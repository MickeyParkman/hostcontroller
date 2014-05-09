/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communications;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simulates a connection by firing off dummy messages every 1/64th of a second
 * to trigger reads from a file in the Filter
 *
 * @author Alex
 */
public class FileDummyConnection implements Connection {
    private ArrayList<FilterListener> filters = new ArrayList<FilterListener>();
    Thread t;
    boolean isRunning = true;

    public FileDummyConnection() {
        t = new Thread(new DummyMessageGenerator());
        
    }
    
    @Override
    public void attachFilter(FilterListener newFilter) {
        filters.add(newFilter);
    }

    @Override
    public void notify(byte[] msg) {
        for(FilterListener listener : filters) {
            listener.msgAvailable(msg);
        }
    }
    
    private void update(String str) {
        notify(str.getBytes());
    }
    
    /**
     * Starts up a thread with a dummy message generator 
     */
    public void start() {
        isRunning = true;
        t = new Thread(new DummyMessageGenerator());
        t.start();
    }
    
    /**
     * Sets the boolean run condition to false to stop the thread from running
     */
    public void stop() {
        isRunning = false;
    }
    
    /**
     * Threaded class for firing off messages every 1/64th of a second
     */
    private class DummyMessageGenerator implements Runnable {
        String dummyString = "Dummy";
        

        @Override
        public void run() {
           while(isRunning) {
               try {
                   TimeUnit.MICROSECONDS.sleep(15625L);
                   update(dummyString);
               } catch (InterruptedException ex) {
                   Logger.getLogger(FileDummyConnection.class.getName()).log(Level.SEVERE, null, ex);
               }
           } 
        }    
    }
    
}
