/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnvironmentalWidgets;

import Configuration.UnitConversionRate;
import Configuration.UnitConversionToIndexUtilities;
import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;
import DataObjects.CurrentLaunchInformation;

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
        if (manualEntry())
        {
            //Its a manual entry we don't set it but should set hash map here
        }
        else
        {
            if (CurrentWidgetDataSet.getInstance().getValue("avgwindspeed").equals(""))
            {
                field.setText("0.00");
            }
            else
            {
                float speed = (Float.parseFloat(CurrentWidgetDataSet.getInstance().getValue("avgwindspeed")) * UnitConversionRate.convertSpeedUnitIndexToFactor(unitId));
                field.setText(String.format("%.2f", speed));
            }
        }
    }

    @Override
    public void update(String msg) {
    }

    @Override
    public void setupUnits() {
        unitId = CurrentDataObjectSet.getCurrentDataObjectSet().getCurrentProfile().getUnitSetting("avgwindspeed");
        unit.setText(" " + UnitLabelUtilities.velocityUnitIndexToString(unitId));
    }
    
}
