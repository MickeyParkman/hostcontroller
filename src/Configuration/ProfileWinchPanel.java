package Configuration;

import javax.swing.*;
import java.awt.*;


public class ProfileWinchPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProfileWinchPanel() {
		setLayout(null);
		
		JLabel lblWinchUnits = new JLabel("Winch Units");
		lblWinchUnits.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWinchUnits.setBounds(181, 136, 104, 14);
		add(lblWinchUnits);

	}

}
