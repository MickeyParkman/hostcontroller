//Successful IF AIRFIELD EXISTS IN DB!

package AddEditPanels;

import DataObjects.CurrentDataObjectSet;
import DataObjects.Runway;
import DatabaseUtilities.DatabaseDataObjectUtilities;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AddEditRunwayFrame extends JFrame {

    private JPanel contentPane;
    private JTextField magneticHeadingField;
    private JTextField nameField;
    private JTextField altitudeField;
    private CurrentDataObjectSet objectSet;
    private Runway currentRunway;
    private boolean isEditEntry;

    /**
     * Create the frame.
     */
    public AddEditRunwayFrame(Runway editRunway, boolean isEditEntry) {
        
        objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();

        if (!isEditEntry){
            editRunway = new Runway("", "", "", 0, "");
        }
        this.isEditEntry = isEditEntry;
        currentRunway = editRunway;

        setTitle("Runway");
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
        nameLabel.setBounds(10, 14, 106, 14);
        panel.add(nameLabel);

        JLabel magneticHeadingLabel = new JLabel("Magnetic Heading:");
        magneticHeadingLabel.setBounds(10, 39, 106, 14);
        panel.add(magneticHeadingLabel);

        JLabel altitudeLabel = new JLabel("Altitude:");

        altitudeLabel.setBounds(10, 64, 106, 14);
        panel.add(altitudeLabel);

        magneticHeadingField = new JTextField(currentRunway.getMagneticHeading());
        magneticHeadingField.setColumns(10);
        magneticHeadingField.setBounds(140, 36, 200, 20);
        panel.add(magneticHeadingField);

        nameField = new JTextField(currentRunway.getId());
        nameField.setEditable(!isEditEntry);
        nameField.setColumns(10);
        nameField.setBounds(140, 11, 200, 20);
        panel.add(nameField);

        altitudeField = new JTextField();
        if (isEditEntry)
        {
            altitudeField.setText(Integer.toString(editRunway.getAltitude()));
        }
        altitudeField.setColumns(10);
        altitudeField.setBounds(140, 61, 200, 20);
        panel.add(altitudeField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(0, 229, 89, 23);
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            submitData();
        }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.setEnabled(isEditEntry);
        deleteButton.setBounds(90, 229, 89, 23);
        panel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            deleteCommand();
        }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setEnabled(!isEditEntry);
        clearButton.setBounds(180, 229, 89, 23);
        panel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            clearData();
        }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(270, 229, 89, 23);
        panel.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            dispose();
        }
        });

        JLabel requiredNoteLabel = new JLabel("All fields are required");
        requiredNoteLabel.setBounds(10, 210, 200, 14);
        panel.add(requiredNoteLabel);
        
        JLabel parentAirfieldLabel = new JLabel();
        try{
            parentAirfieldLabel .setText("Parent Airfield: " + objectSet.getCurrentAirfield().getDesignator());
        }catch (Exception e){
            System.out.println("cur Airfield 404 " + e.getMessage());
        }
        parentAirfieldLabel.setBounds(10, 100, 220, 14);
        panel.add(parentAirfieldLabel);
    }

    public void deleteCommand()
    {
        try{
            int choice = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete " + currentRunway.getId() + "?"
                    + "\n This will also delete all glider and winch positions associated with this runway.",
                    "Delete Runway", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (choice == 0){
                DatabaseUtilities.DatabaseEntryDelete.DeleteEntry(currentRunway);
                objectSet.clearRunway();
                JOptionPane.showMessageDialog(rootPane, currentRunway.toString() + " successfully deleted.");
                this.dispose();
            }
        }catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.");
        }catch (Exception e3) {
            //e3.printStackTrace();
        }
    }

    public void clearData(){
        nameField.setText("");
        magneticHeadingField.setText("");
        altitudeField.setText("");

        nameField.setBackground(Color.WHITE);
        magneticHeadingField.setBackground(Color.WHITE);
        altitudeField.setBackground(Color.WHITE);
    }
    
    protected void submitData(){
        if (isComplete()){
            String magneticHeading = magneticHeadingField.getText();
            int altitude = Integer.parseInt(altitudeField.getText());
            
            String name = currentRunway.getId();
            if (!isEditEntry){
                name = nameField.getText();
            }

            String parent = "";
            try{
                parent = objectSet.getCurrentAirfield().getDesignator();
            }catch (Exception e){
                System.out.println("cur Airfield 404 " + e.getMessage());
            }
            
            Runway newRunway = new Runway(name, magneticHeading, parent, altitude, "");
            try{
                if (isEditEntry){
                    DatabaseUtilities.DatabaseEntryEdit.UpdateEntry(newRunway);
                }
                else
                {
                    DatabaseDataObjectUtilities.addRunwayToDB(newRunway);
                }
                objectSet.setCurrentRunway(newRunway);
                JOptionPane.showMessageDialog(rootPane, "Submission successfully saved.");
                dispose();
            }catch(SQLException e1) {
                if(e1.getErrorCode() == 30000){
                    System.out.println(e1.getMessage());
                    JOptionPane.showMessageDialog(rootPane, "Sorry, but the runway " + newRunway.toString() + " already exists in the database");
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
        String magneticHeading = magneticHeadingField.getText();
        String altitude = altitudeField.getText();
        nameField.setBackground(Color.WHITE);
        magneticHeadingField.setBackground(Color.WHITE);
        altitudeField.setBackground(Color.WHITE);

        if(name.isEmpty())
        {
            nameField.setBackground(Color.PINK);
            emptyFields = true;
        }
        if(magneticHeading.isEmpty())
        {
            magneticHeadingField.setBackground(Color.PINK);
            emptyFields = true;
        }
        if(altitude.isEmpty())
        {
            altitudeField.setBackground(Color.PINK);
            emptyFields = true;
        }

        if (emptyFields){
            throw new Exception("");
        }
    }catch(Exception e){
        ew = new ErrWindow("Please complete all required fields\n" + e.getMessage());
        return false;
    }
    return true;
}

}
