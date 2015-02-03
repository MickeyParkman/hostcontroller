package Configuration;

import DataObjects.Profile;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class ProfileManagementFrame extends JFrame {

	private JPanel contentPane;
	private ProfilePilotPanel ProfilePilotPanel;
	private ProfileGliderPanel ProfileGliderPanel;
	private ProfileAirfieldPanel ProfileAirfieldPanel;
	private ProfileWinchPanel ProfileWinchPanel;
	private ProfileOtherPanel ProfileOtherPanel;
        private SaveAsNewFrame SaveAsNewFrame;
        private List<Profile> names = new ArrayList<Profile>();
        private JScrollPane profileScrollPane;
        private JList profileJList;
                
        private void initProfileList() 
        {
            try
            {
                names = DatabaseUtilities.DatabaseDataObjectUtilities.getProfiles();
                System.out.println(names);
            }
            catch(SQLException e) 
            {
                
            } 
            catch (ClassNotFoundException ex) 
            {
                
            }
        }
        
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/


        /**
        * Creates new ProfileManagementFrame
        */
        public ProfileManagementFrame()
        {
           initProfileList();
           initComponents();
        }
        
	private void initComponents() {
		setTitle("Profile Management");
		ProfilePilotPanel = new ProfilePilotPanel();
		ProfileGliderPanel = new ProfileGliderPanel();
		ProfileAirfieldPanel = new ProfileAirfieldPanel();
		ProfileWinchPanel = new ProfileWinchPanel();
		ProfileOtherPanel = new ProfileOtherPanel();
                profileScrollPane = new javax.swing.JScrollPane();
                profileJList = new javax.swing.JList();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		contentPane.add(profileScrollPane, BorderLayout.WEST);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("Save");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save as new");
		btnNewButton_1.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
                            SaveAsNewFrame = new SaveAsNewFrame();
                            SaveAsNewFrame.setVisible(true);
			}
		});
		panel.add(btnNewButton_1);
		
                
                DefaultListModel profileModel = new DefaultListModel();
                for(Object str: names){
                    profileModel.addElement(str);
                }
                profileJList.setModel(profileModel);
                profileScrollPane.setViewportView(profileJList);
                
		JButton btnNewButton_2 = new JButton("Reset to default");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cancel");
                btnNewButton_3.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
                            dispose();
			}
		});
		panel.add(btnNewButton_3);
		
		tabbedPane.addTab("Pilot", ProfilePilotPanel);
		tabbedPane.addTab("Glider", ProfileGliderPanel);
		tabbedPane.addTab("Airfield", ProfileAirfieldPanel);
		tabbedPane.addTab("Winch", ProfileWinchPanel);
		tabbedPane.addTab("Other", ProfileOtherPanel);
	}

}
