/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainhost;

import Communications.CommPortConnection;
import Communications.FileDummyConnection;
import Communications.MessagePipeline;
import Communications.SocketConnection;
import DataObjects.Pilot;
import DataObjects.Sailplane;
import ParameterSelection.Capability;
import ParameterSelection.Preference;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * The Main class is the launching point for this program where the UI and 
 * the MessagePipeline are started up.
 *  JTROXEL
 */
public class Main {

    public static void main(String[] args) {
        MainWindow a = new MainWindow();
        a.setVisible(true);
    }
    
}
