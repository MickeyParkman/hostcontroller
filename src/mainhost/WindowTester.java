package mainhost;

import javax.swing.*;     
import java.awt.Dimension;   
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class WindowTester extends JFrame {

	private JMenuBar topMenu;

	public WindowTester() {
		createAndShowGUI();
	}

    private void createAndShowGUI() {
    	setTitle("HOST CONTROLLER MAIN VIEW ALPHA");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        topMenu = new JMenuBar();

        setUpMenus();
        setJMenuBar(topMenu);
        
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
        setVisible(true);
    }

    private void setUpMenus() {
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu profileMenu = new JMenu("JTROXEL"); //this should change to show current login

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
