/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import java.sql.*;
/**
 *
 * @author awilliams5
 */
public class DatabaseInitialization {
    public static void initDatabase() throws ClassNotFoundException, SQLException {
        String driverName = "org.apache.jdbc.ClientDriver";
        String databaseConnectionName = "jdbc:derby:WinchCommonsDB;create=true";
        Connection connection = null;
        Statement createStatment;
        
        //Check for DB drivers
        try{
            Class.forName(driverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
    
        //Try to connect to the specified database
        try{
            connection = DriverManager.getConnection(databaseConnectionName);
        }catch(SQLException e) {
            //TODO Fix error handling
            throw e;
        }
        
        //Build the Pilot table
        try{
            createPilot(connection);
        }catch(SQLException e) {
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
        connection.close();
    }
    
    private static void createPilot(Connection connect) throws SQLException {
        String createPilotString = "CREATE TABLE Pilot"
                + "(name VARCHAR(30) NOT NULL,"
                + "weight INT,"
                + "capability INT,"
                + "preference INT"
                + "emergency_contact_info VARCHAR(100),"
                + "emergency_medical_info VARCHAR(150),"
                + "RIMARY KEY (name),"
                + "FOREIGN KEY capability REFERENCES Capability(capability_id),"
                + "FOREIGN KEY preference REFERENCES Preference(preference_id))";
        
        try {
            Statement createPilotTableStatement = connect.createStatement();
            createPilotTableStatement.execute(createPilotString);
            createPilotTableStatement.close();
        }catch(SQLException e) {
            throw e;
        }        
    }
    
    private static void createCapability(Connection connect) throws SQLException {
        String createCapablityString = "CREATE TABLE Capability"
                + "(capability_id INT,"
                + "capability_string VARCHAR(15))";
        String addStudent = "INSERT INTO Capability(capability_id, cpability_string) VALUES Capability(1, 'Student')";
        String addProficient = "INSERT INTO Capability(capability_id, cpability_string) VALUES (2, 'Proficient')";
        String addAdvanced = "INSERT INTO Capability(capability_id, cpability_string) VALUES (3, 'Advanced')";
        try {
            Statement createCapabilityTableStatement = connect.createStatement();
            createCapabilityTableStatement.execute(createCapablityString);
            createCapabilityTableStatement.executeUpdate(addStudent);
            createCapabilityTableStatement.executeUpdate(addProficient);
            createCapabilityTableStatement.executeUpdate(addAdvanced);
            createCapabilityTableStatement.close();
        }catch(SQLException e) {
            throw e;
        }        
    }
    
    private static void createPreference(Connection connect) throws SQLException {
        String createPreferenceString = "CREATE TABLE Preference"
                + "(preference_id INT,"
                + "preference_string VARCHAR(15))";
        String addMild = "INSERT INTO Capability(preference_id, preference_string) VALUES Capability(1, 'Mild')";
        String addNominal = "INSERT INTO Capability(preference_id, preference_string) VALUES (2, 'Nominal')";
        String addPerformance = "INSERT INTO Capability(preference_id, preference_string) VALUES (3, 'Perfomrance')";
        try {
            Statement createPreferenceTableStatement = connect.createStatement();
            createPreferenceTableStatement.execute(createPreferenceString);
            createPreferenceTableStatement.executeUpdate(addMild);
            createPreferenceTableStatement.executeUpdate(addNominal);
            createPreferenceTableStatement.executeUpdate(addPerformance);
            createPreferenceTableStatement.close();
        }catch(SQLException e) {
            throw e;
        }        
    }
    
     public static void deleteDB() throws SQLException, ClassNotFoundException{
         String databaseConnectionName = "jdbc:derby:WinchCommonsDB;drop=true";
         String driverName = "org.apache.jdbc.ClientDriver";
         Connection connection = null;

         //Check for DB drivers
        try{
            Class.forName(driverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
    
        //Try to connect to the specified database
        try{
            connection = DriverManager.getConnection(databaseConnectionName);
        }catch(SQLException e) {
            //TODO Fix error handling
            throw e;
        }
        connection.close();
     }
}