/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataObjects;

/**
 *  This class stores data about the parachute
 * 
 * @author Alec Jacuzzi, dbennett3
 */
public class Parachute {
    private int parachuteId;
    private String name;
    private float lift;
    private float drag;
    private float weight;
    private String info;
    
    
    public Parachute() {
        //Parachute ID number
        parachuteId = 0;
        lift = 0;
        drag = 0;
        weight = 0;
    }
    
    public Parachute(int id, String n, float initialLift, float initialDrag, float initialWeight, String info) {
        this.parachuteId = id;
        lift = initialLift;
        drag = initialDrag;
        weight = initialWeight;
        name = n;
        this.info = info;
    }
    
    public Parachute(float initialLift, float initialDrag, float initialWeight, String info) {
        lift = initialLift;
        drag = initialDrag;
        weight = initialWeight;
        this.info = info;
    }
    
    /**
    * This method can change the parachute ID number of a Parachute object.
    * This method always works, only if Parachute already
    * exists.
    *
    * @param  newParachuteNumber  the int that is used to identify 
    *                of the Parachute object
    */
    public void setParachuteId(int newParachuteNumber) {
        parachuteId = newParachuteNumber;
    }
    
    /**
    * This method can change the lift of a Parachute object.
    * This method always works, only if Parachute already
    * exists.
    *
    * @param  newLift  the float that is contains the parachute lift
    */
    public void setLift(float newLift) {
        lift = newLift;
    }
    
    public void setWeight(float w)
    {
        weight = w;
    }
    
    /**
    * This method can change the drag of a Parachute object.
    * This method always works, only if Parachute already
    * exists.
    *
    * @param  newDrag  the float that contains the drag
    */
    public void setDrag(float newDrag) {
        drag = newDrag;
    }
    
    public void setName(String s)
    {
        name = s;
    }
    
    /**
    * Returns a Parachute object lift. 
    * This method always returns immediately,only if Parachute exists. 
    * @return      the lift of the Parachute object
    */
    public float getLift() {
        return lift;
    }
    
    /**
    * Returns a Parachute object drag. 
    * This method always returns immediately,only if Parachute exists. 
    * @return      the drag of the Parachute object
    */
    public float getDrag() {
        return drag;
    }
    
    public float getWeight() {
        return weight;
    }
    
    public int getParachuteId() {
        return parachuteId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getInfo() {
        return info;
    }
    
    public String toString() {
        return name;
    }
}
