package DashboardInterface;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jtroxel
 */
public class FlightDashboard extends javax.swing.JPanel
{
    private TensionSpeedDial dial;
    private SystemsStatus health;
    
    public FlightDashboard()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        dial = new TensionSpeedDial();
        health = new SystemsStatus();
        
        //this.add(dial);
        //this.add(health);
    }
}
