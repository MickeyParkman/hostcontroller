/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

/**
 *
 * @author Matt
 */
public class UnitList {
    public String[] labels;
    public double[] conversionFactors;
    public int size;
    
    public UnitList(int size1)
    {
        size = size1;
        labels = new String[size];
        conversionFactors = new double[size];
        for(int i = 0; i < size; i++)
        {
            labels[i] = "";
        }
    }
    
    public void add(String label, double conversionFactor)
    {
        try{
            int i = 0;
            while(!labels[i].isEmpty())
            {
                i++;
            }
            labels[i] = label;
            conversionFactors[i] = conversionFactor;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("UnitList " + this + " is full");
        }
    }
    
    @Override
    public String toString()
    {
        String retStr = "[";
        for(int i = 0; i < size; i++)
        {
            retStr += " " + labels[i];
        }
        retStr += "]";
        
        return retStr;
    }
}
