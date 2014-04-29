/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DashboardInterface;

import java.awt.Dimension;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.*;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;



public class TensionSpeedDial extends JPanel implements ChangeListener {
        DefaultValueDataset dataset1;
        DefaultValueDataset dataset2;
        JSlider slider1;
        JSlider slider2;

        public void stateChanged(ChangeEvent changeevent)
        {
                dataset1.setValue(new Integer(slider1.getValue()));
                dataset2.setValue(new Integer(slider2.getValue()));
        }

        public void dialUpdate(double tension, double speed) {
            System.out.println("2");
            dataset1.setValue(speed);
            dataset2.setValue(tension);      
        }
        
        public TensionSpeedDial()
        {
                super(new BorderLayout());
                dataset1 = new DefaultValueDataset(0D);
                dataset2 = new DefaultValueDataset(0D);
                        
                DialPlot dialplot = new DialPlot();
                        
                dialplot.setView(0.0D, 0.0D, 1.0D, 1.0D);
                dialplot.setDataset(0, dataset1);
                dialplot.setDataset(1, dataset2);
                        
                StandardDialFrame standarddialframe = new StandardDialFrame();
                standarddialframe.setBackgroundPaint(Color.lightGray);
                standarddialframe.setForegroundPaint(Color.darkGray);
                dialplot.setDialFrame(standarddialframe);
                        
                GradientPaint gradientpaint = new GradientPaint(new Point(), new Color(255, 255, 255), new Point(), new Color(170, 170, 220));
                DialBackground dialbackground = new DialBackground(gradientpaint);
                        
                dialbackground.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
                dialplot.setBackground(dialbackground);
                        
                DialTextAnnotation dialtextannotation = new DialTextAnnotation("Tension");
                dialtextannotation.setFont(new Font("Dialog", 1, 14));
                dialtextannotation.setRadius(0.30999999999999996D);
                dialplot.addLayer(dialtextannotation);
                        
                        DialTextAnnotation dialtextannotation2 = new DialTextAnnotation("Speed");
                        dialtextannotation2.setFont(new Font("Dialog", 1, 14));
                        dialtextannotation2.setRadius(0.60999999999999996D);
                        dialplot.addLayer(dialtextannotation2);
                        
                        DialValueIndicator dialvalueindicator = new DialValueIndicator(0);
                        dialvalueindicator.setFont(new Font("Dialog", 0, 10));
                        dialvalueindicator.setOutlinePaint(Color.darkGray);
                        dialvalueindicator.setRadius(0.84999999999999998D);
                        dialvalueindicator.setAngle(-90D);
                        dialplot.addLayer(dialvalueindicator);
                        
                        DialValueIndicator dialvalueindicator1 = new DialValueIndicator(1);
                        dialvalueindicator1.setFont(new Font("Dialog", 0, 10));
                        dialvalueindicator1.setOutlinePaint(Color.darkGray);
                        dialvalueindicator1.setRadius(0.52999999999999998D);
                        dialvalueindicator1.setAngle(-90D);
                        dialplot.addLayer(dialvalueindicator1);
                        
                        StandardDialScale standarddialscale = new StandardDialScale(0D, 400D, -120D, -300D, 40D, 4);
                        standarddialscale.setTickRadius(0.88D);
                        standarddialscale.setTickLabelOffset(0.14999999999999999D);
                        standarddialscale.setTickLabelFont(new Font("Dialog", 0, 14));
                        dialplot.addScale(0, standarddialscale);
                        
                        StandardDialScale standarddialscale1 = new StandardDialScale(0.0D, 250000D, -120D, -300D, 25000D, 4);
                        standarddialscale1.setTickRadius(0.5D);
                        standarddialscale1.setTickLabelOffset(0.14999999999999999D);
                        standarddialscale1.setTickLabelFont(new Font("Dialog", 0, 10));
                        standarddialscale1.setMajorTickPaint(Color.BLUE);
                        standarddialscale1.setMinorTickPaint(Color.BLUE);
                        dialplot.addScale(1, standarddialscale1);
                        
                        dialplot.mapDatasetToScale(1, 1);
                        
                        StandardDialRange speedRangeOuter = new StandardDialRange(87.5D, 100D, Color.red);
                        speedRangeOuter.setScaleIndex(1);
                        speedRangeOuter.setInnerRadius(0.89999999999999997D);
                        speedRangeOuter.setOuterRadius(0.90999999999999997D);
                        dialplot.addLayer(speedRangeOuter);
                        
                        StandardDialRange speedRangeInner = new StandardDialRange(87.5D, 100D, Color.red);
                        speedRangeInner.setScaleIndex(1);
                        speedRangeInner.setInnerRadius(0.80999999999999997D);
                        speedRangeInner.setOuterRadius(0.81999999999999997D);
                        dialplot.addLayer(speedRangeInner);
                        
                        StandardDialRange tensionRangeOuter = new StandardDialRange(80D, 100D, Color.red);
                        tensionRangeOuter.setScaleIndex(1);
                        tensionRangeOuter.setInnerRadius(0.44999999999999997D);
                        tensionRangeOuter.setOuterRadius(0.45999999999999997D);
                        dialplot.addLayer(tensionRangeOuter);
                        
                        StandardDialRange tensionRangeInner = new StandardDialRange(80D, 100D, Color.red);
                        tensionRangeInner.setScaleIndex(1);
                        tensionRangeInner.setInnerRadius(0.50999999999999997D);
                        tensionRangeInner.setOuterRadius(0.51999999999999997D);
                        dialplot.addLayer(tensionRangeInner);
                        
                        org.jfree.chart.plot.dial.DialPointer.Pin pin = new org.jfree.chart.plot.dial.DialPointer.Pin(1);
                        pin.setRadius(0.55000000000000004D);
                        dialplot.addPointer(pin);
                        
                        org.jfree.chart.plot.dial.DialPointer.Pointer pointer = new org.jfree.chart.plot.dial.DialPointer.Pointer(0);
                        dialplot.addPointer(pointer);
                        
                        DialCap dialcap = new DialCap();
                        dialcap.setRadius(0.10000000000000001D);
                        dialplot.setCap(dialcap);
                        
                        //ChartFactory.create
                        
                        JFreeChart jfreechart = new JFreeChart(dialplot);
                        ChartPanel chartpanel = new ChartPanel(jfreechart);
                        chartpanel.setPreferredSize(new Dimension(400, 400));
                        JPanel jpanel = new JPanel(new GridLayout(2, 2));
                        //jpanel.add(new JLabel("Speed:"));
                        //jpanel.add(new JLabel("Tension:"));
                        //slider1 = new JSlider(0, 80, 0);
                        //slider1.setMajorTickSpacing(20);
                        //slider1.setPaintTicks(true);
                        //slider1.setPaintLabels(true);
                        //slider1.addChangeListener(this);
                        //jpanel.add(slider1);
                        //jpanel.add(slider1);
                        //slider2 = new JSlider(0, 100, 0);
                        //slider2.setMajorTickSpacing(20);
                        //slider2.setPaintTicks(true);
                        //slider2.setPaintLabels(true);
                        //slider2.addChangeListener(this);
                        //jpanel.add(slider2);
                        add(chartpanel);
                        add(jpanel, "South");
                        //DialUpdater update = new DialUpdater();
                        //Thread t = new Thread(update);
                        //t.start();
        }
        
        private void updateDial() {
            if(dataset1.getValue().intValue() < 80)
                dataset1.setValue(dataset1.getValue().intValue() + 1);
            if(dataset2.getValue().intValue() < 100)
                dataset2.setValue(dataset2.getValue().intValue() + 1);
        }
        
        private class DialUpdater implements Runnable {

            @Override
            public void run() {
                for(int i = 0; i < 101; i ++) {
                    updateDial();
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TensionSpeedDial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        }
}
