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
        if (manualEntry())
        {
            //Its a manual entry we don't set it but should set hash map here
        }
        else
        {
            if(unitId == 0)
            {
                String value = CurrentWidgetDataSet.getInstance().getValue("temperature");
                if (value.equals("")){
                    this.field.setText("0.00");
                }
                else
                {
                    this.field.setText(String.format("%.2f", value));
                }
            }
            else if(unitId == 1)
            {
                String value = CurrentWidgetDataSet.getInstance().getValue("temperature");
                if (value.equals("")){
                    this.field.setText("0.00");
                }
                else
                {
                    this.field.setText(String.format("%.2f", (Float.parseFloat(CurrentWidgetDataSet.getInstance().getValue("temperature"))) * 1.8 + 32));
                }
            }
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
