/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import java.util.Date;

/**
 *
 * @author Chris
 */
public class PreviousLaunch {
    private Date timestamp;
    private String pilotName;
    private String nNumber;
    
    public PreviousLaunch(long timestamp, String name, String nNumber) {
        this.timestamp = new Date(timestamp);
        pilotName = name;
        this.nNumber = nNumber;
    }
    
    public Date getDate() {
        return timestamp;
    }
    
    public String getPilotName() {
        return pilotName;
    }
    
    public String getNNumber() {
        return nNumber;
    }
}
