package Communications;

import Communications.Observer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessagePipeline {
    
    private ArrayList<Observer> observers;
    private Socket socket;
    private BufferedReader reader;
    private OutputStreamWriter writer;
    private String currentMessage = "";
    private static MessagePipeline instance = null;
    
    public static MessagePipeline getInstance()
    {
        if(instance == null)
        {
            instance = new MessagePipeline();
            instance.observers = new ArrayList<Observer>();
        }
        return instance;
    }
    
    public void init()
    {
        try {
            socket = new Socket("147.222.165.75", 32123);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new OutputStreamWriter(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void attach(Observer ob)
    {
        observers.add(ob);
    }
    
    private void notifyObservers()
    {
        for(Observer ob : observers)
        {
            ob.update(currentMessage);
        }
    }
    
    public void TEMPReadFromSocket()
    {
        try {
            String s = reader.readLine();
            currentMessage = s;
            if(!s.equals(""))
            {
                notifyObservers();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void TEMPWriteToSocket(String s)
    {
        try {
            writer.write(s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
