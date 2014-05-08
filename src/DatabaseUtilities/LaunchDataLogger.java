/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import Communications.InternalMessage;
import java.util.ArrayList;

/**
 * Provides the means to log Launch messages in the database in a separate thread
 * 
 * @author Alex Williams
 */
public class LaunchDataLogger {
    //Buffer for incoming messages 
    ArrayList<InternalMessage> launchMessages = new ArrayList<InternalMessage>();
    //Threaded logging mechanism
    InternalLogger messageLogger;
    
    public LaunchDataLogger() {
        messageLogger = new InternalLogger();
        Thread loggingThread = new Thread(messageLogger);
        loggingThread.start();
    }
    
    /**
     * Method for calling the object to log a message
     * @param message the message to be logged
     */
    public void logDisplayMessage(InternalMessage message) {
        launchMessages.add(message);
        synchronized(messageLogger) {
            messageLogger.run();
        }
    }
    
    /**
     * Private class that implements the threaded logging of Launch messages
     */
    private class InternalLogger implements Runnable {

        @Override
        public void run() {
            
        }
        
    }
    
}
