package ParameterSelection;

import Configuration.UnitConversionRate;
import DataObjects.Pilot;
import DataObjects.Sailplane;
import DatabaseUtilities.DatabaseUnitSelectionUtilities;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbennett3
 */
public class ParameterSelectionPanel extends javax.swing.JPanel {

    private final static String[] tabNames = {"PILOT","GLIDER","AIRFIELD"};
    private List<Pilot> pilotNames = new ArrayList<Pilot>();
    private List<Sailplane> sailplanes = new ArrayList<Sailplane>();
    
    public void SetCard(int index)
    {
        final CardLayout layout = (CardLayout)this.getLayout();
        layout.show(this, tabNames[index]);
    }
    
    private void initPilotList() {
        try{
            pilotNames = DatabaseUtilities.DatabaseDataObjectUtilities.getPilots();
            //pilotNames.add(new Pilot("Quartemain", "Alan", "Stephen", 160, Capability.ADVANCED, "Performance", null, null));
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(pilotNameInput, e.getMessage());
            //pilotNames.add(new Pilot("Quartemain", "Alan", "Stephen", 160, Capability.ADVANCED, "Performance", null, null));

        } catch (ClassNotFoundException ex) {
            // TODO change exception case
            Logger.getLogger(PilotSelectionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initSailPlaneList() {
        try{
            sailplanes = DatabaseUtilities.DatabaseDataObjectUtilities.getSailplanes();
            //sailplanes.add(new Sailplane("N32452345", "asdfas", "Bob", "no", 1000, 1000, 1000, 1000, 1000, 1000, false));
        }catch(SQLException e) {

        } catch (ClassNotFoundException ex) {

        }
    }
    
    /*private void pilotNameInputActionPerformed(java.awt.event.ActionEvent evt) {
        //PilotMatchDisplay.add(PilotNameInput.getText(), this);
        flightWeightField.setText(pilotNameInput.getText());
    }
    
    
    private void pilotNameInputKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        String matchstring = pilotNameInput.getText();
        DefaultListModel pilotModel = new DefaultListModel();
        
        // TODO Change from String specific to type Pilot
        for(Pilot plt : pilotNames){
            if(plt.getFirstName().toUpperCase().startsWith(matchstring.toUpperCase())) {
                pilotModel.addElement(plt);
            }
            else if(plt.getLastName().toUpperCase().startsWith(matchstring.toUpperCase())) {
                pilotModel.addElement(plt);
            }
        }
        
        pilotJList.setModel(pilotModel);
    }*/
    
    private void pilotJListMouseClicked(java.awt.event.MouseEvent evt) {
        if(pilotJList.getSelectedIndex() >= 0){
            try{
                Pilot thePilot = (Pilot)pilotJList.getSelectedValue();
                firstNameField.setText((thePilot.getFirstName()));
                firstNameField.setBackground(new Color(142, 250, 127));
                
                lastNameField.setText((thePilot.getLastName()));
                lastNameField.setBackground(new Color(142, 250, 127));
                
                middleNameField.setText((thePilot.getMiddleName()));
                middleNameField.setBackground(new Color(142, 250, 127));
                
                flightWeightField.setText(String.valueOf((int)(thePilot.getWeight() * UnitConversionRate.convertWeightUnitIndexToFactor(DatabaseUnitSelectionUtilities.getPilotWeightUnit()))));
                flightWeightField.setBackground(new Color(142, 250, 127));
                
                studentRadioButton.setSelected(thePilot.getCapability().equals("Student"));
                proficientRadioButton.setSelected(thePilot.getCapability().equals("Proficient"));
                advancedRadioButton.setSelected(thePilot.getCapability().equals("Advanced"));
                
                System.out.println(thePilot.getPreference());
                mildRadioButton.setSelected(thePilot.getPreference().equals("Mild"));
                nominalRadioButton.setSelected(thePilot.getPreference().equals("Nominal"));
                performanceRadioButton.setSelected(thePilot.getPreference().equals("Performance"));
                
            } catch(ClassNotFoundException e1) {
                //TODO respond to error
            }
        }
    }
    
    private void sailplaneJListMouseClicked(java.awt.event.MouseEvent evt) {
        if(sailplaneJList.getSelectedIndex() >= 0){
            try{
                nNumberField.setText((((Sailplane)sailplaneJList.getSelectedValue()).getNumber()));
                nNumberField.setBackground(new Color(142, 250, 127));
                  
            } catch(Exception e) {
                //TODO respond to error
            }
        }
    }
    
    /**
     * Creates new form EditDatabase
     */
    public ParameterSelectionPanel() {
        initPilotList();
        initSailPlaneList();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
        pilotPanel = new javax.swing.JPanel();
        pilotJList = new javax.swing.JList();
        sailplaneJList = new javax.swing.JList();
        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        flightWeightField = new javax.swing.JTextField();
        flightWeightLabel = new javax.swing.JLabel();
        middleNameField = new javax.swing.JTextField();
        middleNameLabel = new javax.swing.JLabel();
        capabilityLabel = new javax.swing.JLabel();
        studentRadioButton = new javax.swing.JRadioButton();
        proficientRadioButton = new javax.swing.JRadioButton();
        advancedRadioButton = new javax.swing.JRadioButton();
        preferenceLabel = new javax.swing.JLabel();
        mildRadioButton = new javax.swing.JRadioButton();
        nominalRadioButton = new javax.swing.JRadioButton();
        performanceRadioButton = new javax.swing.JRadioButton();
        emergencyContactLabel = new javax.swing.JLabel();
        emergencyContactNameField = new javax.swing.JTextField();
        emergencyContactNameLabel = new javax.swing.JLabel();
        emergencyContactPhoneLabel = new javax.swing.JLabel();
        emergencyContactPhoneField = new javax.swing.JTextField();
        primaryPhysicianLabel = new javax.swing.JLabel();
        primaryPhysicianNameLabel = new javax.swing.JLabel();
        primaryPhysicianPhoneLabel = new javax.swing.JLabel();
        primaryPhysicianNameField = new javax.swing.JTextField();
        primaryPhysicianPhoneField = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        pilotAdditionalInfoLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        sailplanePanel = new javax.swing.JPanel();
        sailplaneScrollPane = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        nNumberLabel = new javax.swing.JLabel();
        nNumberField = new javax.swing.JTextField();
        emptyWeightLabel = new javax.swing.JLabel();
        emptyWeightField = new javax.swing.JTextField();
        maxGrossWeightLabel = new javax.swing.JLabel();
        maxGrossWeightField = new javax.swing.JTextField();
        stallSpeedLabel = new javax.swing.JLabel();
        stallSpeedField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        maxWinchingSpeedLabel = new javax.swing.JLabel();
        maxWinchingSpeedField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        airfieldPanel = new AirfieldPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextArea5 = new javax.swing.JTextArea();
        jTextArea4 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        pilotNameInput = new javax.swing.JTextField();
        pilotScrollPane = new javax.swing.JScrollPane();

        firstNameLabel.setText("First Name");

        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });

        lastNameLabel.setText("Last Name");

        flightWeightLabel.setText("Flight Weight");

        middleNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleNameFieldActionPerformed(evt);
            }
        });
        
        DefaultListModel pilotModel = new DefaultListModel();
        for(Object str: pilotNames){
            pilotModel.addElement(str);
        }
        pilotJList.setModel(pilotModel);
        pilotScrollPane.setViewportView(pilotJList);
        
        pilotJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pilotJListMouseClicked(evt);
            }
        });   
        
        middleNameLabel.setText("Middle Name");

        capabilityLabel.setText("Capability");

        studentRadioButton.setText("Student");

        proficientRadioButton.setText("Proficient");

        advancedRadioButton.setText("Advanced");

        preferenceLabel.setText("Preference");

        mildRadioButton.setText("Mild");

        nominalRadioButton.setText("Nominal");

        performanceRadioButton.setText("Performance");

        emergencyContactLabel.setText("Emergency Contact:");

        emergencyContactNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emergencyContactNameFieldActionPerformed(evt);
            }
        });

        emergencyContactNameLabel.setText("Name:");

        emergencyContactPhoneLabel.setText("Phone:");

        primaryPhysicianLabel.setText("Primary Physician:");

        primaryPhysicianNameLabel.setText("Name:");

        primaryPhysicianPhoneLabel.setText("Phone:");

        primaryPhysicianNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primaryPhysicianNameFieldActionPerformed(evt);
            }
        });

        pilotAdditionalInfoLabel.setText("Additional Info:");

        jLabel14.setText("*Units");

        jButton1.setText("Submit");

        javax.swing.GroupLayout pilotPanelLayout = new javax.swing.GroupLayout(pilotPanel);
        pilotPanel.setLayout(pilotPanelLayout);
        pilotPanelLayout.setHorizontalGroup(
            pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pilotPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pilotPanelLayout.createSequentialGroup()
                        .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pilotScrollPane))
                        .addContainerGap())
                    .addGroup(pilotPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstNameLabel)
                            .addComponent(lastNameLabel)
                            .addComponent(middleNameLabel)
                            .addComponent(flightWeightLabel)
                            .addComponent(firstNameField)
                            .addComponent(lastNameField)
                            .addComponent(middleNameField)
                            .addComponent(flightWeightField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pilotPanelLayout.createSequentialGroup()
                                .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pilotPanelLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(capabilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(studentRadioButton)
                                    .addComponent(proficientRadioButton)
                                    .addComponent(advancedRadioButton))
                                .addGap(62, 62, 62)
                                .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(performanceRadioButton)
                                    .addComponent(nominalRadioButton)
                                    .addComponent(mildRadioButton)
                                    .addComponent(preferenceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(157, 157, 157))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pilotPanelLayout.createSequentialGroup()
                                .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emergencyContactLabel)
                                    .addGroup(pilotPanelLayout.createSequentialGroup()
                                        .addComponent(emergencyContactPhoneLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(emergencyContactPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pilotPanelLayout.createSequentialGroup()
                                        .addComponent(emergencyContactNameLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(emergencyContactNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(primaryPhysicianLabel)
                                    .addGroup(pilotPanelLayout.createSequentialGroup()
                                        .addComponent(primaryPhysicianPhoneLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(primaryPhysicianPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pilotPanelLayout.createSequentialGroup()
                                        .addComponent(primaryPhysicianNameLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(primaryPhysicianNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(99, 99, 99))))
                    .addGroup(pilotPanelLayout.createSequentialGroup()
                        .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pilotAdditionalInfoLabel)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pilotPanelLayout.setVerticalGroup(
            pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pilotPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pilotScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pilotPanelLayout.createSequentialGroup()
                        .addComponent(firstNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(middleNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(middleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(flightWeightLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(flightWeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(pilotPanelLayout.createSequentialGroup()
                        .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pilotPanelLayout.createSequentialGroup()
                                .addComponent(preferenceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mildRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nominalRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(performanceRadioButton))
                            .addGroup(pilotPanelLayout.createSequentialGroup()
                                .addComponent(capabilityLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(proficientRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advancedRadioButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pilotPanelLayout.createSequentialGroup()
                                .addComponent(emergencyContactLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emergencyContactNameLabel)
                                    .addComponent(emergencyContactNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emergencyContactPhoneLabel)
                                    .addComponent(emergencyContactPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pilotPanelLayout.createSequentialGroup()
                                .addComponent(primaryPhysicianLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(primaryPhysicianNameLabel)
                                    .addComponent(primaryPhysicianNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(primaryPhysicianPhoneLabel)
                                    .addComponent(primaryPhysicianPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(pilotAdditionalInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addContainerGap())
        );

        this.add(tabNames[0], pilotPanel);

        DefaultListModel sailplaneModel = new DefaultListModel();
        for(Object str: sailplanes){
            sailplaneModel.addElement(str);
        }
        sailplaneJList.setModel(sailplaneModel);
        
        sailplaneJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sailplaneJListMouseClicked(evt);
            }
        });

        sailplaneScrollPane.setViewportView(sailplaneJList);

        nNumberLabel.setText("N-Number");

        emptyWeightLabel.setText("Empty Weight");

        maxGrossWeightLabel.setText("Max Gross Weight");

        stallSpeedLabel.setText("Indicated Stall Speed");

        jLabel19.setText("*Units");

        maxWinchingSpeedLabel.setText("Max Winching Speed");

        jLabel21.setText("*Units");

        jCheckBox1.setText("Single seated?");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        setLayout(new CardLayout(0, 0));

        jCheckBox2.setText("Can carry ballast?");

        jButton2.setText("Submit");

        javax.swing.GroupLayout sailplanePanelLayout = new javax.swing.GroupLayout(sailplanePanel);
        sailplanePanel.setLayout(sailplanePanelLayout);
        sailplanePanelLayout.setHorizontalGroup(
            sailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sailplanePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sailplanePanelLayout.createSequentialGroup()
                        .addComponent(sailplaneScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sailplanePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(sailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maxGrossWeightLabel)
                            .addComponent(emptyWeightLabel)
                            .addComponent(nNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nNumberField)
                            .addComponent(emptyWeightField)
                            .addComponent(maxGrossWeightField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(sailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sailplanePanelLayout.createSequentialGroup()
                                .addGroup(sailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(stallSpeedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stallSpeedField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19))
                            .addComponent(maxWinchingSpeedLabel)
                            .addGroup(sailplanePanelLayout.createSequentialGroup()
                                .addComponent(maxWinchingSpeedField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21))
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2))
                        .addGap(178, 178, 178))
                    .addGroup(sailplanePanelLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        sailplanePanelLayout.setVerticalGroup(
            sailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sailplanePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sailplaneScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(sailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nNumberLabel)
                    .addComponent(stallSpeedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stallSpeedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(sailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emptyWeightLabel)
                    .addComponent(maxWinchingSpeedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emptyWeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxWinchingSpeedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(sailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxGrossWeightLabel)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxGrossWeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(19, 19, 19))
        );

        this.add(tabNames[1], sailplanePanel);
        
        this.add(tabNames[2], airfieldPanel);

        
    }// </editor-fold>//GEN-END:initComponents

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void middleNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middleNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middleNameFieldActionPerformed

    private void emergencyContactNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emergencyContactNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emergencyContactNameFieldActionPerformed

    private void primaryPhysicianNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primaryPhysicianNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_primaryPhysicianNameFieldActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel primaryPhysicianLabel;
    private javax.swing.JLabel primaryPhysicianNameLabel;
    private javax.swing.JLabel primaryPhysicianPhoneLabel;
    private javax.swing.JLabel pilotAdditionalInfoLabel;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel nNumberLabel;
    private javax.swing.JLabel emptyWeightLabel;
    private javax.swing.JLabel maxGrossWeightLabel;
    private javax.swing.JLabel stallSpeedLabel;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel maxWinchingSpeedLabel;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel flightWeightLabel;
    private javax.swing.JLabel middleNameLabel;
    private javax.swing.JLabel capabilityLabel;
    private javax.swing.JLabel preferenceLabel;
    private javax.swing.JLabel emergencyContactLabel;
    private javax.swing.JLabel emergencyContactNameLabel;
    private javax.swing.JLabel emergencyContactPhoneLabel;
    private javax.swing.JPanel pilotPanel;
    private javax.swing.JPanel sailplanePanel;
    private javax.swing.JPanel airfieldPanel;
    private javax.swing.JRadioButton studentRadioButton;
    private javax.swing.JRadioButton proficientRadioButton;
    private javax.swing.JRadioButton advancedRadioButton;
    private javax.swing.JRadioButton mildRadioButton;
    private javax.swing.JRadioButton nominalRadioButton;
    private javax.swing.JRadioButton performanceRadioButton;
    private javax.swing.JScrollPane sailplaneScrollPane;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList pilotJList;
    private javax.swing.JList sailplaneJList;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextField emergencyContactNameField;
    private javax.swing.JTextField nNumberField;
    private javax.swing.JTextField emptyWeightField;
    private javax.swing.JTextField maxGrossWeightField;
    private javax.swing.JTextField stallSpeedField;
    private javax.swing.JTextField maxWinchingSpeedField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField flightWeightField;
    private javax.swing.JTextField middleNameField;
    private javax.swing.JTextField emergencyContactPhoneField;
    private javax.swing.JTextField primaryPhysicianNameField;
    private javax.swing.JTextField primaryPhysicianPhoneField;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField pilotNameInput;
    private javax.swing.JScrollPane pilotScrollPane;
    // End of variables declaration//GEN-END:variables
}
