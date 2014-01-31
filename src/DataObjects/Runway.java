/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 *
 * @author garreola-gutierrez
 */
public class Runway {
    String runway;
    String magneticHeading;
   
    public Runway(){
    }
    @Override
    public String toString(){
        return magneticHeading;
    }
    
    public Runway(String runway1, String magneticHeading1){
       runway = runway1;
       magneticHeading = magneticHeading1;
    }
    
   /**
    * This method can change the runway and makes the 
    * runway part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param runway1  the String that is designated to
    *                 runway of the Airfield object
    */
    public void setRunway1(String runway1){
        runway= runway1;
    }
    
   /**
    * Returns an Airfield object runway to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the runway of Airfield object
    */
    public String getRunway(){
       return runway; 
    }
        public void setMagneticHeading(String magneticHeading1){
        magneticHeading= magneticHeading1;
    }
  /**
    * Returns an Airfield object magnetic heading to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the magnetic heading of Airfield object
    */
    public String getMagneticHeading(){
       return magneticHeading; 
    }
      
}
