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

/**
 *
 * @author dbennett3
 */
public class DatabaseImporter {
    
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
    
    
    private static void importTable(Connection connect, String zipName) throws SQLException, FileNotFoundException, IOException {
        
        ZipFile zip = new ZipFile(new File(zipName));
        ZipInputStream zin = new ZipInputStream(new FileInputStream(zipName));
        for(ZipEntry e; (e = zin.getNextEntry()) != null;) {

            String fileName = e.toString();
            System.out.println(fileName);
                       
            InputStream is = zip.getInputStream(e);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            if(fileName.contains("CAPABILITY")) {
                System.out.println("Importing to capability");
                
            }else if(fileName.contains("PREFERENCE")) {
                System.out.println("Importing to preference");
                
            }else if(fileName.contains("AIRFIELD")) {
                System.out.println("Importing to airfield");
                
            }
            else if(fileName.contains("GLIDERPOSITION")) {
                System.out.println("Importing to gliderposition");
                
            }
            else if(fileName.contains("PARACHUTE")) {
                System.out.println("Importing to parachute");
                
            }
            else if(fileName.contains("PILOT")) {
                System.out.println("Importing to pilot");
                
            }
            else if(fileName.contains("PROFILE")) {
                System.out.println("Importing to profile");
                
            }
            else if(fileName.contains("RUNWAY")) {
                System.out.println("Importing to runway");
                
            }
            else if(fileName.contains("GLIDER")) {
                System.out.println("Importing to glider");
                
            }else if(fileName.contains("WINCHPOSITION")) {
                System.out.println("Importing to winchposition");
                
            }
            
            String s;
            while((s = br.readLine()) != null) {
                System.out.println(s);
            }   
        }
    }
}
