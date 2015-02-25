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
    //n_number of the plane
    String nNumber;
    
    //type of the plane
    String type;
    
    //max gross weight of the plane
    int maximumGrossWeight;
    
    //empty weight of the plane
    int emptyWeight;
    
    //stall speed of the plane
    int indicatedStallSpeed;
    
    //max winching speed of the plane
    int maximumWinchingSpeed;
    
    //max weak link of the plane
    int maximumAllowableWeakLinkStrength;
    
    //max tension of the plane
    int maximumTension;
    
    //cable release angle of the plane
    int cableReleaseAngle;
    
    //boolean on whether or not the plane can carry ballast
    boolean carryBallast;
    
    //boolean on whether or not the plane can carry passengers
    boolean multipleSeats;
    
    //optional info on the plane
    String optionalInfo;
    
    int ballast;
    
    /**
     * Default Constructor
     */
    public Sailplane(){
    }
    
    public Sailplane(String nNumber, String Type,
                     int maximumGrossWeight, int emptyWeight, int indicatedStallSpeed,
                     int maximumWinchingSpeed, int maximumAllowableWeakLinkStrength, int maxTension,
                     int cableReleaseAngle, boolean carryBallast, boolean multipleSeats, String optional){
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
    
    public String getNumber() {
        return nNumber;
    }     
    
    public String getType() {
        return type;
    }
    
    public int getMaxGrossWeight() {
        return maximumGrossWeight;
    }
    
    public int getEmptyWeight() {
        return emptyWeight;
    }
    
    public int getIndicatedStallSpeed() {
        return indicatedStallSpeed;
    }
    
    public int getMaxWinchingSpeed() {
        return maximumWinchingSpeed;
    }
    
    public int getMaxWeakLinkStrength() {
        return maximumAllowableWeakLinkStrength;
    }
    
    public int getMaxTension() {
        return maximumTension;
    }
    
    public int getCableReleaseAngle() {
        return cableReleaseAngle;
    }
    
    public int getMaximumGrossWeight(){
        return maximumGrossWeight;
    }
    
    public int getMaximumWinchingSpeed(){
        return maximumWinchingSpeed;
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
    
    public int getBallastWeight() {
        return ballast;
    }
    
    public void addBallast(int ballast) {
        this.ballast += ballast;
    }

    public String toString() {
        return nNumber;
    }
}
