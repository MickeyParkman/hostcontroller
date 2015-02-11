package DataObjects;

import java.util.List;

public class Drive {

    private float reductionRatio;
    private List<Drum> drumList;
    private String name;


    public Drive()
    {
        drumList = new ArrayList<Drum>();
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