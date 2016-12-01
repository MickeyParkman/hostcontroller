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
    int id;
    //reg_number of the plane
    String regNumber;
    
    //glider name
    String name;
    
    //name of the owner
    String owner;
    
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
    
    public Sailplane(String regNumber, String name, String owner, String Type,
                     float maximumGrossWeight, float emptyWeight, float indicatedStallSpeed,
                     float maximumWinchingSpeed, float maximumAllowableWeakLinkStrength, float maxTension,
                     float cableReleaseAngle, boolean carryBallast, boolean multipleSeats, String optional){
        this.regNumber = regNumber;
        this.name = name;
        this.owner = owner;
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
    public Sailplane(int id, String regNumber, String name, String owner, String Type,
                     float maximumGrossWeight, float emptyWeight, float indicatedStallSpeed,
                     float maximumWinchingSpeed, float maximumAllowableWeakLinkStrength, float maxTension,
                     float cableReleaseAngle, boolean carryBallast, boolean multipleSeats, String optional){
        this.id = id;
        this.regNumber = regNumber;
        this.name = name;
        this.owner = owner;
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
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public String getRegistration() {
        return regNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public String getOwner() {
        return owner;
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
    
    public boolean getCarryBallast() {
        return carryBallast;
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

    @Override
    public String toString() {
        return name + " " + regNumber + " " + owner;
    }
}
