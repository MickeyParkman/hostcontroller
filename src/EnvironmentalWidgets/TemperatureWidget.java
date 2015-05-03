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
public class TemperatureWidget extends EnvironmentalWidget {

    public TemperatureWidget() {
        super("Temperature", true, true);
    }

    @Override
    public void update() {
        if(unitId == 0)
        {
            this.field.setText(String.valueOf(CurrentWidgetDataSet.getInstance().getValue("temperature")));
        }
        else if(unitId == 1)
        {
            String value = CurrentWidgetDataSet.getInstance().getValue("temperature");
            System.out.println(value);
            this.field.setText(String.valueOf((Float.parseFloat(CurrentWidgetDataSet.getInstance().getValue("temperature"))) * 1.8 + 32));
        }
    }

    @Override
    public void update(String msg) {
    }

    @Override
    public void setupUnits() {
        unitId = CurrentDataObjectSet.getCurrentDataObjectSet().getCurrentProfile().getUnitSetting("temperature");
        unit.setText(" " + UnitLabelUtilities.tempUnitIndexToString(unitId));
    }
    
}
