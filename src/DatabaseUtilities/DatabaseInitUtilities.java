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
public class DatabaseInitUtilities {
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
