/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParameterSelection;

import Communications.MessagePipeline;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import Communications.Observer;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 *
 * @author Johnny White
 */
public class EnvironmentalWindow extends javax.swing.JPanel {

    private MessagePipeline pipe;
    private ArrayList<EnvironmentalWidget> widgets;
    
    public EnvironmentalWindow() {
        pipe = MessagePipeline.getInstance();
        widgets = new ArrayList<>();
        addWidget("Launch Weight", true, false);
        addWidget("Run Length", true, false);
        addWidget("Run Direction", true, false);
        addWidget("Run Slope", true, false);
        addWidget("Wind Direction", true, true);
        addWidget("Avg. Wind Speed", true, true);
        addWidget("Gust Wind Speed", true, true);
        addWidget("Head Wind Component", true, true);
        addWidget("Cross Wind Component", true, true);
        addWidget("Density Altitude", true, true);
        addWidget("Temperature", true, true);
        addWidget("Humidity", true, true);
        addWidget("Pressure", true, true);
        //setLayout(new FlowLayout());
        init();
    }
    
    private void addWidget(String name, boolean hasField, boolean canEdit)
    {
        widgets.add(new EnvironmentalWidget(name, hasField, canEdit));
    }
    
    private void init()
    {
        for(EnvironmentalWidget ew : widgets)
        {
            add(ew);
        }
    }
}
