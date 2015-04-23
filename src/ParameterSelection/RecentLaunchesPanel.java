package ParameterSelection;

/**
 *
 * @author Noah Fujioka
 */

import DataObjects.FlightSummary;
import DataObjects.CurrentDataObjectSet;
import Communications.Observer;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RecentLaunchesPanel extends javax.swing.JPanel implements Observer {

    private List<FlightSummary> recentFlights;
    private CurrentDataObjectSet data;
    JScrollPane RecentLaunchScrollPane;
    private javax.swing.JList RecentLaunchJList;
    private JLabel listTitle;
    
    public RecentLaunchesPanel() {
        recentFlights = new ArrayList<FlightSummary>();
        RecentLaunchScrollPane = new JScrollPane();
        RecentLaunchJList = new javax.swing.JList();
        listTitle = new JLabel("Replay List");
        
        this.setLayout(new BorderLayout(0, 0));
        this.setBackground(Color.WHITE);
        this.add(listTitle, BorderLayout.NORTH);
        this.add(RecentLaunchScrollPane, BorderLayout.WEST);
        
        try{
            recentFlights = DatabaseUtilities.DatabaseDataObjectUtilities.getFlights();
            recentFlights.add(new FlightSummary("timstampp", "foo", "firs", "stuff", "last"));
            recentFlights.add(new FlightSummary("info2", "foo", "john", "stuff", "doe"));
            recentFlights.add(new FlightSummary("info3", "foo", "bar", "stuff", "things"));
            recentFlights.add(new FlightSummary("info4", "foo", "bar", "stuff", "things"));
        }catch(SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {

        }
        
        DefaultListModel recentFlightsModel = new DefaultListModel();
        for(Object str: recentFlights){
                recentFlightsModel.addElement(str);
        }
        RecentLaunchJList.setModel(recentFlightsModel);
        RecentLaunchJList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                //recentLaunchJListSelectionChanged(listSelectionEvent);
            }
        });
        RecentLaunchJList.setSelectedIndex(-1);
        RecentLaunchScrollPane.setViewportView(RecentLaunchJList);
        RecentLaunchScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
        RecentLaunchScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        //RecentLaunchScrollPane.setLayout(null);
        
        /*
        pilotButton.setMinimumSize(new Dimension(200, 20));
        pilotButton.setMaximumSize(new Dimension(200, 20));
        pilotButton.setBackground(new Color(200,200,200));
        pilotButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    selectionLayout_.first(ParameterSelectionPanel_);
        	}
        });*/
        
        //this.add(new JLabel("Working"));
    }                      

    public void update() {
        DefaultListModel recentFlightsModel = new DefaultListModel();
        recentFlightsModel.clear();
        for(Object str: recentFlights){
                recentFlightsModel.addElement(str);
        }
        RecentLaunchJList.setModel(recentFlightsModel);
        RecentLaunchScrollPane.setViewportView(RecentLaunchJList);
    }
    
    public void update(String s){}
}
