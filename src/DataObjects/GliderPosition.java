/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 * This Class stores the data about a Position
 * 
 * @author garreola-gutierrez, mtdargen, dbennett3, Noah Fujioka
 */
public class GliderPosition {
    
    String positionId;
    String runwayParent;
    String airfieldParent;
    int altitude;
    float latitude;
    float longitude;
    String optionalInfo;
    
    public GliderPosition(String id, String runwayParent, String airfieldParent, int altitude, float latitude, float longitude, String optional){
       this.positionId = id;
       this.runwayParent = runwayParent;
       this.airfieldParent = airfieldParent;
       this.altitude = altitude;
       this.latitude = latitude;
       this.longitude = longitude;
       this.optionalInfo = optional;
    }
    
    public String getGliderPositionId() {
        return positionId;
    }
        
    public String getRunwayParent(){
       return runwayParent; 
    }
    
    public String getAirfieldParent(){
       return airfieldParent; 
    }
    
    public int getAltitude() {
        return altitude;
    }
    
    public float getLatitude() {
        return latitude;
    }
    
    public float getLongitude() {
        return longitude;
    }
    
    public String getOptionalInfo() {
        return optionalInfo;
    }

    public String toString() {
        return positionId;
    }
}

    
