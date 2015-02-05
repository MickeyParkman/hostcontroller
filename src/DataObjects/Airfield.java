/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 * This class represents the relevant data about an Airfield
 * 
 * @author garreola-gutierrez, dbennett3
 */
public class Airfield {
    String name;
    String designator;
    int altitude;
    int magneticVariation;
    int latitude;
    int longitude;
    String optionalInfo;
    
    
    public Airfield(String name, String designator, int altitude, int magneticVariation, int latitude, int longitude, String optional){
       this.name = name;
       this.designator = designator;
       this.altitude = altitude;
       this.magneticVariation = magneticVariation;
       this.latitude = latitude;
       this.longitude = longitude;
       this.optionalInfo = optional;
    }
    
    public String getName(){
       return name; 
    }
    
    public String getDesignator(){
       return designator; 
    }
    
    public int getAltitude(){
       return altitude; 
    }
    
    public int getMagneticVariation(){
       return magneticVariation; 
    }
    
    public int getLatitude() {
        return latitude;
    }
    
    public int getLongitude() {
        return longitude;
    }
    
    public String getOptionalInfo() {
        return optionalInfo;
    }
}
