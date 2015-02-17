package DataObjects;

public class Drum {
    
    private float coreDiameter;
    private float kFactor;
    private float cableLength;
    private int numLaunches;
    private String name;


    public Drum()
    {

    }
    
    public Drum(String n, float cD, float kF, float cL) {
        name = n;
        coreDiameter = cD;
        kFactor = kF;
        cableLength = cL;
    }
    
    public String toString() {
        return name;
    }
    
    public String getName() {
        return name;
    }
    
    public float getKFactor() {
        return kFactor;
    }   
    
    public float getCableLength() {
        return cableLength;
    }   
    
    public float getCoreDiameter() {
        return coreDiameter;
    }    
    
    public int getNumLaunches() {
        return numLaunches;
    }
}