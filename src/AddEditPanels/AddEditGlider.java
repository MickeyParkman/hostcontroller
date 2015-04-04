package AddEditPanels;

import Communications.Observer;
import Configuration.UnitConversionRate;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Sailplane;
import DatabaseUtilities.DatabaseEntryDelete;
import DatabaseUtilities.DatabaseEntryEdit;
import DatabaseUtilities.DatabaseEntryIdCheck;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class AddEditGlider extends JFrame {

    private JPanel contentPane;
    private JTextField nNumberField;
    private JTextField emptyWeightField;
    private JTextField grossWeightField;
    private JTextField stallSpeedField;
    private JTextField weakLinkField;
    private JTextField tensionField;
    private JTextField releaseAngleField;
    private JTextField winchingSpeedField;
    private JCheckBox ballastCheckBox;
    private JCheckBox multipleSeatsCheckBox;
    private Sailplane currentGlider;
    private boolean isEditEntry;
    private Observer parent;
    
    public void attach(Observer o)
    {
        parent = o;
    }
    
    
    /**
     * Create the frame.
     */
    public AddEditGlider(Sailplane sailplaneEdited, boolean isEditEntry) {
        
        this.isEditEntry = isEditEntry;

        if (!isEditEntry || sailplaneEdited == null){
            sailplaneEdited = new Sailplane("", "", 0, 0, 0, 0, 0, 0, 0, false, false, "");
        }
        currentGlider = sailplaneEdited;
        
        setTitle("Glider");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 650, 242);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel nNumberLabel = new JLabel("N Number:");
        nNumberLabel.setBounds(10, 11, 86, 14);
        contentPane.add(nNumberLabel);
        
        JLabel emptyWeightLabel = new JLabel("Empty Weight:");
        emptyWeightLabel.setBounds(10, 36, 86, 14);
        contentPane.add(emptyWeightLabel);
        
        JLabel maxGrossWeightLabel = new JLabel("Max Gross Weight:");
        maxGrossWeightLabel.setBounds(10, 61, 117, 14);
        contentPane.add(maxGrossWeightLabel);
        
        JLabel lblIndicatedStallSpeed = new JLabel("Indicated Stall Speed:");
        lblIndicatedStallSpeed.setBounds(10, 86, 140, 14);
        contentPane.add(lblIndicatedStallSpeed);
        
        stallSpeedField = new JTextField();
        if (isEditEntry){
            stallSpeedField.setText(String.valueOf(currentGlider.getIndicatedStallSpeed()));
        }
        stallSpeedField.setBounds(160, 83, 110, 20);
        contentPane.add(stallSpeedField);
        stallSpeedField.setColumns(10);
        
        grossWeightField = new JTextField();
        if (isEditEntry){
            grossWeightField.setText(String.valueOf(currentGlider.getMaxGrossWeight()));
        }
        grossWeightField.setBounds(160, 58, 110, 20);
        contentPane.add(grossWeightField);
        grossWeightField.setColumns(10);
        
        emptyWeightField = new JTextField();
        if (isEditEntry){
            emptyWeightField.setText(String.valueOf(currentGlider.getEmptyWeight()));
        }
        emptyWeightField.setBounds(160, 33, 110, 20);
        contentPane.add(emptyWeightField);
        emptyWeightField.setColumns(10);
        
        nNumberField = new JTextField(currentGlider.getNumber());
        nNumberField.setBounds(160, 8, 110, 20);
        contentPane.add(nNumberField);
        nNumberField.setColumns(10);
        
        ballastCheckBox = new JCheckBox("Can Carry Ballast?");
        ballastCheckBox.setSelected(currentGlider.getCarryBallast());
        ballastCheckBox.setBounds(10, 117, 154, 23);
        contentPane.add(ballastCheckBox);
        
        JLabel maxWinchingSpeedLabel = new JLabel("Max Winching Speed:");
        maxWinchingSpeedLabel.setBounds(320, 11, 140, 14);
        contentPane.add(maxWinchingSpeedLabel);
        
        JLabel maxWeakLinkLabel = new JLabel("Max Weak Link Strength:");
        maxWeakLinkLabel.setBounds(320, 36, 159, 14);
        contentPane.add(maxWeakLinkLabel);
        
        JLabel maxTensionLabel = new JLabel("Max Tension:");
        maxTensionLabel.setBounds(320, 61, 140, 14);
        contentPane.add(maxTensionLabel);
        
        JLabel cableReleaseAngleLabel = new JLabel("Cable Release Angle:");
        cableReleaseAngleLabel.setBounds(320, 86, 140, 14);
        contentPane.add(cableReleaseAngleLabel);
        
        multipleSeatsCheckBox = new JCheckBox("Multiple Seats?");
        multipleSeatsCheckBox.setSelected(currentGlider.getMultipleSeats());
        multipleSeatsCheckBox.setBounds(320, 117, 159, 23);
        contentPane.add(multipleSeatsCheckBox);
        
        weakLinkField = new JTextField();
        if (isEditEntry){
            weakLinkField.setText(String.valueOf(currentGlider.getMaxWeakLinkStrength()));
        }
        weakLinkField.setBounds(487, 33, 120, 20);
        contentPane.add(weakLinkField);
        weakLinkField.setColumns(10);
        
        tensionField = new JTextField();
        if (isEditEntry){
            tensionField.setText(String.valueOf(currentGlider.getMaxTension()));
        }
        tensionField.setBounds(487, 58, 120, 20);
        contentPane.add(tensionField);
        tensionField.setColumns(10);
        
        releaseAngleField = new JTextField();
        if (isEditEntry){
            releaseAngleField.setText(String.valueOf(currentGlider.getCableReleaseAngle()));
        }
        releaseAngleField.setBounds(487, 83, 120, 20);
        contentPane.add(releaseAngleField);
        releaseAngleField.setColumns(10);
        
        winchingSpeedField = new JTextField();
        if (isEditEntry){
            winchingSpeedField.setText(String.valueOf(currentGlider.getMaxWinchingSpeed()));
        }
        winchingSpeedField.setBounds(487, 8, 120, 20);
        contentPane.add(winchingSpeedField);
        winchingSpeedField.setColumns(10);
        
        JLabel RequiredNoteLabel = new JLabel("All fields required");
        RequiredNoteLabel.setBounds(10, 150, 200, 14);
        contentPane.add(RequiredNoteLabel);

/*
        JLabel lblUnits = new JLabel("Units*");
        lblUnits.setBounds(290, 44, 46, 14);
        contentPane.add(lblUnits);

        JLabel label = new JLabel("Units*");
        label.setBounds(290, 75, 46, 14);
        contentPane.add(label);

        JLabel label_1 = new JLabel("Units*");
        label_1.setBounds(290, 106, 46, 14);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("Units*");
        label_2.setBounds(290, 137, 46, 14);
        contentPane.add(label_2);*/

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(0, 180, 89, 23);
        submitButton.setBackground(new Color(200,200,200));
        contentPane.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                submitData();
            }
        });
        
        JButton deleteButton = new JButton("Delete");
        deleteButton.setEnabled(isEditEntry);
        deleteButton.setBounds(90, 180, 89, 23);
        deleteButton.setBackground(new Color(200,200,200));
        contentPane.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                deleteCommand();
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(180, 180, 89, 23);
        clearButton.setBackground(new Color(200,200,200));
        contentPane.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                clearData();
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(270, 180, 89, 23);
        cancelButton.setBackground(new Color(200,200,200));
        contentPane.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                cancelCommand();
            }
        });
    }
    
    public void deleteCommand(){
        try{
            int choice = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete " + currentGlider.getNumber() + "?",
                "Delete Glider", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (choice == 0){
                DatabaseEntryDelete.DeleteEntry(currentGlider);
                CurrentDataObjectSet objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
                objectSet.clearGlider();
                JOptionPane.showMessageDialog(rootPane, currentGlider.toString() + " successfully deleted.");
                parent.update();
                this.dispose();
            }
        }catch (ClassNotFoundException e1) {
            JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e2){
            System.out.println(e2.getMessage());
        }
    }
    
    public void submitData(){
        if (isComplete()){
            String nNumber = nNumberField.getText();
            float emptyWeight = Float.parseFloat(emptyWeightField.getText()) / UnitConversionRate.convertWeightUnitIndexToFactor(0);
            float grossWeight = Float.parseFloat(grossWeightField.getText()) / UnitConversionRate.convertWeightUnitIndexToFactor(0);
            float stallSpeed = Float.parseFloat(stallSpeedField.getText()) / UnitConversionRate.convertSpeedUnitIndexToFactor(0);
            float weakLink = Float.parseFloat(weakLinkField.getText()) / UnitConversionRate.convertTensionUnitIndexToFactor(0);
            float tension = Float.parseFloat(tensionField.getText()) / UnitConversionRate.convertTensionUnitIndexToFactor(0);
            float releaseAngle = Float.parseFloat(releaseAngleField.getText());
            float winchingSpeed = Float.parseFloat(winchingSpeedField.getText()) / UnitConversionRate.convertSpeedUnitIndexToFactor(0);
            boolean carryBallast = ballastCheckBox.isSelected();
            boolean multipleSeats = multipleSeatsCheckBox.isSelected();
            
            Sailplane newGlider = new Sailplane(nNumber ,"", grossWeight,
                    emptyWeight, stallSpeed, winchingSpeed, weakLink, tension,
                    releaseAngle, carryBallast, multipleSeats, "");
            newGlider.setId(currentGlider.getId());
            

            try{
                CurrentDataObjectSet ObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
                ObjectSet.setCurrentGlider(newGlider);
                Object[] options = {"One-time Launch", "Save to Database"};
                int choice = JOptionPane.showOptionDialog(rootPane, "Do you want to use this Glider for a one-time launch or save it to the database?",
                    "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                System.out.println(choice);
                if (choice == 0){
                    parent.update();
                    this.dispose();
                }
                else
                {
                    if (isEditEntry){
                        DatabaseEntryEdit.UpdateEntry(newGlider);
                    }
                    else{
                        Random randomId = new Random();
                        newGlider.setId(String.valueOf(randomId.nextInt(100000000)));
                        while (DatabaseEntryIdCheck.IdCheck(newGlider)){
                            newGlider.setId(String.valueOf(randomId.nextInt(100000000)));
                        }
                        DatabaseUtilities.DatabaseDataObjectUtilities.addSailplaneToDB(newGlider);
                    }

                    parent.update();
                    this.dispose();
                } 
            }catch(SQLException e1) {
                e1.printStackTrace();
                if(e1.getErrorCode() == 30000)
                    JOptionPane.showMessageDialog(rootPane, "Sorry, but the glider " + newGlider.toString() + " already exists in the database", "Error", JOptionPane.INFORMATION_MESSAGE);
            }catch (ClassNotFoundException e2) {
                JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }
    
    public boolean isComplete(){
        ErrWindow ew;
        try
        {
            boolean emptyFields = false;
            String nNumber = nNumberField.getText();
            String emptyWeight = emptyWeightField.getText();
            String grossWeight = grossWeightField.getText();
            String stallSpeed = stallSpeedField.getText();
            String weakLink = weakLinkField.getText();
            String tension = tensionField.getText();
            String releaseAngle = releaseAngleField.getText();
            String winchingSpeed = winchingSpeedField.getText();
            
            nNumberField.setBackground(Color.WHITE);
            emptyWeightField.setBackground(Color.WHITE);
            grossWeightField.setBackground(Color.WHITE);
            stallSpeedField.setBackground(Color.WHITE);
            weakLinkField.setBackground(Color.WHITE);
            tensionField.setBackground(Color.WHITE);
            releaseAngleField.setBackground(Color.WHITE);
            winchingSpeedField.setBackground(Color.WHITE);
            
            if(nNumber.isEmpty())
            {
                nNumberField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(emptyWeight.isEmpty())
            {
                emptyWeightField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(grossWeight.isEmpty())
            {
                grossWeightField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(stallSpeed.isEmpty())
            {
                stallSpeedField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(weakLink.isEmpty())
            {
                weakLinkField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(tension.isEmpty())
            {
                tensionField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(releaseAngle.isEmpty())
            {
                releaseAngleField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(winchingSpeed.isEmpty())
            {
                winchingSpeedField.setBackground(Color.PINK);
                emptyFields = true;
            }    
            if (emptyFields){
                throw new Exception("");
            }
            
            Float.parseFloat(emptyWeight);
            Float.parseFloat(grossWeight);
            Float.parseFloat(stallSpeed);
            Float.parseFloat(weakLink);
            Float.parseFloat(tension);
            Float.parseFloat(releaseAngle);
            Float.parseFloat(winchingSpeed);
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Please input a numerical values", "Error", JOptionPane.INFORMATION_MESSAGE);
            //ew = new ErrWindow("Please input a numerical values");
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Please complete all required fields\n" + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            ew = new ErrWindow("Please complete all required fields\n" + e.getMessage());
            return false;
        }
        return true;
    }
    
    public void clearData(){
        nNumberField.setText("");
        emptyWeightField.setText("");
        grossWeightField.setText("");
        stallSpeedField.setText("");
        winchingSpeedField.setText("");
        weakLinkField.setText("");
        tensionField.setText("");
        releaseAngleField.setText("");
        ballastCheckBox.setSelected(false);
        multipleSeatsCheckBox.setSelected(false);
        
        nNumberField.setBackground(Color.WHITE);
        emptyWeightField.setBackground(Color.WHITE);
        grossWeightField.setBackground(Color.WHITE);
        stallSpeedField.setBackground(Color.WHITE);
        winchingSpeedField.setBackground(Color.WHITE);
        weakLinkField.setBackground(Color.WHITE);
        tensionField.setBackground(Color.WHITE);
        releaseAngleField.setBackground(Color.WHITE);
    }
    
    public void cancelCommand(){
        this.dispose();
    }

}
