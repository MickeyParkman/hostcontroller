/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matt
 */
public class DisplayUnitsPanel extends javax.swing.JPanel {

    /**
     * Creates new form DisplayUnitsPanel
     */
    public DisplayUnitsPanel() {
        initComponents();
    }

    public int[] getSelectedIndices() {
        int[] indices = new int[6];
        indices[0] = displayLengthSelection.getSelectedIndex();
        indices[1] = displayTensionSelection.getSelectedIndex();
        indices[2] = displayWeightSelection.getSelectedIndex();
        indices[3] = displayVelocitySelection.getSelectedIndex();
        indices[4] = displayTempSelection.getSelectedIndex();
        indices[5] = displayPressureSelection.getSelectedIndex();
        return indices;
    }
    
    public void setSelectedIndices(int lengthIdx, int tensionIdx, int weightIdx,
                                    int velocityIdx, int tempIdx, int pressureIdx)
    {
        displayLengthSelection.setSelectedIndex(lengthIdx);
        displayTensionSelection.setSelectedIndex(tensionIdx);
        displayWeightSelection.setSelectedIndex(weightIdx);
        displayVelocitySelection.setSelectedIndex(velocityIdx);
        displayTempSelection.setSelectedIndex(tempIdx);
        displayPressureSelection.setSelectedIndex(pressureIdx);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        displayLengthSelection = new javax.swing.JComboBox();
        displayTensionSelection = new javax.swing.JComboBox();
        displayWeightSelection = new javax.swing.JComboBox();
        displayVelocitySelection = new javax.swing.JComboBox();
        displayTempSelection = new javax.swing.JComboBox();
        displayPressureSelection = new javax.swing.JComboBox();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Display Units");

        jLabel2.setText("Tension:");

        jLabel3.setText("Length:");

        jLabel4.setText("Weight:");

        jLabel5.setText("Velocity:");

        jLabel6.setText("Temp:");

        jLabel7.setText("Pressure:");

        displayLengthSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Meters (m)", "Feet (ft)", "Millimeters (mm)", "Centimeters (cm)", "Kilometers (Km)" }));

        displayTensionSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Newtons (N)", "Pound-Force (lbf)", "Kilogram-Force (Kgf)" }));

        displayWeightSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pounds (lbs)", "Kilograms (Kg)" }));

        displayVelocitySelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Miles per hour (mph)", "Kilometers per hour (Km/h)", "Meters per second (m/s)", "Knots (Kn)" }));

        displayTempSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Degrees Fahrenheit (F)", "Degrees Celcius (C)" }));

        displayPressureSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pounds/square inch (psi)", "Megapascals (Mp)", "Kilopascals (Kp)" }));
        try {
            displayLengthSelection.setSelectedIndex(DatabaseUtilities.DatabaseUnitSelectionUtilities.getDashboardDistanceUnit());
            displayPressureSelection.setSelectedIndex(DatabaseUtilities.DatabaseUnitSelectionUtilities.getEnvironmentalPressureUnit());
            displayTempSelection.setSelectedIndex(DatabaseUtilities.DatabaseUnitSelectionUtilities.getEnvironmentalTempUnit());
            displayTensionSelection.setSelectedIndex(DatabaseUtilities.DatabaseUnitSelectionUtilities.getDashboardTensionUnit());
            displayVelocitySelection.setSelectedIndex(DatabaseUtilities.DatabaseUnitSelectionUtilities.getDashboardVelocityUnit());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisplayUnitsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(displayLengthSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(displayTensionSelection, 0, 151, Short.MAX_VALUE)
                                    .addComponent(displayWeightSelection, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(displayTempSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(displayPressureSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(displayVelocitySelection, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(displayLengthSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(displayTensionSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayWeightSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayVelocitySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(displayTempSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(displayPressureSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox displayLengthSelection;
    private javax.swing.JComboBox displayPressureSelection;
    private javax.swing.JComboBox displayTempSelection;
    private javax.swing.JComboBox displayTensionSelection;
    private javax.swing.JComboBox displayVelocitySelection;
    private javax.swing.JComboBox displayWeightSelection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
