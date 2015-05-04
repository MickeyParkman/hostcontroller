/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnvironmentalWidgets;

import Configuration.UnitConversionRate;
import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;
import DataObjects.CurrentLaunchInformation;

/**
 *
 * @author jtroxel
 */
public class DensityAltitudeWidget extends EnvironmentalWidget {

    public DensityAltitudeWidget() {
        super("Density Altitude", true, true);
    }

    @Override
    public void update() {
        if (manualEntry())
        {
            //Its a manual entry we don't set it but should set hash map here
        }
        else
        {
            float alt = CurrentLaunchInformation.getCurrentLaunchInformation().getCalculatedDensityAltitude() * UnitConversionRate.convertDistanceUnitIndexToFactor(unitId);
            field.setText(String.format("%.2f", alt));
        }
    }

    @Override
    public void update(String msg) {
    }

    @Override
    public void setupUnits() {
        unitId = CurrentDataObjectSet.getCurrentDataObjectSet().getCurrentProfile().getUnitSetting("densityaltitude");
        unit.setText(" " + UnitLabelUtilities.lenghtUnitIndexToString(unitId));
    }
    
}
