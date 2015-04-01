/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseUtilities;

import java.sql.*;
import javax.swing.JOptionPane;

import DataObjects.*;

/**
 *
 * @author dbennett3
 */
public class DatabaseEntryDelete {
    
    private static void Delete(String deleteString) throws ClassNotFoundException, SQLException
    {
        String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
        String clientDriverName = "org.apache.derby.jdbc.ClientDriver";
        String databaseConnectionName = "jdbc:derby:WinchCommonsTest12DataBase;create=true";
        PreparedStatement ps = null;
        Connection connection = null;
        
        //Check for DB drivers
        try {
            Class.forName(clientDriverName);
            Class.forName(driverName);
        }catch(java.lang.ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Can't load JavaDB ClientDriver", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw e;
        }
        
        //Try to connect
        try {
            connection = DriverManager.getConnection(databaseConnectionName);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Loaded JavaDB ClientDriver, something else wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw e;
        }
        
        //Update the value given
        try {
            ps = connection.prepareStatement(deleteString);
            ps.execute();
            ps.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error executing", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw e;
        }finally
        { 
        }
    }
    
    public static void DeleteEntry(Pilot pilot) throws Exception
    {
        String deleteString;
        deleteString = "DELETE FROM PILOT WHERE pilot_id = '" + pilot.getPilotId() + "'";
        
        Delete(deleteString);
    }
    
    public static void DeleteEntry(Sailplane sailplane) throws Exception
    {
        String deleteString;
        deleteString = "DELETE FROM SAILPLANE WHERE n_number = '" + sailplane.getNumber() + "'";
        
        Delete(deleteString);
    }
    
    public static void DeleteEntry(Airfield airfield) throws Exception
    {
        String deleteString;
        deleteString = "DELETE FROM AIRFIELD WHERE name = '" + airfield.getName() + "'";
        
        Delete(deleteString);
    }
    
    public static void DeleteEntry(Runway runway) throws Exception
    {
        String deleteString;
        deleteString = "DELETE FROM RUNWAY WHERE runway_id = '" + runway.getId() + "'";
        
        Delete(deleteString);
    }
    
    public static void DeleteEntry(GliderPosition position) throws Exception
    {
        String deleteString;
        deleteString = "DELETE FROM GLIDERPOSITION WHERE position_id = '" + position.getGliderPositionId() + "'";
        
        Delete(deleteString);
    }
    
    public static void DeleteEntry(WinchPosition position) throws Exception
    {
        String deleteString;
        deleteString = "DELETE FROM WINCHPOSITION WHERE name = '" + position.getName() + "'";
        
        Delete(deleteString);
    }
    
    public static void DeleteEntry(Parachute parachute) throws Exception
    {
        String deleteString;
        deleteString = "DELETE FROM PARACHUTE WHERE parachute_id = '" + parachute.getParachuteNumber() + "'";
        
        Delete(deleteString);
    }
    
}
