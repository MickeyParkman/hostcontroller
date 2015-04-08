/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Alex Williams, Noah Fujioka, dbennett3
 */
public class DatabaseInitialization {
    /**
    *Initializes the database for this program using calls to the helper
    *functions
    *
    * @throws ClassNotFoundException if the classes for the Apache Derby database can't be found
    * @throws SQLException if an issue arises while creating the tables
    */
    public static void initDatabase() throws ClassNotFoundException, SQLException {
        String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
        String clientDriverName = "org.apache.derby.jdbc.ClientDriver";
        String databaseConnectionName = "jdbc:derby:WinchCommonsTest12DataBase;create=true";
        Connection connection = null;
        Statement createStatment;
        
        //Check for DB drivers
        try{
            Class.forName(clientDriverName);
            Class.forName(driverName);
        }catch(java.lang.ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Can't load JavaDb ClientDriver", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw e;
        }
    
        //Try to connect to the specified database
        try{
            connection = DriverManager.getConnection(databaseConnectionName);
        }catch(SQLException e) {
            //TODO Fix error handling
            JOptionPane.showMessageDialog(null, "Correctly loaded the JavaDb ClientDriver, somethin else is wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw e;
        }
        
        ///*
        //This is to drop all tables
        try{
            dropTables(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        //*/
        
        
        //Build and fill Capability table
        try{
            createCapability(connection);
            System.out.println("Build capability");
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        } 
        
        //Build and fill Preference table
        try{
            createPreference(connection);
            System.out.println("Build preference");
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        //Build the Pilot table
        try{
            createPilot(connection);
            System.out.println("Build pilot");
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }  
        //Build the Glider table
        try{
             createGlider(connection);
             System.out.println("Build glider");
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }  
        //Build the Airfield table  
        try{
            createAirfield(connection);
            System.out.println("Build airfield");
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        //Build the Runway table
        try{
            createRunway(connection);
            System.out.println("Build runway");
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        //Build the GliderPosition table
        try{
            createGliderPosition(connection);
            System.out.println("Build glider position");
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());

            //throw e;
        }
        //Build the WinchPosition table
        try{
            createWinchPosition(connection);
            System.out.println("Build winch position");
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        //Build the Operator Profile table
        try{
            createProfile(connection);
            System.out.println("Build profile");
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        //Build the Parachute table
        try{
            createParachute(connection);
            System.out.println("Build parachute");
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        
        //Build the RecentLaunches table
        try{
            createRecentLaunches(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        //Build the PreviousLaunchesInfo table
        try{
            createPreviousLaunchesInfo(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        
        try{
             createDistanceUnits(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        try{
             createTensionUnits(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        try{
             createVelocityUnits(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        try{
             createWeightUnits(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        try{
             createTemperatureUnits(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        try{
             createPressureUnits(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        try{
             createPilotUnits(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        try{
             createGliderUnits(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        try{
             createAirfieldUnits(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        try{
             createPositionUnits(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        try{
             createDashboardUnits(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        try{
             createEnvironmentalUnits(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        try{
             createMessagesTable(connection);
        }catch(SQLException e) {
            //For debugging purposes:
            //JOptionPane.showMessageDialog(null, e.getMessage());
            //throw e;
        }
        connection.close();
    }
    
    /**
     * Creates the table in the database for storing data associated with a Pilot object
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createPilot(Connection connect) throws SQLException {
        String createPilotString = "CREATE TABLE Pilot"
                + "(pilot_id VARCHAR(8), "
                + "first_name VARCHAR(30), "
                + "last_name VARCHAR(30), "
                + "middle_name VARCHAR(30), "
                + "flight_weight FLOAT, "
                + "capability INT, "
                + "preference INT, "
                + "emergency_contact_info VARCHAR(100), "
                + "emergency_medical_info VARCHAR(150), "
                + "optional_info VARCHAR(150), "
                + "PRIMARY KEY (pilot_id), "
                + "FOREIGN KEY (capability) REFERENCES Capability (capability_id),"
                + "FOREIGN KEY (preference) REFERENCES Preference (preference_id))";
        
        
        try (Statement createPilotTableStatement = connect.createStatement()) {
            createPilotTableStatement.execute(createPilotString);
        }catch(SQLException e) {
            throw e;
        }        
    }
    
    /**
     * Creates the table in the database for storing data associated with a Glider object
     * 
     * @param connectthe connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createGlider(Connection connect) throws SQLException {
        String createGliderString = "CREATE TABLE Glider"
                + "(glider_id VARCHAR(8), "
                + "n_number VARCHAR(30),"
                + "type VARCHAR(30),"
                + "max_gross_weight FLOAT,"
                + "empty_weight FLOAT,"
                + "indicated_stall_speed FLOAT,"
                + "max_winching_speed FLOAT,"
                + "max_weak_link_strength FLOAT,"
                + "max_tension FLOAT,"
                + "cable_release_angle FLOAT, "
                + "carry_ballast INT, "
                + "multiple_seats INT, "
                + "optional_info VARCHAR(150),"
                + "PRIMARY KEY (glider_id))";
        try (Statement createPilotTableStatement = connect.createStatement()) {
            createPilotTableStatement.execute(createGliderString);
        }catch(SQLException e) {
            throw e;
        }
    }
      
    /**
     * Creates the table in the database for storing the possible Capabilities of a Pilot
     * 
     * @param connectthe connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createCapability(Connection connect) throws SQLException {
        String createCapablityString = "CREATE TABLE Capability"
                + "(capability_id INT,"
                + "capability_string VARCHAR(15),"
                + "PRIMARY KEY (capability_id))";

        String addStudent = "INSERT INTO Capability(capability_id, capability_string) VALUES (0, 'Student')";
        String addProficient = "INSERT INTO Capability(capability_id, capability_string) VALUES (1, 'Proficient')";
        String addAdvanced = "INSERT INTO Capability(capability_id, capability_string) VALUES (2, 'Advanced')";
        try (Statement createCapabilityTableStatement = connect.createStatement()) {
                createCapabilityTableStatement.execute(createCapablityString);
                createCapabilityTableStatement.executeUpdate(addStudent);
                createCapabilityTableStatement.executeUpdate(addProficient);
                createCapabilityTableStatement.executeUpdate(addAdvanced);
                
        }catch(SQLException e) {
            throw e;
        }        
    }
    
    
    /**
     * Creates the table in the database for storing the possible Preferences of a Pilot
     * 
     * @param connectthe connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createPreference(Connection connect) throws SQLException {
        String createPreferenceString = "CREATE TABLE Preference"
                + "(preference_id INT,"
                + "preference_string VARCHAR(15),"
                + "PRIMARY KEY (preference_id))";

        String addMild = "INSERT INTO Preference(preference_id, preference_string) VALUES (0, 'Mild')";
        String addNominal = "INSERT INTO Preference(preference_id, preference_string) VALUES (1, 'Nominal')";
        String addPerformance = "INSERT INTO Preference(preference_id, preference_string) VALUES (2, 'Perfomrance')";
        try (Statement createPreferenceTableStatement = connect.createStatement()) {
                createPreferenceTableStatement.execute(createPreferenceString);
                createPreferenceTableStatement.executeUpdate(addMild);
                createPreferenceTableStatement.executeUpdate(addNominal);
                createPreferenceTableStatement.executeUpdate(addPerformance);
        }catch(SQLException e) {
            throw e;
        }        
    }
    
    /**
     * Creates the table in the database for storing data associated with a Airfield object
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createAirfield(Connection connect) throws SQLException {
        String createAirfieldString = "CREATE TABLE Airfield"
                + "(airfield_id VARCHAR(8), "
                + "name VARCHAR(30), "
                + "designator VARCHAR(30), "
                + "altitude VARCHAR(20), "
                + "magnetic_variation VARCHAR(20), "
                + "latitude FLOAT, "
                + "longitude FLOAT, "
                + "optional_info VARCHAR(150), "
                + "PRIMARY KEY (airfield_id))";
        try (Statement createAirfieldTableStatement = connect.createStatement()) {
            createAirfieldTableStatement.execute(createAirfieldString);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Creates the table in the database for storing data associated with a Runway object
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createRunway(Connection connect) throws SQLException {
        String createRunwayString = "CREATE TABLE Runway "
                + "(runway_id VARCHAR(8), "
                + "runway_name VARCHAR(30), "
                + "magnetic_heading FLOAT, "
                + "parent VARCHAR(30), "
                + "parent_id VARCHAR(8), "
                + "altitude FLOAT, "
                + "optional_info VARCHAR(150), "
                + "PRIMARY KEY (runway_id, parent_id), "
                + "FOREIGN KEY (parent_id) REFERENCES Airfield (airfield_id))";
        try (Statement createRunwayTableStatement = connect.createStatement()) {
            createRunwayTableStatement.execute(createRunwayString);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Creates the table in the database for storing data associated with a GliderPosition object
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createGliderPosition(Connection connect) throws SQLException {
        String createGliderPositionString = "CREATE TABLE GliderPosition "
                + "(glider_position_id VARCHAR(8), "
                + "position_id VARCHAR(30), "
                + "runway_parent VARCHAR(30), "
                + "runway_parent_id VARCHAR(8), "
                + "airfield_parent VARCHAR(30), "
                + "airfield_parent_id VARCHAR(8), "
                + "altitude FLOAT, "
                + "latitude FLOAT, "
                + "longitude FLOAT, "
                + "optional_info VARCHAR(150), "
                + "PRIMARY KEY (glider_position_id, runway_parent_id, airfield_parent_id), "
                + "FOREIGN KEY (runway_parent_id, airfield_parent_id) REFERENCES Runway (runway_id, parent_id), "
                + "FOREIGN KEY (airfield_parent_id) REFERENCES Airfield (airfield_id))";
        try (Statement createGliderPositionTableStatement = connect.createStatement()) {
            createGliderPositionTableStatement.execute(createGliderPositionString);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Creates the table in the database for storing data associated with a WinchPosition object
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createWinchPosition(Connection connect) throws SQLException {
        String createWinchPositionString = "CREATE TABLE WinchPosition"
                + "(winch_position_id VARCHAR(8), "
                + "name VARCHAR(30), "
                + "runway_parent VARCHAR(30), "
                + "runway_parent_id VARCHAR(8), "
                + "airfield_parent VARCHAR(30), "
                + "airfield_parent_id VARCHAR(8), "
                + "altitude FLOAT, "
                + "latitude FLOAT, "
                + "longitude FLOAT, "
                + "optional_info VARCHAR(150), "
                + "PRIMARY KEY (winch_position_id, runway_parent_id, airfield_parent_id), "
                + "FOREIGN KEY (runway_parent_id, airfield_parent_id) REFERENCES Runway (runway_id, parent_id), "
                + "FOREIGN KEY (airfield_parent_id) REFERENCES Airfield (airfield_id))";
        try (Statement createWinchPositionTableStatement = connect.createStatement()) {
            createWinchPositionTableStatement.execute(createWinchPositionString);
        }catch(SQLException e) {
            throw e;
        }
    }
    
        /**
     * Creates the table in the database for storing data associated with a Parachute object
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createParachute(Connection connect) throws SQLException {
        String createParachuteString = "CREATE TABLE Parachute"
                + "(parachute_id INT, "
                + "lift FLOAT, "
                + "drag FLOAT, "
                + "weight INT, "
                + "PRIMARY KEY (parachute_id))";
        try (Statement createParachuteTableStatement = connect.createStatement()) {
            createParachuteTableStatement.execute(createParachuteString);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Creates the table in the database for storing data associated with a Recent Launch object
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createRecentLaunches(Connection connect) throws SQLException {
        String createRecentLaunchesString = "CREATE TABLE RecentLaunches"
                + "(timestamp BIGINT, "
                + "pilot_id VARCHAR(30), "
                + "n_number VARCHAR(30), "
                + "PRIMARY KEY (timestamp, pilot_id, n_number), "
                + "FOREIGN KEY (pilot_id) REFERENCES Pilot (pilot_id))"; 
        try (Statement createRecentLaunchesTableStatement = connect.createStatement()) {
            createRecentLaunchesTableStatement.execute(createRecentLaunchesString);
        }catch(SQLException e) {
            throw e;
        }
    }
    
        
    /**
     * Creates the table to store a list of previous launches with full information
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createPreviousLaunchesInfo(Connection connect) throws SQLException {
        String createPastLaunchesInfo = "CREATE TABLE PreviousLaunchesInfo"
                + "(start_timestamp BIGINT, "
                + "end_timestamp BIGINT, "
                + "profile_id VARCHAR(30), "
                + "unit_settings VARCHAR(1000), "
                + "display_prefs VARCHAR(1000), " //Guessing at min number of chars
                + "pilot_name VARCHAR(30), "
                + "weight FLOAT, "
                + "capability INT, "
                + "preference INT, "
                + "emergency_contact_info VARCHAR(100), "
                + "emergency_medical_info VARCHAR(150), "
                + "n_number VARCHAR(30), "
                + "type VARCHAR(30), "
                + "owner VARCHAR(30), "
                + "contact_info VARCHAR(60), "
                + "max_gross_weight FLOAT, "
                + "empty_weight FLOAT, "
                + "indicated_stall_speed FLOAT, "
                + "max_winching_speed FLOAT, "
                + "max_weak_link_strength FLOAT, "
                + "max_tension FLOAT, "
                + "airfield_name VARCHAR(30), "
                + "designator VARCHAR(20), "
                + "location VARCHAR(20), "
                + "altitude FLOAT, "
                + "magnetic_variation VARCHAR(20), "
                + "runway_name VARCHAR(30),"          //Used in Runway Object 
                + "magnetic_heading VARCHAR(10),"     //Used in Runway Object 
                + "position_name VARCHAR(30),"        //Used in Position Object 
                + "position_maximumLength FLOAT, "    //Used in Position Object
                + "position_slope FLOAT, "            //Used in Position Object
                + "position_centerline_offset FLOAT, " //Used in Position Object
                + "parachute_number INT, "
                + "lift FLOAT, "
                + "drag FLOAT, "                
                + "FOREIGN KEY (capability) REFERENCES Capability (capability_id), "
                + "FOREIGN KEY (preference) REFERENCES Preference (preference_id), "
                + "FOREIGN KEY (start_timestamp, pilot_name, n_number) "
                + "REFERENCES RecentLaunches(timestamp, pilot_id, n_number), "
                + "PRIMARY KEY (start_timestamp, pilot_name, n_number))";
        try (Statement createPastLaunchesInfoTableStatement = connect.createStatement()) {
            createPastLaunchesInfoTableStatement.execute(createPastLaunchesInfo);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Creates the table in the database for storing data associated with a operator Profile object
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createProfile(Connection connect) throws SQLException {
        String createProfileString = "CREATE TABLE Profile"
                + "(id VARCHAR(30), "
                + "unitSettings VARCHAR(1000), "
                + "displayPrefs VARCHAR(1000), " //Guessing at the min num of chars
                + "PRIMARY KEY (id))"; 
        try (Statement createProfileTableStatement = connect.createStatement()) {
            createProfileTableStatement.execute(createProfileString);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Creates the table to store the possible units of distance
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createDistanceUnits(Connection connect) throws SQLException {
        String createLengthUnitsString = "CREATE TABLE DistanceUnits"
                + "( index INT, "
                + " abbreviation VARCHAR(5), "
                + "PRIMARY KEY (index))";
        String meters = "INSERT INTO DistanceUnits(index, abbreviation) VALUES (0, 'm')";
        String feet = "INSERT INTO DistanceUnits(index, abbreviation) VALUES (1, 'ft')";
        String millimeters = "INSERT INTO DistanceUnits(index, abbreviation) VALUES (2, 'mm')";
        String centimeters = "INSERT INTO DistanceUnits(index, abbreviation) VALUES (3, 'cm')";
        String kilometers = "INSERT INTO DistanceUnits(index, abbreviation) VALUES (4, 'Km')";
        try (Statement createLengthUnitsTableStatement = connect.createStatement()) {
            createLengthUnitsTableStatement.execute(createLengthUnitsString);
            createLengthUnitsTableStatement.executeUpdate(meters);
            createLengthUnitsTableStatement.executeUpdate(feet);
            createLengthUnitsTableStatement.executeUpdate(millimeters);
            createLengthUnitsTableStatement.executeUpdate(centimeters);
            createLengthUnitsTableStatement.executeUpdate(kilometers);
            createLengthUnitsTableStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
     /**
     * Creates the table to store the possible units of tension
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createTensionUnits(Connection connect) throws SQLException {
        String createTensionUnitsString = "CREATE TABLE TensionUnits"
                + "( index INT, "
                + " abbreviation VARCHAR(5), "
                + "PRIMARY KEY (index))";
        String newtons = "INSERT INTO TensionUnits(index, abbreviation) VALUES (0, 'N')";
        String poundForce = "INSERT INTO TensionUnits(index, abbreviation) VALUES (1, 'lbf')";
        String kilogramForce = "INSERT INTO TensionUnits(index, abbreviation) VALUES (2, 'Kgf')";
        try (Statement createTensionUnitsTableStatement = connect.createStatement()) {
            createTensionUnitsTableStatement.execute(createTensionUnitsString);
            createTensionUnitsTableStatement.executeUpdate(newtons);
            createTensionUnitsTableStatement.executeUpdate(poundForce);
            createTensionUnitsTableStatement.executeUpdate(kilogramForce);
        }catch(SQLException e) {
            throw e;
        }
    }
    
     /**
     * Creates the table to store the possible units of weight
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createWeightUnits(Connection connect) throws SQLException {
        String createWeightUnitsString = "CREATE TABLE WeightUnits"
                + "( index INT, "
                + " abbreviation VARCHAR(5), "
                + "PRIMARY KEY (index))";
        String pounds = "INSERT INTO WeightUnits(index, abbreviation) VALUES (0, 'lbs')";
        String kilograms = "INSERT INTO WeightUnits(index, abbreviation) VALUES (1, 'Kg')";
        try (Statement createWeightUnitsTableStatement = connect.createStatement()) {
            createWeightUnitsTableStatement.execute(createWeightUnitsString);
            createWeightUnitsTableStatement.executeUpdate(pounds);
            createWeightUnitsTableStatement.executeUpdate(kilograms);
        }catch(SQLException e) {
            throw e;
        }
    }
    
     /**
     * Creates the table to store the possible units of velocity
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createVelocityUnits(Connection connect) throws SQLException {
        String createVelocityUnitsString = "CREATE TABLE VelocityUnits"
                + "( index INT, "
                + " abbreviation VARCHAR(5), "
                + "PRIMARY KEY (index))";
        String milesPerHour = "INSERT INTO VelocityUnits(index, abbreviation) VALUES (0, 'mph')";
        String kmPerHour = "INSERT INTO VelocityUnits(index, abbreviation) VALUES (1, 'Km/h')";
        String metersPerSecond = "INSERT INTO VelocityUnits(index, abbreviation) VALUES (2, 'm/s')";
        String knots = "INSERT INTO VelocityUnits(index, abbreviation) VALUES (3, 'kn')";
        try (Statement createVelocityUnitsTableStatement = connect.createStatement()) {
            createVelocityUnitsTableStatement.execute(createVelocityUnitsString);
            createVelocityUnitsTableStatement.executeUpdate(milesPerHour);
            createVelocityUnitsTableStatement.executeUpdate(kmPerHour);
            createVelocityUnitsTableStatement.executeUpdate(metersPerSecond);
            createVelocityUnitsTableStatement.executeUpdate(knots);
        }catch(SQLException e) {
            throw e;
        }
    }
    
     /**
     * Creates the table to store the possible units of temperature
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createTemperatureUnits(Connection connect) throws SQLException {
        String createTemperatureUnitsString = "CREATE TABLE TemperatureUnits"
                + "( index INT, "
                + " abbreviation VARCHAR(5), "
                + "PRIMARY KEY (index))";
        String fahrenheit = "INSERT INTO TemperatureUnits(index, abbreviation) VALUES (0, 'F')";
        String celsius = "INSERT INTO TemperatureUnits(index, abbreviation) VALUES (1, 'C')";
        try (Statement createVelocityUnitsTableStatement = connect.createStatement()) {
            createVelocityUnitsTableStatement.execute(createTemperatureUnitsString);
            createVelocityUnitsTableStatement.executeUpdate(fahrenheit);
            createVelocityUnitsTableStatement.executeUpdate(celsius);
        }catch(SQLException e) {
            throw e;
        }
    }
    
     /**
     * Creates the table to store the possible units of pressure
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createPressureUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE PressureUnits"
                + "( index INT, "
                + " abbreviation VARCHAR(5), "
                + "PRIMARY KEY (index))";
        String psi = "INSERT INTO PressureUnits(index, abbreviation) VALUES (0, 'psi')";
        String megapascals = "INSERT INTO PressureUnits(index, abbreviation) VALUES (1, 'Mp')";
        String kilopascals = "INSERT INTO PressureUnits(index, abbreviation) VALUES (2, 'Kp')";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(psi);
            createPressureUnitsTableStatement.executeUpdate(megapascals);
            createPressureUnitsTableStatement.executeUpdate(kilopascals);
        }catch(SQLException e) {
            throw e;
        }
    }
    
     /**
     * Creates the table to store the units for pilot data
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createPilotUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE PilotUnits"
                + "( unit_set INT, "
                + " weight_unit INT, "
                + "PRIMARY KEY (unit_set), "
                + "FOREIGN KEY (weight_unit) REFERENCES WeightUnits (index))";
        String insertRow = "INSERT INTO PilotUnits(unit_set, weight_unit) VALUES (0, 0)";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(insertRow);
            createPressureUnitsTableStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
     /**
     * Creates the table to store the units for Glider data
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createGliderUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE GliderUnits"
                + "( unit_set INT, "
                + " weight_unit INT, "
                + " velocity_unit INT, "
                + " tension_unit INT, "
                + "PRIMARY KEY (unit_set), "
                + "FOREIGN KEY (weight_unit) REFERENCES WeightUnits (index), "
                + "FOREIGN KEY (velocity_unit) REFERENCES VelocityUnits (index) ,"
                + "FOREIGN KEY (tension_unit) REFERENCES TensionUnits (index))";
        String insertRow = "INSERT INTO GliderUnits(unit_set, weight_unit, velocity_unit, tension_unit) VALUES (0, 0, 0, 0)";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(insertRow);
            createPressureUnitsTableStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
     /**
     * Creates the table to store the units for Airfield data
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createAirfieldUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE AirfieldUnits"
                + "( unit_set INT, "
                + " distance_unit INT, "
                + "PRIMARY KEY (unit_set), "
                + "FOREIGN KEY (distance_unit) REFERENCES DistanceUnits (index))";
        String insertRow = "INSERT INTO AirfieldUnits(unit_set, distance_unit) VALUES (0, 0)";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(insertRow);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Creates the table to store the units for Position data
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createPositionUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE PositionUnits"
                + "( unit_set INT, "
                + " distance_unit INT, "
                + "PRIMARY KEY (unit_set), "
                + "FOREIGN KEY (distance_unit) REFERENCES DistanceUnits (index))";
        String insertRow = "INSERT INTO PositionUnits(unit_set, distance_unit) VALUES (0, 0)";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(insertRow);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Creates the table to store the units for Dashboard display data
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createDashboardUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE DashboardUnits"
                + "( unit_set INT, "
                + " distance_unit INT, "
                + " tension_unit INT, "
                + " velocity_unit INT, "
                + " PRIMARY KEY (unit_set), "
                + " FOREIGN KEY (distance_unit) REFERENCES DistanceUnits (index), "
                + " FOREIGN KEY (tension_unit) REFERENCES TensionUnits (index), "
                + " FOREIGN KEY (velocity_unit) REFERENCES VelocityUnits (index))";
        String insertRow = "INSERT INTO DashboardUnits(unit_set, distance_unit, tension_unit, velocity_unit) VALUES (0, 0, 0, 0)";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(insertRow);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Creates the table to store the units for environmental data
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createEnvironmentalUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE EnvironmentalUnits"
                + "( unit_set INT, "
                + " temp_unit INT, "
                + " pressure_unit INT, "
                + " PRIMARY KEY (unit_set), "
                + " FOREIGN KEY (temp_unit) REFERENCES TemperatureUnits (index), "
                + " FOREIGN KEY (pressure_unit) REFERENCES PressureUnits (index))";
        String insertRow = "INSERT INTO EnvironmentalUnits(unit_set, temp_unit, pressure_unit) VALUES (0, 0, 0)";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(insertRow);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Creates the table to store raw CanBus messages
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createMessagesTable(Connection connect) throws SQLException {
        String createMessagesString = "CREATE TABLE Messages"
                + "( timestamp BIGINT, "
                + " message VARCHAR(40))";
        try (Statement createMessagesTableStatement = connect.createStatement()) {
            createMessagesTableStatement.execute(createMessagesString);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Creates the table to store a list of previous launches
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createPreviousLaunchesTable(Connection connect) throws SQLException {
        String createPastLaunches = "CREATE TABLE PreviousLaunches"
                + "( timestamp BIGINT, "
                + " pilot VARCHAR(20), "
                + " glider VARCHAR(20), "
                + " PRIMARY KEY (timestamp, pilot, glider))";
        try (Statement createPastLaunchesTableStatement = connect.createStatement()) {
            createPastLaunchesTableStatement.execute(createPastLaunches);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Creates the table to store the messages associated with previous launches
     * 
     * @param connect the connection to be used for creating the table in the database
     * @throws SQLException if the table can't be created
     */
    private static void createLaunchMessagesTable(Connection connect) throws SQLException {
        String createLaunchMessages = "CREATE TABLE LaunchMessages"
                + "( id INT NOT NULL AUTO_INCREMENT, "
                + " can_message VARCHAR(40),"
                + " can_message_id INT,"
                + " message_timestamp BIGINT,"
                + " launch_timestamp BIGINT, "
                + " pilot VARCHAR(20),"
                + " glider VARCHAR(20), "
                + " PRIMARY KEY (id), "
                + " FOREIGN KEY (launch_timestamp, pilot, glider) "
                + " REFERENCES PreviousLaunches (timestamp, pilot, glider))";
        try (Statement createLaunchMessagesTableStatement = connect.createStatement()) {
            createLaunchMessagesTableStatement.execute(createLaunchMessages);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Drops tables excluding the units tables
     * The order at which these tables are dropped is important because of table references
     * 
     */
    private static void dropTables(Connection connect) throws SQLException {
             
        try(Statement stmt = connect.createStatement()){
            
            try 
            {
                stmt.execute("SELECT * FROM PREVIOUSLAUNCHESINFO");
                stmt.execute("DROP TABLE PREVIOUSLAUNCHESINFO");
            } catch(SQLException e) { }
            try 
            {
                stmt.execute("SELECT * FROM RECENTLAUNCHES");
                stmt.execute("DROP TABLE RECENTLAUNCHES");
            } catch(SQLException e) { }
            try 
            {
                stmt.execute("SELECT * FROM PARACHUTE");
                stmt.execute("DROP TABLE PARACHUTE");
            } catch(SQLException e) { }
            
            try 
            {
                stmt.execute("SELECT * FROM PROFILE");
                stmt.execute("DROP TABLE PROFILE");
            } catch(SQLException e) { }
            
            try 
            {
                stmt.execute("SELECT * FROM WINCHPOSITION");
                stmt.execute("DROP TABLE WINCHPOSITION");
            } catch(SQLException e) { }
            
            try 
            {
                stmt.execute("SELECT * FROM GLIDERPOSITION");
                stmt.execute("DROP TABLE GLIDERPOSITION");
            } catch(SQLException e) { }
            
            try 
            {
                stmt.execute("SELECT * FROM RUNWAY");
                stmt.execute("DROP TABLE RUNWAY");
            } catch(SQLException e) { }
            try 
            {
                stmt.execute("SELECT * FROM AIRFIELD");
                stmt.execute("DROP TABLE AIRFIELD");
            } catch(SQLException e) { }
            try 
            {
                stmt.execute("SELECT * FROM GLIDER");
                stmt.execute("DROP TABLE GLIDER");
                System.out.println("Dropped glider");
            } catch(SQLException e) { }
            try 
            {
                stmt.execute("SELECT * FROM PILOT");
                stmt.execute("DROP TABLE PILOT");
            } catch(SQLException e) { e.printStackTrace(); }
            try 
            {
                stmt.execute("SELECT * FROM PREFERENCE");
                stmt.execute("DROP TABLE PREFERENCE");
            } catch(SQLException e) { e.printStackTrace(); }
            try 
            {
                stmt.execute("SELECT * FROM CAPABILITY");
                stmt.execute("DROP TABLE CAPABILITY");
                System.out.println("Dropped capability");
            } catch(SQLException e) { e.printStackTrace(); }
           
        }catch(SQLException e) {
            //System.out.println(e);
            throw e;
        }
    }
}
