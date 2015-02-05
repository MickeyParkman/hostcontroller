package Wizards;

import DataObjects.Runway;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RunwayPanel extends JPanel {
	private JTextField textField;
	private JTextField magHeadField;

	/**
	 * Create the panel.
	 */
	public RunwayPanel() {
		setLayout(null);
		
		JLabel lblExistingRunways = new JLabel("Existing Runways:");
		lblExistingRunways.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExistingRunways.setBounds(10, 11, 139, 14);
		add(lblExistingRunways);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 36, 400, 100);
		add(textArea);
		
		JLabel lblNewLabel = new JLabel("Runway Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 151, 103, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Magnetic Heading:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 182, 125, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(150, 150, 120, 20);
		add(textField);
		textField.setColumns(10);
		
		magHeadField = new JTextField();
		magHeadField.setColumns(10);
		magHeadField.setBounds(150, 181, 120, 20);
		add(magHeadField);

	}
        
    public boolean isComplete(Runway r)
    {   
            //r.setMagneticHeading(magHeadField.getText());
            if(r.getMagneticHeading().isEmpty()){
                return false;
            }
        return true;
    }

}
