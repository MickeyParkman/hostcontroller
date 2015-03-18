/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataObjects;

/**
 * This class stores info on the position of the winch
 *
 * @author dbennett3, Noah Fujioka
 */
public class WinchPosition {
    String id;
    String name;
    String runwayParent;
    String runwayParentId;
    String airfieldParent;
    String airfieldParentId;
    int altitude;
    float latitude;
    float longitude;
    String optionalInfo;
    
    public WinchPosition(String name, String runwayParent, String airfieldParent, int altitude, float latitude, float longitude, String optional) {
        this.name = name;
        this.runwayParent = runwayParent;
        this.airfieldParent = airfieldParent;
        this.altitude = altitude;
        this.latitude = latitude;
        this.longitude = longitude;
        this.optionalInfo = optional;
    }
    
    public String getId(){
        if (id != null){
            return id;
        }
        else{
            id = "";
            return id;
        }
    }
    
    public void setId(String newId){
        id = newId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getRunwayParent() {
        return runwayParent;
    }

    public String getRunwayParentId(){
        if (runwayParentId != null){
            return runwayParentId;
        }
        else{
            runwayParentId = "";
            return runwayParentId;
        }
    }
    
    public void setRunwayParentId(String newRunwayParentId){
        runwayParentId = newRunwayParentId;
    } 
    
    public String getAirfieldParent(){
       return airfieldParent; 
    }
    
    public String getAirfieldParentId(){
        if (airfieldParentId != null){
            return airfieldParentId;
        }
        else{
            airfieldParentId = "";
            return airfieldParentId;
        }
    }
    
    public void setAirfieldParentId(String newAirfieldParentId){
        airfieldParentId = newAirfieldParentId;
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
        return name;
    }
}
