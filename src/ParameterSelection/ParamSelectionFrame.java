/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ParameterSelection;

import Communications.MessagePipeline;
import Communications.MessagePipelineException;
import DashboardInterface.DashboardInterface;
import DataObjects.Pilot;
import DataObjects.Sailplane;
import DataObjects.Airfield;
import DataObjects.GliderPosition;
import DataObjects.Runway;
import Wizards.PreWizard;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * This UI class allow the user to select a Pilot, Sailplane and Airfield 
 * with which to parameterize a launch
 * 
 * @author awilliams5
 */
public class ParamSelectionFrame extends javax.swing.JFrame {
    
    /*
    
    MessagePipeline pipeline;
    
    /**
     * Creates new form ParamSelectionFrame
     *
    public ParamSelectionFrame(MessagePipeline pipeline) {
        this.pipeline = pipeline;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        oneTimeSailplanePanel1 = new ParameterSelection.OneTimeSailplanePanel();
        HeaderPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        previousLaunchesPanel = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        environmentalVariablePanel = new javax.swing.JPanel();
        environmentalVariablesTitle = new javax.swing.JLabel();
        selectAirfieldPanel = new javax.swing.JPanel();
        airfieldSelectTitle = new javax.swing.JLabel();
        airfieldTabbedPane = new javax.swing.JTabbedPane();
        airfieldSelectionPanel = new ParameterSelection.AirfieldSelection();
        airfieldFromLabel = new javax.swing.JLabel();
        selectSailplanePanel = new javax.swing.JPanel();
        selectSailplaneTitle = new javax.swing.JLabel();
        sailplaneTabbedPane = new javax.swing.JTabbedPane();
        sailplaneSelectionPanel = new ParameterSelection.SailplaneSelection();
        sailplaneFromLabel = new javax.swing.JLabel();
        selectPilotPanel = new javax.swing.JPanel();
        selectPilotTitle = new javax.swing.JLabel();
        pilotFromLabel = new javax.swing.JLabel();
        pilotTabbedPane = new javax.swing.JTabbedPane();
        pilotScrollPane = new javax.swing.JScrollPane();
        pilotSelectionPanel = new ParameterSelection.PilotSelectionPanel();
        oneTimePilotPanel = new ParameterSelection.OneTimePilotPanel();
        appMenu1 = new ParameterSelection.AppMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleLabel.setText("Launch Selection");

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGap(431, 431, 431)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(37, 37, 37))
        );

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout previousLaunchesPanelLayout = new javax.swing.GroupLayout(previousLaunchesPanel);
        previousLaunchesPanel.setLayout(previousLaunchesPanelLayout);
        previousLaunchesPanelLayout.setHorizontalGroup(
            previousLaunchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(previousLaunchesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        previousLaunchesPanelLayout.setVerticalGroup(
            previousLaunchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(previousLaunchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        environmentalVariablePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        environmentalVariablesTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        environmentalVariablesTitle.setText("<html>Environmental <br/> Conditions</html>");

        javax.swing.GroupLayout environmentalVariablePanelLayout = new javax.swing.GroupLayout(environmentalVariablePanel);
        environmentalVariablePanel.setLayout(environmentalVariablePanelLayout);
        environmentalVariablePanelLayout.setHorizontalGroup(
            environmentalVariablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(environmentalVariablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(environmentalVariablesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(618, Short.MAX_VALUE))
        );
        environmentalVariablePanelLayout.setVerticalGroup(
            environmentalVariablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(environmentalVariablePanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(environmentalVariablesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        selectAirfieldPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        airfieldSelectTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        airfieldSelectTitle.setText("Select an Airfield");

        airfieldTabbedPane.addTab("Database", airfieldSelectionPanel);

        airfieldFromLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        airfieldFromLabel.setText("From:");

        javax.swing.GroupLayout selectAirfieldPanelLayout = new javax.swing.GroupLayout(selectAirfieldPanel);
        selectAirfieldPanel.setLayout(selectAirfieldPanelLayout);
        selectAirfieldPanelLayout.setHorizontalGroup(
            selectAirfieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(airfieldTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(selectAirfieldPanelLayout.createSequentialGroup()
                .addGroup(selectAirfieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(selectAirfieldPanelLayout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(airfieldSelectTitle))
                    .addGroup(selectAirfieldPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(airfieldFromLabel)))
                .addGap(128, 128, 128))
        );
        selectAirfieldPanelLayout.setVerticalGroup(
            selectAirfieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectAirfieldPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(airfieldSelectTitle)
                .addGap(1, 1, 1)
                .addComponent(airfieldFromLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(airfieldTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        selectSailplanePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        selectSailplaneTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selectSailplaneTitle.setText("Select a Sailplane");

        sailplaneTabbedPane.addTab("Database", sailplaneSelectionPanel);
        sailplaneTabbedPane.addTab("One Time Entry", oneTimeSailplanePanel1);

        sailplaneFromLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sailplaneFromLabel.setText("From:");

        javax.swing.GroupLayout selectSailplanePanelLayout = new javax.swing.GroupLayout(selectSailplanePanel);
        selectSailplanePanel.setLayout(selectSailplanePanelLayout);
        selectSailplanePanelLayout.setHorizontalGroup(
            selectSailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSailplanePanelLayout.createSequentialGroup()
                .addGroup(selectSailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(selectSailplanePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sailplaneFromLabel))
                    .addGroup(selectSailplanePanelLayout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(selectSailplaneTitle)))
                .addContainerGap(220, Short.MAX_VALUE))
            .addComponent(sailplaneTabbedPane)
        );
        selectSailplanePanelLayout.setVerticalGroup(
            selectSailplanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSailplanePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectSailplaneTitle)
                .addGap(5, 5, 5)
                .addComponent(sailplaneFromLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sailplaneTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        selectPilotPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        selectPilotTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selectPilotTitle.setText("Select a Pilot");

        pilotFromLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pilotFromLabel.setText("From:");

        pilotTabbedPane.setFocusCycleRoot(true);

        pilotScrollPane.setViewportView(pilotSelectionPanel);

        pilotTabbedPane.addTab("Database", pilotScrollPane);
        pilotTabbedPane.addTab("One Time Entry", oneTimePilotPanel);

        javax.swing.GroupLayout selectPilotPanelLayout = new javax.swing.GroupLayout(selectPilotPanel);
        selectPilotPanel.setLayout(selectPilotPanelLayout);
        selectPilotPanelLayout.setHorizontalGroup(
            selectPilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pilotTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(selectPilotPanelLayout.createSequentialGroup()
                .addGroup(selectPilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(selectPilotPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pilotFromLabel))
                    .addGroup(selectPilotPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(selectPilotTitle)))
                .addGap(61, 61, 61))
        );
        selectPilotPanelLayout.setVerticalGroup(
            selectPilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectPilotPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectPilotTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pilotFromLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pilotTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pilotTabbedPane.getAccessibleContext().setAccessibleName("From Database");

        jMenu1.setText("File");
        appMenu1.add(jMenu1);

        jMenu2.setText("Edit");
        appMenu1.add(jMenu2);

        setJMenuBar(appMenu1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(previousLaunchesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(selectPilotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(selectSailplanePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(environmentalVariablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectAirfieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectAirfieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectPilotPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectSailplanePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(environmentalVariablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(previousLaunchesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        boolean allValidEntries = true;

        // Get the selected/provided pilot
        if(pilotTabbedPane.getSelectedIndex() == 0) {
            Pilot name = pilotSelectionPanel.getSelectedPilot();
            if(name == null) {
                JOptionPane.showMessageDialog(rootPane, "You have not selected a pilot");
                allValidEntries = false;
            }
            else
                JOptionPane.showMessageDialog(rootPane, "PILOT:" + '\n' + name.getFirstName() + " " + name.getLastName() + '\n' + 
                        name.getWeight() + '\n' + name.getCapability() + '\n' + name.getPreference() + '\n' + 
                        name.getEmergencyContact() + '\n' + name.getMedInfo());
        }
        else {
            Pilot name = oneTimePilotPanel.getOneTimePilot();
            if(name == null) {
                JOptionPane.showMessageDialog(rootPane, "You have not entered a valid pilot");
                allValidEntries = false;
            }
            else
                JOptionPane.showMessageDialog(rootPane, "PILOT:" + '\n' + name.getFirstName() + " " + name.getLastName() + '\n' + 
                        name.getWeight() + '\n' + name.getCapability() + '\n' + name.getPreference() + '\n' + 
                        name.getEmergencyContact() + '\n' + name.getMedInfo());
        }
        
        //Get the selected/provided sailplane
        Sailplane plane;
        if(sailplaneTabbedPane.getSelectedIndex() == 0) {
            plane = sailplaneSelectionPanel.getSelectedPlane();
            if(plane == null){
                JOptionPane.showMessageDialog(rootPane, "You have not selected a sailplane");
                allValidEntries = false;
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "PLANE:" + '\n' + plane.getNumber() + '\n' + 
                        plane.getType()+ '\n'  + "...");
            }
        }
        else {
            plane = oneTimeSailplanePanel1.getOneTimeSailplnae();
            if(plane == null){
                JOptionPane.showMessageDialog(rootPane, "You have not entered a valid sailplane");
                allValidEntries = false;
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "PLANE:" + '\n' + plane.getNumber() + '\n' + 
                        plane.getType()+ '\n' + "...");
            }
        }
        
        
        //get the selected Airfield/Runway/Position
        if(airfieldTabbedPane.getSelectedIndex() == 0) {
            Airfield airfield = airfieldSelectionPanel.getSeleAirfiield();
            if(airfield == null){
                JOptionPane.showMessageDialog(rootPane, "You have not selected an airfield");
                allValidEntries = false;
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "AIRFIELD:" + '\n' + airfield.getName() + '\n' + 
                        airfield.getDesignator() + '\n' + "...");
            }
        }
        
        if (allValidEntries) {
            try {
                pipeline.startDashboard();
            } catch (MessagePipelineException ex) {
                Logger.getLogger(ParamSelectionFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        }
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    
    public void getSelectedLaunchElements(Pilot pilot, Sailplane sailplane, Airfield airfield, Runway runway, GliderPosition position) {
        pilot = pilotSelectionPanel.getSelectedPilot();
        sailplane = sailplaneSelectionPanel.getSelectedPlane();
        airfield = airfieldSelectionPanel.getSeleAirfiield();
        runway = airfieldSelectionPanel.getRunway();
        position = airfieldSelectionPanel.getPositions();
    }
    /**
     * @param args the command line arguments
     *
    public static void main(String args[]) {
        /* Set the Nimbus look and feel *
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         *
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ParamSelectionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParamSelectionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParamSelectionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParamSelectionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form *
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ParamSelectionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel airfieldFromLabel;
    private javax.swing.JLabel airfieldSelectTitle;
    private ParameterSelection.AirfieldSelection airfieldSelectionPanel;
    private javax.swing.JTabbedPane airfieldTabbedPane;
    private ParameterSelection.AppMenu appMenu1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel environmentalVariablePanel;
    private javax.swing.JLabel environmentalVariablesTitle;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private ParameterSelection.OneTimePilotPanel oneTimePilotPanel;
    private ParameterSelection.OneTimeSailplanePanel oneTimeSailplanePanel1;
    private javax.swing.JLabel pilotFromLabel;
    private javax.swing.JScrollPane pilotScrollPane;
    private ParameterSelection.PilotSelectionPanel pilotSelectionPanel;
    private javax.swing.JTabbedPane pilotTabbedPane;
    private javax.swing.JPanel previousLaunchesPanel;
    private javax.swing.JLabel sailplaneFromLabel;
    private ParameterSelection.SailplaneSelection sailplaneSelectionPanel;
    private javax.swing.JTabbedPane sailplaneTabbedPane;
    private javax.swing.JPanel selectAirfieldPanel;
    private javax.swing.JPanel selectPilotPanel;
    private javax.swing.JLabel selectPilotTitle;
    private javax.swing.JPanel selectSailplanePanel;
    private javax.swing.JLabel selectSailplaneTitle;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables


    */
}
