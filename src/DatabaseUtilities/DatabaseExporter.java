/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseUtilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author dbennett3
 */
public class DatabaseExporter {
    
    /**
     * Exports tables to a csv file using a unique timestamp and the name of the name of the table
     * The location of the files is its own folder in the final build 
     * 
     * @param tableName name of the table that is to be exported
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static void exportDatabase(List<String> tableName, String zipName) throws ClassNotFoundException, SQLException {
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
            JOptionPane.showMessageDialog(null, "Correctly loaded the JavaDb ClientDriver, somethin else is wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw e;
        }
        
        try {
            exportTable(connection, tableName, zipName);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't export table", "Error", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private static void exportTable(Connection connect, List<String> names, String zipName) throws SQLException, FileNotFoundException, IOException {
        
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        ZipEntry ze = null;
        
        try {
            fos = new FileOutputStream(zipName);
            zos = new ZipOutputStream(fos);
            
            String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            
            for(String str : names)
            {
                String resultString = "";
                String fileName = "output_" + str + "_" + timestamp + ".csv";
                
                ze = new ZipEntry(fileName);
                zos.putNextEntry(ze);
                
                PreparedStatement ps = connect.prepareStatement("SELECT * FROM " + str);
                ResultSet rs = ps.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
                
                int columnCount = rsmd.getColumnCount();
                
                while(rs.next())
                {
                    resultString = "";
                    for(int i = 1; i <= columnCount; i++)
                    {
                        resultString += rs.getString(i) + ",";
                    }
                    resultString += "\n";
                    
                    byte[] buffer = resultString.getBytes();
                    zos.write(buffer);
                }
                
                zos.closeEntry();
            }
            
        }catch(Exception e)
        { }
        finally{
            zos.close();
            fos.close();
        }
    } 

    
}
