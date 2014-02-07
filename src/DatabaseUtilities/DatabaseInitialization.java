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
        String databaseConnectionName = "jdbc:derby:WinchCommonsTest11DataBase;create=true";
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
                + "capability_string VARCHAR(15),"
                + "PRIMARY KEY (capability_id))";
        String addStudent = "INSERT INTO Capability(capability_id, capability_string) VALUES (1, 'Student')";
        String addProficient = "INSERT INTO Capability(capability_id, capability_string) VALUES (2, 'Proficient')";
        String addAdvanced = "INSERT INTO Capability(capability_id, capability_string) VALUES (3, 'Advanced')";
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
                + "preference_string VARCHAR(15),"
                + "PRIMARY KEY (preference_id))";
        String addMild = "INSERT INTO Preference(preference_id, preference_string) VALUES (1, 'Mild')";
        String addNominal = "INSERT INTO Preference(preference_id, preference_string) VALUES (2, 'Nominal')";
        String addPerformance = "INSERT INTO Preference(preference_id, preference_string) VALUES (3, 'Perfomrance')";
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
         String databaseConnectionName = "jdbc:derby:WinchCommonsDB;";
         String clientDriverName = "org.apache.derby.jdbc.ClientDriver";
         String removePreferenceString = "DROP TABLE Preference";
         String removeCapabilityString = "DROP TABLE Capability";
         String removePilotString = "DROP TABLE Pilot";
         Connection connection = null;

         //Check for DB drivers
        try{
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
    
        //Try to connect to the specified database
        try{
            connection = DriverManager.getConnection(databaseConnectionName);
            Statement removeTableStatement = connection.createStatement();
            dropATable(removeTableStatement, removePreferenceString);
            dropATable(removeTableStatement, removeCapabilityString);
            dropATable(removeTableStatement, removePilotString);
            connection.close();
            connection = DriverManager.getConnection(databaseConnectionName + "drop=true");
        }catch(SQLException e) {
            //TODO Fix error handling
            throw e;
        }
        connection.close();
     }
     
     private static void dropATable(Statement stmt, String removeString) {
         try {
             stmt.executeQuery(removeString);
         }catch (SQLException e) {
             //Do nothing because table doesn't exist
         }
     }
}