/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParameterSelection;

import Communications.Observer;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Drum;
import DataObjects.Winch;
import java.util.List;

/**
 *
 * @author jtroxel
 */
public class DrumPanel extends JPanel implements Observer {
    
    private JList drumList;
    private DefaultListModel drumModel;
    private CurrentDataObjectSet data;
    private List<Drum> currentDrums;


    public DrumPanel() {
        data = CurrentDataObjectSet.getCurrentDataObjectSet();
        data.attach(this);
        initComponents();
    }
    
    private void updateDrumList() {
        Winch curWinch = data.getCurrentWinch();
        drumModel.clear();
        if(curWinch != null) {
            currentDrums = curWinch.getDrumsForDrive("Drive #1");
            for(Drum drum : currentDrums) {
                drumModel.addElement(drum);
            }   
        }
    }
    
    private void initComponents() {
        JPanel drumPanel = new JPanel();
        drumModel = new DefaultListModel();
        drumList = new javax.swing.JList();
        JScrollPane drumScroller = new JScrollPane();
        drumPanel.add(drumScroller);
        JPanel drumInfoPanel = new JPanel();
        drumInfoPanel.setLayout(new BoxLayout(drumInfoPanel, BoxLayout.PAGE_AXIS));
        drumList.setModel(drumModel);
        drumList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(drumList.getSelectedIndex() >= 0){
                    Drum curDrum = (Drum)drumList.getSelectedValue();
                    data.setCurrentDrum(curDrum);
                }
            }
        });
        drumScroller.setViewportView(drumList);
        updateDrumList();
        add(drumPanel);

    }

    @Override
    public void update() {
        updateDrumList();
    }

    @Override
    public void update(String msg) {
    }
}
