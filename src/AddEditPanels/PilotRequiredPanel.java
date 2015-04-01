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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

/**
 *
 * @author Matt
 */
public class PilotRequiredPanel extends javax.swing.JPanel {
    
	private JTextField idField;
        private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField middleNameField;
	private JTextField weightField;
        private ButtonGroup pilotCapability;
        private ButtonGroup pilotLaunchPref;
    
    /**
     * Creates new form PilotRequiredPanel
     */
    
	/**
	 * Create the panel.
	 */
    public PilotRequiredPanel(Pilot editPilot) {
            setLayout(null);

            JLabel lblFirstName = new JLabel("First Name:");
            lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblFirstName.setBounds(10, 11, 69, 14);
            add(lblFirstName);

            JLabel lblNewLabel = new JLabel("Last Name:");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblNewLabel.setBounds(10, 42, 69, 14);
            add(lblNewLabel);

            JLabel lblMiddleName = new JLabel("Middle Name:");
            lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblMiddleName.setBounds(10, 73, 99, 14);
            add(lblMiddleName);

            firstNameField = new JTextField(editPilot.getFirstName());
            firstNameField.setBounds(120, 10, 120, 20);
            add(firstNameField);
            firstNameField.setColumns(10);

            lastNameField = new JTextField(editPilot.getLastName());
            lastNameField.setBounds(120, 41, 120, 20);
            add(lastNameField);
            lastNameField.setColumns(10);

            middleNameField = new JTextField(editPilot.getMiddleName());
            middleNameField.setBounds(120, 72, 120, 20);
            add(middleNameField);
            middleNameField.setColumns(10);

            JLabel lblWeight = new JLabel("Weight:");
            lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblWeight.setBounds(10, 104, 88, 14);
            add(lblWeight);

            float weight = editPilot.getWeight();
            String weightString = "";
            if (weight > 0){
                weightString = String.valueOf(weight);
            }
            
            weightField = new JTextField(weightString);
            weightField.setBounds(120, 103, 100, 20);
            add(weightField);
            weightField.setColumns(10);

            JLabel lblWeightUnits = new JLabel("WeightUnits");
            lblWeightUnits.setBounds(230, 106, 46, 14);
            add(lblWeightUnits);

            JLabel lblCapabilityLevel = new JLabel("Capability:");
            lblCapabilityLevel.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblCapabilityLevel.setBounds(10, 160, 120, 14);
            add(lblCapabilityLevel);

            JRadioButton rdbtnStudent = new JRadioButton("Student");
            rdbtnStudent.setActionCommand("Student");
            rdbtnStudent.setBounds(10, 180, 109, 23);
            add(rdbtnStudent);

            JRadioButton rdbtnProficient = new JRadioButton("Proficient");
            rdbtnProficient.setActionCommand("Proficient");
            rdbtnProficient.setBounds(10, 206, 109, 23);
            add(rdbtnProficient);

            JRadioButton rdbtnAdvanced = new JRadioButton("Advanced");
            rdbtnAdvanced.setActionCommand("Advanced");
            rdbtnAdvanced.setBounds(10, 232, 109, 23);
            add(rdbtnAdvanced);
            
            pilotCapability = new ButtonGroup();
            pilotCapability.add(rdbtnStudent);
            pilotCapability.add(rdbtnProficient);
            pilotCapability.add(rdbtnAdvanced);
            switch(editPilot.getCapability()){
                case "Student":
                    rdbtnStudent.doClick();
                    break;
                case "Proficient":
                    rdbtnProficient.doClick();
                    break;
                case "Advanced":
                    rdbtnAdvanced.doClick();
                    break;
            }

            JLabel lblPreferredLaunch = new JLabel("Preferred Launch:");
            lblPreferredLaunch.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblPreferredLaunch.setBounds(250, 160, 120, 14);
            add(lblPreferredLaunch);

            JRadioButton rdbtnMild = new JRadioButton("Mild");
            rdbtnMild.setActionCommand("Mild");
            rdbtnMild.setBounds(250, 180, 109, 23);
            add(rdbtnMild);

            JRadioButton rdbtnNominal = new JRadioButton("Nominal");
            rdbtnNominal.setActionCommand("Nominal");
            rdbtnNominal.setBounds(250, 206, 109, 23);
            add(rdbtnNominal);

            JRadioButton rdbtnPerformance = new JRadioButton("Performance");
            rdbtnPerformance.setActionCommand("Performance");
            rdbtnPerformance.setBounds(250, 232, 109, 23);
            add(rdbtnPerformance);
            
            pilotLaunchPref = new ButtonGroup();
            pilotLaunchPref.add(rdbtnMild);
            pilotLaunchPref.add(rdbtnNominal);
            pilotLaunchPref.add(rdbtnPerformance);
            switch(editPilot.getPreference()){
                case "Mild":
                    rdbtnMild.doClick();
                    break;
                case "Nominal":
                    rdbtnNominal.doClick();
                    break;
                case "Performance":
                    rdbtnPerformance.doClick();
                    break;
            }

    }
        
    public int getWeight() {
        try{
            int weight = Integer.parseInt(weightField.getText());
            return weight;
        }catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public String getPilotFirstName() {
        return firstNameField.getText();
    }
    
    public String getPilotLastName() {
        return lastNameField.getText();
    }
    
    public String getPilotMiddleName() {
        return middleNameField.getText();
    }
    
    public String getCapability() {
        return pilotCapability.getSelection().getActionCommand();
    }
    
    public String getPreference() {
        return pilotLaunchPref.getSelection().getActionCommand();
    }
    
    public boolean isComplete()
    {
        ErrWindow ew;
        try
        {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            //String middleName = middleNameField.getText();
            String weightStr = weightField.getText();
            int weightInt;
            
            if(firstName.isEmpty())
            {
                throw new Exception();
            }
            if(lastName.isEmpty())
            {
                throw new Exception();
            }
            if(weightStr.isEmpty())
            {
                throw new Exception();
            }
            
            if(pilotCapability.getSelection() == null){
                throw new Exception();
            }
            
            if(pilotLaunchPref.getSelection() == null){
                throw new Exception();
            }
            
            weightInt = Integer.parseInt(weightStr);
            
        }catch(NumberFormatException e){
            ew = new ErrWindow("Please input a numerical weight value");
            return false;
        }catch(Exception e){
            ew = new ErrWindow("Please complete all required fields");
            return false;
        }
        return true;
    }
    
    public void clearData(){
        firstNameField.setText("");
	lastNameField.setText("");
	middleNameField.setText("");
	weightField.setText("");
        pilotCapability.clearSelection();
        pilotLaunchPref.clearSelection();
    }
    
}
