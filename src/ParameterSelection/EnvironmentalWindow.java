/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParameterSelection;

import java.awt.Dimension;

/**
 *
 * @author Johnny White
 */
public class EnvironmentalWindow extends javax.swing.JPanel {

    /**
     * Creates new form EnvironmentalWindow
     */
    public EnvironmentalWindow() {
        initComponents();
    }
                  
    private void initComponents() {
        this.setPreferredSize(new Dimension (200, 400));
        EnvLabel = new javax.swing.JLabel();
        WNDSPDLabel = new javax.swing.JLabel();
        TEMPLabel = new javax.swing.JLabel();
        PRSSRLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        windspeedLabel = new javax.swing.JLabel();
        temperatureLabel = new javax.swing.JLabel();
        pressureLabel = new javax.swing.JLabel();
        altdensityLabel = new javax.swing.JLabel();

        EnvLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        EnvLabel.setText("Environmental Data");

        WNDSPDLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        WNDSPDLabel.setText("Wind Speed");

        TEMPLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TEMPLabel.setText("Temperature");

        PRSSRLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PRSSRLabel.setText("Pressure");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Altitude Density");

        windspeedLabel.setText("jLabel2");

        temperatureLabel.setText("jLabel3");

        pressureLabel.setText("jLabel4");

        altdensityLabel.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TEMPLabel)
                    .addComponent(PRSSRLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(altdensityLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(temperatureLabel)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(WNDSPDLabel)
                            .addGap(45, 45, 45)
                            .addComponent(windspeedLabel))
                        .addComponent(pressureLabel)
                        .addComponent(EnvLabel)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EnvLabel)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WNDSPDLabel)
                    .addComponent(windspeedLabel))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TEMPLabel)
                    .addComponent(temperatureLabel))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PRSSRLabel)
                    .addComponent(pressureLabel))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(altdensityLabel))
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel EnvLabel;
    private javax.swing.JLabel PRSSRLabel;
    private javax.swing.JLabel TEMPLabel;
    private javax.swing.JLabel WNDSPDLabel;
    private javax.swing.JLabel altdensityLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pressureLabel;
    private javax.swing.JLabel temperatureLabel;
    private javax.swing.JLabel windspeedLabel;
    // End of variables declaration                   
}
