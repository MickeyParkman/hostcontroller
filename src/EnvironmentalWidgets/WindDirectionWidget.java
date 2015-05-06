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
public class WindDirectionWidget extends EnvironmentalWidget {

    public WindDirectionWidget() {
        super("Wind Direction", true, true);
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
                String value = CurrentWidgetDataSet.getInstance().getValue("winddirection");
                if (value.equals("")){
                    this.field.setText("0.00");
                }
                else
                {
                    float direction = Float.parseFloat(CurrentWidgetDataSet.getInstance().getValue("winddirection"));
                    direction -= CurrentLaunchInformation.getCurrentLaunchInformation().getAirfieldMagneticVariation();
                    this.field.setText(String.format("%.2f", direction));
                }
            }
            else if(unitId == 1)
            {
                this.field.setText(String.valueOf(CurrentWidgetDataSet.getInstance().getValue("winddirection")));
            }
        }
    }

    @Override
    public void update(String msg) {
    }

    @Override
    public void setupUnits() {
        unitId = CurrentDataObjectSet.getCurrentDataObjectSet().getCurrentProfile().getUnitSetting("winddirection");
        unit.setText(" degrees " + UnitLabelUtilities.degreesUnitIndexToString(unitId));
    }
    
}
