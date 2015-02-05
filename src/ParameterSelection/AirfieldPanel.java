package ParameterSelection;

import DataObjects.Airfield;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;


public class AirfieldPanel extends JPanel {

	private javax.swing.JScrollPane airfieldScrollPane;
	private javax.swing.JList airfieldJList;
	private List<Airfield> airfields = new ArrayList<Airfield>();
	
	private void initSailPlaneList() {
        try{
            //airfields = DatabaseUtilities.DatabaseDataObjectUtilities.getAirfields();
        }catch(Exception e) {

        }
    }
	
	
	/**
	 * Create the panel.
	 */
	public AirfieldPanel() {
		airfieldScrollPane = new javax.swing.JScrollPane();
		
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		JPanel airfieldSubPanel = new JPanel();
		panel.add(airfieldSubPanel);
		
		DefaultListModel airfieldModel = new DefaultListModel();
                for(Object str: airfields){
                    airfieldModel.addElement(str);
                }
                //airfieldJList.setModel(airfieldModel);
                //airfieldScrollPane.setViewportView(airfieldModel);
		
		JPanel gliderPostitionSubPanel = new JPanel();
		panel.add(gliderPostitionSubPanel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));
		
		JPanel runwaySubPanel = new JPanel();
		panel_1.add(runwaySubPanel);
		
		JPanel winchPostitionSubPanel = new JPanel();
		panel_1.add(winchPostitionSubPanel);

	}

}
