/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * This class stores the relevant data about a drum on the winch
 * 
 * @author  Johnny White, Noah Fujioka
 * @date    11/19/2014
 */
public class Winch {
    private float brakePressure;
    private String name;
    private String optionalData;
    private List<Drive> driveList;

    public Winch() {
        driveList = new ArrayList<Drive>();
        name = "";
        optionalData = "";
        brakePressure = 0;
    }

    
    public void setBrakePressure(float newBrakePressure) {
        brakePressure = newBrakePressure;
    }

    public void setName(String nameIn)
    {
        name = nameIn;
    }

    public void setOptionalData(String opt)
    {
        optionalData = opt;
    }
    
    public float getBrakePressure() {
        return brakePressure;
    }

    public List<Drive> getDriveList()
    {
        return driveList;
    }

    public List<Drum> getDrumsForDrive(String driveName)
    {
        for(Drive drive : driveList)
        {
            if(driveName.equals(drive.getName()))
            {
                return drive.getDrumList();
            }
        }
        return null;
    }
}
