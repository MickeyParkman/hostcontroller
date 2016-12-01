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
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import javax.swing.JOptionPane;
import DataObjects.*;
import static DatabaseUtilities.DatabaseInitialization.connect;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 *
 * @author dbennett3
 */
public class DatabaseImporter{
    
    private static BufferedReader br;
    private static Connection connection;
    
    public static void importDatabase(File zipFile, List<String> importList) {
        connection = connect();
        try {
            importTable(connection, zipFile, importList);
            
        }catch(IOException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Couldn't import", "Error", JOptionPane.INFORMATION_MESSAGE);
            //e.printStackTrace();
        }
        
        
    }
    
    
    private static void importTable(Connection connect, File file, List<String> importList)
            throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
        
        //System.out.println(importList.toString());
        
        ZipFile zip = new ZipFile(file);
        ZipInputStream zin = new ZipInputStream(new FileInputStream(file));
        for(ZipEntry e; (e = zin.getNextEntry()) != null;) {

            //System.out.println(importList);
            
            String fileName = e.toString();
            //System.out.println(fileName);
                       
            InputStream is = zip.getInputStream(e);
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            if(importList.contains(fileName)) {
                if(fileName.contains("CAPABILITY")) {
                    System.out.println("Importing CAPABILITY");
                    importCapability();
                }else if(fileName.contains("PREFERENCE")) {
                    System.out.println("Importing PREFERENCE");
                    importPreference();
                }else if(fileName.contains("GLIDERPOSITION")) {
                    System.out.println("Importing GLIDERPOSITION");
                    importGliderPosition();
                }else if(fileName.contains("GLIDER")) {
                    System.out.println("Importing SAILPLANE");
                    importGlider();
                }else if(fileName.contains("AIRFIELD")) {
                    System.out.println("Importing AIRFIELD");
                    importAirfield();
                }else if(fileName.contains("RUNWAY")) {
                    System.out.println("Importing RUNWAY");
                    importRunway();
                }else if(fileName.contains("WINCHPOSITION")) {
                    System.out.println("Importing WINCHPOSITION");
                    importWinchPosition();
                }else if(fileName.contains("PARACHUTE")) {
                    System.out.println("Importing PARACHUTE");
                    importParachute();
                }else if(fileName.contains("PILOT")) {
                    System.out.println("Importing PILOT");
                    importPilot();
                }else if(fileName.contains("PROFILE")) {
                    System.out.println("Importing PROFILE");
                    importProfile();
                }else if(fileName.contains("Messages")) {
                    System.out.println("Importing Messages");
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
    
    private static void importGlider() throws IOException {
        String s;
        while((s = br.readLine()) != null) {
            String[] gliderData = s.split(",", -1);
            Sailplane importer = new Sailplane(gliderData[1],gliderData[2], gliderData[3],
                    gliderData[4], Float.parseFloat(gliderData[5]),Float.parseFloat(gliderData[6]), 
                    Float.parseFloat(gliderData[7]), Float.parseFloat(gliderData[8]), 
                    Float.parseFloat(gliderData[9]), Float.parseFloat(gliderData[10]), 
                    Float.parseFloat(gliderData[11]), Boolean.parseBoolean(gliderData[12]), 
                    Boolean.parseBoolean(gliderData[13]), gliderData[14]);
            importer.setId(Integer.parseInt(gliderData[0]));
            try {
                DatabaseEntryInsert.addSailplaneToDB(importer);
            }catch(Exception e)
            {   }
        }
    }
    
    private static void importPilot() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] pilotData = s.split(",",-1);
            Pilot importer = new Pilot(Integer.parseInt(pilotData[0]), pilotData[1], 
                    pilotData[2], pilotData[3], Float.parseFloat(pilotData[4]), pilotData[5], 
                    Float.parseFloat(pilotData[6]), pilotData[7], pilotData[8], pilotData[9]);
            DatabaseEntryInsert.addPilotToDB(importer);
            
        }
    }
    
    private static void importAirfield() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] airfieldData = s.split(",",-1);
            Airfield importer = new Airfield(airfieldData[1], airfieldData[2], 
                    Float.parseFloat(airfieldData[3]), Float.parseFloat(airfieldData[4]), 
                    Float.parseFloat(airfieldData[5]), Float.parseFloat(airfieldData[6]), airfieldData[7]);
            importer.setId(Integer.parseInt(airfieldData[0]));
            DatabaseEntryInsert.addAirfieldToDB(importer);
        }
    }
    
    private static void importRunway() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] runwayData = s.split(",",-1);
            Runway importer = new Runway(runwayData[2], Float.parseFloat(runwayData[3]), 
                    runwayData[4]);
            importer.setId(Integer.parseInt(runwayData[0]));
            importer.setParentId(Integer.parseInt(runwayData[1]));
            DatabaseEntryInsert.addRunwayToDB(importer);
        }
    }
    
    private static void importGliderPosition() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] gliderPositionData = s.split(",",-1);
            GliderPosition importer = new GliderPosition(gliderPositionData[1], 
                    Float.parseFloat(gliderPositionData[2]), Float.parseFloat(gliderPositionData[3]), 
                    Float.parseFloat(gliderPositionData[4]), gliderPositionData[5]);
            importer.setId(Integer.parseInt(gliderPositionData[0]));
            importer.setRunwayParentId(Integer.parseInt(gliderPositionData[1]));
            DatabaseEntryInsert.addGliderPositionToDB(importer);
        }
    }
    
    private static void importWinchPosition() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] winchPositionData = s.split(",",-1);
            WinchPosition importer = new WinchPosition(winchPositionData[2], Float.parseFloat(winchPositionData[3]), 
                    Float.parseFloat(winchPositionData[4]), Float.parseFloat(winchPositionData[5]), 
                    winchPositionData[6]);
            importer.setId(Integer.parseInt(winchPositionData[0]));
            importer.setRunwayParentId(Integer.parseInt(winchPositionData[1]));
            DatabaseEntryInsert.addWinchPositionToDB(importer);
        }
    }
    
    private static void importParachute() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] parachuteData = s.split(",",-1);
            Parachute importer = new Parachute(Integer.parseInt(parachuteData[0]), parachuteData[1], 
                    Float.parseFloat(parachuteData[2]), Float.parseFloat(parachuteData[3]), 
                    Float.parseFloat(parachuteData[4]), parachuteData[5]); 
            DatabaseEntryInsert.addParachuteToDB(importer);
        }
    }
    
    private static void importProfile() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] profileData = s.split(",",-1);
            Operator importer = new Operator(Integer.parseInt(profileData[0]), profileData[1], 
                    profileData[2]); 
            DatabaseEntryInsert.addOperatorToDB(importer);
        }
    }
    
    private static void importMessages() throws IOException, SQLException, ClassNotFoundException {
        String s;
        while((s = br.readLine()) != null) {
            String[] messagesData = s.split(",", -1);
            PreparedStatement insertStatement = connection.prepareStatement(
                "INSERT INTO Preference(timestamp, message) VALUES (?, ?)");
                insertStatement.setString(1, String.valueOf(messagesData[0]));
                insertStatement.setString(2, messagesData[1]);
                insertStatement.executeUpdate();
                insertStatement.close();               
        }
    }
}
