/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import DataObjects.Pilot;
import ParameterSelection.Capability;
import ParameterSelection.Preference;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author awilliams5
 */
public class DatabaseUtilities {
    private static String databaseConnectionName = "jdbc:derby:WinchCommonsTest12DataBase;";
    private static String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String clientDriverName = "org.apache.derby.jdbc.ClientDriver";

    
    public static void addPilotToDB(Pilot thePilot) throws SQLException, ClassNotFoundException {
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
            PreparedStatement pilotInsertStatement = connect.prepareStatement(
                    "INSERT INTO Pilot(name, weight, capability, preference,"
                            + " emergency_contact_info, emergency_medical_info)"
                            + "values (?,?,?,?,?,?)");
            pilotInsertStatement.setString(1, thePilot.getFirstName() + " " +
                    thePilot.getLastName());
            pilotInsertStatement.setString(2, String.valueOf(thePilot.getWeight()));
            pilotInsertStatement.setString(3, String.valueOf(Preference.convertPreferenceStringToNum(thePilot.getCapability())));
            System.out.println(String.valueOf(Preference.convertPreferenceStringToNum(thePilot.getCapability())));
            pilotInsertStatement.setString(4, String.valueOf(Preference.convertPreferenceStringToNum(thePilot.getPreference())));
            System.out.println(String.valueOf(Preference.convertPreferenceStringToNum(thePilot.getPreference())));
            pilotInsertStatement.setString(5, thePilot.getEmergencyContact());
            pilotInsertStatement.setString(6, thePilot.getMedInfo());
            pilotInsertStatement.executeUpdate();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    public static List<Pilot> getPilots() throws SQLException, ClassNotFoundException {        
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet thePilots = stmt.executeQuery("SELECT name, weight, capability, "
                    + "preference, emergency_contact_info, emergency_medical_info "
                    + "FROM Pilot ORDER BY name");
            List pilots = new ArrayList<Pilot>();
            
            while(thePilots.next()) {
                String pilotName = thePilots.getString(1);
                String[] names = pilotName.split("\\s+");
                int weight = 0; 
                int capability = 1;
                int preference = 1;
                try {
                    weight = Integer.parseInt(thePilots.getString(2));
                    capability = Integer.parseInt(thePilots.getString(3));
                    preference = Integer.parseInt(thePilots.getString(4));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                Pilot newPilot = new Pilot(names[0], names[1], weight , Capability.convertCapabilityNumToString(capability), Preference.convertPreferenceNumToString(preference), thePilots.getString(5), thePilots.getString(6));
                pilots.add(newPilot);
            }
            return pilots;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static boolean checkForTable(Connection dbConnection) throws SQLException {
        try {
            Statement s = dbConnection.createStatement();
            s.execute("UPDATE Pilot SET name = 'A Name', Weight = '000', capability='1', preference='1', emergency_contact_info='None', emergency_medical_info = 'None' where 1=3"); 
        }catch(SQLException sqle) {
            String theError = (sqle).getSQLState();
            if (theError.equals("42X05"))
                return false;
            else if(theError.equals("42X14") || theError.equals("42821")){
                //TODO find a good way to camcle and rerun init program
                throw sqle;
            }
            else
                throw sqle;
        }
        return true;            
    }
}
