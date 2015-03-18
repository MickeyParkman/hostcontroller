//Should be successful if entries in DB are set in the CurrentDataObjectSet
package AddEditPanels;

import DataObjects.CurrentDataObjectSet;
import DataObjects.GliderPosition;
import DatabaseUtilities.DatabaseEntryEdit;
import DatabaseUtilities.DatabaseEntryIdCheck;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;


public class AddEditGliderPosFrame extends JFrame {

    private JPanel contentPane;
    private JTextField latitudeField;
    private JTextField longitudeField;
    private JTextField altitudeField;
    private JTextField nameField;
    private CurrentDataObjectSet objectSet;
    private GliderPosition currentGliderPos;
    private boolean isEditEntry;

    /**
     * Create the frame.
     */
    public AddEditGliderPosFrame(GliderPosition editGliderPos, boolean isEditEntry) {
        objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();

        if (!isEditEntry){
            editGliderPos = new GliderPosition("", "","", 0, 0, 0, "");
        }
        this.isEditEntry = isEditEntry;
        currentGliderPos = editGliderPos;

        setTitle("Glider Position");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        contentPane.add(panel, BorderLayout.CENTER);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 14, 46, 14);
        panel.add(nameLabel);

        JLabel altitudeLabel = new JLabel("Altitude:");
        altitudeLabel.setBounds(10, 39, 46, 14);
        panel.add(altitudeLabel);

        JLabel longitudeLabel = new JLabel("Longitude:");
        longitudeLabel.setBounds(10, 64, 80, 14);
        panel.add(longitudeLabel);

        JLabel latitudeLabel = new JLabel("Latitude:");
        latitudeLabel.setBounds(10, 89, 80, 14);
        panel.add(latitudeLabel);

        latitudeField = new JTextField();
        latitudeField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        if (isEditEntry){
            latitudeField.setText(String.valueOf(currentGliderPos.getLatitude()));
        }
        latitudeField.setColumns(10);
        latitudeField.setBounds(135, 86, 200, 20);
        panel.add(latitudeField);

        longitudeField = new JTextField();
        longitudeField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        if (isEditEntry){
            longitudeField.setText(String.valueOf(currentGliderPos.getLongitude()));
        }
        longitudeField.setColumns(10);
        longitudeField.setBounds(135, 61, 200, 20);
        panel.add(longitudeField);

        altitudeField = new JTextField();
        altitudeField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        if (isEditEntry){
            altitudeField.setText(String.valueOf(currentGliderPos.getAltitude()));
        }
        altitudeField.setColumns(10);
        altitudeField.setBounds(135, 36, 200, 20);
        panel.add(altitudeField);

        nameField = new JTextField(currentGliderPos.getGliderPositionId());
        nameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        nameField.setColumns(10);
        nameField.setBounds(135, 11, 200, 20);
        panel.add(nameField);
        
        JLabel ParentAirfieldLabel = new JLabel("Parent Airfield: ");
        ParentAirfieldLabel.setBounds(10, 126, 220, 14);
        panel.add(ParentAirfieldLabel);
        
        try{
        JLabel ParentAirfieldNameLabel = new JLabel(objectSet.getCurrentAirfield().getName());
        ParentAirfieldNameLabel.setBounds(135, 126, 220, 14);
        panel.add(ParentAirfieldNameLabel);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        JLabel parentRunwayLabel = new JLabel("Parent Runway: ");
        parentRunwayLabel.setBounds(10, 151, 220, 14);
        panel.add(parentRunwayLabel);
        try{
        JLabel parentRunwayNameLabel = new JLabel(objectSet.getCurrentRunway().getId());
        parentRunwayNameLabel.setBounds(135, 151, 220, 14);
        panel.add(parentRunwayNameLabel);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        

        JLabel requiredNoteLabel = new JLabel("All fields are required");
        requiredNoteLabel.setBounds(10, 210, 200, 14);
        panel.add(requiredNoteLabel);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(0, 228, 89, 23);
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                submitData();
            }
        });
        
        JButton deleteButton = new JButton("Delete");
        deleteButton.setEnabled(isEditEntry);
        deleteButton.setBounds(90, 228, 89, 23);
        panel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                deleteCommand();
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setEnabled(!isEditEntry);
        clearButton.setBounds(180, 228, 89, 23);
        panel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                clearData();
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(270, 228, 89, 23);
        panel.add(cancelButton);
        
        JLabel latitudeUnits = new JLabel("degrees");
        latitudeUnits.setBounds(345, 89, 65, 14);
        panel.add(latitudeUnits);
        
        JLabel longitudeUnits = new JLabel("degrees");
        longitudeUnits.setBounds(345, 64, 65, 14);
        panel.add(longitudeUnits);
        
        JLabel altitudeUnits = new JLabel("m");
        altitudeUnits.setBounds(345, 39, 46, 14);
        panel.add(altitudeUnits);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });
    }
	
    public void deleteCommand(){
        try{
            int choice = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete " + currentGliderPos.getGliderPositionId() + "?",
                "Delete Glider Position", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (choice == 0){
                DatabaseUtilities.DatabaseEntryDelete.DeleteEntry(currentGliderPos);
                objectSet.cleafGliderPosition();
                JOptionPane.showMessageDialog(rootPane, currentGliderPos.toString() + " successfully deleted.");
                this.dispose();
            }
        }catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.");
        }catch (Exception e3) {

        }
    }

    public void clearData(){
        nameField.setText("");
        altitudeField.setText("");
        longitudeField.setText("");
        latitudeField.setText("");
        nameField.setBackground(Color.WHITE);
        altitudeField.setBackground(Color.WHITE);
        longitudeField.setBackground(Color.WHITE);
        latitudeField.setBackground(Color.WHITE);
    }
    
    protected void submitData(){
        if (isComplete()){
            String gliderPosId = nameField.getText();
            int altitude = Integer.parseInt(altitudeField.getText());
            float longitude = Float.parseFloat(longitudeField.getText());
            float latitude = Float.parseFloat(latitudeField.getText());
            
            String runwayParent = "";
            String runwayParentId = "";
            String airfieldParent = "";
            String airfieldParentId = "";
            
            try{
                runwayParent = objectSet.getCurrentRunway().getName();
                runwayParentId = objectSet.getCurrentRunway().getId();
                airfieldParent = objectSet.getCurrentAirfield().getDesignator();
                airfieldParentId = objectSet.getCurrentAirfield().getId();
            }catch (Exception e){
                System.out.println("cur runway or airfield 404 " + e.getMessage());
            }
            
            GliderPosition newGliderPos = new GliderPosition(gliderPosId, 
                    runwayParent, airfieldParent, altitude,
                    latitude, longitude, "");
            newGliderPos.setId(currentGliderPos.getId());
            newGliderPos.setRunwayParentId(runwayParentId);
            newGliderPos.setAirfieldParentId(airfieldParentId);
            try{
                if (isEditEntry){
                    DatabaseEntryEdit.UpdateEntry(newGliderPos);
                }
                else{
                    Random randomId = new Random();
                    newGliderPos.setId(String.valueOf(randomId.nextInt(100000000)));
                    while (DatabaseEntryIdCheck.IdCheck(newGliderPos)){
                        newGliderPos.setId(String.valueOf(randomId.nextInt(100000000)));
                    }
                    DatabaseUtilities.DatabaseDataObjectUtilities.addGliderPositionToDB(newGliderPos);
                }
                objectSet.setCurrentGliderPosition(newGliderPos);
                JOptionPane.showMessageDialog(rootPane, "Submission successfully saved.");
                dispose();
            }catch(SQLException e1) {
                if(e1.getErrorCode() == 30000){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, "Sorry, but the Glider Position " + newGliderPos.toString() + " already exists in the database");
                }
            }catch (ClassNotFoundException e2) {
                JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.");
            } catch (Exception e3) {

            }
        }
    }

    public boolean isComplete()
    {
    ErrWindow ew;
    try
    {
        boolean emptyFields = false;
        String name = nameField.getText();
        String altitude = altitudeField.getText();
        String longitude = longitudeField.getText();
        String latitude = latitudeField.getText();
        nameField.setBackground(Color.WHITE);
        altitudeField.setBackground(Color.WHITE);
        longitudeField.setBackground(Color.WHITE);
        latitudeField.setBackground(Color.WHITE);

        if(name.isEmpty())
        {
            nameField.setBackground(Color.PINK);
            emptyFields = true;
        }
        if(altitude.isEmpty())
        {
            altitudeField.setBackground(Color.PINK);
            emptyFields = true;
        }
        if(longitude.isEmpty())
        {
            longitudeField.setBackground(Color.PINK);
            emptyFields = true;
        }
        if(latitude.isEmpty())
        {
            latitudeField.setBackground(Color.PINK);
            emptyFields = true;
        }

        if (emptyFields){
            throw new Exception("");
        }
        Integer.parseInt(altitude);
        Float.parseFloat(longitude);
        Float.parseFloat(latitude);
        
    }catch(NumberFormatException e){
        ew = new ErrWindow("Please input correct numerical values");
        return false;
    }catch(Exception e){
        ew = new ErrWindow("Please complete all required fields\n" + e.getMessage());
        return false;
    }
    return true;
}

}
