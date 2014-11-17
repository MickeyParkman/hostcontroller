/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataObjects;

/**
 *  This class stores data about the parachute
 * 
 * @author Alec Jacuzzi
 */
public class Parachute {
    private int parachuteNumber;    //Parachute ID number
    private float lift;             //Parachute lift
    private float drag;             //Parachute drag
    
    public Parachute() {
        //Parachute ID number
        parachuteNumber = 0;
        lift = 0;
        drag = 0;
    }
    
    public Parachute(int initialParachuteNumber, float initialLift, float initialDrag) {
        parachuteNumber = initialParachuteNumber;
        lift = initialLift;
        drag = initialDrag;
    }
    
    /**
    * This method can change the parachute ID number of a Parachute object.
    * This method always works, only if Parachute already
    * exists.
    *
    * @param  newParachuteNumber  the int that is used to identify 
    *                of the Parachute object
    */
    public void setParachuteNumber(int newParachuteNumber) {
        parachuteNumber = newParachuteNumber;
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
    
    /**
    * Returns a Parachute object parachute ID number. 
    * This method always returns immediately,only if Parachute exists. 
    * @return      the parachute ID number of the Parachute object
    */
    public int getParachuteNumber() {
        return parachuteNumber;
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
}
