/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 * This class represents the relevant data about an Airfield
 * 
 * @author garreola-gutierrez, dbennett3, Noah Fujioka
 */
public class Airfield {
    int id;
    String name;
    String designator;
    float altitude;
    float magneticVariation;
    float latitude;
    float longitude;
    int utcOffset;
    String optionalInfo;
    
    
    public Airfield(String name, String designator, float altitude, float magneticVariation, 
            float latitude, float longitude, String optional) {
       this.name = name;
       this.designator = designator;
       this.altitude = altitude;
       this.magneticVariation = magneticVariation;
       this.latitude = latitude;
       this.longitude = longitude;
       this.optionalInfo = optional;
    }
    public Airfield(int id, String name, String designator, float altitude, float magneticVariation, 
            float latitude, float longitude, int utc, String optional) {
        this.id = id;
        this.name = name;
        this.designator = designator;
        this.altitude = altitude;
        this.magneticVariation = magneticVariation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.utcOffset = utc;
        this.optionalInfo = optional;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int newId){
        id = newId;
    }
    
    public String getName(){
       return name; 
    }
    
    public String getDesignator(){
       return designator; 
    }
    
    public float getElevation(){
       return altitude; 
    }
    
    public float getMagneticVariation(){
       return magneticVariation; 
    }
    
    public float getLatitude() {
        return latitude;
    }
    
    public float getLongitude() {
        return longitude;
    }
    public int getUTC() {
        return utcOffset;
    }
    
    public String getOptionalInfo() {
        return optionalInfo;
    }

    public String toString() {
        return name + " (" + designator + ")";
    }
}
