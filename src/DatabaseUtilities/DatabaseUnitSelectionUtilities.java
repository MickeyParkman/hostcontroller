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
    
    public static int getSailplaneWeightUnit() throws ClassNotFoundException {
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
                + "FROM SailplaneUnits "
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
    
    public static int getSailplaneVelocityUnit() throws ClassNotFoundException {
       int velocityUnit = 0;
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            Statement stmt = connect.createStatement();
            ResultSet thePilots = stmt.executeQuery("SELECT velocity_unit "
                + "FROM SailplaneUnits "
                + "WHERE unit_set = 0");
            while(thePilots.next()) {
                
                try {
                    velocityUnit = Integer.parseInt(thePilots.getString(1));
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
        return velocityUnit;
    }
    
    public static int getSailplaneTensionUnit() throws ClassNotFoundException {
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
            ResultSet thePilots = stmt.executeQuery("SELECT tension_unit "
                + "FROM SailplaneUnits "
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
    
    public static int getAirfieldDistanceUnit() throws ClassNotFoundException {
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
            ResultSet thePilots = stmt.executeQuery("SELECT distance_unit "
                + "FROM AirfieldUnits "
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
    
    public static int getPositionDistanceUnit() throws ClassNotFoundException {
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
            ResultSet thePilots = stmt.executeQuery("SELECT distance_unit "
                + "FROM PositionUnits "
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
    
    public static int getDashboardDistanceUnit() throws ClassNotFoundException {
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
            ResultSet thePilots = stmt.executeQuery("SELECT distance_unit "
                + "FROM DashboardUnits "
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
    
    public static int getDashboardTensionUnit() throws ClassNotFoundException {
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
            ResultSet thePilots = stmt.executeQuery("SELECT tension_unit "
                + "FROM DashboardUnits "
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
    
    public static int getDashboardVelocityUnit() throws ClassNotFoundException {
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
            ResultSet thePilots = stmt.executeQuery("SELECT velocity_unit "
                + "FROM DashboardUnits "
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
    
    public static int getEnvironmentalTempUnit() throws ClassNotFoundException {
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
            ResultSet thePilots = stmt.executeQuery("SELECT temp_unit "
                + "FROM EnvironmentalUnits "
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
    
    public static int getEnvironmentalPressureUnit() throws ClassNotFoundException {
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
            ResultSet thePilots = stmt.executeQuery("SELECT pressure_unit "
                + "FROM EnvironmentalUnits "
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
    
    public static void storeSailplanesUnits(int[] unitIndex) throws ClassNotFoundException, SQLException {
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
            String updatePilotString = "UPDATE SailplaneUnits "
                                        + "SET weight_unit = " + unitIndex[0] + ", "
                                        + "velocity_unit= " + unitIndex[1] + ", "
                                        + "tension_unit= " + unitIndex[2]
                                        + "WHERE unit_set = 0";
            updatePilotTabelStmt.executeUpdate(updatePilotString);
            updatePilotTabelStmt.close();
            connect.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    public static void storeAirfieldUnits(int unitIndex) throws ClassNotFoundException, SQLException {
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
            String updatePilotString = "UPDATE AirfieldUnits "
                                        + "SET distance_unit = " + unitIndex
                                        + "WHERE unit_set = 0";
            updatePilotTabelStmt.executeUpdate(updatePilotString);
            updatePilotTabelStmt.close();
            connect.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    public static void storePositionUnits(int unitIndex) throws ClassNotFoundException, SQLException {
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
            String updatePilotString = "UPDATE PositionUnits "
                                        + "SET distance_unit = " + unitIndex
                                        + "WHERE unit_set = 0";
            updatePilotTabelStmt.executeUpdate(updatePilotString);
            updatePilotTabelStmt.close();
            connect.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    public static void storeDashboardUnits(int[] unitIndex) throws ClassNotFoundException, SQLException {
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
            String updatePilotString = "UPDATE DashboardUnits "
                                        + "SET distance_unit = " + unitIndex[0] + ", "
                                        + "tension_unit= " + unitIndex[1] + ", "
                                        + "velocity_unit= " + unitIndex[3]
                                        + "WHERE unit_set = 0";
            updatePilotTabelStmt.executeUpdate(updatePilotString);
            updatePilotTabelStmt.close();
            connect.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    public static void storeEnvironmentalUnits(int[] unitIndex) throws ClassNotFoundException, SQLException {
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
            String updatePilotString = "UPDATE EnvironmentalUnits "
                                        + "SET temp_unit = " + unitIndex[0] + ", "
                                        + "pressure_unit= " + unitIndex[1]
                                        + "WHERE unit_set = 0";
            updatePilotTabelStmt.executeUpdate(updatePilotString);
            updatePilotTabelStmt.close();
            connect.close();
        }catch(SQLException e) {
            throw e;
        }
    }
}
