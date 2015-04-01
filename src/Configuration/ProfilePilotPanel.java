package Configuration;

import DataObjects.CurrentDataObjectSet;
import DataObjects.Pilot;
import DatabaseUtilities.DatabaseEntryDelete;
import DatabaseUtilities.DatabaseEntryEdit;
import DatabaseUtilities.DatabaseDataObjectUtilities;
import ParameterSelection.PilotPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class ProfilePilotPanel extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField middleNameField;
    private JTextField flightWeightField;
    private JTextField emergencyContactNameField;
    private JTextField emergencyContactPhoneField;
    private JTextArea optionalInfoField;

    
    /**
     * Create the panel.
     */
    public ProfilePilotPanel() {
    	setBackground(Color.WHITE);
        setBounds(100, 100, 500, 500);
        setLayout(new BorderLayout(0, 0));
        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setBounds(10, 11, 86, 14);
        this.add(firstNameLabel);
        
        JLabel middleNameLabel = new JLabel("Middle Name:");
        middleNameLabel.setBounds(10, 36, 86, 14);
        this.add(middleNameLabel);
        
        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setBounds(10, 61, 117, 14);
        this.add(lastNameLabel);
        
        JLabel flightWeightLabel = new JLabel("Flight Weight: ");
        flightWeightLabel.setBounds(10, 86, 140, 14);
        this.add(flightWeightLabel);
        
        flightWeightField = new JTextField();
        flightWeightField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

        flightWeightField.setBounds(160, 83, 110, 20);
        this.add(flightWeightField);
        flightWeightField.setColumns(10);
        
        lastNameField = new JTextField();
        lastNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        lastNameField.setBounds(160, 58, 110, 20);
        this.add(lastNameField);
        lastNameField.setColumns(10);
        lastNameField.setEnabled(false);
        
        middleNameField = new JTextField();
        middleNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        middleNameField.setBounds(160, 33, 110, 20);
        this.add(middleNameField);
        middleNameField.setColumns(10);
        middleNameField.setEnabled(false);
        
        firstNameField = new JTextField();
        firstNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        firstNameField.setBounds(160, 8, 110, 20);
        this.add(firstNameField);
        firstNameField.setColumns(10);
        firstNameField.setEnabled(false);
        
        JLabel CapabilityLabel = new JLabel("Capability: ");
        CapabilityLabel.setBounds(10, 132, 69, 14);
        this.add(CapabilityLabel);
        
        JRadioButton studentRadioButton = new JRadioButton("Student");
        studentRadioButton.setBackground(Color.WHITE);
        studentRadioButton.setActionCommand("Student");
        studentRadioButton.setBounds(85, 128, 109, 23);
        this.add(studentRadioButton);
        studentRadioButton.setEnabled(false);
        
        JRadioButton proficientRadioButton = new JRadioButton("Proficient");
        proficientRadioButton.setBackground(Color.WHITE);
        proficientRadioButton.setActionCommand("Proficient");
        proficientRadioButton.setBounds(85, 153, 109, 23);
        this.add(proficientRadioButton);
        proficientRadioButton.setEnabled(false);
        
        JRadioButton advancedRadioButton = new JRadioButton("Advanced");
        advancedRadioButton.setBackground(Color.WHITE);
        advancedRadioButton.setActionCommand("Advanced");
        advancedRadioButton.setBounds(85, 178, 109, 23);
        this.add(advancedRadioButton);
        advancedRadioButton.setEnabled(false);
               
        JLabel preferenceLabel = new JLabel("Preference: *");
        preferenceLabel.setBounds(245, 132, 75, 14);
        this.add(preferenceLabel);
        
        JRadioButton mildRadioButton = new JRadioButton("Mild");
        mildRadioButton.setBackground(Color.WHITE);
        mildRadioButton.setActionCommand("Mild");
        mildRadioButton.setBounds(326, 128, 109, 23);
        this.add(mildRadioButton);
        mildRadioButton.setEnabled(false);
        
        JRadioButton nominalRadioButton = new JRadioButton("Nominal");
        nominalRadioButton.setBackground(Color.WHITE);
        nominalRadioButton.setActionCommand("Nominal");
        nominalRadioButton.setBounds(326, 153, 109, 23);
        this.add(nominalRadioButton);
        nominalRadioButton.setEnabled(false);
        
        JRadioButton performanceRadioButton = new JRadioButton("Performance");
        performanceRadioButton.setBackground(Color.WHITE);
        performanceRadioButton.setActionCommand("Performance");
        performanceRadioButton.setBounds(326, 178, 109, 23);
        this.add(performanceRadioButton);
        performanceRadioButton.setEnabled(false);
        
        JLabel emergencyContactLabel = new JLabel("Emergency Contact:");
        emergencyContactLabel.setBounds(10, 208, 117, 14);
        this.add(emergencyContactLabel);
        
        JLabel emergencyContactNameLabel = new JLabel("Name:");
        emergencyContactNameLabel.setBounds(33, 233, 46, 14);
        this.add(emergencyContactNameLabel);
        
        JLabel emergencyContactPhoneLabel = new JLabel("Phone:");
        emergencyContactPhoneLabel.setBounds(33, 258, 46, 14);
        this.add(emergencyContactPhoneLabel);
        
        emergencyContactNameField = new JTextField();
        emergencyContactNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        emergencyContactNameField.setBounds(85, 230, 110, 20);
        this.add(emergencyContactNameField);
        emergencyContactNameField.setColumns(10);
        emergencyContactNameField.setEnabled(false);
        
        emergencyContactPhoneField = new JTextField();
        emergencyContactPhoneField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        emergencyContactPhoneField.setBounds(85, 255, 109, 20);
        this.add(emergencyContactPhoneField);
        emergencyContactPhoneField.setColumns(10);
        emergencyContactPhoneField.setEnabled(false);
        
        JLabel additionalInformationLabel = new JLabel("Additional Information:");
        additionalInformationLabel.setBounds(10, 300, 152, 14);
        this.add(additionalInformationLabel);
        
        optionalInfoField = new JTextArea();
        optionalInfoField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        optionalInfoField.setBounds(10, 325, 450, 88);
        this.add(optionalInfoField);
        optionalInfoField.setColumns(10);
        optionalInfoField.setEnabled(false);
        
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(0, 438, 89, 23);
        submitButton.setBackground(new Color(200,200,200));
        this.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                submitData();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(90, 438, 89, 23);
        deleteButton.setBackground(new Color(200,200,200));
        this.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                deleteCommand();
            }
        });
        
        JButton clearButton = new JButton("Reset to default");
        clearButton.setBounds(180, 438, 89, 23);
        clearButton.setBackground(new Color(200,200,200));
        this.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                clearData();
            }
        });
    }
        
    protected void submitData(){

    }
    
    public void deleteCommand(){

    }
    
    public void cancelCommand(){
        //this.dispose();
    }
    
    public void clearData(){

    }
}
