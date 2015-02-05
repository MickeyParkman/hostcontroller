package Wizards;

import DataObjects.Pilot;
import ParameterSelection.Capability;
import ParameterSelection.Preference;
import java.awt.BorderLayout;
import java.awt.EventQueue;
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
    //private EditDatabase EditDatabasePanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEditPilotPanel frame = new AddEditPilotPanel();
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
	public AddEditPilotPanel() {
		pilotRequiredPanel = new PilotRequiredPanel();
		pilotOptionalPanel = new PilotOptionalPanel();
		//EditDatabasePanel = new EditDatabase();
		
		setTitle("New Pilot Wizard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnNewButton_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnCancel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Required Info", pilotRequiredPanel);
		tabbedPane.addTab("Optional Info", pilotOptionalPanel);
		//tabbedPane.addTab("asdfa", EditDatabasePanel);
	}
        
    protected void submitData(){
        String firstName = pilotRequiredPanel.getPilotFirstName();
        String lastName = pilotRequiredPanel.getPilotLastName();
        String middleName = pilotRequiredPanel.getPilotMiddleName();
        int weight = 0;
        try {
            weight = (int) ((int) pilotRequiredPanel.getWeight() * (1 / Configuration.UnitConversionRate.convertWeightUnitIndexToFactor(DatabaseUtilities.DatabaseUnitSelectionUtilities.getPilotWeightUnit())));
        } catch (ClassNotFoundException e1) {
            
        }
        //String capability = Capability.convertCapabilityNumToString(pilotRequiredPanel.getCapability());
        //String preference = Preference.convertPreferenceNumToString(pilotRequiredPanel.getPreference());
        
        Pilot newPilot = new Pilot(lastName, firstName, middleName, weight, "capability", "preference", "", "");
        try{
            DatabaseUtilities.DatabaseDataObjectUtilities.addPilotToDB(newPilot);
            JOptionPane.showMessageDialog(rootPane, "Submission successfully saved.");
            this.dispose();
        }catch(SQLException e1) {
            if(e1.getErrorCode() == 30000)
                JOptionPane.showMessageDialog(rootPane, "Sorry, but the pilot " + firstName + " " + lastName + " already exists in the database");
        }catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.");
        }   
    }
}
