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

public class Sailplane {
    String Number;
    String type;
    String owner;
    String contactInformation;
    int maximumGrossWeight;
    int emptyWeight;
    int indicatedStallSpeed;
    int maximumWinchingSpeed;
    int maximumAllowableWeakLinkStrength;
    int maximumTension;
 
    public String toString(){
        return Number;
    
    }
    
    /**
     * Default Constructor 
     */
    public Sailplane(){
    }
    
    /**
     *  Constructor with all part of Sailplane object 
     * @param number                             n-number of sailplane                            
     * @param type1                              type of sailplane 
     * @param owners                             owner of sailplane
     * @param contactInfo                        contact information of sailplane
     * @param maximumGrossWeight1                maximum gross weight of sailplane
     * @param emptyWeight1                       empty weight of sailplane
     * @param indicatedStallSpeed1               indicated stall speed of sailplane
     * @param maximumWinchingSpeed1              maximum winching speed of sailplane
     * @param maximumAllowableWeakLinkStrength1  maximum allowable weak link strength of sailplane
     * @param maximumTension1                    maximum tension of sailplane
     */
    public Sailplane(String number, String type1, String owners, String contactInfo,
          int maximumGrossWeight1, int emptyWeight1, int indicatedStallSpeed1, 
          int maximumWinchingSpeed1, int maximumAllowableWeakLinkStrength1,
          int maximumTension1){
       Number = number;
       type = type1;
       owner = owners;
       contactInformation = contactInfo;
       maximumGrossWeight = maximumGrossWeight1;  
       emptyWeight= emptyWeight1;
       indicatedStallSpeed = indicatedStallSpeed1;
       maximumWinchingSpeed = maximumWinchingSpeed1;
       maximumAllowableWeakLinkStrength = maximumAllowableWeakLinkStrength1;
}  
    
 public Sailplane(String number, String type1,
          int maximumGrossWeight1, int emptyWeight1, int indicatedStallSpeed1, 
          int maximumWinchingSpeed1, int maximumAllowableWeakLinkStrength1,
          int maximumTension1){
       Number = number;
       type = type1;
       maximumGrossWeight = maximumGrossWeight1;  
       emptyWeight= emptyWeight1;
       indicatedStallSpeed = indicatedStallSpeed1;
       maximumWinchingSpeed = maximumWinchingSpeed1;
       maximumAllowableWeakLinkStrength = maximumAllowableWeakLinkStrength1;
} 
    /**
    * This method can change the n-number and makes the 
    * n-number part of the Sailplane object.
    * This method always works, only if sailplane already
    * exists.
    *
    * @param  number1  the String that is designated to n-number 
    *                  of the Sailplane object
    */
    public void setNumber(String number1){
        Number = number1;
    }
    
   /**
    * Returns an Sailplane object n-number to be displayed. 
    * This method always returns immediately,only if sailplane exists. 
    * @return      the n-number of Sailplane object
    */
    public String getNumber(){
       return Number; 
    }
   /**
    * This method can change the type and makes the 
    * type part of the Sailplane object.
    * This method always works, only if sailplane already
    * exists.
    *
    * @param  type1  the String that is designated to type
    *                of the Sailplane object
    */
    public void setType(String type1){
        type = type1;
    }
     
   /**
    * Returns an Sailplane object type to be displayed. 
    * This method always returns immediately,only if sailplane exists. 
    * @return      the type of Sailplane object
    */
    public String getType(){
       return type; 
    }
   /**
    * This method can change the owner and makes the 
    * owner part of the Sailplane object.
    * This method always works, only if sailplane already
    * exists.
    *
    * @param  owners  the String that is designated to owner
    *                of the Sailplane object
    */ 
    public void setOwner(String owners){
       owner = owners;
    }
     
   /**
    * Returns an Sailplane object owner to be displayed. 
    * This method always returns immediately,only if sailplane exists. 
    * @return      the owner of Sailplane object
    */
    public String getOwner(){
       return owner; 
    }
    
   /**
    * This method can change the contact information and makes the 
    * contact information part of the Sailplane object.
    * This method always works, only if sailplane already
    * exists.
    *
    * @param  contactInfo the String that is designated to contact 
    *                     information of the Sailplane object
    */
    public void setContactInformation(String contactInfo){
       contactInformation = contactInfo;
    }
     
   /**
    * Returns an Sailplane object contact information to be displayed. 
    * This method always returns immediately,only if sailplane exists. 
    * @return      the contact information of Sailplane object
    */   
    public String getContactInformation(){
       return contactInformation; 
    }

   /**
    * This method can change the maximum gross weight and makes the 
    * maximum gross weight part of the Sailplane object.
    * This method always works, only if sailplane already
    * exists.
    *
    * @param  maximumGrossWeight1  the int that is designated to the
    *                              maximum gross weight of the Sailplane object
    */
    public void setMaximumGrossWeight(int maximumGrossWeight1){
        maximumGrossWeight  = maximumGrossWeight1;
    }
   
        
   /**
    * Returns an Sailplane object maximum gross weight to be displayed. 
    * This method always returns immediately,only if sailplane exists. 
    * @return      the maximum gross weight of Sailplane object
    */
    public int getMaximumGrossWeight (){
       return maximumGrossWeight ; 
    }  
    
    /**
    * This method can change the empty Weight and makes the 
    * empty weight part of the Sailplane object.
    * This method always works, only if sailplane already
    * exists.
    *
    * @param  emptyWeight1  the int that is designated to empty weight
    *                       of the Sailplane object
    */
    public void setEmptyWeight(int emptyWeight1){
        emptyWeight  = emptyWeight1;
    }
  
        
   /**
    * Returns an Sailplane object empty weight to be displayed. 
    * This method always returns immediately,only if sailplane exists. 
    * @return      the empty weight of Sailplane object
    */
    public int getEmptyWeight(){
       return emptyWeight ; 
    }      
 
   /**
    * This method can change the indicated stall speed and makes the 
    * indicated stall speed part of the Sailplane object.
    * This method always works, only if sailplane already
    * exists.
    *
    * @param  indicatedStallSpeed1  the int that is designated to indicated 
    *                               stall speed of the Sailplane object
    */
    public void setIndicatedStallSpeed(int indicatedStallSpeed1){
       indicatedStallSpeed  = indicatedStallSpeed1;
    }
       
   /**
    * Returns an Sailplane object indicated stall speed to be displayed. 
    * This method always returns immediately,only if sailplane exists. 
    * @return      the indicated stall speed of Sailplane object
    */
    public int getIndicatedStallSpeed(){
       return indicatedStallSpeed ; 
    }  

   /**
    * This method can change maximum winching speed and makes the 
    * maximum winching speed part of the Sailplane object.
    * This method always works, only if sailplane already
    * exists.
    *
    * @param  maximumWinchingSpeed1 the int that is designated to maximum 
    *                               winching speed of the Sailplane object
    */
    public void setMaximumWinchingSpeed(int maximumWinchingSpeed1){
        maximumWinchingSpeed  = maximumWinchingSpeed1;
    }
 
        
   /**
    * Returns an Sailplane object maximum winching speed to be displayed. 
    * This method always returns immediately,only if sailplane exists. 
    * @return      the maximum winching speed of Sailplane object
    */
    public int getMaximumWinchingSpeed(){
       return maximumWinchingSpeed; 
    }      
   
   /**
    * This method can change the maximum allowableWeakLinkStrength and makes the 
    * maximum allowable weak link strength part of the Sailplane object.
    * This method always works, only if sailplane already
    * exists.
    *
    * @param  maximumAllowableWeakLinkStrength1  the int that is designated 
    *                                            to indicated stall speed of 
    *                                            the Sailplane object
    */
    public void setMaximumAllowableWeakLinkStrength(
                int maximumAllowableWeakLinkStrength1){
        maximumAllowableWeakLinkStrength = maximumAllowableWeakLinkStrength1;
    }
         
   /**
    * Returns an Sailplane object maximum allowable weak link strength 
    * to be displayed.This method always returns immediately,only if 
    * sailplane exists. 
    * 
    * @return      the maximum allowableWeakLinkStrength of Sailplane object
    */
    public int getMaximumAllowableWeakLinkStrength(){
       return maximumAllowableWeakLinkStrength; 
    } 
   /**
    * This method can change the maximum tension and makes the 
    * maximum tension part of the Sailplane object.
    * This method always works, only if sailplane already
    * exists.
    *
    * @param  maximumTension1  the int that is designated to maximum Tension
    *                          of the Sailplane object
    */
    public void setMaximumTension(int maximumTension1){
       maximumTension = maximumTension1;
    }
        
   /**
    * Returns an Sailplane object maximum tension to be displayed. 
    * This method always returns immediately,only if sailplane exists. 
    * @return      the maximum tension of Sailplane object
    */
    public int getMaximumTension(){
       return maximumTension; 
    }      
}
