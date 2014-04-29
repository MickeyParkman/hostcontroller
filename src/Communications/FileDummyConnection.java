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
 *
 * @author Alex
 */
public class FileDummyConnection implements Connection {
    private ArrayList<FilterListener> filters = new ArrayList<FilterListener>();

    public FileDummyConnection() {
        Thread t = new Thread(new DummyMessageGenerator());
        t.start();
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
    
    private class DummyMessageGenerator implements Runnable {
        String dummyString = "Dummy";

        @Override
        public void run() {
           while(true) {
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
