/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import DataObjects.Pilot;
import DataObjects.Sailplane;
import DataObjects.Airfield;
import DataObjects.Runway;
import DataObjects.GliderPosition;
import DataObjects.Winch;
import DataObjects.DrumParameters;
import DataObjects.Drum;
import DataObjects.Parachute;
import DataObjects.WinchPosition;
import DataObjects.Profile;
import DataObjects.FlightSummary;
import DataObjects.CurrentDataObjectSet;
import DataObjects.CurrentLaunchInformation;
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
 * @author Alex Williams, Noah Fujioka, dbennett3
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
                "INSERT INTO Pilot(pilot_id, first_name, last_name, middle_name, flight_weight, capability, preference,"
                        + " emergency_contact_info, emergency_medical_info, optional_info)"
                        + "values (?,?,?,?,?,?,?,?,?,?)");
            pilotInsertStatement.setString(1, thePilot.getPilotId());
            pilotInsertStatement.setString(2, thePilot.getFirstName());
            pilotInsertStatement.setString(3, thePilot.getLastName());
            pilotInsertStatement.setString(4, thePilot.getMiddleName());
            pilotInsertStatement.setString(5, String.valueOf(thePilot.getWeight()));
            pilotInsertStatement.setString(6, String.valueOf(Capability.convertCapabilityStringToNum(thePilot.getCapability())));
            pilotInsertStatement.setString(7, String.valueOf(Preference.convertPreferenceStringToNum(thePilot.getPreference())));
            pilotInsertStatement.setString(8, thePilot.getEmergencyContact());
            pilotInsertStatement.setString(9, thePilot.getMedInfo());
            pilotInsertStatement.setString(10, thePilot.getOptionalInfo());
            pilotInsertStatement.executeUpdate();
            pilotInsertStatement.close();
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
            PreparedStatement sailplaneInsertStatement = connect.prepareStatement(
                    "INSERT INTO Glider(glider_id, n_number, type, "
                            + "max_gross_weight, empty_weight, indicated_stall_speed, "
                            + "max_winching_speed, max_weak_link_strength, max_tension, "
                            + "cable_release_angle, carry_ballast, multiple_seats, "
                            + "optional_info)"
                            + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sailplaneInsertStatement.setString(1, theSailplane.getId());
            sailplaneInsertStatement.setString(2, theSailplane.getNumber());
            sailplaneInsertStatement.setString(3, theSailplane.getType());
            sailplaneInsertStatement.setString(4, String.valueOf(theSailplane.getMaxGrossWeight()));
            sailplaneInsertStatement.setString(5, String.valueOf(theSailplane.getEmptyWeight()));
            sailplaneInsertStatement.setString(6, String.valueOf(theSailplane.getIndicatedStallSpeed()));
            sailplaneInsertStatement.setString(7, String.valueOf(theSailplane.getMaxWinchingSpeed()));
            sailplaneInsertStatement.setString(8, String.valueOf(theSailplane.getMaxWeakLinkStrength()));
            sailplaneInsertStatement.setString(9, String.valueOf(theSailplane.getMaxTension()));
            sailplaneInsertStatement.setString(10, String.valueOf(theSailplane.getCableReleaseAngle()));
            sailplaneInsertStatement.setString(11, String.valueOf(theSailplane.storeCarryBallast()));
            sailplaneInsertStatement.setString(12, String.valueOf(theSailplane.storeMultipleSeats()));
            sailplaneInsertStatement.setString(13, theSailplane.getOptionalInfo());
            sailplaneInsertStatement.executeUpdate();
            sailplaneInsertStatement.close();
        }catch(SQLException e) {
            //System.out.println("Error adding sailplane to database");
            throw e;
        }
    }
    
    public static void addWinchToDB(Winch theWinch) throws SQLException, ClassNotFoundException 
    {

    }
    
    /**
     * Adds the relevant data for an airfield to the database
     * 
     * @param theAirfield the airfield to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addAirfieldToDB(Airfield theAirfield) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement AirfieldInsertStatement = connect.prepareStatement(
                "INSERT INTO Airfield(airfield_id, name, designator, altitude, "
                + "magnetic_variation, latitude, longitude, optional_info) "
                + "values (?,?,?,?,?,?,?,?)");
            AirfieldInsertStatement.setString(1, theAirfield.getId());
            AirfieldInsertStatement.setString(2, theAirfield.getName());
            AirfieldInsertStatement.setString(3, theAirfield.getDesignator());
            AirfieldInsertStatement.setString(4, String.valueOf(theAirfield.getAltitude()));
            AirfieldInsertStatement.setString(5, String.valueOf(theAirfield.getMagneticVariation()));
            AirfieldInsertStatement.setString(6, String.valueOf(theAirfield.getLatitude()));
            AirfieldInsertStatement.setString(7, String.valueOf(theAirfield.getLongitude()));
            AirfieldInsertStatement.setString(8, theAirfield.getOptionalInfo());
            AirfieldInsertStatement.executeUpdate();
            AirfieldInsertStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Adds the relevant data for a runway to the database
     * 
     * @param theRunway the runway to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addRunwayToDB(Runway theRunway) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement RunwayInsertStatement = connect.prepareStatement(
                "INSERT INTO Runway(runway_id, runway_name, magnetic_heading, parent, parent_id, altitude, optional_info) "
                        + "values (?,?,?,?,?,?,?)");
            RunwayInsertStatement.setString(1, theRunway.getId());
            RunwayInsertStatement.setString(2, theRunway.getName());
            RunwayInsertStatement.setString(3, String.valueOf(theRunway.getMagneticHeading()));
            RunwayInsertStatement.setString(4, theRunway.getParent());
            RunwayInsertStatement.setString(5, theRunway.getParentId());
            RunwayInsertStatement.setString(6, String.valueOf(theRunway.getAltitude()));
            RunwayInsertStatement.setString(7, theRunway.getOptionalInfo());
            RunwayInsertStatement.executeUpdate();
            RunwayInsertStatement.close();
        }catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * Adds the relevant data for a glider position to the database
     * 
     * @param theGliderPosition the runway to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addGliderPositionToDB(GliderPosition theGliderPosition) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement GliderPositionInsertStatement = connect.prepareStatement(
                "INSERT INTO GliderPosition(glider_position_id, position_id, runway_parent, runway_parent_id, airfield_parent, airfield_parent_id, altitude, latitude, longitude, optional_info) "
                        + "values (?,?,?,?,?,?,?,?,?,?)");
            GliderPositionInsertStatement.setString(1, theGliderPosition.getId());
            GliderPositionInsertStatement.setString(2, theGliderPosition.getGliderPositionId());
            GliderPositionInsertStatement.setString(3, theGliderPosition.getRunwayParent());
            GliderPositionInsertStatement.setString(4, theGliderPosition.getRunwayParentId());
            GliderPositionInsertStatement.setString(5, theGliderPosition.getAirfieldParent());
            GliderPositionInsertStatement.setString(6, theGliderPosition.getAirfieldParentId());
            GliderPositionInsertStatement.setString(7, String.valueOf(theGliderPosition.getAltitude()));
            GliderPositionInsertStatement.setString(8, String.valueOf(theGliderPosition.getLatitude()));
            GliderPositionInsertStatement.setString(9, String.valueOf(theGliderPosition.getLongitude()));
            GliderPositionInsertStatement.setString(10, theGliderPosition.getOptionalInfo());
            GliderPositionInsertStatement.executeUpdate();
            GliderPositionInsertStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Adds the relevant data for a winch position to the database
     * 
     * @param theWinchPosition the runway to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addWinchPositionToDB(WinchPosition theWinchPosition) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement WinchPositionInsertStatement = connect.prepareStatement(
                "INSERT INTO WinchPosition(winch_position_id, name, runway_parent, runway_parent_id, airfield_parent, airfield_parent_id, altitude, latitude, longitude, optional_info) "
                        + "values (?,?,?,?,?,?,?,?,?,?)");
            WinchPositionInsertStatement.setString(1, theWinchPosition.getId());
            WinchPositionInsertStatement.setString(2, theWinchPosition.getName());
            WinchPositionInsertStatement.setString(3, theWinchPosition.getRunwayParent());
            WinchPositionInsertStatement.setString(4, theWinchPosition.getRunwayParentId());
            WinchPositionInsertStatement.setString(5, theWinchPosition.getAirfieldParent());
            WinchPositionInsertStatement.setString(6, theWinchPosition.getAirfieldParentId());
            WinchPositionInsertStatement.setString(7, String.valueOf(theWinchPosition.getAltitude()));
            WinchPositionInsertStatement.setString(8, String.valueOf(theWinchPosition.getLatitude()));
            WinchPositionInsertStatement.setString(9, String.valueOf(theWinchPosition.getLongitude()));
            WinchPositionInsertStatement.setString(10, theWinchPosition.getOptionalInfo());
            WinchPositionInsertStatement.executeUpdate();
            WinchPositionInsertStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Adds the relevant data for a parachute to the database
     * 
     * @param theParachute the runway to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addParachuteToDB(Parachute theParachute) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement ParachuteInsertStatement = connect.prepareStatement(
                "INSERT INTO Parachute(parachute_id, lift, drag, weight) "
                        + "values (?,?,?,?)");
            ParachuteInsertStatement.setString(1, String.valueOf(theParachute.getParachuteNumber()));
            ParachuteInsertStatement.setString(2, String.valueOf(theParachute.getLift()));
            ParachuteInsertStatement.setString(3, String.valueOf(theParachute.getDrag()));
            ParachuteInsertStatement.setString(4, String.valueOf(theParachute.getWeight()));
            ParachuteInsertStatement.executeUpdate();
            ParachuteInsertStatement.close();
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
            PreparedStatement ProfileInsertStatement = connect.prepareStatement(
                "INSERT INTO Profile(id, unitSettings, displayPrefs)"
                        + "values (?,?,?)");
            ProfileInsertStatement.setString(1, theProfile.getID());
            ProfileInsertStatement.setString(2, theProfile.getUnitSettingsForStorage());
            ProfileInsertStatement.setString(3, theProfile.getDisplayPrefsForStorage());
            ProfileInsertStatement.executeUpdate();
            ProfileInsertStatement.close();
            //System.out.println(theProfile.getID() + ": " + theProfile.getUnitSettingsForStorage());
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Adds the relevant data for a Launch to the database based on the current loaded information
     * 
     * @param startTime the start of the launch
     * @param endTime the end of the launch
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addLaunchToDB(double startTime, double endTime) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement PreviousLaunchesInfoInsertStatement = connect.prepareStatement(
                "INSERT INTO PreviousLaunchesInfo("
                        + "start_timestamp, "
                        + "end_timestamp, "
                        + "profile_id, "
                        + "unit_settings, "
                        + "display_prefs, "
                        + "pilot_id, "
                        + "pilot_first_name, "
                        + "pilot_last_name, "
                        + "pilot_middle_name, "
                        + "pilot_flight_weight, "
                        + "pilot_capability, "
                        + "pilot_preference, "
                        + "pilot_emergency_contact_info, "
                        + "pilot_emergency_medical_info, "
                        + "pilot_optional_info, "
                        + "glider_id, "
                        + "glider_n_number,"
                        + "glider_type,"
                        + "glider_max_gross_weight,"
                        + "glider_empty_weight,"
                        + "glider_indicated_stall_speed,"
                        + "glider_max_winching_speed,"
                        + "glider_max_weak_link_strength,"
                        + "glider_max_tension,"
                        + "glider_cable_release_angle, "
                        + "glider_carry_ballast, "
                        + "glider_multiple_seats, "
                        + "glider_optional_info, "
                        + "glider_ballast, "
                        + "glider_baggage, "
                        + "glider_passenger_weight, "
                        + "airfield_id, "
                        + "airfield_name, "
                        + "airfield_designator, "
                        + "airfield_altitude, "
                        + "airfield_magnetic_variation, "
                        + "airfield_latitude, "
                        + "airfield_longitude, "
                        + "airfield_optional_info, "
                        + "runway_id, "
                        + "runway_name, "
                        + "runway_magnetic_heading, "
                        + "runway_parent, "
                        + "runway_parent_id, "
                        + "runway_altitude, "
                        + "runway_optional_info, "
                        + "glider_position_id, "
                        + "glider_position_position_id, "
                        + "glider_position_runway_parent, "
                        + "glider_position_runway_parent_id, "
                        + "glider_position_airfield_parent, "
                        + "glider_position_airfield_parent_id, "
                        + "glider_position_altitude, "
                        + "glider_position_latitude, "
                        + "glider_position_longitude, "
                        + "glider_position_optional_info, "
                        + "winch_position_id, "
                        + "winch_position_name, "
                        + "winch_position_runway_parent, "
                        + "winch_position_runway_parent_id, "
                        + "winch_position_airfield_parent, "
                        + "winch_position_airfield_parent_id, "
                        + "winch_position_altitude, "
                        + "winch_position_latitude, "
                        + "winch_position_longitude, "
                        + "winch_position_optional_info, "
                        + "drum_name, "
                        + "drum_core_diameter, "
                        + "drum_k_factor, "
                        + "drum_cable_length, "
                        + "parachute_id, "
                        + "parachute_name, "
                        + "parachute_lift, "
                        + "parachute_drag, "
                        + "parachute_weight) "
                        + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            CurrentDataObjectSet currentDataObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
            PreviousLaunchesInfoInsertStatement.setString(1, String.valueOf(startTime));
            PreviousLaunchesInfoInsertStatement.setString(2, String.valueOf(endTime));
            PreviousLaunchesInfoInsertStatement.setString(3, currentDataObjectSet.getCurrentProfile().getID());
            PreviousLaunchesInfoInsertStatement.setString(4, currentDataObjectSet.getCurrentProfile().getUnitSettingsForStorage());
            PreviousLaunchesInfoInsertStatement.setString(5, currentDataObjectSet.getCurrentProfile().getDisplayPrefsForStorage());
            PreviousLaunchesInfoInsertStatement.setString(6, currentDataObjectSet.getCurrentPilot().getPilotId());
            PreviousLaunchesInfoInsertStatement.setString(7, currentDataObjectSet.getCurrentPilot().getFirstName());
            PreviousLaunchesInfoInsertStatement.setString(8, currentDataObjectSet.getCurrentPilot().getLastName());
            PreviousLaunchesInfoInsertStatement.setString(9, currentDataObjectSet.getCurrentPilot().getMiddleName());
            PreviousLaunchesInfoInsertStatement.setString(10, String.valueOf(currentDataObjectSet.getCurrentPilot().getWeight()));
            PreviousLaunchesInfoInsertStatement.setString(11, String.valueOf(Capability.convertCapabilityStringToNum(currentDataObjectSet.getCurrentPilot().getCapability())));
            PreviousLaunchesInfoInsertStatement.setString(12, String.valueOf(Preference.convertPreferenceStringToNum(currentDataObjectSet.getCurrentPilot().getPreference())));
            PreviousLaunchesInfoInsertStatement.setString(13, currentDataObjectSet.getCurrentPilot().getEmergencyContact());
            PreviousLaunchesInfoInsertStatement.setString(14, currentDataObjectSet.getCurrentPilot().getMedInfo());
            PreviousLaunchesInfoInsertStatement.setString(15, currentDataObjectSet.getCurrentPilot().getOptionalInfo());
            PreviousLaunchesInfoInsertStatement.setString(16, currentDataObjectSet.getCurrentSailplane().getId());
            PreviousLaunchesInfoInsertStatement.setString(17, currentDataObjectSet.getCurrentSailplane().getNumber());
            PreviousLaunchesInfoInsertStatement.setString(18, currentDataObjectSet.getCurrentSailplane().getType());
            PreviousLaunchesInfoInsertStatement.setString(19, String.valueOf(currentDataObjectSet.getCurrentSailplane().getMaxGrossWeight()));
            PreviousLaunchesInfoInsertStatement.setString(20, String.valueOf(currentDataObjectSet.getCurrentSailplane().getEmptyWeight()));
            PreviousLaunchesInfoInsertStatement.setString(21, String.valueOf(currentDataObjectSet.getCurrentSailplane().getIndicatedStallSpeed()));
            PreviousLaunchesInfoInsertStatement.setString(22, String.valueOf(currentDataObjectSet.getCurrentSailplane().getMaxWinchingSpeed()));
            PreviousLaunchesInfoInsertStatement.setString(23, String.valueOf(currentDataObjectSet.getCurrentSailplane().getMaxWeakLinkStrength()));
            PreviousLaunchesInfoInsertStatement.setString(24, String.valueOf(currentDataObjectSet.getCurrentSailplane().getMaxTension()));
            PreviousLaunchesInfoInsertStatement.setString(25, String.valueOf(currentDataObjectSet.getCurrentSailplane().getCableReleaseAngle()));
            PreviousLaunchesInfoInsertStatement.setString(26, String.valueOf(currentDataObjectSet.getCurrentSailplane().storeCarryBallast()));
            PreviousLaunchesInfoInsertStatement.setString(27, String.valueOf(currentDataObjectSet.getCurrentSailplane().storeMultipleSeats()));
            PreviousLaunchesInfoInsertStatement.setString(28, currentDataObjectSet.getCurrentSailplane().getOptionalInfo());
            CurrentLaunchInformation currentLaunchInformation = CurrentLaunchInformation.getCurrentLaunchInformation();
            PreviousLaunchesInfoInsertStatement.setString(29, String.valueOf(currentLaunchInformation.getGliderBallast()));
            PreviousLaunchesInfoInsertStatement.setString(30, String.valueOf(currentLaunchInformation.getGliderBaggage()));
            PreviousLaunchesInfoInsertStatement.setString(31, String.valueOf(currentLaunchInformation.getPassengerWeight()));
            PreviousLaunchesInfoInsertStatement.setString(32, currentDataObjectSet.getCurrentAirfield().getId());
            PreviousLaunchesInfoInsertStatement.setString(33, currentDataObjectSet.getCurrentAirfield().getName());
            PreviousLaunchesInfoInsertStatement.setString(34, currentDataObjectSet.getCurrentAirfield().getDesignator());
            PreviousLaunchesInfoInsertStatement.setString(35, String.valueOf(currentDataObjectSet.getCurrentAirfield().getAltitude()));
            PreviousLaunchesInfoInsertStatement.setString(36, String.valueOf(currentDataObjectSet.getCurrentAirfield().getMagneticVariation()));
            PreviousLaunchesInfoInsertStatement.setString(37, String.valueOf(currentDataObjectSet.getCurrentAirfield().getLatitude()));
            PreviousLaunchesInfoInsertStatement.setString(38, String.valueOf(currentDataObjectSet.getCurrentAirfield().getLongitude()));
            PreviousLaunchesInfoInsertStatement.setString(39, currentDataObjectSet.getCurrentAirfield().getOptionalInfo());
            PreviousLaunchesInfoInsertStatement.setString(40, currentDataObjectSet.getCurrentRunway().getId());
            PreviousLaunchesInfoInsertStatement.setString(41, currentDataObjectSet.getCurrentRunway().getName());
            PreviousLaunchesInfoInsertStatement.setString(42, String.valueOf(currentDataObjectSet.getCurrentRunway().getMagneticHeading()));
            PreviousLaunchesInfoInsertStatement.setString(43, currentDataObjectSet.getCurrentRunway().getParent());
            PreviousLaunchesInfoInsertStatement.setString(44, currentDataObjectSet.getCurrentRunway().getParentId());
            PreviousLaunchesInfoInsertStatement.setString(45, String.valueOf(currentDataObjectSet.getCurrentRunway().getAltitude()));
            PreviousLaunchesInfoInsertStatement.setString(46, currentDataObjectSet.getCurrentRunway().getOptionalInfo());
            PreviousLaunchesInfoInsertStatement.setString(47, currentDataObjectSet.getCurrentGliderPosition().getId());
            PreviousLaunchesInfoInsertStatement.setString(48, currentDataObjectSet.getCurrentGliderPosition().getGliderPositionId());
            PreviousLaunchesInfoInsertStatement.setString(49, currentDataObjectSet.getCurrentGliderPosition().getRunwayParent());
            PreviousLaunchesInfoInsertStatement.setString(50, currentDataObjectSet.getCurrentGliderPosition().getRunwayParentId());
            PreviousLaunchesInfoInsertStatement.setString(51, currentDataObjectSet.getCurrentGliderPosition().getAirfieldParent());
            PreviousLaunchesInfoInsertStatement.setString(52, currentDataObjectSet.getCurrentGliderPosition().getAirfieldParentId());
            PreviousLaunchesInfoInsertStatement.setString(53, String.valueOf(currentDataObjectSet.getCurrentGliderPosition().getAltitude()));
            PreviousLaunchesInfoInsertStatement.setString(54, String.valueOf(currentDataObjectSet.getCurrentGliderPosition().getLatitude()));
            PreviousLaunchesInfoInsertStatement.setString(55, String.valueOf(currentDataObjectSet.getCurrentGliderPosition().getLongitude()));
            PreviousLaunchesInfoInsertStatement.setString(56, currentDataObjectSet.getCurrentGliderPosition().getOptionalInfo());
            PreviousLaunchesInfoInsertStatement.setString(57, currentDataObjectSet.getCurrentWinchPosition().getId());
            PreviousLaunchesInfoInsertStatement.setString(58, currentDataObjectSet.getCurrentWinchPosition().getName());
            PreviousLaunchesInfoInsertStatement.setString(59, currentDataObjectSet.getCurrentWinchPosition().getRunwayParent());
            PreviousLaunchesInfoInsertStatement.setString(60, currentDataObjectSet.getCurrentWinchPosition().getRunwayParentId());
            PreviousLaunchesInfoInsertStatement.setString(61, currentDataObjectSet.getCurrentWinchPosition().getAirfieldParent());
            PreviousLaunchesInfoInsertStatement.setString(62, currentDataObjectSet.getCurrentWinchPosition().getAirfieldParentId());
            PreviousLaunchesInfoInsertStatement.setString(63, String.valueOf(currentDataObjectSet.getCurrentWinchPosition().getAltitude()));
            PreviousLaunchesInfoInsertStatement.setString(64, String.valueOf(currentDataObjectSet.getCurrentWinchPosition().getLatitude()));
            PreviousLaunchesInfoInsertStatement.setString(65, String.valueOf(currentDataObjectSet.getCurrentWinchPosition().getLongitude()));
            PreviousLaunchesInfoInsertStatement.setString(66, currentDataObjectSet.getCurrentWinchPosition().getOptionalInfo());
            PreviousLaunchesInfoInsertStatement.setString(67, currentDataObjectSet.getCurrentDrum().getName());
            PreviousLaunchesInfoInsertStatement.setString(68, String.valueOf(currentDataObjectSet.getCurrentDrum().getCoreDiameter()));
            PreviousLaunchesInfoInsertStatement.setString(69, String.valueOf(currentDataObjectSet.getCurrentDrum().getKFactor()));
            PreviousLaunchesInfoInsertStatement.setString(70, String.valueOf(currentDataObjectSet.getCurrentDrum().getCableLength()));
            PreviousLaunchesInfoInsertStatement.setString(71, String.valueOf(currentDataObjectSet.getCurrentDrum().getParachute().getParachuteNumber()));
            PreviousLaunchesInfoInsertStatement.setString(72, currentDataObjectSet.getCurrentDrum().getParachute().getName());
            PreviousLaunchesInfoInsertStatement.setString(73, String.valueOf(currentDataObjectSet.getCurrentDrum().getParachute().getLift()));
            PreviousLaunchesInfoInsertStatement.setString(74, String.valueOf(currentDataObjectSet.getCurrentDrum().getParachute().getDrag()));
            PreviousLaunchesInfoInsertStatement.setString(75, String.valueOf(currentDataObjectSet.getCurrentDrum().getParachute().getWeight()));
            
            PreviousLaunchesInfoInsertStatement.executeUpdate();
            PreviousLaunchesInfoInsertStatement.close();
        }catch(SQLException e) {
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
            ResultSet thePilots = stmt.executeQuery("SELECT pilot_id, first_name, last_name, middle_name, flight_weight, capability, "
                    + "preference, emergency_contact_info, emergency_medical_info, optional_info "
                    + "FROM Pilot ORDER BY pilot_id");
            List pilots = new ArrayList<Pilot>();
            
            while(thePilots.next()) {
                String pilotId = thePilots.getString(1);
                String pilotFirstName = thePilots.getString(2);
                String pilotLastName = thePilots.getString(3);
                String pilotMiddleName = thePilots.getString(4);
                
                float weight = 0; 
                int capability = 1;
                int preference = 1;
                try {
                    weight = Float.parseFloat(thePilots.getString(5));
                    capability = Integer.parseInt(thePilots.getString(6));
                    preference = Integer.parseInt(thePilots.getString(7));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                Pilot newPilot = new Pilot(pilotId, pilotFirstName, pilotLastName, pilotMiddleName, weight , 
                        Capability.convertCapabilityNumToString(capability), Preference.convertPreferenceNumToString(preference), 
                        thePilots.getString(8), thePilots.getString(9), thePilots.getString(10));
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
            ResultSet theSailplanes = stmt.executeQuery("SELECT glider_id, n_number, type, "
                    + "max_gross_weight, empty_weight, indicated_stall_speed,"
                    + "max_winching_speed, max_weak_link_strength, max_tension, "
                    + "cable_release_angle, carry_ballast, multiple_seats, "
                    + "optional_info "
                    + "FROM Glider ORDER BY n_number");
            List sailplanes = new ArrayList<Sailplane>();
            
            while(theSailplanes.next()) {
                String nNumber = theSailplanes.getString(2);
                String type = theSailplanes.getString(3);
                float maxGrossWeight = 0; 
                float emptyWeight = 0;
                float stallSpeed = 0;
                float maxWinchingSpeed = 0;
                float maxWeakLinkStrength = 0;
                float maxTension = 0;
                float cableAngle = 0;
                try {
                    maxGrossWeight = Float.parseFloat(theSailplanes.getString(4));
                    emptyWeight = Float.parseFloat(theSailplanes.getString(5));
                    stallSpeed = Float.parseFloat(theSailplanes.getString(6));
                    maxWinchingSpeed = Float.parseFloat(theSailplanes.getString(7));
                    maxWeakLinkStrength = Float.parseFloat(theSailplanes.getString(8));
                    maxTension = Float.parseFloat(theSailplanes.getString(9));
                    cableAngle = Float.parseFloat(theSailplanes.getString(10));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                boolean ballast = false;
                boolean multipleSeats = false;
                try{
                    ballast = Sailplane.returnCarryBallast(Integer.parseInt(theSailplanes.getString(11)));
                    multipleSeats = Sailplane.returnMultipleSeats(Integer.parseInt(theSailplanes.getString(12)));
                }catch(NumberFormatException e) {
                    //e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error reading ballast in reading from DB");
                }
                
                Sailplane newSailplane = new Sailplane(nNumber, type,
                        maxGrossWeight, emptyWeight, stallSpeed, maxWinchingSpeed, 
                        maxWeakLinkStrength, maxTension, cableAngle, ballast, multipleSeats, theSailplanes.getString(13));
                newSailplane.setId(theSailplanes.getString(1));
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
     * Pulls the list of Airfields (and relevant data) from the database
     * 
     * @return the list of airfields in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<Airfield> getAirfields() throws SQLException, ClassNotFoundException {        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theAirfields = stmt.executeQuery("SELECT airfield_id, name, designator, altitude, "
                + "magnetic_variation, latitude, longitude, optional_info "
                + "FROM Airfield ORDER BY name");
            List airfields = new ArrayList<Airfield>();
            
            while(theAirfields.next()) {
                String name = theAirfields.getString(2);
                String designator = theAirfields.getString(3);
                
                float altitude = 0;
                float magneticVariation = 0;
                float latitude = 0;
                float longitude = 0;
                try {
                    altitude = Float.parseFloat(theAirfields.getString(4));
                    magneticVariation = Float.parseFloat(theAirfields.getString(5));
                    latitude = Float.parseFloat(theAirfields.getString(6));
                    longitude = Float.parseFloat(theAirfields.getString(7));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                
                String optional = theAirfields.getString(8);
                
                Airfield newAirfield = new Airfield(name, designator, altitude, magneticVariation,
                        latitude, longitude, optional);
                newAirfield.setId(theAirfields.getString(1));
                airfields.add(newAirfield);
                
            }
            theAirfields.close();
            stmt.close();
            connect.close();
            return airfields;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Runways (and relevant data) from the database
     * 
     * @return the list of runways in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<Runway> getRunways() throws SQLException, ClassNotFoundException {        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theRunways = stmt.executeQuery("SELECT runway_id, runway_name, magnetic_heading, parent, parent_id, altitude, optional_info "
                + "FROM Runway ORDER BY runway_id");
            List runways = new ArrayList<Runway>();
            
            while(theRunways.next()) {
                String name = theRunways.getString(2);
                String parent = theRunways.getString(4);
                
                float altitude = 0;
                float magneticHeading = 0;
                try {
                    magneticHeading = Float.parseFloat(theRunways.getString(3));
                    altitude = Float.parseFloat(theRunways.getString(6));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                
                String optional = theRunways.getString(7);
                          
                Runway newRunway = new Runway(name, magneticHeading, parent, altitude, optional);
                newRunway.setId(theRunways.getString(1));
                newRunway.setParentId(theRunways.getString(5));
                runways.add(newRunway);
                
            }
            theRunways.close();
            stmt.close();
            connect.close();
            return runways;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Glider positions (and relevant data) from the database
     * 
     * @return the list of glider positions in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<GliderPosition> getGliderPositions() throws SQLException, ClassNotFoundException {        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theGliderPositions = stmt.executeQuery("SELECT glider_position_id, position_id, runway_parent, runway_parent_id, airfield_parent, airfield_parent_id, altitude, latitude, longitude, optional_info "
                + "FROM GliderPosition ORDER BY position_id");
            List positions = new ArrayList<GliderPosition>();
            
            while(theGliderPositions.next()) {
                String id = theGliderPositions.getString(2);
                String runwayParent = theGliderPositions.getString(3);
                String airfieldParent = theGliderPositions.getString(5);
                
                float altitude = 0;
                float latitude = 0;
                float longitude = 0;
                try {
                    altitude = Float.parseFloat(theGliderPositions.getString(7));
                    latitude = Float.parseFloat(theGliderPositions.getString(8));
                    longitude = Float.parseFloat(theGliderPositions.getString(9));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                
                String optional = theGliderPositions.getString(10);
                          
                GliderPosition newGliderPosition = new GliderPosition(id, runwayParent, airfieldParent, altitude, latitude, longitude, optional);
                newGliderPosition.setId(theGliderPositions.getString(1));
                newGliderPosition.setRunwayParentId(theGliderPositions.getString(4));
                newGliderPosition.setAirfieldParentId(theGliderPositions.getString(6));
                positions.add(newGliderPosition);
                
            }
            theGliderPositions.close();
            stmt.close();
            connect.close();
            return positions;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Winch positions (and relevant data) from the database
     * 
     * @return the list of winch positions in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<WinchPosition> getWinchPositions() throws SQLException, ClassNotFoundException {        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theWinchPositions = stmt.executeQuery("SELECT winch_position_id, name, runway_parent, runway_parent_id, airfield_parent, airfield_parent_id, altitude, latitude, longitude, optional_info "
                + "FROM WinchPosition ORDER BY name");
            List positions = new ArrayList<WinchPosition>();
            
            while(theWinchPositions.next()) {
                String name = theWinchPositions.getString(2);
                String runwayParent = theWinchPositions.getString(3);
                String airfieldParent = theWinchPositions.getString(5);
                
                float altitude = 0;
                float latitude = 0;
                float longitude = 0;
                try {
                    altitude = Float.parseFloat(theWinchPositions.getString(7));
                    latitude = Float.parseFloat(theWinchPositions.getString(8));
                    longitude = Float.parseFloat(theWinchPositions.getString(9));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                
                String optional = theWinchPositions.getString(7);
                          
                WinchPosition newWinchPosition = new WinchPosition(name, runwayParent, airfieldParent, altitude, latitude, longitude, optional);
                newWinchPosition.setId(theWinchPositions.getString(1));
                newWinchPosition.setRunwayParentId(theWinchPositions.getString(4));
                newWinchPosition.setAirfieldParentId(theWinchPositions.getString(6));
                positions.add(newWinchPosition);
                
            }
            theWinchPositions.close();
            stmt.close();
            connect.close();
            return positions;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Parachutes (and relevant data) from the database
     * 
     * @return the list of parachutes in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<Parachute> getParachutes() throws SQLException, ClassNotFoundException {        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theParachutes = stmt.executeQuery("SELECT parachute_id, lift, drag, weight "
                + "FROM Parachute ORDER BY parachute_id");
            List parachutes = new ArrayList<Parachute>();
            
            while(theParachutes.next()) {
                
                int id = 0;
                
                float lift = 0;
                float drag = 0;
                float weight = 0;
                try {
                    id = Integer.parseInt(theParachutes.getString(1));
                    lift = Float.parseFloat(theParachutes.getString(2));
                    drag = Float.parseFloat(theParachutes.getString(3));
                    weight = Float.parseFloat(theParachutes.getString(4));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
               
                Parachute newParachute = new Parachute(id, lift, drag, weight);
                        
                parachutes.add(newParachute);
                
            }
            theParachutes.close();
            stmt.close();
            connect.close();
            return parachutes;
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
     * Pulls the summary list of flights from the database
     * 
     * @return the list of flights in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    
    public static List<FlightSummary> getFlights() throws SQLException, ClassNotFoundException {        
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
            ResultSet theFlights = stmt.executeQuery("SELECT start_timestamp, pilot_id, "
                    + "pilot_first_name, pilot_last_name, glider_n_number "
                    + "FROM PreviousLaunchesInfo ORDER BY start_timestamp");
            List flights = new ArrayList<FlightSummary>();
            
            while(theFlights.next()) {
                String startTimestamp = theFlights.getString(1); 
                String pilotId = theFlights.getString(2);
                String pilotFirstName = theFlights.getString(3);
                String pilotLastName = theFlights.getString(4);
                String gliderNnumber = theFlights.getString(5);
                
                FlightSummary newFlight = new FlightSummary(startTimestamp, pilotId, 
                        pilotFirstName, pilotLastName, gliderNnumber);
                flights.add(newFlight);
            }
            theFlights.close();
            stmt.close();
            connect.close();
            return flights;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * sets currentDataObjectSet to the given flight
     * 
     * @param flightInformation contains the summary information of the flight
     * @post the current information contains the past flight information
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    
    public static void setCurrentDataObjectSetToFlight(FlightSummary flightInformation) throws SQLException, ClassNotFoundException {        
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
            ResultSet theFlight = stmt.executeQuery("SELECT * "
                    + "FROM PreviousLaunchesInfo WHERE start_timestamp = " + Double.parseDouble(flightInformation.getStartTimestamp()) + " "
                    + "AND pilot_id = '" + flightInformation.getPilotId() + "' ");
            CurrentDataObjectSet currentDataObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
            while(theFlight.next()) {
                //Create Profile
                String profileName = theFlight.getString(3);
                String[] names = profileName.split("\\s+"); 
                String unitSettings = theFlight.getString(4);
                String displayPrefs = theFlight.getString(5);
                Profile newProfile = new Profile(profileName, unitSettings, displayPrefs);
                currentDataObjectSet.setCurrentProfile(newProfile);
                
                //Create Pilot
                String pilotId = theFlight.getString(6);
                String pilotFirstName = theFlight.getString(7);
                String pilotLastName = theFlight.getString(8);
                String pilotMiddleName = theFlight.getString(9);
                
                float pilotWeight = 0; 
                int pilotCapability = 1;
                int pilotPreference = 1;
                try {
                    pilotWeight = Float.parseFloat(theFlight.getString(10));
                    pilotCapability = Integer.parseInt(theFlight.getString(11));
                    pilotPreference = Integer.parseInt(theFlight.getString(12));
                }catch(NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                Pilot newPilot = new Pilot(pilotId, pilotFirstName, pilotLastName, pilotMiddleName, pilotWeight , 
                        Capability.convertCapabilityNumToString(pilotCapability), Preference.convertPreferenceNumToString(pilotPreference), 
                        theFlight.getString(13), theFlight.getString(14), theFlight.getString(15));
                currentDataObjectSet.setCurrentPilot(newPilot);
                
                //Create Glider
                String gliderNNumber = theFlight.getString(17);
                String gliderType = theFlight.getString(18);
                float gliderMaxGrossWeight = 0; 
                float gliderEmptyWeight = 0;
                float gliderStallSpeed = 0;
                float gliderMaxWinchingSpeed = 0;
                float gliderMaxWeakLinkStrength = 0;
                float gliderMaxTension = 0;
                float gliderCableAngle = 0;
                try {
                    gliderMaxGrossWeight = Float.parseFloat(theFlight.getString(19));
                    gliderEmptyWeight = Float.parseFloat(theFlight.getString(20));
                    gliderStallSpeed = Float.parseFloat(theFlight.getString(21));
                    gliderMaxWinchingSpeed = Float.parseFloat(theFlight.getString(22));
                    gliderMaxWeakLinkStrength = Float.parseFloat(theFlight.getString(23));
                    gliderMaxTension = Float.parseFloat(theFlight.getString(24));
                    gliderCableAngle = Float.parseFloat(theFlight.getString(25));
                }catch(NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                boolean ballast = false;
                boolean multipleSeats = false;
                try{
                    ballast = Sailplane.returnCarryBallast(Integer.parseInt(theFlight.getString(26)));
                    multipleSeats = Sailplane.returnMultipleSeats(Integer.parseInt(theFlight.getString(27)));
                }catch(NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error reading ballast in reading from DB");
                }
                
                Sailplane newSailplane = new Sailplane(gliderNNumber, gliderType,
                        gliderMaxGrossWeight, gliderEmptyWeight, gliderStallSpeed, gliderMaxWinchingSpeed, 
                        gliderMaxWeakLinkStrength, gliderMaxTension, gliderCableAngle, ballast, multipleSeats, theFlight.getString(28));
                newSailplane.setId(theFlight.getString(16));
                currentDataObjectSet.setCurrentGlider(newSailplane);
                
                CurrentLaunchInformation currentLaunchInformation = CurrentLaunchInformation.getCurrentLaunchInformation();
                currentLaunchInformation.setGliderBallast(Float.parseFloat(theFlight.getString(29)));
                currentLaunchInformation.setPassengerWeight(Float.parseFloat(theFlight.getString(31)));
                currentLaunchInformation.setGliderBaggage(Float.parseFloat(theFlight.getString(30)));
                
                //Create Airfield
                String airfieldName = theFlight.getString(33);
                String airfieldDesignator = theFlight.getString(34);
                
                float airfieldAltitude = 0;
                float airfieldMagneticVariation = 0;
                float airfieldLatitude = 0;
                float airfieldLongitude = 0;
                try {
                    airfieldAltitude = Float.parseFloat(theFlight.getString(35));
                    airfieldMagneticVariation = Float.parseFloat(theFlight.getString(36));
                    airfieldLatitude = Float.parseFloat(theFlight.getString(37));
                    airfieldLongitude = Float.parseFloat(theFlight.getString(38));
                }catch(NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                
                String airfieldOptional = theFlight.getString(39);
                
                Airfield newAirfield = new Airfield(airfieldName, airfieldDesignator, airfieldAltitude, airfieldMagneticVariation,
                        airfieldLatitude, airfieldLongitude, airfieldOptional);
                newAirfield.setId(theFlight.getString(32));
                currentDataObjectSet.setCurrentAirfield(newAirfield);
                
                //Create Runway
                String runwayName = theFlight.getString(41);
                String runwayParent = theFlight.getString(43);
                
                float runwayAltitude = 0;
                float runwayMagneticHeading = 0;
                try {
                    runwayMagneticHeading = Float.parseFloat(theFlight.getString(42));
                    runwayAltitude = Float.parseFloat(theFlight.getString(45));
                }catch(NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                
                String runwayOptional = theFlight.getString(46);
                          
                Runway newRunway = new Runway(runwayName, runwayMagneticHeading, runwayParent, runwayAltitude, runwayOptional);
                newRunway.setId(theFlight.getString(40));
                newRunway.setParentId(theFlight.getString(44));
                currentDataObjectSet.setCurrentRunway(newRunway);
                
                //Create Glider Position
                String gliderPositionId = theFlight.getString(48);
                String gliderPositionRunwayParent = theFlight.getString(49);
                String gliderPositionAirfieldParent = theFlight.getString(51);
                
                float gliderPositionAltitude = 0;
                float gliderPositionLatitude = 0;
                float gliderPositionLongitude = 0;
                try {
                    gliderPositionAltitude = Float.parseFloat(theFlight.getString(53));
                    gliderPositionLatitude = Float.parseFloat(theFlight.getString(54));
                    gliderPositionLongitude = Float.parseFloat(theFlight.getString(55));
                }catch(NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                
                String gliderPositionOptional = theFlight.getString(56);
                          
                GliderPosition newGliderPosition = new GliderPosition(gliderPositionId, 
                        gliderPositionRunwayParent, gliderPositionAirfieldParent, 
                        gliderPositionAltitude, gliderPositionLatitude, gliderPositionLongitude, gliderPositionOptional);
                newGliderPosition.setId(theFlight.getString(47));
                newGliderPosition.setRunwayParentId(theFlight.getString(50));
                newGliderPosition.setAirfieldParentId(theFlight.getString(52));
                currentDataObjectSet.setCurrentGliderPosition(newGliderPosition);
                
                //Create Winch Position
                String winchPositionName = theFlight.getString(58);
                String winchPositionRunwayParent = theFlight.getString(59);
                String winchPositionAirfieldParent = theFlight.getString(61);
                
                float winchPositionAltitude = 0;
                float winchPositionLatitude = 0;
                float winchPositionLongitude = 0;
                try {
                    winchPositionAltitude = Float.parseFloat(theFlight.getString(63));
                    winchPositionLatitude = Float.parseFloat(theFlight.getString(64));
                    winchPositionLongitude = Float.parseFloat(theFlight.getString(65));
                }catch(NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                
                String winchPositionOptional = theFlight.getString(66);
                          
                WinchPosition newWinchPosition = new WinchPosition(winchPositionName,
                        winchPositionRunwayParent, winchPositionAirfieldParent,
                        winchPositionAltitude, winchPositionLatitude,
                        winchPositionLongitude, winchPositionOptional);
                newWinchPosition.setId(theFlight.getString(57));
                newWinchPosition.setRunwayParentId(theFlight.getString(60));
                newWinchPosition.setAirfieldParentId(theFlight.getString(62));
                currentDataObjectSet.setCurrentWinchPosition(newWinchPosition);
                
                //Create Drum
                String drumName = theFlight.getString(67);
                
                float drumCoreDiameter = 0;
                float drumKFactor = 0;
                float drumCableLength = 0;
                try {
                    drumCoreDiameter = Float.parseFloat(theFlight.getString(68));
                    drumKFactor = Float.parseFloat(theFlight.getString(69));
                    drumCableLength = Float.parseFloat(theFlight.getString(70));
                }catch(NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
               
                Drum newDrum = new Drum(drumName, drumCoreDiameter, drumKFactor, drumCableLength);
                
                //Create Parachute
                String parachuteName = theFlight.getString(72);
                int parachuteId = 0;
                
                float parachuteLift = 0;
                float parachuteDrag = 0;
                float parachuteWeight = 0;
                try {
                    parachuteId = Integer.parseInt(theFlight.getString(71));
                    parachuteLift = Float.parseFloat(theFlight.getString(73));
                    parachuteDrag = Float.parseFloat(theFlight.getString(74));
                    parachuteWeight = Float.parseFloat(theFlight.getString(75));
                }catch(NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
               
                Parachute newParachute = new Parachute(parachuteName, parachuteId, parachuteLift, parachuteDrag, parachuteWeight);
                newDrum.setParachute(newParachute);
                currentDataObjectSet.setCurrentDrum(newDrum);
            }
            theFlight.close();
            stmt.close();
            connect.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static List<String> getTables() throws SQLException, ClassNotFoundException {        
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
            ResultSet theTables = stmt.executeQuery("SELECT * FROM SYS.SYSTABLES");
            List tables = new ArrayList<String>();
            while(theTables.next()) {
                
                //CHECKS TO SEE IF IT IS A SYSTEM TABLE OR A UNITS TABLE, WHICH WILL BE EXCLUDED
                if(!theTables.getString(2).contains("SYS") && !theTables.getString(2).contains("UNITS"))
                    tables.add(theTables.getString(2));
            }
            
            return tables;
            
        }catch(Exception e) {
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
                                        + "WHERE firstName = ? "
                                        + "AND WHERE lastName = ?");
            pilotEditStatement.setString(1, String.valueOf(pilot.getWeight()));
            pilotEditStatement.setString(2, String.valueOf(Capability.convertCapabilityStringToNum(pilot.getCapability())));
            pilotEditStatement.setString(3, String.valueOf(Preference.convertPreferenceStringToNum(pilot.getPreference())));
            pilotEditStatement.setString(4, pilot.getEmergencyContact());
            pilotEditStatement.setString(5, pilot.getMedInfo());
            pilotEditStatement.setString(6, pilot.getFirstName());
            pilotEditStatement.setString(7, pilot.getLastName());
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
                    + "WHERE firstName = ? "
                    + "AND WHERE lastName = ?");   
            pilotEditStatement.setString(1, pilot.getFirstName());
            pilotEditStatement.setString(2, pilot.getLastName());
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
            s.execute("UPDATE Pilot SET firstName = 'A Name', Weight = '000', capability='1', preference='1', emergency_contact_info='None', emergency_medical_info = 'None' where 1=3"); 
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
    
    
    
    public static void addMessageToBlackBox(double time, String message) throws SQLException, ClassNotFoundException {
        //long unixTime = System.currentTimeMillis(); 
        //Date date = new Date();
        
        //System.out.println(date.getTime());
        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(ClassNotFoundException e){
            System.out.println("Error");
            throw e;
        }
        
        try(Connection connect = DriverManager.getConnection(databaseConnectionName)) {
           PreparedStatement insertStatement = connect.prepareStatement(
                 "INSERT INTO BlackBox(timestamp, message)"
                         + "values(?,?)");
           insertStatement.setString(1, String.valueOf(time));
           insertStatement.setString(2, message);
           
           insertStatement.executeUpdate();
           insertStatement.close();
        }catch(SQLException e) {
            System.out.println("Error 2");
            e.printStackTrace();
            throw e;
        }
            
    }
    
    public static void addMessageToFlightMessages(long time, String message) throws SQLException, ClassNotFoundException {
        
        long unixTime = System.currentTimeMillis(); 
        //Date date = new Date();
        
        //System.out.println(date.getTime());
        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(ClassNotFoundException e){
            System.out.println("Error");
            throw e;
        }
        
        try(Connection connect = DriverManager.getConnection(databaseConnectionName)) {
           PreparedStatement insertStatement = connect.prepareStatement(
                 "INSERT INTO Messages(timestamp, message)"
                         + "values(?,?)");
           insertStatement.setString(1, String.valueOf(time));
           insertStatement.setString(2, message);
           
           insertStatement.executeUpdate();
           insertStatement.close();
        }catch(SQLException e) {
            System.out.println("Error 2");
            e.printStackTrace();
            throw e;
        }
    }
         
    public static void clearBlackbox() throws SQLException, ClassNotFoundException {
        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(ClassNotFoundException e){
            System.out.println("Error");
            throw e;
        }
        
        try(Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            Statement stmt = connect.createStatement();
            try 
            {
                stmt.execute("SELECT * FROM Blackbox");
                stmt.execute("DROP TABLE Blackbox");
                
            } catch(SQLException e) { }
            
            DatabaseInitialization.createBlackboxTable(connect);
            
        }catch(SQLException e) {
            System.out.println("Error 2");
            e.printStackTrace();
            throw e;
        }
    }


}
