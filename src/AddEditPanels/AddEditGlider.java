package AddEditPanels;

import DataObjects.CurrentDataObjectSet;
import DataObjects.Sailplane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class AddEditGlider extends JFrame {

    private JPanel contentPane;
    private JTextField nNumField;
    private JTextField emptyWeightField;
    private JTextField maxGrossWeightField;
    private JTextField indicatedStallSpeedField;
    private JTextField maxWinchingSpeedField;
    private JCheckBox chckbxCanCarryBallast;
    private JCheckBox chckbxSecondSeat;
    private Sailplane sailplaneEdited;
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
                                    AddEditGlider frame = new AddEditGlider(sample, true);
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
            setTitle("Glider");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 450, 300);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblNnumber = new JLabel("N-Number:");
            lblNnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblNnumber.setBounds(10, 11, 85, 14);
            contentPane.add(lblNnumber);

            JLabel lblNewLabel = new JLabel("Empty Weight:");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblNewLabel.setBounds(10, 42, 105, 14);
            contentPane.add(lblNewLabel);

            JLabel lblMaxGrossWeight = new JLabel("Max Gross Weight:");
            lblMaxGrossWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblMaxGrossWeight.setBounds(10, 73, 131, 14);
            contentPane.add(lblMaxGrossWeight);

            JLabel lblIndicatedStallSpeed = new JLabel("Indicated Stall Speed:");
            lblIndicatedStallSpeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblIndicatedStallSpeed.setBounds(10, 104, 144, 14);
            contentPane.add(lblIndicatedStallSpeed);

            JLabel lblMaxWinchingSpeed = new JLabel("Max Winching Speed:");
            lblMaxWinchingSpeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblMaxWinchingSpeed.setBounds(10, 135, 144, 14);
            contentPane.add(lblMaxWinchingSpeed);

            nNumField = new JTextField(sailplaneEdited.getNumber());
            nNumField.setColumns(10);
            nNumField.setBounds(180, 10, 100, 20);
            contentPane.add(nNumField);

            emptyWeightField = new JTextField(Integer.toString(sailplaneEdited.getEmptyWeight()));
            emptyWeightField.setColumns(10);
            emptyWeightField.setBounds(180, 41, 100, 20);
            contentPane.add(emptyWeightField);

            maxGrossWeightField = new JTextField(Integer.toString(sailplaneEdited.getMaximumGrossWeight()));
            maxGrossWeightField.setColumns(10);
            maxGrossWeightField.setBounds(180, 72, 100, 20);
            contentPane.add(maxGrossWeightField);

            indicatedStallSpeedField = new JTextField(Integer.toString(sailplaneEdited.getIndicatedStallSpeed()));
            indicatedStallSpeedField.setBounds(180, 103, 100, 20);
            contentPane.add(indicatedStallSpeedField);
            indicatedStallSpeedField.setColumns(10);

            maxWinchingSpeedField = new JTextField(Integer.toString(sailplaneEdited.getMaximumWinchingSpeed()));
            maxWinchingSpeedField.setColumns(10);
            maxWinchingSpeedField.setBounds(180, 134, 100, 20);
            contentPane.add(maxWinchingSpeedField);

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
            contentPane.add(label_2);

            chckbxSecondSeat = new JCheckBox("Singled Seated?", sailplaneEdited.getCarryBallast());
            chckbxSecondSeat.setHorizontalTextPosition(SwingConstants.LEADING);
            chckbxSecondSeat.setFont(new Font("Tahoma", Font.PLAIN, 14));
            chckbxSecondSeat.setBounds(10, 166, 144, 23);
            contentPane.add(chckbxSecondSeat);

            chckbxCanCarryBallast = new JCheckBox("Can carry ballast?", sailplaneEdited.getCarryBallast());
            chckbxCanCarryBallast.setHorizontalTextPosition(SwingConstants.LEADING);
            chckbxCanCarryBallast.setFont(new Font("Tahoma", Font.PLAIN, 14));
            chckbxCanCarryBallast.setBounds(10, 197, 144, 23);
            contentPane.add(chckbxCanCarryBallast);

            JButton submitButton = new JButton("Submit");
            submitButton.setBounds(0, 239, 89, 23);
            contentPane.add(submitButton);
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    //submitData();
                }
            });

            JButton clearButton = new JButton("Clear");
            clearButton.setBounds(90, 239, 89, 23);
            contentPane.add(clearButton);
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    clearData();
                }
            });

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setBounds(180, 239, 89, 23);
            contentPane.add(cancelButton);
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    cancelCommand();
                }
            });
    }
    
    /*public void submitData(){
        if (isComplete()){
            Sailplane sailplane = sailplaneEdited;
            String firstName = pilotRequiredPanel.getPilotFirstName();
            String lastName = pilotRequiredPanel.getPilotLastName();
            String middleName = pilotRequiredPanel.getPilotMiddleName();
            String emergencyContact = pilotOptionalPanel.getEmergencyContact();
            String medicalInformation = pilotOptionalPanel.getMedicalInformation();
            String optionalInformation = pilotOptionalPanel.getOptionalInformation();
            int weight = 0;
            try {
                weight = (int) ((int) pilotRequiredPanel.getWeight() * (1 / Configuration.UnitConversionRate.convertWeightUnitIndexToFactor(DatabaseUtilities.DatabaseUnitSelectionUtilities.getPilotWeightUnit())));
            } catch (ClassNotFoundException e1) {

            }
            String capability = pilotRequiredPanel.getCapability();
            String preference = pilotRequiredPanel.getPreference();

            Pilot newPilot = new Pilot("" ,lastName, firstName, middleName, 
                    weight, capability, preference, emergencyContact,
                    medicalInformation, optionalInformation);
            try{
                if (isEditEntry){
                    DatabaseUtilities.DatabaseDataObjectUtilities.deletePilot(oldPilot);
                }
                DatabaseUtilities.DatabaseDataObjectUtilities.addPilotToDB(newPilot);
                CurrentDataObjectSet ObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
                ObjectSet.setCurrentPilot(newPilot);
                JOptionPane.showMessageDialog(rootPane, "Submission successfully saved.");
                this.dispose();
            }catch(SQLException e1) {
                if(e1.getErrorCode() == 30000)
                    JOptionPane.showMessageDialog(rootPane, "Sorry, but the pilot " + newPilot.toString() + " already exists in the database");
            }catch (ClassNotFoundException e2) {
                JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.");
            }
        }
    }*/
    
    public boolean isComplete(){
       return true; 
    }
    
    public void clearData(){
        nNumField.setText("");
        emptyWeightField.setText("");
        maxGrossWeightField.setText("");
        indicatedStallSpeedField.setText("");
        maxWinchingSpeedField.setText("");
        chckbxCanCarryBallast.setSelected(false);
        chckbxSecondSeat.setSelected(false);
    }
    
    public void cancelCommand(){
        this.dispose();
    }

}
