package DataObjects;

public class Drum {
    
    private float coreDiameter;
    private float kFactor;
    private float cableLength;
    private int numLaunches;
    private String name;
    private Parachute para;
    private Drive drive;


    public Drum()
    {

    }
    
    public void setDrive(Drive d)
    {
        drive = d;
    }
    
    public Drum(String n, float cD, float kF, float cL) {
        name = n;
        coreDiameter = cD;
        kFactor = kF;
        cableLength = cL;
    }
    
    public void setName(String s)
    {
        name = s;
    }
    
    public void setCoreDiameter(float cd)
    {
        coreDiameter = cd;
    }
    
    public void setKFactor(float k)
    {
        kFactor = k;        
    }
    
    public void setCableLength(float cl)
    {
        cableLength = cl;
    }
    
    public String toString() {
        if(para == null) return drive.getName() + " - " + name + " (NO PARACHUTE)";
        else return drive.getName() + " - " + name + " (" + para.getName() + ")";
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
    
    public Parachute getParachute() {
        return para;
    }
    
    public void setParachute(Parachute parachute) {
        para = parachute;
        CurrentDataObjectSet.getCurrentDataObjectSet().forceUpdate();
    }
    
    public void clearParachute()
    {
        para = null;
        CurrentDataObjectSet.getCurrentDataObjectSet().forceUpdate();
    }
}