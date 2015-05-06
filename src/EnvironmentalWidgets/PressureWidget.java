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
public class PressureWidget extends EnvironmentalWidget {

    public PressureWidget() {
        super("Pressure", true, true);
    }

    @Override
    public void update() {
        if (manualEntry())
        {
            //Its a manual entry we don't set it but should set hash map here
        }
        else
        {
            if (CurrentWidgetDataSet.getInstance().getValue("pressure").equals(""))
            {
                field.setText("0.00");
            }
            else
            {
                float speed = (Float.parseFloat(CurrentWidgetDataSet.getInstance().getValue("pressure")) * UnitConversionRate.convertWeightUnitIndexToFactor(unitId));
                field.setText(String.format("%.2f", speed));
            }
        }
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
