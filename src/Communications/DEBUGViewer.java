/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communications;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author jtroxel
 */
public class DEBUGViewer extends JPanel implements Observer {
    
    JTextArea debugPanel;
    JScrollPane scroller;
    MessagePipeline pipe;
    JLabel label;
    
    public DEBUGViewer()
    {
        pipe = MessagePipeline.getInstance();
        pipe.attach(this);
        debugPanel = new JTextArea(400,600);
        scroller = new JScrollPane(debugPanel);
        debugPanel.setEditable(true);
        label = new JLabel();
        this.add(label);
        this.setVisible(true);
    }

    public void update() {}

    public void update(String msg) {
        label.setText(msg);
    }
}
