package Wizards;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class AirfieldPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public AirfieldPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Airfield Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 151, 100, 14);
		add(lblNewLabel);
		
		JLabel lblDesignator = new JLabel("Designator:");
		lblDesignator.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesignator.setBounds(10, 182, 100, 14);
		add(lblDesignator);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocation.setBounds(10, 213, 100, 14);
		add(lblLocation);
		
		JLabel lblAltitude = new JLabel("Altitude:");
		lblAltitude.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAltitude.setBounds(10, 244, 100, 14);
		add(lblAltitude);
		
		JLabel lblMagneticVariation = new JLabel("Magnetic Variation:");
		lblMagneticVariation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMagneticVariation.setBounds(10, 275, 122, 14);
		add(lblMagneticVariation);
		
		JLabel lblExistingAirfields = new JLabel("Existing Airfields:");
		lblExistingAirfields.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExistingAirfields.setBounds(10, 11, 138, 14);
		add(lblExistingAirfields);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 36, 400, 100);
		add(textArea);
		
		textField = new JTextField();
		textField.setBounds(150, 274, 120, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(150, 243, 120, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(150, 212, 120, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(150, 181, 120, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(150, 150, 120, 20);
		add(textField_4);
		
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setBounds(280, 246, 46, 14);
		add(lblUnits);

	}

}
