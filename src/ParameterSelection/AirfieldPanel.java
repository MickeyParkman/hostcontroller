package ParameterSelection;

import DataObjects.Airfield;
import DataObjects.GliderPosition;
import DataObjects.CurrentDataObjectSet;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


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
    private CurrentDataObjectSet currentData;

    private void initAirfieldList() {
        try{
            airfields = DatabaseUtilities.DatabaseDataObjectUtilities.getAirfields();
            airfields.add(0, new Airfield("Spokane", "GEG", 1000, 5, 5, 5, "sdfgsdgf"));   
        }catch(SQLException e) {
            airfields.add(new Airfield("Spokane", "GEG", 1000, 5, 5, 5, "sdfgsdgf"));
            airfields.add(new Airfield("Bob-land", "BOB", 1000, 5, 5, 5, "sdfgsdgf"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirfieldPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initGliderPositionsList() {
        try{
            gliderPositions = DatabaseUtilities.DatabaseDataObjectUtilities.getGliderPositions();
            gliderPositions.add(new GliderPosition("The glider position", "The Runway", 5, 5, 5, "sdfgsdgf"));
        }catch(SQLException e) {
            gliderPositions.add(new GliderPosition("Spokane Runway1 glider", "Spokane Runway1", 5, 5, 5, "sdfgsdgf"));
            gliderPositions.add(new GliderPosition("Spokane Runway2 glider", "Spokane Runway2", 5, 5, 5, "sdfgsdgf"));
            gliderPositions.add(new GliderPosition("Bob-land Runway1 glider", "Bob-land Runway1", 5, 5, 5, "sdfgsdgf"));
            gliderPositions.add(new GliderPosition("Bob-land Runway2 glider", "Bob-land Runway2", 5, 5, 5, "sdfgsdgf"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirfieldPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initWinchPositionsList() {
        try{
            winchPositions = DatabaseUtilities.DatabaseDataObjectUtilities.getWinchPositions();
            winchPositions.add(new WinchPosition("The winch position", "The Runway", 5, 5, 5, "sdfgsdgf"));
        }catch(SQLException e) {
            winchPositions.add(new WinchPosition("Spokane Runway1 winch", "Spokane Runway1", 5, 5, 5, "sdfgsdgf"));
            winchPositions.add(new WinchPosition("Spokane Runway2 winch", "Spokane Runway2", 5, 5, 5, "sdfgsdgf"));
            winchPositions.add(new WinchPosition("Bob-land Runway1 winch", "Bob-land Runway1", 5, 5, 5, "sdfgsdgf"));
            winchPositions.add(new WinchPosition("Bob-land Runway2 winch", "Bob-land Runway2", 5, 5, 5, "sdfgsdgf"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirfieldPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initRunwaysList() {
        try{
            runways = DatabaseUtilities.DatabaseDataObjectUtilities.getRunways();
            runways.add(new Runway("The Runway", "North", "Spokane", 5, "sdghsdg"));
        }catch(SQLException e) {
            runways.add(new Runway("Spokane Runway1", "North", "GEG", 5, "sdghsdg"));
            runways.add(new Runway("Spokane Runway2", "North", "GEG", 5, "sdghsdg"));
            runways.add(new Runway("Bob-land Runway1", "South", "BOB", 6, "asdfasdf"));
            runways.add(new Runway("Bob-land Runway2", "South", "BOB", 6, "asdfasdf"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirfieldPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    private void airfieldJListMouseClicked(java.awt.event.MouseEvent evt) 
    {
        if(airfieldJList.getSelectedIndex() >= 0){
            try{
                Airfield theAirfield = (Airfield)airfieldJList.getSelectedValue();
                currentData.setCurrentAirfield(theAirfield);
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
                
                runwayNameField.setText("");
                runwayNameField.setBackground(new Color(255, 255, 255));
                runwayAltitudeField.setText("");
                runwayAltitudeField.setBackground(new Color(255, 255, 255));
                magneticHeadingField.setText("");
                magneticHeadingField.setBackground(new Color(255, 255, 255));
                gliderPosNameField.setText("");
                gliderPosNameField.setBackground(new Color(255, 255, 255));
                gliderPosAltitudeField.setText("");
                gliderPosAltitudeField.setBackground(new Color(255, 255, 255));
                gliderPosLongitudeField.setText("");
                gliderPosLongitudeField.setBackground(new Color(255, 255, 255));
                gliderPosLatitudeField.setText("");
                gliderPosLatitudeField.setBackground(new Color(255, 255, 255));
                winchPosNameField.setText("");
                winchPosNameField.setBackground(new Color(255, 255, 255));
                winchPosAltitudeField.setText("");
                winchPosAltitudeField.setBackground(new Color(255, 255, 255));
                winchPosLongitudeField.setText("");
                winchPosLongitudeField.setBackground(new Color(255, 255, 255));
                winchPosLatitudeField.setText("");
                winchPosLatitudeField.setBackground(new Color(255, 255, 255));
                
                runwaysModel.removeAllElements();
                winchPositionModel.removeAllElements();
                gliderPositionModel.removeAllElements();
                for(Runway str: runways){
                    if(str.getParent().equals(theAirfield.getDesignator()))
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
                currentData.setCurrentRunway(theRunway);
                
                runwayNameField.setText(theRunway.getId());
                runwayNameField.setBackground(new Color(142, 250, 127));
                
                runwayAltitudeField.setText(String.valueOf(theRunway.getAltitude()));
                runwayAltitudeField.setBackground(new Color(142, 250, 127));
                
                magneticHeadingField.setText(String.valueOf(theRunway.getMagneticHeading()));
                magneticHeadingField.setBackground(new Color(142, 250, 127));
                
                gliderPosNameField.setText("");
                gliderPosNameField.setBackground(new Color(255, 255, 255));
                gliderPosAltitudeField.setText("");
                gliderPosAltitudeField.setBackground(new Color(255, 255, 255));
                gliderPosLongitudeField.setText("");
                gliderPosLongitudeField.setBackground(new Color(255, 255, 255));
                gliderPosLatitudeField.setText("");
                gliderPosLatitudeField.setBackground(new Color(255, 255, 255));
                winchPosNameField.setText("");
                winchPosNameField.setBackground(new Color(255, 255, 255));
                winchPosAltitudeField.setText("");
                winchPosAltitudeField.setBackground(new Color(255, 255, 255));
                winchPosLongitudeField.setText("");
                winchPosLongitudeField.setBackground(new Color(255, 255, 255));
                winchPosLatitudeField.setText("");
                winchPosLatitudeField.setBackground(new Color(255, 255, 255));
                
                gliderPositionModel.removeAllElements();
                for(GliderPosition str: gliderPositions){
                    if(str.getParent().equals(theRunway.getId()))
                        gliderPositionModel.addElement(str);
                }
                
                winchPositionModel.removeAllElements();
                for(WinchPosition str: winchPositions){
                    if(str.getParent().equals(theRunway.getId()))
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
                currentData.setCurrentGliderPosition(theGliderPosition);
                
                gliderPosNameField.setText(theGliderPosition.getGliderPositionId());
                gliderPosNameField.setBackground(new Color(142, 250, 127));
                
                gliderPosAltitudeField.setText(String.valueOf(theGliderPosition.getAltitude()));
                gliderPosAltitudeField.setBackground(new Color(142, 250, 127));
 
                gliderPosLongitudeField.setText(String.valueOf(theGliderPosition.getLongitude()));
                gliderPosLongitudeField.setBackground(new Color(142, 250, 127));
                
                gliderPosLatitudeField.setText(String.valueOf(theGliderPosition.getLatitude()));
                gliderPosLatitudeField.setBackground(new Color(142, 250, 127));
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
                currentData.setCurrentWinchPosition(theWinchPosition);
                
                winchPosNameField.setText(theWinchPosition.getName());
                winchPosNameField.setBackground(new Color(142, 250, 127));
                
                winchPosAltitudeField.setText(String.valueOf(theWinchPosition.getAltitude()));
                winchPosAltitudeField.setBackground(new Color(142, 250, 127));
 
                winchPosLongitudeField.setText(String.valueOf(theWinchPosition.getLongitude()));
                winchPosLongitudeField.setBackground(new Color(142, 250, 127));
                
                winchPosLatitudeField.setText(String.valueOf(theWinchPosition.getLatitude()));
                winchPosLatitudeField.setBackground(new Color(142, 250, 127));
                
            } catch(Exception e) {
                //TODO respond to error
            }
        }
    }
    
    /**
     * Creates new form sailplanePanel
     */
    public AirfieldPanel() {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
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
        designatorLabel.setBounds(10, 78, 84, 14);
        airfieldAttributesPanel.add(designatorLabel);
        
        JLabel airfieldAltitudeLabel = new JLabel("Altitude:");
        airfieldAltitudeLabel.setBounds(10, 104, 84, 14);
        airfieldAttributesPanel.add(airfieldAltitudeLabel);
        
        JLabel magneticVariationLabel = new JLabel("Magnetic Variation:");
        magneticVariationLabel.setBounds(10, 129, 200, 14);
        airfieldAttributesPanel.add(magneticVariationLabel);
        
        JLabel airfieldLongitudeLabel = new JLabel("Longitude:");
        airfieldLongitudeLabel.setBounds(10, 154, 84, 14);
        airfieldAttributesPanel.add(airfieldLongitudeLabel);
        
        JLabel airfieldLatitudeLabel = new JLabel("Latitude:");
        airfieldLatitudeLabel.setBounds(10, 179, 84, 14);
        airfieldAttributesPanel.add(airfieldLatitudeLabel);
        
        airfieldAltitudeField = new JTextField();
        airfieldAltitudeField.setBounds(140, 100, 200, 20);
        airfieldAttributesPanel.add(airfieldAltitudeField);
        airfieldAltitudeField.setColumns(10);
        
        designatorField = new JTextField();
        designatorField.setBounds(140, 75, 200, 20);
        airfieldAttributesPanel.add(designatorField);
        designatorField.setColumns(10);
        
        airfieldNameField = new JTextField();
        airfieldNameField.setBounds(140, 50, 200, 20);
        airfieldAttributesPanel.add(airfieldNameField);
        airfieldNameField.setColumns(10);
        
        magneticVariationField = new JTextField();
        magneticVariationField.setBounds(140, 125, 200, 20);
        airfieldAttributesPanel.add(magneticVariationField);
        magneticVariationField.setColumns(10);
        
        JLabel airfieldNameLabel = new JLabel("Name:");
        airfieldNameLabel.setBounds(10, 53, 46, 14);
        airfieldAttributesPanel.add(airfieldNameLabel);
        
        airfieldLongitudeField = new JTextField();
        airfieldLongitudeField.setBounds(140, 151, 200, 20);
        airfieldAttributesPanel.add(airfieldLongitudeField);
        airfieldLongitudeField.setColumns(10);
        
        airfieldLatitudeField = new JTextField();
        airfieldLatitudeField.setBounds(140, 176, 200, 20);
        airfieldAttributesPanel.add(airfieldLatitudeField);
        airfieldLatitudeField.setColumns(10);
        
        JButton airfieldAddNewButton = new JButton("Add New");
        airfieldAddNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        airfieldAddNewButton.setBounds(200, 0, 89, 23);
        airfieldAttributesPanel.add(airfieldAddNewButton);
        
        JButton airfieldEditButton = new JButton("Edit");
        airfieldEditButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        airfieldEditButton.setBounds(288, 0, 89, 23);
        airfieldAttributesPanel.add(airfieldEditButton);
        
        JLabel airfieldLabel = new JLabel("Airfield");
        airfieldLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        airfieldLabel.setBounds(10, 20, 100, 22);
        airfieldAttributesPanel.add(airfieldLabel);

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
        gliderPosNameLabel.setBounds(10, 53, 46, 14);
        gliderPositionAttributesPanel.add(gliderPosNameLabel);
        
        JLabel gliderPosAltitudeLabel = new JLabel("Altitude:");
        gliderPosAltitudeLabel.setBounds(10, 78, 46, 14);
        gliderPositionAttributesPanel.add(gliderPosAltitudeLabel);
        
        JLabel gliderPosLongitudeLabel = new JLabel("Longitude:");
        gliderPosLongitudeLabel.setBounds(10, 103, 80, 14);
        gliderPositionAttributesPanel.add(gliderPosLongitudeLabel);
        
        JLabel gliderPosLatitudeLabel = new JLabel("Latitude:");
        gliderPosLatitudeLabel.setBounds(10, 128, 80, 14);
        gliderPositionAttributesPanel.add(gliderPosLatitudeLabel);
        
        /*JLabel gliderPosParentAirfieldLabel = new JLabel("Parent Airfield:");
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
        gliderPosParentAirfieldField.setColumns(10);*/
        
        gliderPosLatitudeField = new JTextField();
        gliderPosLatitudeField.setBounds(135, 125, 200, 20);
        gliderPositionAttributesPanel.add(gliderPosLatitudeField);
        gliderPosLatitudeField.setColumns(10);
        
        gliderPosLongitudeField = new JTextField();
        gliderPosLongitudeField.setBounds(135, 100, 200, 20);
        gliderPositionAttributesPanel.add(gliderPosLongitudeField);
        gliderPosLongitudeField.setColumns(10);
        
        gliderPosAltitudeField = new JTextField();
        gliderPosAltitudeField.setBounds(135, 75, 200, 20);
        gliderPositionAttributesPanel.add(gliderPosAltitudeField);
        gliderPosAltitudeField.setColumns(10);
        
        gliderPosNameField = new JTextField();
        gliderPosNameField.setBounds(135, 50, 200, 20);
        gliderPositionAttributesPanel.add(gliderPosNameField);
        gliderPosNameField.setColumns(10);
        
        JButton gliderPosAddNewButton = new JButton("Add New");
        gliderPosAddNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        gliderPosAddNewButton.setBounds(200, 0, 89, 23);
        gliderPositionAttributesPanel.add(gliderPosAddNewButton);
        
        JButton gliderPosEditButton = new JButton("Edit");
        gliderPosEditButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        gliderPosEditButton.setBounds(288, 0, 89, 23);
        gliderPositionAttributesPanel.add(gliderPosEditButton);
        
        JLabel gliderPositionLabel = new JLabel("Glider Position");
        gliderPositionLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        gliderPositionLabel.setBounds(10, 20, 180, 31);
        gliderPositionAttributesPanel.add(gliderPositionLabel);
        
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
        runwayNameLabel.setBounds(10, 53, 106, 14);
        runwayAttributesPanel.add(runwayNameLabel);
        
        JLabel magneticHeadingLabel = new JLabel("Magnetic Heading:");
        magneticHeadingLabel.setBounds(10, 78, 106, 14);
        runwayAttributesPanel.add(magneticHeadingLabel);
        
        JLabel runwayAltitudeLabel = new JLabel("Altitude:");
        runwayAltitudeLabel.setBounds(10, 103, 106, 14);
        runwayAttributesPanel.add(runwayAltitudeLabel);
        
        /*JLabel runwayParentAirfieldLabel = new JLabel("Parent Airfield:");
        runwayParentAirfieldLabel.setBounds(10, 111, 106, 14);
        runwayAttributesPanel.add(runwayParentAirfieldLabel);*/
        
        magneticHeadingField = new JTextField();
        magneticHeadingField.setBounds(140, 75, 200, 20);
        runwayAttributesPanel.add(magneticHeadingField);
        magneticHeadingField.setColumns(10);
        
        runwayNameField = new JTextField();
        runwayNameField.setBounds(140, 50, 200, 20);
        runwayAttributesPanel.add(runwayNameField);
        runwayNameField.setColumns(10);
        
        runwayAltitudeField = new JTextField();
        runwayAltitudeField.setBounds(140, 100, 200, 20);
        runwayAttributesPanel.add(runwayAltitudeField);
        runwayAltitudeField.setColumns(10);
        
        /*runwayParentAirfieldField = new JTextField();
        runwayParentAirfieldField.setBounds(140, 108, 120, 20);
        runwayAttributesPanel.add(runwayParentAirfieldField);
        runwayParentAirfieldField.setColumns(10);*/
        
        JLabel runwaySlopeLabel = new JLabel("Slope:");
        runwaySlopeLabel.setBounds(10, 128, 81, 14);
        runwayAttributesPanel.add(runwaySlopeLabel);
        
        runwaySlopeField = new JTextField();
        runwaySlopeField.setBounds(140, 125, 200, 20);
        runwayAttributesPanel.add(runwaySlopeField);
        runwaySlopeField.setColumns(10);
        
        JButton runwayEditButton = new JButton("Edit");
        runwayEditButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        runwayEditButton.setBounds(288, 0, 89, 23);
        runwayAttributesPanel.add(runwayEditButton);
        
        JButton runwayAddNewButton = new JButton("Add New");
        runwayAddNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        runwayAddNewButton.setBounds(200, 0, 89, 23);
        runwayAttributesPanel.add(runwayAddNewButton);
        
        JLabel runwayLabel = new JLabel("Runway");
        runwayLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        runwayLabel.setBounds(10, 20, 140, 31);
        runwayAttributesPanel.add(runwayLabel);
        
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
        winchPosNameLabel.setBounds(10, 53, 46, 14);
        winchPositionAttributesPanel.add(winchPosNameLabel);
        
        winchPosNameField = new JTextField();
        winchPosNameField.setColumns(10);
        winchPosNameField.setBounds(135, 50, 200, 20);
        winchPositionAttributesPanel.add(winchPosNameField);
        
        JLabel winchPosAltitudeLabel = new JLabel("Altitude:");
        winchPosAltitudeLabel.setBounds(10, 78, 46, 14);
        winchPositionAttributesPanel.add(winchPosAltitudeLabel);
        
        winchPosAltitudeField = new JTextField();
        winchPosAltitudeField.setColumns(10);
        winchPosAltitudeField.setBounds(135, 75, 200, 20);
        winchPositionAttributesPanel.add(winchPosAltitudeField);
        
        JLabel winchPosLongitudeLabel = new JLabel("Longitude:");
        winchPosLongitudeLabel.setBounds(10, 103, 80, 14);
        winchPositionAttributesPanel.add(winchPosLongitudeLabel);
        
        winchPosLongitudeField = new JTextField();
        winchPosLongitudeField.setColumns(10);
        winchPosLongitudeField.setBounds(135, 100, 200, 20);
        winchPositionAttributesPanel.add(winchPosLongitudeField);
        
        JLabel winchPosLatitudeLabel = new JLabel("Latitude:");
        winchPosLatitudeLabel.setBounds(10, 128, 80, 14);
        winchPositionAttributesPanel.add(winchPosLatitudeLabel);
        
        winchPosLatitudeField = new JTextField();
        winchPosLatitudeField.setColumns(10);
        winchPosLatitudeField.setBounds(135, 125, 200, 20);
        winchPositionAttributesPanel.add(winchPosLatitudeField);
        
        JButton winchPosAddNewButton = new JButton("Add New");
        winchPosAddNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        winchPosAddNewButton.setBounds(200, 0, 89, 23);
        winchPositionAttributesPanel.add(winchPosAddNewButton);
        
        JButton winchPosEditButton = new JButton("Edit");
        winchPosEditButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        winchPosEditButton.setBounds(288, 0, 89, 23);
        winchPositionAttributesPanel.add(winchPosEditButton);
        
        JLabel winchPositionLabel = new JLabel("Winch Position");
        winchPositionLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        winchPositionLabel.setBounds(10, 20, 180, 31);
        winchPositionAttributesPanel.add(winchPositionLabel);
        
        /*JLabel winchPosParentAirfieldLabel = new JLabel("Parent Airfield:");
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
        winchPositionAttributesPanel.add(winchPosParentRunwayField);*/
        
        winchPositionsJList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               winchPositionsJListMouseClicked(evt);
            }
        });

    }
}
