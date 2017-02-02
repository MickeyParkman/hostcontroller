package ParameterSelection;

import AddEditPanels.AddEditGliderPosFrame;
import Communications.Observer;
import Configuration.UnitConversionRate;
import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;
import DataObjects.GliderPosition;
import DataObjects.RecentLaunchSelections;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.control.Label;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by micha on 10/18/2016.
 */
public class GliderPositionPanel extends JPanel implements Observer
{
    private int gliderPosAltitudeUnitsID;

    private CurrentDataObjectSet currentData;

    SubScene winchPosPane;

    @FXML TableView gliderPositionTable;

    @FXML Label positionNameLabel;
    @FXML Label altitudeLabel;
    @FXML Label longitudeLabel;
    @FXML Label latitudeLabel;

    @FXML Label altitudeUnitLabel;
    @FXML Label longitudeUnitLabel;
    @FXML Label latitudeUnitLabel;

    public GliderPositionPanel(SubScene winchPosPane)
    {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        this.winchPosPane = winchPosPane;
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
        gliderPosAltitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("gliderPosAltitude");
        String gliderPosAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(gliderPosAltitudeUnitsID);
    }

    @Override
    public void update()
    {

    }

    @Override
    public void update(String s)
    {

    }

    public void clear()
    {

    }

    private Observer getObserver() {
        return this;
    }

    @FXML public void ChooseWinchPosButton_Click(javafx.event.ActionEvent e) { winchPosPane.toFront(); }
}
