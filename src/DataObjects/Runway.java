/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 * This Class stores the data about a Runway
 * 
 * @author garreola-gutierrez, matt dargen, dbennett3
 */
public class Runway {
    String runwayId;
    String magneticHeading;
    String parent;
    int altitude;
    String optionalInfo;
    
    public Runway(String runwayId, String magneticHeading, String parent, int altitude, String optional){
       this.runwayId = runwayId;
       this.magneticHeading = magneticHeading;
       this.parent = parent;
       this.altitude = altitude;
       this.optionalInfo = optional;
    }
    
    public String getId(){
       return runwayId; 
    }
    
    public String getMagneticHeading(){
       return magneticHeading; 
    }
    
    public String getParent() {
        return parent;
    }
    
    public int getAltitude() {
        return altitude;
    }
    
    public String getOptionalInfo() {
        return optionalInfo;
    }
    
      
}
