package ParameterSelection;

import AddEditPanels.AddEditPilotPanel;
import Communications.Observer;
import Configuration.UnitConversionRate;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Pilot;
import DatabaseUtilities.DatabaseUnitSelectionUtilities;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.ButtonGroup;


public class PilotPanel extends JPanel implements Observer{
    private List<Pilot> pilotNames = new ArrayList<Pilot>();
    private CurrentDataObjectSet currentData;
    private JScrollPane pilotScrollPane = new JScrollPane();

    @Override
    public void update()
    {
        initPilotList();
        DefaultListModel pilotModel = new DefaultListModel();
        pilotModel.clear();
        for(Object str: pilotNames){
            pilotModel.addElement(str);
        }
        pilotJList.setModel(pilotModel);
        Pilot currentPilot = currentData.getCurrentPilot();
        pilotJList.setSelectedValue(currentPilot.toString(), true);
        pilotScrollPane.setViewportView(pilotJList);
    }
    
    private Observer getObserver() {
        return this;
    }
    
    private void initPilotList() {
        try{
            pilotNames = DatabaseUtilities.DatabaseDataObjectUtilities.getPilots();
            pilotNames.add(new Pilot("1", "Alec", "Jacuzzi", "Michael", 100, "Advanced", "Performance", "John Doe.200-234-2345", "John Doe.200-234-2345", "asdgfsdhasdgf"));
            pilotNames.add(0, new Pilot("1", "", "Default", "", 0, "Student", "Mild", "", "", ""));
        }catch(SQLException e) {
            pilotNames.add(new Pilot("1", "Alec", "Jacuzzi", "Michael", 100, "Advanced", "Performance", "John Doe.200-234-2345", "John Doe.200-234-2345", "asdgfsdhasdgf"));
            pilotNames.add(0, new Pilot("1", "", "Default", "", 0, "Student", "Mild", "", "", ""));

        } catch (ClassNotFoundException ex) {
            // TODO change exception case
        }
    }

    public void clear()
    {
        pilotJList.clearSelection();
        firstNameField.setText("");
        firstNameField.setBackground(new Color(255, 255, 255));
        lastNameField.setText("");
        lastNameField.setBackground(new Color(255, 255, 255));
        middleNameField.setText("");
        middleNameField.setBackground(new Color(255, 255, 255));
        emergencyContactNameField.setText("");
        emergencyContactNameField.setBackground(new Color(255, 255, 255));
        emergencyContactPhoneField.setText("");
        emergencyContactPhoneField.setBackground(new Color(255, 255, 255));
        medInfoNameField.setText("");
        medInfoNameField.setBackground(new Color(255, 255, 255));
        medInfoPhoneField.setText("");
        medInfoPhoneField.setBackground(new Color(255, 255, 255));
        flightWeightField.setText("");
        flightWeightField.setBackground(new Color(255, 255, 255));
        studentRadioButton.setSelected(false);
        proficientRadioButton.setSelected(false);
        advancedRadioButton.setSelected(false);
        mildRadioButton.setSelected(false);
        nominalRadioButton.setSelected(false);
        performanceRadioButton.setSelected(false);
        optionalInfoField.setText("");
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
                String emergencyContactName;
                String emergencyContactPhone;
                int p = emergencyContact.indexOf('%');
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
                String medInfoName;
                String medInfoPhone;
                int t = medInfo.indexOf('%');
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
     * Creates new form PilotPanel
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

        add(pilotScrollPane, BorderLayout.NORTH);
        DefaultListModel pilotModel = new DefaultListModel();
        for(Object str: pilotNames){
            pilotModel.addElement(str);
        }
        pilotJList.setModel(pilotModel);

        pilotJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pilotJListMouseClicked(evt);
            }
        });

        pilotScrollPane.setViewportView(pilotJList);

        JPanel attributesPanel = new JPanel();
        JScrollPane attributesPanelScrollPane = new JScrollPane();
        add(attributesPanelScrollPane, BorderLayout.CENTER);
        attributesPanel.setPreferredSize(new Dimension(700,500));
        attributesPanelScrollPane.setViewportView(attributesPanel);
        attributesPanel.setLayout(null);
        
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(10, 53, 86, 14);
        attributesPanel.add(firstNameLabel);
        
        JLabel middleNameLabel = new JLabel("Middle Name:");
        middleNameLabel.setBounds(10, 78, 86, 14);
        attributesPanel.add(middleNameLabel);
        
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(10, 103, 117, 14);
        attributesPanel.add(lastNameLabel);
        
        JLabel flightWeightLabel = new JLabel("Flight Weight:");
        flightWeightLabel.setBounds(10, 128, 140, 14);
        attributesPanel.add(flightWeightLabel);
        
        flightWeightField = new JTextField();
        flightWeightField.setBounds(160, 125, 110, 20);
        attributesPanel.add(flightWeightField);
        flightWeightField.setColumns(10);
        
        lastNameField = new JTextField();
        lastNameField.setBounds(160, 100, 110, 20);
        attributesPanel.add(lastNameField);
        lastNameField.setColumns(10);
        
        middleNameField = new JTextField();
        middleNameField.setBounds(160, 75, 110, 20);
        attributesPanel.add(middleNameField);
        middleNameField.setColumns(10);
        
        firstNameField = new JTextField();
        firstNameField.setBounds(160, 50, 110, 20);
        attributesPanel.add(firstNameField);
        firstNameField.setColumns(10);
        
        JLabel CapabilityLabel = new JLabel("Capability:");
        CapabilityLabel.setBounds(10, 174, 69, 14);
        attributesPanel.add(CapabilityLabel);
        
        studentRadioButton = new JRadioButton("Student");
        buttonGroup.add(studentRadioButton);
        studentRadioButton.setBounds(85, 170, 109, 23);
        attributesPanel.add(studentRadioButton);
        
        proficientRadioButton = new JRadioButton("Proficient");
        buttonGroup.add(proficientRadioButton);
        proficientRadioButton.setBounds(85, 195, 109, 23);
        attributesPanel.add(proficientRadioButton);
        
        advancedRadioButton = new JRadioButton("Advanced");
        buttonGroup.add(advancedRadioButton);
        advancedRadioButton.setBounds(85, 220, 109, 23);
        attributesPanel.add(advancedRadioButton);
        
        JLabel preferenceLabel = new JLabel("Preference:");
        preferenceLabel.setBounds(245, 174, 69, 14);
        attributesPanel.add(preferenceLabel);
        
        mildRadioButton = new JRadioButton("Mild");
        buttonGroup.add(mildRadioButton);
        mildRadioButton.setBounds(320, 170, 109, 23);
        attributesPanel.add(mildRadioButton);
        
        nominalRadioButton = new JRadioButton("Nominal");
        buttonGroup.add(nominalRadioButton);
        nominalRadioButton.setBounds(320, 195, 109, 23);
        attributesPanel.add(nominalRadioButton);
        
        performanceRadioButton = new JRadioButton("Performance");
        buttonGroup.add(performanceRadioButton);
        performanceRadioButton.setBounds(320, 220, 109, 23);
        attributesPanel.add(performanceRadioButton);
        
        JLabel emergencyContactLabel = new JLabel("Emergency Contact:");
        emergencyContactLabel.setBounds(10, 250, 117, 14);
        attributesPanel.add(emergencyContactLabel);
        
        JLabel emergencyContactNameLabel = new JLabel("Name:");
        emergencyContactNameLabel.setBounds(33, 275, 46, 14);
        attributesPanel.add(emergencyContactNameLabel);
        
        JLabel emergencyContactPhoneLabel = new JLabel("Phone:");
        emergencyContactPhoneLabel.setBounds(33, 300, 46, 14);
        attributesPanel.add(emergencyContactPhoneLabel);
        
        emergencyContactNameField = new JTextField();
        emergencyContactNameField.setBounds(85, 272, 110, 20);
        attributesPanel.add(emergencyContactNameField);
        emergencyContactNameField.setColumns(10);
        
        emergencyContactPhoneField = new JTextField();
        emergencyContactPhoneField.setBounds(85, 297, 109, 20);
        attributesPanel.add(emergencyContactPhoneField);
        emergencyContactPhoneField.setColumns(10);
        
        JLabel medInfoLabel = new JLabel("Primary Physician:");
        medInfoLabel.setBounds(244, 247, 117, 14);
        attributesPanel.add(medInfoLabel);
        
        JLabel medInfoNameLabel = new JLabel("Name:");
        medInfoNameLabel.setBounds(267, 272, 46, 14);
        attributesPanel.add(medInfoNameLabel);
        
        medInfoNameField = new JTextField();
        medInfoNameField.setColumns(10);
        medInfoNameField.setBounds(319, 269, 110, 20);
        attributesPanel.add(medInfoNameField);
        
        medInfoPhoneField = new JTextField();
        medInfoPhoneField.setColumns(10);
        medInfoPhoneField.setBounds(319, 294, 109, 20);
        attributesPanel.add(medInfoPhoneField);
        
        JLabel medInfoPhoneLabel = new JLabel("Phone:");
        medInfoPhoneLabel.setBounds(267, 297, 46, 14);
        attributesPanel.add(medInfoPhoneLabel);
        
        JLabel lblAdditionalInformation = new JLabel("Additional Information:");
        lblAdditionalInformation.setBounds(10, 342, 152, 14);
        attributesPanel.add(lblAdditionalInformation);
        
        optionalInfoField = new JTextArea();
        optionalInfoField.setBounds(10, 367, 734, 88);
        attributesPanel.add(optionalInfoField);
        optionalInfoField.setColumns(10);
        
        lblPilot = new JLabel("Pilot");
        lblPilot.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblPilot.setBounds(10, 20, 86, 31);
        attributesPanel.add(lblPilot);
        
        addNewButton = new JButton("Add New");
        addNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    AddEditPilotPanel AddEditPilotPanel_ = new AddEditPilotPanel(currentData.getCurrentPilot(), false);
                    AddEditPilotPanel_.setVisible(true);
                    AddEditPilotPanel_.attach(getObserver());
        	}
        });
        addNewButton.setBounds(200, 0, 89, 23);
        attributesPanel.add(addNewButton);
        
        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    AddEditPilotPanel AddEditPilotPanel_ = new AddEditPilotPanel(currentData.getCurrentPilot(), true);
                    AddEditPilotPanel_.setVisible(true);
                    AddEditPilotPanel_.attach(getObserver());
        	}
        });
        editButton.setBounds(288, 0, 89, 23);
        attributesPanel.add(editButton);
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
    private final ButtonGroup buttonGroup = new ButtonGroup();

    @Override
    public void update(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
