/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParameterSelection;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import Communications.Observer;

/**
 *
 * @author Johnny White
 */
public class EnvironmentalWindow extends javax.swing.JPanel implements Observer{

    /**
     * Creates new form EnvironmentalWindow
     */
    public EnvironmentalWindow() {
        initComponents();
        loadEnvironmentalData();
    }
               
    public void loadEnvironmentalData()
    {
        altdensityLabel.setText("100");
        pressureLabel.setText("100");
        temperatureLabel.setText("100");
        windspeedLabel.setText("100");
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

        EnvLabel.setText("Environmental Data");

        WNDSPDLabel.setText("Wind Speed");

        TEMPLabel.setText("Temperature");

        PRSSRLabel.setText("Pressure");

        jLabel1.setText("Altitude Density");
        
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(EnvLabel);
        this.add(WNDSPDLabel);
        this.add(windspeedLabel);
        this.add(PRSSRLabel);
        this.add(pressureLabel);
        this.add(TEMPLabel);
        this.add(temperatureLabel);
        this.add(jLabel1);
        this.add(altdensityLabel);
    }                      


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

    @Override
    public void update() {
        loadEnvironmentalData();
    }
}
