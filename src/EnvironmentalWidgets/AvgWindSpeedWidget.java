/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnvironmentalWidgets;

import Configuration.UnitConversionRate;
import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;

/**
 *
 * @author jtroxel
 */
public class AvgWindSpeedWidget extends EnvironmentalWidget {

    public AvgWindSpeedWidget() {
        super("Avg. Wind Speed", true, true);
    }

    @Override
    public void update() {
    }

    @Override
    public void update(String msg) {
        this.field.setText(String.valueOf(Float.parseFloat(CurrentWidgetDataSet.getInstance().getValue("windspeed")) * UnitConversionRate.convertSpeedUnitIndexToFactor(unitId)));
    }

    @Override
    public void setupUnits() {
        unitId = CurrentDataObjectSet.getCurrentDataObjectSet().getCurrentProfile().getUnitSetting("avgwindspeed");
        unit.setText(" " + UnitLabelUtilities.velocityUnitIndexToString(unitId));
    }
    
}
