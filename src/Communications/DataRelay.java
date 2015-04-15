package Communications;

import java.util.ArrayList;

public class DataRelay
{
    private ArrayList<Observer> TensionListeners;
    private ArrayList<Observer> TorqueListeners;
    private ArrayList<Observer> CableSpeedListeners;
    private ArrayList<Observer> CableAngleListeners;
    private ArrayList<Observer> CableOutListeners;    
    private ArrayList<Observer> StateListeners;
            
    public DataRelay()
    {
        TensionListeners = new ArrayList<>();
        TorqueListeners = new ArrayList<>();
        CableSpeedListeners = new ArrayList<>();
        CableAngleListeners = new ArrayList<>();
        CableOutListeners = new ArrayList<>();
        StateListeners = new ArrayList<>();
    }
    
    public void attach(String type, Observer o)
    {
        switch(type)
        {
            case "TENSION":
                TensionListeners.add(o);
                break;
            case "SPEED":
                CableSpeedListeners.add(o);
                break;
            case "TORQUE":
                TorqueListeners.add(o);
                break;
            case "ANGLE":
                CableAngleListeners.add(o);
                break;
            case "OUT":
                CableOutListeners.add(o);
                break;
            case "STATE":
                StateListeners.add(o);
                break;
        }
    }

    public void sendTimeMessage(){}

    public void sendState(int currentState, int activeDrum)
    {
        for(Observer o : StateListeners)
        {
            o.update("STATE;"+String.valueOf(currentState));
        }    
    }

    public void sendUnknownMessage(){}

    public void sendFilteredData(float[] data, float groupDelay)
    {
        //0-torque, 1-tension, 2-cable_speed, 3-cable_angle, 4-cable_out
        for(Observer o : TensionListeners)
        {
            o.update("TENSION;"+String.valueOf(data[1]));
        }
        for(Observer o : TorqueListeners)
        {
            o.update("TORQUE;"+String.valueOf(data[0]));
        }
        for(Observer o : CableSpeedListeners)
        {
            o.update("SPEED;"+String.valueOf(data[2]));
        }
        for(Observer o : CableAngleListeners)
        {
            o.update("ANGLE;"+String.valueOf(data[3]));
        }
        for(Observer o : CableOutListeners)
        {
            o.update("OUT;"+String.valueOf(data[4]));
        }
    }
}