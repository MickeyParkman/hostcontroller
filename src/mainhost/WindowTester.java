package mainhost;

import javax.swing.*;     
import java.awt.Dimension;   
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;


public class WindowTester extends JFrame {

	private JMenuBar topMenu;
	private JPanel mainWindow;
	private String currentProfile;
	private JPanel sidePanel;
	private JLabel statusLabel;

	public WindowTester() {
		topMenu = new JMenuBar();
		mainWindow = new JPanel(new BorderLayout());
		sidePanel = new JPanel();
		statusLabel = new JLabel();
		currentProfile = "NO PROFILE";
		createAndShowGUI();
	}

    private void createAndShowGUI() {
    	setTitle("HOST CONTROLLER MAIN VIEW ALPHA");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setUpMenus();
        setJMenuBar(topMenu);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setPreferredSize(new Dimension(800, 600));
		tabbedPane.addTab("Scenario Selection", makePanel("1"));
		tabbedPane.addTab("Flight Dashboard", makePanel("3"));
		mainWindow.add(tabbedPane, BorderLayout.CENTER);



		sidePanel.setPreferredSize(new Dimension(200, 600));
		mainWindow.add(sidePanel, BorderLayout.LINE_START);
		mainWindow.add(statusLabel, BorderLayout.PAGE_END);
		statusLabel.setText("LOADED");

        add(mainWindow);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
        setVisible(true);
    }

    private static JPanel makePanel(String text) {
        JPanel p = new JPanel();
        p.add(new JLabel());
        p.setLayout(new GridLayout(1, 1));
        return p;
    }

    private void setUpMenus() {
        final JMenu fileMenu = new JMenu("File");
        final JMenu editMenu = new JMenu("Edit");
        final JMenu profileMenu = new JMenu(currentProfile); //this should change to show current login

    	JMenuItem newProfileItem = new JMenuItem("Add New...");
    	newProfileItem.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
        	}
    	});
		profileMenu.add(newProfileItem);

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
            }
        });
		editMenu.add(editScenarioItem);

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
