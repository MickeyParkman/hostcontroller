/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communications;

import javax.swing.JOptionPane;

/**
 * An exception to be used internally in the MessagePipeline
 *
 * @author Alex
 */
public class MessagePipelineException extends Exception {
    String errorMessage;
    
    public void displayError() {
        JOptionPane.showMessageDialog(null, errorMessage);
    }
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
