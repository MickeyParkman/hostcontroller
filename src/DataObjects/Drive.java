package DataObjects;

import java.util.ArrayList;
import java.util.List;

public class Drive {

    private float reductionRatio;
    private List<Drum> drumList;
    private String name;


    public Drive()
    {
        drumList = new ArrayList<>();
    }
    
    public Drive(String nameIn) {
        drumList = new ArrayList<>();        
        name = nameIn;
    }
    
    public void addDrum(Drum drum) {
        drumList.add(drum);
    }

    public String getName()
    {
        return name;
    }

    public List<Drum> getDrumList()
    {
        return drumList;
    }
}