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
import javax.swing.JOptionPane;
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
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.Layer;

/**
 * This UI class implements the graph of relevant data about a launch using the 
 * JFreechart library
 * 
 * @author Alex
 */
public class LaunchGraph extends JPanel {
    private final long serialVersionUID = 1L;
    TimeSeriesCollection heightDataset = new TimeSeriesCollection();
    TimeSeriesCollection speedDataset = new TimeSeriesCollection();
    TimeSeriesCollection tensionDataset = new TimeSeriesCollection();
    TimeSeries tensionTimeSeries = new TimeSeries("Tension ");
    TimeSeries speedTimeSeries = new TimeSeries("Speed ");
    TimeSeries heightTimeSeries = new TimeSeries("Height ");
    
    private XYPlot plot;
    
    private long previousTime = 0L;
    private int maxTensionMarker = 950;
    
     public LaunchGraph(String title) {
        setBackground(Color.WHITE);
        ChartPanel chartPanel = (ChartPanel) createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 270));
        add(chartPanel);
        //Thread t = new Thread(this);
        //t.start();
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
            "Speed, Height and Tension v Time:",  // title
            "Time",             // x-axis label
            "Speed",   // y-axis label
            dataset,            // data
            PlotOrientation.VERTICAL,
            true,               // create legend?
            true,               // generate tooltips?
            false               // generate URLs?
        );

        chart.setBackgroundPaint(Color.white);

        plot = chart.getXYPlot();        
        XYSplineRenderer splinerenderer1 = new XYSplineRenderer();
        XYSplineRenderer splinerenderer2 = new XYSplineRenderer();
        XYSplineRenderer splinerenderer3 = new XYSplineRenderer();
        

        XYDataset dataset1 = createDataset(0L, 130000);
        plot.setDataset(0,dataset1);
        plot.setRenderer(0,splinerenderer1);
        DateAxis domainAxis = new DateAxis("Date");
        plot.setDomainAxis(domainAxis);
        NumberAxis heightYAxis = new NumberAxis("Height");
        heightYAxis.setRange(0, 1050);
        plot.setRangeAxis(heightYAxis);
    
        XYDataset dataset2 = createDataset2();
        plot.setDataset(1, dataset2);
        plot.setRenderer(1, splinerenderer2);
        NumberAxis speedYAxis = new NumberAxis("Speed");
        speedYAxis.setRange(0, 50);
        plot.setRangeAxis(1, speedYAxis);
    
        XYDataset dataset3 = createDataset3();
        plot.setDataset(2, dataset3);
        plot.setRenderer(2, splinerenderer3);
        NumberAxis tensionYAxis = new NumberAxis("Tension");
        tensionYAxis.setRange(0, 8000);
        plot.setRangeAxis(2, tensionYAxis);

        plot.mapDatasetToRangeAxis(0, 0);//1st dataset to 1st y-axis
        plot.mapDatasetToRangeAxis(1, 1); //2nd dataset to 2nd y-axis
        plot.mapDatasetToRangeAxis(2, 2);
    
        float[] dashArray = {1,1,1,0};
        plot.addRangeMarker(new ValueMarker(maxTensionMarker, Color.YELLOW, new BasicStroke(1, 0, 0, 1, dashArray, 0)));
        XYTextAnnotation text = new XYTextAnnotation("Max Tension", 10, maxTensionMarker);
        text.setFont(new Font("SansSerif", Font.PLAIN, 9));
        plot.addAnnotation(text);
        
                
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(false);
        renderer.setBaseShapesFilled(false);
        
        XYLineAndShapeRenderer renderer2 = (XYLineAndShapeRenderer) plot.getRendererForDataset(speedDataset);
        renderer2.setBaseShapesVisible(false);
        renderer2.setBaseShapesFilled(false);
        
        XYLineAndShapeRenderer renderer3 = (XYLineAndShapeRenderer) plot.getRendererForDataset(tensionDataset);
        renderer3.setBaseShapesVisible(false);
        renderer3.setBaseShapesFilled(false);
        
        return chart;
    }
    
    /**
     * Adds a new vertical blue marker to the graph at the change of states
     * 
     * @param state the new state the launch has transitioned into
     */
    public void addStateMarker(int state) {
        plot.addDomainMarker(new ValueMarker(previousTime, Color.BLUE, new BasicStroke((float) 2.5)));
        switch(state) {
            case 2:
                XYTextAnnotation text = new XYTextAnnotation("Armed", previousTime + 2000, 500);
                text.setFont(new Font("SansSerif", Font.PLAIN, 9));
                plot.addAnnotation(text);
                break;
            case 3:
                XYTextAnnotation text2 = new XYTextAnnotation("Profile", previousTime + 2000, 510);
                text2.setFont(new Font("SansSerif", Font.PLAIN, 9));
                plot.addAnnotation(text2);
                break;
            case 4:
                XYTextAnnotation text3 = new XYTextAnnotation("Ramp", previousTime + 2000, 520);
                text3.setFont(new Font("SansSerif", Font.PLAIN, 9));
                plot.addAnnotation(text3);
                break;
            case 5:
                XYTextAnnotation text4 = new XYTextAnnotation("Constant", previousTime + 2000, 530);
                text4.setFont(new Font("SansSerif", Font.PLAIN, 9));
                plot.addAnnotation(text4);
                break;
            case 6:
                XYTextAnnotation text5 = new XYTextAnnotation("Recovery", previousTime + 2000, 540);
                text5.setFont(new Font("SansSerif", Font.PLAIN, 9));
                plot.addAnnotation(text5);
                break;
            case 7:
                XYTextAnnotation text6 = new XYTextAnnotation("Retrieve", previousTime + 2000, 550);
                text6.setFont(new Font("SansSerif", Font.PLAIN, 9));
                plot.addAnnotation(text6);
                break;
        }
    }
    
    /**
     * Creates a dataset for height values 
     *
     * @return The dataset.
     */
    private XYDataset createDataset(long startTimeMili, int maxOffset) {
        heightTimeSeries.add(new Millisecond(new Date(startTimeMili + maxOffset)), null);
        heightDataset.addSeries(heightTimeSeries);

        return heightDataset;

    }
    
    /**
     * Creates a dataset for speed values 
     *
     * @return The dataset.
     */
    private XYDataset createDataset2() {
        speedDataset.addSeries(speedTimeSeries);
        return speedDataset;

    }
    
    /**
     * Creates a dataset for tension values 
     *
     * @return The dataset.
     */
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
    
    /**
     * Adds a new height value to the height dataset
     * 
     * @param time the time associated with the value on the graph
     * @param value the height value to be graphed
     */
    public void addHeightValue(long time, float value) {
        heightTimeSeries.addOrUpdate(new Millisecond(new Date(previousTime)), value);
    }
    
    /**
     * Adds a new tension value to the tension dataset
     * 
     * @param time the time associated with the value on the graph
     * @param value the tension value to be graphed
     */
    public void addTensionValue(long time, float value) {
        tensionTimeSeries.addOrUpdate(new Millisecond(new Date(previousTime)), value);
    }
    
    /**
     * Adds a new speed value to the height dataset
     * 
     * @param time the time associated with the value on the graph
     * @param value the speed value to be graphed
     */
    public void addSpeedValue(long time, float value) {
        try{
            previousTime += time;
            speedTimeSeries.add(new Millisecond(new Date(previousTime)), value);
        } catch(SeriesException e) {
            
        }
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
}
