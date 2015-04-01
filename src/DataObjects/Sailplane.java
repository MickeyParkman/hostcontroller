/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 * This Class stores the data about a Sailplane
 * 
 * @author garreola-gutierrez, dbennett3
 */

public class Sailplane {
    String id;
    //n_number of the plane
    String nNumber;
    
    //type of the plane
    String type;
    
    //max gross weight of the plane
    float maximumGrossWeight;
    
    //empty weight of the plane
    float emptyWeight;
    
    //stall speed of the plane
    float indicatedStallSpeed;
    
    //max winching speed of the plane
    float maximumWinchingSpeed;
    
    //max weak link of the plane
    float maximumAllowableWeakLinkStrength;
    
    //max tension of the plane
    float maximumTension;
    
    //cable release angle of the plane
    float cableReleaseAngle;
    
    //boolean on whether or not the plane can carry ballast
    boolean carryBallast;
    
    //boolean on whether or not the plane can carry passengers
    boolean multipleSeats;
    
    //optional info on the plane
    String optionalInfo;
    
    float ballast;
    
    /**
     * Default Constructor
     */
    public Sailplane(){
    }
    
    public Sailplane(String nNumber, String Type,
                     float maximumGrossWeight, float emptyWeight, float indicatedStallSpeed,
                     float maximumWinchingSpeed, float maximumAllowableWeakLinkStrength, float maxTension,
                     float cableReleaseAngle, boolean carryBallast, boolean multipleSeats, String optional){
        this.nNumber = nNumber;
        this.type = Type;
        this.maximumGrossWeight = maximumGrossWeight;
        this.emptyWeight= emptyWeight;
        this.indicatedStallSpeed = indicatedStallSpeed;
        this.maximumWinchingSpeed = maximumWinchingSpeed;
        this.maximumAllowableWeakLinkStrength = maximumAllowableWeakLinkStrength;
        this.maximumTension = maxTension;
        this.cableReleaseAngle = cableReleaseAngle;
        this.carryBallast = carryBallast;
        this.multipleSeats = multipleSeats;
        this.optionalInfo = optional;
        
        ballast = 0;
    }
    
    public String getId(){
        if (id != null){
            return id;
        }
        else{
            return id;
        }
    }
    
    public void setId(String newId){
        id = newId;
    }
    
    public String getNumber() {
        return nNumber;
    }     
    
    public String getType() {
        return type;
    }
    
    public float getMaxGrossWeight() {
        return maximumGrossWeight;
    }
    
    public float getEmptyWeight() {
        return emptyWeight;
    }
    
    public float getIndicatedStallSpeed() {
        return indicatedStallSpeed;
    }
    
    public float getMaxWinchingSpeed() {
        return maximumWinchingSpeed;
    }
    
    public float getMaxWeakLinkStrength() {
        return maximumAllowableWeakLinkStrength;
    }
    
    public float getMaxTension() {
        return maximumTension;
    }
    
    public float getCableReleaseAngle() {
        return cableReleaseAngle;
    }
    
    public float getMaximumGrossWeight(){
        return maximumGrossWeight;
    }
        
    public int storeCarryBallast() {
        if (carryBallast)
            return 1;
        return 0;
    }
    
    public static boolean returnCarryBallast(int cBallast) {
        if(cBallast == 0)
            return false;
        else if(cBallast == 1)
            return true;
        return false;
    }
    
    public boolean getCarryBallast() {
        return carryBallast;
    }
    
    public int storeMultipleSeats() {
        if (multipleSeats)
            return 1;
        return 0;
    }
    
    public static boolean returnMultipleSeats(int cMultipleSeats) {
        if(cMultipleSeats == 0)
            return false;
        else if(cMultipleSeats == 1)
            return true;
        return false;
    }
    
    public boolean getMultipleSeats() {
        return multipleSeats;
    }
    
    public String getOptionalInfo() {
        return optionalInfo;
    }
    
    public float getBallastWeight() {
        return ballast;
    }
    
    public void addBallast(float ballast) {
        this.ballast += ballast;
    }

    public String toString() {
        return nNumber;
    }
}
