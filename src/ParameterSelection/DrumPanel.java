package ParameterSelection;

import Communications.Observer;
import Configuration.UnitConversionRate;
import DataObjects.CurrentDataObjectSet;
import DataObjects.RecentLaunchSelections;
import DataObjects.Drum;
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
import java.awt.Font;
import javax.swing.ButtonGroup;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import javax.swing.border.MatteBorder;
import Configuration.UnitLabelUtilities;
import DataObjects.Drive;
import DataObjects.Parachute;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DrumPanel implements Observer{

    private CurrentDataObjectSet currentData;
    private int cableLengthUnitsID;
    private int coreDiameterUnitsID;

    @FXML SubScene parachuteScene;

    @FXML TableView drumTable;

    @FXML Label drumNumberLabel;
    @FXML Label coreDiameterLabel;
    @FXML Label kFactorLabel;
    @FXML Label cableLengthLabel;
    @FXML Label cableDensityLabel;
    @FXML Label systemEquivalentMassLabel;
    @FXML Label numLaunchesLabel;
    @FXML Label maxTensionLabel;

    @FXML Label coreDiameterUnitLabel;
    @FXML Label cableLengthUnitLabel;
    @FXML Label cableDensityUnitLabel;
    @FXML Label systemEquivalentMassUnitLabel;
    @FXML Label maxTensionUnitLabel;

    public DrumPanel(SubScene parachuteScene) {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        currentData.attach(this);
        this.parachuteScene = parachuteScene;
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
        cableLengthUnitsID = currentData.getCurrentProfile().getUnitSetting("cableLength");
        String cableLengthUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(cableLengthUnitsID);
        cableLengthUnitLabel.setText(cableLengthUnitsString);
        
        coreDiameterUnitsID = currentData.getCurrentProfile().getUnitSetting("coreDiameter");
        String coreDiameterUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(coreDiameterUnitsID);
        coreDiameterUnitLabel.setText(coreDiameterUnitsString);
    }
    
    @Override
    public void update()
    {
        setupUnits();
    }

    private Observer getObserver() {
        return this;
    }

    public void clear()
    {

    }
    
    /**
     * Create the panel.
     */
    @Override
    public void update(String msg) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML public void ParachuteButton_Click(javafx.event.ActionEvent e) { parachuteScene.toFront(); }
}
