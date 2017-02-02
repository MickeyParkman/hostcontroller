package ParameterSelection;

import AddEditPanels.AddEditWinchPosFrame;
import AddEditPanels.AddEditGliderPosFrame;
import AddEditPanels.AddEditAirfieldFrame;
import AddEditPanels.AddEditRunwayFrame;
import Communications.Observer;
import Configuration.UnitConversionRate;
import Configuration.UnitLabelUtilities;
import DataObjects.Airfield;
import DataObjects.GliderPosition;
import DataObjects.CurrentDataObjectSet;
import DataObjects.RecentLaunchSelections;
import DataObjects.Runway;
import DataObjects.WinchPosition;
import DatabaseUtilities.DatabaseEntrySelect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class AirfieldPanel extends JPanel implements Observer{

    private CurrentDataObjectSet currentData;
    private int airfieldAltitudeUnitsID;
    private int magneticVariationUnitsID;
    private int longitudeUnitsID;
    private int latitudeUnitsID;
    private int UTCUnitsID;

    SubScene runwayPane;

    @FXML TableView airfieldTable;

    @FXML Label designatorLabel;
    @FXML Label altitudeLabel;
    @FXML Label magneticVariationLabel;
    @FXML Label longitudeLabel;
    @FXML Label latitudeLabel;
    @FXML Label UTCOffsetLabel;

    @FXML Label altitudeUnitLabel;
    @FXML Label magneticVariationUnitLabel;
    @FXML Label longitudeUnitLabel;
    @FXML Label latitudeUnitLabel;
    @FXML Label UTCOffsetUnitLabel;

    /**
     * Creates new form sailplanePanel
     */
    public AirfieldPanel(SubScene runwayPane) {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        this.runwayPane = runwayPane;
    }

    @FXML protected void initialize()
    {
        loadData();
        setupUnits();
    }

    public void loadData()
    {
        if(currentData.getCurrentAirfield() != null)
        {
            designatorLabel.setText("" + currentData.getCurrentAirfield().getDesignator());
            altitudeLabel.setText("" + currentData.getCurrentAirfield().getElevation());
            magneticVariationLabel.setText("" + currentData.getCurrentAirfield().getMagneticVariation());
            longitudeLabel.setText("" + currentData.getCurrentAirfield().getLongitude());
            latitudeLabel.setText("" + currentData.getCurrentAirfield().getLatitude());
            UTCOffsetLabel.setText("" + currentData.getCurrentAirfield().getUTC());
        }

        TableColumn airfieldCol = (TableColumn) airfieldTable.getColumns().get(0);
        airfieldCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn designatorCol = (TableColumn) airfieldTable.getColumns().get(0);
        designatorCol.setCellValueFactory(new PropertyValueFactory<>("designator"));

        airfieldTable.setItems(FXCollections.observableList(DatabaseEntrySelect.getAirfields()));

    }

    public void setupUnits()
    {
        airfieldAltitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("airfieldAltitude");
        altitudeUnitLabel.setText(UnitLabelUtilities.lenghtUnitIndexToString(airfieldAltitudeUnitsID));

        magneticVariationUnitsID = currentData.getCurrentProfile().getUnitSetting("airfieldMagneticVariation");
        magneticVariationUnitLabel.setText(UnitLabelUtilities.lenghtUnitIndexToString(magneticVariationUnitsID));

        longitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("airfieldLongitude");
        longitudeUnitLabel.setText(UnitLabelUtilities.lenghtUnitIndexToString(longitudeUnitsID));

        latitudeUnitsID = currentData.getCurrentProfile().getUnitSetting("airfieldLatitude");
        latitudeUnitLabel.setText(UnitLabelUtilities.lenghtUnitIndexToString(latitudeUnitsID));

        UTCUnitsID = currentData.getCurrentProfile().getUnitSetting("airfieldUTC");
        UTCOffsetUnitLabel.setText(UnitLabelUtilities.lenghtUnitIndexToString(UTCUnitsID));
    }
    
    @Override
    public void update(String s)
    {          
        setupUnits();
        if(s.equals("1"))
        {

        }
        else if(s.equals("2"))
        {

        }
        else if(s.equals("3"))
        {

        }
        else
        {

        }     
    }
    
    private Observer getObserver() {
        return this;
    }

    public void clear()
    {

    }

    @FXML public void ChooseRunwayButton_Click(javafx.event.ActionEvent e) { runwayPane.toFront(); }

    @Override
    public void update() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
