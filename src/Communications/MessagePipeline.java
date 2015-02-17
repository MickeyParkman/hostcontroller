package Communications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessagePipeline extends Thread {
    
    private ArrayList<Observer> observers;
    private Socket socket;
    private BufferedReader reader;
    private OutputStreamWriter writer;
    private String currentMessage = "";
    private static MessagePipeline instance = null;
    private boolean running = false;
    private String DEBUGMessageList[] = {"100 100 100 65"
                                        ,"80 200 100 50"
                                        ,"100 100 500 100"
                                        ,"150 100 20 45"
                                        ,"100 30 46 100"
                                        ,"34 30 46 100"
                                        ,"67 56 46 500"
                                        ,"100 30 46 40"
                                        ,"776 30 46 56"
                                        ,"7 78 46 58"};
    private int curMessageIndex = 0;
    
    public static MessagePipeline getInstance()
    {
        if(instance == null)
        {
            instance = new MessagePipeline();
            instance.observers = new ArrayList<>();
            instance.init();
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
        currentMessage = DEBUGMessageList[curMessageIndex];
        ++curMessageIndex;
        curMessageIndex%=10;
        /*try {
            String s = reader.readLine();
            currentMessage = s;
            if(!s.equals(""))
            {
                notifyObservers();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }
    
    public void TEMPWriteToSocket(String s)
    {
        try {
            writer.write(s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void run()
    {
        running = true;
        while(running)
        {
            long startTime = System.currentTimeMillis();
            long elapsed = 0;
            while(elapsed < 100) {
                TEMPReadFromSocket();
                long endTime = System.currentTimeMillis();
                elapsed = endTime - startTime;
            }
            notifyObservers();
        }
    }
    
    public void close()
    {
        running = false;
        try {
            socket.close();
            writer.close();
            reader.close();
        } catch (IOException ex) {
        }
    }
}
