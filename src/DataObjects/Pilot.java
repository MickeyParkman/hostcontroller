/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 *  This Class stores the data about a Pilot
 * 
 * @author awilliams5, dbennett3, Noah Fujioka
 */
public class Pilot {
    //Pilot's unique id
    int pilotId;
    //Pilot's last name
    String lastName;
    //Pilot's first name
    String firstName;
    //Pilot's middle name
    String middleName;
    //Pilot's weight
    float flightWeight;
    //Pilot's capability
    String capability;
    //Pilot's paunch preference
    float preference;
    //Pilot's Emergency Contact Info
    String emergencyContact;
    //Pilot's Emergency Medical Info
    String medInfo;
    //Pilot's optional_info
    String optional_info;
    
    public Pilot(int pilotId, String firstName, String lastName, String middleName,
            float weight, String capability, float preference, String emergencyContact,
            String medInfo, String optional) {
        this.pilotId = pilotId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.flightWeight = weight;
        this.capability = capability;
        this.preference = preference;
        this.emergencyContact = emergencyContact;
        this.medInfo = medInfo;
        this.optional_info = optional;
    }
    
    public int getPilotId() {
        return pilotId;
    }
    public void setPilotId(int newId) {
        pilotId = newId;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getMiddleName() {
        return middleName;
    }
    
    public float getWeight() {
        return flightWeight;
    }
    
    public String getCapability() {
        return capability;
    }
    
    public float getPreference() {
        return preference;
    }
    
    public String getEmergencyName() {
        return emergencyContact;
    }
    
    public String getEmergencyPhone() {
        return medInfo;
    }
    
    public String getOptionalInfo() {
        return optional_info;
    }
    
    @Override
    public String toString() { 
        return (firstName + " " + middleName + " " + lastName);
    }
    
    /**
     * 
     * @param other Pilot being compared to this pilot
     * @return true if the pilot id's are the same 
     *
    public boolean pilotEquals(Pilot other) {
        return pilotId == other.pilotId;
    }
    */
}
