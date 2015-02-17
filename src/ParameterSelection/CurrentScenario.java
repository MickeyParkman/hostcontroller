/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParameterSelection;
import DataObjects.*;
import Communications.Observer;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
/**
 *
 * @author Johnny White
 */
public class CurrentScenario extends javax.swing.JPanel implements Observer {
    private CurrentDataObjectSet data;
    /**
     * Creates new form CurrentScenario
     */
    public CurrentScenario() {
        data = CurrentDataObjectSet.getCurrentDataObjectSet();
        data.attach(this);
        initComponents();
        loadScenario();
    }
    
    private void loadScenario() {
        
        Pilot pilot = data.getCurrentPilot();
        Sailplane glider = data.getCurrentSailplane();
        Airfield airfield = data.getCurrentAirfield();
        GliderPosition position = data.getCurrentGliderPosition();
        Runway runway = data.getCurrentRunway();
        WinchPosition winch = data.getCurrentWinchPosition();   
        Drum drum = data.getCurrentDrum();
        
        if(pilot == null) {
            pilotNameLabel.setText("NO PILOT");
            pilotNameLabel.setForeground(Color.RED);       
        } else {
            pilotNameLabel.setText(pilot.toString());      
            pilotNameLabel.setForeground(Color.BLACK);       
        }

        if(airfield == null) {
            airfieldLabel.setText("NO AIRFIELD");
            airfieldLabel.setForeground(Color.RED); 
        } else {
            airfieldLabel.setText(airfield.toString());    
            airfieldLabel.setForeground(Color.BLACK); 
        }

        if(glider == null) {
            gliderLabel.setText("NO GLIDER");
            gliderLabel.setForeground(Color.RED); 
        } else {
            gliderLabel.setText(glider.toString());
            gliderLabel.setForeground(Color.BLACK); 
        }
        
        if(runway == null) {
            runwayLabel.setText("NO RUNWAY");        
            runwayLabel.setForeground(Color.RED); 
        } else {
            runwayLabel.setText(runway.toString());
            runwayLabel.setForeground(Color.BLACK); 
        }
        
        if(position == null) {
            positionLabel.setText("NO GLIDER POSITION");            
            positionLabel.setForeground(Color.RED); 
        } else {
            positionLabel.setText(position.toString());    
            positionLabel.setForeground(Color.BLACK); 
        }

        if(winch == null) {
            winchposLabel.setText("NO WINCH POSITION");            
            winchposLabel.setForeground(Color.RED); 
        } else {
            winchposLabel.setText(winch.toString());    
            winchposLabel.setForeground(Color.BLACK); 
        }
        
        if(drum == null) {
            drumLabel.setText("NO DRUM"); 
            drumLabel.setForeground(Color.RED);
        } else {
            drumLabel.setText(drum.toString());    
            drumLabel.setForeground(Color.BLACK);  
        }
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        airfieldLabel = new JLabel();
        gliderLabel = new JLabel();
        runwayLabel = new JLabel();
        positionLabel = new JLabel();
        winchposLabel = new JLabel();
        pilotNameLabel = new JLabel();
        drumLabel = new JLabel();
        TitleLabel = new JLabel("Current Scenario");
        //TitleLabel.setFon
        
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(TitleLabel);
        this.add(pilotNameLabel);
        this.add(gliderLabel);
        this.add(airfieldLabel);
        this.add(runwayLabel);
        this.add(positionLabel);
        this.add(winchposLabel);
        this.add(drumLabel);
    }                      

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

    private JLabel airfieldLabel;
    private JLabel gliderLabel;
    private JLabel runwayLabel;
    private JLabel positionLabel;
    private JLabel winchposLabel;
    private JLabel pilotNameLabel;
    private JLabel TitleLabel;
    private JLabel drumLabel;

    public void update() {
       loadScenario();
    }
    
    public void update(String s){}
}