package DataObjects;

public class Drum {
    
    private int drumId; //should be same as drum number
    private int winchId;
    private String name;
    private float coreDiameter;
    private float kFactor;
    private float cableLength;
    private float cableDensity;
    private float systemEquivalentMass;
    private int numLaunches;
    private float maxTension;
    private String info;
    
    private Parachute para;
    private Drive drive;


    public Drum()
    {

    }
    
    public Drive getDrive()
    {
        return drive;
    }
    
    public void setDrive(Drive d)
    {
        drive = d;
    }
    
    public Drum(int id, int wid, String n, float cDi, float kF, float cL, 
            float cDe, float dsem, int num, float mt, String info) {
        drumId = id;
        winchId = wid;
        name = n;
        coreDiameter = cDi;
        kFactor = kF;
        cableLength = cL;
        cableDensity = cDe;
        systemEquivalentMass = dsem;
        numLaunches = num;
        maxTension = mt;
        this.info = info;
    }
    
    public Drum(String n, float cD, float kF, float cL, float mt, String info) {
        name = n;
        coreDiameter = cD;
        kFactor = kF;
        cableLength = cL;
        numLaunches = 0;
        maxTension = mt;
        this.info = info;
    }
    
    public void setId(int i) {
        drumId = i;
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
        if(para == null) 
            return drive.getName() + " - " + name + " (NO PARACHUTE)";
        else 
            return drive.getName() + " - " + name + " (" + para.getName() + ")";
    }
    
    public int getId() {
        return drumId;
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
    
    public int getWinchId() {
        return winchId;
    }
    
    public float getMaxTension() {
        return maxTension;
    }
    
    public String getOptionalInfo() {
        return info;
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

    public float getSystemEquivalentMass() {
        return systemEquivalentMass;
    }

    public float getCableDensity() {
        return cableDensity;
    }
}