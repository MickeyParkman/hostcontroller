/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataObjects;

import Communications.Observer;
import java.util.ArrayList;

/**
 *
 * @author Noah
 */
public class RecentLaunchSelections {
    private static RecentLaunchSelections instance = null;
    private static CurrentDataObjectSet currentDataObjectSet;
    private ArrayList<Pilot> recentPilot;
    private ArrayList<Sailplane> recentSailplane;
    private ArrayList<Profile> recentProfile;
    private ArrayList<Runway> recentRunway;
    private ArrayList<WinchPosition> recentWinchPosition;
    private ArrayList<GliderPosition> recentGliderPosition;
    private ArrayList<Winch> recentWinch;
    private ArrayList<Airfield> recentAirfield;
    private ArrayList<Drum> recentDrum;
    private ArrayList<Observer> observers;
    
    public static RecentLaunchSelections RecentLaunchSelections()
    {
        if(instance == null)
        {
            instance = new RecentLaunchSelections();
            instance.observers = new ArrayList<Observer>();
        }
        return instance;
    }
    
    public void addCurrentToRecentLaunchSelections(){
        currentDataObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
        instance.addRecentPilot(currentDataObjectSet.getCurrentPilot());
        instance.addRecentSailplane(currentDataObjectSet.getCurrentSailplane());
        instance.addRecentProfile(currentDataObjectSet.getCurrentProfile());
        instance.addRecentRunway(currentDataObjectSet.getCurrentRunway());
        instance.addRecentWinchPosition(currentDataObjectSet.getCurrentWinchPosition());
        instance.addRecentGliderPosition(currentDataObjectSet.getCurrentGliderPosition());
        instance.addRecentWinch(currentDataObjectSet.getCurrentWinch());
        instance.addRecentAirfield(currentDataObjectSet.getCurrentAirfield());
        instance.addRecentDrum(currentDataObjectSet.getCurrentDrum());
        
    }
    
    public void attach(Observer ob)
    {
        observers.add(ob);
    }
    
    private void notifyObservers()
    {
        for(Observer ob : observers)
        {
            ob.update();
        }
    }
    
    //use with caution!!!
    //this will clear the recent loaded objects.
    public static void Clear()
    {
        instance = null;
    }
    
    public static boolean IsInitialized()
    {
        return(instance != null);
    }
        
    //clear each list
    public void clearRecentPilot()
    {
        if(instance != null) instance.recentPilot = null;
        instance.notifyObservers();
    }
    public void clearRecentSailplane()
    {
        if(instance != null) instance.recentSailplane = null;
        instance.notifyObservers();
    }
    public void clearRecentProfile()
    {
        if(instance != null) instance.recentProfile = null;
        instance.notifyObservers();
    }
    public void clearRecentRunway()
    {
        if(instance != null) instance.recentRunway = null;
        instance.notifyObservers();
    }
    public void clearRecentWinchPosition()
    {
        if(instance != null) instance.recentWinchPosition = null;
        instance.notifyObservers();
    }
    public void clearRecentGliderPosition()
    {
        if(instance != null) instance.recentGliderPosition = null;
        instance.notifyObservers();
    }
    public void clearRecentWinch()
    {
        if(instance != null) instance.recentWinch = null;
        instance.notifyObservers();
    }
    public void clearRecentAirfield()
    {
        if(instance != null) instance.recentAirfield = null;
        instance.notifyObservers();
    }
    public void clearRecentDrum()
    {
        if(instance != null) instance.recentDrum = null;
        instance.notifyObservers();
    }
    //Add a new object to the list
    public void addRecentPilot(Pilot newPilot)
    {
        if(instance != null)
        {
            instance.recentPilot.add(newPilot);
            if (instance.recentPilot.size() > 5){
                instance.recentPilot.remove(0);
            }
        }
    instance.notifyObservers();
    }
    public void addRecentSailplane(Sailplane newSailplane)
    {
        if(instance != null)
        {
            instance.recentSailplane.add(newSailplane);
            if (instance.recentSailplane.size() > 5){
                instance.recentSailplane.remove(0);
            }
        }
    instance.notifyObservers();
    }
    public void addRecentProfile(Profile newProfile)
    {
        if(instance != null)
        {
            instance.recentProfile.add(newProfile);
            if (instance.recentProfile.size() > 5){
                instance.recentProfile.remove(0);
            }
        }
    instance.notifyObservers();
    }
    public void addRecentRunway(Runway newRunway)
    {
        if(instance != null)
        {
            instance.recentRunway.add(newRunway);
            if (instance.recentRunway.size() > 5){
                instance.recentRunway.remove(0);
            }
        }
    instance.notifyObservers();
    }
    public void addRecentWinchPosition(WinchPosition newWinchPosition)
    {
        if(instance != null)
        {
            instance.recentWinchPosition.add(newWinchPosition);
            if (instance.recentWinchPosition.size() > 5){
                instance.recentWinchPosition.remove(0);
            }
        }
    instance.notifyObservers();
    }
    public void addRecentGliderPosition(GliderPosition newGliderPosition)
    {
        if(instance != null)
        {
            instance.recentGliderPosition.add(newGliderPosition);
            if (instance.recentGliderPosition.size() > 5){
                instance.recentGliderPosition.remove(0);
            }
        }
    instance.notifyObservers();
    }
    public void addRecentWinch(Winch newWinch)
    {
        if(instance != null)
        {
            instance.recentWinch.add(newWinch);
            if (instance.recentWinch.size() > 5){
                instance.recentWinch.remove(0);
            }
        }
    instance.notifyObservers();
    }
    public void addRecentAirfield(Airfield newAirfield)
    {
        if(instance != null)
        {
            instance.recentAirfield.add(newAirfield);
            if (instance.recentAirfield.size() > 5){
                instance.recentAirfield.remove(0);
            }
        }
    instance.notifyObservers();
    }
    public void addRecentDrum(Drum newDrum)
    {
        if(instance != null)
        {
            instance.recentDrum.add(newDrum);
            if (instance.recentDrum.size() > 5){
                instance.recentDrum.remove(0);
            }
        }
    instance.notifyObservers();
    }
    //Get the list of object
    public ArrayList<Pilot> getRecentPilot()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.recentPilot;
        }
    }
    public ArrayList<Sailplane> getRecentSailplane()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.recentSailplane;
        }
    }
    public ArrayList<Profile> getRecentProfile()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.recentProfile;
        }
    }
    public ArrayList<Runway> getRecentRunway()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.recentRunway;
        }
    }
    public ArrayList<WinchPosition> getRecentWinchPosition()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.recentWinchPosition;
        }
    }
    public ArrayList<GliderPosition> getRecentGliderPosition()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.recentGliderPosition;
        }
    }
    public ArrayList<Winch> getRecentWinch()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.recentWinch;
        }
    }
    public ArrayList<Airfield> getRecentAirfield()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.recentAirfield;
        }
    }
    public ArrayList<Drum> getRecentDrum()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.recentDrum;
        }
    }
}
