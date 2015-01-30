package mainhost;

import Configuration.ProfileManagementFrame;
import ParameterSelection.ParameterSelectionPanel;
import javax.swing.*;
import java.awt.Dimension;   
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.BoxLayout;

public class MainWindow extends JFrame {
	private String version = "2.0.1";
	private JMenuBar topMenu;
	private JPanel mainWindow;
	private String currentProfile;
	private JPanel leftSidePanelScenario;
	private JPanel leftSidePanelDashboard;
	private JLabel statusLabel;
	private JPanel rightSidePanel;
	private JPanel upperLeftSidePanel;
	private JPanel lowerLeftSidePanel;
	private JTabbedPane tabbedPane;
        private ParameterSelectionPanel ParameterSelectionPanel_;
        private ProfileManagementFrame ProfileManagementFrame;

	public MainWindow() {
            topMenu = new JMenuBar();
            mainWindow = new JPanel(new BorderLayout());
            leftSidePanelScenario = new JPanel();
            leftSidePanelDashboard = new JPanel();
            rightSidePanel = new JPanel();
            statusLabel = new JLabel();
            tabbedPane = new JTabbedPane(JTabbedPane.TOP);
            currentProfile = "NO PROFILE";
            ParameterSelectionPanel_ = new ParameterSelectionPanel();
            createAndShowGUI();
	}

    private void createAndShowGUI() {
    	setTitle("Winch Host Manager v" + version);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setUpMenus();
        setJMenuBar(topMenu);
        leftSidePanelScenario.setPreferredSize(new Dimension(200, 600));
        leftSidePanelDashboard.setPreferredSize(new Dimension(200, 600));
        leftSidePanelScenario.setBorder(BorderFactory.createLineBorder(Color.black));
        leftSidePanelDashboard.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JButton pilotButton = new JButton();
        pilotButton.setText("Select Pilot");
        pilotButton.setPreferredSize(new Dimension(180,20));
        JButton gliderButton = new JButton();
        gliderButton.setText("Select Glider");
        gliderButton.setPreferredSize(new Dimension(180,20));
        JButton airfieldButton = new JButton();
        airfieldButton.setText("Select Airfield");
        airfieldButton.setPreferredSize(new Dimension(180,20));
        
        leftSidePanelScenario.add(pilotButton);        
        leftSidePanelScenario.add(gliderButton);   
        leftSidePanelScenario.add(airfieldButton);
        
        rightSidePanel.setPreferredSize(new Dimension(200, 600));

        tabbedPane.setPreferredSize(new Dimension(800, 600));
        tabbedPane.addTab("Edit Scenario", makePanel(ParameterSelectionPanel_, 1));
        tabbedPane.addTab("Flight Dashboard", makePanel(new JPanel(),2));
        mainWindow.add(tabbedPane, BorderLayout.CENTER);

        mainWindow.add(rightSidePanel, BorderLayout.LINE_END);

        //mainWindow.add(leftSidePanel, BorderLayout.LINE_START);
        /*upperLeftSidePanel = new JPanel();
        upperLeftSidePanel.setPreferredSize(new Dimension(200,300));
        lowerLeftSidePanel = new JPanel();
        lowerLeftSidePanel.setPreferredSize(new Dimension(200,300));
        leftSidePanel.add(upperLeftSidePanel);
        leftSidePanel.add(lowerLeftSidePanel);*/

        mainWindow.add(statusLabel, BorderLayout.PAGE_END);
        statusLabel.setText("LOADED");

        getContentPane().add(mainWindow);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
        setVisible(true);
        
        final CardLayout selectionLayout = (CardLayout)ParameterSelectionPanel_.getLayout();
        
        pilotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                //ParameterSelectionPanel_.SetCard(0);
                selectionLayout.first(ParameterSelectionPanel_);
            }
        });
        
        gliderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                //selectionLayout.show(ParameterSelectionPanel_, "Glider");
                //ParameterSelectionPanel_.SetCard(1);
                selectionLayout.first(ParameterSelectionPanel_);
                selectionLayout.next(ParameterSelectionPanel_);
            }
        });
        
        airfieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                //ParameterSelectionPanel_.SetCard(2);
                selectionLayout.first(ParameterSelectionPanel_);
                selectionLayout.next(ParameterSelectionPanel_);
                selectionLayout.next(ParameterSelectionPanel_);
            }
        });
    }

    private JPanel makePanel(JPanel innerPanel, int tab) {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout(1, 1));
        if(tab == 1) p.add(leftSidePanelScenario, BorderLayout.LINE_START);
        else p.add(leftSidePanelDashboard, BorderLayout.LINE_START);
        p.add(innerPanel, BorderLayout.CENTER);
        return p;
    }

    private void setUpMenus() {
        final JMenu fileMenu = new JMenu("File");
        final JMenu editMenu = new JMenu("Edit");
        //final JMenu profileMenu = new JMenu(currentProfile); //this should change to show current login

        //String[] profiles = {"JTROXEL", "AJACUZZI", "DBENNETT"};
        /*for (final String profile : profiles) {
        	JMenuItem profileItem = new JMenuItem(profile);
        	profileItem.addActionListener(new ActionListener() {
            	@Override
            	public void actionPerformed(ActionEvent event) {
            		currentProfile = profile;
            		profileMenu.setText(currentProfile);
            	}
        	});
			profileMenu.add(profileItem);
        }*/
        

        JMenuItem setupDBItem = new JMenuItem("Setup Database");
        setupDBItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            }
        });
		fileMenu.add(setupDBItem);

        JMenuItem exportDBItem = new JMenuItem("Export From Database");
        exportDBItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            }
        });
		fileMenu.add(exportDBItem);

		JMenuItem editDBItem = new JMenuItem("Edit Database Entry");
        editDBItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            }
        });
		editMenu.add(editDBItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
		fileMenu.add(exitMenuItem);

        JMenuItem addNewEntryItem = new JMenuItem("Add Database Entry");
        addNewEntryItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	//PreWizard wiz = new PreWizard();
       			//wiz.setVisible(true);
            }
        });
		editMenu.add(addNewEntryItem);

		JMenuItem editScenarioItem = new JMenuItem("Edit Scenario");
        editScenarioItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	tabbedPane.setSelectedIndex(0);
            }
        });
		editMenu.add(editScenarioItem);

    	JMenuItem preferencesItem = new JMenuItem("Manage Profiles");
    	preferencesItem.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
                    ProfileManagementFrame = new ProfileManagementFrame();
                    ProfileManagementFrame.setVisible(true);
        	}
    	});
		editMenu.add(preferencesItem);

        topMenu.add(fileMenu);
        topMenu.add(editMenu);
        //topMenu.add(profileMenu);
    }

    public static void run() {
        /*javax.swing.SwingUtilities.invokeLater(new Runnable() {
        	@Override
            public void run() {
            	MainWindow wt = new MainWindow();
            }
        });*/
    }
    
    /*public static void main(String[] args) {
       javax.swing.SwingUtilities.invokeLater(new Runnable() {
        	@Override
            public void run() {
        		MainWindow wt = new MainWindow();
            }
        });
    }*/
}
