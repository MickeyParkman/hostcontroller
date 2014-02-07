/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainhost;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author garreola-gutierrez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        MainHost a = new MainHost();
        a.setVisible(true);
        
            
        // TODO code application logic here
        
        /*try {
            //DatabaseUtilities.DatabaseInitialization.deleteDB();
            DatabaseUtilities.DatabaseInitialization.initDatabase();
        }catch(ClassNotFoundException e1) {
            JOptionPane.showMessageDialog(a, "ClassNotFoundException" + e1.getMessage());
        }catch(SQLException e2) {
            JOptionPane.showMessageDialog(a, "SQLException" + e2.getMessage());
        }*/
        
        /*try{
            DatabaseUtilities.DatabaseUtilities.addPilotToDB(new Pilot("Smith", "Matt", 145, Capability.ADVANCED, "Aggressive", null, null));
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(a, "SQLException " + e.getMessage());
        }*/
    }
    
}
