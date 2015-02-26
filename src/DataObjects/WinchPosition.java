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
    String name;
    String runwayParent;
    String airfieldParent;
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
    
    public String getName() {
        return name;
    }
    
    public String getRunwayParent() {
        return runwayParent;
    }

    public String getAirfieldParent() {
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
        return name;
    }
}
