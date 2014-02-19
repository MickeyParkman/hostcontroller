/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ParameterSelection;

import SystemConfiguration.SystemParametersPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author awilliams5
 */
public class AppMenu extends JMenuBar{
    
    public AppMenu() {
        super();
        initMenu();
    }
    
    private void initMenu() {
        JMenu menu = new JMenu("System");
        JMenuItem menuItem =  new JMenuItem("Parameters");
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame();
                f.add(new SystemParametersPanel());
                f.pack();
                f.setVisible(true);
            }
        });
        menu.add(menuItem);
        add(menu);
    }
}
