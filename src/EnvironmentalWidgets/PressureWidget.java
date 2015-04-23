/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnvironmentalWidgets;

import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;
/**
 *
 * @author jtroxel
 */
public class PressureWidget extends EnvironmentalWidget {

    public PressureWidget() {
        super("Pressure", true, true);
    }

    @Override
    public void update() {
        this.field.setText(CurrentWidgetDataSet.getInstance().getValue("PRESSURE"));
    }

    @Override
    public void update(String msg) {
    }

    @Override
    public void setupUnits() {
        unitId = CurrentDataObjectSet.getCurrentDataObjectSet().getCurrentProfile().getUnitSetting("pressure");
        unit.setText(" " + UnitLabelUtilities.pressureUnitIndexToString(unitId));
    }
    
}
