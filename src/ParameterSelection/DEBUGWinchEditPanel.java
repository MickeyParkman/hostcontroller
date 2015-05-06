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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ParameterSelectionPanel paramPanel;
    private CurrentDataObjectSet data;
    
    public DEBUGWinchEditPanel(ParameterSelectionPanel p) {
        paramPanel = p;
        selected = 0;
        initDEBUGWinch();
        initComponents();
        JScrollPane scrollPane = new JScrollPane(DEBUGMainPanel);
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
                
        data = CurrentDataObjectSet.getCurrentDataObjectSet();
        data.setCurrentWinch(DEBUGWinch);
    }
    
    public void setParamPanel(ParameterSelectionPanel p)
    {
        paramPanel = p;   
    }
    
    private void buildWinchPanel(Winch winch, boolean isSelected) {
        DEBUGWinchPanel = new JPanel();

        JPanel WinchPanel = new JPanel();
        WinchPanel.setLayout(new BoxLayout(WinchPanel, BoxLayout.Y_AXIS));
        JLabel winchName = new JLabel("WINCH: " + winch.getName());
        winchName.setAlignmentX(Component.CENTER_ALIGNMENT);
        WinchPanel.add(winchName);
        for(Drum d : winch.getDrumsForDrive("Drive 1")) {
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
        buildWinchPanel(DEBUGWinch, true);
        /*for(int i = 0; i < 7; ++i) {
            if(i == selected) buildWinchPanel(DEBUGWinch, true);
            else buildWinchPanel(DEBUGWinch, false);
        }*/
    }
    
    private void initDEBUGWinch() {
        /*DEBUGWinch = new Winch("Winch #1", "Primary Winch for Spokane Gliding Team", (float)2.0);
        Drive drive = new Drive("Drive #1", (float)1.0);
        Drum drum1 = new Drum("Drum #1", (float)1.0, (float)1.0, (float)1000.0);
        Parachute p1 = new Parachute("Green Parachute", 0, (float)0.5, (float)0.5, (float)25);
        drum1.setParachute(p1);
        drive.addDrum(drum1);
        drive.addDrum(new Drum("Drum #2", (float)2.0, (float)2.0, (float)2000.0));
        DEBUGWinch.addDrive(drive);
        
        DEBUGWinch.addParachute(p1);
        DEBUGWinch.addParachute(new Parachute("Red Parachute", 1, (float)0.77, (float)0.67, (float)55));
        DEBUGWinch.addParachute(new Parachute("Blue Parachute", 2, (float)0.23, (float)0.34, (float)35));*/
        DEBUGWinch = loadWinchFile("D:\\Users\\Jacob\\Documents\\example_winch.txt");
        //paramPanel.update();
    }
    
    private Winch loadWinchFile(String file)
    {
        ArrayList<String> lines = new ArrayList<>();

        Winch loadedWinch = new Winch();
        Drive curDrive = new Drive();
        Drum curDrum = new Drum();
        Parachute curPara = new Parachute();
        
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            try {
                while ((line = br.readLine()) != null)
                {
                    lines.add(line);
                }
            } catch (IOException ex) {
            }
        } catch (FileNotFoundException ex) {
        }
        
        for(String str : lines)
        {
            String parts[] = str.split(":");
            String name = parts[0].trim();
            
            switch(name)
            {
                case "winch-name":
                    loadedWinch.setName(parts[1]);
                    break;
                case "winch-id":
                    loadedWinch.setId(parts[1]);
                    break;
                case "winch-optional-data":
                    loadedWinch.setOptionalData(parts[1]);
                    break;
                case "winch-brake-pressure":
                    loadedWinch.setBrakePressure(Float.parseFloat(parts[1]));
                    break;
                case "drive":
                    curDrive = new Drive();
                    break;
                case "drive-name":
                    curDrive.setName(parts[1]);
                    break;
                case "drive-reduction-ratio":
                    curDrive.setReductionRatio(Float.parseFloat(parts[1]));
                    break;
                case "end-drive":
                    loadedWinch.addDrive(curDrive);
                    break;
                case "drum":
                    curDrum = new Drum();
                    curDrum.setDrive(curDrive);
                    break;
                case "drum-name":
                    curDrum.setName(parts[1]);
                    break;
                case "drum-core-diameter":
                    curDrum.setCoreDiameter(Float.parseFloat(parts[1]));
                    break;
                case "drum-k-factor":
                    curDrum.setKFactor(Float.parseFloat(parts[1]));
                    break;
                case "drum-cable-length":
                    curDrum.setCableLength(Float.parseFloat(parts[1]));
                    break;
                case "end-drum":
                    curDrive.addDrum(curDrum);
                    break;
                case "parachute":
                    curPara = new Parachute();
                    break;
                case "parachute-name":
                    curPara.setName(parts[1]);
                    break;
                case "parachute-number":
                    curPara.setParachuteNumber(Integer.parseInt(parts[1]));
                    break;
                case "parachute-lift":
                    curPara.setLift(Float.parseFloat(parts[1]));
                    break;
                case "parachute-drag":
                    curPara.setDrag(Float.parseFloat(parts[1]));
                    break;
                case "parachute-weight":
                    curPara.setWeight(Float.parseFloat(parts[1]));
                    break;
                case "end-parachute":
                    loadedWinch.addParachute(curPara);
                    break;
            }
        }
        
        return loadedWinch;
    }
}
