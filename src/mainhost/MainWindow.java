package mainhost;

import Configuration.ProfileManagementFrame;
import Configuration.DatabaseExportFrame;
import ParameterSelection.ParameterSelectionPanel;
import DashboardInterface.FlightDashboard;
import DataObjects.CurrentDataObjectSet;
import DatabaseUtilities.DatabaseImporter;
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
import ParameterSelection.DEBUGWinchEditPanel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;

public class MainWindow extends JFrame {
    private String version = "2.0.1";
    private JMenuBar topMenu;
    private JPanel mainWindow;
    private String currentProfile;
    private JPanel leftSidePanelScenario;
    private JPanel leftSidePanelDashboard;
    private JPanel leftSidePanelWinch;
    private JLabel statusLabel;
    private JPanel rightSidePanel;
    private JPanel lowerLeftSidePanelScenario;    
    private JPanel lowerLeftSidePanelDashboard;
    private JPanel lowerLeftSidePanelWinch;
    private JPanel upperLeftSidePanelScenario;    
    private JPanel upperLeftSidePanelDashboard;
    private JPanel upperLeftSidePanelWinch;
    private JTabbedPane tabbedPane;
    private ParameterSelectionPanel ParameterSelectionPanel_;
    private ProfileManagementFrame ProfileManagementFrame;
    private FlightDashboard FlightDashboard_;
    private DatabaseExportFrame DatabaseExportFrame;
    private EnvironmentalWindow EnvironmentalWindow_;
    private CurrentScenario CurrentScenario_;
    private CurrentDataObjectSet currentData;
    private CardLayout selectionLayout;

    public MainWindow() {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        topMenu = new JMenuBar();
        mainWindow = new JPanel(new BorderLayout());
        leftSidePanelScenario = new JPanel();
        leftSidePanelDashboard = new JPanel();
        leftSidePanelWinch = new JPanel();
        //rightSidePanel = new JPanel();
        statusLabel = new JLabel();
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        currentProfile = "NO PROFILE";
        ParameterSelectionPanel_ = new ParameterSelectionPanel();
        FlightDashboard_ = new FlightDashboard();
        EnvironmentalWindow_ = new EnvironmentalWindow();
        rightSidePanel = EnvironmentalWindow_;
        selectionLayout = (CardLayout)ParameterSelectionPanel_.getLayout();
        upperLeftSidePanelScenario = new CurrentScenario(selectionLayout, ParameterSelectionPanel_);
        upperLeftSidePanelDashboard = new CurrentScenario(selectionLayout, ParameterSelectionPanel_);
        upperLeftSidePanelWinch = new CurrentScenario(selectionLayout, ParameterSelectionPanel_);
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
        leftSidePanelWinch.setPreferredSize(new Dimension(200, 600));
        leftSidePanelScenario.setBorder(BorderFactory.createLineBorder(Color.black));
        leftSidePanelDashboard.setBorder(BorderFactory.createLineBorder(Color.black));
        leftSidePanelWinch.setBorder(BorderFactory.createLineBorder(Color.black));
        leftSidePanelScenario.setBackground(Color.WHITE);
        leftSidePanelDashboard.setBackground(Color.WHITE);
        leftSidePanelWinch.setBackground(Color.WHITE);

        rightSidePanel.setPreferredSize(new Dimension(200, 600));
        rightSidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        rightSidePanel.setBackground(Color.WHITE);
        
        //TODO (jtroxel) move all side panels into their respective panels, since they are tied to them
        // RSP can stay with main window IF static.
        lowerLeftSidePanelScenario = new JPanel();
        lowerLeftSidePanelScenario.setPreferredSize(new Dimension(200,WIDTH));
        lowerLeftSidePanelScenario.setBackground(Color.WHITE);
        leftSidePanelScenario.add(upperLeftSidePanelScenario);
        leftSidePanelScenario.add(lowerLeftSidePanelScenario);
        
        lowerLeftSidePanelDashboard = new JPanel();
        lowerLeftSidePanelDashboard.setPreferredSize(new Dimension(200,WIDTH));
        lowerLeftSidePanelDashboard.setBackground(Color.WHITE);
        leftSidePanelDashboard.add(upperLeftSidePanelDashboard);
        leftSidePanelDashboard.add(lowerLeftSidePanelDashboard);
        
        lowerLeftSidePanelWinch = new JPanel();
        lowerLeftSidePanelWinch.setPreferredSize(new Dimension(200,WIDTH));
        lowerLeftSidePanelWinch.setBackground(Color.WHITE);
        leftSidePanelWinch.add(upperLeftSidePanelWinch);
        leftSidePanelWinch.add(lowerLeftSidePanelWinch);
                
        
        //upperLeftSidePanelDashboard.add(new JLabel("REPLAY LIST HERE"));
        //lowerLeftSidePanelDashboard.add(new JLabel("Current Scenario"));
        
        tabbedPane.setPreferredSize(new Dimension(800, 620));
        tabbedPane.addTab("Edit Scenario", makePanel(ParameterSelectionPanel_, 1));
        tabbedPane.addTab("Flight Dashboard", makePanel(FlightDashboard_, 2));
        tabbedPane.addTab("Edit Winch", makePanel(new DEBUGWinchEditPanel(), 3));
        mainWindow.add(tabbedPane, BorderLayout.CENTER);

        mainWindow.add(rightSidePanel, BorderLayout.LINE_END);

        mainWindow.add(statusLabel, BorderLayout.PAGE_END);
        statusLabel.setText("LOADED");

        getContentPane().add(mainWindow);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
        setVisible(true);       
    }

    private JPanel makePanel(JPanel innerPanel, int tab) {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout(1, 1));
        if(tab==1) p.add(leftSidePanelScenario, BorderLayout.LINE_START);
        else if (tab==2) p.add(leftSidePanelDashboard, BorderLayout.LINE_START);
        else p.add(leftSidePanelWinch, BorderLayout.LINE_START);
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
        
        JMenuItem importDBItem = new JMenuItem("Import From Database");
        importDBItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    DatabaseImporter.importDatabase("hi");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
	fileMenu.add(importDBItem);
        

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
