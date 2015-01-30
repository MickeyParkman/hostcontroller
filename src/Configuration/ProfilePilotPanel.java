package Configuration;

import java.awt.*;
import javax.swing.*;


public class ProfilePilotPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProfilePilotPanel() {
		setLayout(null);
		
		JLabel lblPilotUnits = new JLabel("Pilot Units");
		lblPilotUnits.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPilotUnits.setBounds(156, 119, 106, 14);
		add(lblPilotUnits);

	}

}
