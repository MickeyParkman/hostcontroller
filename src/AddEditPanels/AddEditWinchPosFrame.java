//Should be successful if entries in DB are set in the CurrentDataObjectSet
package AddEditPanels;

import DataObjects.CurrentDataObjectSet;
import DataObjects.WinchPosition;
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
import javax.swing.JOptionPane;


public class AddEditWinchPosFrame extends JFrame {

    private JPanel contentPane;
    private JTextField latitudeField;
    private JTextField longitudeField;
    private JTextField altitudeField;
    private JTextField nameField;
    private CurrentDataObjectSet objectSet;
    private WinchPosition currentWinchPos;
    private boolean isEditEntry;

    /**
     * Create the frame.
     */
    public AddEditWinchPosFrame(WinchPosition editWinchPos, boolean isEditEntry) {
        objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();

        if (!isEditEntry){
            editWinchPos = new WinchPosition("", "", 0, 0, 0, "");
        }
        this.isEditEntry = isEditEntry;
        currentWinchPos = editWinchPos;

        setTitle("Winch Position");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
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
        if (isEditEntry){
            latitudeField.setText(String.valueOf(currentWinchPos.getLatitude()));
        }
        latitudeField.setColumns(10);
        latitudeField.setBounds(135, 86, 200, 20);
        panel.add(latitudeField);

        longitudeField = new JTextField();
        if (isEditEntry){
            longitudeField.setText(String.valueOf(currentWinchPos.getLongitude()));
        }
        longitudeField.setColumns(10);
        longitudeField.setBounds(135, 61, 200, 20);
        panel.add(longitudeField);

        altitudeField = new JTextField();
        if (isEditEntry){
            altitudeField.setText(String.valueOf(currentWinchPos.getAltitude()));
        }
        altitudeField.setColumns(10);
        altitudeField.setBounds(135, 36, 200, 20);
        panel.add(altitudeField);

        nameField = new JTextField(currentWinchPos.getName());
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
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });
    }
	
    public void deleteCommand(){
        try{
            DatabaseUtilities.DatabaseEntryDelete.DeleteEntry(currentWinchPos);
            objectSet.cleafGliderPosition();
            
            JOptionPane.showMessageDialog(rootPane, currentWinchPos.toString() + " successfully deleted.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.", "Error", JOptionPane.INFORMATION_MESSAGE);
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
            int altitude = Integer.parseInt(altitudeField.getText());
            float longitude = Float.parseFloat(longitudeField.getText());
            float latitude = Float.parseFloat(latitudeField.getText());
            
            String winchPosId = currentWinchPos.getName();
            if (!isEditEntry){
                winchPosId = nameField.getText();
            }
            
            String parent = "";
            try{
                parent = objectSet.getCurrentRunway().getId();
            }catch (Exception e){
                System.out.println("cur runway 404 " + e.getMessage());
            }
            
            WinchPosition newWinchPos = new WinchPosition(winchPosId, parent,
                    altitude, latitude, longitude, "");
            try{
                if (isEditEntry){
                    DatabaseUtilities.DatabaseEntryEdit.UpdateEntry(newWinchPos);
                }
                else
                {
                    DatabaseUtilities.DatabaseDataObjectUtilities.addWinchPositionToDB(newWinchPos);
                }
                objectSet.setCurrentWinchPosition(newWinchPos);
                JOptionPane.showMessageDialog(rootPane, "Submission successfully saved.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }catch(SQLException e1) {
                if(e1.getErrorCode() == 30000){
                    System.out.println(e1.getMessage());
                    JOptionPane.showMessageDialog(rootPane, "Sorry, but the Winch Position " + newWinchPos.toString() + " already exists in the database", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch (ClassNotFoundException e2) {
                JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.", "Error", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(rootPane, "Please input correct numerical values", "Error", JOptionPane.INFORMATION_MESSAGE);
            //ew = new ErrWindow("Please input correct numerical values");
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Please complete all required fields\n" + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            //ew = new ErrWindow("Please complete all required fields\n" + e.getMessage());
            return false;
        }
        return true;
    }

}
