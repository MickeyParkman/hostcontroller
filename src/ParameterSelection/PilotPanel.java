package ParameterSelection;

import AddEditPanels.AddEditPilotPanel;
import Communications.Observer;
import Configuration.UnitConversionRate;
import DataObjects.CurrentDataObjectSet;
import DataObjects.RecentLaunchSelections;
import DataObjects.Pilot;
import DatabaseUtilities.DatabaseUnitSelectionUtilities;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import javax.swing.border.MatteBorder;
import Configuration.UnitLabelUtilities;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PilotPanel implements Observer{

    private Boolean shown;
    private CurrentDataObjectSet currentData;

    GridPane scenarioHomePane;

    @FXML TableView pilotTable;
    @FXML Slider preferenceSlider;

    @FXML Label flightWeightLabel;
    @FXML Label capabiltiyLabel;

    @FXML Label flightWeightUnitLabel;

    private int flightWeightUnitsID;

    public PilotPanel(GridPane scenarioHomePane) {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
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

    @FXML public void PilotFinishButton_Click(javafx.event.ActionEvent e) { scenarioHomePane.toFront(); }
}
