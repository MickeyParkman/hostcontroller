package Configuration;

import DataObjects.Profile;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;



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
            }
            catch(SQLException e) 
            {   
            } 
            catch (ClassNotFoundException ex) 
            {     
            }
        }

        /**
        * Creates new ProfileManagementFrame
        */
        public ProfileManagementFrame()
        {
           initProfileList();
           initComponents();
        }
        
        private ProfileManagementFrame getCurrentProfileManagementFrame()
        {
            return this;
        }
        
        public void Rebuild()
        {
            initProfileList();
            DefaultListModel profileModel = new DefaultListModel();
            for(Object str: names){
                profileModel.addElement(str);
            }
            profileJList.setModel(profileModel);
            profileScrollPane.setViewportView(profileJList);
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
		setBounds(100, 100, 1071, 704);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(profileScrollPane, BorderLayout.WEST);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton saveButton = new JButton("Save");
                saveButton.setBackground(new Color(200,200,200));
		panel.add(saveButton);
		
		JButton saveAsNewButton = new JButton("Save as new");
                saveAsNewButton.setBackground(new Color(200,200,200));
		saveAsNewButton.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
                            SaveAsNewFrame = new SaveAsNewFrame();
                            SaveAsNewFrame.setParent(getCurrentProfileManagementFrame());
                            SaveAsNewFrame.setVisible(true);
			}
		});
		panel.add(saveAsNewButton);
		
                profileJList.setPreferredSize(new Dimension(200,100));
                DefaultListModel profileModel = new DefaultListModel();
                for(Object str: names){
                    profileModel.addElement(str);
                }
                profileJList.setModel(profileModel);
                profileScrollPane.setViewportView(profileJList);
                
		JButton resetButton = new JButton("Reset to default");
                resetButton.setBackground(new Color(200,200,200));
		panel.add(resetButton);
		
		JButton cancelButton = new JButton("Cancel");
                cancelButton.setBackground(new Color(200,200,200));
                cancelButton.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
                            dispose();
			}
		});
		panel.add(cancelButton);
                
		tabbedPane.addTab("Pilot", ProfilePilotPanel);
		tabbedPane.addTab("Glider", ProfileGliderPanel);
		tabbedPane.addTab("Airfield", ProfileAirfieldPanel);
		tabbedPane.addTab("Display", ProfileWinchPanel);
	}

}
