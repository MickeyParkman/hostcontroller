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
 * @author nfujioka
 */
public class DatabaseEntryIdCheck {
    private static boolean IdCheck(String idCheckString) throws ClassNotFoundException, SQLException
    {
        String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
        String clientDriverName = "org.apache.derby.jdbc.ClientDriver";
        String databaseConnectionName = "jdbc:derby:WinchCommonsTest12DataBase;create=true";
        PreparedStatement stmt = null;
        Connection connection = null;
        boolean result = false;
        
        //Check for DB drivers
        try {
            Class.forName(clientDriverName);
            Class.forName(driverName);
        }catch(java.lang.ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Can't load JavaDB ClientDriver");
            throw e;
        }
        
        //Try to connect
        try {
            connection = DriverManager.getConnection(databaseConnectionName);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Loaded JavaDB ClientDriver, something else wrong");
            throw e;
        }
        
        //Update the value given
        try {
            stmt = connection.prepareStatement(idCheckString);;
            ResultSet theIds = stmt.executeQuery();
            result = theIds.next();
            stmt.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error executing");
            throw e;
        }finally
        { 
        }
        return result;
    }
    
    public static boolean IdCheck(Pilot pilot) throws Exception
    {
        String idCheckString;
        idCheckString = "SELECT * FROM PILOT WHERE pilot_id = '" + pilot.getPilotId() + "'";
        
        return IdCheck(idCheckString);
    }
    
    public static boolean IdCheck(Sailplane sailplane) throws Exception
    {
        String idCheckString;
        idCheckString = "SELECT * FROM GLIDER WHERE glider_id = '" + sailplane.getId() + "'";
        
        return IdCheck(idCheckString);
    }
    
    public static boolean IdCheck(Airfield airfield) throws Exception
    {
        String idCheckString;
        idCheckString = "SELECT * FROM AIRFIELD WHERE airfield_id = '" + airfield.getId() + "'";
        
        return IdCheck(idCheckString);
    }
    
    public static boolean IdCheck(Runway runway) throws Exception
    {
        String idCheckString;
        idCheckString = "SELECT * FROM RUNWAY WHERE runway_id = '" + runway.getId() + "' "
                + "AND parent_id = '" + runway.getParentId() + "'";
        
        return IdCheck(idCheckString);
    }
    
    public static boolean IdCheck(GliderPosition position) throws Exception
    {
        String idCheckString;
        idCheckString = "SELECT * FROM GLIDERPOSITION WHERE glider_position_id = '" + position.getId() + "' "
                + "AND runway_parent_id = '" + position.getRunwayParentId() + "' "
                + "AND airfield_parent_id = '" + position.getAirfieldParentId() + "'";
        
        return IdCheck(idCheckString);
    }
    
    public static boolean IdCheck(WinchPosition position) throws Exception
    {
        String idCheckString;
        idCheckString = "SELECT * FROM WINCHPOSITION WHERE winch_position_id = '" + position.getId() + "' "
                + "AND runway_parent_id = '" + position.getRunwayParentId() + "' "
                + "AND airfield_parent_id = '" + position.getAirfieldParentId() + "'";
        
        return IdCheck(idCheckString);
    }
    
    public static boolean IdCheck(Parachute parachute) throws Exception
    {
        String idCheckString;
        idCheckString = "SELECT * FROM PARACHUTE WHERE parachute_id = '" + parachute.getParachuteNumber() + "'";
        
        return IdCheck(idCheckString);
    }
    
    public static boolean uniqueCheck(Sailplane plane) throws Exception{
        String idCheckString;
        idCheckString = "SELECT * FROM GLIDER WHERE reg_number = '" + plane.getRegistration() + "'";
        
        return IdCheck(idCheckString);    
    }
    
    public static boolean uniqueCheck(Airfield field) throws Exception {
        String idCheckString;
        idCheckString = "SELECT * FROM AIRFIELD WHERE designator = '" + field.getDesignator() + "'";
        
        return IdCheck(idCheckString);    
    }
    
}

