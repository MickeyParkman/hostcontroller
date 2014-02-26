/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DashboardInterface;

import java.awt.Dimension;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.*;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;



public class TensionDial extends JPanel implements ChangeListener {
        DefaultValueDataset dataset1;
        DefaultValueDataset dataset2;
        JSlider slider1;
        JSlider slider2;

        public void stateChanged(ChangeEvent changeevent)
        {
                dataset1.setValue(new Integer(slider1.getValue()));
                dataset2.setValue(new Integer(slider2.getValue()));
        }

        public void demoUpdate(int tension, int speed) {
            dataset1.setValue(speed);
            dataset2.setValue(tension);      
        }
        
        public TensionDial()
        {
                super(new BorderLayout());
                dataset1 = new DefaultValueDataset(0D);
                        
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
                        
                        DialValueIndicator dialvalueindicator = new DialValueIndicator(0);
                        dialvalueindicator.setFont(new Font("Dialog", 0, 10));
                        dialvalueindicator.setOutlinePaint(Color.darkGray);
                        dialvalueindicator.setRadius(0.84999999999999998D);
                        dialvalueindicator.setAngle(-90D);
                        dialplot.addLayer(dialvalueindicator);
                        
                        StandardDialScale standarddialscale = new StandardDialScale(0D, 80D, -120D, -300D, 10D, 4);
                        standarddialscale.setTickRadius(0.88D);
                        standarddialscale.setTickLabelOffset(0.14999999999999999D);
                        standarddialscale.setTickLabelFont(new Font("Dialog", 0, 14));
                        dialplot.addScale(0, standarddialscale);
                        
                        StandardDialScale standarddialscale1 = new StandardDialScale(0.0D, 100D, -120D, -300D, 10D, 4);
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
                        
                        org.jfree.chart.plot.dial.DialPointer.Pin pin = new org.jfree.chart.plot.dial.DialPointer.Pin(1);
                        pin.setRadius(0.55000000000000004D);
                        dialplot.addPointer(pin);
                        
                        org.jfree.chart.plot.dial.DialPointer.Pointer pointer = new org.jfree.chart.plot.dial.DialPointer.Pointer(0);
                        dialplot.addPointer(pointer);
                        
                        DialCap dialcap = new DialCap();
                        dialcap.setRadius(0.10000000000000001D);
                        dialplot.setCap(dialcap);
                                                
                        JFreeChart jfreechart = new JFreeChart(dialplot);
                        ChartPanel chartpanel = new ChartPanel(jfreechart);
                        chartpanel.setPreferredSize(new Dimension(400, 400));
                        JPanel jpanel = new JPanel(new GridLayout(2, 2));
                        add(chartpanel);
                        add(jpanel, "South");
        }
}
