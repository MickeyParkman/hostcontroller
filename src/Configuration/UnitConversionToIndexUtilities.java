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
public class UnitConversionToIndexUtilities {
    public static int lenghtUnitStringToIndex(String unit) {
        switch (unit) {
            case "m":
                return 0;
            case "ft":
                return 1;
            case "mm": 
                return 2;
            case "cm":
                return 3;
            case "km":
                return 4;
            case "mi":
                return 5;
            default:
                return 0;
        }
    }
    
    public static int tensionUnitStringToIndex(String unit) {
       switch (unit) {
            case "N":
                return 0;
            case "lbf":
                return 1;
            case "kgf": 
                return 2;
            case "daN":
                return 3;
            default:
                return 0;
        } 
    }
    
    public static int weightUnitStringToIndex(String unit) {
       switch (unit) {
            case "kg":
                return 0;
            case "lbs":
                return 1;
            default:
                return 0;
        } 
    }
    
    public static int velocityUnitStringToIndex(String unit) {
       switch (unit) {
            case "kph":
                return 0;
            case "mph":
                return 1;
            case "m/s": 
                return 2;
            case "kn":
                return 3;
            default:
                return 0;
        } 
    }
    
    public static int tempUnitStringToIndex(String unit) {
       switch (unit) {
            case "F":
                return 1;
            case "C":
                return 0;
            default:
                return 0;
        } 
    }
    
    public static int pressureUnitStringToIndex(String unit) {
       switch (unit) {
            case "psi":
                return 1;
            case "Mp":
                return 1;
            case "Kp": 
                return 0;
            default:
                return 0;
        } 
    }
}
