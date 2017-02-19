package ParameterSelection;

import Communications.Observer;
import Configuration.UnitLabelUtilities;
import DataObjects.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.control.Label;

import javax.swing.*;

/**
 * Created by micha on 10/18/2016.
 */
public class RunwayPanel extends JPanel implements Observer
{
    private int runwayMagneticHeadingUnitsID;
    private CurrentDataObjectSet currentData;

    SubScene editRunwayPanel;
    SubScene gliderPosPane;

    @FXML TableView gliderTable;

    @FXML Label magneticHeadingLabel;
    @FXML Label magneticHeadingUnitLabel;

    public RunwayPanel(SubScene editRunwayPanel, SubScene gliderPosPane)
    {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        this.editRunwayPanel = editRunwayPanel;
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

    @FXML public void ChooseGliderPosButton_Click(ActionEvent e)
    {
        gliderPosPane.toFront();
    }
    
    @FXML public void NewRunwayButton_Click(ActionEvent e) { editRunwayPanel.toFront(); }
    
}
