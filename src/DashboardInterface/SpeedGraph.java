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
import java.util.Date;
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
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.Layer;

/**
 *
 * @author Alex
 */
public class SpeedGraph extends JPanel {
    private static final long serialVersionUID = 1L;
    
     public SpeedGraph(String title) {
        ChartPanel chartPanel = (ChartPanel) createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 270));
        add(chartPanel);
    }
     
     /**
     * Creates a chart.
     *
     * @param dataset  a dataset.
     *
     * @return A chart.
     */
    private static JFreeChart createChart(XYDataset dataset) {

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
        

        XYDataset dataset1 = createDataset(0L, 14000);
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
    private static XYDataset createDataset(long startTimeMili, int maxOffset) {
        TimeSeries s1 = new TimeSeries("Height ");
        s1.add(new Second(new Date(startTimeMili)), 10);
        s1.add(new Second(new Date(startTimeMili + 1000)), 15);
        s1.add(new Second(new Date(startTimeMili + 2000)), 35);
        s1.add(new Second(new Date(startTimeMili + 3000)), 60);
        s1.add(new Second(new Date(startTimeMili + 4000)), 75);
        s1.add(new Second(new Date(startTimeMili + 5000)), 100);
        s1.add(new Second(new Date(startTimeMili + 6000)), 105);
        s1.add(new Second(new Date(startTimeMili + 7000)), 106);
        s1.add(new Second(new Date(startTimeMili + 8000)), 105);
        s1.add(new Second(new Date(startTimeMili + 9000)), 105);
        s1.add(new Second(new Date(startTimeMili + 10000)), 105);
        s1.add(new Second(new Date(startTimeMili + 11000)), 104);
        s1.add(new Second(new Date(startTimeMili + maxOffset)), null);
        
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;

    }
    
    private static XYDataset createDataset2() {
        long dateMili = 0L;

        TimeSeries s1 = new TimeSeries("Speed ");
        s1.add(new Second(new Date(dateMili)), 1.1);
        s1.add(new Second(new Date(dateMili + 1000)), 1.3);
        s1.add(new Second(new Date(dateMili + 2000)), 2.8);
        s1.add(new Second(new Date(dateMili + 3000)), 4.0);
        s1.add(new Second(new Date(dateMili + 4000)), 5.7);
        s1.add(new Second(new Date(dateMili + 5000)), 8.0);
        s1.add(new Second(new Date(dateMili + 6000)), 10.9);
        s1.add(new Second(new Date(dateMili + 7000)), 9.6);
        s1.add(new Second(new Date(dateMili + 8000)), 9.5);
        s1.add(new Second(new Date(dateMili + 9000)), 9.5);
        s1.add(new Second(new Date(dateMili + 10000)), 9.5);
        s1.add(new Second(new Date(dateMili + 11000)), 10.4);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;

    }
    
    private static XYDataset createDataset3 () {
        long dateMili = 0L;

        TimeSeries s1 = new TimeSeries("Tension ");
        s1.add(new Second(new Date(dateMili)), 90);
        s1.add(new Second(new Date(dateMili + 1000)), 95);
        s1.add(new Second(new Date(dateMili + 2000)), 103);
        s1.add(new Second(new Date(dateMili + 3000)), 106);
        s1.add(new Second(new Date(dateMili + 4000)), 112);
        s1.add(new Second(new Date(dateMili + 5000)), 115);
        s1.add(new Second(new Date(dateMili + 6000)), 126);
        s1.add(new Second(new Date(dateMili + 7000)), 128);
        s1.add(new Second(new Date(dateMili + 8000)), 135);
        s1.add(new Second(new Date(dateMili + 9000)), 137);
        s1.add(new Second(new Date(dateMili + 10000)), 139);
        s1.add(new Second(new Date(dateMili + 11000)), 139);
        
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;

    }
    
    private static XYDataset createDataset4(int offset) {
        long dateMili = 1387265266000L;

        TimeSeries s1 = new TimeSeries("");
        s1.add(new Second(new Date(dateMili)), 110);
        s1.add(new Second(new Date(dateMili + offset)), 110);        
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;

    }
    
    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset(1387265266000L, 18000));
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(false);
        panel.setMouseWheelEnabled(false);
        panel.setAutoscrolls(false);
        panel.setDomainZoomable(false);
        panel.setFocusable(false);
        return panel;
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
