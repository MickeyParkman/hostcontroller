/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AddEditPanels;

import DataObjects.Pilot;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class PilotOptionalPanel extends JPanel {
    private JTextField emergencyContactNameField;
    private JTextField emergencyContactNumberField;
    private JTextField medicalInformationNameField;
    private JTextField medicalInformationNumberField;
    private JTextArea optionalInformationField;

    /**
     * Create the panel.
     */
    public PilotOptionalPanel(Pilot editPilot) {
            setLayout(null);

		JLabel lblEmergencyContact = new JLabel("Emergency Contact:");
		lblEmergencyContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmergencyContact.setBounds(10, 11, 152, 14);
		add(lblEmergencyContact);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 35, 46, 14);
		add(lblNewLabel);
		
		emergencyContactNameField = new JTextField(editPilot.getEmergencyContact());
		emergencyContactNameField.setBounds(76, 34, 120, 20);
		add(emergencyContactNameField);
		emergencyContactNameField.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(10, 66, 46, 14);
		add(lblPhoneNumber);
		
		emergencyContactNumberField = new JTextField(editPilot.getEmergencyContact());
		emergencyContactNumberField.setColumns(10);
		emergencyContactNumberField.setBounds(76, 65, 120, 20);
		add(emergencyContactNumberField);
		
		medicalInformationNameField = new JTextField(editPilot.getMedInfo());
		medicalInformationNameField.setColumns(10);
		medicalInformationNameField.setBounds(76, 157, 120, 20);
		add(medicalInformationNameField);
		
		JLabel label = new JLabel("Phone:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 158, 46, 14);
		add(label);
		
		medicalInformationNumberField = new JTextField(editPilot.getMedInfo());
		medicalInformationNumberField.setColumns(10);
		medicalInformationNumberField.setBounds(76, 126, 120, 20);
		add(medicalInformationNumberField);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 127, 46, 14);
		add(label_1);
		
		JLabel lblPrimaryPhysician = new JLabel("Primary Physician:");
		lblPrimaryPhysician.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrimaryPhysician.setBounds(10, 103, 152, 14);
		add(lblPrimaryPhysician);

            JLabel lblNewLabel_1 = new JLabel("Additional Info:");
            lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lblNewLabel_1.setBounds(10, 195, 152, 14);
            add(lblNewLabel_1);

            optionalInformationField = new JTextArea(editPilot.getOptionalInfo());
            optionalInformationField.setBounds(10, 220, 400, 65);
            add(optionalInformationField);

    }
        
    public void clearData(){
        emergencyContactNameField.setText("");
        emergencyContactNumberField.setText("");
	medicalInformationNameField.setText("");
	medicalInformationNumberField.setText("");
	optionalInformationField.setText("");
    }
    
    public String getEmergencyContact() {
        return emergencyContactNameField.getText() + "." + emergencyContactNumberField.getText();
    }
    
    public String getMedicalInformation() {
        return medicalInformationNameField.getText() + "." + medicalInformationNumberField.getText();
    }
    
    public String getOptionalInformation() {
        return optionalInformationField.getText();
    }
}