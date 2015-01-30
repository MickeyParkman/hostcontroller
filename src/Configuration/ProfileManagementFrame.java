package Configuration;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class ProfileManagementFrame extends JFrame {

	private JPanel contentPane;
	private ProfilePilotPanel ProfilePilotPanel;
	private ProfileGliderPanel ProfileGliderPanel;
	private ProfileAirfieldPanel ProfileAirfieldPanel;
	private ProfileWinchPanel ProfileWinchPanel;
	private ProfileOtherPanel ProfileOtherPanel;
        private SaveAsNewFrame SaveAsNewFrame;
                
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileManagementFrame frame = new ProfileManagementFrame();
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
	public ProfileManagementFrame() {
		setTitle("Profile Management");
		ProfilePilotPanel = new ProfilePilotPanel();
		ProfileGliderPanel = new ProfileGliderPanel();
		ProfileAirfieldPanel = new ProfileAirfieldPanel();
		ProfileWinchPanel = new ProfileWinchPanel();
		ProfileOtherPanel = new ProfileOtherPanel();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea txtrProfileList = new JTextArea();
		txtrProfileList.setText("Profile List");
		txtrProfileList.setColumns(12);
		contentPane.add(txtrProfileList, BorderLayout.WEST);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("Save");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save as new");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            SaveAsNewFrame = new SaveAsNewFrame();
                            SaveAsNewFrame.setVisible(true);
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reset to default");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cancel");
		panel.add(btnNewButton_3);
		
		tabbedPane.addTab("Pilot", ProfilePilotPanel);
		tabbedPane.addTab("Glider", ProfileGliderPanel);
		tabbedPane.addTab("Airfield", ProfileAirfieldPanel);
		tabbedPane.addTab("Winch", ProfileWinchPanel);
		tabbedPane.addTab("Other", ProfileOtherPanel);
	}

}
