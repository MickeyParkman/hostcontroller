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
import java.util.List;

/**
 *
 * @author dbennett3
 */
public class DatabaseImporter {
    
    private static BufferedReader br;
    
    public static void importDatabase(String zipName) throws ClassNotFoundException, SQLException 
    {
        String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
        String clientDriverName = "org.apache.derby.jdbc.ClientDriver";
        String databaseConnectionName = "jdbc:derby:WinchCommonsTest12DataBase;create=true";
        Connection connection = null;

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
            zipName = "C:\\Users\\dbennett3\\Documents\\importTest.zip";
            importTable(connection, zipName);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't import", "Error", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
        
        
    }
    
    
    private static void importTable(Connection connect, String zipName) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
        
        ZipFile zip = new ZipFile(new File(zipName));
        ZipInputStream zin = new ZipInputStream(new FileInputStream(zipName));
        for(ZipEntry e; (e = zin.getNextEntry()) != null;) {

            String fileName = e.toString();
            //System.out.println(fileName);
                       
            InputStream is = zip.getInputStream(e);
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            if(fileName.contains("CAPABILITY")) {
                //System.out.println("Importing to capability");
                //importCapability();
                
            }else if(fileName.contains("PREFERENCE")) {
                //System.out.println("Importing to preference");
                
            }else if(fileName.contains("AIRFIELD")) {
                //System.out.println("Importing to airfield");
                
            }
            else if(fileName.contains("GLIDERPOSITION")) {
                //System.out.println("Importing to gliderposition");
                
            }
            else if(fileName.contains("PARACHUTE")) {
                //System.out.println("Importing to parachute");
                
            }
            else if(fileName.contains("PILOT")) {
                System.out.println("Importing to pilot");
                importPilot();
            }
            else if(fileName.contains("PROFILE")) {
                //System.out.println("Importing to profile");
                
            }
            else if(fileName.contains("RUNWAY")) {
                //System.out.println("Importing to runway");
                
            }

            else if(fileName.contains("GLIDER")) {
                System.out.println("Importing to glider");
                
            }else if(fileName.contains("WINCHPOSITION")) {
                //System.out.println("Importing to winchposition");
                
            }
            
               
        }
    }
    
    private static void importCapability() throws IOException {
        String s;
        while((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }
    
    private static void importPilot() throws IOException, SQLException, ClassNotFoundException {
        boolean isNewPilot = true;
        List<Pilot> currentPilots = DatabaseDataObjectUtilities.getPilots();
        
        String s;
        br.readLine();
        while((s = br.readLine()) != null) {
            String[] pilotData = s.split(",");
            System.out.println(pilotData[8]);
            System.out.println(pilotData[9]);
            
            Pilot importer = new Pilot(pilotData[0], pilotData[1], pilotData[2], pilotData[3], Integer.parseInt(pilotData[4]), pilotData[5], pilotData[6], pilotData[7], pilotData[8], pilotData[9]);
            
            for(Pilot p: currentPilots)
            {
                if(p.pilotEquals(importer))
                {
                    isNewPilot = false;
                    break;
                }
            }
            if(isNewPilot)
                DatabaseDataObjectUtilities.addPilotToDB(importer);
            //System.out.println(s);
        }
    }
}
