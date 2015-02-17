package ParameterSelection;

import DataObjects.Drive;
import DataObjects.Drum;
import DataObjects.Parachute;
import DataObjects.Winch;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import DataObjects.CurrentDataObjectSet;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

/**
 *
 * @author jtroxel
 */
public class DEBUGWinchEditPanel extends JPanel {
    
    private Winch DEBUGWinch;
    private JPanel DEBUGWinchPanel;
    private JPanel DEBUGWinchPanel2;
    private JPanel DEBUGMainPanel;
    private int selected;
    private CurrentDataObjectSet data;
    
    public DEBUGWinchEditPanel() {
        selected = 0;
        initDEBUGWinch();
        initComponents();
        JScrollPane scrollPane = new JScrollPane(DEBUGMainPanel);
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        
        data = CurrentDataObjectSet.getCurrentDataObjectSet();
        data.setCurrentWinch(DEBUGWinch);
    }
    
    private void buildWinchPanel(Winch winch, boolean isSelected) {
        DEBUGWinchPanel = new JPanel();

        JPanel WinchPanel = new JPanel();
        WinchPanel.setLayout(new BoxLayout(WinchPanel, BoxLayout.Y_AXIS));
        JLabel winchName = new JLabel("WINCH: " + winch.getName());
        winchName.setAlignmentX(Component.CENTER_ALIGNMENT);
        WinchPanel.add(winchName);
        for(Drum d : winch.getDrumsForDrive("Drive #1")) {
            JPanel drum = new JPanel();
            JLabel drumName = new JLabel("DRUM: " + d.toString());
            drum.add(drumName);
            WinchPanel.add(drum);
        }
        
        for(Parachute p : winch.getParachuteList()) {
            JPanel para = new JPanel();
            JLabel paraName = new JLabel("PARACHUTE: " + p.getName());
            para.add(paraName);
            WinchPanel.add(para);
        }
        
        DEBUGWinchPanel.add(WinchPanel);
        if(isSelected) DEBUGWinchPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        else DEBUGWinchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        DEBUGMainPanel.add(DEBUGWinchPanel);
    }
    
    private void initComponents() {
        DEBUGMainPanel = new JPanel();
        DEBUGMainPanel.setLayout(new BoxLayout(DEBUGMainPanel, BoxLayout.Y_AXIS));
        for(int i = 0; i < 7; ++i) {
            if(i == selected) buildWinchPanel(DEBUGWinch, true);
            else buildWinchPanel(DEBUGWinch, false);
        }
    }
    
    private void initDEBUGWinch() {
        DEBUGWinch = new Winch("Winch #1", "Primary Winch for Spokane Gliding Team", (float)2.0);
        Drive drive = new Drive("Drive #1");
        Drum drum1 = new Drum("Drum #1", (float)1.0, (float)1.0, (float)1000.0);
        Parachute p1 = new Parachute("Green Parachute", 0, (float)0.5, (float)0.5, 25);
        drum1.setParachute(p1);
        drive.addDrum(drum1);
        drive.addDrum(new Drum("Drum #2", (float)2.0, (float)2.0, (float)2000.0));
        DEBUGWinch.addDrive(drive);
        
        DEBUGWinch.addParachute(p1);
        DEBUGWinch.addParachute(new Parachute("Red Parachute", 1, (float)0.77, (float)0.67, 55));
        DEBUGWinch.addParachute(new Parachute("Blue Parachute", 2, (float)0.23, (float)0.34, 35));
    }
}
