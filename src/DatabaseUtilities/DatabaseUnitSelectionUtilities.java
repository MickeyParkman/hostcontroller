/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import DataObjects.Pilot;
import ParameterSelection.Capability;
import ParameterSelection.Preference;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author awilliams5
 */
public class DatabaseUnitSelectionUtilities {
    private static String databaseConnectionName = "jdbc:derby:WinchCommonsTest12DataBase;";
    private static String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String clientDriverName = "org.apache.derby.jdbc.ClientDriver";
    
    public static int getPilotWeightUnit() throws ClassNotFoundException {
        int weightUnit = 0;
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            Statement stmt = connect.createStatement();
            ResultSet thePilots = stmt.executeQuery("SELECT weight_unit "
                + "FROM PilotUnits "
                + "WHERE unit_set = 0");
            while(thePilots.next()) {
                
                try {
                    weightUnit = Integer.parseInt(thePilots.getString(1));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
            }
            thePilots.close();
            stmt.close();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return -1;            
        }
        return weightUnit;
    }
    
    public static int getSailplaneWeightUnit() {
        return 0;
    }
    
    public static int getSailplaneVelocityUnit() {
        return 0;
    }
    
    public static int getSailplaneTensionUnit() {
        return 0;
    }
    
    public static int getAirfieldDistanceUnit() {
        return 0;
    }
    
    public static int getPositionDistanceUnit() {
        return 0;
    }
    
    public static int getDashboardDistanceUnit() {
        return 0;
    }
    
    public static int getDashboardTensionUnit() {
        return 0;
    }
    
    public static int getDashboardVelocityUnit() {
        return 0;
    }
    
    public static int getEnvironmentalTempUnit() {
        return 0;
    }
    
    public static int getEnvironmentalPressureUnit() {
        return 0;
    }
    
    
    
    
    
    public static void storePilotUnits(int unitIndex) throws ClassNotFoundException, SQLException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement updatePilotTabelStmt = connect.createStatement();
            String updatePilotString = "UPDATE PilotUnits "
                                        + "SET weight_unit = " + unitIndex
                                        + "WHERE unit_set = 0";
            updatePilotTabelStmt.executeUpdate(updatePilotString);
            updatePilotTabelStmt.close();
            connect.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    public static void storeSailplaneWeightUnit(int unitIndex) {
        
    }
    
    public static void storeSailplaneVelocityUnit(int unitIndex) {
        
    }
    
    public static void storeSailplaneTensionUnit(int unitIndex) {
        
    }
    
    public static void storeAirfieldDistanceUnit(int unitIndex) {
        
    }
    
    public static void storePositionDistanceUnit(int unitIndex) {
        
    }
    
    public static void storeDashboardDistanceUnit(int unitIndex) {
        
    }
    
    public static void storeDashboardTensionUnit(int unitIndex) {
        
    }
    
    public static void storeDashboardVelocityUnit(int unitIndex) {
        
    }
    
    public static void storeEnvironmentalTempUnit(int unitIndex) {
        
    }
    
    public static void storeEnvironmentalPressureUnit(int unitIndex) {
        
    }
    
}
