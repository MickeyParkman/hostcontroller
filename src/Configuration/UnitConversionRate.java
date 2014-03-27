/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Configuration;

/**
 *
 * @author awilliams5
 */
public class UnitConversionRate {
    //Conversion factors from the standard SI unit to the given unit
    
    //Conversion rates for distances from the standard of a Meter
    public static final double METERS = 1;
    public static final double FEET = 3.2804;
    public static final double MILLIMETERS = 1000;
    public static final double CENTIMETERS = 100;
    public static final double KILOMETERS = 0.001;
    
    //Conversion rates for tension from the standard of a Newton
    public static final double NEWTON = 1;
    public static final double POUND_FORCE = 0.224808943;
    public static final double KILOGRAM_FORCE = 0.101971621;
    
    public static final double POUND = 1;
    public static final double KILOGRAM = 0.453592;
    
    //Conversion rates for weight from the standard of a Newton
    
    public static double convertDistanceUnitIndexToFactor(int index) {
        switch (index) {
            case 0:
                return METERS;
            case 1:
                return FEET;
            case 2:
                return MILLIMETERS;
            case 3:
                return CENTIMETERS;
            case 4:
                return KILOMETERS;
            default:
                return METERS;
        }
    }    

    public static double convertWeightUnitIndexToFactor(int index) {
        switch (index) {
            case 0:
                return POUND;
            case 1:
                return KILOGRAM;
            default:
                return POUND;
        }
    }    
}
