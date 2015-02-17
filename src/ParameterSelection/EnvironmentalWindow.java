/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParameterSelection;

import Communications.MessagePipeline;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import Communications.Observer;

/**
 *
 * @author Johnny White
 */
public class EnvironmentalWindow extends javax.swing.JPanel implements Observer{

    private MessagePipeline pipe;
    private final int HEARTBEAT_COUNT = 1;
    private float curTick;
    private float temp;
    private float density;
    private float pressure;
    private float speed;
    
    public EnvironmentalWindow() {
        temp = 0;
        density = 0;
        pressure = 0;
        speed = 0;
        curTick = 0;
        initComponents();
        pipe = MessagePipeline.getInstance();
        pipe.attach(this);
        loadEnvironmentalData("0 0 0 0");
        updateDisplay();
    }
               
    public void loadEnvironmentalData(String message)
    {
        String mParts[] = message.split(" ");
        density += Integer.parseInt(mParts[0]);
        temp += Integer.parseInt(mParts[1]);
        speed += Integer.parseInt(mParts[2]);
        pressure += Integer.parseInt(mParts[3]);

    }
    
    private void updateDisplay() {
        temp /= HEARTBEAT_COUNT;
        density /= HEARTBEAT_COUNT;
        pressure /= HEARTBEAT_COUNT;
        speed /= HEARTBEAT_COUNT;
        altdensityLabel.setText(String.valueOf(density));
        pressureLabel.setText(String.valueOf(pressure));
        temperatureLabel.setText(String.valueOf(temp));
        windspeedLabel.setText(String.valueOf(speed));
        temp = 0;
        density = 0;
        pressure = 0;
        speed = 0;
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

    public void update() {
       // loadEnvironmentalData();
    }
    
    public void update(String message){
        loadEnvironmentalData(message);
        //++curTick;
        //if(curTick == HEARTBEAT_COUNT) {
        //    curTick = 0;
            updateDisplay();
        //}
    }
}
