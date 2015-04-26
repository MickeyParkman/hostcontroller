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
public class WindDirectionWidget extends EnvironmentalWidget {

    public WindDirectionWidget() {
        super("Wind Direction", true, true);
    }

    @Override
    public void update() {
        this.field.setText(CurrentWidgetDataSet.getInstance().getValue("winddirection"));
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
