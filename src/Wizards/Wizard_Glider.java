package Wizards;

import DataObjects.Sailplane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class Wizard_Glider extends JFrame {

	private JPanel contentPane;
	private JTextField nNumField;
	private JTextField emptyWeightField;
	private JTextField maxGrossWeightField;
	private JTextField indicatedStallSpeedField;
	private JTextField maxWinchingSpeedField;
        private Sailplane sailplaneEdited;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                                        Sailplane sample = new Sailplane("N-num", "The type",
                                                100, 200, 300, 400, 500, 600, true, true);
					Wizard_Glider frame = new Wizard_Glider(sample);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Wizard_Glider(Sailplane sailplaneEdited) {
		setTitle("New Glider Wizard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNnumber = new JLabel("N-Number:");
		lblNnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNnumber.setBounds(10, 11, 85, 14);
		contentPane.add(lblNnumber);
		
		JLabel lblNewLabel = new JLabel("Empty Weight:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 42, 105, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMaxGrossWeight = new JLabel("Max Gross Weight:");
		lblMaxGrossWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaxGrossWeight.setBounds(10, 73, 131, 14);
		contentPane.add(lblMaxGrossWeight);
		
		JLabel lblIndicatedStallSpeed = new JLabel("Indicated Stall Speed:");
		lblIndicatedStallSpeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIndicatedStallSpeed.setBounds(10, 104, 144, 14);
		contentPane.add(lblIndicatedStallSpeed);
		
		JLabel lblMaxWinchingSpeed = new JLabel("Max Winching Speed:");
		lblMaxWinchingSpeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaxWinchingSpeed.setBounds(10, 135, 144, 14);
		contentPane.add(lblMaxWinchingSpeed);
                
		nNumField = new JTextField(sailplaneEdited.getNumber());
		nNumField.setColumns(10);
		nNumField.setBounds(180, 10, 100, 20);
		contentPane.add(nNumField);
                
                emptyWeightField = new JTextField(Integer.toString(sailplaneEdited.getEmptyWeight()));
		emptyWeightField.setColumns(10);
		emptyWeightField.setBounds(180, 41, 100, 20);
		contentPane.add(emptyWeightField);
		
		//maxGrossWeightField = new JTextField(Integer.toString(sailplaneEdited.getMaximumGrossWeight()));
		maxGrossWeightField.setColumns(10);
		maxGrossWeightField.setBounds(180, 72, 100, 20);
		contentPane.add(maxGrossWeightField);
		
		indicatedStallSpeedField = new JTextField(Integer.toString(sailplaneEdited.getIndicatedStallSpeed()));
		indicatedStallSpeedField.setBounds(180, 103, 100, 20);
		contentPane.add(indicatedStallSpeedField);
		indicatedStallSpeedField.setColumns(10);
		
		//maxWinchingSpeedField = new JTextField(Integer.toString(sailplaneEdited.getMaximumWinchingSpeed()));
		maxWinchingSpeedField.setColumns(10);
		maxWinchingSpeedField.setBounds(180, 134, 100, 20);
		contentPane.add(maxWinchingSpeedField);
		
		JLabel lblUnits = new JLabel("Units*");
		lblUnits.setBounds(290, 44, 46, 14);
		contentPane.add(lblUnits);
		
		JLabel label = new JLabel("Units*");
		label.setBounds(290, 75, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Units*");
		label_1.setBounds(290, 106, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Units*");
		label_2.setBounds(290, 137, 46, 14);
		contentPane.add(label_2);
		
		/*JCheckBox chckbxNewCheckBox = new JCheckBox("Singled Seated?", sailplaneEdited.gethasBallast());
		chckbxNewCheckBox.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox.setBounds(10, 166, 144, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxCanCarryBallast = new JCheckBox("Can carry ballast?", sailplaneEdited.gethasBallast());
		chckbxCanCarryBallast.setHorizontalTextPosition(SwingConstants.LEADING);
		chckbxCanCarryBallast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCanCarryBallast.setBounds(10, 197, 144, 23);
		contentPane.add(chckbxCanCarryBallast);*/
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(0, 239, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(90, 239, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.setBounds(180, 239, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
