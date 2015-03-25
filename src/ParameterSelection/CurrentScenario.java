/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParameterSelection;
import DataObjects.*;
import Communications.Observer;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
/**
 *
 * @author Johnny White
 */
public class CurrentScenario extends javax.swing.JPanel implements Observer {
    private CurrentDataObjectSet data;
    private CardLayout selectionLayout_;
    private ParameterSelectionPanel ParameterSelectionPanel_;
    /**
     * Creates new form CurrentScenario
     */
    public CurrentScenario(CardLayout selectionLayout, ParameterSelectionPanel ParamSelectionPanel_) {
        data = CurrentDataObjectSet.getCurrentDataObjectSet();
        data.attach(this);
        selectionLayout_ = selectionLayout;
        ParameterSelectionPanel_ = ParamSelectionPanel_;
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
            pilotNameLabel.setForeground(new Color(0,128,0));       
        }

        if(airfield == null) {
            airfieldLabel.setText("NO AIRFIELD");
            airfieldLabel.setForeground(Color.RED); 
        } else {
            airfieldLabel.setText(airfield.toString());    
            airfieldLabel.setForeground(new Color(0,128,0)); 
        }

        if(glider == null) {
            gliderLabel.setText("NO GLIDER");
            gliderLabel.setForeground(Color.RED); 
        } else {
            gliderLabel.setText(glider.toString());
            gliderLabel.setForeground(new Color(0,128,0)); 
        }
        
        if(runway == null) {
            runwayLabel.setText("NO RUNWAY");        
            runwayLabel.setForeground(Color.RED); 
        } else {
            runwayLabel.setText(runway.toString());
            runwayLabel.setForeground(new Color(0,128,0)); 
        }
        
        if(position == null) {
            positionLabel.setText("NO GLIDER POSITION");            
            positionLabel.setForeground(Color.RED); 
        } else {
            positionLabel.setText(position.toString());    
            positionLabel.setForeground(new Color(0,128,0)); 
        }

        if(winch == null) {
            winchposLabel.setText("NO WINCH POSITION");            
            winchposLabel.setForeground(Color.RED); 
        } else {
            winchposLabel.setText(winch.toString());    
            winchposLabel.setForeground(new Color(0,128,0)); 
        }
        
        if(drum == null) {
            drumLabel.setText("NO DRUM"); 
            drumLabel.setForeground(Color.RED);
        } else {
            drumLabel.setText(drum.toString());    
            drumLabel.setForeground(new Color(0,128,0));  
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
        TitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        pilotButton = new JButton("Select Pilot");
        gliderButton = new JButton("Select Glider");
        airfieldButton = new JButton("Select Airfield");
        runwayButton = new JButton("Select Runway");
        gliderPosButton = new JButton("Select Glider Position");
        winchPosButton = new JButton("Select Winch Position");
        drumButton = new JButton("Select Drum");
        clearButton = new JButton("Clear All");
        
        this.setPreferredSize(new Dimension(200,350));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.WHITE);
        
        pilotButton.setMinimumSize(new Dimension(200, 20));
        pilotButton.setMaximumSize(new Dimension(200, 20));
        pilotButton.setBackground(new Color(200,200,200));
        pilotButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    selectionLayout_.first(ParameterSelectionPanel_);
        	}
        });
        
        gliderButton.setMinimumSize(new Dimension(200, 20));
        gliderButton.setMaximumSize(new Dimension(200, 20));
        gliderButton.setBackground(new Color(200,200,200));
        gliderButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    selectionLayout_.first(ParameterSelectionPanel_);
                    selectionLayout_.next(ParameterSelectionPanel_);
        	}
        });
        
        airfieldButton.setMinimumSize(new Dimension(200, 20));
        airfieldButton.setMaximumSize(new Dimension(200, 20));
        airfieldButton.setBackground(new Color(200,200,200));
        airfieldButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    selectionLayout_.first(ParameterSelectionPanel_);
                    selectionLayout_.next(ParameterSelectionPanel_);
                    selectionLayout_.next(ParameterSelectionPanel_);
        	}
        });
        
        runwayButton.setMinimumSize(new Dimension(200, 20));
        runwayButton.setMaximumSize(new Dimension(200, 20));
        runwayButton.setBackground(new Color(200,200,200));
        runwayButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    selectionLayout_.first(ParameterSelectionPanel_);
                    selectionLayout_.next(ParameterSelectionPanel_);
                    selectionLayout_.next(ParameterSelectionPanel_);
        	}
        });
        
        gliderPosButton.setMinimumSize(new Dimension(200, 20));
        gliderPosButton.setMaximumSize(new Dimension(200, 20));
        gliderPosButton.setBackground(new Color(200,200,200));
        gliderPosButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    selectionLayout_.first(ParameterSelectionPanel_);
                    selectionLayout_.next(ParameterSelectionPanel_);
                    selectionLayout_.next(ParameterSelectionPanel_);
        	}
        });
        
        winchPosButton.setMinimumSize(new Dimension(200, 20));
        winchPosButton.setMaximumSize(new Dimension(200, 20));
        winchPosButton.setBackground(new Color(200,200,200));
        winchPosButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    selectionLayout_.first(ParameterSelectionPanel_);
                    selectionLayout_.next(ParameterSelectionPanel_);
                    selectionLayout_.next(ParameterSelectionPanel_);
        	}
        });
        
        drumButton.setMinimumSize(new Dimension(200, 20));
        drumButton.setMaximumSize(new Dimension(200, 20));
        drumButton.setBackground(new Color(200,200,200));
        drumButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    selectionLayout_.first(ParameterSelectionPanel_);
                    selectionLayout_.next(ParameterSelectionPanel_);
                    selectionLayout_.next(ParameterSelectionPanel_);
                    selectionLayout_.next(ParameterSelectionPanel_);
        	}
        });
        
        
        clearButton.setMinimumSize(new Dimension(200, 20));
        clearButton.setMaximumSize(new Dimension(200, 20));
        clearButton.setBackground(new Color(200,200,200));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ParameterSelectionPanel_.clear();
                data.cleafGliderPosition();
                data.clearAirfield();
                data.clearGlider();
                data.clearPilot();
                data.clearRunway();
                data.clearWinchPosition();
                data.clearDrum();
                
            }
        });
        
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(TitleLabel);
        this.add(pilotNameLabel);
        this.add(pilotButton);
        this.add(gliderLabel);
        this.add(gliderButton);
        this.add(airfieldLabel);
        this.add(airfieldButton);
        this.add(runwayLabel);
        this.add(runwayButton);
        this.add(positionLabel);
        this.add(gliderPosButton);
        this.add(winchposLabel);
        this.add(winchPosButton);
        this.add(drumLabel);
        this.add(drumButton);
        this.add(new JLabel(" "));
        this.add(clearButton);
    }                      

    private JLabel airfieldLabel;
    private JLabel gliderLabel;
    private JLabel runwayLabel;
    private JLabel positionLabel;
    private JLabel winchposLabel;
    private JLabel pilotNameLabel;
    private JLabel TitleLabel;
    private JLabel drumLabel;
    private JButton pilotButton; 
    private JButton gliderButton; 
    private JButton airfieldButton; 
    private JButton runwayButton; 
    private JButton gliderPosButton; 
    private JButton winchPosButton; 
    private JButton drumButton;
    private JButton clearButton;

    public void update() {
       loadScenario();
    }
    
    public void update(String s){}
}