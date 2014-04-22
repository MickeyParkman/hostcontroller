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
 * @author awilliams5
 */
public class DatabaseInitialization {
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
            JOptionPane.showMessageDialog(null, "Can't load JavaDb ClientDriver");
            throw e;
        }
    
        //Try to connect to the specified database
        try{
            connection = DriverManager.getConnection(databaseConnectionName);
        }catch(SQLException e) {
            //TODO Fix error handling
            JOptionPane.showMessageDialog(null, "Loaded JavaDb ClientDriver, somethin else wrong");
            throw e;
        }
        
        
        //Build and fill Capability table
        try{
            createCapability(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        } 
        
        //Build and fill Preference table
        try{
            createPreference(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        //Build the Pilot table
        try{
            createPilot(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }  
        //Build the Sailplane tabel
        try{
             createSailplane(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }  
        try{
             createDistanceUnits(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        try{
             createTensionUnits(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        try{
             createVelocityUnits(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        try{
             createWeightUnits(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        try{
             createTemperatureUnits(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        try{
             createPressureUnits(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        try{
             createPilotUnits(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        try{
             createSailplaneUnits(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        try{
             createAirfieldUnits(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        try{
             createPositionUnits(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        try{
             createDashboardUnits(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        try{
             createEnvironmentalUnits(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        try{
             createMessageBlackBoxTable(connection);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            throw e;
        }
        connection.close();
    }
    
    private static void createPilot(Connection connect) throws SQLException {
        String createPilotString = "CREATE TABLE Pilot"
                + "(name VARCHAR(30) NOT NULL,"
                + "weight INT,"
                + "capability INT,"
                + "preference INT,"
                + "emergency_contact_info VARCHAR(100),"
                + "emergency_medical_info VARCHAR(150),"
                + "PRIMARY KEY (name),"
                + "FOREIGN KEY (capability) REFERENCES Capability (capability_id),"
                + "FOREIGN KEY (preference) REFERENCES Preference (preference_id))";
        
        
        try (Statement createPilotTableStatement = connect.createStatement()) {
            createPilotTableStatement.execute(createPilotString);
        }catch(SQLException e) {
            throw e;
        }        
    }
    
    private static void createSailplane(Connection connect) throws SQLException {
        String createSailplaneString = "CREATE TABLE Sailplane"
                + "(n_number VARCHAR(20),"
                + "type VARCHAR(30),"
                + "owner VARCHAR(30),"
                + "contact_info VARCHAR(60),"
                + "max_gross_weight INT,"
                + "empty_weight INT,"
                + "indicated_stall_speed INT,"
                + "max_winching_speed INT,"
                + "max_weak_link_strength INT,"
                + "max_tension INT,"
                + "PRIMARY KEY (n_number))";
        try (Statement createPilotTableStatement = connect.createStatement()) {
            createPilotTableStatement.execute(createSailplaneString);
        }catch(SQLException e) {
            throw e;
        }
    }
        
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
    
    private static void createAirfield(Connection connect) throws SQLException {
        String createAirfieldString = "CREATE TABLE Airfield"
                + "( name VARCHAR(30),"
                + "designator VARCHAR(20),"
                + "location VARCHAR(20),"
                + "altitude VARCHAR(20),"
                + "magneticVariation VARCHAR(20),"
                + "PRIMARY KEY (name))";
        try (Statement createAirfieldTableStatement = connect.createStatement()) {
            createAirfieldTableStatement.execute(createAirfieldString);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    private static void createRunway(Connection connect) throws SQLException {
        String createRunwayString = "CREATE TABLE Runway"
                + "( magnetic_heading VARCHAR(10), "
                + "parent VARCHAR(30), "
                + "PRIMARY KEY (magnetic_heading), "
                + "FOREIGN KEY (parent) REFERENCES Airfield (name))";
        try (Statement createRunwayTableStatement = connect.createStatement()) {
            createRunwayTableStatement.execute(createRunwayString);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    private static void createPosition(Connection connect) throws SQLException {
        String createRunwayString = "CREATE TABLE Position"
                + "( max_length FLOAT(10,6), "
                + " slope FLOAT(10,6),"
                + " centerline_offset FLOAT(10,6), "
                + "PRIMARY KEY (name), "
                + "FOREIGN KEY (parent) REFERENCES Airfield (name))";
        try (Statement createRunwayTableStatement = connect.createStatement()) {
            createRunwayTableStatement.execute(createRunwayString);
        }catch(SQLException e) {
            throw e;
        }
    }
    
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
    
    private static void createSailplaneUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE SailplaneUnits"
                + "( unit_set INT, "
                + " weight_unit INT, "
                + " velocity_unit INT, "
                + " tension_unit INT, "
                + "PRIMARY KEY (unit_set), "
                + "FOREIGN KEY (weight_unit) REFERENCES WeightUnits (index), "
                + "FOREIGN KEY (velocity_unit) REFERENCES VelocityUnits (index) ,"
                + "FOREIGN KEY (tension_unit) REFERENCES TensionUnits (index))";
        String insertRow = "INSERT INTO SailplaneUnits(unit_set, weight_unit, velocity_unit, tension_unit) VALUES (0, 0, 0, 0)";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(insertRow);
            createPressureUnitsTableStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
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
    
    private static void createMessageBlackBoxTable(Connection connect) throws SQLException {
        String createBlackBoxString = "CREATE TABLE BlackBoxMessages"
                + "( timestamp BIGINT, "
                + " message VARCHAR(40))";
        try (Statement createBlackBoxTableStatement = connect.createStatement()) {
            createBlackBoxTableStatement.execute(createBlackBoxString);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    private static void createPreviousLaunchesTable(Connection connect) throws SQLException {
        String createPastLaunches = "CREATE TABLE PreviousLaunches"
                + "( timestamp BIGINT, "
                + " pilot VARCHAR(20), "
                + " sailplane VARCHAR(20), "
                + " PRIMARY KEY (timestamp, pilot, sailplane))";
        try (Statement createPastLaunchesTableStatement = connect.createStatement()) {
            createPastLaunchesTableStatement.execute(createPastLaunches);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    private static void createLaunchMessagesTable(Connection connect) throws SQLException {
        String createLaunchMessages = "CREATE TABLE LaunchMessages"
                + "( id INT NOT NULL AUTO_INCREMENT, "
                + " can_message VARCHAR(40),"
                + " can_message_id INT,"
                + " message_timestamp BIGINT,"
                + " launch_timestamp BIGINT, "
                + " pilot VARCHAR(20),"
                + " sailplane VARCHAR(20), "
                + " PRIMARY KEY (id), "
                + " FOREIGN KEY (launch_timestamp, pilot, sailplane) "
                + " REFERENCES PreviousLaunches (timestamp, pilot, sailplane))";
        try (Statement createLaunchMessagesTableStatement = connect.createStatement()) {
            createLaunchMessagesTableStatement.execute(createLaunchMessages);
        }catch(SQLException e) {
            throw e;
        }
    }
}