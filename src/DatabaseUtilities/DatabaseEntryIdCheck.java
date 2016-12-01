/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseUtilities;

import static Communications.ErrorLogger.logError;
import java.sql.*;

import DataObjects.*;
import javax.swing.JOptionPane;
/**
 *
 * @author nfujioka
 */
public class DatabaseEntryIdCheck {
    
    public static Connection connectEx() throws ClassNotFoundException, SQLException {//other connect in Initialization
        String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
        String clientDriverName = "org.apache.derby.jdbc.ClientDriver";
        String databaseConnectionName = "jdbc:derby:hcDatabase;create=true";
        Connection connection = null;
        //Check for DB drivers
        try {
            Class.forName(clientDriverName);
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Can't load JavaDb ClientDriver", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw e;
        }
        //Try to connect to the specified database
        try {
            connection = DriverManager.getConnection(databaseConnectionName);
        } catch (SQLException e) {
            //TODO Fix error handling
            JOptionPane.showMessageDialog(null, "Correctly loaded the JavaDb ClientDriver, " + "somethin else is wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw e;
        }
        return connection;
    }
    
    private static boolean IdCheck(PreparedStatement stmt) throws SQLException {
        boolean result;
        //Update the value given
        ResultSet theIds = stmt.executeQuery();
        result = theIds.next();
        stmt.close();
        return result;
    }
    
    public static boolean IdCheck(Pilot pilot) throws SQLException, ClassNotFoundException {
        try(Connection conn = connectEx()) {
            if(conn == null) {
                throw new SQLException();
            }
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PILOT WHERE pilot_id = ?");
            stmt.setInt(1, pilot.getPilotId());
            
            return IdCheck(stmt);
        } catch(SQLException | ClassNotFoundException e) {
            logError(e);
            throw e;
        }
    }
    
    public static boolean IdCheck(Sailplane sailplane) throws SQLException, ClassNotFoundException {
        try(Connection conn = connectEx()) {
            if(conn == null) {
                return false;
            }
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM GLIDER WHERE glider_id = ?");
            stmt.setInt(1, sailplane.getId());
            
            return IdCheck(stmt);
        } catch(SQLException | ClassNotFoundException e) {
            logError(e);
            throw e;
        }
    }
    
    public static boolean IdCheck(Airfield airfield) throws SQLException, ClassNotFoundException {
        try(Connection conn = connectEx()) {
            if(conn == null) {
                return false;
            }
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM AIRFIELD WHERE airfield_id = ?");
            stmt.setInt(1, airfield.getId());
            
            return IdCheck(stmt);
        } catch(SQLException | ClassNotFoundException e) {
            logError(e);
            throw e;
        }
    }
    
    public static boolean IdCheck(Runway runway) throws SQLException, ClassNotFoundException {
        try(Connection conn = connectEx()) {
            if(conn == null) {
                return false;
            }
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM RUNWAY WHERE runway_id = ?");
            stmt.setInt(1, runway.getId());
            
            return IdCheck(stmt);
        } catch(SQLException | ClassNotFoundException e) {
            logError(e);
            throw e;
        }
    }
    
    public static boolean IdCheck(GliderPosition position) throws SQLException, ClassNotFoundException {
        try(Connection conn = connectEx()) {
            if(conn == null) {
                return false;
            }
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM GLIDERPOSITION WHERE glider_position_id = ?");
            stmt.setInt(1, position.getId());
            
            return IdCheck(stmt);
        } catch(SQLException | ClassNotFoundException e) {
            logError(e);
            throw e;
        }
    }
    
    public static boolean IdCheck(WinchPosition position) throws SQLException, ClassNotFoundException {
        try(Connection conn = connectEx()) {
            if(conn == null) {
                return false;
            }
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM WINCHPOSITION WHERE winch_position_id = ?");
            stmt.setInt(1, position.getId());
            
            return IdCheck(stmt);
        } catch(SQLException | ClassNotFoundException e) {
            logError(e);
            throw e;
        }
    }
    
    public static boolean IdCheck(Drum drum) throws SQLException, ClassNotFoundException {
        try(Connection conn = connectEx()) {
            if(conn == null) {
                return false;
            }
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM DRUM WHERE drum_id = ?");
            stmt.setInt(1, drum.getId());
            
            return IdCheck(stmt);
        } catch(SQLException | ClassNotFoundException e) {
            logError(e);
            throw e;
        }
    }
    
    public static boolean IdCheck(Parachute parachute) throws SQLException, ClassNotFoundException {
        try(Connection conn = connectEx()) {
            if(conn == null) {
                return false;
            }
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PARACHUTE WHERE parachute_id = ?");
            stmt.setInt(1, parachute.getParachuteId());
            
            return IdCheck(stmt);
        } catch(SQLException | ClassNotFoundException e) {
            logError(e);
            throw e;
        }
    }
    public static boolean IdCheck(Operator operator) throws SQLException, ClassNotFoundException {
        try(Connection conn = connectEx()) {
            if(conn == null) {
                return false;
            }
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Operator WHERE operator_id = ?");
            stmt.setInt(1, operator.getID());
        
            return IdCheck(stmt);
        } catch(SQLException | ClassNotFoundException e) {
            logError(e);
            throw e;
        }
    }
    
    public static boolean matchPassword(Operator operator, String check)
            throws SQLException, ClassNotFoundException {
        String salt, pass;
        try(Connection conn = connectEx()) {
            if(conn == null) {
                return false;
            }
            PreparedStatement stmt = conn.prepareStatement("SELECT salt, hash "
                    + "FROM Operator WHERE operator_id = ?");
            stmt.setInt(1, operator.getID());
            ResultSet op = stmt.executeQuery();
            op.next();
            salt = op.getString("salt");
            pass = op.getString("hash");
            
            check = salt + check;     
            byte [] hashedInput = new byte[check.length()+224];
   	
            Whirlpool w = new Whirlpool();
            w.NESSIEinit();
            w.NESSIEadd(check);
            w.NESSIEfinalize(hashedInput); 
            String hash = w.display(hashedInput);
            return hash.compareTo(pass) == 0;
        } catch(SQLException | ClassNotFoundException e) {
            logError(e);
            throw e;
        }
    }

    static boolean IdCheck(int Airfield_Key) throws SQLException, ClassNotFoundException {  {
        try(Connection conn = connectEx()) {
            if(conn == null) {
                return false;
            }
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PreviousAirfieldInfo WHERE table_id = ?");
            stmt.setInt(1, Airfield_Key);
            
            return IdCheck(stmt);
            } catch(SQLException | ClassNotFoundException e) {
                logError(e);
                throw e;
            }
        }
    }
}

