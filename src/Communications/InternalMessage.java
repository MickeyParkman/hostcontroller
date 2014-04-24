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
public class InternalMessage {
    
    private byte[] canMsg;
    private int id;
    private float timestamp;
    private float cableOut;
    private float cableSpeed;
    private float cableAngle;
    private float tension;
    private int state;
    
    /**
     * Constructs a new InternalMessage from the original CAN message.
     * <p>
     * This constructor is sufficient to create a message that will be written
     * in the "Log Everything" database.  To add other values to an InternalMessage,
     * use their corresponding "setter" functions.
     * 
     * @param id int value representing the ID of the message
     * @param payload array of bytes containing the message's value
     */
    public InternalMessage(int id, byte[] payload)
    {
        this.id = id;
        this.canMsg = payload;
    }
    
    public InternalMessage(int id, byte[] rawMessage, float timestamp, float cableOut, float cableSpeed, float cabelAngle, float tension, int state) {
        this.id = id;
        this.canMsg = rawMessage;
        this.timestamp = timestamp;
        this.cableOut = cableOut;
        this.cableSpeed = cableSpeed;
        this.cableAngle = cabelAngle;
        this.tension = tension;
        this.state = state;
    }
    
    public InternalMessage(float timestamp, float cableOut, float cableSpeed, float cabelAngle, float tension, int state) {
        this.timestamp = timestamp;
        this.cableOut = cableOut;
        this.cableSpeed = cableSpeed;
        this.cableAngle = cabelAngle;
        this.tension = tension;
        this.state = state;
    }
    
    public void setRawMessage(byte[] canMessage) {
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
    
    public void setCableOut(float cableOut) {
        this.cableOut = cableOut;
    }
    
    public void setCableSpeed(float cableSpeed) {
        this.cableSpeed = cableSpeed;
    }
    
    public void setCableAngle(float cableAngle) {
        this.cableAngle = cableAngle;
    }
    
    public void setTension(float tension) {
        this.tension = tension;
    }
    
    public void setState(int state) {
        this.state = state;
    }
    
    /**
     * Method for acquiring the value of the message's timestamp.
     * 
     * @return the timestamp value, if set, null if otherwise.
     */
    public float getTimestamp()
    {
        return timestamp;
    }
    
    public float getCableOut() {
        return cableOut;
    }

    public float getCableSpeed() {
        return cableSpeed;
    }
    
    public float getCableAngle() {
        return cableAngle;
    }
    
    public float getTension() {
        return tension;
    }
    
}
