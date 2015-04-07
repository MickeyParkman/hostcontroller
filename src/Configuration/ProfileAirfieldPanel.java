package Configuration;

import AddEditPanels.AddEditWinchPosFrame;
import AddEditPanels.AddEditGliderPosFrame;
import AddEditPanels.AddEditAirfieldFrame;
import AddEditPanels.AddEditRunwayFrame;
import Communications.Observer;
import Configuration.UnitConversionRate;
import Configuration.UnitLabelUtilities;
import DataObjects.Airfield;
import DataObjects.GliderPosition;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Runway;
import DataObjects.WinchPosition;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;


public class ProfileAirfieldPanel extends JPanel implements Observer{

    private javax.swing.JScrollPane airfieldScrollPane;
    private List<Airfield> airfields = new ArrayList<Airfield>();
    private javax.swing.JScrollPane gliderPositionsScrollPane;
    private List<GliderPosition> gliderPositions = new ArrayList<GliderPosition>();
    private javax.swing.JScrollPane winchPositionsScrollPane;
    private List<WinchPosition> winchPositions = new ArrayList<WinchPosition>();
    private javax.swing.JScrollPane runwaysScrollPane;
    private List<Runway> runways = new ArrayList<Runway>();
    DefaultListModel airfieldModel = new DefaultListModel();
    private DefaultListModel runwaysModel = new DefaultListModel();
    private DefaultListModel gliderPositionModel = new DefaultListModel();
    private DefaultListModel winchPositionModel = new DefaultListModel();
    private javax.swing.JList airfieldJList = new javax.swing.JList();
    private javax.swing.JList runwaysJList = new javax.swing.JList();
    private javax.swing.JList winchPositionsJList = new javax.swing.JList();
    private javax.swing.JList gliderPositionsJList = new javax.swing.JList();
    private JTextField designatorField;
    private JTextField airfieldNameField;
    private JTextField runwayNameField;
    private JTextField runwayParentAirfieldField;
    private JTextField gliderPosParentRunwayField;
    private JTextField gliderPosParentAirfieldField;
    private JTextField gliderPosNameField;
    private JTextField winchPosNameField;
    private JTextField winchPosParentAirfieldField;
    private JTextField winchPosParentRunwayField;
    private CurrentDataObjectSet currentData;
    private int gliderPosAltitudeUnitsID;
    private int runwayAltitudeUnitsID;
    private int winchPosAltitudeUnitsID;
    
    @Override
    public void update(String s)
    {

    }
    
    private Observer getObserver() {
        return this;
    }

    public void clear()
    {
    }
            
    
    /**
     * Creates new form sailplanePanel
     */
    public ProfileAirfieldPanel() {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
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
        
        JPanel panel_1 = new JPanel();
        add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));

        JPanel airfieldSubPanel = new JPanel();
        panel.add(airfieldSubPanel);
        airfieldSubPanel.setLayout(new BorderLayout(0, 0));
        airfieldSubPanel.add(airfieldScrollPane, BorderLayout.NORTH);
        
        JScrollPane airfieldAttributesPanelScrollPane = new JScrollPane();
        airfieldSubPanel.add(airfieldAttributesPanelScrollPane, BorderLayout.CENTER);
        JPanel airfieldAttributesPanel = new JPanel();
        airfieldAttributesPanel.setBackground(Color.WHITE);
        airfieldAttributesPanel.setPreferredSize(new Dimension(300, 200));
        airfieldAttributesPanel.setLayout(null);
        airfieldAttributesPanelScrollPane.setViewportView(airfieldAttributesPanel);
        airfieldAttributesPanelScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
        airfieldAttributesPanelScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        
        JLabel airfieldAltitudeLabel = new JLabel("Altitude:");
        airfieldAltitudeLabel.setBounds(10, 104, 84, 14);
        airfieldAttributesPanel.add(airfieldAltitudeLabel);
               
        JLabel airfieldLabel = new JLabel("Airfield");
        airfieldLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        airfieldLabel.setBounds(10, 20, 100, 22);
        airfieldAttributesPanel.add(airfieldLabel);
        
        JComboBox AirfieldAltitudeComboBox = new JComboBox();
        AirfieldAltitudeComboBox.setMaximumSize(new Dimension(32767, 20));
        AirfieldAltitudeComboBox.setBounds(66, 101, 54, 20);
        airfieldAttributesPanel.add(AirfieldAltitudeComboBox);
        AirfieldAltitudeComboBox.addItem("m");
        AirfieldAltitudeComboBox.addItem("ft");
        AirfieldAltitudeComboBox.addItem("km");
        AirfieldAltitudeComboBox.addItem("mi");
        

        JPanel gliderPostitionSubPanel = new JPanel();
        gliderPostitionSubPanel.setLayout(new BorderLayout(0, 0));
        gliderPostitionSubPanel.add(gliderPositionsScrollPane, BorderLayout.NORTH);
        
        JScrollPane gliderPosAttributesPanelScrollPane = new JScrollPane();
        JPanel gliderPositionAttributesPanel = new JPanel();
        gliderPositionAttributesPanel.setBackground(Color.WHITE);
        gliderPostitionSubPanel.add(gliderPosAttributesPanelScrollPane, BorderLayout.CENTER);
        gliderPositionAttributesPanel.setPreferredSize(new Dimension(300, 200));
        gliderPosAttributesPanelScrollPane.setViewportView(gliderPositionAttributesPanel);
        gliderPosAttributesPanelScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
        gliderPosAttributesPanelScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        gliderPositionAttributesPanel.setLayout(null);
        
        JLabel gliderPosAltitudeLabel = new JLabel("Altitude:");
        gliderPosAltitudeLabel.setBounds(10, 78, 46, 14);
        gliderPositionAttributesPanel.add(gliderPosAltitudeLabel);
                       
        JLabel gliderPositionLabel = new JLabel("Glider Position");
        gliderPositionLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        gliderPositionLabel.setBounds(10, 20, 180, 31);
        gliderPositionAttributesPanel.add(gliderPositionLabel);
        
        JComboBox GliderPosAltitudeComboBox = new JComboBox();
        GliderPosAltitudeComboBox.setMaximumSize(new Dimension(32767, 20));
        GliderPosAltitudeComboBox.setBounds(66, 75, 54, 20);
        gliderPositionAttributesPanel.add(GliderPosAltitudeComboBox);
        GliderPosAltitudeComboBox.addItem("m");
        GliderPosAltitudeComboBox.addItem("ft");
        GliderPosAltitudeComboBox.addItem("km");
        GliderPosAltitudeComboBox.addItem("mi");
               
        JPanel runwaySubPanel = new JPanel();
        panel_1.add(runwaySubPanel);
        runwaySubPanel.setLayout(new BorderLayout(0, 0));
        runwaySubPanel.add(runwaysScrollPane, BorderLayout.NORTH);
        
        panel_1.add(gliderPostitionSubPanel);

        JPanel runwayAttributesPanel = new JPanel();
        runwayAttributesPanel.setBackground(Color.WHITE);
        JScrollPane runwayAttributesPanelScrollPane = new JScrollPane();
        runwaySubPanel.add(runwayAttributesPanelScrollPane, BorderLayout.CENTER);
        runwayAttributesPanel.setLayout(null);
        runwayAttributesPanel.setPreferredSize(new Dimension(300, 200));
        runwayAttributesPanelScrollPane.setViewportView(runwayAttributesPanel);
        runwayAttributesPanelScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
        runwayAttributesPanelScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        
        JLabel runwayAltitudeLabel = new JLabel("Altitude:");
        runwayAltitudeLabel.setBounds(10, 103, 66, 14);
        runwayAttributesPanel.add(runwayAltitudeLabel);
        
        JLabel runwayLabel = new JLabel("Runway");
        runwayLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        runwayLabel.setBounds(10, 20, 140, 31);
        runwayAttributesPanel.add(runwayLabel);
        
        JComboBox RunwayAltitudeComboBox = new JComboBox();
        RunwayAltitudeComboBox.setMaximumSize(new Dimension(32767, 20));
        RunwayAltitudeComboBox.setBounds(66, 100, 54, 20);
        runwayAttributesPanel.add(RunwayAltitudeComboBox);
        RunwayAltitudeComboBox.addItem("m");
        RunwayAltitudeComboBox.addItem("ft");
        RunwayAltitudeComboBox.addItem("km");
        RunwayAltitudeComboBox.addItem("mi");
        
        JPanel winchPostitionSubPanel = new JPanel();
        panel.add(winchPostitionSubPanel);
        winchPostitionSubPanel.setLayout(new BorderLayout(0, 0));
        winchPostitionSubPanel.add(winchPositionsScrollPane, BorderLayout.NORTH);
                
        JPanel winchPositionAttributesPanel = new JPanel();
        winchPositionAttributesPanel.setBackground(Color.WHITE);
        JScrollPane winchPositionAttributesPanelScrollPane = new JScrollPane();
        winchPostitionSubPanel.add(winchPositionAttributesPanelScrollPane, BorderLayout.CENTER);
        winchPositionAttributesPanel.setLayout(null);
        winchPositionAttributesPanel.setPreferredSize(new Dimension(300, 200));
        winchPositionAttributesPanelScrollPane.setViewportView(winchPositionAttributesPanel);
        winchPositionAttributesPanelScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
        winchPositionAttributesPanelScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
                
        JLabel winchPosAltitudeLabel = new JLabel("Altitude:");
        winchPosAltitudeLabel.setBounds(10, 78, 46, 14);
        winchPositionAttributesPanel.add(winchPosAltitudeLabel);
                
        JLabel winchPositionLabel = new JLabel("Winch Position");
        winchPositionLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        winchPositionLabel.setBounds(10, 20, 180, 31);
        winchPositionAttributesPanel.add(winchPositionLabel);
        
        JComboBox WinchPosAltitudeComboBox = new JComboBox();
        WinchPosAltitudeComboBox.setMaximumSize(new Dimension(32767, 20));
        WinchPosAltitudeComboBox.setBounds(66, 75, 54, 20);
        winchPositionAttributesPanel.add(WinchPosAltitudeComboBox);
        WinchPosAltitudeComboBox.addItem("m");
        WinchPosAltitudeComboBox.addItem("ft");
        WinchPosAltitudeComboBox.addItem("km");
        WinchPosAltitudeComboBox.addItem("mi");
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
