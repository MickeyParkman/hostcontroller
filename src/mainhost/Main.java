/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainhost;

import ApplicationFrame.ApplicationFrame;
import Communications.CommPortConnection;
import Communications.MessagePipeline;
import Communications.SocketConnection;
import DataObjects.Pilot;
import DataObjects.Sailplane;
import ParameterSelection.Capability;
import ParameterSelection.Preference;
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
        //*** USE FOR CONNECTION TO DEVICE OVER COM PORT ***//
        //CommPortConnection connection = new CommPortConnection();
        
        //*** USE FOR CONNECTION TO DEVICE OVER SOCKET ***//
        SocketConnection connection = new SocketConnection();
        
        MessagePipeline pipeline = new MessagePipeline(connection);
        MainHost a = new MainHost(pipeline);
        a.setVisible(true);
                
        /*try {
            //DatabaseUtilities.DatabaseInitialization.deleteDB();
            DatabaseUtilities.DatabaseInitialization.initDatabase();
        }catch(ClassNotFoundException e1) {
            JOptionPane.showMessageDialog(a, "ClassNotFoundException" + e1.getMessage());
        }catch(SQLException e2) {
            JOptionPane.showMessageDialog(a, "SQLException" + e2.getMessage());
        }
        
        try{
            DatabaseUtilities.DatabaseUtilities.addSailplaneToDB(new Sailplane("XF15D574930Z2", "Single Place", "Alex Williams", "None", 450, 1400, 400, 350, 1600, 240));
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(a, "SQLException " + e.getMessage());
        } catch(ClassNotFoundException e2) {
            
        }*/
    }
    
}
