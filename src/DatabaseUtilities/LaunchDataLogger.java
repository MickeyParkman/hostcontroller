/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import Communications.InternalMessage;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class LaunchDataLogger {
    ArrayList<InternalMessage> launchMessages = new ArrayList<InternalMessage>();
    InternalLogger messageLogger;
    
    public LaunchDataLogger() {
        messageLogger = new InternalLogger();
        Thread loggingThread = new Thread(messageLogger);
        loggingThread.start();
    }
    
    public void logDisplayMessage(InternalMessage message) {
        launchMessages.add(message);
        synchronized(messageLogger) {
            messageLogger.run();
        }
    }
    
    private class InternalLogger implements Runnable {

        @Override
        public void run() {
            
        }
        
    }
    
}
