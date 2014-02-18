/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainhost;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
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

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Speed v Time:",  // title
            "Time",             // x-axis label
            "Speed",   // y-axis label
            dataset,            // data
            true,               // create legend?
            true,               // generate tooltips?
            false               // generate URLs?
        );

        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
            renderer.setDrawSeriesLineAsPath(true);
        }

        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("mm:ss"));

        return chart;
    }
    
    /**
     * Creates a dataset, consisting of two series of monthly data.
     *
     * @return The dataset.
     */
    private static XYDataset createDataset() {
        long dateMili = 1387265266000L;

        TimeSeries s1 = new TimeSeries("Speed ");
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
    
    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
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
