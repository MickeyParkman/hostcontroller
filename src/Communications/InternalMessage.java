/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Communications;

import java.util.ArrayList;

/**
 *
 * @author Matt
 */
public class InternalMessage
{

    //  CanMsg data
    //  ??should these be public or private
    public byte[] canMsg;
    public double timestamp;    //  Unix time
    public int state;

    //  launch related data variables
    private double startTime;       //  start time of launch
    private float elapsedTime;      //  time since last launch began
    private float cableOut;         //  cable out (m)
    private float cableSpeed;       //  cable speed (m/s)
    private float cableAngle;       //  cable angle (degrees)
    private float tension;          //  cable tension (N)
    private float controlLever;     //  control lever nom 0.0 - 1.0
    private int activeDrum;         //  active drum system
    private boolean launchActive;   //  true when launch is ongoing

    /**
     * Constructs a new InternalMessage from the original CAN message.
     * <p>
     * This constructor is sufficient to create a message that will be written
     * in the "Log Everything" database. To add other values to an
     * InternalMessage, use their corresponding "setter" functions.
     *
     * @param id int value representing the ID of the message
     * @param payload array of bytes containing the message's value
     */
    public InternalMessage()
    {

    }
    /*
     public InternalMessage(byte[] rawMessage, float timestamp, float cableOut, float cableSpeed, float cabelAngle, float tension, int state)
     {
     this.id = id;
     this.canMsg = rawMessage;
     this.timestamp = timestamp;
     this.cableOut = cableOut;
     this.cableSpeed = cableSpeed;
     this.cableAngle = cabelAngle;
     this.tension = tension;
     this.state = state;
     }

     public InternalMessage(float timestamp, float cableOut, float cableSpeed, float cabelAngle, float tension, int state)
     {
     this.timestamp = timestamp;
     this.cableOut = cableOut;
     this.cableSpeed = cableSpeed;
     this.cableAngle = cabelAngle;
     this.tension = tension;
     this.state = state;
     }
     */

    //  ?? suggest logRawMessage
    public void setRawMessage(byte[] canMessage)
    {
        this.canMsg = canMessage;
    }

    /**
     * Sets the value of the "timestamp" data member
     *
     * @param timestamp the timestamp of the message, in UNIX time
     */
    public void setTimestamp(float timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setCableOut(float cableOut)
    {
        this.cableOut = cableOut;
    }

    public void setCableSpeed(float cableSpeed)
    {
        this.cableSpeed = cableSpeed;
    }

    public void setCableAngle(float cableAngle)
    {
        this.cableAngle = cableAngle;
    }

    public void setTension(float tension)
    {
        this.tension = tension;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public void setStartTime(double time)
    {
        this.startTime = time;
    }
    
    public void setElaspedTime(double time)
    {
        this.elapsedTime = time;
    }
    public void setActiveDrum(int drum)
    {
        this.activeDrum = drum;
    }
    
    public void setLauchActive(boolean active)
    {
        this.launchActive = active;
    }
    public void setControlLever(float position)
    {
        this.controlLever = position;
    }
    

    /**
     * Method for acquiring the value of the message's timestamp.
     *
     * @return the timestamp value, if set, null if otherwise.
     */
    public double getTimestamp()
    {
        return timestamp;
    }

    public float getCableOut()
    {
        return cableOut;
    }

    public float getCableSpeed()
    {
        return cableSpeed;
    }

    public float getCableAngle()
    {
        return cableAngle;
    }

    public float getTension()
    {
        return tension;
    }
    public double getStartTime()
    {
        return startTime;
    }
    
    public float getElaspedTime()
    {
        return elapsedTime;
    }
    public int getActiveDrum()
    {
        return activeDrum;
    }
    
    public boolean getLaunchActive()
    {
        return launchActive;
    }
    
    public float getControlLever()
    {
        return controlLever;
    }

}
