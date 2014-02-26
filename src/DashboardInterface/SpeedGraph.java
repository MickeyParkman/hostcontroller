/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DashboardInterface;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

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
        

    XYDataset dataset1 = createDataset();
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
    
        return chart;
    }
    
    /**
     * Creates a dataset, consisting of two series of monthly data.
     *
     * @return The dataset.
     */
    private static XYDataset createDataset() {
        long dateMili = 1387265266000L;

        TimeSeries s1 = new TimeSeries("Height ");
        s1.add(new Second(new Date(dateMili)), 10);
        s1.add(new Second(new Date(dateMili + 1000)), 15);
        s1.add(new Second(new Date(dateMili + 2000)), 35);
        s1.add(new Second(new Date(dateMili + 3000)), 60);
        s1.add(new Second(new Date(dateMili + 4000)), 75);
        s1.add(new Second(new Date(dateMili + 5000)), 100);
        s1.add(new Second(new Date(dateMili + 6000)), 105);
        s1.add(new Second(new Date(dateMili + 7000)), 106);
        s1.add(new Second(new Date(dateMili + 8000)), 105);
        s1.add(new Second(new Date(dateMili + 9000)), 105);
        s1.add(new Second(new Date(dateMili + 10000)), 105);
        s1.add(new Second(new Date(dateMili + 11000)), 104);
        //s1.add(new Minute(new Date(1387265266000L + 12000L)), 138.7);
        //s1.add(new Minute(new Date(1387265266000L + 13000L)), 137.3);
        //s1.add(new Minute(new Date(1387265266000L + 14000L)), 143.9);
        //s1.add(new Minute(new Date(1387265266000L + 15000L)), 139.8);
        //s1.add(new Minute(new Date(1387265266000L + 16000L)), 137.0);
        //s1.add(new Minute(new Date(1387265266000L + 17000L)), 132.8);


        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;

    }
    
    private static XYDataset createDataset2() {
        long dateMili = 1387265266000L;

        TimeSeries s1 = new TimeSeries("Speed ");
        s1.add(new Second(new Date(dateMili)), 1.1);
        s1.add(new Second(new Date(dateMili + 1000)), 1.6);
        s1.add(new Second(new Date(dateMili + 2000)), 3.8);
        s1.add(new Second(new Date(dateMili + 3000)), 6.0);
        s1.add(new Second(new Date(dateMili + 4000)), 7.7);
        s1.add(new Second(new Date(dateMili + 5000)), 10.0);
        s1.add(new Second(new Date(dateMili + 6000)), 10.9);
        s1.add(new Second(new Date(dateMili + 7000)), 11.6);
        s1.add(new Second(new Date(dateMili + 8000)), 11.5);
        s1.add(new Second(new Date(dateMili + 9000)), 11.5);
        s1.add(new Second(new Date(dateMili + 10000)), 11.5);
        s1.add(new Second(new Date(dateMili + 11000)), 11.4);
        //s1.add(new Minute(new Date(1387265266000L + 12000L)), 138.7);
        //s1.add(new Minute(new Date(1387265266000L + 13000L)), 137.3);
        //s1.add(new Minute(new Date(1387265266000L + 14000L)), 143.9);
        //s1.add(new Minute(new Date(1387265266000L + 15000L)), 139.8);
        //s1.add(new Minute(new Date(1387265266000L + 16000L)), 137.0);
        //s1.add(new Minute(new Date(1387265266000L + 17000L)), 132.8);


        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;

    }
    
    private static XYDataset createDataset3 () {
        long dateMili = 1387265266000L;

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
        //s1.add(new Minute(new Date(1387265266000L + 12000L)), 138.7);
        //s1.add(new Minute(new Date(1387265266000L + 13000L)), 137.3);
        //s1.add(new Minute(new Date(1387265266000L + 14000L)), 143.9);
        //s1.add(new Minute(new Date(1387265266000L + 15000L)), 139.8);
        //s1.add(new Minute(new Date(1387265266000L + 16000L)), 137.0);
        //s1.add(new Minute(new Date(1387265266000L + 17000L)), 132.8);


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
        JFreeChart chart = createChart(createDataset());
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
