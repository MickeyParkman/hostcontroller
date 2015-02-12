package ParameterSelection;

import DataObjects.Airfield;
import DataObjects.GliderPosition;
import DataObjects.Runway;
import DataObjects.WinchPosition;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AirfieldPanel extends JPanel {

    private javax.swing.JScrollPane airfieldScrollPane;
    private List<Airfield> airfields = new ArrayList<Airfield>();
    private javax.swing.JScrollPane gliderPositionsScrollPane;
    private List<GliderPosition> gliderPositions = new ArrayList<GliderPosition>();
    private javax.swing.JScrollPane winchPositionsScrollPane;
    private List<WinchPosition> winchPositions = new ArrayList<WinchPosition>();
    private javax.swing.JScrollPane runwaysScrollPane;
    private List<Runway> runways = new ArrayList<Runway>();
    private DefaultListModel runwaysModel = new DefaultListModel();
    private DefaultListModel gliderPositionModel = new DefaultListModel();
    private DefaultListModel winchPositionModel = new DefaultListModel();
    private javax.swing.JList airfieldJList = new javax.swing.JList();
    private javax.swing.JList runwaysJList = new javax.swing.JList();
    private javax.swing.JList winchPositionsJList = new javax.swing.JList();
    private javax.swing.JList gliderPositionsJList = new javax.swing.JList();
    private JTextField airfieldAltitudeField;
    private JTextField designatorField;
    private JTextField airfieldNameField;
    private JTextField magneticVariationField;
    private JTextField airfieldLongitudeField;
    private JTextField airfieldLatitudeField;
    private JTextField magneticHeadingField;
    private JTextField runwayNameField;
    private JTextField runwayAltitudeField;
    private JTextField runwayParentAirfieldField;
    private JTextField runwaySlopeField;
    private JTextField gliderPosParentRunwayField;
    private JTextField gliderPosParentAirfieldField;
    private JTextField gliderPosLatitudeField;
    private JTextField gliderPosLongitudeField;
    private JTextField gliderPosAltitudeField;
    private JTextField gliderPosNameField;
    private JTextField winchPosNameField;
    private JTextField winchPosAltitudeField;
    private JTextField winchPosLongitudeField;
    private JTextField winchPosLatitudeField;
    private JTextField winchPosParentAirfieldField;
    private JTextField winchPosParentRunwayField;

    private void initAirfieldList() {
        try{
            airfields = DatabaseUtilities.DatabaseDataObjectUtilities.getAirfields();
            airfields.add(new Airfield("The place", "Spokane", 1000, 5, 5, 5, "sdfgsdgf"));   
        }catch(SQLException e) {
            airfields.add(new Airfield("The place", "Spokane", 1000, 5, 5, 5, "sdfgsdgf"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirfieldPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initGliderPositionsList() {
        try{
            gliderPositions = DatabaseUtilities.DatabaseDataObjectUtilities.getGliderPositions();
            gliderPositions.add(new GliderPosition("The glider position", "The Runway", 5, 5, 5, "sdfgsdgf"));
        }catch(SQLException e) {
            gliderPositions.add(new GliderPosition("The glider position", "The Runway", 5, 5, 5, "sdfgsdgf"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirfieldPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initWinchPositionsList() {
        try{
            winchPositions = DatabaseUtilities.DatabaseDataObjectUtilities.getWinchPositions();
            winchPositions.add(new WinchPosition("The winch position", "The Runway", 5, 5, 5, "sdfgsdgf"));
        }catch(SQLException e) {
            winchPositions.add(new WinchPosition("The winch position", "The Runway", 5, 5, 5, "sdfgsdgf"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirfieldPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initRunwaysList() {
        try{
            runways = DatabaseUtilities.DatabaseDataObjectUtilities.getRunways();
            runways.add(new Runway("The Runway", "North", "The place", 5, "sdghsdg"));
        }catch(SQLException e) {
            runways.add(new Runway("The Runway", "North", "The place", 5, "sdghsdg"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirfieldPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    private void airfieldJListMouseClicked(java.awt.event.MouseEvent evt) 
    {
        if(airfieldJList.getSelectedIndex() >= 0){
            try{
                Airfield theAirfield = (Airfield)airfieldJList.getSelectedValue();
                //select * in runways where parent = theAirfield;
                airfieldNameField.setText(theAirfield.getName());
                airfieldNameField.setBackground(new Color(142, 250, 127));
                
                designatorField.setText(String.valueOf(theAirfield.getDesignator()));
                designatorField.setBackground(new Color(142, 250, 127));
                
                airfieldAltitudeField.setText(String.valueOf(theAirfield.getAltitude()));
                airfieldAltitudeField.setBackground(new Color(142, 250, 127));
                
                magneticVariationField.setText(String.valueOf(theAirfield.getMagneticVariation()));
                magneticVariationField.setBackground(new Color(142, 250, 127));
                
                airfieldLongitudeField.setText(String.valueOf(theAirfield.getLongitude()));
                airfieldLongitudeField.setBackground(new Color(142, 250, 127));
                
                airfieldLatitudeField.setText(String.valueOf(theAirfield.getLatitude()));
                airfieldLatitudeField.setBackground(new Color(142, 250, 127));
                
                for(Object str: runways){
                        runwaysModel.addElement(str);
                }
                runwaysJList.setModel(runwaysModel);
                runwaysScrollPane.setViewportView(runwaysJList);
                
            } catch(Exception e) {
                //TODO respond to error
            }
        }
    }
    
    private void runwayJListMouseClicked(java.awt.event.MouseEvent evt) 
    {
        if(runwaysJList.getSelectedIndex() >= 0){
            try{
                Runway theRunway = (Runway)runwaysJList.getSelectedValue();

                for(Object str: gliderPositions){
                        gliderPositionModel.addElement(str);
                }
                
                for(Object str: winchPositions){
                        winchPositionModel.addElement(str);
                }

            } catch(Exception e) {
                //TODO respond to error
            }
        }
    }
    
    private void gliderPositionsJListMouseClicked(java.awt.event.MouseEvent evt) 
    {
        if(gliderPositionsJList.getSelectedIndex() >= 0){
            try{
                GliderPosition theGliderPosition = (GliderPosition)gliderPositionsJList.getSelectedValue();

            } catch(Exception e) {
                //TODO respond to error
            }
        }
    }
    
    private void winchPositionsJListMouseClicked(java.awt.event.MouseEvent evt) 
    {
        if(winchPositionsJList.getSelectedIndex() >= 0){
            try{
                WinchPosition theWinchPosition = (WinchPosition)winchPositionsJList.getSelectedValue();

            } catch(Exception e) {
                //TODO respond to error
            }
        }
    }
    
    /**
     * Creates new form sailplanePanel
     */
    public AirfieldPanel() {
        initAirfieldList();
        initWinchPositionsList();
        initGliderPositionsList();
        initRunwaysList();
        initComponents();
    }
    
    /**
     * Create the panel.
     */
    public void initComponents() {
        airfieldScrollPane = new javax.swing.JScrollPane();
        gliderPositionsScrollPane = new javax.swing.JScrollPane();
        winchPositionsScrollPane = new javax.swing.JScrollPane();
        runwaysScrollPane = new javax.swing.JScrollPane();

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel airfieldSubPanel = new JPanel();
        panel.add(airfieldSubPanel);
        airfieldSubPanel.setLayout(new BorderLayout(0, 0));
        airfieldSubPanel.add(airfieldScrollPane, BorderLayout.NORTH);
        DefaultListModel airfieldModel = new DefaultListModel();
        for(Object str: airfields){
                airfieldModel.addElement(str);
        }
        airfieldJList.setModel(airfieldModel);
        
        airfieldJList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                airfieldJListMouseClicked(evt);
            }
        });
        
        airfieldScrollPane.setViewportView(airfieldJList);
        
        JPanel airfieldAttributesPanel = new JPanel();
        airfieldSubPanel.add(airfieldAttributesPanel, BorderLayout.CENTER);
        airfieldAttributesPanel.setLayout(null);
        
        JLabel designatorLabel = new JLabel("Designator:");
        designatorLabel.setBounds(10, 36, 84, 14);
        airfieldAttributesPanel.add(designatorLabel);
        
        JLabel airfieldAltitudeLabel = new JLabel("Altitude:");
        airfieldAltitudeLabel.setBounds(10, 62, 84, 14);
        airfieldAttributesPanel.add(airfieldAltitudeLabel);
        
        JLabel magneticVariationLabel = new JLabel("Magnetic Variation:");
        magneticVariationLabel.setBounds(10, 87, 120, 14);
        airfieldAttributesPanel.add(magneticVariationLabel);
        
        JLabel airfieldLongitudeLabel = new JLabel("Longitude:");
        airfieldLongitudeLabel.setBounds(10, 112, 84, 14);
        airfieldAttributesPanel.add(airfieldLongitudeLabel);
        
        JLabel airfieldLatitudeLabel = new JLabel("Latitude:");
        airfieldLatitudeLabel.setBounds(10, 137, 84, 14);
        airfieldAttributesPanel.add(airfieldLatitudeLabel);
        
        airfieldAltitudeField = new JTextField();
        airfieldAltitudeField.setBounds(140, 58, 120, 20);
        airfieldAttributesPanel.add(airfieldAltitudeField);
        airfieldAltitudeField.setColumns(10);
        
        designatorField = new JTextField();
        designatorField.setBounds(140, 33, 120, 20);
        airfieldAttributesPanel.add(designatorField);
        designatorField.setColumns(10);
        
        airfieldNameField = new JTextField();
        airfieldNameField.setBounds(140, 8, 120, 20);
        airfieldAttributesPanel.add(airfieldNameField);
        airfieldNameField.setColumns(10);
        
        magneticVariationField = new JTextField();
        magneticVariationField.setBounds(140, 83, 120, 20);
        airfieldAttributesPanel.add(magneticVariationField);
        magneticVariationField.setColumns(10);
        
        JLabel airfieldNameLabel = new JLabel("Name:");
        airfieldNameLabel.setBounds(10, 11, 46, 14);
        airfieldAttributesPanel.add(airfieldNameLabel);
        
        airfieldLongitudeField = new JTextField();
        airfieldLongitudeField.setBounds(140, 109, 120, 20);
        airfieldAttributesPanel.add(airfieldLongitudeField);
        airfieldLongitudeField.setColumns(10);
        
        airfieldLatitudeField = new JTextField();
        airfieldLatitudeField.setBounds(140, 134, 120, 20);
        airfieldAttributesPanel.add(airfieldLatitudeField);
        airfieldLatitudeField.setColumns(10);

        JPanel gliderPostitionSubPanel = new JPanel();
        panel.add(gliderPostitionSubPanel);
        gliderPostitionSubPanel.setLayout(new BorderLayout(0, 0));
        gliderPostitionSubPanel.add(gliderPositionsScrollPane, BorderLayout.NORTH);

        gliderPositionsJList.setModel(gliderPositionModel);
        gliderPositionsScrollPane.setViewportView(gliderPositionsJList);
        
        JPanel gliderPositionAttributesPanel = new JPanel();
        gliderPostitionSubPanel.add(gliderPositionAttributesPanel, BorderLayout.CENTER);
        gliderPositionAttributesPanel.setLayout(null);
        
        JLabel gliderPosNameLabel = new JLabel("Name:");
        gliderPosNameLabel.setBounds(10, 11, 46, 14);
        gliderPositionAttributesPanel.add(gliderPosNameLabel);
        
        JLabel gliderPosAltitudeLabel = new JLabel("Altitude:");
        gliderPosAltitudeLabel.setBounds(10, 36, 46, 14);
        gliderPositionAttributesPanel.add(gliderPosAltitudeLabel);
        
        JLabel gliderPosLongitudeLabel = new JLabel("Longitude:");
        gliderPosLongitudeLabel.setBounds(10, 61, 80, 14);
        gliderPositionAttributesPanel.add(gliderPosLongitudeLabel);
        
        JLabel gliderPosLatitudeLabel = new JLabel("Latitude:");
        gliderPosLatitudeLabel.setBounds(10, 86, 80, 14);
        gliderPositionAttributesPanel.add(gliderPosLatitudeLabel);
        
        JLabel gliderPosParentAirfieldLabel = new JLabel("Parent Airfield:");
        gliderPosParentAirfieldLabel.setBounds(10, 111, 103, 14);
        gliderPositionAttributesPanel.add(gliderPosParentAirfieldLabel);
        
        JLabel gliderPosParentRunwayLabel = new JLabel("Parent Runway:");
        gliderPosParentRunwayLabel.setBounds(10, 136, 103, 14);
        gliderPositionAttributesPanel.add(gliderPosParentRunwayLabel);
        
        gliderPosParentRunwayField = new JTextField();
        gliderPosParentRunwayField.setBounds(135, 133, 120, 20);
        gliderPositionAttributesPanel.add(gliderPosParentRunwayField);
        gliderPosParentRunwayField.setColumns(10);
        
        gliderPosParentAirfieldField = new JTextField();
        gliderPosParentAirfieldField.setBounds(135, 108, 120, 20);
        gliderPositionAttributesPanel.add(gliderPosParentAirfieldField);
        gliderPosParentAirfieldField.setColumns(10);
        
        gliderPosLatitudeField = new JTextField();
        gliderPosLatitudeField.setBounds(135, 83, 120, 20);
        gliderPositionAttributesPanel.add(gliderPosLatitudeField);
        gliderPosLatitudeField.setColumns(10);
        
        gliderPosLongitudeField = new JTextField();
        gliderPosLongitudeField.setBounds(135, 58, 120, 20);
        gliderPositionAttributesPanel.add(gliderPosLongitudeField);
        gliderPosLongitudeField.setColumns(10);
        
        gliderPosAltitudeField = new JTextField();
        gliderPosAltitudeField.setBounds(135, 33, 120, 20);
        gliderPositionAttributesPanel.add(gliderPosAltitudeField);
        gliderPosAltitudeField.setColumns(10);
        
        gliderPosNameField = new JTextField();
        gliderPosNameField.setBounds(135, 8, 120, 20);
        gliderPositionAttributesPanel.add(gliderPosNameField);
        gliderPosNameField.setColumns(10);
        
        gliderPositionsJList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               gliderPositionsJListMouseClicked(evt);
            }
        });
        
        JPanel panel_1 = new JPanel();
        add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));

        JPanel runwaySubPanel = new JPanel();
        panel_1.add(runwaySubPanel);
        runwaySubPanel.setLayout(new BorderLayout(0, 0));
        runwaySubPanel.add(runwaysScrollPane, BorderLayout.NORTH);
        
        DefaultListModel runwayModel = new DefaultListModel();
        runwaysJList.setModel(runwayModel);
        runwaysScrollPane.setViewportView(runwaysJList);
        
        JPanel runwayAttributesPanel = new JPanel();
        runwaySubPanel.add(runwayAttributesPanel, BorderLayout.CENTER);
        runwayAttributesPanel.setLayout(null);
        
        JLabel runwayNameLabel = new JLabel("Name:");
        runwayNameLabel.setBounds(10, 11, 106, 14);
        runwayAttributesPanel.add(runwayNameLabel);
        
        JLabel magneticHeadingLabel = new JLabel("Magnetic Heading:");
        magneticHeadingLabel.setBounds(10, 36, 106, 14);
        runwayAttributesPanel.add(magneticHeadingLabel);
        
        JLabel runwayAltitudeLabel = new JLabel("Altitude:");
        runwayAltitudeLabel.setBounds(10, 61, 106, 14);
        runwayAttributesPanel.add(runwayAltitudeLabel);
        
        JLabel runwayParentAirfieldLabel = new JLabel("Parent Airfield:");
        runwayParentAirfieldLabel.setBounds(10, 111, 106, 14);
        runwayAttributesPanel.add(runwayParentAirfieldLabel);
        
        magneticHeadingField = new JTextField();
        magneticHeadingField.setBounds(140, 33, 120, 20);
        runwayAttributesPanel.add(magneticHeadingField);
        magneticHeadingField.setColumns(10);
        
        runwayNameField = new JTextField();
        runwayNameField.setBounds(140, 8, 120, 20);
        runwayAttributesPanel.add(runwayNameField);
        runwayNameField.setColumns(10);
        
        runwayAltitudeField = new JTextField();
        runwayAltitudeField.setBounds(140, 58, 120, 20);
        runwayAttributesPanel.add(runwayAltitudeField);
        runwayAltitudeField.setColumns(10);
        
        runwayParentAirfieldField = new JTextField();
        runwayParentAirfieldField.setBounds(140, 108, 120, 20);
        runwayAttributesPanel.add(runwayParentAirfieldField);
        runwayParentAirfieldField.setColumns(10);
        
        JLabel runwaySlopeLabel = new JLabel("Slope:");
        runwaySlopeLabel.setBounds(10, 86, 81, 14);
        runwayAttributesPanel.add(runwaySlopeLabel);
        
        runwaySlopeField = new JTextField();
        runwaySlopeField.setBounds(140, 83, 120, 20);
        runwayAttributesPanel.add(runwaySlopeField);
        runwaySlopeField.setColumns(10);
        
        runwaysJList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               runwayJListMouseClicked(evt);
            }
        });
        
        JPanel winchPostitionSubPanel = new JPanel();
        panel_1.add(winchPostitionSubPanel);
        winchPostitionSubPanel.setLayout(new BorderLayout(0, 0));
        winchPostitionSubPanel.add(winchPositionsScrollPane, BorderLayout.NORTH);
        
        winchPositionsJList.setModel(winchPositionModel);
        winchPositionsScrollPane.setViewportView(winchPositionsJList);
        
        JPanel winchPositionAttributesPanel = new JPanel();
        winchPostitionSubPanel.add(winchPositionAttributesPanel, BorderLayout.CENTER);
        winchPositionAttributesPanel.setLayout(null);
        
        JLabel winchPosNameLabel = new JLabel("Name:");
        winchPosNameLabel.setBounds(10, 11, 46, 14);
        winchPositionAttributesPanel.add(winchPosNameLabel);
        
        winchPosNameField = new JTextField();
        winchPosNameField.setColumns(10);
        winchPosNameField.setBounds(135, 8, 120, 20);
        winchPositionAttributesPanel.add(winchPosNameField);
        
        JLabel winchPosAltitudeLabel = new JLabel("Altitude:");
        winchPosAltitudeLabel.setBounds(10, 36, 46, 14);
        winchPositionAttributesPanel.add(winchPosAltitudeLabel);
        
        winchPosAltitudeField = new JTextField();
        winchPosAltitudeField.setColumns(10);
        winchPosAltitudeField.setBounds(135, 33, 120, 20);
        winchPositionAttributesPanel.add(winchPosAltitudeField);
        
        JLabel winchPosLongitudeLabel = new JLabel("Longitude:");
        winchPosLongitudeLabel.setBounds(10, 61, 80, 14);
        winchPositionAttributesPanel.add(winchPosLongitudeLabel);
        
        winchPosLongitudeField = new JTextField();
        winchPosLongitudeField.setColumns(10);
        winchPosLongitudeField.setBounds(135, 58, 120, 20);
        winchPositionAttributesPanel.add(winchPosLongitudeField);
        
        JLabel winchPosLatitudeLabel = new JLabel("Latitude:");
        winchPosLatitudeLabel.setBounds(10, 86, 80, 14);
        winchPositionAttributesPanel.add(winchPosLatitudeLabel);
        
        winchPosLatitudeField = new JTextField();
        winchPosLatitudeField.setColumns(10);
        winchPosLatitudeField.setBounds(135, 83, 120, 20);
        winchPositionAttributesPanel.add(winchPosLatitudeField);
        
        JLabel winchPosParentAirfieldLabel = new JLabel("Parent Airfield:");
        winchPosParentAirfieldLabel.setBounds(10, 111, 103, 14);
        winchPositionAttributesPanel.add(winchPosParentAirfieldLabel);
        
        winchPosParentAirfieldField = new JTextField();
        winchPosParentAirfieldField.setColumns(10);
        winchPosParentAirfieldField.setBounds(135, 108, 120, 20);
        winchPositionAttributesPanel.add(winchPosParentAirfieldField);
        
        JLabel winchPosParentRunwayLabel = new JLabel("Parent Runway:");
        winchPosParentRunwayLabel.setBounds(10, 136, 103, 14);
        winchPositionAttributesPanel.add(winchPosParentRunwayLabel);
        
        winchPosParentRunwayField = new JTextField();
        winchPosParentRunwayField.setColumns(10);
        winchPosParentRunwayField.setBounds(135, 133, 120, 20);
        winchPositionAttributesPanel.add(winchPosParentRunwayField);
        
        winchPositionsJList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               winchPositionsJListMouseClicked(evt);
            }
        });

    }
}
