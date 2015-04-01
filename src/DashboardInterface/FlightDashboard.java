package DashboardInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jtroxel
 */
public class FlightDashboard extends javax.swing.JPanel
{
    private TensionSpeedDial dial;
    private SystemsStatus health;
    private LaunchGraph graph;
    private JPanel contentPane;
    private GroupLayout layout;
    
    private JPanel graphPane;
    private JPanel dialSquare;
    private JPanel dialPane;
    private JPanel systemPane;
    private JPanel diagramPane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    
    public FlightDashboard()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        
        //dial.dialUpdate(1125.0, 25.0);
        //dial.setSize(20, 20);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        graphPane = new javax.swing.JPanel();
        dialPane = new JPanel();
        
        //dialPane.setLayout(new BorderLayout());
        
        dialPane.setLayout(new GridBagLayout());
        //dialPane.setBorder(BorderFactory.createLineBorder(Color.black));
        systemPane = new JPanel();
        diagramPane = new StateMachinePanel();
        
        dialSquare = new JPanel(new BorderLayout()) {
            @Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int)d.getWidth(),(int)d.getHeight());
                } else if (c!=null &&
                        c.getWidth()>d.getWidth() &&
                        c.getHeight()>d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (w>h ? h : w);
                //System.out.println(s);
                return new Dimension(s,s);
            }
        };
        
        //dialSquare.setBorder(BorderFactory.createLineBorder(Color.black));
        
        dial = new TensionSpeedDial(dialSquare);
        dialSquare.add(dial, BorderLayout.CENTER);
        health = new SystemsStatus();
        graph = new LaunchGraph("title");
        
        //dial.dialUpdate(1125.0, 25.0);
        //dial.setSize(20, 20);
        
        graphPane.add(graph);
        //dialPane.add(dial, BorderLayout.CENTER);
        dialPane.add(dialSquare);
        systemPane.add(health);
        
        layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graphPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(systemPane)
                            .addComponent(diagramPane))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dialPane)))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dialPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(diagramPane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(systemPane)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(graphPane)
                .addContainerGap())
        );
        
        this.add(contentPane);
        //this.add(graph);
        //this.add(dial);
        //this.add(health);
    }
}
