/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chris
 */
public class BlackBoxLogger {
    private long currenttimestamp;
    private LinkedList<String> messages = new LinkedList<String>();
    private InternalLogger logger;
    private Thread loggingThread;
    
    private Connection connection;
    
    private static String databaseConnectionName = "jdbc:derby:WinchCommonsTest12DataBase;";
    private static String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String clientDriverName = "org.apache.derby.jdbc.ClientDriver";
    
    public BlackBoxLogger() {
        currenttimestamp = 0L;
        logger = new InternalLogger();
        loggingThread = new Thread(logger);
        loggingThread.start();

        //TODO Connect to Database
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
            connection = DriverManager.getConnection(databaseConnectionName);
        }catch(java.lang.ClassNotFoundException e) {
            Logger.getLogger(BlackBoxLogger.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(BlackBoxLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loggMessage(String message) {
        messages.add(message);
        synchronized(logger){
            logger.run();
        }
    }
    
    public void loggMessage(long timeStamp, String message) {
        currenttimestamp = timeStamp;
        messages.add(message);
        synchronized(logger){
            logger.run();
        }
    }
    
    private class InternalLogger implements Runnable {
        @Override
        public void run() {
            //try {
                if(!messages.isEmpty() && connection != null) {
                    try {
                        PreparedStatement messageInsertStatement = connection.prepareStatement(
                                "INSERT INTO BlackBoxMessages(timestamp, message)"
                                    + "values (?,?)");
                        messageInsertStatement.setString(1, String.valueOf(currenttimestamp));
                        messageInsertStatement.setString(2, messages.remove(0));
                        messageInsertStatement.executeUpdate();
                        messageInsertStatement.close();
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                        Logger.getLogger(BlackBoxLogger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(messages.get(0));
                }
                //wait();
            //} catch (InterruptedException ex) {
            //    Logger.getLogger(BlackBoxLogger.class.getName()).log(Level.SEVERE, null, ex);
            //}
        }
    }
}
