/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 *
 * @author Alex
 */
public class DrumParameters {
    private int coreRadius;
    private int cableLength;
    private int kFactor;
    private int endOffset;
    private int quadratureSensor;
    
    public DrumParameters() {
        coreRadius = 0;
        cableLength = 0;
        kFactor = 0;
        endOffset = 0;
        quadratureSensor = 64;
    }
    
    public DrumParameters(int coreRadius, int cableLength, int kFactor,
            int endOffset, int quadratureSensor) {
        this.coreRadius = coreRadius;
        this.cableLength = cableLength;
        this.kFactor = kFactor;
        this.endOffset = endOffset;
        this.quadratureSensor = quadratureSensor;
    }
    
    public void setCoreRadius(int newCoreRadius) {
        coreRadius = newCoreRadius;
    }
    
    public int getCoreRadius() {
        return coreRadius;
    }
    
    public void setCableLength(int newCableLength) {
        coreRadius = newCableLength;
    }
    
    public int getCableLength() {
        return cableLength;
    }
    
    public void setKFactor(int newKFactor) {
        kFactor = newKFactor;
    }
    
    public int getKFactor() {
        return kFactor;
    }
    
    public void setEndOffset(int newEndOffset) {
        endOffset = newEndOffset;
    }
    
    public int getEndOffset() {
        return endOffset;
    }
    
    public void setQuadratureSensor(int newQuadratureSensor) {
        quadratureSensor = newQuadratureSensor;
    }
    
    public int getQuadratureSensor() {
        return quadratureSensor;
    }
}
