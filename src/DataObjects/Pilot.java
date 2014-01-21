/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 *
 * @author awilliams5
 */
public class Pilot {
    //Pilot's last name
    String lastName;
    //Pilot's first name
    String firstName;
    //Pilot's weight
    int weight;
    //Pilot's capability
    String capability;
    //Pilot's paunch preference
    String preference;
    //Pilot's Emergency Contact Info
    String emergencyContact;
    //Pilot's Emergency Medical Info
    String medInfo;
    
    public Pilot(String lastName, String firstName, int weight, String capability, String preference, String emergencyContact, String medInfo) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.weight = weight;
        this.capability = capability;
        this.preference = preference;
        this.emergencyContact = emergencyContact;
        this.medInfo = medInfo;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public String getCapability() {
        return capability;
    }
    
    public String getPreference() {
        return preference;
    }
    
    public String getEmergencyContact() {
        return emergencyContact;
    }
    
    public String getMedInfo() {
        return medInfo;
    }
    
    @Override
    public String toString() { 
        return (firstName + " " + lastName);
    }
}
