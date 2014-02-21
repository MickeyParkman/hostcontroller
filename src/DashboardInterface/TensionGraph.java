/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DashboardInterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
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
public class TensionGraph extends JPanel {
    private static final long serialVersionUID = 1L;
    private TimeSeries s1 = new TimeSeries("Tension ");
    private long lastTimeStamp = 1387265277000L;
    
     public TensionGraph(String title) {
        ChartPanel chartPanel = (ChartPanel) createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 270));
        add(chartPanel);
        JButton b1 = new JButton("Test");
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addDataPoint(130 + Math.random() * 50);
            }
        });
        add(b1);
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
            "Tension v Time:",  // title
            "Time",             // x-axis label
            "Tension",   // y-axis label
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
    private XYDataset createDataset() {
        long dateMili = 1387265266000L;

        s1.add(new Second(new Date(dateMili)), 1.8);
        s1.add(new Second(new Date(dateMili + 1000)), 27.3);
        s1.add(new Second(new Date(dateMili + 2000)), 67.3);
        s1.add(new Second(new Date(dateMili + 3000)), 167.6);
        s1.add(new Second(new Date(dateMili + 4000)), 158.8);
        s1.add(new Second(new Date(dateMili + 5000)), 148.3);
        s1.add(new Second(new Date(dateMili + 6000)), 153.9);
        s1.add(new Second(new Date(dateMili + 7000)), 142.7);
        s1.add(new Second(new Date(dateMili + 8000)), 123.2);
        s1.add(new Second(new Date(dateMili + 9000)), 131.8);
        s1.add(new Second(new Date(dateMili + 10000)), 139.6);
        s1.add(new Second(new Date(dateMili + 11000)), 142.9);
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
    public JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        return panel;
    }
    
    public void addDataPoint(double value) {
        lastTimeStamp += 1000;
        s1.add(new Second(new Date(lastTimeStamp)), value);
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
