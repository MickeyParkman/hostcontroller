package Configuration;

import javax.swing.*;
import java.awt.*;


public class ProfileGliderPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProfileGliderPanel() {
		setLayout(null);
		
		JLabel lblGliderUnits = new JLabel("Glider Units");
		lblGliderUnits.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGliderUnits.setBounds(188, 133, 116, 14);
		add(lblGliderUnits);

	}

}
