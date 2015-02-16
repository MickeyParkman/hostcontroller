/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParameterSelection;
import DataObjects.*;
/**
 *
 * @author Johnny White
 */
public class CurrentScenario extends javax.swing.JPanel {
    private CurrentDataObjectSet data;
    /**
     * Creates new form CurrentScenario
     */
    public CurrentScenario() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        data = CurrentDataObjectSet.getCurrentDataObjectSet();
        
        Pilot pilot = data.getCurrentPilot();
        Sailplane glider = data.getCurrentSailplane();
        Airfield airfield = data.getCurrentAirfield();
        GliderPosition position = data.getCurrentGliderPosition();
        Runway runway = data.getCurrentRunway();
        WinchPosition winch = data.getCurrentWinchPosition();
        
        FNLabel             = new javax.swing.JLabel();
        LNLabel             = new javax.swing.JLabel();
        MNLabel             = new javax.swing.JLabel();
        WGHTLabel           = new javax.swing.JLabel();
        PREFERLabel         = new javax.swing.JLabel();
        CAPLabel            = new javax.swing.JLabel();
        TitleLabel          = new javax.swing.JLabel();
        firstnameLabel      = new javax.swing.JLabel();
        lastnameLabel       = new javax.swing.JLabel();
        middlenameLabel     = new javax.swing.JLabel();
        weightLabel         = new javax.swing.JLabel();
        capabilityLabel     = new javax.swing.JLabel();
        prefLabel           = new javax.swing.JLabel();
        airfieldLabel       = new javax.swing.JLabel();
        AIRLabel            = new javax.swing.JLabel();
        GLDRLabel           = new javax.swing.JLabel();
        gliderLabel         = new javax.swing.JLabel();
        gliderweightLabel   = new javax.swing.JLabel();
        GLDRWGHTLabel       = new javax.swing.JLabel();
        runwayLabel         = new javax.swing.JLabel();
        positionLabel       = new javax.swing.JLabel();
        winchposLabel       = new javax.swing.JLabel();
        RUNLabel            = new javax.swing.JLabel();
        POSLabel            = new javax.swing.JLabel();
        WNCHLabel           = new javax.swing.JLabel();

        FNLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        FNLabel.setText("First Name");

        LNLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LNLabel.setText("Last Name");

        MNLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        MNLabel.setText("Middle Name");

        WGHTLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        WGHTLabel.setText("Weight");

        PREFERLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PREFERLabel.setText("Preference");

        CAPLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CAPLabel.setText("Capability");

        TitleLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TitleLabel.setText("Current Scenario");
        
        /*
        firstnameLabel.setText(pilot.getFirstName());

        lastnameLabel.setText(pilot.getLastName());

        middlenameLabel.setText(pilot.getMiddleName());
        //String weightStr = pilot.getWeight().toString();
        weightLabel.setText(Integer.toString(pilot.getWeight()));

        capabilityLabel.setText(pilot.getCapability());

        prefLabel.setText(pilot.getPreference());

        airfieldLabel.setText(airfield.getName());

        AIRLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AIRLabel.setText("Airfield");

        GLDRLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        GLDRLabel.setText("Glider");

        GLDRWGHTLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        GLDRWGHTLabel.setText("Glider Weight");

        gliderLabel.setText(glider.getType());

        gliderweightLabel.setText(Integer.toString(glider.getMaxGrossWeight()));

        RUNLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        RUNLabel.setText("Runway");

        POSLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        POSLabel.setText("Position");

        WNCHLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        WNCHLabel.setText("Winch Position");

        runwayLabel.setText(runway.getId());

        positionLabel.setText(position.getGliderPositionId());

        winchposLabel.setText((Float.toString((winch.getLatitude())) + " " + Float.toString(winch.getLongitude())));
        */
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FNLabel)
                            .addComponent(LNLabel)
                            .addComponent(MNLabel)
                            .addComponent(WGHTLabel)
                            .addComponent(CAPLabel)
                            .addComponent(PREFERLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(AIRLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(airfieldLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(GLDRLabel)
                            .addComponent(FNLabel)
                            .addComponent(GLDRWGHTLabel)
                            .addComponent(RUNLabel)
                            .addComponent(POSLabel)
                            .addComponent(WNCHLabel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(firstnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(33, 33, 33))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lastnameLabel)
                                            .addComponent(middlenameLabel)
                                            .addComponent(weightLabel)
                                            .addComponent(capabilityLabel)
                                            .addComponent(prefLabel)
                                            .addComponent(airfieldLabel)
                                            .addComponent(gliderLabel))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(runwayLabel)
                                            .addComponent(gliderweightLabel)
                                            .addComponent(positionLabel))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(winchposLabel)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FNLabel)
                    .addComponent(firstnameLabel))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LNLabel)
                    .addComponent(lastnameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MNLabel)
                    .addComponent(middlenameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WGHTLabel)
                    .addComponent(weightLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CAPLabel)
                    .addComponent(capabilityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PREFERLabel)
                    .addComponent(prefLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AIRLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(airfieldLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RUNLabel)
                    .addComponent(runwayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(POSLabel)
                    .addComponent(positionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WNCHLabel)
                    .addComponent(winchposLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gliderLabel)
                    .addComponent(GLDRLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GLDRWGHTLabel)
                    .addComponent(gliderweightLabel))
                .addContainerGap())
        );

        //pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CurrentScenario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrentScenario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrentScenario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrentScenario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrentScenario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel FNLabel;
    private javax.swing.JLabel middlenameLabel;
    private javax.swing.JLabel weightLabel;
    private javax.swing.JLabel capabilityLabel;
    private javax.swing.JLabel prefLabel;
    private javax.swing.JLabel airfieldLabel;
    private javax.swing.JLabel AIRLabel;
    private javax.swing.JLabel GLDRLabel;
    private javax.swing.JLabel GLDRWGHTLabel;
    private javax.swing.JLabel gliderLabel;
    private javax.swing.JLabel CAPLabel;
    private javax.swing.JLabel LNLabel;
    private javax.swing.JLabel RUNLabel;
    private javax.swing.JLabel POSLabel;
    private javax.swing.JLabel WNCHLabel;
    private javax.swing.JLabel runwayLabel;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JLabel winchposLabel;
    private javax.swing.JLabel firstnameLabel;
    private javax.swing.JLabel MNLabel;
    private javax.swing.JLabel WGHTLabel;
    private javax.swing.JLabel PREFERLabel;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel gliderweightLabel;
    // End of variables declaration                   
}