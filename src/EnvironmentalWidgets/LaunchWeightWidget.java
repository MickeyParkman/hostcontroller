package EnvironmentalWidgets;

import Configuration.UnitConversionRate;
import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;
import DataObjects.CurrentLaunchInformation;

/**
 *
 * @author jtroxel
 */
public class LaunchWeightWidget extends EnvironmentalWidget {

    public LaunchWeightWidget()
    {
        super("Launch Weight", true, false);
    }

    @Override
    public void update()
    {
        float weight = (CurrentLaunchInformation.getCurrentLaunchInformation().getGliderLaunchMass()) * UnitConversionRate.convertWeightUnitIndexToFactor(unitId);
        field.setText(""+weight);
    }

    @Override
    public void update(String msg) {}

    @Override
    public void setupUnits() {
        unitId = CurrentDataObjectSet.getCurrentDataObjectSet().getCurrentProfile().getUnitSetting("launchweight");
        unit.setText(" " + UnitLabelUtilities.weightUnitIndexToString(unitId));
    }
    
}
