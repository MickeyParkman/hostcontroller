package AddEditPanels;

import DataObjects.CurrentDataObjectSet;
import DataObjects.Pilot;
import ParameterSelection.Capability;
import ParameterSelection.Preference;
import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;


public class AddEditPilotPanel extends JFrame {
    private PilotOptionalPanel pilotOptionalPanel;
    private PilotRequiredPanel pilotRequiredPanel;
    private Pilot currentPilot;
    private boolean isEditEntry;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEditPilotPanel frame = new AddEditPilotPanel(new Pilot("123", "last", "first", "middle", 200, "Student", "Mild","contact","meds","optional"), true);
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
	public AddEditPilotPanel(Pilot editPilot, boolean isEditEntry) {
            if (!isEditEntry){
                editPilot = new Pilot("", "", "", "", 0, "", "", "", "", "");
            }
            this.isEditEntry = isEditEntry;
            currentPilot = editPilot;
            pilotRequiredPanel = new PilotRequiredPanel(editPilot);
            pilotOptionalPanel = new PilotOptionalPanel(editPilot);
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            setTitle("Pilot");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 450, 450);

            JPanel panel = new JPanel();
            getContentPane().add(panel, BorderLayout.SOUTH);
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));


            JButton submitButton = new JButton("Submit");
            submitButton.setHorizontalAlignment(SwingConstants.LEFT);
            panel.add(submitButton);
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    submitData();
                }
            });

            JButton clearButton = new JButton("Clear");
            clearButton.setHorizontalAlignment(SwingConstants.LEFT);
            panel.add(clearButton);
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    pilotRequiredPanel.clearData();
                    pilotOptionalPanel.clearData();
                }
            });

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setHorizontalAlignment(SwingConstants.LEFT);
            panel.add(cancelButton);
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    cancelCommand();
                }
            });

            JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
            getContentPane().add(tabbedPane, BorderLayout.CENTER);

            tabbedPane.addTab("Required Info", pilotRequiredPanel);
            tabbedPane.addTab("Optional Info", pilotOptionalPanel);
	}
        
    protected void submitData(){
        if (pilotRequiredPanel.isComplete()){
            Pilot oldPilot = currentPilot;
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
    }
    
    public void cancelCommand(){
        this.dispose();
    }
}
