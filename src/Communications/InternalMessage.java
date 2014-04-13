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
    private Integer timestamp = null;
    private ArrayList<MotorData> motors = null;
    
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
    
    /**
     * Sets the value of the "timestamp" data member
     * 
     * @param timestamp the timestamp of the message, in UNIX time
     */
    public void setTimestamp(int timestamp)
    {
        this.timestamp = new Integer(timestamp);
    }
    
    /**
     * Method for acquiring the value of the message's timestamp.
     * 
     * @return the timestamp value, if set, null if otherwise.
     */
    public Integer getTimestamp()
    {
        return timestamp;
    }
    
    public void addBattery(int motorNum, int batteryNum, float voltage)
    {
        if (motors == null)
        {
            motors = new ArrayList();
            motors.add(new MotorData(motorNum));
            motors.get(0).addBattery(batteryNum, voltage);
        }else{
            int i = 0;
            for(MotorData m: motors)
            {
               if(m.getMotorNum() < motorNum){ 
                   continue; 
               }else if(m.getMotorNum() == motorNum){
                   m.addBattery(batteryNum, voltage);
                   break;
               }else{
                   motors.add(i, new MotorData(motorNum));
                   motors.get(i).addBattery(batteryNum, voltage);
               }
               i++;
            }
        }
    }
}
