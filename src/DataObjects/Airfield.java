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
public class Airfield {
    String name;
    String designator;
    String location;
    String altitude;
    String magneticVariation;
    String runway;
    String position;
    String magneticHeading;
    String positionMaximumLength;
    String positionSlope;
    String positionCenterlineOffset;
    
    public Airfield(){
    }
    @Override
    public String toString(){
        return name;
    }
    
    public Airfield(String name1, String designator1, String location1, String altitude1, 
                    String magneticVariation1, String runway, String magneticHeading1,
                    String position1, String positionMaximumLength1, String positionSlope1, 
                    String positionCenterlineOffset1){
       name = name1;
       designator = designator1; 
       location = location1;
       altitude = altitude1;
       magneticVariation = magneticVariation1;
       magneticHeading = magneticHeading1;
       position = position1;
       positionMaximumLength = positionMaximumLength1;
       positionSlope = positionSlope1;
       positionCenterlineOffset = positionCenterlineOffset1;
              }
   /**
    * This method can change the name and makes the 
    * name part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  name1  the String that is designated to name 
    *                of the Airfield object
    */
    public void setName(String name1){
        name = name1;
    }
    
   /**
    * Returns an Airfield object name to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the name of Airfield object
    */
    public String getName(){
       return name; 
    }
    
   /**
    * This method can change the designator and makes the 
    * designator part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  designator1  the String that is designated 
    *                      to designator of the Airfield object
    */
    public void setDesignator(String designator1){
        designator = designator1;
    }
    
   /**
    * Returns an Airfield object designator to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the designator of Airfield object
    */
    public String getDesignator(){
       return designator; 
    }
    
   /**
    * This method can change the location and makes the 
    * location part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  location1  the String that is designated to location 
    *                    of the Airfield object
    */
    public void setLocation(String location1){
        location = location1;
    }
    
   /**
    * Returns an Airfield object location.to be displayed 
    * This method always returns immediately,only if airfield exists. 
    * @return      the location of Airfield object
    */
    public String getLocation(){
       return location; 
    }
   /**
    * This method can change the altitude and makes the 
    * altitude part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  altitude1  the String that is designated to altitude 
    *                    of the Airfield object
    */
    public void setAltitude(String altitude1){
        altitude = altitude1;
    }
    
   /**
    * Returns an Airfield object altitude to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the altitude of Airfield object
    */
    public String getAltitude(){
       return altitude; 
    }
    
   /**
    * This method can change the magnetic variation and makes the 
    * magnetic variation part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  magneticVariation1  the String that is designated to
    *                             magnetic variation of the 
    *                             Airfield object
    */
    public void setMagneticVariation(String magneticVariation1){
        magneticVariation = magneticVariation1;
    }
    
   /**
    * Returns an Airfield object magnetic variation to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the magnetic variation of Airfield object
    */
    public String getMagneticVariation(){
       return magneticVariation; 
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
    public void setRunway(String runway1){
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
    
   /**
    * This method can change the magnetic heading and makes the 
    * magnetic heading part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  magneticHeading1  the String that is designated to
    *                           magnetic heading of 
    *                           the Airfield object
    */
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
    
   /**
    * This method can change the position and makes the 
    * position part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  position1  the String that is designated to
    *                    position of the Airfield object
    */
    public void setPosition(String position1){
        position = position1;
    }

   /**
    * Returns an Airfield object position to be displayed.
    * This method always returns immediately,only if airfield exists. 
    * @return      the position of Airfield object
    */
    public String getPosition(){
       return position; 
    }

   /**
    * This method can change the position maximum length and makes the 
    * position Maximum Length part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  positionMaximumLength1  the String that is 
    *                                 designated to position maximum 
    *                                 length of the Airfield object
    */
    public void setPositionMaximumLength(String positionMaximumLength1){
        positionMaximumLength= positionMaximumLength1;
 }
 
   /**
    * Returns an Airfield object position maximum length to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the designator of Airfield object
    */ 
    public String getPositionMaximumLength(){
       return positionMaximumLength; 
    }

/**
 * This method can change the position slope and makes the 
 * position slope part of the Airfield object.
 * This method always works, only if airfield already
 * exists.
 *
 * @param  positionSlope1  the String that is designated to
 *                         position slop of the Airfield object
 */
    public void setPositionSlope(String positionSlope1){
            positionSlope= positionSlope1;
    }
    
   /**
    * Returns an Airfield object position slope to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the position slope of Airfield object
    */    
    public String getPositionSlope(){
           return positionSlope; 
    }
    
   /**
    * This method can change the position centerline offset and 
    * makes the position centerline offset part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  positionCenterlineOffset1  the String that is 
    *                                    designated to position slope of 
    *                                    the Airfield object
    */
    public void setPositionCenterlineOffset(String positionCenterlineOffset1){
        positionCenterlineOffset = positionCenterlineOffset1;
    }
    
   /**
    * Returns an Airfield object position centerline offset to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the position centerline offset of Airfield object
    */   
    public String getPositionCenterlineOffset(){
       return positionCenterlineOffset; 
    }
}
