package ParameterSelection;

import AddEditPanels.AddEditGlider;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Sailplane;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.Font;

import javax.swing.JButton;

import Communications.Observer;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;


public class SailplanePanel extends JPanel implements Observer{
    private List<Sailplane> sailplanes = new ArrayList<Sailplane>();
    private CurrentDataObjectSet currentData;
    JScrollPane sailplaneScrollPane = new JScrollPane();
    
    @Override
    public void update()
    {
        initSailPlaneList();
        DefaultListModel sailplaneModel = new DefaultListModel();
        sailplaneModel.clear();
        for(Object str: sailplanes){
                sailplaneModel.addElement(str);
        }
        sailplaneJList.setModel(sailplaneModel);
        Sailplane currentSailplane = currentData.getCurrentSailplane();
        sailplaneJList.setSelectedValue(currentSailplane.toString(), true);
        sailplaneScrollPane.setViewportView(sailplaneJList);
        
        nNumberField.setText(currentSailplane.getNumber());
        nNumberField.setBackground(Color.GREEN);

        weakLinkField.setText(String.valueOf(currentSailplane.getMaxWeakLinkStrength()));
        weakLinkField.setBackground(Color.GREEN);

        tensionField.setText(String.valueOf(currentSailplane.getMaxTension()));
        tensionField.setBackground(Color.GREEN);

        releaseAngleField.setText(String.valueOf(currentSailplane.getCableReleaseAngle()));
        releaseAngleField.setBackground(Color.GREEN);

        stallSpeedField.setText(String.valueOf(currentSailplane.getIndicatedStallSpeed()));
        stallSpeedField.setBackground(Color.GREEN);

        grossWeightField.setText(String.valueOf(currentSailplane.getMaxGrossWeight()));
        grossWeightField.setBackground(Color.GREEN);

        emptyWeightField.setText(String.valueOf(currentSailplane.getEmptyWeight()));
        emptyWeightField.setBackground(Color.GREEN);

        winchingSpeedField.setText(String.valueOf(currentSailplane.getMaxWinchingSpeed()));
        winchingSpeedField.setBackground(Color.GREEN);

        if(currentSailplane.getCarryBallast())
        {
            ballastCheckBox.setSelected(true);
        }
        if(!currentSailplane.getCarryBallast())
        {
            ballastCheckBox.setSelected(false);
        }
        if(currentSailplane.getMultipleSeats())
        {
            multipleSeatsCheckBox.setSelected(true);
        }
        if(!currentSailplane.getMultipleSeats())
        {
            multipleSeatsCheckBox.setSelected(false);
        }
    }
    
    private Observer getObserver() {
        return this;
    }
    
    public void clear()
    {
        sailplaneJList.clearSelection();
        nNumberField.setText("");
        nNumberField.setBackground(Color.WHITE);
        weakLinkField.setText("");
        weakLinkField.setBackground(Color.WHITE);
        tensionField.setText("");
        tensionField.setBackground(Color.WHITE);
        releaseAngleField.setText("");
        releaseAngleField.setBackground(Color.WHITE);
        stallSpeedField.setText("");
        stallSpeedField.setBackground(Color.WHITE);
        grossWeightField.setText("");
        grossWeightField.setBackground(Color.WHITE);
        emptyWeightField.setText("");
        emptyWeightField.setBackground(Color.WHITE);
        winchingSpeedField.setText("");
        winchingSpeedField.setBackground(Color.WHITE);
        ballastCheckBox.setSelected(false);
        multipleSeatsCheckBox.setSelected(false);
    }
    
    private void sailplaneJListMouseClicked(java.awt.event.MouseEvent evt) 
    {
        if(sailplaneJList.getSelectedIndex() >= 0){
            try{
                Sailplane theSailplane = (Sailplane)sailplaneJList.getSelectedValue();
                currentData.setCurrentGlider(theSailplane);
                
                nNumberField.setText(theSailplane.getNumber());
                nNumberField.setBackground(Color.GREEN);

                weakLinkField.setText(String.valueOf(theSailplane.getMaxWeakLinkStrength()));
                weakLinkField.setBackground(Color.GREEN);

                tensionField.setText(String.valueOf(theSailplane.getMaxTension()));
                tensionField.setBackground(Color.GREEN);

                releaseAngleField.setText(String.valueOf(theSailplane.getCableReleaseAngle()));
                releaseAngleField.setBackground(Color.GREEN);

                stallSpeedField.setText(String.valueOf(theSailplane.getIndicatedStallSpeed()));
                stallSpeedField.setBackground(Color.GREEN);

                grossWeightField.setText(String.valueOf(theSailplane.getMaxGrossWeight()));
                grossWeightField.setBackground(Color.GREEN);

                emptyWeightField.setText(String.valueOf(theSailplane.getEmptyWeight()));
                emptyWeightField.setBackground(Color.GREEN);

                winchingSpeedField.setText(String.valueOf(theSailplane.getMaxWinchingSpeed()));
                winchingSpeedField.setBackground(Color.GREEN);
                
                if(theSailplane.getCarryBallast())
                {
                    ballastCheckBox.setSelected(true);
                }
                if(!theSailplane.getCarryBallast())
                {
                    ballastCheckBox.setSelected(false);
                }
                if(theSailplane.getMultipleSeats())
                {
                    multipleSeatsCheckBox.setSelected(true);
                }
                if(!theSailplane.getMultipleSeats())
                {
                    multipleSeatsCheckBox.setSelected(false);
                }
            } catch(Exception e) {
                //TODO respond to error
            }
        }
    }
    
    private void initSailPlaneList() {
        try{
            sailplanes = DatabaseUtilities.DatabaseDataObjectUtilities.getSailplanes();
            //sailplanes.add(0, new Sailplane("Default Glider", "", 0, 0, 0, 0, 0, 0, 0, false, false, ""));
            //sailplanes.add(new Sailplane("N5789678", "thing", 654, 698, 987, 231, 684, 161, 165, true, true, "khghjghjghjfghf"));
        }catch(SQLException e) 
        {
            //sailplanes.add(0, new Sailplane("Default Glider", "", 0, 0, 0, 0, 0, 0, 0, false, false, ""));
            //sailplanes.add(new Sailplane("N5789678", "thing", 654, 698, 987, 231, 684, 161, 165, true, true, "khghjghjghjfghf"));
        } catch (ClassNotFoundException ex) {

        }
    }
    
    /**
     * Creates new form sailplanePanel
     */
    public SailplanePanel() {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        initSailPlaneList();
        initComponents();
    }
    
    /**
     * Create the panel.
     */
    public void initComponents() {
        sailplaneJList = new javax.swing.JList();
        
        setLayout(new BorderLayout(0, 0));
        
        add(sailplaneScrollPane, BorderLayout.NORTH);
        DefaultListModel sailplaneModel = new DefaultListModel();
        for(Object str: sailplanes){
            sailplaneModel.addElement(str);
        }
        sailplaneJList.setModel(sailplaneModel);
        sailplaneJList.setSelectedIndex(0);
        sailplaneJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sailplaneJListMouseClicked(evt);
            }
        });

        sailplaneScrollPane.setViewportView(sailplaneJList);

        JPanel attributesPanel = new JPanel();
        attributesPanel.setBackground(Color.WHITE);
        JScrollPane attributesPanelScrollPane = new JScrollPane();
        add(attributesPanelScrollPane, BorderLayout.CENTER);
        attributesPanel.setPreferredSize(new Dimension(700,400));
        attributesPanelScrollPane.setViewportView(attributesPanel);
        attributesPanelScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
        attributesPanelScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        attributesPanel.setLayout(null);
        
        JLabel nNumberLabel = new JLabel("Registration Number:");
        nNumberLabel.setBounds(10, 53, 125, 14);
        attributesPanel.add(nNumberLabel);
        
        JLabel emptyWeightLabel = new JLabel("Empty Weight:");
        emptyWeightLabel.setBounds(10, 78, 86, 14);
        attributesPanel.add(emptyWeightLabel);
        
        JLabel maxGrossWeightLabel = new JLabel("Max Gross Weight:");
        maxGrossWeightLabel.setBounds(10, 103, 117, 14);
        attributesPanel.add(maxGrossWeightLabel);
        
        JLabel lblIndicatedStallSpeed = new JLabel("Indicated Stall Speed:");
        lblIndicatedStallSpeed.setBounds(10, 128, 140, 14);
        attributesPanel.add(lblIndicatedStallSpeed);
        
        stallSpeedField = new JTextField();
        stallSpeedField.setBackground(Color.WHITE);
        stallSpeedField.setEditable(false);
        stallSpeedField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        stallSpeedField.setBounds(160, 125, 110, 20);
        attributesPanel.add(stallSpeedField);
        stallSpeedField.setColumns(10);
        
        grossWeightField = new JTextField();
        grossWeightField.setBackground(Color.WHITE);
        grossWeightField.setEditable(false);
        grossWeightField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        grossWeightField.setBounds(160, 100, 110, 20);
        attributesPanel.add(grossWeightField);
        grossWeightField.setColumns(10);
        
        emptyWeightField = new JTextField();
        emptyWeightField.setBackground(Color.WHITE);
        emptyWeightField.setEditable(false);
        emptyWeightField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        emptyWeightField.setBounds(160, 75, 110, 20);
        attributesPanel.add(emptyWeightField);
        emptyWeightField.setColumns(10);
        
        nNumberField = new JTextField();
        nNumberField.setBackground(Color.WHITE);
        nNumberField.setEditable(false);
        nNumberField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        nNumberField.setBounds(160, 50, 110, 20);
        attributesPanel.add(nNumberField);
        nNumberField.setColumns(10);
        
        ballastCheckBox = new JCheckBox("Can Carry Ballast?");
        ballastCheckBox.setBackground(Color.WHITE);
        ballastCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    ballastField.setEnabled(true);
                    ballastField.setBackground(Color.WHITE);
                }
                else
                {
                    ballastField.setEnabled(false);
                    ballastField.setBackground(Color.LIGHT_GRAY);
                }
            }
        });
        ballastCheckBox.setBounds(10, 159, 154, 23);
        attributesPanel.add(ballastCheckBox);
        
        JLabel ballastLabel = new JLabel("Ballast Weight:");
        ballastLabel.setBounds(10, 189, 117, 14);
        attributesPanel.add(ballastLabel);
        
        ballastField = new JTextField();
        ballastField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        ballastField.setEnabled(false);
        ballastField.setBounds(160, 186, 110, 20);
        attributesPanel.add(ballastField);
        ballastField.setBackground(Color.LIGHT_GRAY);
        ballastField.setColumns(10);
        
        JLabel maxWinchingSpeedLabel = new JLabel("Max Winching Speed:");
        maxWinchingSpeedLabel.setBounds(320, 53, 140, 14);
        attributesPanel.add(maxWinchingSpeedLabel);
        
        JLabel maxWeakLinkLabel = new JLabel("Max Weak Link Strength:");
        maxWeakLinkLabel.setBounds(320, 78, 159, 14);
        attributesPanel.add(maxWeakLinkLabel);
        
        JLabel maxTensionLabel = new JLabel("Max Tension:");
        maxTensionLabel.setBounds(320, 103, 140, 14);
        attributesPanel.add(maxTensionLabel);
        
        JLabel cableReleaseAngleLabel = new JLabel("Cable Release Angle:");
        cableReleaseAngleLabel.setBounds(320, 128, 140, 14);
        attributesPanel.add(cableReleaseAngleLabel);
        
        multipleSeatsCheckBox = new JCheckBox("Multiple Seats?");
        multipleSeatsCheckBox.setBackground(Color.WHITE);
        
        multipleSeatsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    passengerWeightField.setEnabled(true);
                    passengerWeightField.setBackground(Color.WHITE);
                }
                else
                {
                    passengerWeightField.setEnabled(false);
                    passengerWeightField.setBackground(Color.LIGHT_GRAY);
                }
            }
        });
        multipleSeatsCheckBox.setBounds(320, 159, 159, 23);
        attributesPanel.add(multipleSeatsCheckBox);
        
        JLabel passengerWeightLabel = new JLabel("Total Passenger Weight:");
        passengerWeightLabel.setBounds(320, 189, 140, 14);
        attributesPanel.add(passengerWeightLabel);
        
        weakLinkField = new JTextField();
        weakLinkField.setBackground(Color.WHITE);
        weakLinkField.setEditable(false);
        weakLinkField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        weakLinkField.setBounds(487, 75, 120, 20);
        attributesPanel.add(weakLinkField);
        weakLinkField.setColumns(10);
        
        tensionField = new JTextField();
        tensionField.setBackground(Color.WHITE);
        tensionField.setEditable(false);
        tensionField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        tensionField.setBounds(487, 100, 120, 20);
        attributesPanel.add(tensionField);
        tensionField.setColumns(10);
        
        releaseAngleField = new JTextField();
        releaseAngleField.setBackground(Color.WHITE);
        releaseAngleField.setEditable(false);
        releaseAngleField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        releaseAngleField.setBounds(487, 125, 120, 20);
        attributesPanel.add(releaseAngleField);
        releaseAngleField.setColumns(10);
        
        passengerWeightField = new JTextField();
        passengerWeightField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        passengerWeightField.setEnabled(false);
        passengerWeightField.setBounds(487, 186, 120, 20);
        attributesPanel.add(passengerWeightField);
        passengerWeightField.setColumns(10);
        passengerWeightField.setBackground(Color.LIGHT_GRAY);
        
        winchingSpeedField = new JTextField();
        winchingSpeedField.setBackground(Color.WHITE);
        winchingSpeedField.setEditable(false);
        winchingSpeedField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        winchingSpeedField.setBounds(487, 50, 120, 20);
        attributesPanel.add(winchingSpeedField);
        winchingSpeedField.setColumns(10);
        
        JCheckBox baggageCheckBox = new JCheckBox("Baggage?");
        baggageCheckBox.setBackground(Color.WHITE);
        baggageCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    baggageField.setEnabled(true);
                    baggageField.setBackground(Color.WHITE);
                }
                else
                {
                    baggageField.setEnabled(false);
                    baggageField.setBackground(Color.LIGHT_GRAY);
                }
            }
        });
        baggageCheckBox.setBounds(10, 220, 97, 23);
        attributesPanel.add(baggageCheckBox);
        
        JLabel lblBaggageWeight = new JLabel("Baggage Weight:");
        lblBaggageWeight.setBounds(10, 250, 97, 14);
        attributesPanel.add(lblBaggageWeight);
        
        baggageField = new JTextField();
        baggageField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        baggageField.setEnabled(false);
        baggageField.setBounds(160, 247, 110, 20);
        attributesPanel.add(baggageField);
        baggageField.setColumns(10);
        baggageField.setBackground(Color.LIGHT_GRAY);
        
        JLabel lblGlider = new JLabel("Glider");
        lblGlider.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblGlider.setBounds(10, 20, 140, 31);
        attributesPanel.add(lblGlider);
        
        JButton addNewButton = new JButton("Add New");
        addNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    AddEditGlider AddEditGlider_ = new AddEditGlider(currentData.getCurrentSailplane(), false);
                    AddEditGlider_.setVisible(true);
                    AddEditGlider_.attach(getObserver());
        	}
        });
        addNewButton.setBounds(201, 0, 89, 23);
        attributesPanel.add(addNewButton);
        
        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    AddEditGlider AddEditGlider_ = new AddEditGlider(currentData.getCurrentSailplane(), true);
                    AddEditGlider_.setVisible(true);
                    AddEditGlider_.attach(getObserver());
        	}
        });
        editButton.setBounds(289, 0, 89, 23);
        attributesPanel.add(editButton);
        
        JLabel emptyWeightUnits = new JLabel("kgs");
        emptyWeightUnits.setBounds(280, 78, 46, 14);
        attributesPanel.add(emptyWeightUnits);
        
        JLabel maxGrossWeightUnits = new JLabel("kgs");
        maxGrossWeightUnits.setBounds(280, 103, 46, 14);
        attributesPanel.add(maxGrossWeightUnits);
        
        JLabel stallSpeedUnits = new JLabel("km/h");
        stallSpeedUnits.setBounds(280, 128, 46, 14);
        attributesPanel.add(stallSpeedUnits);
        
        JLabel ballastWeightUnits = new JLabel("kgs");
        ballastWeightUnits.setBounds(280, 189, 46, 14);
        attributesPanel.add(ballastWeightUnits);
        
        JLabel baggageWeightUnits = new JLabel("kgs");
        baggageWeightUnits.setBounds(280, 250, 46, 14);
        attributesPanel.add(baggageWeightUnits);
        
        JLabel passengerWeightUnits = new JLabel("kgs");
        passengerWeightUnits.setBounds(617, 189, 46, 14);
        attributesPanel.add(passengerWeightUnits);
        
        JLabel cableReleaseAngleUnits = new JLabel("degrees");
        cableReleaseAngleUnits.setBounds(617, 128, 65, 14);
        attributesPanel.add(cableReleaseAngleUnits);
        
        JLabel tensionUnits = new JLabel("N");
        tensionUnits.setBounds(617, 103, 46, 14);
        attributesPanel.add(tensionUnits);
        
        JLabel weakLinkStrengthUnits = new JLabel("N");
        weakLinkStrengthUnits.setBounds(617, 78, 46, 14);
        attributesPanel.add(weakLinkStrengthUnits);
        
        JLabel winchingSpeedUnits = new JLabel("km/h");
        winchingSpeedUnits.setBounds(617, 53, 46, 14);
        attributesPanel.add(winchingSpeedUnits);
    }
        
    private javax.swing.JList sailplaneJList;
    private JTextField stallSpeedField;
    private JTextField grossWeightField;
    private JTextField emptyWeightField;
    private JTextField nNumberField;
    private JTextField ballastField;
    private JTextField weakLinkField;
    private JTextField tensionField;
    private JTextField releaseAngleField;
    private JTextField passengerWeightField;
    private JTextField winchingSpeedField;
    private JTextField baggageField;
    private JCheckBox multipleSeatsCheckBox;
    private JCheckBox ballastCheckBox;
    
    @Override
    public void update(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
