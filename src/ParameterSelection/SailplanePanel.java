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


public class SailplanePanel extends JPanel {
    private List<Sailplane> sailplanes = new ArrayList<Sailplane>();
    private CurrentDataObjectSet currentData;
    
    public void clear()
    {
        sailplaneJList.clearSelection();
        nNumberField.setText("");
        nNumberField.setBackground(new Color(255, 255, 255));
        weakLinkField.setText("");
        weakLinkField.setBackground(new Color(255, 255, 255));
        tensionField.setText("");
        tensionField.setBackground(new Color(255, 255, 255));
        releaseAngleField.setText("");
        releaseAngleField.setBackground(new Color(255, 255, 255));
        stallSpeedField.setText("");
        stallSpeedField.setBackground(new Color(255, 255, 255));
        grossWeightField.setText("");
        grossWeightField.setBackground(new Color(255, 255, 255));
        emptyWeightField.setText("");
        emptyWeightField.setBackground(new Color(255, 255, 255));
        winchingSpeedField.setText("");
        winchingSpeedField.setBackground(new Color(255, 255, 255));
    }
    private void sailplaneJListMouseClicked(java.awt.event.MouseEvent evt) 
    {
        if(sailplaneJList.getSelectedIndex() >= 0){
            try{
                Sailplane theSailplane = (Sailplane)sailplaneJList.getSelectedValue();
                currentData.setCurrentGlider(theSailplane);
                
                nNumberField.setText(theSailplane.getNumber());
                nNumberField.setBackground(new Color(142, 250, 127));

                weakLinkField.setText(String.valueOf(theSailplane.getMaxWeakLinkStrength()));
                weakLinkField.setBackground(new Color(142, 250, 127));

                tensionField.setText(String.valueOf(theSailplane.getMaxTension()));
                tensionField.setBackground(new Color(142, 250, 127));

                releaseAngleField.setText(String.valueOf(theSailplane.getCableReleaseAngle()));
                releaseAngleField.setBackground(new Color(142, 250, 127));

                stallSpeedField.setText(String.valueOf(theSailplane.getIndicatedStallSpeed()));
                stallSpeedField.setBackground(new Color(142, 250, 127));

                grossWeightField.setText(String.valueOf(theSailplane.getMaxGrossWeight()));
                grossWeightField.setBackground(new Color(142, 250, 127));

                emptyWeightField.setText(String.valueOf(theSailplane.getEmptyWeight()));
                emptyWeightField.setBackground(new Color(142, 250, 127));

                winchingSpeedField.setText(String.valueOf(theSailplane.getMaxWinchingSpeed()));
                winchingSpeedField.setBackground(new Color(142, 250, 127));
            } catch(Exception e) {
                //TODO respond to error
            }
        }
    }
    
    private void initSailPlaneList() {
        try{
            sailplanes = DatabaseUtilities.DatabaseDataObjectUtilities.getSailplanes();
            sailplanes.add(0, new Sailplane("Default Glider", "", 0, 0, 0, 0, 0, 0, 0, false, false, ""));
            sailplanes.add(new Sailplane("N5789678", "thing", 654, 698, 987, 231, 684, 161, 165, true, true, "khghjghjghjfghf"));
        }catch(SQLException e) 
        {
            sailplanes.add(0, new Sailplane("Default Glider", "", 0, 0, 0, 0, 0, 0, 0, false, false, ""));
            sailplanes.add(new Sailplane("N5789678", "thing", 654, 698, 987, 231, 684, 161, 165, true, true, "khghjghjghjfghf"));
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

        JScrollPane sailplaneScrollPane = new JScrollPane();
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

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JLabel nNumberLabel = new JLabel("N Number:");
        nNumberLabel.setBounds(10, 53, 86, 14);
        panel.add(nNumberLabel);
        
        JLabel emptyWeightLabel = new JLabel("Empty Weight:");
        emptyWeightLabel.setBounds(10, 78, 86, 14);
        panel.add(emptyWeightLabel);
        
        JLabel maxGrossWeightLabel = new JLabel("Max Gross Weight:");
        maxGrossWeightLabel.setBounds(10, 103, 117, 14);
        panel.add(maxGrossWeightLabel);
        
        JLabel lblIndicatedStallSpeed = new JLabel("Indicated Stall Speed:");
        lblIndicatedStallSpeed.setBounds(10, 128, 140, 14);
        panel.add(lblIndicatedStallSpeed);
        
        stallSpeedField = new JTextField();
        stallSpeedField.setBounds(160, 125, 110, 20);
        panel.add(stallSpeedField);
        stallSpeedField.setColumns(10);
        
        grossWeightField = new JTextField();
        grossWeightField.setBounds(160, 100, 110, 20);
        panel.add(grossWeightField);
        grossWeightField.setColumns(10);
        
        emptyWeightField = new JTextField();
        emptyWeightField.setBounds(160, 75, 110, 20);
        panel.add(emptyWeightField);
        emptyWeightField.setColumns(10);
        
        nNumberField = new JTextField();
        nNumberField.setBounds(160, 50, 110, 20);
        panel.add(nNumberField);
        nNumberField.setColumns(10);
        
        JCheckBox ballastCheckBox = new JCheckBox("Can Carry Ballast?");
        ballastCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    ballastField.setEnabled(true);
                }
                else
                {
                    ballastField.setEnabled(false);
                }
            }
        });
        ballastCheckBox.setBounds(10, 159, 154, 23);
        panel.add(ballastCheckBox);
        
        JLabel ballastLabel = new JLabel("Ballast Weight:");
        ballastLabel.setBounds(10, 189, 117, 14);
        panel.add(ballastLabel);
        
        ballastField = new JTextField();
        ballastField.setEnabled(false);
        ballastField.setBounds(160, 186, 110, 20);
        panel.add(ballastField);
        ballastField.setColumns(10);
        
        JLabel maxWinchingSpeedLabel = new JLabel("Max Winching Speed:");
        maxWinchingSpeedLabel.setBounds(320, 53, 140, 14);
        panel.add(maxWinchingSpeedLabel);
        
        JLabel maxWeakLinkLabel = new JLabel("Max Weak Link Strength:");
        maxWeakLinkLabel.setBounds(320, 78, 159, 14);
        panel.add(maxWeakLinkLabel);
        
        JLabel maxTensionLabel = new JLabel("Max Tension:");
        maxTensionLabel.setBounds(320, 103, 140, 14);
        panel.add(maxTensionLabel);
        
        JLabel cableReleaseAngleLabel = new JLabel("Cable Release Angle:");
        cableReleaseAngleLabel.setBounds(320, 128, 140, 14);
        panel.add(cableReleaseAngleLabel);
        
        JCheckBox multipleSeatsCheckBox = new JCheckBox("Multiple Seats?");
        ballastCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    passengerWeightField.setEnabled(true);
                }
                else
                {
                    passengerWeightField.setEnabled(false);
                }
            }
        });
        multipleSeatsCheckBox.setBounds(320, 159, 159, 23);
        panel.add(multipleSeatsCheckBox);
        
        JLabel passengerWeightLabel = new JLabel("Total Passenger Weight:");
        passengerWeightLabel.setBounds(320, 189, 140, 14);
        panel.add(passengerWeightLabel);
        
        weakLinkField = new JTextField();
        weakLinkField.setBounds(487, 75, 120, 20);
        panel.add(weakLinkField);
        weakLinkField.setColumns(10);
        
        tensionField = new JTextField();
        tensionField.setBounds(487, 100, 120, 20);
        panel.add(tensionField);
        tensionField.setColumns(10);
        
        releaseAngleField = new JTextField();
        releaseAngleField.setBounds(487, 125, 120, 20);
        panel.add(releaseAngleField);
        releaseAngleField.setColumns(10);
        
        passengerWeightField = new JTextField();
        passengerWeightField.setEnabled(false);
        passengerWeightField.setBounds(487, 186, 120, 20);
        panel.add(passengerWeightField);
        passengerWeightField.setColumns(10);
        
        winchingSpeedField = new JTextField();
        winchingSpeedField.setBounds(487, 50, 120, 20);
        panel.add(winchingSpeedField);
        winchingSpeedField.setColumns(10);
        
        JCheckBox baggageCheckBox = new JCheckBox("Baggage?");
        ballastCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    baggageField.setEnabled(true);
                }
                else
                {
                    baggageField.setEnabled(false);
                }
            }
        });
        baggageCheckBox.setBounds(10, 220, 97, 23);
        panel.add(baggageCheckBox);
        
        JLabel lblBaggageWeight = new JLabel("Baggage Weight:");
        lblBaggageWeight.setBounds(10, 250, 97, 14);
        panel.add(lblBaggageWeight);
        
        baggageField = new JTextField();
        baggageField.setEnabled(false);
        baggageField.setBounds(160, 247, 110, 20);
        panel.add(baggageField);
        baggageField.setColumns(10);
        
        JLabel lblGlider = new JLabel("Glider");
        lblGlider.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblGlider.setBounds(10, 20, 140, 31);
        panel.add(lblGlider);
        
        JButton addNewButton = new JButton("Add New");
        addNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    AddEditGlider AddEditGlider_ = new AddEditGlider(currentData.getCurrentSailplane(), false);
                    AddEditGlider_.setVisible(true);
        	}
        });
        addNewButton.setBounds(201, 0, 89, 23);
        panel.add(addNewButton);
        
        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    AddEditGlider AddEditGlider_ = new AddEditGlider(currentData.getCurrentSailplane(), true);
                    AddEditGlider_.setVisible(true);
        	}
        });
        editButton.setBounds(289, 0, 89, 23);
        panel.add(editButton);
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
}
