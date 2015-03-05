package AddEditPanels;

import Communications.Observer;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Pilot;
import DatabaseUtilities.DatabaseEntryDelete;
import DatabaseUtilities.DatabaseEntryEdit;
import ParameterSelection.PilotPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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


public class AddEditPilotPanel extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField middleNameField;
    private JTextField flightWeightField;
    private ButtonGroup pilotCapability;
    private ButtonGroup pilotLaunchPref;
    private JTextField emergencyContactNameField;
    private JTextField emergencyContactPhoneField;
    private JTextField medInfoNameField;
    private JTextField medInfoPhoneField;
    private JTextArea optionalInfoField;
    private Pilot currentPilot;
    private boolean isEditEntry;
    private Observer parent;
    
    public void attach(Observer o)
    {
        parent = o;
    }
    
    /**
     * Create the frame.
     */
    public AddEditPilotPanel(Pilot editPilot, boolean isEditEntry) {
        if (!isEditEntry){
            editPilot = new Pilot("", "", "", "", 0, "", "", "", "", "");
        }
        this.isEditEntry = isEditEntry;
        currentPilot = editPilot;
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        setTitle("Pilot");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel firstNameLabel = new JLabel("First Name: *");
        firstNameLabel.setBounds(10, 11, 86, 14);
        panel.add(firstNameLabel);
        
        JLabel middleNameLabel = new JLabel("Middle Name:");
        middleNameLabel.setBounds(10, 36, 86, 14);
        panel.add(middleNameLabel);
        
        JLabel lastNameLabel = new JLabel("Last Name: *");
        lastNameLabel.setBounds(10, 61, 117, 14);
        panel.add(lastNameLabel);
        
        JLabel flightWeightLabel = new JLabel("Flight Weight: *");
        flightWeightLabel.setBounds(10, 86, 140, 14);
        panel.add(flightWeightLabel);
        
        flightWeightField = new JTextField();
        flightWeightField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        if (isEditEntry){
            flightWeightField.setText(Integer.toString(editPilot.getWeight()));
        }
        flightWeightField.setBounds(160, 83, 110, 20);
        panel.add(flightWeightField);
        flightWeightField.setColumns(10);
        
        lastNameField = new JTextField(editPilot.getLastName());
        lastNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        lastNameField.setBounds(160, 58, 110, 20);
        panel.add(lastNameField);
        lastNameField.setColumns(10);
        
        middleNameField = new JTextField(editPilot.getMiddleName());
        middleNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        middleNameField.setBounds(160, 33, 110, 20);
        panel.add(middleNameField);
        middleNameField.setColumns(10);
        
        firstNameField = new JTextField(editPilot.getFirstName());
        firstNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        firstNameField.setBounds(160, 8, 110, 20);
        panel.add(firstNameField);
        firstNameField.setColumns(10);
        
        JLabel CapabilityLabel = new JLabel("Capability: *");
        CapabilityLabel.setBounds(10, 132, 69, 14);
        panel.add(CapabilityLabel);
        
        JRadioButton studentRadioButton = new JRadioButton("Student");
        studentRadioButton.setBackground(Color.WHITE);
        studentRadioButton.setActionCommand("Student");
        studentRadioButton.setBounds(85, 128, 109, 23);
        panel.add(studentRadioButton);
        
        JRadioButton proficientRadioButton = new JRadioButton("Proficient");
        proficientRadioButton.setBackground(Color.WHITE);
        proficientRadioButton.setActionCommand("Proficient");
        proficientRadioButton.setBounds(85, 153, 109, 23);
        panel.add(proficientRadioButton);
        
        JRadioButton advancedRadioButton = new JRadioButton("Advanced");
        advancedRadioButton.setBackground(Color.WHITE);
        advancedRadioButton.setActionCommand("Advanced");
        advancedRadioButton.setBounds(85, 178, 109, 23);
        panel.add(advancedRadioButton);
        
        pilotCapability = new ButtonGroup();
        pilotCapability.add(studentRadioButton);
        pilotCapability.add(proficientRadioButton);
        pilotCapability.add(advancedRadioButton);
        switch(editPilot.getCapability()){
            case "Student":
                studentRadioButton.doClick();
                break;
            case "Proficient":
                proficientRadioButton.doClick();
                break;
            case "Advanced":
                advancedRadioButton.doClick();
                break;
        }
        
        JLabel preferenceLabel = new JLabel("Preference: *");
        preferenceLabel.setBounds(245, 132, 75, 14);
        panel.add(preferenceLabel);
        
        JRadioButton mildRadioButton = new JRadioButton("Mild");
        mildRadioButton.setBackground(Color.WHITE);
        mildRadioButton.setActionCommand("Mild");
        mildRadioButton.setBounds(326, 128, 109, 23);
        panel.add(mildRadioButton);
        
        JRadioButton nominalRadioButton = new JRadioButton("Nominal");
        nominalRadioButton.setBackground(Color.WHITE);
        nominalRadioButton.setActionCommand("Nominal");
        nominalRadioButton.setBounds(326, 153, 109, 23);
        panel.add(nominalRadioButton);
        
        JRadioButton performanceRadioButton = new JRadioButton("Performance");
        performanceRadioButton.setBackground(Color.WHITE);
        performanceRadioButton.setActionCommand("Performance");
        performanceRadioButton.setBounds(326, 178, 109, 23);
        panel.add(performanceRadioButton);
        
        pilotLaunchPref = new ButtonGroup();
        pilotLaunchPref.add(mildRadioButton);
        pilotLaunchPref.add(nominalRadioButton);
        pilotLaunchPref.add(performanceRadioButton);
        switch(editPilot.getPreference()){
            case "Mild":
                mildRadioButton.doClick();
                break;
            case "Nominal":
                nominalRadioButton.doClick();
                break;
            case "Performance":
                performanceRadioButton.doClick();
                break;
        }
        
        JLabel emergencyContactLabel = new JLabel("Emergency Contact:");
        emergencyContactLabel.setBounds(10, 208, 117, 14);
        panel.add(emergencyContactLabel);
        
        JLabel emergencyContactNameLabel = new JLabel("Name:");
        emergencyContactNameLabel.setBounds(33, 233, 46, 14);
        panel.add(emergencyContactNameLabel);
        
        JLabel emergencyContactPhoneLabel = new JLabel("Phone:");
        emergencyContactPhoneLabel.setBounds(33, 258, 46, 14);
        panel.add(emergencyContactPhoneLabel);
        
        String emergencyContact = editPilot.getEmergencyContact();
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

        emergencyContactNameField = new JTextField(emergencyContactName);
        emergencyContactNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        emergencyContactNameField.setBounds(85, 230, 110, 20);
        panel.add(emergencyContactNameField);
        emergencyContactNameField.setColumns(10);
        
        emergencyContactPhoneField = new JTextField(emergencyContactPhone);
        emergencyContactPhoneField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        emergencyContactPhoneField.setBounds(85, 255, 109, 20);
        panel.add(emergencyContactPhoneField);
        emergencyContactPhoneField.setColumns(10);
        
        JLabel medInfoLabel = new JLabel("Primary Physician:");
        medInfoLabel.setBounds(244, 205, 117, 14);
        panel.add(medInfoLabel);
        
        JLabel medInfoNameLabel = new JLabel("Name:");
        medInfoNameLabel.setBounds(267, 230, 46, 14);
        panel.add(medInfoNameLabel);
        
        String medInfo = editPilot.getMedInfo();
        String medInfoName;
        String medInfoPhone;
        int t = medInfo.indexOf('%');
        if (t >= 0) 
        {
            medInfoName = medInfo.substring(0, t);
            medInfoPhone = medInfo.substring(t + 1);
        }
        else
        {
            medInfoName = "";
            medInfoPhone = "";
        }
        
        medInfoNameField = new JTextField(medInfoName);
        medInfoNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        medInfoNameField.setColumns(10);
        medInfoNameField.setBounds(319, 227, 110, 20);
        panel.add(medInfoNameField);
        
        medInfoPhoneField = new JTextField(medInfoPhone);
        medInfoPhoneField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        medInfoPhoneField.setColumns(10);
        medInfoPhoneField.setBounds(319, 252, 109, 20);
        panel.add(medInfoPhoneField);
        
        JLabel medInfoPhoneLabel = new JLabel("Phone:");
        medInfoPhoneLabel.setBounds(267, 255, 46, 14);
        panel.add(medInfoPhoneLabel);
        
        JLabel additionalInformationLabel = new JLabel("Additional Information:");
        additionalInformationLabel.setBounds(10, 300, 152, 14);
        panel.add(additionalInformationLabel);
        
        optionalInfoField = new JTextArea(editPilot.getOptionalInfo());
        optionalInfoField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        optionalInfoField.setBounds(10, 325, 450, 88);
        panel.add(optionalInfoField);
        optionalInfoField.setColumns(10);
        
        JLabel RequiredNoteLabel = new JLabel("* Indicates required field");
        RequiredNoteLabel.setBounds(10, 419, 200, 14);
        panel.add(RequiredNoteLabel);
        
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(0, 438, 89, 23);
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                submitData();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.setEnabled(isEditEntry);
        deleteButton.setBounds(90, 438, 89, 23);
        panel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                deleteCommand();
            }
        });
        
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(180, 438, 89, 23);
        panel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                clearData();
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(270, 438, 89, 23);
        panel.add(cancelButton);
        
        JLabel flightWeightUnits = new JLabel("kgs");
        flightWeightUnits.setBounds(280, 86, 46, 14);
        panel.add(flightWeightUnits);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                cancelCommand();
            }
        });

    }
        
    protected void submitData(){
        if (isComplete()){
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String middleName = middleNameField.getText();
            String emergencyContact = emergencyContactNameField.getText() +
                    "%" + emergencyContactPhoneField.getText();
            String medicalInformation = medInfoNameField.getText() +
                    "%" + medInfoPhoneField.getText();
            String optionalInformation = optionalInfoField.getText();
            int weight = 0;
            try {
                weight = Integer.parseInt(flightWeightField.getText());
            }catch (NumberFormatException e) {
                weight = -1;
            }
            String capability = pilotCapability.getSelection().getActionCommand();
            String preference = pilotLaunchPref.getSelection().getActionCommand();
            String newPilotId = currentPilot.getPilotId();
            if (!isEditEntry){
                newPilotId = firstName+middleName+lastName;
            }

            Pilot newPilot = new Pilot(newPilotId, firstName, lastName, middleName, 
                    weight, capability, preference, emergencyContact,
                    medicalInformation, optionalInformation);
            try{
                if (isEditEntry){
                    DatabaseEntryEdit.UpdateEntry(newPilot);
                }
                else{
                    DatabaseUtilities.DatabaseDataObjectUtilities.addPilotToDB(newPilot);
                }
                CurrentDataObjectSet ObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
                ObjectSet.setCurrentPilot(newPilot);
                JOptionPane.showMessageDialog(rootPane, "Submission successfully saved.");
                parent.update();
                this.dispose();
            }catch(SQLException e1) {
                e1.printStackTrace();
                if(e1.getErrorCode() == 30000)
                    System.out.println(e1.getMessage());
                    //JOptionPane.showMessageDialog(rootPane, "Sorry, but the pilot " + newPilot.toString() + " already exists in the database");
            }catch (ClassNotFoundException e2) {
                JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.");
            }catch (Exception e3) {
                System.out.println(e3.getMessage());
                //e3.printStackTrace();
            }
        }
    }
    
    public void deleteCommand(){
        try{
            DatabaseEntryDelete.DeleteEntry(currentPilot);
            CurrentDataObjectSet objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
            objectSet.clearPilot();
            JOptionPane.showMessageDialog(rootPane, currentPilot.toString() + " successfully deleted.");
            parent.update();
            this.dispose();
        }catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.");
        }catch (Exception e3) {
            System.out.println("NNNNNNN");
            e3.printStackTrace();
            //System.out.println(e3.getMessage());
        }   
    }
    
    public void cancelCommand(){
        this.dispose();
    }
    
    public boolean isComplete()
    {
        ErrWindow ew;
        try
        {
            boolean emptyFields = false;
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String weightStr = flightWeightField.getText();
            firstNameField.setBackground(Color.WHITE);
            lastNameField.setBackground(Color.WHITE);
            flightWeightField.setBackground(Color.WHITE);
            
            if(firstName.isEmpty())
            {
                firstNameField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(lastName.isEmpty())
            {
                lastNameField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(weightStr.isEmpty())
            {
                flightWeightField.setBackground(Color.PINK);
                emptyFields = true;
            }
            
            if(pilotCapability.getSelection() == null){
                if (pilotLaunchPref.getSelection() == null){
                    throw new Exception("Select Capability and Launch Pref");
                }
                throw new Exception("Select Capability");
            }
            
            if(pilotLaunchPref.getSelection() == null){
                throw new Exception("Select Launch Preference");
            }
            
            if (emptyFields){
                throw new Exception("");
            }
            
            if (!weightStr.isEmpty()){
                Integer.parseInt(weightStr);
            }
            
        }catch(NumberFormatException e){
            ew = new ErrWindow("Please input a numerical weight value");
            return false;
        }catch(Exception e){
            ew = new ErrWindow("Please complete all required fields\n" + e.getMessage());
            return false;
        }
        return true;
    }
    
    public void clearData(){
        firstNameField.setText("");
	lastNameField.setText("");
	middleNameField.setText("");
	flightWeightField.setText("");
        pilotCapability.clearSelection();
        pilotLaunchPref.clearSelection();
        emergencyContactNameField.setText("");
        emergencyContactPhoneField.setText("");
	medInfoNameField.setText("");
	medInfoPhoneField.setText("");
	optionalInfoField.setText("");
        
        firstNameField.setBackground(Color.WHITE);
	lastNameField.setBackground(Color.WHITE);
	flightWeightField.setBackground(Color.WHITE);
    }
}
