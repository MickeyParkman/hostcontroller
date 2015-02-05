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
public class DatabaseEntryEdit 
{
    
    /**
     * performs the update string created in the functions below
     * 
     * @param updateString update sql string to be executed
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    private static void Update(String updateString) throws ClassNotFoundException, SQLException
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
            ps = connection.prepareStatement(updateString);
            ps.execute();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error executing");
            throw e;
        }finally
        {
            ps.close();
        }
    }
    
    
    /**
     * updates the pilot table in the database with the new pilot data in the object passed in
     * 
     * @param pilot pilot object that is to be updated
     * @throws Exception 
     */
    public static void UpdateEntry(Pilot pilot) throws Exception
    {
        String updateString;
        updateString = "UPDATE PILOT SET "
                + "first_name = " + pilot.getFirstName()
                + "middle_name = " + pilot.getMiddleName()
                + "last_name = " + pilot.getLastName()
                + "flight_weight = " + String.valueOf(pilot.getWeight())
                + "capability = " + pilot.getCapability()
                + "preference = " + pilot.getPreference()
                + "emergency_contact_info = " + pilot.getEmergencyContact()
                + "emergency_medical_info = " + pilot.getMedInfo()
                + "optional_info = " + pilot.getOptionalInfo()
                + "WHERE pilot_id = " + pilot.getPilotId();
        
        Update(updateString);
    }
    
    /**
     * updates the sailplane table in the database with the new sailplane data in the object passed in
     * 
     * @param sailplane sailplane object that is to be updated
     * @throws Exception 
     */
    public static void UpdateEntry(Sailplane sailplane) throws Exception
    {
        String updateString;
        updateString = "UPDATE SAILPLANE SET "
                + "type = " + sailplane.getType()
                + "max_gross_weight = " + String.valueOf(sailplane.getMaxGrossWeight())
                + "empty_weight = " + String.valueOf(sailplane.getEmptyWeight())
                + "indicated_stall_speed = " + String.valueOf(sailplane.getIndicatedStallSpeed())
                + "max_winching_speed = " + String.valueOf(sailplane.getMaxWinchingSpeed())
                + "max_tension = " + String.valueOf(sailplane.getMaxTension())
                + "cable_release_angle = " + String.valueOf(sailplane.getCableReleaseAngle())
                + "carry_ballast = " + String.valueOf(sailplane.storeCarryBallast())
                + "optional_info = " + sailplane.getOptionalInfo()
                + "WHERE n_number = " + sailplane.getNumber();
        
        Update(updateString);
    }
    
    /**
     * updates the airfield table in the database with the new airfield data in the object passed in
     * 
     * @param airfield airfield object that is to be updated
     * @throws Exception 
     */
    public static void UpdateEntry(Airfield airfield) throws Exception
    {
        String updateString;
        updateString = "UPDATE ARIFIELD SET "
                + "designator = " + airfield.getDesignator()
                + "altitude = " + String.valueOf(airfield.getAltitude())
                + "magneticVariation = " + String.valueOf(airfield.getMagneticVariation())
                + "latitude = " + String.valueOf(airfield.getLatitude())
                + "longitude = " + String.valueOf(airfield.getLongitude())
                + "optional_info = " + airfield.getOptionalInfo()
                + "WHERE name = " + airfield.getName();
        
        Update(updateString);
    }
    
    /**
     * updates the runway table in the database with the new runway data in the object passed in
     * 
     * @param runway runway object that is to be updated
     * @throws Exception 
     */
    public static void UpdateEntry(Runway runway) throws Exception
    {
        String updateString;
        updateString = "UPDATE RUNWAY SET "
                + "magnetic_heading = " + runway.getMagneticHeading()
                + "parent = " + runway.getParent()
                + "altitude = " + String.valueOf(runway.getAltitude())
                + "optional_info = " + runway.getOptionalInfo()
                + "WHERE runway_id = " + runway.getId();
        
        Update(updateString);
    }
    
    /**
     * updates the GliderPosition table in the database with the new position data in the object passed in
     * 
     * @param position GliderPosition object that is to be updated
     * @throws Exception 
     */
    public static void UpdateEntry(GliderPosition position) throws Exception
    {
        String updateString;
        updateString = "UPDATE GLIDERPOSITION SET "
                + "runway_parent = " + position.getParent()
                + "altitude = " + String.valueOf(position.getAltitude())
                + "latitude = " + String.valueOf(position.getLatitude())
                + "longitude = " + String.valueOf(position.getLongitude())
                + "optional_info = " + position.getOptionalInfo()
                + "WHERE position_id = " + position.getGliderPositionId();
        
        Update(updateString);
    }
    
    /**
     * updates the WinchPosition table in the database with the new position data in the object passed in
     * 
     * @param position WinchPosition object that is to be updated
     * @throws Exception 
     */
    public static void UpdateEntry(WinchPosition position) throws Exception
    {
        String updateString;
        updateString = "UPDATE GLIDERPOSITION SET "
                + "runway_parent = " + position.getParent()
                + "altitude = " + String.valueOf(position.getAltitude())
                + "latitude = " + String.valueOf(position.getLatitude())
                + "longitude = " + String.valueOf(position.getLongitude())
                + "optional_info = " + position.getOptionalInfo()
                + "WHERE name = " + position.getName();
        
        Update(updateString);
    }
    
    /**
     * updates the parachute in the database with the new parachute data in the object passed in
     * 
     * @param parachute parachute object that is to be updated
     * @throws Exception 
     */
    public static void UpdateEntry(Parachute parachute) throws Exception
    {
        String updateString;
        updateString = "UPDATE PARACHUTE SET "
                + "lift = " + String.valueOf(parachute.getLift())
                + "drag = " + String.valueOf(parachute.getDrag())
                + "weight = " + String.valueOf(parachute.getWeight())
                + "WHERE parachute_id = " + parachute.getParachuteNumber();
        
        Update(updateString);
    }
    
    
    
}
