//Successful IF AIRFIELD EXISTS IN DB!

package AddEditPanels;

import Communications.Observer;
import Configuration.UnitConversionRate;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Runway;
import DatabaseUtilities.DatabaseDataObjectUtilities;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;


public class AddEditRunwayFrame extends JFrame {

    private JPanel contentPane;
    private JTextField magneticHeadingField;
    private JTextField nameField;
    private JTextField altitudeField;
    private CurrentDataObjectSet objectSet;
    private Runway currentRunway;
    private boolean isEditEntry;
    private Observer parent;
    
    public void attach(Observer o)
    {
        parent = o;
    }
    
    /**
     * Create the frame.
     */
    public AddEditRunwayFrame(Runway editRunway, boolean isEditEntry) {
        
        objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();

        if (!isEditEntry || editRunway == null){
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

        nameField = new JTextField(currentRunway.getName());
        nameField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        nameField.setColumns(10);
        nameField.setBounds(140, 11, 200, 20);
        panel.add(nameField);

        altitudeField = new JTextField();
        if (isEditEntry)
        {
            altitudeField.setText(String.valueOf(editRunway.getAltitude()));
        }
        altitudeField.setColumns(10);
        altitudeField.setBounds(140, 61, 200, 20);
        panel.add(altitudeField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(0, 229, 89, 23);
        submitButton.setBackground(new Color(200,200,200));
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
        deleteButton.setBackground(new Color(200,200,200));
        panel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            deleteCommand();
        }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(180, 229, 89, 23);
        clearButton.setBackground(new Color(200,200,200));
        panel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            clearData();
        }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(270, 229, 89, 23);
        cancelButton.setBackground(new Color(200,200,200));
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
                parent.update("2");
                this.dispose();
            }
        }catch (ClassNotFoundException e2) {
            JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e3) {

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
            String name = nameField.getText();
            String magneticHeading = magneticHeadingField.getText();
            float altitude = Float.parseFloat(altitudeField.getText()) / UnitConversionRate.convertDistanceUnitIndexToFactor(0);

            String parentAirfield = "";
            String parentId = "";
            try{
                parentAirfield = objectSet.getCurrentAirfield().getDesignator();
                parentId = objectSet.getCurrentAirfield().getId();
            }catch (Exception e){
                System.out.println("cur Airfield 404 " + e.getMessage());
            }
            

            Runway newRunway = new Runway(name, magneticHeading, parentAirfield, altitude, "");
            newRunway.setId(currentRunway.getId());
            newRunway.setParentId(parentId);
            try{
                objectSet.setCurrentRunway(newRunway);
                Object[] options = {"One-time Launch", "Save to Database"};
                int choice = JOptionPane.showOptionDialog(rootPane, "Do you want to use this Runway for a one-time launch or save it to the database?",
                    "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                System.out.println(choice);
                if (choice == 0){
                    parent.update("2");
                    this.dispose();
                }
                else
                {
                    if (isEditEntry){
                        DatabaseEntryEdit.UpdateEntry(newRunway);
                    }
                    else{
                        Random randomId = new Random();
                        newRunway.setId(String.valueOf(randomId.nextInt(100000000)));
                        while (DatabaseEntryIdCheck.IdCheck(newRunway)){
                            newRunway.setId(String.valueOf(randomId.nextInt(100000000)));
                        }
                        DatabaseUtilities.DatabaseDataObjectUtilities.addRunwayToDB(newRunway);
                    }
                    parent.update("2");
                    this.dispose();
                }
            }catch(SQLException e1) {
                if(e1.getErrorCode() == 30000){
                    System.out.println(e1.getMessage());
                    JOptionPane.showMessageDialog(rootPane, "Sorry, but the runway " + newRunway.toString() + " already exists in the database", "Error", JOptionPane.INFORMATION_MESSAGE);

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
        JOptionPane.showMessageDialog(rootPane, "Please complete all required fields\n" + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        //ew = new ErrWindow("Please complete all required fields\n" + e.getMessage());
        return false;
    }
    return true;
}

}
