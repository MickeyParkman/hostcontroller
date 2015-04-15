/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParameterSelection;

import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Communications.Observer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author jtroxel
 */
public class EnvironmentalWidget extends JPanel implements Observer {
    private JLabel title;
    private JTextField field;
    private JCheckBox isEditable;
    
    public EnvironmentalWidget(String titleIn, boolean hasField, boolean canEdit)
    {
        setBackground(Color.WHITE);
        JPanel fieldPanel = new JPanel();
        fieldPanel.setBackground(Color.WHITE);
        fieldPanel.setLayout(new BorderLayout());
        title = new JLabel(titleIn);
        field = new JTextField();
        field.setBorder(new MatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
        field.setEditable(false);
        field.setBackground(Color.WHITE);
        field.setPreferredSize(new Dimension(120, 20));
        isEditable = new JCheckBox();
        isEditable.setBackground(Color.WHITE);
        isEditable.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    field.setEditable(true);
                    field.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
                }
                else
                {
                    field.setEditable(false);
                    field.setBorder(new MatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
                }
            }
        });
        setLayout(new BorderLayout());
        //setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        setPreferredSize(new Dimension(185, 37));
        add(title, BorderLayout.PAGE_START);
        fieldPanel.add(field, BorderLayout.LINE_START);
        if(canEdit) fieldPanel.add(isEditable, BorderLayout.CENTER); 
        if(hasField)
        {
            add(fieldPanel);
        }
    }
    
    public String getFieldValue()
    {
        return field.getText();
    }

    @Override
    public void update() {
    }

    @Override
    public void update(String msg) {
    }
}
