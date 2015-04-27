/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DashboardInterface;

import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author dbennett3
 */
public class DataSet {
    
    public XYSplineRenderer render;
    public XYDataset dataset;
    public NumberAxis numberAxis;
    
    public DataSet() {
        
    }
    
    public DataSet(String title, int range) {
        render = new XYSplineRenderer();
    }
    
}
