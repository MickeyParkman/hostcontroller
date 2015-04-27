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
public class DensityAltitudeWidget extends EnvironmentalWidget {

    public DensityAltitudeWidget() {
        super("Density Altitude", true, true);
    }

    @Override
    public void update() {
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
