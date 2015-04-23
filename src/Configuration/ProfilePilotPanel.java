package Configuration;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;


public class ProfilePilotPanel extends JPanel {
    protected JComboBox flightWeightComboBox = new JComboBox();

    /**
     * Create the panel.
     */
    public ProfilePilotPanel() {
            setBackground(Color.WHITE);

            JLabel flightWeightLabel = new JLabel("Flight Weight:");

            flightWeightComboBox.setSize(new Dimension(0, 20));
            flightWeightComboBox.setMaximumSize(new Dimension(32767, 20));
            flightWeightComboBox.addItem("lbs");
            flightWeightComboBox.addItem("kg");
            GroupLayout groupLayout = new GroupLayout(this);
            groupLayout.setHorizontalGroup(
                    groupLayout.createParallelGroup(Alignment.LEADING)
                            .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(7)
                                    .addComponent(flightWeightLabel)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(flightWeightComboBox, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                    .addGap(318))
            );
            groupLayout.setVerticalGroup(
                    groupLayout.createParallelGroup(Alignment.LEADING)
                            .addGroup(groupLayout.createSequentialGroup()
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                            .addGroup(groupLayout.createSequentialGroup()
                                                    .addGap(10)
                                                    .addComponent(flightWeightLabel))
                                            .addGroup(groupLayout.createSequentialGroup()
                                                    .addGap(7)
                                                    .addComponent(flightWeightComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(273, Short.MAX_VALUE))
            );
            setLayout(groupLayout);
    }
}
