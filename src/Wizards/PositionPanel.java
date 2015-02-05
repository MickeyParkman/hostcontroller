package Wizards;

import DataObjects.Position;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class PositionPanel extends JPanel {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;

    /**
     * Create the panel.
     */
    public PositionPanel() {
            setLayout(null);

            JLabel lblExistingPositions = new JLabel("Existing Positions:");
            lblExistingPositions.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lblExistingPositions.setBounds(10, 11, 152, 14);
            add(lblExistingPositions);

            JTextArea textArea = new JTextArea();
            textArea.setBounds(10, 36, 400, 100);
            add(textArea);

            JLabel lblNewLabel = new JLabel("Position Name:");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblNewLabel.setBounds(10, 151, 106, 14);
            add(lblNewLabel);

            JLabel lblNewLabel_1 = new JLabel("Maximum Length:");
            lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblNewLabel_1.setBounds(10, 182, 126, 14);
            add(lblNewLabel_1);

            JLabel lblNewLabel_2 = new JLabel("Slope:");
            lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblNewLabel_2.setBounds(10, 213, 46, 14);
            add(lblNewLabel_2);

            JLabel lblCenterlineOffset = new JLabel("Centerline Offset:");
            lblCenterlineOffset.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblCenterlineOffset.setBounds(10, 244, 106, 14);
            add(lblCenterlineOffset);

            JLabel lblLongitude = new JLabel("Longitude:");
            lblLongitude.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblLongitude.setBounds(10, 275, 126, 14);
            add(lblLongitude);

            JLabel lblLatitude = new JLabel("Latitude:");
            lblLatitude.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblLatitude.setBounds(10, 306, 106, 14);
            add(lblLatitude);

            textField = new JTextField();
            textField.setBounds(150, 181, 120, 20);
            add(textField);
            textField.setColumns(10);

            textField_1 = new JTextField();
            textField_1.setColumns(10);
            textField_1.setBounds(150, 150, 120, 20);
            add(textField_1);

            textField_2 = new JTextField();
            textField_2.setColumns(10);
            textField_2.setBounds(150, 212, 120, 20);
            add(textField_2);

            textField_3 = new JTextField();
            textField_3.setColumns(10);
            textField_3.setBounds(150, 243, 120, 20);
            add(textField_3);

            textField_4 = new JTextField();
            textField_4.setColumns(10);
            textField_4.setBounds(150, 274, 120, 20);
            add(textField_4);

            textField_5 = new JTextField();
            textField_5.setColumns(10);
            textField_5.setBounds(150, 305, 120, 20);
            add(textField_5);

    }
    /*    
    ArrayList<Position> positions = new ArrayList();

    public void populate(){
        DefaultListModel positionListModel = new DefaultListModel();
        for(Position p: positions){
            positionListModel.addElement(p.getPositionMaximumLength());
        }
        positionMenu.setModel(positionListModel);
    }
    
    public boolean isComplete(Position p)
    {
        p.setPositionMaximumLength(Integer.parseInt(maxLengthField.getText()));
        if(maxLengthField.getText().isEmpty()){
            return false;
        }
        p.setPositionSlope(Integer.parseInt(slopeField.getText()));
        if(slopeField.getText().isEmpty()){
            return false;
        }
        p.setPositionCenterlineOffset(Integer.parseInt(clineOffsetField.getText()));
        if(clineOffsetField.getText().isEmpty()){
            return false;
        }
        return true;
    }
*/
}
