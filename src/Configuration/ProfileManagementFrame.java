package Configuration;

import DataObjects.CurrentDataObjectSet;
import DataObjects.Profile;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.util.Random;
import Communications.Observer;
import DatabaseUtilities.DatabaseDataObjectUtilities;
import DatabaseUtilities.DatabaseEntryEdit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;



public class ProfileManagementFrame extends JFrame {
    private Observer parent;
    private JPanel contentPane;
    private ProfilePilotPanel ProfilePilotPanel;
    private ProfileGliderPanel ProfileGliderPanel;
    private ProfileAirfieldPanel ProfileAirfieldPanel;
    private ProfileWinchPanel ProfileWinchPanel;
    private ProfileOtherPanel ProfileOtherPanel;
    private SaveAsNewFrame SaveAsNewFrame;
    private List<Profile> names = new ArrayList<Profile>();
    private JScrollPane profileScrollPane;
    private JList profileJList;
    private CurrentDataObjectSet currentData;
    String flightWeightUnits;
    String airfieldAltitudeUnits;
    String gliderPosAltitudeUnits;
    String runwayAltitudeUnits;
    String winchPosAltitudeUnits;
    String emptyWeightUnits;
    String maxGrossWeightUnits;
    String stallSpeedUnits;
    String weakLinkStrengthUnits;
    String maxWinchingSpeedUnits;
    String maxTensionUnits;
    String ballastWeightUnits;
    String baggageWeightUnits;
    String passengerWeightUnits;
    private int flightWeightUnitsID;
    private int airfieldAltitudeUnitsID;
    private int gliderPosAltitudeUnitsID;
    private int runwayAltitudeUnitsID;
    private int winchPosAltitudeUnitsID;
    private int emptyWeightUnitsID;
    private int maxGrossWeightUnitsID;
    private int stallSpeedUnitsID;
    private int tensionUnitsID;
    private int weakLinkStrengthUnitsID;
    private int winchingSpeedUnitsID;
    private int ballastWeightUnitsID;
    private int baggageWeightUnitsID;
    private int passengerWeightUnitsID;

    public void setParent(Observer p)
    {
        parent = p;
    }
    
    public void getUnitsForProfile()
    {
        flightWeightUnits = (String)ProfilePilotPanel.flightWeightComboBox.getSelectedItem();
        airfieldAltitudeUnits = (String)ProfileAirfieldPanel.airfieldAltitudeComboBox.getSelectedItem();
        gliderPosAltitudeUnits = (String)ProfileAirfieldPanel.gliderPosAltitudeComboBox.getSelectedItem();
        runwayAltitudeUnits = (String)ProfileAirfieldPanel.runwayAltitudeComboBox.getSelectedItem();
        winchPosAltitudeUnits = (String)ProfileAirfieldPanel.winchPosAltitudeComboBox.getSelectedItem();
        emptyWeightUnits = (String)ProfileGliderPanel.emptyWeightComboBox.getSelectedItem();
        maxGrossWeightUnits = (String)ProfileGliderPanel.maxGrossWeightComboBox.getSelectedItem();
        stallSpeedUnits = (String)ProfileGliderPanel.stallSpeedComboBox.getSelectedItem();
        weakLinkStrengthUnits = (String)ProfileGliderPanel.weakLinkStrengthComboBox.getSelectedItem();
        maxWinchingSpeedUnits = (String)ProfileGliderPanel.maxWinchingSpeedComboBox.getSelectedItem();
        maxTensionUnits = (String)ProfileGliderPanel.maxTensionComboBox.getSelectedItem();
        ballastWeightUnits = (String)ProfileGliderPanel.ballastWeightComboBox.getSelectedItem();
        baggageWeightUnits = (String)ProfileGliderPanel.baggageWeightComboBox.getSelectedItem();
        passengerWeightUnits = (String)ProfileGliderPanel.passengerWeightComboBox.getSelectedItem();         
    }
    
    public void selectButtonClicked()
    {
        if(profileJList.getSelectedIndex() >= 0){
            Profile selectedProfile = (Profile)profileJList.getSelectedValue();
            currentData.setCurrentProfile(selectedProfile);
            parent.update();
        }
        dispose();
    }

    public void saveButtonClicked()
    {
        getUnitsForProfile();
        Profile currentProfile_ = currentData.getCurrentProfile();
        currentProfile_.setUnitSetting("flightWeight", UnitConversionToIndexUtilities.weightUnitStringToIndex(flightWeightUnits));
        currentProfile_.setUnitSetting("emptyWeight", UnitConversionToIndexUtilities.weightUnitStringToIndex(emptyWeightUnits));
        currentProfile_.setUnitSetting("maxGrossWeight", UnitConversionToIndexUtilities.weightUnitStringToIndex(maxGrossWeightUnits));
        currentProfile_.setUnitSetting("ballastWeight", UnitConversionToIndexUtilities.weightUnitStringToIndex(ballastWeightUnits));
        currentProfile_.setUnitSetting("baggageWeight", UnitConversionToIndexUtilities.weightUnitStringToIndex(baggageWeightUnits));
        currentProfile_.setUnitSetting("passengerWeight", UnitConversionToIndexUtilities.weightUnitStringToIndex(passengerWeightUnits));
        currentProfile_.setUnitSetting("airfieldAltitude", UnitConversionToIndexUtilities.lenghtUnitStringToIndex(airfieldAltitudeUnits));
        currentProfile_.setUnitSetting("gliderPosAltitude", UnitConversionToIndexUtilities.lenghtUnitStringToIndex(gliderPosAltitudeUnits));
        currentProfile_.setUnitSetting("winchPosAltitude", UnitConversionToIndexUtilities.lenghtUnitStringToIndex(winchPosAltitudeUnits));
        currentProfile_.setUnitSetting("runwayAltitude", UnitConversionToIndexUtilities.lenghtUnitStringToIndex(runwayAltitudeUnits));
        currentProfile_.setUnitSetting("maxTension", UnitConversionToIndexUtilities.tensionUnitStringToIndex(maxTensionUnits));
        currentProfile_.setUnitSetting("stallSpeed", UnitConversionToIndexUtilities.tensionUnitStringToIndex(stallSpeedUnits));
        currentProfile_.setUnitSetting("winchingSpeed", UnitConversionToIndexUtilities.velocityUnitStringToIndex(maxWinchingSpeedUnits));
        currentData.setCurrentProfile(currentProfile_);
        parent.update();
        try {
            DatabaseEntryEdit.UpdateEntry(currentProfile_); 
        } catch (Exception e) {
            e.printStackTrace();
            //do nothing for now...
        }
        //System.out.println(currentData.getCurrentProfile().getUnitSettingsForStorage());
    }

    public void saveAsNewButtonClicked()
    {
        getUnitsForProfile();
        Random randomId = new Random();
        String temp = String.valueOf(randomId.nextInt(100000000));
        Profile newProfile = new Profile(temp,"{}","{}");
        newProfile.setUnitSetting("flightWeight", UnitConversionToIndexUtilities.weightUnitStringToIndex(flightWeightUnits));
        newProfile.setUnitSetting("emptyWeight", UnitConversionToIndexUtilities.weightUnitStringToIndex(emptyWeightUnits));
        newProfile.setUnitSetting("maxGrossWeight", UnitConversionToIndexUtilities.weightUnitStringToIndex(maxGrossWeightUnits));
        newProfile.setUnitSetting("ballastWeight", UnitConversionToIndexUtilities.weightUnitStringToIndex(ballastWeightUnits));
        newProfile.setUnitSetting("baggageWeight", UnitConversionToIndexUtilities.weightUnitStringToIndex(baggageWeightUnits));
        newProfile.setUnitSetting("passengerWeight", UnitConversionToIndexUtilities.weightUnitStringToIndex(passengerWeightUnits));
        newProfile.setUnitSetting("airfieldAltitude", UnitConversionToIndexUtilities.lenghtUnitStringToIndex(airfieldAltitudeUnits));
        newProfile.setUnitSetting("gliderPosAltitude", UnitConversionToIndexUtilities.lenghtUnitStringToIndex(gliderPosAltitudeUnits));
        newProfile.setUnitSetting("winchPosAltitude", UnitConversionToIndexUtilities.lenghtUnitStringToIndex(winchPosAltitudeUnits));
        newProfile.setUnitSetting("runwayAltitude", UnitConversionToIndexUtilities.lenghtUnitStringToIndex(runwayAltitudeUnits));
        newProfile.setUnitSetting("maxTension", UnitConversionToIndexUtilities.tensionUnitStringToIndex(maxTensionUnits));
        newProfile.setUnitSetting("stallSpeed", UnitConversionToIndexUtilities.tensionUnitStringToIndex(stallSpeedUnits));
        newProfile.setUnitSetting("winchingSpeed", UnitConversionToIndexUtilities.velocityUnitStringToIndex(maxWinchingSpeedUnits));
        currentData.setCurrentProfile(newProfile);
        SaveAsNewFrame = new SaveAsNewFrame();
        SaveAsNewFrame.setParent(getCurrentProfileManagementFrame());
        SaveAsNewFrame.setVisible(true);
        parent.update();
    }

    private void initProfileList() 
    {
        try
        {
            names = DatabaseUtilities.DatabaseDataObjectUtilities.getProfiles();
        }
        catch(SQLException e) 
        {   
        } 
        catch (ClassNotFoundException ex) 
        {     
        }
    }

    /**
    * Creates new ProfileManagementFrame
    */
    public ProfileManagementFrame()
    {
       currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
       initProfileList();
       initComponents();
    }

    private ProfileManagementFrame getCurrentProfileManagementFrame()
    {
        return this;
    }

    private void profileJListMouseClicked(java.awt.event.MouseEvent evt) {
        if(profileJList.getSelectedIndex() >= 0){
            try{
                Profile selectedProfile = (Profile)profileJList.getSelectedValue();
                currentData.setCurrentProfile(selectedProfile);
                //System.out.println(currentData.getCurrentProfile().getUnitSettingsForStorage());
                
                flightWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("flightWeight");
                //System.out.println(">>" + currentData.getCurrentProfile().getUnitSetting("flightWeight"));
                String flightWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(flightWeightUnitsID);
                ProfilePilotPanel.flightWeightComboBox.setSelectedItem(flightWeightUnitsString);

                airfieldAltitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("airfieldAltitude");
                String airfieldAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(airfieldAltitudeUnitsID);
                ProfileAirfieldPanel.airfieldAltitudeComboBox.setSelectedItem(airfieldAltitudeUnitsString);

                gliderPosAltitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("gliderPosAltitude");
                String gliderPosAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(gliderPosAltitudeUnitsID);
                ProfileAirfieldPanel.gliderPosAltitudeComboBox.setSelectedItem(gliderPosAltitudeUnitsString);

                runwayAltitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("runwayAltitude");
                String runwayAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(runwayAltitudeUnitsID);
                ProfileAirfieldPanel.runwayAltitudeComboBox.setSelectedItem(runwayAltitudeUnitsString);

                winchPosAltitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("winchPosAltitude");
                String winchPosAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(winchPosAltitudeUnitsID);
                ProfileAirfieldPanel.winchPosAltitudeComboBox.setSelectedItem(winchPosAltitudeUnitsString);

                emptyWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("emptyWeight");
                String emptyWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(emptyWeightUnitsID);
                ProfileGliderPanel.emptyWeightComboBox.setSelectedItem(emptyWeightUnitsString);

                maxGrossWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("maxGrossWeight");
                String maxGrossWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(maxGrossWeightUnitsID);
                ProfileGliderPanel.maxGrossWeightComboBox.setSelectedItem(maxGrossWeightUnitsString);

                stallSpeedUnitsID = currentData.getCurrentProfile().getUnitSetting("stallSpeed");
                String stallSpeedUnitsString = UnitLabelUtilities.velocityUnitIndexToString(stallSpeedUnitsID);
                ProfileGliderPanel.stallSpeedComboBox.setSelectedItem(stallSpeedUnitsString);

                ballastWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("ballastWeight");
                String ballastWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(ballastWeightUnitsID);
                ProfileGliderPanel.ballastWeightComboBox.setSelectedItem(ballastWeightUnitsString);

                baggageWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("baggageWeight");
                String baggageWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(baggageWeightUnitsID);
                ProfileGliderPanel.baggageWeightComboBox.setSelectedItem(baggageWeightUnitsString);

                passengerWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("passengerWeight");
                String passengerWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(passengerWeightUnitsID);
                ProfileGliderPanel.passengerWeightComboBox.setSelectedItem(passengerWeightUnitsString);

                tensionUnitsID = currentData.getCurrentProfile().getUnitSetting("maxTension");
                String tensionUnitsString = UnitLabelUtilities.tensionUnitIndexToString(tensionUnitsID);
                ProfileGliderPanel.maxTensionComboBox.setSelectedItem(tensionUnitsString);

                weakLinkStrengthUnitsID = currentData.getCurrentProfile().getUnitSetting("weakLinkStrength");
                String weakLinkStrengthUnitsString = UnitLabelUtilities.tensionUnitIndexToString(weakLinkStrengthUnitsID);
                ProfileGliderPanel.weakLinkStrengthComboBox.setSelectedItem(weakLinkStrengthUnitsString);

                winchingSpeedUnitsID = currentData.getCurrentProfile().getUnitSetting("winchingSpeed");
                String winchingSpeedUnitsString = UnitLabelUtilities.velocityUnitIndexToString(winchingSpeedUnitsID);
                ProfileGliderPanel.maxWinchingSpeedComboBox.setSelectedItem(winchingSpeedUnitsString);

            } catch(Exception e) {
                //TODO respond to error
            }
        }
    }

    public void Rebuild()
    {
        initProfileList();
        DefaultListModel profileModel = new DefaultListModel();
        for(Object str: names){
            profileModel.addElement(str);
        }
        profileJList.setModel(profileModel);
        profileScrollPane.setViewportView(profileJList);
                
        flightWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("flightWeight");
        String flightWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(flightWeightUnitsID);
        ProfilePilotPanel.flightWeightComboBox.setSelectedItem(flightWeightUnitsString);
        
        airfieldAltitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("airfieldAltitude");
        String airfieldAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(airfieldAltitudeUnitsID);
        ProfileAirfieldPanel.airfieldAltitudeComboBox.setSelectedItem(airfieldAltitudeUnitsString);

        gliderPosAltitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("gliderPosAltitude");
        String gliderPosAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(gliderPosAltitudeUnitsID);
        ProfileAirfieldPanel.gliderPosAltitudeComboBox.setSelectedItem(gliderPosAltitudeUnitsString);

        runwayAltitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("runwayAltitude");
        String runwayAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(runwayAltitudeUnitsID);
        ProfileAirfieldPanel.runwayAltitudeComboBox.setSelectedItem(runwayAltitudeUnitsString);

        winchPosAltitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("winchPosAltitude");
        String winchPosAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(winchPosAltitudeUnitsID);
        ProfileAirfieldPanel.winchPosAltitudeComboBox.setSelectedItem(winchPosAltitudeUnitsString);
        
        emptyWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("emptyWeight");
        String emptyWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(emptyWeightUnitsID);
        ProfileGliderPanel.emptyWeightComboBox.setSelectedItem(emptyWeightUnitsString);
        
        maxGrossWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("maxGrossWeight");
        String maxGrossWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(maxGrossWeightUnitsID);
        ProfileGliderPanel.maxGrossWeightComboBox.setSelectedItem(maxGrossWeightUnitsString);
        
        stallSpeedUnitsID = currentData.getCurrentProfile().getUnitSetting("stallSpeed");
        String stallSpeedUnitsString = UnitLabelUtilities.velocityUnitIndexToString(stallSpeedUnitsID);
        ProfileGliderPanel.stallSpeedComboBox.setSelectedItem(stallSpeedUnitsString);
        
        ballastWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("ballastWeight");
        String ballastWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(ballastWeightUnitsID);
        ProfileGliderPanel.ballastWeightComboBox.setSelectedItem(ballastWeightUnitsString);
        
        baggageWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("baggageWeight");
        String baggageWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(baggageWeightUnitsID);
        ProfileGliderPanel.baggageWeightComboBox.setSelectedItem(baggageWeightUnitsString);
        
        passengerWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("passengerWeight");
        String passengerWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(passengerWeightUnitsID);
        ProfileGliderPanel.passengerWeightComboBox.setSelectedItem(passengerWeightUnitsString);
        
        tensionUnitsID = currentData.getCurrentProfile().getUnitSetting("maxTension");
        String tensionUnitsString = UnitLabelUtilities.tensionUnitIndexToString(tensionUnitsID);
        ProfileGliderPanel.maxTensionComboBox.setSelectedItem(tensionUnitsString);
        
        weakLinkStrengthUnitsID = currentData.getCurrentProfile().getUnitSetting("weakLinkStrength");
        String weakLinkStrengthUnitsString = UnitLabelUtilities.tensionUnitIndexToString(weakLinkStrengthUnitsID);
        ProfileGliderPanel.weakLinkStrengthComboBox.setSelectedItem(weakLinkStrengthUnitsString);
        
        winchingSpeedUnitsID = currentData.getCurrentProfile().getUnitSetting("winchingSpeed");
        String winchingSpeedUnitsString = UnitLabelUtilities.velocityUnitIndexToString(winchingSpeedUnitsID);
        ProfileGliderPanel.maxWinchingSpeedComboBox.setSelectedItem(winchingSpeedUnitsString);
    }

    private void initComponents() {
        setTitle("Profile Management");
        ProfilePilotPanel = new ProfilePilotPanel();
        ProfileGliderPanel = new ProfileGliderPanel();
        ProfileAirfieldPanel = new ProfileAirfieldPanel();
        ProfileWinchPanel = new ProfileWinchPanel();
        ProfileOtherPanel = new ProfileOtherPanel();
        profileScrollPane = new javax.swing.JScrollPane();
        profileJList = new javax.swing.JList();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1071, 704);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        contentPane.add(profileScrollPane, BorderLayout.WEST);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JButton selectButton = new JButton("Set as Current Profile");
        selectButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    selectButtonClicked();
                    }
        });
        selectButton.setBackground(new Color(200,200,200));
        panel.add(selectButton);
       
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    saveButtonClicked();
                    }
        });
        saveButton.setBackground(new Color(200,200,200));
        panel.add(saveButton);

        JButton saveAsNewButton = new JButton("Save as new");
        saveAsNewButton.setBackground(new Color(200,200,200));
        saveAsNewButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    saveAsNewButtonClicked();
                }
        });
        panel.add(saveAsNewButton);

        profileJList.setPreferredSize(new Dimension(200,100));
        DefaultListModel profileModel = new DefaultListModel();
        for(Object str: names){
            profileModel.addElement(str);
        }
        profileJList.setModel(profileModel);
        profileJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileJListMouseClicked(evt);
            }
        });
        profileScrollPane.setViewportView(profileJList);

        JButton resetButton = new JButton("Reset to default");
        resetButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    ProfilePilotPanel.flightWeightComboBox.setSelectedItem("kg");
                    ProfileAirfieldPanel.airfieldAltitudeComboBox.setSelectedItem("m");
                    ProfileAirfieldPanel.gliderPosAltitudeComboBox.setSelectedItem("m");
                    ProfileAirfieldPanel.runwayAltitudeComboBox.setSelectedItem("m");
                    ProfileAirfieldPanel.winchPosAltitudeComboBox.setSelectedItem("m");
                    ProfileGliderPanel.emptyWeightComboBox.setSelectedItem("kg");
                    ProfileGliderPanel.maxGrossWeightComboBox.setSelectedItem("kg");
                    ProfileGliderPanel.stallSpeedComboBox.setSelectedItem("kph");
                    ProfileGliderPanel.weakLinkStrengthComboBox.setSelectedItem("N");
                    ProfileGliderPanel.maxWinchingSpeedComboBox.setSelectedItem("kph");;
                    ProfileGliderPanel.maxTensionComboBox.setSelectedItem("N");
                    ProfileGliderPanel.ballastWeightComboBox.setSelectedItem("kg");
                    ProfileGliderPanel.baggageWeightComboBox.setSelectedItem("kg");
                    ProfileGliderPanel.passengerWeightComboBox.setSelectedItem("kg");
                }
        });
        resetButton.setBackground(new Color(200,200,200));
        panel.add(resetButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(200,200,200));
        cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    dispose();
                }
        });
        panel.add(cancelButton);

        tabbedPane.addTab("Pilot", ProfilePilotPanel);
        tabbedPane.addTab("Glider", ProfileGliderPanel);
        tabbedPane.addTab("Airfield", ProfileAirfieldPanel);
        tabbedPane.addTab("Display", ProfileWinchPanel);
    }

}
