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
public class Positions {
    String position;
    String positionMaximumLength;
    String positionSlope;
    String positionCenterlineOffset;
    
    public Positions(){
    }
    @Override
    public String toString(){
        return positionMaximumLength;
    }
    
    public Positions(String position1, String positionMaximumLength1, String positionSlope1, 
                    String positionCenterlineOffset1){
       position = position1;
       positionMaximumLength = positionMaximumLength1;
       positionSlope = positionSlope1;
       positionCenterlineOffset = positionCenterlineOffset1;
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

    
