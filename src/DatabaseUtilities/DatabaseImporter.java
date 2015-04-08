/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import javax.swing.JOptionPane;
import DataObjects.*;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 *
 * @author dbennett3
 */
public class DatabaseImporter {
    
    private static BufferedReader br;
    private static Connection connection;
    
    public static void importDatabase(String zipName, List<String> importList) throws ClassNotFoundException, SQLException 
    {
        String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
        String clientDriverName = "org.apache.derby.jdbc.ClientDriver";
        String databaseConnectionName = "jdbc:derby:WinchCommonsTest12DataBase;create=true";
        connection = null;

        //Check for DB drivers
        try {
            Class.forName(clientDriverName);
            Class.forName(driverName);
        }catch(java.lang.ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Can't load JavaDb ClientDriver", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw e;
        }

        //try to connect
        try {
            connection = DriverManager.getConnection(databaseConnectionName);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Correctly loaded the JavaDb ClientDriver, something else is wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw e;
        }
        
        try {
            importTable(connection, zipName, importList);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't import", "Error", JOptionPane.INFORMATION_MESSAGE);
            //e.printStackTrace();
        }
        
        
    }
    
    
    private static void importTable(Connection connect, String zipName, List<String> importList) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
        
        ZipFile zip = new ZipFile(new File(zipName));
        ZipInputStream zin = new ZipInputStream(new FileInputStream(zipName));
        for(ZipEntry e; (e = zin.getNextEntry()) != null;) {

            //System.out.println(importList);
            
            String fileName = e.toString();
            //System.out.println(fileName);
                       
            InputStream is = zip.getInputStream(e);
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            if(importList.contains(fileName)) {
                if(fileName.contains("CAPABILITY")) {
                    //System.out.println("Importing CAPABILITY");
                    importCapability();
                }else if(fileName.contains("PREFERENCE")) {
                    //System.out.println("Importing PREFERENCE");
                    importPreference();
                }else if(fileName.contains("AIRFIELD")) {
                    //System.out.println("Importing AIRFIELD");
                    importAirfield();
                }else if(fileName.contains("RUNWAY")) {
                    //System.out.println("Importing RUNWAY");
                    importRunway();
                }else if(fileName.contains("GLIDERPOSITION")) {
                    //System.out.println("Importing GLIDERPOSITION");
                    importGliderPosition();
                }else if(fileName.contains("WINCHPOSITION")) {
                    //System.out.println("Importing WINCHPOSITION");
                    importWinchPosition();
                }else if(fileName.contains("PARACHUTE")) {
                    //System.out.println("Importing PARACHUTE");
                    importParachute();
                }else if(fileName.contains("PILOT")) {
                    //System.out.println("Importing PILOT");
                    importPilot();
                }else if(fileName.contains("PROFILE")) {
                    //System.out.println("Importing PROFILE");
                    importProfile();
                }else if(fileName.contains("SAILPLANE")) {
                    //System.out.println("Importing SAILPLANE");
                    importSailplane();
                }else if(fileName.contains("Messages")) {
                    //System.out.println("Importing Messages");
                    importMessages();
                }
            }
            
               
        }
    }
    
    private static void importCapability() throws IOException {
        String s;
        while((s = br.readLine()) != null) {
            String[] capabilityData = s.split(",", -1);
            
            try {
                PreparedStatement insertStatement = connection.prepareStatement(
                "INSERT INTO Capability(capability_id, capability_string)"
                        + "VALUES (?, ?)");
                insertStatement.setString(1, capabilityData[0]);
                insertStatement.setString(2, capabilityData[1]);
                insertStatement.executeUpdate();
                insertStatement.close();               
            }catch(Exception e)
            {   }
            
        }
    }
    
    private static void importPreference() throws IOException {
        String s;
        while((s = br.readLine()) != null) {
            String[] capabilityData = s.split(",", -1);
            
            try {
                PreparedStatement insertStatement = connection.prepareStatement(
                "INSERT INTO Preference(preference_id, preference_string)"
                        + "VALUES (?, ?)");
                insertStatement.setString(1, capabilityData[0]);
                insertStatement.setString(2, capabilityData[1]);
                insertStatement.executeUpdate();
                insertStatement.close();               
            }catch(Exception e)
            {   }
        }
    }
    
    private static void importPilot() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] pilotData = s.split(",",-1);
            Pilot importer = new Pilot(pilotData[0], pilotData[1], pilotData[2], pilotData[3], Float.parseFloat(pilotData[4]), pilotData[5], pilotData[6], pilotData[7], pilotData[8], pilotData[9]);
            try {
                DatabaseDataObjectUtilities.addPilotToDB(importer);
            } catch(SQLIntegrityConstraintViolationException e)
            {   }
        }
    }
    
    private static void importAirfield() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] airfieldData = s.split(",",-1);
            Airfield importer = new Airfield(airfieldData[1], airfieldData[2], Float.parseFloat(airfieldData[3]), Float.parseFloat(airfieldData[4]), 
                    Float.parseFloat(airfieldData[5]), Float.parseFloat(airfieldData[6]), airfieldData[7]);
            importer.setId(airfieldData[0]);
            try {
                DatabaseDataObjectUtilities.addAirfieldToDB(importer);
            } catch(SQLIntegrityConstraintViolationException e)
            {   }
        }
    }
    
    private static void importRunway() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] runwayData = s.split(",",-1);
            Runway importer = new Runway(runwayData[1], runwayData[2], runwayData[3], Float.parseFloat(runwayData[5]), runwayData[6]);
            importer.setId(runwayData[0]);
            importer.setParentId(runwayData[4]);
            try {
                DatabaseDataObjectUtilities.addRunwayToDB(importer);
            } catch(SQLIntegrityConstraintViolationException e)
            {   }
        }
    }
    
    private static void importGliderPosition() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] gliderPositionData = s.split(",",-1);
            GliderPosition importer = new GliderPosition(gliderPositionData[1], gliderPositionData[2], gliderPositionData[4], Float.parseFloat(gliderPositionData[6]), 
                    Float.parseFloat(gliderPositionData[7]), Float.parseFloat(gliderPositionData[8]), gliderPositionData[9]);
            importer.setId(gliderPositionData[0]);
            importer.setAirfieldParentId(gliderPositionData[5]);
            importer.setRunwayParentId(gliderPositionData[3]);
            try {
                DatabaseDataObjectUtilities.addGliderPositionToDB(importer);
            } catch(SQLIntegrityConstraintViolationException e)
            {   }
        }
    }
    
    private static void importWinchPosition() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] winchPositionData = s.split(",",-1);
            WinchPosition importer = new WinchPosition(winchPositionData[1], winchPositionData[2], winchPositionData[4], Float.parseFloat(winchPositionData[6]), 
                    Float.parseFloat(winchPositionData[7]), Float.parseFloat(winchPositionData[8]), winchPositionData[9]);
            importer.setId(winchPositionData[0]);
            importer.setAirfieldParentId(winchPositionData[5]);
            importer.setRunwayParentId(winchPositionData[3]);
            try {
                DatabaseDataObjectUtilities.addWinchPositionToDB(importer);
            } catch(SQLIntegrityConstraintViolationException e)
            {   }
        }
    }
    
    private static void importParachute() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] parachuteData = s.split(",",-1);
            Parachute importer = new Parachute(Integer.parseInt(parachuteData[0]), Float.parseFloat(parachuteData[1]), Float.parseFloat(parachuteData[2]), Integer.parseInt(parachuteData[3])); 
                    
            try {
                DatabaseDataObjectUtilities.addParachuteToDB(importer);
            } catch(SQLIntegrityConstraintViolationException e)
            {   }
        }
    }
    
    private static void importProfile() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] profileData = s.split(",",-1);
            Profile importer = new Profile(profileData[0], profileData[1], profileData[2]); 
                    
            try {
                DatabaseDataObjectUtilities.addProfileToDB(importer);
            } catch(SQLIntegrityConstraintViolationException e)
            {   }
        }
    }
    
    private static void importSailplane() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] gliderData = s.split(",",-1);
            Sailplane importer = new Sailplane(gliderData[1], gliderData[2], Float.parseFloat(gliderData[3]), Float.parseFloat(gliderData[4]), 
                    Float.parseFloat(gliderData[5]), Float.parseFloat(gliderData[6]), Float.parseFloat(gliderData[7]), Float.parseFloat(gliderData[8]),
                    Float.parseFloat(gliderData[9]), Boolean.valueOf(gliderData[10]), Boolean.valueOf(gliderData[11]), gliderData[12]);
            importer.setId(gliderData[0]);
            try {
                DatabaseDataObjectUtilities.addSailplaneToDB(importer);
            } catch(SQLIntegrityConstraintViolationException e)
            {   }
        }
    }
    
    private static void importMessages() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] messagesData = s.split(",", -1);
            
            try {
                PreparedStatement insertStatement = connection.prepareStatement(
                "INSERT INTO Preference(timestamp, message)"
                        + "VALUES (?, ?)");
                insertStatement.setString(1, String.valueOf(messagesData[0]));
                insertStatement.setString(2, messagesData[1]);
                insertStatement.executeUpdate();
                insertStatement.close();               
            }catch(Exception e)
            {   }
        }
    }
}
