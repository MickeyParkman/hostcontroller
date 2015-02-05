/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Wizards;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

/**
 *
 * @author Matt
 */
public class PilotRequiredPanel extends javax.swing.JPanel {
    
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField middleNameField;
	private JTextField weightField;
    
    /**
     * Creates new form PilotRequiredPanel
     */
    
	/**
	 * Create the panel.
	 */
    public PilotRequiredPanel() {
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

            firstNameField = new JTextField();
            firstNameField.setBounds(120, 10, 120, 20);
            add(firstNameField);
            firstNameField.setColumns(10);

            lastNameField = new JTextField();
            lastNameField.setBounds(120, 41, 120, 20);
            add(lastNameField);
            lastNameField.setColumns(10);

            middleNameField = new JTextField();
            middleNameField.setBounds(120, 72, 120, 20);
            add(middleNameField);
            middleNameField.setColumns(10);

            JLabel lblWeight = new JLabel("Weight:");
            lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblWeight.setBounds(10, 104, 88, 14);
            add(lblWeight);

            weightField = new JTextField();
            weightField.setBounds(120, 103, 100, 20);
            add(weightField);
            weightField.setColumns(10);

            JLabel lblUnits = new JLabel("Units*");
            lblUnits.setBounds(230, 106, 46, 14);
            add(lblUnits);

            JLabel lblNewLabel_1 = new JLabel("Experience Level:");
            lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblNewLabel_1.setBounds(10, 160, 120, 14);
            add(lblNewLabel_1);

            JRadioButton rdbtnNewRadioButton = new JRadioButton("Student");
            rdbtnNewRadioButton.setBounds(10, 180, 109, 23);
            add(rdbtnNewRadioButton);

            JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Proficient");
            rdbtnNewRadioButton_1.setBounds(10, 206, 109, 23);
            add(rdbtnNewRadioButton_1);

            JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Advanced");
            rdbtnNewRadioButton_2.setBounds(10, 232, 109, 23);
            add(rdbtnNewRadioButton_2);

            JLabel lblPreferredLaunch = new JLabel("Preferred Launch:");
            lblPreferredLaunch.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblPreferredLaunch.setBounds(250, 160, 120, 14);
            add(lblPreferredLaunch);

            JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Mild");
            rdbtnNewRadioButton_3.setBounds(250, 180, 109, 23);
            add(rdbtnNewRadioButton_3);

            JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Nominal");
            rdbtnNewRadioButton_4.setBounds(250, 206, 109, 23);
            add(rdbtnNewRadioButton_4);

            JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Performance");
            rdbtnNewRadioButton_5.setBounds(250, 232, 109, 23);
            add(rdbtnNewRadioButton_5);

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
    /*
    public int getCapability() {
        return xpSlider.getValue();
    }
    
    public int getPreference() {
        return launchPrefSlider.getValue();
    }*/
    
    public boolean isComplete()
    {
        ErrWindow ew;
        try
        {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String middleName = middleNameField.getText();
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
            
            Integer.parseInt(weightStr);
            
        }catch(NumberFormatException e){
            ew = new ErrWindow("Please input a numerical weight value");
            return false;
        }catch(Exception e){
            ew = new ErrWindow("Please complete all required fields");
            return false;
        }
        return true;
    }
    
}
