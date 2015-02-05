package DataObjects;

/**
 *
 * @author Jacob Troxel
 */
public class CurrentDataObjectSet {
    
    private static CurrentDataObjectSet instance = null;
    private Pilot currentPilot;
    private Sailplane currentSailplane;
    private Profile currentProfile;
    private Runway currentRunway;
    private WinchPosition currentWinchPos;
    private GliderPosition currentGliderPos;
    private Winch currentWinch;
    private Airfield currentAirfield;
    
    public static CurrentDataObjectSet getCurrentDataObjectSet()
    {
        if(instance == null)
        {
            instance = new CurrentDataObjectSet();
        }
        return instance;
    }
    
    //use with caution!!!
    //this will clear the current loaded objects.
    public static void Clear()
    {
        instance = null;
    }
    
    public static boolean IsInitialized()
    {
        return(instance != null);
    }
    
    //Ah yeah, getters and setters
    public void setCurrentPilot(Pilot pilot)
    {
        if(instance != null)
        {
            instance.currentPilot = pilot;
        }
    }
    public void setCurrentGlider(Sailplane sailplane)
    {
        if(instance != null)
        {
            instance.currentSailplane = sailplane;
        }       
    }
    public void setCurrentRunway(Runway runway)
    {
        if(instance != null)
        {
            instance.currentRunway = runway;
        }    
    }
    public void setCurrentAirfield(Airfield airfield)
    {
        if(instance != null)
        {
            instance.currentAirfield = airfield;
        }        
    }
    public void setCurrentProfile(Profile profile)
    {
        if(instance != null)
        {
            instance.currentProfile = profile;
        }        
    }
    public void setCurrentGliderPosition(GliderPosition pos)
    {
        if(instance != null)
        {
            instance.currentGliderPos = pos;
        }        
    }
    public void setCurrentWinchPosition(WinchPosition pos)
    {
        if(instance != null)
        {
            instance.currentWinchPos = pos;
        }        
    }
    public void setCurrentWinch(Winch winch)
    {
        if(instance != null)
        {
            instance.currentWinch = winch;
        }        
    }
    public Pilot getCurrentPilot()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.currentPilot;
        }
    }
    public Sailplane getCurrentSailplane()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.currentSailplane;
        }        
    }
    public Airfield getCurrentAirfield()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.currentAirfield;
        }        
    }
    public Runway getCurrentRunway()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.currentRunway;
        }        
    }
    public GliderPosition getCurrentGliderPosition()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.currentGliderPos;
        }        
    }
    public WinchPosition getCurrentWinchPosition()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.currentWinchPos;
        }        
    }
    public Winch getCurrentWinch()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.currentWinch;
        }        
    }
    public Profile getCurrentProfile()
    {
        if(instance == null)
        {
            return null;
        }
        else
        {
            return instance.currentProfile;
        }        
    }
}
