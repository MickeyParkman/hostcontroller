package ParameterSelection;

import DataObjects.CurrentDataObjectSet;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

/**
 * Created by micha on 2/2/2017.
 */
public class ParachutePanel
{
    GridPane scenarioHome;
    CurrentDataObjectSet currentData;

    @FXML TableView parachuteTable;

    //Values
    @FXML Label liftLabel;
    @FXML Label dragLabel;
    @FXML Label weightLabel;

    //Unit Labels
    @FXML Label liftUnitLabel;
    @FXML Label dragUnitLabel;
    @FXML Label weightUnitLabel;

    public ParachutePanel(GridPane scenarioHome)
    {
        this.scenarioHome = scenarioHome;
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
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

    }

    @FXML public void FinishButton_Click(javafx.event.ActionEvent e) { scenarioHome.toFront(); }
}
