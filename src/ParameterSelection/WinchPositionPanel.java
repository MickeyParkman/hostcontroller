package ParameterSelection;

import AddEditPanels.AddEditWinchPosFrame;
import Communications.Observer;
import Configuration.UnitConversionRate;
import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;
import DataObjects.RecentLaunchSelections;
import DataObjects.WinchPosition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by micha on 10/18/2016.
 */
public class WinchPositionPanel extends JPanel implements Observer
{
    private CurrentDataObjectSet currentData;
    private int winchPosAltitudeUnitsID;

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

    public WinchPositionPanel(GridPane scenarioHomePane)
    {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
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
}
