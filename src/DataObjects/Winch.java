/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 * This class stores the relevant data about a drum on the winch
 * 
 * @author  Johnny White, Noah Fujioka
 * @date    11/19/2014
 */
public class Winch{
    private float brakePressure;

    public Winch() {
        //drum = null;
        //parachute = null;
        brakePressure = 0;
    }
    
    public Winch(float brakePressure) {

        this.brakePressure = brakePressure;
    }

    
    public void setBrakePressure(float newBrakePressure) {
        brakePressure = newBrakePressure;
    }
    
    public float getBrakePressure() {
        return brakePressure;
    }
}
