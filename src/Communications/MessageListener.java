/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Communications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Matt
 */
public abstract class MessageListener implements ActionListener {

    // abstract method msgAvailable
    //      to be defined in different incarnations of MessageListener
    public abstract void msgAvailable(byte[] msg);
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
