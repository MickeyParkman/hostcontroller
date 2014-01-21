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
    public static void initDatabase() {
        String driverName = "org.apache.jdbc.ClientDriver";
        String databaseConnectionName = "jdbc:derby:WinchHoastDB;create=true";
        
        Connection connection = null;
        Statement createStatment;
        String createCapablityString = "CREATE TABLE Capability"
                + "(capability_id INT,"
                + "capability_string VARCHAR(15))";
        String createPreferenceString = "CREATE TABLE Preference"
                + "(preference_id INT,"
                + "preference_string VARCHAR(15))";
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

        try{
            Class.forName(driverName);
        }catch(java.lang.ClassNotFoundException e) {
            //TODO Add feedback for Class not found
            System.err.print("ClassNotFoundException: ");
        }
        
        try{
            connection = DriverManager.getConnection(databaseConnectionName);
        }catch(Throwable e) {
            //TODO Fix error handling
        }
        
    }
}
