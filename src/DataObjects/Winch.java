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
    private List<Parachute> paraList;

    public Winch() {
        driveList = new ArrayList<>();
        paraList = new ArrayList<>();
        name = "";
        optionalData = "";
        brakePressure = 0;
    }
    
    public Winch(String nameIn, String opt, float brake) {
        driveList = new ArrayList<>();
        paraList = new ArrayList<>();
        name = nameIn;
        optionalData = opt;
        brakePressure = brake;
    }
    
    public void setBrakePressure(float newBrakePressure) {
        brakePressure = newBrakePressure;
    }

    public void setName(String nameIn)
    {
        name = nameIn;
    }
    
    public void addDrive(Drive drive) {
        driveList.add(drive);
    }
    
    public void addParachute(Parachute p) {
        paraList.add(p);
    }

    public void setOptionalData(String opt)
    {
        optionalData = opt;
    }
    
    public float getBrakePressure() {
        return brakePressure;
    }
    
    public String getOptionalData() {
        return optionalData;
    }

    public List<Drive> getDriveList()
    {
        return driveList;
    }
    
    public List<Parachute> getParachuteList()
    {
        return paraList;
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
    
    public String toString()
    {
        return name;
    }
    
    public String getName() {
        return name;
    }
}
