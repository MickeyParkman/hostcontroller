/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author awilliams5
 */
public class SocketConnection implements Connection{
    private ArrayList<FilterListener> filters = new ArrayList<FilterListener>();
    private String ipAddress = "192.168.1.80";
    private Socket socket;
    private BufferedReader in;
    OutputStreamWriter out;
    
    public SocketConnection() {
        initSocket();
        SocketDataListener listen = new SocketDataListener();
        Thread t = new Thread(listen);
        t.start();
    }
    
    private void initSocket() {
        try {
            socket = new Socket(ipAddress, 32124);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new OutputStreamWriter(socket.getOutputStream());
        } catch (IOException ex) {
                System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public void attachFilter(FilterListener newFilter) {
        filters.add(newFilter);
    }
    
    @Override
    public void notify(byte[] msg) {
        for(FilterListener filter : filters) {
            filter.msgAvailable(msg);
        }
    }
    
    private void updateListeners(String s) {
            notify(s.getBytes());
    }
    
    private class SocketDataListener implements Runnable {

        @Override
        public void run() {
           while(true) {
               try {
                   String message = in.readLine();
                   updateListeners(message);
               } catch (IOException ex) {
                   Logger.getLogger(SocketConnection.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           } 
        }    
    }
}
