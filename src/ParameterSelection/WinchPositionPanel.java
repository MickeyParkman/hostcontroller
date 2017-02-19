package ParameterSelection;

import Communications.Observer;
import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;

import javax.swing.*;

/**
 * Created by micha on 10/18/2016.
 */
public class WinchPositionPanel extends JPanel implements Observer
{
    private CurrentDataObjectSet currentData;
    private int winchPosAltitudeUnitsID;

    SubScene editWinchPositionPanel;
    GridPane scenarioHomePane;

    @FXML
    TableView gliderPositionTable;

    @FXML Label positionNameLabel;
    @FXML Label altitudeLabel;
    @FXML Label longitudeLabel;
    @FXML Label latitudeLabel;

    @FXML Label altitudeUnitLabel;
    @FXML Label longitudeUnitLabel;
    @FXML Label latitudeUnitLabel;

    public WinchPositionPanel(SubScene editWinchPositionPanel, GridPane scenarioHomePane)
    {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        this.editWinchPositionPanel = editWinchPositionPanel;
        this.scenarioHomePane = scenarioHomePane;
    }

    @FXML protected void initialize()
    {
        loadData();
        setupUnits();
    }

    public void loadData()
    {

    }

    public void setupUnits()
    {
        winchPosAltitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("winchPosAltitude");
        String winchPosAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(winchPosAltitudeUnitsID);
    }

    @Override
    public void update()
    {

    }

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

    @FXML public void AirfieldFinishButton_Click(javafx.event.ActionEvent e) { scenarioHomePane.toFront(); }
    
    @FXML public void NewWinchPositionButton_Click(ActionEvent e) { editWinchPositionPanel.toFront(); }
}
