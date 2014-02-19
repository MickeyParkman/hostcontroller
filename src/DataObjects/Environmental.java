/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 *
 * @author garreola-gutierrez
 */
public class Environmental {
    int windSpeed;
    String direction;
    int temperature;
    int pressure;
    int  densityAlitude;
    public Environmental(){
        
    }
    public Environmental(int w, String d, int a){
       windSpeed = w;
       direction = d;
       densityAlitude = a;

    }
    
    public void setWindSpeed(int wind){
        windSpeed = wind;    
    }
    
    public int getWindSpeed(){
    return windSpeed;
    }
    
    public void setDirection(String d){
        direction = d;
    }
       
    public String getDirection(){
        return direction;
    }
    
    public void setTemperature(int t){
        temperature = t;
    }
    
    public int getTemperature(){
        return temperature;
    }
    public void setPressure(int p){
        pressure = p;
    }
    public int getPressure(){
        return pressure;
    }
    public void setAltitudeDensity(int a){
        densityAlitude = a;
        
    }
    public int getAltitudeDensity(){
        return densityAlitude;
    }
    public void calculateAltitudeDensity(){
        densityAlitude = pressure + (120 * temperature);
    }
    
}
