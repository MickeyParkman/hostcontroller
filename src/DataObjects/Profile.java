/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataObjects;

import java.util.HashMap;
/**
 *  This Class stores the data about an operator
 *  Includes his desired settings.
 * 
 * @author jtroxel
 */
public class Profile {
    private String id;
    private HashMap<String,Integer> unitSettings;
    private HashMap<String,Integer> displayPrefs;

    public Profile(String id, String settings, String prefs) {
        unitSettings = new HashMap<String, Integer>();
        displayPrefs = new HashMap<String, Integer>();
        this.id = id;
        initSettingsFromString(settings, prefs);
    }
    
    private void initSettingsFromString(String settings, String prefs) {
        if(!settings.equals("")) {
            /* settings could be "{'PILOT_WEIGHT':0,'SAILPLANE_WEIGHT':1}" */
            settings = settings.replace("{","");
            settings = settings.replace("}","");
            String[] settingsArray = settings.split(","); //["'PILOT_WEIGHT':0"]
            for (String setting : settingsArray) {
                int hashValue = 0;
                String[] settingArray = setting.split(":");
                String hashId = settingArray[0].replace("'","");
                try {
                    hashValue = Integer.parseInt(settingArray[1]);
                } catch (NumberFormatException nfe) {
                    // for now, do nothing;
                }
                unitSettings.put(hashId.toUpperCase(), hashValue);
            }
        }

        if(!prefs.equals("")) {
            prefs = prefs.replace("{","");
            prefs = prefs.replace("}","");
            String[] prefsArray = prefs.split(","); //["'PILOT_WEIGHT':0"]
            for (String pref : prefsArray) {
                int hashValue = 0;
                String[] prefArray = pref.split(":");
                String hashId = prefArray[0].replace("'","");
                try {
                    hashValue = Integer.parseInt(prefArray[1]);
                } catch (NumberFormatException nfe) {
                    // for now, do nothing;
                }
                displayPrefs.put(hashId.toUpperCase(), hashValue);
            }
        }
    }

    public void setUnitSetting(String id, int value) {
        unitSettings.put(id, value);
    }   

    public void setDisplayPref(String id, int value) {
        displayPrefs.put(id, value);
    }

    public int getUnitSetting(String id) {
        if (unitSettings.containsKey(id)) return unitSettings.get(id);
        else return -1;
    }
  
    public int getDisplayPref(String id) {
        if (displayPrefs.containsKey(id)) return displayPrefs.get(id);
        else return -1;
    }

    public String getUnitSettingsForStorage() {
        String result = "{";
        for (int i = 0; i < unitSettings.size(); i++) {
            String id = (String) unitSettings.keySet().toArray()[i];
            result += "'" + id + "':";
            result += Integer.toString(unitSettings.get(id));
            if (i != unitSettings.size() - 1) {
                result += ",";
            }
        }
        result += "}";
        return result;
    }

    public String getDisplayPrefsForStorage() {
        String result = "{";
        for (int i = 0; i < displayPrefs.size(); i++) {
            String id = (String) displayPrefs.keySet().toArray()[i];
            result += "'" + id + "':";
            result += Integer.toString(displayPrefs.get(id));
            if (i != displayPrefs.size() - 1) {
                result += ",";
            }
        }
        result += "}";
        return result;  
    }
    
    public String getID() {
        return id;
    }

    @Override
    public String toString() { 
        return (id);
    }
}
