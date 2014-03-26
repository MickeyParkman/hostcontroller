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
            throw e;
        } 
        
        //Build and fill Preference table
        try{
            createPreference(connection);
        }catch(SQLException e) {
            throw e;
        }
        //Build the Pilot table
        try{
            createPilot(connection);
        }catch(SQLException e) {
            throw e;
        }  
        //Build the Sailplane tabel
        try{
             createSailplane(connection);
        }catch(SQLException e) {
            throw e;
        }  
        try{
             createUnits(connection);
        }catch(SQLException e) {
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
    
    private static void createUnits(Connection connect) throws SQLException {
        String createLengthUnitsString = "CREATE TABLE Units"
                + "( index INT, "
                + " abbreviation VARCHAR(5), "
                + "PRIMARY KEY (index))";
        String meters = "INSERT INTO Units(index, abbreviation) VALUES (0, 'm')";
        String feet = "INSERT INTO Units(index, abbreviation) VALUES (1, 'ft')";
        String millimeters = "INSERT INTO Units(index, abbreviation) VALUES (2, 'mm')";
        String centimeters = "INSERT INTO Units(index, abbreviation) VALUES (3, 'cm')";
        String kilometers = "INSERT INTO Units(index, abbreviation) VALUES (4, 'Km')";
        String newtons = "INSERT INTO Units(index, abbreviation) VALUES (5, 'N')";
        String poundForce = "INSERT INTO Units(index, abbreviation) VALUES (6, 'lbf')";
        String kilogramForce = "INSERT INTO Units(index, abbreviation) VALUES (7, 'Kgf')";
        String pounds = "INSERT INTO Units(index, abbreviation) VALUES (8, 'lbs')";
        String kilograms = "INSERT INTO Units(index, abbreviation) VALUES (9, 'Kg')";
        String milesPerHour = "INSERT INTO Units(index, abbreviation) VALUES (10, 'mph')";
        String kmPerHour = "INSERT INTO Units(index, abbreviation) VALUES (11, 'Km/h')";
        String metersPerSecond = "INSERT INTO Units(index, abbreviation) VALUES (12, 'm/s')";
        String knots = "INSERT INTO Units(index, abbreviation) VALUES (13, 'kn')";
        String fahrenheit = "INSERT INTO Units(index, abbreviation) VALUES (14, 'F')";
        String celsius = "INSERT INTO Units(index, abbreviation) VALUES (15, 'C')";
        String psi = "INSERT INTO Units(index, abbreviation) VALUES (16, 'psi')";
        String megapascals = "INSERT INTO Units(index, abbreviation) VALUES (17, 'Mp')";
        String kilopascals = "INSERT INTO Units(index, abbreviation) VALUES (18, 'Kp')";
        try (Statement createLengthUnitsTableStatement = connect.createStatement()) {
            createLengthUnitsTableStatement.execute(createLengthUnitsString);
            createLengthUnitsTableStatement.executeUpdate(meters);
            createLengthUnitsTableStatement.executeUpdate(feet);
            createLengthUnitsTableStatement.executeUpdate(millimeters);
            createLengthUnitsTableStatement.executeUpdate(centimeters);
            createLengthUnitsTableStatement.executeUpdate(kilometers);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    private static void createPilotUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE PilotUnits"
                + "( index INT, "
                + " unit VARCHAR(5), "
                + "PRIMARY KEY (index))";
        String fahrenheit = "INSERT INTO PressureUnits(index, abbreviation) VALUES (0, 'F')";
        String celsius = "INSERT INTO PressureUnits(index, abbreviation) VALUES (1, 'C')";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(fahrenheit);
            createPressureUnitsTableStatement.executeUpdate(celsius);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    private static void createSailplaneUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE PressureUnits"
                + "( index INT, "
                + " abbreviation VARCHAR(5), "
                + "PRIMARY KEY (index))";
        String fahrenheit = "INSERT INTO PressureUnits(index, abbreviation) VALUES (0, 'F')";
        String celsius = "INSERT INTO PressureUnits(index, abbreviation) VALUES (1, 'C')";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(fahrenheit);
            createPressureUnitsTableStatement.executeUpdate(celsius);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    private static void createAirfieldUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE PressureUnits"
                + "( index INT, "
                + " abbreviation VARCHAR(5), "
                + "PRIMARY KEY (index))";
        String fahrenheit = "INSERT INTO PressureUnits(index, abbreviation) VALUES (0, 'F')";
        String celsius = "INSERT INTO PressureUnits(index, abbreviation) VALUES (1, 'C')";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(fahrenheit);
            createPressureUnitsTableStatement.executeUpdate(celsius);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    private static void createDashboardUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE PressureUnits"
                + "( index INT, "
                + " abbreviation VARCHAR(5), "
                + "PRIMARY KEY (index))";
        String fahrenheit = "INSERT INTO PressureUnits(index, abbreviation) VALUES (0, 'F')";
        String celsius = "INSERT INTO PressureUnits(index, abbreviation) VALUES (1, 'C')";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(fahrenheit);
            createPressureUnitsTableStatement.executeUpdate(celsius);
        }catch(SQLException e) {
            throw e;
        }
    }
    
    private static void createEnvironmentalUnits(Connection connect) throws SQLException {
        String createPressureUnitsString = "CREATE TABLE PressureUnits"
                + "( index INT, "
                + " abbreviation VARCHAR(5), "
                + "PRIMARY KEY (index))";
        String fahrenheit = "INSERT INTO PressureUnits(index, abbreviation) VALUES (0, 'F')";
        String celsius = "INSERT INTO PressureUnits(index, abbreviation) VALUES (1, 'C')";
        try (Statement createPressureUnitsTableStatement = connect.createStatement()) {
            createPressureUnitsTableStatement.execute(createPressureUnitsString);
            createPressureUnitsTableStatement.executeUpdate(fahrenheit);
            createPressureUnitsTableStatement.executeUpdate(celsius);
        }catch(SQLException e) {
            throw e;
        }
    }
}