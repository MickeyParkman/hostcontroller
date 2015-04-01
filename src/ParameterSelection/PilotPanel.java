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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import javax.swing.border.MatteBorder;
import Configuration.UnitLabelUtilities;


public class PilotPanel extends JPanel implements Observer{
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
    private JLabel PilotLabel;
    private JButton addNewButton;
    private JButton editButton;
    private Boolean shown;
    private CurrentDataObjectSet currentData;
    private JLabel emergencyContactLabel = new JLabel();
    private JLabel emergencyContactNameLabel = new JLabel();
    private JLabel emergencyContactPhoneLabel = new JLabel();
    private JLabel additionalInformationLabel = new JLabel();
    private JButton showMoreButton = new JButton();
    private List<Pilot> pilotNames = new ArrayList<Pilot>();
    private JScrollPane pilotScrollPane = new JScrollPane();
    private final ButtonGroup capabilityButtonGroup = new ButtonGroup();
    private final ButtonGroup preferenceButtonGroup = new ButtonGroup();
    private JLabel flightWeightUnits = new JLabel();
    
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
        
        int flightWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("flightWeight");
        String flightWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(flightWeightUnitsID);
        flightWeightUnits.setText(flightWeightUnitsString);
        
        firstNameField.setText((currentPilot.getFirstName()));
        firstNameField.setBackground(Color.GREEN);

        lastNameField.setText((currentPilot.getLastName()));
        lastNameField.setBackground(Color.GREEN);

        middleNameField.setText((currentPilot.getMiddleName()));
        middleNameField.setBackground(Color.GREEN);

        String emergencyContact = currentPilot.getEmergencyContact();
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
        emergencyContactNameField.setBackground(Color.GREEN);
        emergencyContactPhoneField.setText(emergencyContactPhone);
        emergencyContactPhoneField.setBackground(Color.GREEN);

        /*String medInfo = thePilot.getEmergencyContact();
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
        medInfoNameField.setBackground(Color.GREEN);
        medInfoPhoneField.setText(medInfoPhone);
        medInfoPhoneField.setBackground(Color.GREEN);*/

        flightWeightField.setText(String.valueOf((currentPilot.getWeight() * UnitConversionRate.convertWeightUnitIndexToFactor(flightWeightUnitsID))));
        flightWeightField.setBackground(Color.GREEN);

        studentRadioButton.setSelected(currentPilot.getCapability().equals("Student"));
        proficientRadioButton.setSelected(currentPilot.getCapability().equals("Proficient"));
        advancedRadioButton.setSelected(currentPilot.getCapability().equals("Advanced"));

        mildRadioButton.setSelected(currentPilot.getPreference().equals("Mild"));
        nominalRadioButton.setSelected(currentPilot.getPreference().equals("Nominal"));
        performanceRadioButton.setSelected(currentPilot.getPreference().equals("Performance"));

        optionalInfoField.setText((currentPilot.getOptionalInfo()));      
    }
    
    private Observer getObserver() {
        return this;
    }
    
    private void initPilotList() {
        try{
            pilotNames = DatabaseUtilities.DatabaseDataObjectUtilities.getPilots();
        }catch(SQLException e) {
        } catch (ClassNotFoundException ex) {
            // TODO change exception case
        }
    }

    public void clear()
    {
        pilotJList.clearSelection();
        firstNameField.setText("");
        firstNameField.setBackground(Color.WHITE);
        lastNameField.setText("");
        lastNameField.setBackground(Color.WHITE);
        middleNameField.setText("");
        middleNameField.setBackground(Color.WHITE);
        emergencyContactNameField.setText("");
        emergencyContactNameField.setBackground(Color.WHITE);
        emergencyContactPhoneField.setText("");
        emergencyContactPhoneField.setBackground(Color.WHITE);
        /*medInfoNameField.setText("");
        medInfoNameField.setBackground(Color.WHITE);
        medInfoPhoneField.setText("");
        medInfoPhoneField.setBackground(Color.WHITE);*/
        flightWeightField.setText("");
        flightWeightField.setBackground(Color.WHITE);
        capabilityButtonGroup.clearSelection();
        preferenceButtonGroup.clearSelection();
        optionalInfoField.setText("");
}
    
    private void pilotJListMouseClicked(java.awt.event.MouseEvent evt) {
        if(pilotJList.getSelectedIndex() >= 0){
            try{
                Pilot thePilot = (Pilot)pilotJList.getSelectedValue();
                currentData.setCurrentPilot(thePilot);
                firstNameField.setText((thePilot.getFirstName()));
                firstNameField.setBackground(Color.GREEN);

                lastNameField.setText((thePilot.getLastName()));
                lastNameField.setBackground(Color.GREEN);

                middleNameField.setText((thePilot.getMiddleName()));
                middleNameField.setBackground(Color.GREEN);

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
                emergencyContactNameField.setBackground(Color.GREEN);
                emergencyContactPhoneField.setText(emergencyContactPhone);
                emergencyContactPhoneField.setBackground(Color.GREEN);

                /*String medInfo = thePilot.getEmergencyContact();
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
                medInfoNameField.setBackground(Color.GREEN);
                medInfoPhoneField.setText(medInfoPhone);
                medInfoPhoneField.setBackground(Color.GREEN);*/

                flightWeightField.setText(String.valueOf((int)(thePilot.getWeight() * UnitConversionRate.convertWeightUnitIndexToFactor(DatabaseUnitSelectionUtilities.getPilotWeightUnit()))));
                flightWeightField.setBackground(Color.GREEN);

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
        attributesPanel.setBackground(Color.WHITE);
        JScrollPane attributesPanelScrollPane = new JScrollPane();
        add(attributesPanelScrollPane, BorderLayout.CENTER);
        attributesPanel.setPreferredSize(new Dimension(700,500));
        attributesPanelScrollPane.setViewportView(attributesPanel);
        attributesPanelScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
        attributesPanelScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
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
        flightWeightField.setBackground(Color.WHITE);
        flightWeightField.setEditable(false);
        flightWeightField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        flightWeightField.setBounds(160, 125, 110, 20);
        attributesPanel.add(flightWeightField);
        flightWeightField.setColumns(10);
        
        lastNameField = new JTextField();
        lastNameField.setBackground(Color.WHITE);
        lastNameField.setEditable(false);
        lastNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        lastNameField.setBounds(160, 100, 110, 20);
        attributesPanel.add(lastNameField);
        lastNameField.setColumns(10);
        
        middleNameField = new JTextField();
        middleNameField.setBackground(Color.WHITE);
        middleNameField.setEditable(false);
        middleNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        middleNameField.setBounds(160, 75, 110, 20);
        attributesPanel.add(middleNameField);
        middleNameField.setColumns(10);
        
        firstNameField = new JTextField();
        firstNameField.setBackground(Color.WHITE);
        firstNameField.setEditable(false);
        firstNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        firstNameField.setBounds(160, 50, 110, 20);
        attributesPanel.add(firstNameField);
        firstNameField.setColumns(10);
        
        JLabel CapabilityLabel = new JLabel("Capability:");
        CapabilityLabel.setBounds(10, 174, 69, 14);
        attributesPanel.add(CapabilityLabel);
        
        studentRadioButton = new JRadioButton("Student");
        capabilityButtonGroup.add(studentRadioButton);
        studentRadioButton.setBackground(Color.WHITE);
        studentRadioButton.setBounds(85, 170, 109, 23);
        attributesPanel.add(studentRadioButton);
        
        proficientRadioButton = new JRadioButton("Proficient");
        capabilityButtonGroup.add(proficientRadioButton);
        proficientRadioButton.setBackground(Color.WHITE);
        proficientRadioButton.setBounds(85, 195, 109, 23);
        attributesPanel.add(proficientRadioButton);
        
        advancedRadioButton = new JRadioButton("Advanced");
        capabilityButtonGroup.add(advancedRadioButton);
        advancedRadioButton.setBackground(Color.WHITE);
        advancedRadioButton.setBounds(85, 220, 109, 23);
        attributesPanel.add(advancedRadioButton);
        
        JLabel preferenceLabel = new JLabel("Preference:");
        preferenceLabel.setBounds(245, 174, 69, 14);
        attributesPanel.add(preferenceLabel);
        
        mildRadioButton = new JRadioButton("Mild");
        preferenceButtonGroup.add(mildRadioButton);
        mildRadioButton.setBackground(Color.WHITE);
        mildRadioButton.setBounds(320, 170, 109, 23);
        attributesPanel.add(mildRadioButton);
        
        nominalRadioButton = new JRadioButton("Nominal");
        preferenceButtonGroup.add(nominalRadioButton);
        nominalRadioButton.setBackground(Color.WHITE);
        nominalRadioButton.setBounds(320, 195, 109, 23);
        attributesPanel.add(nominalRadioButton);
        
        performanceRadioButton = new JRadioButton("Performance");
        preferenceButtonGroup.add(performanceRadioButton);
        performanceRadioButton.setBackground(Color.WHITE);
        performanceRadioButton.setBounds(320, 220, 109, 23);
        attributesPanel.add(performanceRadioButton);
        
        emergencyContactLabel.setText("Emergency Contact:");
        emergencyContactLabel.setBounds(10, 284, 117, 14);
        attributesPanel.add(emergencyContactLabel);
        emergencyContactLabel.setVisible(false);
        
        emergencyContactNameLabel.setText("Name:");
        emergencyContactNameLabel.setBounds(33, 309, 46, 14);
        attributesPanel.add(emergencyContactNameLabel);
        emergencyContactNameLabel.setVisible(false);
        
        emergencyContactPhoneLabel.setText("Phone:");
        emergencyContactPhoneLabel.setBounds(33, 334, 46, 14);
        attributesPanel.add(emergencyContactPhoneLabel);
        emergencyContactPhoneLabel.setVisible(false);
        
        emergencyContactNameField = new JTextField();
        emergencyContactNameField.setBackground(Color.WHITE);
        emergencyContactNameField.setEditable(false);
        emergencyContactNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        emergencyContactNameField.setBounds(85, 306, 110, 20);
        attributesPanel.add(emergencyContactNameField);
        emergencyContactNameField.setColumns(10);
        emergencyContactNameField.setVisible(false);
        
        emergencyContactPhoneField = new JTextField();
        emergencyContactPhoneField.setBackground(Color.WHITE);
        emergencyContactPhoneField.setEditable(false);
        emergencyContactPhoneField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        emergencyContactPhoneField.setBounds(85, 331, 110, 20);
        attributesPanel.add(emergencyContactPhoneField);
        emergencyContactPhoneField.setColumns(10);
        emergencyContactPhoneField.setVisible(false);
        
        /*JLabel medInfoLabel = new JLabel("Primary Physician:");
        medInfoLabel.setBounds(244, 247, 117, 14);
        attributesPanel.add(medInfoLabel);
        
        JLabel medInfoNameLabel = new JLabel("Name:");
        medInfoNameLabel.setBounds(267, 272, 46, 14);
        attributesPanel.add(medInfoNameLabel);
        
        medInfoNameField = new JTextField();
        medInfoNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        medInfoNameField.setColumns(10);
        medInfoNameField.setBounds(319, 269, 110, 20);
        attributesPanel.add(medInfoNameField);
        
        medInfoPhoneField = new JTextField();
        medInfoPhoneField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        medInfoPhoneField.setColumns(10);
        medInfoPhoneField.setBounds(319, 294, 110, 20);
        attributesPanel.add(medInfoPhoneField);
        
        JLabel medInfoPhoneLabel = new JLabel("Phone:");
        medInfoPhoneLabel.setBounds(267, 297, 46, 14);
        attributesPanel.add(medInfoPhoneLabel);*/
        
        additionalInformationLabel.setText("Additional Information:");
        additionalInformationLabel.setBounds(10, 376, 152, 14);
        attributesPanel.add(additionalInformationLabel);
        additionalInformationLabel.setVisible(false);
        
        optionalInfoField = new JTextArea();
        optionalInfoField.setBackground(Color.WHITE);
        optionalInfoField.setEditable(false);
        optionalInfoField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        optionalInfoField.setBounds(10, 401, 734, 88);
        attributesPanel.add(optionalInfoField);
        optionalInfoField.setColumns(10);
        optionalInfoField.setVisible(false);
        
        PilotLabel = new JLabel("Pilot");
        PilotLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        PilotLabel.setBounds(10, 20, 86, 31);
        attributesPanel.add(PilotLabel);
        
        addNewButton = new JButton("Add New");
        addNewButton.setBackground(new Color(200,200,200));
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
        editButton.setBackground(new Color(200,200,200));
        editButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    AddEditPilotPanel AddEditPilotPanel_ = new AddEditPilotPanel(currentData.getCurrentPilot(), true);
                    AddEditPilotPanel_.setVisible(true);
                    AddEditPilotPanel_.attach(getObserver());
        	}
        });
        editButton.setBounds(288, 0, 89, 23);
        attributesPanel.add(editButton);
        
        flightWeightUnits.setText("kg");
        flightWeightUnits.setBounds(280, 128, 46, 14);
        attributesPanel.add(flightWeightUnits);
        
        shown = false;
        showMoreButton.setText("Show More");
        showMoreButton.setBackground(new Color(200,200,200));
        showMoreButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(shown)
        		{
                            emergencyContactLabel.setVisible(false);
                            emergencyContactNameLabel.setVisible(false);
                            emergencyContactPhoneLabel.setVisible(false);
                            emergencyContactNameField.setVisible(false);
                            emergencyContactPhoneField.setVisible(false);
                            additionalInformationLabel.setVisible(false);
                            optionalInfoField.setVisible(false);
                            shown = false;
                            showMoreButton.setText("Show More");
        		}
        		else
        		{
                            emergencyContactLabel.setVisible(true);
                            emergencyContactNameLabel.setVisible(true);
                            emergencyContactPhoneLabel.setVisible(true);
                            emergencyContactNameField.setVisible(true);
                            emergencyContactPhoneField.setVisible(true);
                            additionalInformationLabel.setVisible(true);
                            optionalInfoField.setVisible(true);
                            shown = true;
                            showMoreButton.setText("Show Less");
        		}
        	}
        });
        showMoreButton.setBounds(7, 261, 140, 23);
        attributesPanel.add(showMoreButton);
    }
            
    @Override
    public void update(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
