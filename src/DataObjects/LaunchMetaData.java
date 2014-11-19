/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataObjects;

/**
 * This class stores information about a launch
 *
 * @author Noah Fujioka
 */
public class LaunchMetaData {
    Profile currentOperatorProfile
    Pilot currentPilot;
    Sailplane currentSailplane;
    Airfield currentAirfield;
    Runway currentRunway;
    Position currentPosition;
    Parachute currentParachute;
    DrumParameters currentDrumParameters;
    Winch currentWinch;
    Environmental currentEnvironmental; //At the start of the flight
    long startTimestamp;
    long endTimestamp;
    
    public LaunchMetaData(){
    }
    
    public LaunchMetaData(Profile newProfile, Pilot newPilot, Sailplane newSailplane,
            Airfield newAirfield, Runway newRunway, Position newPosition,
            Parachute newParachute, DrumParameters newDrumParameters,
            Environmental newEnvironmental, long newStartTimestamp,
            long newEndTimestamp){
        currentOperatorProfile = newProfile;
        currentPilot = newPilot;
        currentSailplane = newSailplane;
        currentAirfield = newAirfield;
        currentRunway = newRunway;
        currentPosition = newPosition;
        currentParachute = newParachute;
        currentDrumParameters = newDrumParameters;
        currentWinch = newWinchParameters;
        currentEnvironmental = newEnvironmental;
        startTimestamp = newStartTimestamp;
        endTimestamp = newEndTimestamp;
    }
    
    @Override
    public String toString() { 
        return (currentPilot.toString() + ", " + currentSailplane.toString() +
                ", " + startTimestamp);
    }

    public Profile getProfile(){
        return currentOperatorProfile;
    }
    
    public Pilot getPilot(){
        return currentPilot;
    }
    
    public Sailplane getSailplane(){
        return currentSailplane;
    }
    
    public Airfield getAirfield(){
        return currentAirfield;
    }
    
    public Runway getRunway(){
        return currentRunway;
    }
    
    public Position getPosition(){
        return currentPosition;
    }
    
    public Parachute getParachtue(){
        return currentParachute;
    }
    
    public DrumParameters getDrumParameters(){
        return currentDrumParameters;
    }
    
    public Winch getWinchParameters(){
        return currentWinchParameters;
    }
    
    public Environmental getEnvironmental(){
        return currentEnvironmental;
    }
    
    public long getStartTimestamp(){
        return startTimestamp;
    }
    
    public long getEndTimestamp(){
        return endTimestamp;
    }
}
