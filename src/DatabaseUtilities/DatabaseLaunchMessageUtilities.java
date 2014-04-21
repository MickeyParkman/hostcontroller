/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import Communications.InternalMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class DatabaseLaunchMessageUtilities {
    private static final String databaseConnectionName = "jdbc:derby:WinchCommonsTest12DataBase;";
    private static final String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String clientDriverName = "org.apache.derby.jdbc.ClientDriver";
    
    public static List<PreviousLaunch> getPreviousLaunches() throws ClassNotFoundException, SQLException {
        ArrayList<PreviousLaunch> previousLaunches = new ArrayList<PreviousLaunch>();        
                
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theLaunches = stmt.executeQuery("SELECT timestamp, pilot, sailplane "
                    + "FROM PreviousLaunches ORDER BY timestamp");
            
            while(theLaunches.next()) {
                long timestamp = 0L;
                try {
                    Long.parseLong(theLaunches.getString(1));
                } catch(NumberFormatException e) {
                    
                }
                
                String pilotName = theLaunches.getString(2);
                String nNumber = theLaunches.getString(3);
                PreviousLaunch launch = new PreviousLaunch(timestamp, pilotName, nNumber);
                previousLaunches.add(launch);
            }
            theLaunches.close();
            stmt.close();
            connect.close();
            return previousLaunches;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static List<InternalMessage> getMessagesForLaunch(PreviousLaunch launch) {
       ArrayList<InternalMessage> messages = new ArrayList<InternalMessage>(); 
       
       
       
       
       return messages;
    }
    
}
