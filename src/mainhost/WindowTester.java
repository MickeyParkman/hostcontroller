package mainhost;

import javax.swing.*;     
import java.awt.Dimension;   
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.BoxLayout;


public class WindowTester extends JFrame {

	private String version = "2.0.1";
	private JMenuBar topMenu;
	private JPanel mainWindow;
	private String currentProfile;
	private JPanel leftSidePanel;
	private JLabel statusLabel;
	private JPanel rightSidePanel;
	private JPanel upperLeftSidePanel;
	private JPanel lowerLeftSidePanel;
	private JTabbedPane tabbedPane;

	public WindowTester() {
		topMenu = new JMenuBar();
		mainWindow = new JPanel(new BorderLayout());
		leftSidePanel = new JPanel();
		rightSidePanel = new JPanel();
		statusLabel = new JLabel();
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		currentProfile = "NO PROFILE";
		createAndShowGUI();
	}

    private void createAndShowGUI() {
    	setTitle("Winch Host Manager v" + version);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setUpMenus();
        setJMenuBar(topMenu);

        tabbedPane.setPreferredSize(new Dimension(800, 600));
		tabbedPane.addTab("Edit Scenario", makePanel("1"));
		tabbedPane.addTab("Flight Dashboard", makePanel("3"));
		mainWindow.add(tabbedPane, BorderLayout.CENTER);

		rightSidePanel.setPreferredSize(new Dimension(200, 600));
		mainWindow.add(rightSidePanel, BorderLayout.LINE_END);

		leftSidePanel.setPreferredSize(new Dimension(200, 600));
		mainWindow.add(leftSidePanel, BorderLayout.LINE_START);
		/*upperLeftSidePanel = new JPanel();
		upperLeftSidePanel.setPreferredSize(new Dimension(200,300));
		lowerLeftSidePanel = new JPanel();
		lowerLeftSidePanel.setPreferredSize(new Dimension(200,300));
		leftSidePanel.add(upperLeftSidePanel);
		leftSidePanel.add(lowerLeftSidePanel);*/

		mainWindow.add(statusLabel, BorderLayout.PAGE_END);
		statusLabel.setText("LOADED");

        add(mainWindow);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
        setVisible(true);
    }

    private JPanel makePanel(String text) {
        JPanel p = new JPanel();
        p.add(new JLabel());
        p.setLayout(new GridLayout(1, 1));
        return p;
    }

    private void setUpMenus() {
        final JMenu fileMenu = new JMenu("File");
        final JMenu editMenu = new JMenu("Edit");
        final JMenu profileMenu = new JMenu(currentProfile); //this should change to show current login

        String[] profiles = {"JTROXEL", "AJACUZZI", "DBENNETT"};
        for (final String profile : profiles) {
        	JMenuItem profileItem = new JMenuItem(profile);
        	profileItem.addActionListener(new ActionListener() {
            	@Override
            	public void actionPerformed(ActionEvent event) {
            		currentProfile = profile;
            		profileMenu.setText(currentProfile);
            	}
        	});
			profileMenu.add(profileItem);
        }

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

    	JMenuItem preferencesItem = new JMenuItem("Edit Preferences");
    	preferencesItem.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
        	}
    	});
		editMenu.add(preferencesItem);

        topMenu.add(fileMenu);
        topMenu.add(editMenu);
        topMenu.add(profileMenu);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        	@Override
            public void run() {
            	WindowTester wt = new WindowTester();
            }
        });
    }
}
