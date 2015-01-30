package Configuration;

import javax.swing.*;
import java.awt.*;


public class ProfileAirfieldPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProfileAirfieldPanel() {
		setLayout(null);
		
		JLabel lblAirfieldUnits = new JLabel("Airfield Units");
		lblAirfieldUnits.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAirfieldUnits.setBounds(173, 147, 100, 14);
		add(lblAirfieldUnits);

	}

}
