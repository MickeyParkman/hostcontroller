/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 * This class stores the relevant data about a drum on the winch
 * 
 * @author  Johnny White
 * @date    11/19/2014
 */
public class WinchParameters {
    private DrumParameters drum;
    private Parachute parachute;
    private float brakePressure;
    private float batteryVoltage;

    public WinchParameters() {
        drum = null;
        parachute = null;
        brakePressure = 0;
        batteryVoltage = 0;
    }
    
    public WinchParameters(int coreRadius, int cableLength, int kFactor, int endOffset, int quadratureSensor) {
        this.drum = coreRadius;
        this.parachute = cableLength;
        this.brakePressure = brakePressure;
        this.batteryVoltage = batteryVoltage;
    }
    
    public void setDrum(DrumParameters newDrum) {
        drum = newDrum;
    }
    
    public int getDrum() {
        return drum;
    }
    
    public void setParachute(Parachute newParachute) {
        parachute = newParachute;
    }
    
    public int getParachute() {
        return parachute;
    }
    
    public void setParachute(float newBrakePressure) {
        brakePressure = newBrakePressure;
    }
    
    public float getBrakePressure() {
        return brakePressure;
    }
    public void setParachute(float newBatteryVoltage) {
        batteryVoltage = newBatteryVoltage;
    }
    
    public float getBatteryVoltage() {
        return batteryVoltage;
    }    
}
