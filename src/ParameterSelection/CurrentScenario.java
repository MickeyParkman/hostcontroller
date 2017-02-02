/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParameterSelection;

import Communications.Observer;
import Configuration.ProfileManagementFrame;
import DataObjects.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

/**
 * @author Johnny White
 */
public class CurrentScenario implements Observer
{
    @FXML SubScene   pilotPane;
    @FXML SubScene   gliderPane;
    @FXML SubScene   airfieldPane;
    @FXML SubScene   runwayPane;
    @FXML SubScene   gliderPosPane;
    @FXML SubScene   winchPosPane;
    @FXML SubScene   drumPane;
    @FXML SubScene    parachutePane;
    @FXML GridPane   scenarioHomePane;
    @FXML AnchorPane flightDashboardPanel;
    @FXML Button     pilotButton;
    @FXML Button     gliderButton;
    @FXML Button     airfieldButton;
    @FXML Button     drumButton;
    @FXML Rectangle  pilotGridBackground;
    @FXML Rectangle   gliderGridBackground;
    @FXML Rectangle   runDescriptionGridBackground;
    @FXML Rectangle   drumGridBackground;

    private CurrentDataObjectSet   data;
    private ProfileManagementFrame ProfileManagementFrame;


    /**
     * Creates new form CurrentScenario
     */
    public CurrentScenario() throws IOException
    {
        data = CurrentDataObjectSet.getCurrentDataObjectSet();
        data.attach(this);
    }

    @FXML public void EditAirFieldButton_Click(javafx.event.ActionEvent e)
    {
        airfieldPane.toFront();
    }

    @FXML public void PilotButton_Click(javafx.event.ActionEvent e)
    {
        pilotPane.toFront();
    }

    @FXML public void GliderButton_Click(javafx.event.ActionEvent e)
    {
        gliderPane.toFront();
    }

    @FXML public void DrumButton_Click(javafx.event.ActionEvent e) { drumPane.toFront(); }

    @FXML protected void initialize() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ParameterSelection/PilotScene.fxml"));
        loader.setController(new PilotPanel(scenarioHomePane));
        Parent root = loader.load();
        pilotPane.setRoot(root);

        loader = new FXMLLoader(getClass().getResource("/ParameterSelection/SailplaneScene.fxml"));
        loader.setController(new SailplanePanel(scenarioHomePane));
        root = loader.load();
        gliderPane.setRoot(root);

        loader = new FXMLLoader(getClass().getResource("/ParameterSelection/AirfieldScene.fxml"));
        loader.setController(new AirfieldPanel(runwayPane));
        root = loader.load();
        airfieldPane.setRoot(root);

        loader = new FXMLLoader(getClass().getResource("/ParameterSelection/RunwayScene.fxml"));
        loader.setController(new RunwayPanel(gliderPane));
        root = loader.load();
        runwayPane.setRoot(root);

        loader = new FXMLLoader(getClass().getResource("/ParameterSelection/GliderPositionScene.fxml"));
        loader.setController(new GliderPositionPanel(winchPosPane));
        root = loader.load();
        gliderPosPane.setRoot(root);

        loader = new FXMLLoader(getClass().getResource("/ParameterSelection/WinchPositionScene.fxml"));
        loader.setController(new WinchPositionPanel(scenarioHomePane));
        root = loader.load();
        winchPosPane.setRoot(root);

        loader = new FXMLLoader(getClass().getResource("/ParameterSelection/DrumScene.fxml"));
        loader.setController(new DrumPanel(parachutePane));
        root = loader.load();
        drumPane.setRoot(root);

        loader = new FXMLLoader(getClass().getResource("/ParameterSelection/ParachuteScene.fxml"));
        loader.setController(new ParachutePanel(scenarioHomePane));
        root = loader.load();
        parachutePane.setRoot(root);

        loadScenario();
    }

    private void loadScenario()
    {

        Pilot pilot = data.getCurrentPilot();
        //Sailplane glider = data.getCurrentSailplane();
        //Airfield airfield = data.getCurrentAirfield();
        Sailplane glider = new Sailplane(0,"", "", "","", 0f, 0f, 0f, 0f, 0f, 0f, 0f, true, true, "");
        Airfield airfield = new Airfield("", "", 0f, 0f, 0f, 0f, "");
        GliderPosition position = data.getCurrentGliderPosition();
        Runway runway = data.getCurrentRunway();
        WinchPosition winch = data.getCurrentWinchPosition();
        Drum drum = data.getCurrentDrum();
        Operator profile = data.getCurrentProfile();
        //Stop light red
        Color unstartedBackground = Color.web("#fb122f");
        //traffic light green
        Color completeBackground = Color.web("#27e833");
        //Luminious Vivid Amber
        Color incompleteBackground = Color.web("#FFBF00");

        if (pilot == null)
        {
            pilotGridBackground.setFill(unstartedBackground);
        }
        else
        {
            pilotGridBackground.setFill(completeBackground);
        }

        if (airfield == null && runway == null && position == null && winch == null)
        {
            runDescriptionGridBackground.setFill(unstartedBackground);
        }
        else if(airfield != null && runway != null && position != null && winch != null)
        {
            runDescriptionGridBackground.setFill(completeBackground);
        }
        else
        {
            runDescriptionGridBackground.setFill(incompleteBackground);
        }

        if (glider == null)
        {
            gliderGridBackground.setFill(unstartedBackground);
        }
        else
        {
            gliderGridBackground.setFill(completeBackground);
        }

        if (drum == null)
        {
            drumGridBackground.setFill(unstartedBackground);
        }
        else
        {
            drumGridBackground.setFill(completeBackground);
            /*if (drum.getParachute() == null)
            {
                drumLabel.setForeground(new Color(255, 102, 0));
            }
            else
            {
                drumLabel.setForeground(new Color(0, 128, 0));
            }
            drumLabel.setText(drum.toString());*/
        }
        
        /*if(profile == null) {
            profileLabel.setText("Default Profile"); 
            profileLabel.setForeground(Color.RED);
        } else {
            profileLabel.setText(profile.toString());    
            profileLabel.setForeground(new Color(0,128,0));  
        }*/
    }

    public void update()
    {
        loadScenario();
    }

    public void update(String s) { }
}