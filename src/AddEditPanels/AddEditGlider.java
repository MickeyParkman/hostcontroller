package AddEditPanels;

import DataObjects.CurrentDataObjectSet;
import DataObjects.Sailplane;
import DatabaseUtilities.DatabaseEntryDelete;
import DatabaseUtilities.DatabaseEntryEdit;

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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                    public void run() {
                            try {
                                    Sailplane sample = new Sailplane("N-num", "The type",
                                            100, 200, 300, 400, 500, 600, 700, true, "Optional");
                                    AddEditGlider frame = new AddEditGlider(sample, false);
                                    frame.setVisible(true);
                            } catch (Exception e) {
                                    e.printStackTrace();
                            }
                    }
            });
    }

    /**
     * Create the frame.
     */
    public AddEditGlider(Sailplane sailplaneEdited, boolean isEditEntry) {
        if (!isEditEntry){
            sailplaneEdited = new Sailplane("", "", 0, 0, 0, 0, 0, 0, 0, false, "");
        }
        currentGlider = sailplaneEdited;
        this.isEditEntry = isEditEntry;
        setTitle("Glider");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            stallSpeedField.setText(Integer.toString(currentGlider.getIndicatedStallSpeed()));
        }
        stallSpeedField.setBounds(160, 83, 110, 20);
        contentPane.add(stallSpeedField);
        stallSpeedField.setColumns(10);
        
        grossWeightField = new JTextField();
        if (isEditEntry){
            grossWeightField.setText(Integer.toString(currentGlider.getMaxGrossWeight()));
        }
        grossWeightField.setBounds(160, 58, 110, 20);
        contentPane.add(grossWeightField);
        grossWeightField.setColumns(10);
        
        emptyWeightField = new JTextField();
        if (isEditEntry){
            emptyWeightField.setText(Integer.toString(currentGlider.getEmptyWeight()));
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
        multipleSeatsCheckBox.setSelected(false);//Needs to change to curGlider.getSeats
        multipleSeatsCheckBox.setBounds(320, 117, 159, 23);
        contentPane.add(multipleSeatsCheckBox);
        
        weakLinkField = new JTextField();
        if (isEditEntry){
            weakLinkField.setText(Integer.toString(currentGlider.getMaxWeakLinkStrength()));
        }
        weakLinkField.setBounds(487, 33, 120, 20);
        contentPane.add(weakLinkField);
        weakLinkField.setColumns(10);
        
        tensionField = new JTextField();
        if (isEditEntry){
            tensionField.setText(Integer.toString(currentGlider.getMaxTension()));
        }
        tensionField.setBounds(487, 58, 120, 20);
        contentPane.add(tensionField);
        tensionField.setColumns(10);
        
        releaseAngleField = new JTextField();
        if (isEditEntry){
            releaseAngleField.setText(Integer.toString(currentGlider.getCableReleaseAngle()));
        }
        releaseAngleField.setBounds(487, 83, 120, 20);
        contentPane.add(releaseAngleField);
        releaseAngleField.setColumns(10);
        
        winchingSpeedField = new JTextField();
        if (isEditEntry){
            winchingSpeedField.setText(Integer.toString(currentGlider.getMaxWinchingSpeed()));
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
        contentPane.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                deleteCommand();
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(180, 180, 89, 23);
        contentPane.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                clearData();
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(270, 180, 89, 23);
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
            DatabaseEntryDelete.DeleteEntry(currentGlider);
            CurrentDataObjectSet ObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
            ObjectSet.setCurrentGlider(currentGlider); //set new glider to null
            JOptionPane.showMessageDialog(rootPane, "Submission successfully saved.");
            this.dispose();
        }catch(SQLException e1) {
            if(e1.getErrorCode() == 30000)
                JOptionPane.showMessageDialog(rootPane, "Sorry, but the glider " + currentGlider.toString() + " already exists in the database");
        }catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.");
        }catch (Exception e3){
            System.out.println(e3.getMessage());
        }
    }
    
    public void submitData(){
        if (isComplete()){
            Sailplane oldGlider = currentGlider;
            String nNumber = nNumberField.getText();
            int emptyWeight = Integer.parseInt(emptyWeightField.getText());
            int grossWeight = Integer.parseInt(grossWeightField.getText());
            int stallSpeed = Integer.parseInt(stallSpeedField.getText());
            int weakLink = Integer.parseInt(weakLinkField.getText());
            int tension = Integer.parseInt(tensionField.getText());
            int releaseAngle = Integer.parseInt(releaseAngleField.getText());
            int winchingSpeed = Integer.parseInt(winchingSpeedField.getText());
            boolean carryBallast = ballastCheckBox.isSelected();
            boolean multipleSeats = multipleSeatsCheckBox.isSelected();
            Sailplane newGlider = new Sailplane(nNumber ,"", grossWeight,
                    emptyWeight, stallSpeed, winchingSpeed, weakLink, tension,
                    releaseAngle, carryBallast, "");
            try{
                if (isEditEntry){
                    DatabaseEntryDelete.DeleteEntry(oldGlider);
                }
                DatabaseUtilities.DatabaseDataObjectUtilities.addSailplaneToDB(newGlider);
                CurrentDataObjectSet ObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
                ObjectSet.setCurrentGlider(newGlider);
                JOptionPane.showMessageDialog(rootPane, "Submission successfully saved.");
                this.dispose();
            }catch(SQLException e1) {
                if(e1.getErrorCode() == 30000)
                    JOptionPane.showMessageDialog(rootPane, "Sorry, but the glider " + newGlider.toString() + " already exists in the database");
            }catch (ClassNotFoundException e2) {
                JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.");
            }catch (Exception e3){
                System.out.println(e3.getMessage());
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
            //Integer.parseInt(nNumber);
            Integer.parseInt(emptyWeight);
            Integer.parseInt(grossWeight);
            Integer.parseInt(stallSpeed);
            Integer.parseInt(weakLink);
            Integer.parseInt(tension);
            Integer.parseInt(releaseAngle);
            Integer.parseInt(winchingSpeed);
            
        }catch(NumberFormatException e){
            ew = new ErrWindow("Please input a numerical values");
            return false;
        }catch(Exception e){
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
