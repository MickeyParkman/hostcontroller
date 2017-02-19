package ParameterSelection;

import Communications.Observer;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Pilot;
import javax.swing.DefaultListModel;
import Configuration.UnitLabelUtilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;


public class PilotPanel implements Observer{

    private Boolean shown;
    private CurrentDataObjectSet currentData;

    GridPane scenarioHomePane;
    SubScene editPilotPanel;

    @FXML TableView pilotTable;
    @FXML Slider preferenceSlider;

    @FXML Label flightWeightLabel;
    @FXML Label capabiltiyLabel;

    @FXML Label flightWeightUnitLabel;

    private int flightWeightUnitsID;

    public PilotPanel(SubScene editPilotPanel, GridPane scenarioHomePane) {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        this.editPilotPanel = editPilotPanel;
        this.scenarioHomePane = scenarioHomePane;
    }

    @FXML
    protected void initialize()
    {
        setupUnits();
        loadData();

        preferenceSlider.setLabelFormatter(new StringConverter<Double>()
        {
            @Override
            public String toString(Double object)
            {
                if(object.doubleValue() == 0)
                {
                    return "Student";
                }
                if(object.doubleValue() == .5)
                {
                    return "Proficient";
                }
                if(object.doubleValue() == 1)
                {
                    return "Advanced";
                }
                return object.toString();
            }

            @Override
            public Double fromString(String string)
            {
                if(string.equalsIgnoreCase("Student"))
                {
                    return new Double(0);
                }
                if(string.equalsIgnoreCase("Proficient"))
                {
                    return new Double(.5);
                }
                if(string.equalsIgnoreCase("Advanced"))
                {
                    return new Double(1);
                }
                return Double.parseDouble(string);
            }
        });
    }

    public void loadData()
    {

    }

    public void setupUnits()
    {
        flightWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("flightWeight");
        flightWeightUnitLabel.setText(UnitLabelUtilities.lenghtUnitIndexToString(flightWeightUnitsID));
    }
    
    @Override
    public void update()
    {
        setupUnits();
        DefaultListModel pilotModel = new DefaultListModel();
        pilotModel.clear();


        Pilot currentPilot = currentData.getCurrentPilot();
    }
    
    private Observer getObserver() {
        return this;
    }

    public void clear()
    {

    }

    @Override
    public void update(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML public void PilotFinishButton_Click(ActionEvent e) { scenarioHomePane.toFront(); }
    
    @FXML public void NewPilotButton_Click(ActionEvent e) { editPilotPanel.toFront(); }
}
