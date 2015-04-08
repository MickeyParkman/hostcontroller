
package DataObjects;

import Communications.Observer;
import ParameterSelection.Capability;
import ParameterSelection.Preference;
import java.util.ArrayList;

/**
 *
 * @author Noah
 */
public class CurrentLaunchInformation {
    
    private static CurrentLaunchInformation instance = null;
    private static CurrentDataObjectSet currentDataObjectSet;
    private boolean complete;
    private float pilotWeight;
    private int pilotCapacity;
    private int pilotPreference;
    private float gliderMaxGrossWeight;
    private float gliderEmptyWeight;
    private float gliderIndicatedStallSpeed;
    private float gliderMaxWinchingSpeed;
    private float gliderMaxWeakLinkStrength;
    private float gliderMaxTension;
    private float airfieldAltitude;
    private float airfieldMagneticVariation;
    private float airfieldLatitude;
    private float airfieldLongitude;
    private float runwayMagneticHeading;
    private float runwayAltitude;
    private float gliderPositionAltitude;
    private float gliderPositionLatitude;
    private float gliderPositionLongitude;
    private float winchPositionAltitude;
    private float winchPositionLatitude;
    private float winchPositionLongitude;
    private float drumCoreDiameter;
    private float drumKFactor;
    private float drumCableLength;
    private float drumEndOffset;
    private float drumQuadratureSensor;
    private float parachuteLift;
    private float parachuteDrag;
    private float parachuteWeight; 
    private float windSpeed;
    private float windDirection;
    private float temperature;
    private float pressure;
    private float densityAltitude;
    private float runLength;
    private float runSlope;
    private float runHeading;
    private float gliderLaunchMass;
    private ArrayList<Observer> observers;
    
    public static CurrentLaunchInformation CurrentLaunchInformation()
    {
        if(instance == null)
        {
            instance = new CurrentLaunchInformation();
            instance.observers = new ArrayList<Observer>();
            instance.complete = false;
        }
        return instance;
    }
    
    public void updateCurrentFlightInformation()
    {
        currentDataObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
        instance.pilotWeight = currentDataObjectSet.getCurrentPilot().getWeight();
        try{
            int capability = Capability.convertCapabilityStringToNum(currentDataObjectSet.getCurrentPilot().getCapability());
            int preference = Preference.convertPreferenceStringToNum(currentDataObjectSet.getCurrentPilot().getPreference());
            instance.pilotCapacity = capability;
            instance.pilotPreference = preference;
        }catch (Exception e){
            System.out.println("Error when updating capability/pilot");
            e.printStackTrace();
        }
        instance.gliderMaxGrossWeight = currentDataObjectSet.getCurrentSailplane().getMaxGrossWeight();
        instance.gliderEmptyWeight = currentDataObjectSet.getCurrentSailplane().getEmptyWeight();
        instance.gliderIndicatedStallSpeed = currentDataObjectSet.getCurrentSailplane().getIndicatedStallSpeed();
        instance.gliderMaxWinchingSpeed = currentDataObjectSet.getCurrentSailplane().getMaxWinchingSpeed();
        instance.gliderMaxWeakLinkStrength = currentDataObjectSet.getCurrentSailplane().getMaxWeakLinkStrength();
        instance.gliderMaxTension = currentDataObjectSet.getCurrentSailplane().getMaxTension();
        instance.airfieldAltitude = currentDataObjectSet.getCurrentAirfield().getAltitude();
        instance.airfieldMagneticVariation = currentDataObjectSet.getCurrentAirfield().getMagneticVariation();
        instance.airfieldLatitude = currentDataObjectSet.getCurrentAirfield().getLatitude();
        instance.airfieldLongitude = currentDataObjectSet.getCurrentAirfield().getLongitude();
        instance.runwayMagneticHeading = currentDataObjectSet.getCurrentRunway().getMagneticHeading();
        instance.runwayAltitude = currentDataObjectSet.getCurrentRunway().getAltitude();
        instance.gliderPositionAltitude = currentDataObjectSet.getCurrentGliderPosition().getAltitude();
        instance.gliderPositionLatitude = currentDataObjectSet.getCurrentGliderPosition().getLatitude();
        instance.gliderPositionLongitude = currentDataObjectSet.getCurrentGliderPosition().getLongitude();
        instance.winchPositionAltitude = currentDataObjectSet.getCurrentWinchPosition().getAltitude();
        instance.winchPositionLatitude = currentDataObjectSet.getCurrentWinchPosition().getLatitude();
        instance.winchPositionLongitude = currentDataObjectSet.getCurrentWinchPosition().getLongitude();
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
    //this will clear the current loaded objects.
    public static void Clear()
    {
        instance = null;
    }
    
    public static boolean IsInitialized()
    {
        return(instance != null);
    }
    
    public static boolean IsReady()
    {
        return(instance.complete);
    }

    public void clearPilotWeight()
    {
        if(instance != null) instance.pilotWeight = -1;
        instance.notifyObservers();
    }
    public void clearPilotCapacity()
    {
        if(instance != null) instance.pilotCapacity = -1;
        instance.notifyObservers();
    }
    public void clearPilotPreference()
    {
        if(instance != null) instance.pilotPreference = -1;
        instance.notifyObservers();
    }
    public void clearGliderMaxGrossWeight()
    {
        if(instance != null) instance.gliderMaxGrossWeight = -1;
        instance.notifyObservers();
    }
    public void clearGliderEmptyWeight()
    {
        if(instance != null) instance.gliderEmptyWeight = -1;
        instance.notifyObservers();
    }
    public void clearGliderIndicatedStallSpeed()
    {
        if(instance != null) instance.gliderIndicatedStallSpeed = -1;
        instance.notifyObservers();
    }
    public void clearGliderMaxWinchingSpeed()
    {
        if(instance != null) instance.gliderMaxWinchingSpeed = -1;
        instance.notifyObservers();
    }
    public void clearGliderMaxWeakLinkStrength()
    {
        if(instance != null) instance.gliderMaxWeakLinkStrength = -1;
        instance.notifyObservers();
    }
    public void clearGliderMaxTension()
    {
        if(instance != null) instance.gliderMaxTension = -1;
        instance.notifyObservers();
    }
    public void clearAirfieldAltitude()
    {
        if(instance != null) instance.airfieldAltitude = -1;
        instance.notifyObservers();
    }
    public void clearAirfieldMagneticVariation()
    {
        if(instance != null) instance.airfieldMagneticVariation = -1;
        instance.notifyObservers();
    }
    public void clearAirfieldLatitude()
    {
        if(instance != null) instance.airfieldLatitude = -1;
        instance.notifyObservers();
    }
    public void clearAirfieldLongitude()
    {
        if(instance != null) instance.airfieldLongitude = -1;
        instance.notifyObservers();
    }
    public void clearRunwayMagneticHeading()
    {
        if(instance != null) instance.runwayMagneticHeading = -1;
        instance.notifyObservers();
    }
    public void clearRunwayAltitude()
    {
        if(instance != null) instance.runwayAltitude = -1;
        instance.notifyObservers();
    }
    public void clearGliderPositionAltitude()
    {
        if(instance != null) instance.gliderPositionAltitude = -1;
        instance.notifyObservers();
    }
    public void clearGliderPositionLatitude()
    {
        if(instance != null) instance.gliderPositionLatitude = -1;
        instance.notifyObservers();
    }
    public void clearGliderPositionLongitude()
    {
        if(instance != null) instance.gliderPositionLongitude = -1;
        instance.notifyObservers();
    }
    public void clearWinchPositionAltitude()
    {
        if(instance != null) instance.winchPositionAltitude = -1;
        instance.notifyObservers();
    }
    public void clearWinchPositionLatitude()
    {
        if(instance != null) instance.winchPositionLatitude = -1;
        instance.notifyObservers();
    }
    public void clearWinchPositionLongitude()
    {
        if(instance != null) instance.winchPositionLongitude = -1;
        instance.notifyObservers();
    }
    public void clearDrumCoreDiameter()
    {
        if(instance != null) instance.drumCoreDiameter = -1;
        instance.notifyObservers();
    }
    public void clearDrumKFactor()
    {
        if(instance != null) instance.drumKFactor = -1;
        instance.notifyObservers();
    }
    public void clearDrumCableLength()
    {
        if(instance != null) instance.drumCableLength = -1;
        instance.notifyObservers();
    }
    public void clearDrumEndOffset()
    {
        if(instance != null) instance.drumEndOffset = -1;
        instance.notifyObservers();
    }
    public void clearDrumQuadratureSensor()
    {
        if(instance != null) instance.drumQuadratureSensor = -1;
        instance.notifyObservers();
    }
    public void clearParachuteLift()
    {
        if(instance != null) instance.parachuteLift = -1;
        instance.notifyObservers();
    }
    public void clearParachuteDrag()
    {
        if(instance != null) instance.parachuteDrag = -1;
        instance.notifyObservers();
    }
    public void clearParachuteWeight()
    {
        if(instance != null) instance.parachuteWeight = -1;
        instance.notifyObservers();
    }
    public void clearWindSpeed()
    {
        if(instance != null) instance.windSpeed = -1;
        instance.notifyObservers();
    }
    public void clearWindDirection()
    {
        if(instance != null) instance.windDirection = -1;
        instance.notifyObservers();
    }
    public void clearTemperature()
    {
        if(instance != null) instance.temperature = -1;
        instance.notifyObservers();
    }
    public void clearPressure()
    {
        if(instance != null) instance.pressure = -1;
        instance.notifyObservers();
    }
    public void clearDensityAltitude()
    {
        if(instance != null) instance.densityAltitude = -1;
        instance.notifyObservers();
    }
    public void setPilotWeight(float newPilotWeight)
    {
        if(instance != null)
        {
            instance.pilotWeight = newPilotWeight;
        }
    instance.notifyObservers();
    }
    public void setPilotCapacity(int newPilotCapacity)
    {
        if(instance != null)
        {
            instance.pilotCapacity = newPilotCapacity;
        }
    instance.notifyObservers();
    }
    public void setPilotPreference(int newPilotPreference)
    {
        if(instance != null)
        {
            instance.pilotPreference = newPilotPreference;
        }
    instance.notifyObservers();
    }
    public void setGliderMaxGrossWeight(float newGliderMaxGrossWeight)
    {
        if(instance != null)
        {
            instance.gliderMaxGrossWeight = newGliderMaxGrossWeight;
        }
    instance.notifyObservers();
    }
    public void setGliderEmptyWeight(float newGliderEmptyWeight)
    {
        if(instance != null)
        {
            instance.gliderEmptyWeight = newGliderEmptyWeight;
        }
    instance.notifyObservers();
    }
    public void setGliderIndicatedStallSpeed(float newGliderIndicatedStallSpeed)
    {
        if(instance != null)
        {
            instance.gliderIndicatedStallSpeed = newGliderIndicatedStallSpeed;
        }
    instance.notifyObservers();
    }
    public void setGliderMaxWinchingSpeed(float newGliderMaxWinchingSpeed)
    {
        if(instance != null)
        {
            instance.gliderMaxWinchingSpeed = newGliderMaxWinchingSpeed;
        }
    instance.notifyObservers();
    }
    public void setGliderMaxWeakLinkStrength(float newGliderMaxWeakLinkStrength)
    {
        if(instance != null)
        {
            instance.gliderMaxWeakLinkStrength = newGliderMaxWeakLinkStrength;
        }
    instance.notifyObservers();
    }
    public void setGliderMaxTension(float newGliderMaxTension)
    {
        if(instance != null)
        {
            instance.gliderMaxTension = newGliderMaxTension;
        }
    instance.notifyObservers();
    }
    public void setAirfieldAltitude(float newAirfieldAltitude)
    {
        if(instance != null)
        {
            instance.airfieldAltitude = newAirfieldAltitude;
        }
    instance.notifyObservers();
    }
    public void setAirfieldMagneticVariation(float newAirfieldMagneticVariation)
    {
        if(instance != null)
        {
            instance.airfieldMagneticVariation = newAirfieldMagneticVariation;
        }
    instance.notifyObservers();
    }
    public void setAirfieldLatitude(float newAirfieldLatitude)
    {
        if(instance != null)
        {
            instance.airfieldLatitude = newAirfieldLatitude;
        }
    instance.notifyObservers();
    }
    public void setAirfieldLongitude(float newAirfieldLongitude)
    {
        if(instance != null)
        {
            instance.airfieldLongitude = newAirfieldLongitude;
        }
    instance.notifyObservers();
    }
    public void setRunwayMagneticHeading(float newRunwayMagneticHeading)
    {
        if(instance != null)
        {
            instance.runwayMagneticHeading = newRunwayMagneticHeading;
        }
    instance.notifyObservers();
    }
    public void setRunwayAltitude(float newRunwayAltitude)
    {
        if(instance != null)
        {
            instance.runwayAltitude = newRunwayAltitude;
        }
    instance.notifyObservers();
    }
    public void setGliderPositionAltitude(float newGliderPositionAltitude)
    {
        if(instance != null)
        {
            instance.gliderPositionAltitude = newGliderPositionAltitude;
        }
    instance.notifyObservers();
    }
    public void setGliderPositionLatitude(float newGliderPositionLatitude)
    {
        if(instance != null)
        {
            instance.gliderPositionLatitude = newGliderPositionLatitude;
        }
    instance.notifyObservers();
    }
    public void setGliderPositionLongitude(float newGliderPositionLongitude)
    {
        if(instance != null)
        {
            instance.gliderPositionLongitude = newGliderPositionLongitude;
        }
    instance.notifyObservers();
    }
    public void setWinchPositionAltitude(float newWinchPositionAltitude)
    {
        if(instance != null)
        {
            instance.winchPositionAltitude = newWinchPositionAltitude;
        }
    instance.notifyObservers();
    }
    public void setWinchPositionLatitude(float newWinchPositionLatitude)
    {
        if(instance != null)
        {
            instance.winchPositionLatitude = newWinchPositionLatitude;
        }
    instance.notifyObservers();
    }
    public void setWinchPositionLongitude(float newWinchPositionLongitude)
    {
        if(instance != null)
        {
            instance.winchPositionLongitude = newWinchPositionLongitude;
        }
    instance.notifyObservers();
    }
    public void setDrumCoreDiameter(float newDrumCoreDiameter)
    {
        if(instance != null)
        {
            instance.drumCoreDiameter = newDrumCoreDiameter;
        }
    instance.notifyObservers();
    }
    public void setDrumKFactor(float newDrumKFactor)
    {
        if(instance != null)
        {
            instance.drumKFactor = newDrumKFactor;
        }
    instance.notifyObservers();
    }
    public void setDrumCableLength(float newDrumCableLength)
    {
        if(instance != null)
        {
            instance.drumCableLength = newDrumCableLength;
        }
    instance.notifyObservers();
    }
    public void setDrumEndOffset(float newDrumEndOffset)
    {
        if(instance != null)
        {
            instance.drumEndOffset = newDrumEndOffset;
        }
    instance.notifyObservers();
    }
    public void setDrumQuadratureSensor(float newDrumQuadratureSensor)
    {
        if(instance != null)
        {
            instance.drumQuadratureSensor = newDrumQuadratureSensor;
        }
    instance.notifyObservers();
    }
    public void setParachuteLift(float newParachuteLift)
    {
        if(instance != null)
        {
            instance.parachuteLift = newParachuteLift;
        }
    instance.notifyObservers();
    }
    public void setParachuteDrag(float newParachuteDrag)
    {
        if(instance != null)
        {
            instance.parachuteDrag = newParachuteDrag;
        }
    instance.notifyObservers();
    }
    public void setParachuteWeight(float newParachuteWeight)
    {
        if(instance != null)
        {
            instance.parachuteWeight = newParachuteWeight;
        }
    instance.notifyObservers();
    }
    public void setWindSpeed(float newWindSpeed)
    {
        if(instance != null)
        {
            instance.windSpeed = newWindSpeed;
        }
    instance.notifyObservers();
    }
    public void setWindDirection(float newWindDirection)
    {
        if(instance != null)
        {
            instance.windDirection = newWindDirection;
        }
    instance.notifyObservers();
    }
    public void setTemperature(float newTemperature)
    {
        if(instance != null)
        {
            instance.temperature = newTemperature;
        }
    instance.notifyObservers();
    }
    public void setPressure(float newPressure)
    {
        if(instance != null)
        {
            instance.pressure = newPressure;
        }
    instance.notifyObservers();
    }
    public void setDensityAltitude(float newDensityAltitude)
    {
        if(instance != null)
        {
            instance.densityAltitude = newDensityAltitude;
        }
    instance.notifyObservers();
    }
    public float getPilotWeight()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.pilotWeight;
        }
    }
    public int getPilotCapacity()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.pilotCapacity;
        }
    }
    public int getPilotPreference()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.pilotPreference;
        }
    }
    public float getGliderMaxGrossWeight()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.gliderMaxGrossWeight;
        }
    }
    public float getGliderEmptyWeight()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.gliderEmptyWeight;
        }
    }
    public float getGliderIndicatedStallSpeed()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.gliderIndicatedStallSpeed;
        }
    }
    public float getGliderMaxWinchingSpeed()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.gliderMaxWinchingSpeed;
        }
    }
    public float getGliderMaxWeakLinkStrength()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.gliderMaxWeakLinkStrength;
        }
    }
    public float getGliderMaxTension()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.gliderMaxTension;
        }
    }
    public float getAirfieldAltitude()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.airfieldAltitude;
        }
    }
    public float getAirfieldMagneticVariation()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.airfieldMagneticVariation;
        }
    }
    public float getAirfieldLatitude()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.airfieldLatitude;
        }
    }
    public float getAirfieldLongitude()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.airfieldLongitude;
        }
    }
    public float getRunwayMagneticHeading()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.runwayMagneticHeading;
        }
    }
    public float getRunwayAltitude()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.runwayAltitude;
        }
    }
    public float getGliderPositionAltitude()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.gliderPositionAltitude;
        }
    }
    public float getGliderPositionLatitude()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.gliderPositionLatitude;
        }
    }
    public float getGliderPositionLongitude()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.gliderPositionLongitude;
        }
    }
    public float getWinchPositionAltitude()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.winchPositionAltitude;
        }
    }
    public float getWinchPositionLatitude()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.winchPositionLatitude;
        }
    }
    public float getWinchPositionLongitude()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.winchPositionLongitude;
        }
    }
    public float getDrumCoreDiameter()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.drumCoreDiameter;
        }
    }
    public float getDrumKFactor()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.drumKFactor;
        }
    }
    public float getDrumCableLength()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.drumCableLength;
        }
    }
    public float getDrumEndOffset()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.drumEndOffset;
        }
    }
    public float getDrumQuadratureSensor()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.drumQuadratureSensor;
        }
    }
    public float getParachuteLift()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.parachuteLift;
        }
    }
    public float getParachuteDrag()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.parachuteDrag;
        }
    }
    public float getParachuteWeight()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.parachuteWeight;
        }
    }
    public float getWindSpeed()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.windSpeed;
        }
    }
    public float getWindDirection()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.windDirection;
        }
    }
    public float getTemperature()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.temperature;
        }
    }
    public float getPressure()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.pressure;
        }
    }
    public float getDensityAltitude()
    {
        if(instance == null)
        {
            return -1;
        }
        else
        {
            return instance.densityAltitude;
        }
    }

}
