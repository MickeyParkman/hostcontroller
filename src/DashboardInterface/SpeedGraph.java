/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DashboardInterface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.Layer;

/**
 *
 * @author Alex
 */
public class SpeedGraph extends JPanel implements Runnable {
    private final long serialVersionUID = 1L;
    TimeSeriesCollection heightDataset = new TimeSeriesCollection();
    TimeSeriesCollection speedDataset = new TimeSeriesCollection();
    TimeSeriesCollection tensionDataset = new TimeSeriesCollection();
    TimeSeries tensionTimeSeries = new TimeSeries("Tension ");
    TimeSeries speedTimeSeries = new TimeSeries("Speed ");
    TimeSeries heightTimeSeries = new TimeSeries("Height ");
    
     public SpeedGraph(String title) {
        ChartPanel chartPanel = (ChartPanel) createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 270));
        add(chartPanel);
        Thread t = new Thread(this);
        t.start();
    }
     
     /**
     * Creates a chart.
     *
     * @param dataset  a dataset.
     *
     * @return A chart.
     */
    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
            "Speed v Time:",  // title
            "Time",             // x-axis label
            "Speed",   // y-axis label
            dataset,            // data
            PlotOrientation.VERTICAL,
            true,               // create legend?
            true,               // generate tooltips?
            false               // generate URLs?
        );

        chart.setBackgroundPaint(Color.white);

        XYPlot plot = chart.getXYPlot();
        XYSplineRenderer splinerenderer1 = new XYSplineRenderer();
        XYSplineRenderer splinerenderer2 = new XYSplineRenderer();
        XYSplineRenderer splinerenderer3 = new XYSplineRenderer();
        

        XYDataset dataset1 = createDataset(0L, 70000);
        plot.setDataset(0,dataset1);
        plot.setRenderer(0,splinerenderer1);
        DateAxis domainAxis = new DateAxis("Date");
        plot.setDomainAxis(domainAxis);
        plot.setRangeAxis(new NumberAxis("Height"));
    
        XYDataset dataset2 = createDataset2();
        plot.setDataset(1, dataset2);
        plot.setRenderer(1, splinerenderer2);
        plot.setRangeAxis(1, new NumberAxis("Speed"));
    
        XYDataset dataset3 = createDataset3();
        plot.setDataset(2, dataset3);
        plot.setRenderer(2, splinerenderer3);
        plot.setRangeAxis(2, new NumberAxis("Tension"));

        plot.mapDatasetToRangeAxis(0, 0);//1st dataset to 1st y-axis
        plot.mapDatasetToRangeAxis(1, 1); //2nd dataset to 2nd y-axis
        plot.mapDatasetToRangeAxis(2, 2);
    
        plot.addRangeMarker(new ValueMarker(100, Color.RED, new BasicStroke()));
        plot.addDomainMarker(new ValueMarker(0, Color.BLUE, new BasicStroke((float) 2.5)));
        plot.addDomainMarker(new ValueMarker(1000, Color.BLUE, new BasicStroke((float) 2.5)));
        plot.addDomainMarker(new ValueMarker(7000, Color.BLUE, new BasicStroke((float) 2.5)));
        plot.addDomainMarker(new ValueMarker(14000, Color.BLUE, new BasicStroke((float) 2.5)));
        XYTextAnnotation text = new XYTextAnnotation("Max Tension", 10, 95);
        text.setFont(new Font("SansSerif", Font.PLAIN, 9));
        plot.addAnnotation(text);
        XYTextAnnotation text2 = new XYTextAnnotation("Profile", 0, 50);
        text2.setFont(new Font("SansSerif", Font.PLAIN, 9));
        plot.addAnnotation(text2);
        XYTextAnnotation text3 = new XYTextAnnotation("Ramp", 1000, 50);
        text3.setFont(new Font("SansSerif", Font.PLAIN, 9));
        plot.addAnnotation(text3);
        XYTextAnnotation text4 = new XYTextAnnotation("Constant", 7000, 50);
        text4.setFont(new Font("SansSerif", Font.PLAIN, 9));
        plot.addAnnotation(text4);
        XYTextAnnotation text5 = new XYTextAnnotation("Recovery", 14000, 50);
        text5.setFont(new Font("SansSerif", Font.PLAIN, 9));
        plot.addAnnotation(text5);
        
        return chart;
    }
    
    /**
     * Creates a dataset, consisting of two series of monthly data.
     *
     * @return The dataset.
     */
    private XYDataset createDataset(long startTimeMili, int maxOffset) {
        heightTimeSeries.add(new Millisecond(new Date(startTimeMili + maxOffset)), null);
        heightDataset.addSeries(heightTimeSeries);

        return heightDataset;

    }
    
    private XYDataset createDataset2() {
        speedDataset.addSeries(speedTimeSeries);
        return speedDataset;

    }
    
    private XYDataset createDataset3 () {
        tensionDataset.addSeries(tensionTimeSeries);
        return tensionDataset;
    }
    
    private XYDataset createDataset4(int offset) {
        long dateMili = 0L;

        TimeSeries s1 = new TimeSeries("");
        s1.add(new Second(new Date(dateMili)), 110);
        s1.add(new Second(new Date(dateMili + offset)), 110);        
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;

    }
    
    private void addHeightValue(long time, float value) {
        heightTimeSeries.add(new Millisecond(new Date(time)), value);
    }
    private void addTensionValue(long time, float value) {
        tensionTimeSeries.add(new Millisecond(new Date(time)), value);
    }
    
    private void addSpeedValue(long time, float value) {
        speedTimeSeries.add(new Millisecond(new Date(time)), value);
    }
    
    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset(0L, 18000));
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(false);
        panel.setMouseWheelEnabled(false);
        panel.setAutoscrolls(false);
        panel.setDomainZoomable(false);
        panel.setFocusable(false);
        return panel;
    }

    @Override
    public void run() {
        long time = 0L;
        try {
            time += 500;
            addTensionValue(time, (float) 2.913);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 11.779);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 26.539);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 47.167);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 73.512);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 105.607);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 143.361);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 186.686);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 235.466);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 289.589);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 348.924);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 413.323);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 482.633);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            
            
            
             time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            
             time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            
            
            
             time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            
            
            
             time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            
            
            
             time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            
            
            
             time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            
             time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            
            
            
             time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            
            
            
             time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            
            
            
             time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            addTensionValue(time, (float) 556.694);
            Thread.sleep(50L);
            time += 500;
            
            
             
            
        } catch (InterruptedException ex) {
            Logger.getLogger(SpeedGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    /*public static void main(String[] args) {

        TensionGraph demo = new TensionGraph(
                "Time Series Chart Demo 1");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }*/
}
