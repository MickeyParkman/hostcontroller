package ParameterSelection;

import DataObjects.Airfield;
import DataObjects.GliderPosition;
import DataObjects.Runway;
import DataObjects.WinchPosition;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;


public class AirfieldPanel extends JPanel {

    private javax.swing.JScrollPane airfieldScrollPane;
    private javax.swing.JList airfieldJList;
    private List<Airfield> airfields = new ArrayList<Airfield>();
    private javax.swing.JScrollPane gliderPositionsScrollPane;
    private javax.swing.JList gliderPositionsJList;
    private List<GliderPosition> gliderPositions = new ArrayList<GliderPosition>();
    private javax.swing.JScrollPane winchPositionsScrollPane;
    private javax.swing.JList winchPositionsJList;
    private List<WinchPosition> winchPositions = new ArrayList<WinchPosition>();
    private javax.swing.JScrollPane runwaysScrollPane;
    private javax.swing.JList runwaysJList;
    private List<Runway> runways = new ArrayList<Runway>();

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
            runways.add(new Runway("The Runway", "North", "The Place", 5, "sdghsdg"));
        }catch(SQLException e) {
            runways.add(new Runway("The Runway", "North", "The Place", 5, "sdghsdg"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirfieldPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    private void airfieldJListMouseClicked(java.awt.event.MouseEvent evt) 
    {
        if(airfieldJList.getSelectedIndex() >= 0){
            try{
                Airfield theAirfield = (Airfield)airfieldJList.getSelectedValue();

                DefaultListModel gliderPositionModel = new DefaultListModel();
                for(Object str: gliderPositions){
                        gliderPositionModel.addElement(str);
                }
                gliderPositionsJList.setModel(gliderPositionModel);

                gliderPositionsJList.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                       gliderPositionsJListMouseClicked(evt);
                    }
                });

                gliderPositionsScrollPane.setViewportView(gliderPositionsJList);
                
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

                DefaultListModel gliderPositionModel = new DefaultListModel();
                for(Object str: gliderPositions){
                        gliderPositionModel.addElement(str);
                }
                gliderPositionsJList.setModel(gliderPositionModel);

                gliderPositionsJList.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                       gliderPositionsJListMouseClicked(evt);
                    }
                });

                gliderPositionsScrollPane.setViewportView(gliderPositionsJList);
                
                DefaultListModel winchPositionModel = new DefaultListModel();
                for(Object str: winchPositions){
                        winchPositionModel.addElement(str);
                }
                winchPositionsJList.setModel(winchPositionModel);

                winchPositionsJList.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                       winchPositionsJListMouseClicked(evt);
                    }
                });

                winchPositionsScrollPane.setViewportView(winchPositionsJList);
        
        
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                airfieldJListMouseClicked(evt);
            }
        });
        
        airfieldScrollPane.setViewportView(airfieldJList);

        JPanel gliderPostitionSubPanel = new JPanel();
        panel.add(gliderPostitionSubPanel);
        gliderPostitionSubPanel.setLayout(new BorderLayout(0, 0));
        gliderPostitionSubPanel.add(gliderPositionsScrollPane, BorderLayout.NORTH);

        JPanel panel_1 = new JPanel();
        add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));

        JPanel runwaySubPanel = new JPanel();
        panel_1.add(runwaySubPanel);
        runwaySubPanel.setLayout(new BorderLayout(0, 0));
        runwaySubPanel.add(runwaysScrollPane, BorderLayout.NORTH);

        JPanel winchPostitionSubPanel = new JPanel();
        panel_1.add(winchPostitionSubPanel);
        winchPostitionSubPanel.setLayout(new BorderLayout(0, 0));
        winchPostitionSubPanel.add(winchPositionsScrollPane, BorderLayout.NORTH);

    }

}
