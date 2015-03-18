//Successful
package AddEditPanels;

import DataObjects.CurrentDataObjectSet;
import DataObjects.Airfield;
import DatabaseUtilities.DatabaseEntryDelete;
import DatabaseUtilities.DatabaseEntryEdit;
import DatabaseUtilities.DatabaseEntryIdCheck;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


public class AddEditAirfieldFrame extends JFrame {
    private JPanel airfieldAttributesPanel;
    private JTextField airfieldAltitudeField;
    private JTextField designatorField;
    private JTextField airfieldNameField;
    private JTextField magneticVariationField;
    private JTextField airfieldLongitudeField;
    private JTextField airfieldLatitudeField;
    private Airfield currentAirfield;
    private boolean isEditEntry;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                    public void run() {
                            try {
                                    AddEditAirfieldFrame frame = new AddEditAirfieldFrame(new Airfield("name", "des", 100, 200, 300, 400, "optional"), false);
                                    frame.setVisible(true);
                            } catch (Exception e) {
                                    e.printStackTrace();
                            }
                    }
            });
    }

    /**
     * Create the frame.
     */
    public AddEditAirfieldFrame(Airfield editAirfield, boolean isEditEntry) {
        if (!isEditEntry){
            editAirfield = new Airfield("", "", 0, 0, 0, 0, "");
        }
        currentAirfield = editAirfield;
        this.isEditEntry = isEditEntry;
        setTitle("Airfield");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 650, 242);
        
        airfieldAttributesPanel = new JPanel();
        airfieldAttributesPanel.setBackground(Color.WHITE);
        airfieldAttributesPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(airfieldAttributesPanel);
        airfieldAttributesPanel.setLayout(null);
        
        JLabel designatorLabel = new JLabel("Designator:");
        designatorLabel.setBounds(10, 36, 84, 14);
        airfieldAttributesPanel.add(designatorLabel);
        
        JLabel airfieldAltitudeLabel = new JLabel("Altitude:");
        airfieldAltitudeLabel.setBounds(10, 62, 84, 14);
        airfieldAttributesPanel.add(airfieldAltitudeLabel);
        
        JLabel magneticVariationLabel = new JLabel("Magnetic Variation:");
        magneticVariationLabel.setBounds(10, 87, 120, 14);
        airfieldAttributesPanel.add(magneticVariationLabel);
        
        JLabel airfieldLongitudeLabel = new JLabel("Longitude:");
        airfieldLongitudeLabel.setBounds(10, 112, 84, 14);
        airfieldAttributesPanel.add(airfieldLongitudeLabel);
        
        JLabel airfieldLatitudeLabel = new JLabel("Latitude:");
        airfieldLatitudeLabel.setBounds(10, 137, 84, 14);
        airfieldAttributesPanel.add(airfieldLatitudeLabel);
        
        airfieldAltitudeField = new JTextField();
        airfieldAltitudeField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        if (isEditEntry){
            airfieldAltitudeField.setText(String.valueOf(currentAirfield.getAltitude()));
        }
        airfieldAltitudeField.setBounds(140, 58, 120, 20);
        airfieldAttributesPanel.add(airfieldAltitudeField);
        airfieldAltitudeField.setColumns(10);
        
        designatorField = new JTextField(currentAirfield.getDesignator());
        designatorField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        designatorField.setBounds(140, 33, 120, 20);
        airfieldAttributesPanel.add(designatorField);
        designatorField.setColumns(10);
        
        airfieldNameField = new JTextField(currentAirfield.getName());
        airfieldNameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        airfieldNameField.setBounds(140, 8, 120, 20);
        airfieldAttributesPanel.add(airfieldNameField);
        airfieldNameField.setColumns(10);
        
        magneticVariationField = new JTextField();
        magneticVariationField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        if (isEditEntry){
            magneticVariationField.setText(String.valueOf(currentAirfield.getMagneticVariation()));
        }
        magneticVariationField.setBounds(140, 83, 120, 20);
        airfieldAttributesPanel.add(magneticVariationField);
        magneticVariationField.setColumns(10);
        
        JLabel airfieldNameLabel = new JLabel("Name:");
        airfieldNameLabel.setBounds(10, 11, 46, 14);
        airfieldAttributesPanel.add(airfieldNameLabel);
        
        airfieldLongitudeField = new JTextField();
        airfieldLongitudeField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        if (isEditEntry){
            airfieldLongitudeField.setText(String.valueOf(currentAirfield.getLongitude()));
        }
        airfieldLongitudeField.setBounds(140, 109, 120, 20);
        airfieldAttributesPanel.add(airfieldLongitudeField);
        airfieldLongitudeField.setColumns(10);
        
        airfieldLatitudeField = new JTextField();
        airfieldLatitudeField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        if (isEditEntry){
            airfieldLatitudeField.setText(String.valueOf(currentAirfield.getLatitude()));
        }
        airfieldLatitudeField.setBounds(140, 134, 120, 20);
        airfieldAttributesPanel.add(airfieldLatitudeField);
        airfieldLatitudeField.setColumns(10);
        
        JLabel requiredNoteLabel = new JLabel("All fields are required");
        requiredNoteLabel.setBounds(10, 160, 200, 14);
        airfieldAttributesPanel.add(requiredNoteLabel);
    
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(0, 180, 89, 23);
        airfieldAttributesPanel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                submitData();
            }
        });
        
        JButton deleteButton = new JButton("Delete");
        deleteButton.setEnabled(isEditEntry);
        deleteButton.setBounds(90, 180, 89, 23);
        airfieldAttributesPanel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                deleteCommand();
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setEnabled(!isEditEntry);
        clearButton.setBounds(180, 180, 89, 23);
        airfieldAttributesPanel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                clearData();
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(270, 180, 89, 23);
        airfieldAttributesPanel.add(cancelButton);
        
        JLabel latitudeUnits = new JLabel("degrees");
        latitudeUnits.setBounds(270, 137, 65, 14);
        airfieldAttributesPanel.add(latitudeUnits);
        
        JLabel longitudeUnits = new JLabel("degrees");
        longitudeUnits.setBounds(270, 112, 65, 14);
        airfieldAttributesPanel.add(longitudeUnits);
        
        JLabel magneticVariationUnits = new JLabel("degrees");
        magneticVariationUnits.setBounds(270, 87, 65, 14);
        airfieldAttributesPanel.add(magneticVariationUnits);
        
        JLabel altitudeUnits = new JLabel("m");
        altitudeUnits.setBounds(270, 62, 46, 14);
        airfieldAttributesPanel.add(altitudeUnits);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                cancelCommand();
            }
        });
    }
    
    public void deleteCommand(){
        try{
            int choice = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete " + currentAirfield.getName() + "?"
                    + "\n This will also delete all runways on this airfield and glider and winch positions associated with those runways.",
                    "Delete Airfield", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (choice == 0){
                DatabaseEntryDelete.DeleteEntry(currentAirfield);
                CurrentDataObjectSet objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
                objectSet.clearAirfield();
                JOptionPane.showMessageDialog(rootPane, currentAirfield.toString() + " successfully deleted.");
                this.dispose();
            }
        }catch (ClassNotFoundException e1) {
            JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.");
        }catch (Exception e2){
            e2.printStackTrace();
        }
    }
    
    public void submitData(){
        if (isComplete()){
            String airfieldName = airfieldNameField.getText();
            String designator = designatorField.getText();
            int airfieldAltitude = Integer.parseInt(airfieldAltitudeField.getText());
            int magneticVariation = Integer.parseInt(magneticVariationField.getText());
            float airfieldLatitude = Float.parseFloat(airfieldLatitudeField.getText());
            float airfieldLongitude = Float.parseFloat(airfieldLongitudeField.getText());
            
            Airfield newAirfield = new Airfield(airfieldName, designator, airfieldAltitude,
                    magneticVariation, airfieldLatitude, airfieldLongitude, "");
            newAirfield.setId(currentAirfield.getId());
            
            try{
                if (isEditEntry){
                    DatabaseEntryEdit.UpdateEntry(newAirfield);
                }
                else{
                    Random randomId = new Random();
                    newAirfield.setId(String.valueOf(randomId.nextInt(100000000)));
                    while (DatabaseEntryIdCheck.IdCheck(newAirfield)){
                        newAirfield.setId(String.valueOf(randomId.nextInt(100000000)));
                    }
                    DatabaseUtilities.DatabaseDataObjectUtilities.addAirfieldToDB(newAirfield);
                }
                CurrentDataObjectSet ObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
                ObjectSet.setCurrentAirfield(newAirfield);
                JOptionPane.showMessageDialog(rootPane, "Submission successfully saved.");
                this.dispose();
            }catch(SQLException e1) {
                if(e1.getErrorCode() == 30000)
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, "Sorry, but the airfield " + newAirfield.toString() + " already exists in the database");
            }catch (ClassNotFoundException e2) {
                JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.");
            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }
    
    public boolean isComplete(){
        ErrWindow ew;
        try
        {
            boolean emptyFields = false;
            String airfieldName = airfieldNameField.getText();
            String designator = designatorField.getText();
            String airfieldAltitude = airfieldAltitudeField.getText();
            String magneticVariation = magneticVariationField.getText();
            String airfieldLatitude = airfieldLatitudeField.getText();
            String airfieldLongitude = airfieldLongitudeField.getText();
            
            airfieldNameField.setBackground(Color.WHITE);
            designatorField.setBackground(Color.WHITE);
            airfieldAltitudeField.setBackground(Color.WHITE);
            magneticVariationField.setBackground(Color.WHITE);
            airfieldLatitudeField.setBackground(Color.WHITE);
            airfieldLongitudeField.setBackground(Color.WHITE);
            
            if(airfieldName.isEmpty())
            {
                airfieldNameField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(designator.isEmpty())
            {
                designatorField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(airfieldAltitude.isEmpty())
            {
                airfieldAltitudeField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(magneticVariation.isEmpty())
            {
                magneticVariationField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(airfieldLatitude.isEmpty())
            {
                airfieldLatitudeField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(airfieldLongitude.isEmpty())
            {
                airfieldLongitudeField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if (emptyFields){
                throw new Exception("");
            }
            Integer.parseInt(airfieldAltitude);
            Integer.parseInt(magneticVariation);
            Float.parseFloat(airfieldLatitude);
            Float.parseFloat(airfieldLongitude);
            
        }catch(NumberFormatException e){
            ew = new ErrWindow("Please input correct numerical values");
            return false;
        }catch(Exception e){
            ew = new ErrWindow("Please complete all required fields\n" + e.getMessage());
            return false;
        }
        return true;
    }
    
    public void clearData(){
        airfieldNameField.setText("");
        designatorField.setText("");
        airfieldAltitudeField.setText("");
        magneticVariationField.setText("");
        airfieldLatitudeField.setText("");
        airfieldLongitudeField.setText("");
        
        airfieldNameField.setBackground(Color.WHITE);
        designatorField.setBackground(Color.WHITE);
        airfieldAltitudeField.setBackground(Color.WHITE);
        magneticVariationField.setBackground(Color.WHITE);
        airfieldLatitudeField.setBackground(Color.WHITE);
        airfieldLongitudeField.setBackground(Color.WHITE);
    }
    
    public void cancelCommand(){
        this.dispose();
    }
    
    
}
