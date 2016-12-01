package DataObjects;

/**
 *
 * @author Noah Fujioka
 */

import DatabaseUtilities.DatabaseEntryInsert;
import DatabaseUtilities.DatabaseEntrySelect;

public class FlightSummary {
    private String startTimestamp;
    private String pilotId;
    private String pilotFirstName;
    private String pilotLastName;
    private String gliderNnumber;
    
    public FlightSummary(String startTimestamp, String pilotId, 
            String pilotFirstName, String pilotLastName, String gliderNnumber){
            this.startTimestamp = startTimestamp;
            this.pilotId = pilotId;
            this.pilotFirstName = pilotFirstName;
            this.pilotLastName = pilotLastName;
            this.gliderNnumber = gliderNnumber;
    }
    
    public String toString(){
        return startTimestamp + ", " + pilotFirstName + " " + pilotLastName +
                ", " + gliderNnumber;
    }
    
    public void setCurrentDataObjectSet(){
        try{
            DatabaseEntrySelect.setCurrentDataObjectSetToFlight(this);
        }catch(Exception e){
            System.out.println("Error 404: Flight not found");
            //e.printStackTrace();
        }
    }
    
    public String getStartTimestamp(){
        return startTimestamp;
    }
    
    public String getPilotId(){
        return pilotId;
    }
}
