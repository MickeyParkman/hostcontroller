/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import java.util.Date;

/**
 * Class to store the relevant data for identifying a previous launch
 * @author Alex Williams
 */
public class PreviousLaunch {
    private Date timestamp;
    private String pilotName;
    private String nNumber;
    
    /**
     * Constructor for the PreviousLaunch class
     * 
     * @param timestamp the time that the launch started
     * @param name the Pilot for the launch
     * @param nNumber the N-number of the sailplane for the previous launch
     */
    public PreviousLaunch(long timestamp, String name, String nNumber) {
        this.timestamp = new Date(timestamp);
        pilotName = name;
        this.nNumber = nNumber;
    }
    
    /**
     * Accessor for the start time of the launch
     * @return the start time of the launch
     */
    public Date getDate() {
        return timestamp;
    }
    
    /**
     * Accessor for the pilot for the launch
     * @return the start time of the launch
     */
    public String getPilotName() {
        return pilotName;
    }
    
    /**
     * Accessor for the N-number of sailplane for the launch
     * @return the start time of the launch
     */
    public String getNNumber() {
        return nNumber;
    }
}
