/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import DataObjects.Pilot;
import DataObjects.Position;
import DataObjects.Sailplane;
import DataObjects.Profile;
import ParameterSelection.Capability;
import ParameterSelection.Preference;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * This class provides the methods that allow a user to add and retrieve Pilots,
 * Sailplanes and Airfields from the database as well as update and delete Pilots
 * 
 * @author Alex Williams
 */
public class DatabaseDataObjectUtilities {
    private static String databaseConnectionName = "jdbc:derby:WinchCommonsTest12DataBase;";
    private static String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String clientDriverName = "org.apache.derby.jdbc.ClientDriver";

    /**
     * Adds the relevant data for a pilot to the database
     * 
     * @param thePilot the pilot to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addPilotToDB(Pilot thePilot) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement pilotInsertStatement = connect.prepareStatement(
                "INSERT INTO Pilot(name, weight, capability, preference,"
                        + " emergency_contact_info, emergency_medical_info)"
                        + "values (?,?,?,?,?,?)");
            pilotInsertStatement.setString(1, thePilot.getFirstName() + " " +
                thePilot.getLastName());
            pilotInsertStatement.setString(2, String.valueOf(thePilot.getWeight()));
            pilotInsertStatement.setString(3, String.valueOf(Capability.convertCapabilityStringToNum(thePilot.getCapability())));
            pilotInsertStatement.setString(4, String.valueOf(Preference.convertPreferenceStringToNum(thePilot.getPreference())));
            pilotInsertStatement.setString(5, thePilot.getEmergencyContact());
            pilotInsertStatement.setString(6, thePilot.getMedInfo());
            pilotInsertStatement.executeUpdate();
            pilotInsertStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Adds the relevant data for a profile to the database
     * 
     * @param theProfile the profile to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addProfileToDB(Profile theProfile) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement profileInsertStatement = connect.prepareStatement(
                "INSERT INTO Profile(id, unitSettings, dislayPrefs)"
                        + "values (?,?,?)");
            profileInsertStatement.setString(1, theProfile.getID());
            profileInsertStatement.setString(5, theProfile.getUnitSettingsForStorage());
            profileInsertStatement.setString(6, theProfile.getDisplayPrefsForStorage());
            profileInsertStatement.executeUpdate();
            profileInsertStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Adds the relevant data for a sailplane to the database
     * 
     * @param theSailplane the sailplane to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addSailplaneToDB(Sailplane theSailplane) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)){
            PreparedStatement pilotInsertStatement = connect.prepareStatement(
                    "INSERT INTO Sailplane(n_number, type, owner, contact_info,"
                            + " max_gross_weight, empty_weight, indicated_stall_speed,"
                            + "max_winching_speed, max_weak_link_strength, max_tension)"
                            + "values (?,?,?,?,?,?,?,?,?,?)");
            pilotInsertStatement.setString(1, theSailplane.getNumber());
            pilotInsertStatement.setString(2, theSailplane.getType());
            pilotInsertStatement.setString(3, theSailplane.getOwner());
            pilotInsertStatement.setString(4, theSailplane.getContactInformation());
            pilotInsertStatement.setString(5, String.valueOf(theSailplane.getMaximumGrossWeight()));
            pilotInsertStatement.setString(6, String.valueOf(theSailplane.getEmptyWeight()));
            pilotInsertStatement.setString(7, String.valueOf(theSailplane.getIndicatedStallSpeed()));
            pilotInsertStatement.setString(8, String.valueOf(theSailplane.getMaximumWinchingSpeed()));
            pilotInsertStatement.setString(9, String.valueOf(theSailplane.getMaximumAllowableWeakLinkStrength()));
            pilotInsertStatement.setString(10, String.valueOf(theSailplane.getMaximumTension()));
            pilotInsertStatement.executeUpdate();
            pilotInsertStatement.close();
        }catch(SQLException e) {
            //System.out.println("Error adding sailplane to database");
            throw e;
        }
    }
    
    /**
     * Pulls the list of pilots (and relevant data) from the database
     * 
     * @return the list of pilots in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<Pilot> getPilots() throws SQLException, ClassNotFoundException {        
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
            ResultSet thePilots = stmt.executeQuery("SELECT name, weight, capability, "
                    + "preference, emergency_contact_info, emergency_medical_info "
                    + "FROM Pilot ORDER BY name");
            List pilots = new ArrayList<Pilot>();
            
            while(thePilots.next()) {
                String pilotName = thePilots.getString(1);
                String[] names = pilotName.split("\\s+");
                int weight = 0; 
                int capability = 1;
                int preference = 1;
                try {
                    weight = Integer.parseInt(thePilots.getString(2));
                    capability = Integer.parseInt(thePilots.getString(3));
                    preference = Integer.parseInt(thePilots.getString(4));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                Pilot newPilot = new Pilot(names[1], names[0], weight , Capability.convertCapabilityNumToString(capability), Preference.convertPreferenceNumToString(preference), thePilots.getString(5), thePilots.getString(6));
                pilots.add(newPilot);
            }
            thePilots.close();
            stmt.close();
            connect.close();
            return pilots;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Sailplanes (and relevant data) from the database
     * 
     * @return the list of sailplanes in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<Sailplane> getSailplanes() throws SQLException, ClassNotFoundException {        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theSailplanes = stmt.executeQuery("SELECT n_number, type, owner,"
                    + "contact_info, max_gross_weight, empty_weight, indicated_stall_speed,"
                    + "max_winching_speed, max_weak_link_strength, max_tension "
                    + "FROM Sailplane ORDER BY n_number");
            List sailplanes = new ArrayList<Sailplane>();
            
            while(theSailplanes.next()) {
                //System.out.println("Getting a sailplane");
                String nNumber = theSailplanes.getString(1);
                String type = theSailplanes.getString(2);
                String owner = theSailplanes.getString(3);
                String contactInfo = theSailplanes.getString(4);
                int maxGrossWeight = 0; 
                int emptyWeight = 0;
                int stallSpeed = 0;
                int maxWinchingSpeed = 0;
                int maxWeakLinkStrength = 0;
                int maxTension = 0;
                try {
                    maxGrossWeight = Integer.parseInt(theSailplanes.getString(5));
                    emptyWeight = Integer.parseInt(theSailplanes.getString(6));
                    stallSpeed = Integer.parseInt(theSailplanes.getString(7));
                    maxWinchingSpeed = Integer.parseInt(theSailplanes.getString(8));
                    maxWeakLinkStrength = Integer.parseInt(theSailplanes.getString(9));
                    maxTension = Integer.parseInt(theSailplanes.getString(10));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                Sailplane newSailplane = new Sailplane(nNumber, type, owner, contactInfo, maxGrossWeight, emptyWeight, stallSpeed, maxWinchingSpeed, maxWeakLinkStrength, maxTension, true);
                sailplanes.add(newSailplane);
                
            }
            theSailplanes.close();
            stmt.close();
            connect.close();
            return sailplanes;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Profiles (and relevant data) from the database
     * 
     * @return the list of profiles in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    
    public static List<Profile> getProfiles() throws SQLException, ClassNotFoundException {        
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
            ResultSet theProfiles = stmt.executeQuery("SELECT id, unitSettings,  "
                    + "displayPrefs "
                    + "FROM Profile ORDER BY id");
            List profiles = new ArrayList<Profile>();
            
            while(theProfiles.next()) {
                String profileName = theProfiles.getString(1);
                String[] names = profileName.split("\\s+"); 
                String unitSettings = theProfiles.getString(2);
                String displayPrefs = theProfiles.getString(3);
                Profile newProfile = new Profile(profileName, unitSettings, displayPrefs);
                profiles.add(newProfile);
            }
            theProfiles.close();
            stmt.close();
            connect.close();
            return profiles;
        } catch (SQLException e) {
            throw e;
        }
    }    
    
    /**
     * Update the data for a given pilot in the database
     * 
     * @param pilot the pilot to update the data for
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     * @throws SQLException if the table in the database can't be accessed
     */
    public static void updatePilotEntry(Pilot pilot) throws ClassNotFoundException, SQLException {
         try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            PreparedStatement pilotEditStatement= connect.prepareStatement("UPDATE Pilot "
                                        + "SET weight = ?, "
                                        + " capability = ?, "
                                        + " preference = ?,"
                                        + " emergency_contact_info = ?, "
                                        + " emergency_medical_info = ? "
                                        + "WHERE name = ?");
            pilotEditStatement.setString(1, String.valueOf(pilot.getWeight()));
            pilotEditStatement.setString(2, String.valueOf(Capability.convertCapabilityStringToNum(pilot.getCapability())));
            pilotEditStatement.setString(3, String.valueOf(Preference.convertPreferenceStringToNum(pilot.getPreference())));
            pilotEditStatement.setString(4, pilot.getEmergencyContact());
            pilotEditStatement.setString(5, pilot.getMedInfo());
            pilotEditStatement.setString(6, pilot.getFirstName() + " " + pilot.getLastName());
            pilotEditStatement.executeUpdate();
            pilotEditStatement.close();
            connect.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Delete the data for a given pilot from the database
     * 
     * @param pilot the pilot to delete from the database
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     * @throws SQLException if the table in the database can't be accessed
     */
    public static void deletePilot(Pilot pilot) throws ClassNotFoundException {
       try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            PreparedStatement pilotEditStatement= connect.prepareStatement("DELETE FROM Pilot "
                    + "WHERE name = ?");   
            pilotEditStatement.setString(1, pilot.getFirstName() + " " + pilot.getLastName());
            pilotEditStatement.executeUpdate();
            pilotEditStatement.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Check to see that Pilot table exists
     * 
     * @param dbConnection the connection to the database
     * @return true if Pilot table exists
     * @return false if Pilot table doesn't exist
     * @throws SQLException 
     */
    public static boolean checkForTable(Connection dbConnection) throws SQLException {
        try {
            Statement s = dbConnection.createStatement();
            s.execute("UPDATE Pilot SET name = 'A Name', Weight = '000', capability='1', preference='1', emergency_contact_info='None', emergency_medical_info = 'None' where 1=3"); 
        }catch(SQLException sqle) {
            String theError = (sqle).getSQLState();
            if (theError.equals("42X05"))
                return false;
            else if(theError.equals("42X14") || theError.equals("42821")){
                //TODO find a good way to camcle and rerun init program
                throw sqle;
            }
            else
                throw sqle;
        }
        return true;            
    }

    public static List<Position> getPositions() {
        List positions = new ArrayList<Position>();
        return positions;
    }
}
