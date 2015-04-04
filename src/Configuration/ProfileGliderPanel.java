package Configuration;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ProfileGliderPanel extends JPanel {
	private JComboBox emptyWeightComboBox = new JComboBox();
	
	/**
	 * Create the panel.
	 */
	public ProfileGliderPanel() {
		setBackground(Color.WHITE);
		
		JLabel emptyWeightLabel = new JLabel("Empty Weight:");
		
		emptyWeightComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		emptyWeightComboBox.setSize(new Dimension(0, 20));
		emptyWeightComboBox.setMaximumSize(new Dimension(32767, 20));
		emptyWeightComboBox.addItem("kg");
		emptyWeightComboBox.addItem("lbs");
		      
		JLabel maxGrossWeightLabel = new JLabel("Max Gross Weight:");
		
		JComboBox maxGrossWeightComboBox = new JComboBox();
		maxGrossWeightComboBox.setSize(new Dimension(0, 20));
		maxGrossWeightComboBox.setMaximumSize(new Dimension(32767, 20));
		maxGrossWeightComboBox.addItem("kg");
		maxGrossWeightComboBox.addItem("lbs");
		
		JLabel indicatedStallSpeedLabel = new JLabel("Indicated Stall Speed:");
		
		JComboBox stallSpeedComboBox = new JComboBox();
		stallSpeedComboBox.setSize(new Dimension(0, 20));
		stallSpeedComboBox.setMaximumSize(new Dimension(32767, 20));
		stallSpeedComboBox.addItem("kph");
		stallSpeedComboBox.addItem("mph");
		
		JLabel weakLinkStrengthLabel = new JLabel("Max Weak Link Strength:");
		
		JLabel maxWinchingSpeedLabel = new JLabel("Max Winching Speed:");
		
		JComboBox weakLinkStrengthComboBox = new JComboBox();
		weakLinkStrengthComboBox.setSize(new Dimension(0, 20));
		weakLinkStrengthComboBox.setMaximumSize(new Dimension(32767, 20));
		weakLinkStrengthComboBox.addItem("N");
		weakLinkStrengthComboBox.addItem("ldf");
		weakLinkStrengthComboBox.addItem("kdf");
		
		JComboBox maxWinchingSpeedComboBox = new JComboBox();
		maxWinchingSpeedComboBox.setSize(new Dimension(0, 20));
		maxWinchingSpeedComboBox.setMaximumSize(new Dimension(32767, 20));
		maxWinchingSpeedComboBox.addItem("kph");
		maxWinchingSpeedComboBox.addItem("mph");
		
		JLabel maxTensionLabel = new JLabel("Max Tension:");
		
		JComboBox maxTensionComboBox = new JComboBox();
		maxTensionComboBox.setSize(new Dimension(0, 20));
		maxTensionComboBox.setMaximumSize(new Dimension(32767, 20));
		maxTensionComboBox.addItem("N");
		maxTensionComboBox.addItem("ldf");
		maxTensionComboBox.addItem("kdf");
		
		JLabel ballastWeightLabel = new JLabel("Ballast Weight:");
		
		JLabel passengerWeightLabel = new JLabel("Total Passenger Weight:");
		
		JLabel baggageWeightLabel = new JLabel("Baggage Weight:");
		
		JComboBox ballastWeightComboBox = new JComboBox();
		ballastWeightComboBox.setSize(new Dimension(0, 20));
		ballastWeightComboBox.setMaximumSize(new Dimension(32767, 20));
		ballastWeightComboBox.addItem("kg");
		ballastWeightComboBox.addItem("lbs");
		
		JComboBox baggageWeightComboBox = new JComboBox();
		baggageWeightComboBox.setSize(new Dimension(0, 20));
		baggageWeightComboBox.setMaximumSize(new Dimension(32767, 20));
		baggageWeightComboBox.addItem("kg");
		baggageWeightComboBox.addItem("lbs");
		
		JComboBox passengerWeightComboBox = new JComboBox();
		passengerWeightComboBox.setSize(new Dimension(0, 20));
		passengerWeightComboBox.setMaximumSize(new Dimension(32767, 20));
		passengerWeightComboBox.addItem("kg");
		passengerWeightComboBox.addItem("lbs");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ballastWeightLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(emptyWeightLabel)
								.addComponent(maxGrossWeightLabel)
								.addComponent(indicatedStallSpeedLabel)
								.addComponent(baggageWeightLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(baggageWeightComboBox, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(stallSpeedComboBox, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(emptyWeightComboBox, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
										.addComponent(maxGrossWeightComboBox, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
										.addComponent(ballastWeightComboBox, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
									.addGap(64)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(weakLinkStrengthLabel)
										.addComponent(maxWinchingSpeedLabel)
										.addComponent(maxTensionLabel)
										.addComponent(passengerWeightLabel))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(maxTensionComboBox, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
												.addComponent(maxWinchingSpeedComboBox, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
												.addComponent(weakLinkStrengthComboBox, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addComponent(passengerWeightComboBox, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))))))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(maxWinchingSpeedLabel)
								.addComponent(maxWinchingSpeedComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(weakLinkStrengthLabel)
								.addComponent(weakLinkStrengthComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(maxTensionLabel)
								.addComponent(maxTensionComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(emptyWeightLabel)
								.addComponent(emptyWeightComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(maxGrossWeightLabel)
								.addComponent(maxGrossWeightComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(indicatedStallSpeedLabel)
								.addComponent(stallSpeedComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ballastWeightLabel)
						.addComponent(passengerWeightLabel)
						.addComponent(ballastWeightComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passengerWeightComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(baggageWeightLabel)
						.addComponent(baggageWeightComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(160))
		);
		setLayout(groupLayout);

	}
}
