package mainhost;

import Configuration.ProfileManagementFrame;
import Configuration.DatabaseExportFrame;
import ParameterSelection.ParameterSelectionPanel;
import DashboardInterface.FlightDashboard;
import DataObjects.CurrentDataObjectSet;
import javax.swing.*;
import java.awt.Dimension;   
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import DatabaseUtilities.DatabaseInitialization;
import ParameterSelection.CurrentScenario;
import ParameterSelection.EnvironmentalWindow;
import ParameterSelection.WinchEditPanel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindow extends JFrame {
    private String version = "2.0.1";
    private JMenuBar topMenu;
    private JPanel mainWindow;
    private String currentProfile;
    private JPanel leftSidePanelScenario;
    private JPanel leftSidePanelDashboard;
    private JLabel statusLabel;
    private JPanel rightSidePanel;
    private JPanel upperLeftSidePanelScenario;
    private JPanel lowerLeftSidePanelScenario;    
    private JPanel upperLeftSidePanelDashboard;
    private JPanel lowerLeftSidePanelDashboard;
    private JTabbedPane tabbedPane;
    private ParameterSelectionPanel ParameterSelectionPanel_;
    private ProfileManagementFrame ProfileManagementFrame;
    private FlightDashboard FlightDashboard_;
    private DatabaseExportFrame DatabaseExportFrame;
    private EnvironmentalWindow EnvironmentalWindow_;
    private CurrentScenario CurrentScenario_;
    private CurrentDataObjectSet currentData;

    public MainWindow() {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        topMenu = new JMenuBar();
        mainWindow = new JPanel(new BorderLayout());
        leftSidePanelScenario = new JPanel();
        leftSidePanelDashboard = new JPanel();
        //rightSidePanel = new JPanel();
        statusLabel = new JLabel();
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        currentProfile = "NO PROFILE";
        ParameterSelectionPanel_ = new ParameterSelectionPanel();
        FlightDashboard_ = new FlightDashboard();
        EnvironmentalWindow_ = new EnvironmentalWindow();
        rightSidePanel = EnvironmentalWindow_;
        //CurrentScenario_ = new CurrentScenario();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        //setupMainWindow();
        //setepMenu();
        //setupLeftSideBar()
        //setupTabbedPane();
        //setupRightSideBar();
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
        JButton drumButton = new JButton();
        drumButton.setText("Select Drum");
        drumButton.setPreferredSize(new Dimension(180,20));
        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setPreferredSize(new Dimension(180,20));
        JButton submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setPreferredSize(new Dimension(180,20));
        
        rightSidePanel.setPreferredSize(new Dimension(200, 600));
        rightSidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        //TODO (jtroxel) move all side panels into their respective panels, since they are tied to them
        // RSP can stay with main window IF static.
        upperLeftSidePanelScenario = new JPanel();
        upperLeftSidePanelScenario.setPreferredSize(new Dimension(200,200));
        upperLeftSidePanelScenario.setBorder(BorderFactory.createLineBorder(Color.black));
        lowerLeftSidePanelScenario = new CurrentScenario();
        lowerLeftSidePanelScenario.setPreferredSize(new Dimension(200,300));
        lowerLeftSidePanelScenario.setBorder(BorderFactory.createLineBorder(Color.black));
        leftSidePanelScenario.add(upperLeftSidePanelScenario);
        leftSidePanelScenario.add(lowerLeftSidePanelScenario);
        
        //lowerLeftSidePanelScenario.add(new JLabel("Current Scenario"));
        
        upperLeftSidePanelDashboard = new CurrentScenario();
        upperLeftSidePanelDashboard.setPreferredSize(new Dimension(200,300));
        upperLeftSidePanelDashboard.setBorder(BorderFactory.createLineBorder(Color.black));
        lowerLeftSidePanelDashboard = new JPanel();
        lowerLeftSidePanelDashboard.setPreferredSize(new Dimension(200,300));
        lowerLeftSidePanelDashboard.setBorder(BorderFactory.createLineBorder(Color.black));
        leftSidePanelDashboard.add(upperLeftSidePanelDashboard);
        leftSidePanelDashboard.add(lowerLeftSidePanelDashboard);

        //upperLeftSidePanelDashboard.add(new JLabel("REPLAY LIST HERE"));
        //lowerLeftSidePanelDashboard.add(new JLabel("Current Scenario"));
        
        upperLeftSidePanelScenario.add(pilotButton);        
        upperLeftSidePanelScenario.add(gliderButton);   
        upperLeftSidePanelScenario.add(airfieldButton);
        upperLeftSidePanelScenario.add(drumButton);        
        upperLeftSidePanelScenario.add(clearButton);   
        upperLeftSidePanelScenario.add(submitButton);
        
        tabbedPane.setPreferredSize(new Dimension(800, 620));
        tabbedPane.addTab("Edit Scenario", makePanel(ParameterSelectionPanel_, 1));
        tabbedPane.addTab("Flight Dashboard", makePanel(FlightDashboard_, 2));
        tabbedPane.addTab("Edit Winch", makePanel(new WinchEditPanel(), 3));
        mainWindow.add(tabbedPane, BorderLayout.CENTER);

        mainWindow.add(rightSidePanel, BorderLayout.LINE_END);

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
                selectionLayout.first(ParameterSelectionPanel_);
            }
        });
        
        gliderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                selectionLayout.first(ParameterSelectionPanel_);
                selectionLayout.next(ParameterSelectionPanel_);
            }
        });
        
        airfieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                selectionLayout.first(ParameterSelectionPanel_);
                selectionLayout.next(ParameterSelectionPanel_);
                selectionLayout.next(ParameterSelectionPanel_);
            }
        });
        
        drumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            }
        });
        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                currentData.cleafGliderPosition();
                currentData.clearAirfield();
                currentData.clearGlider();
                currentData.clearPilot();
                currentData.clearRunway();
                currentData.clearWinchPosition();
                ParameterSelectionPanel_.clear();
            }
        });
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            }
        });
    }

    private JPanel makePanel(JPanel innerPanel, int tab) {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout(1, 1));
        if(tab==1) p.add(leftSidePanelScenario, BorderLayout.LINE_START);
        else if (tab==2) p.add(leftSidePanelDashboard, BorderLayout.LINE_START);
        p.add(innerPanel, BorderLayout.CENTER);
        return p;
    }

    private void setUpMenus() {
        final JMenu fileMenu = new JMenu("File");
        final JMenu editMenu = new JMenu("Edit");
        final JMenu editAddMenu = new JMenu("Add New...");
//FILE MENU
        JMenuItem setupDBItem = new JMenuItem("Setup Database");
        setupDBItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try 
                {
                    //DatabaseUtilities.DatabaseInitialization.deleteDB();
                    DatabaseUtilities.DatabaseInitialization.initDatabase();
                }
                catch(ClassNotFoundException e1) 
                {
                    JOptionPane.showMessageDialog(null, "ClassNotFoundException" + e1.getMessage());
                }
                catch(SQLException e2) 
                {
                    if(e2.getErrorCode() == 30000) 
                    {
                        JOptionPane.showMessageDialog(null, "Database Already Exists");
                    }
                    else 
                    { 
                        JOptionPane.showMessageDialog(null, "SQLException: " + e2.getErrorCode());
                    }
                }
            }
        });
	fileMenu.add(setupDBItem);

        JMenuItem exportDBItem = new JMenuItem("Export From Database");
        exportDBItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                DatabaseExportFrame = new DatabaseExportFrame();
                DatabaseExportFrame.setVisible(true);
            }
        });
	fileMenu.add(exportDBItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
	fileMenu.add(exitMenuItem);
//EDIT MENU
        //editMenu.add(editAddMenu);
        
        JMenuItem addNewEntryItem = new JMenuItem("Add Database Entry");
        addNewEntryItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            }
        });        
	editMenu.add(addNewEntryItem);
        
        JMenuItem editDBItem = new JMenuItem("Edit Database Entry");
        editDBItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            }
        });
	editMenu.add(editDBItem);

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
    }

    //TODO (jtroxel): remove this guy...necessary?
    public static void run() {

    }
}
