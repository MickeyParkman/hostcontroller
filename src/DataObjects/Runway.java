/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 *
 * @author garreola-gutierrez, matt dargen
 */
public class Runway {
    Airfield parent;
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
    * This method can change the Airfield parent of a Runway object
    * This method always works, only if Runway already
    * exists.
    *
    * @param parent1  the Airfield this runway belongs to
    */
    public void setParent(Airfield parent1){
        parent = parent1;
    }
    
   /**
    * Returns the Airfield object this Runway belongs to. 
    * This method always returns immediately, only if Runway exists. 
    * @return      the parent of the Runway object
    */
    public Airfield getParent(){
       return parent; 
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
