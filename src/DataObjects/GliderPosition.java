/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 * This Class stores the data about a Position
 * 
 * @author garreola-gutierrez, mtdargen, dbennett3
 */
public class GliderPosition {
    
    String positionId;
    String runwayParent;
    int altitude;
    float latitude;
    float longitude;
    String optionalInfo;
    
    public GliderPosition(String id, String parent, int altitude, float latitude, float longitude, String optional){
       this.positionId = id;
       this.runwayParent = parent;
       this.altitude = altitude;
       this.latitude = latitude;
       this.longitude = longitude;
       this.optionalInfo = optional;
    }
    
    public String getGliderPositionId() {
        return positionId;
    }
        
    public String getParent(){
       return runwayParent; 
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
}

    
