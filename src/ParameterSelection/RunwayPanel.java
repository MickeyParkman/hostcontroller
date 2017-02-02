package ParameterSelection;

import AddEditPanels.AddEditRunwayFrame;
import Communications.Observer;
import Configuration.UnitLabelUtilities;
import DataObjects.*;
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
public class RunwayPanel extends JPanel implements Observer
{
    private int runwayMagneticHeadingUnitsID;
    private CurrentDataObjectSet currentData;

    SubScene gliderPosPane;

    @FXML TableView gliderTable;

    @FXML Label magneticHeadingLabel;
    @FXML Label magneticHeadingUnitLabel;

    public RunwayPanel(SubScene gliderPosPane)
    {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        this.gliderPosPane = gliderPosPane;
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
        runwayMagneticHeadingUnitsID = currentData.getCurrentProfile().getUnitSetting("runwayMagneticHeading");
        String runwayMagneticHeadingUnitsString = UnitLabelUtilities.degreesUnitIndexToString(runwayMagneticHeadingUnitsID);
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

    @FXML public void ChooseGliderPosButton_Click(javafx.event.ActionEvent e)
    {
        gliderPosPane.toFront();
    }
}
