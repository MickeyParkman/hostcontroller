package ParameterSelection;

import Configuration.UnitConversionRate;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Pilot;
import DatabaseUtilities.DatabaseUnitSelectionUtilities;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;


public class PilotPanel extends JPanel {
    private List<Pilot> pilotNames = new ArrayList<Pilot>();
    private CurrentDataObjectSet currentData;

       private void initPilotList() {
           try{
               pilotNames = DatabaseUtilities.DatabaseDataObjectUtilities.getPilots();
               pilotNames.add(new Pilot("1", "Jacuzzi", "Alec", "Michael", 100, "Advanced", "Performance", "John Doe.200-234-2345", "John Doe.200-234-2345", "asdgfsdhasdgf"));
           }catch(SQLException e) {
               pilotNames.add(new Pilot("1", "Jacuzzi", "Alec", "Michael", 100, "Advanced", "Performance", "John Doe.200-234-2345", "John Doe.200-234-2345", "asdgfsdhasdgf"));

           } catch (ClassNotFoundException ex) {
               // TODO change exception case
           }
       }

       private void pilotJListMouseClicked(java.awt.event.MouseEvent evt) {
           if(pilotJList.getSelectedIndex() >= 0){
                try{
                    Pilot thePilot = (Pilot)pilotJList.getSelectedValue();
                    currentData.setCurrentPilot(thePilot);
                    firstNameField.setText((thePilot.getFirstName()));
                    firstNameField.setBackground(new Color(142, 250, 127));

                    lastNameField.setText((thePilot.getLastName()));
                    lastNameField.setBackground(new Color(142, 250, 127));

                    middleNameField.setText((thePilot.getMiddleName()));
                    middleNameField.setBackground(new Color(142, 250, 127));

                    String emergencyContact = thePilot.getEmergencyContact();
                    System.out.println(emergencyContact);
                    String emergencyContactName;
                    String emergencyContactPhone;
                    int p = emergencyContact.indexOf('.');
                    if (p >= 0) 
                    {
                        emergencyContactName = emergencyContact.substring(0, p);
                        emergencyContactPhone = emergencyContact.substring(p + 1);
                    }
                    else
                    {
                        emergencyContactName = "";
                        emergencyContactPhone = "";
                    }
                    emergencyContactNameField.setText(emergencyContactName);
                    emergencyContactNameField.setBackground(new Color(142, 250, 127));
                    emergencyContactPhoneField.setText(emergencyContactPhone);
                    emergencyContactPhoneField.setBackground(new Color(142, 250, 127));

                    String medInfo = thePilot.getEmergencyContact();
                    System.out.println(emergencyContact);
                    String medInfoName;
                    String medInfoPhone;
                    int t = medInfo.indexOf('.');
                    if (t >= 0) 
                    {
                        medInfoName = emergencyContact.substring(0, t);
                        medInfoPhone = emergencyContact.substring(t + 1);
                    }
                    else
                    {
                        medInfoName = "";
                        medInfoPhone = "";
                    }
                    medInfoNameField.setText(medInfoName);
                    medInfoNameField.setBackground(new Color(142, 250, 127));
                    medInfoPhoneField.setText(medInfoPhone);
                    medInfoPhoneField.setBackground(new Color(142, 250, 127));

                    flightWeightField.setText(String.valueOf((int)(thePilot.getWeight() * UnitConversionRate.convertWeightUnitIndexToFactor(DatabaseUnitSelectionUtilities.getPilotWeightUnit()))));
                    flightWeightField.setBackground(new Color(142, 250, 127));

                    studentRadioButton.setSelected(thePilot.getCapability().equals("Student"));
                    proficientRadioButton.setSelected(thePilot.getCapability().equals("Proficient"));
                    advancedRadioButton.setSelected(thePilot.getCapability().equals("Advanced"));

                    mildRadioButton.setSelected(thePilot.getPreference().equals("Mild"));
                    nominalRadioButton.setSelected(thePilot.getPreference().equals("Nominal"));
                    performanceRadioButton.setSelected(thePilot.getPreference().equals("Performance"));

                    optionalInfoField.setText((thePilot.getOptionalInfo()));
                } catch(Exception e) {
                   //TODO respond to error
                }
        }
    }
    
    /**
     * Creates new form sailplanePanel
     */
    public PilotPanel() {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        initPilotList();
        initComponents();
    }
    
    /**
     * Create the panel.
     */
    public void initComponents() {
        pilotJList = new javax.swing.JList();
        
        setLayout(new BorderLayout(0, 0));

        JScrollPane sailplaneScrollPane = new JScrollPane();
        add(sailplaneScrollPane, BorderLayout.NORTH);
        DefaultListModel sailplaneModel = new DefaultListModel();
        for(Object str: pilotNames){
            sailplaneModel.addElement(str);
        }
        pilotJList.setModel(sailplaneModel);

        pilotJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pilotJListMouseClicked(evt);
            }
        });

        sailplaneScrollPane.setViewportView(pilotJList);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(10, 53, 86, 14);
        panel.add(firstNameLabel);
        
        JLabel middleNameLabel = new JLabel("Middle Name:");
        middleNameLabel.setBounds(10, 78, 86, 14);
        panel.add(middleNameLabel);
        
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(10, 103, 117, 14);
        panel.add(lastNameLabel);
        
        JLabel flightWeightLabel = new JLabel("Flight Weight:");
        flightWeightLabel.setBounds(10, 128, 140, 14);
        panel.add(flightWeightLabel);
        
        flightWeightField = new JTextField();
        flightWeightField.setBounds(160, 125, 110, 20);
        panel.add(flightWeightField);
        flightWeightField.setColumns(10);
        
        lastNameField = new JTextField();
        lastNameField.setBounds(160, 100, 110, 20);
        panel.add(lastNameField);
        lastNameField.setColumns(10);
        
        middleNameField = new JTextField();
        middleNameField.setBounds(160, 75, 110, 20);
        panel.add(middleNameField);
        middleNameField.setColumns(10);
        
        firstNameField = new JTextField();
        firstNameField.setBounds(160, 50, 110, 20);
        panel.add(firstNameField);
        firstNameField.setColumns(10);
        
        JLabel CapabilityLabel = new JLabel("Capability:");
        CapabilityLabel.setBounds(10, 174, 69, 14);
        panel.add(CapabilityLabel);
        
        studentRadioButton = new JRadioButton("Student");
        studentRadioButton.setBounds(85, 170, 109, 23);
        panel.add(studentRadioButton);
        
        proficientRadioButton = new JRadioButton("Proficient");
        proficientRadioButton.setBounds(85, 195, 109, 23);
        panel.add(proficientRadioButton);
        
        advancedRadioButton = new JRadioButton("Advanced");
        advancedRadioButton.setBounds(85, 220, 109, 23);
        panel.add(advancedRadioButton);
        
        JLabel preferenceLabel = new JLabel("Preference:");
        preferenceLabel.setBounds(245, 174, 69, 14);
        panel.add(preferenceLabel);
        
        mildRadioButton = new JRadioButton("Mild");
        mildRadioButton.setBounds(320, 170, 109, 23);
        panel.add(mildRadioButton);
        
        nominalRadioButton = new JRadioButton("Nominal");
        nominalRadioButton.setBounds(320, 195, 109, 23);
        panel.add(nominalRadioButton);
        
        performanceRadioButton = new JRadioButton("Performance");
        performanceRadioButton.setBounds(320, 220, 109, 23);
        panel.add(performanceRadioButton);
        
        JLabel emergencyContactLabel = new JLabel("Emergency Contact:");
        emergencyContactLabel.setBounds(10, 250, 117, 14);
        panel.add(emergencyContactLabel);
        
        JLabel emergencyContactNameLabel = new JLabel("Name:");
        emergencyContactNameLabel.setBounds(33, 275, 46, 14);
        panel.add(emergencyContactNameLabel);
        
        JLabel emergencyContactPhoneLabel = new JLabel("Phone:");
        emergencyContactPhoneLabel.setBounds(33, 300, 46, 14);
        panel.add(emergencyContactPhoneLabel);
        
        emergencyContactNameField = new JTextField();
        emergencyContactNameField.setBounds(85, 272, 110, 20);
        panel.add(emergencyContactNameField);
        emergencyContactNameField.setColumns(10);
        
        emergencyContactPhoneField = new JTextField();
        emergencyContactPhoneField.setBounds(85, 297, 109, 20);
        panel.add(emergencyContactPhoneField);
        emergencyContactPhoneField.setColumns(10);
        
        JLabel medInfoLabel = new JLabel("Primary Physician:");
        medInfoLabel.setBounds(244, 247, 117, 14);
        panel.add(medInfoLabel);
        
        JLabel medInfoNameLabel = new JLabel("Name:");
        medInfoNameLabel.setBounds(267, 272, 46, 14);
        panel.add(medInfoNameLabel);
        
        medInfoNameField = new JTextField();
        medInfoNameField.setColumns(10);
        medInfoNameField.setBounds(319, 269, 110, 20);
        panel.add(medInfoNameField);
        
        medInfoPhoneField = new JTextField();
        medInfoPhoneField.setColumns(10);
        medInfoPhoneField.setBounds(319, 294, 109, 20);
        panel.add(medInfoPhoneField);
        
        JLabel medInfoPhoneLabel = new JLabel("Phone:");
        medInfoPhoneLabel.setBounds(267, 297, 46, 14);
        panel.add(medInfoPhoneLabel);
        
        JLabel lblAdditionalInformation = new JLabel("Additional Information:");
        lblAdditionalInformation.setBounds(10, 342, 152, 14);
        panel.add(lblAdditionalInformation);
        
        optionalInfoField = new JTextArea();
        optionalInfoField.setBounds(10, 367, 734, 88);
        panel.add(optionalInfoField);
        optionalInfoField.setColumns(10);
        
        lblPilot = new JLabel("Pilot");
        lblPilot.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblPilot.setBounds(10, 20, 86, 31);
        panel.add(lblPilot);
        
        addNewButton = new JButton("Add New");
        addNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        addNewButton.setBounds(200, 0, 89, 23);
        panel.add(addNewButton);
        
        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        editButton.setBounds(288, 0, 89, 23);
        panel.add(editButton);
    }
        
    private javax.swing.JList pilotJList;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField middleNameField;
    private JTextField flightWeightField;
    private JTextField emergencyContactNameField;
    private JTextField emergencyContactPhoneField;
    private JTextField medInfoNameField;
    private JTextField medInfoPhoneField;
    private JRadioButton studentRadioButton;
    private JRadioButton proficientRadioButton;
    private JRadioButton advancedRadioButton;
    private JRadioButton mildRadioButton;
    private JRadioButton nominalRadioButton;
    private JRadioButton performanceRadioButton;
    private JTextArea optionalInfoField;
    private JLabel lblPilot;
    private JButton addNewButton;
    private JButton editButton;
}
