package DashboardInterface;

import java.awt.BorderLayout;
import java.awt.Rectangle;
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
    private JPanel dialPane;
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
        dial = new TensionSpeedDial();
        health = new SystemsStatus();
        graph = new LaunchGraph("title");
        
        dial.dialUpdate(1125.0, 25.0);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        graphPane = new javax.swing.JPanel();
        dialPane = new JPanel();
        
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        graphPane.add(graph);
        dialPane.add(dial);

        jTextArea2.setText("Dial");
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea4.setText("System Status");
        jScrollPane4.setViewportView(jTextArea4);

        jTextArea3.setText("State diagram");
        jScrollPane3.setViewportView(jTextArea3);
        
        layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graphPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane3))
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
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)))
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
