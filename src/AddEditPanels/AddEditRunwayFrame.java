
package AddEditPanels;

import Communications.Observer;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Runway;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddEditRunwayFrame extends AddEditPanel {
    
    @FXML private TextField magneticHeadingField;
    @FXML private TextField nameField;
    private CurrentDataObjectSet objectSet;
    private Runway currentRunway;
    private boolean isEditEntry;
    private Observer parent;
    @FXML private Label magneticHeadingUnitsLabel;
    
    public void attach(Observer o)
    {
        parent = o;
    }
    
    public AddEditRunwayFrame(SubScene runwayPanel) { super(runwayPanel); }
    
    public void edit(Runway editRunway, boolean isEditEntry) {
        objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
        //setupUnits();

        if (!isEditEntry || editRunway == null){
            editRunway = new Runway("", 0, "");
        }
        this.isEditEntry = isEditEntry;
        currentRunway = editRunway;
        
        if (isEditEntry)
        {
            magneticHeadingField.setText(String.valueOf(currentRunway.getMagneticHeading()));
        }        
    }
    
    /*public void deleteCommand()
    {
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

    }

    public void clearData(){
        nameField.setText("");
        magneticHeadingField.setText("");
        //altitudeField.setText("");

        nameField.setBackground(Color.WHITE);
        magneticHeadingField.setBackground(Color.WHITE);
        //altitudeField.setBackground(Color.WHITE);
    }
    
    protected void submitData(){
        if (isComplete()){
            String name = nameField.getText();
            float magneticHeading = Float.parseFloat(magneticHeadingField.getText());
            //float altitude = Float.parseFloat(altitudeField.getText()) / UnitConversionRate.convertDistanceUnitIndexToFactor(runwayAltitudeUnitsID);

            int parentId = 0;
            try{
                parentId = objectSet.getCurrentAirfield().getId();
            }catch (Exception e){
                
            }
            

            Runway newRunway = new Runway(name, magneticHeading, "");
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
                        newRunway.setId(randomId.nextInt(100000000));
                        while (DatabaseEntryIdCheck.IdCheck(newRunway)){
                            newRunway.setId(randomId.nextInt(100000000));
                        }
                        DatabaseUtilities.DatabaseEntryInsert.addRunwayToDB(newRunway);
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
    try
    {
        boolean emptyFields = false;
        String name = nameField.getText();
        String magneticHeading = magneticHeadingField.getText();
        //String altitude = altitudeField.getText();
        nameField.setBackground(Color.WHITE);
        magneticHeadingField.setBackground(Color.WHITE);
        //altitudeField.setBackground(Color.WHITE);

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
        
        Float.parseFloat(magneticHeading);
        //Float.parseFloat(altitude);
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
*/
}
