//Should be successful if entries in DB are set in the CurrentDataObjectSet
package AddEditPanels;

import Communications.Observer;
import Configuration.UnitConversionRate;
import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;
import DataObjects.GliderPosition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SubScene;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class AddEditGliderPosFrame extends AddEditPanel {    
    @FXML private TextField latitudeField;
    @FXML private TextField longitudeField;
    @FXML private TextField altitudeField;
    @FXML private TextField nameField;
    @FXML private TextArea optionalInformationArea;
    private CurrentDataObjectSet objectSet;
    private GliderPosition currentGliderPos;
    private boolean isEditEntry;
    private Observer parent;
    @FXML private Label gliderPosAltitudeUnitsLabel; 
    private int gliderPosAltitudeUnitsID;
        
    public void setupUnits()
    {
        gliderPosAltitudeUnitsID = objectSet.getCurrentProfile().getUnitSetting("gliderPosAltitude");
        String GliderPosAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(gliderPosAltitudeUnitsID);
        gliderPosAltitudeUnitsLabel.setText(GliderPosAltitudeUnitsString);
    }
    
    public void attach(Observer o)
    {
        parent = o;
    }
    
    public AddEditGliderPosFrame(SubScene gliderPosPanel) { super(gliderPosPanel); }
    
    public void edit(GliderPosition editGliderPos, boolean isEditEntry) {
        objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
        setupUnits();

        if (!isEditEntry || editGliderPos == null){
            editGliderPos = new GliderPosition("", 0, 0, 0, "");
        }
        this.isEditEntry = isEditEntry;
        currentGliderPos = editGliderPos;
        
        if (isEditEntry){
            latitudeField.setText(String.valueOf(currentGliderPos.getLatitude()));        
            longitudeField.setText(String.valueOf(currentGliderPos.getLongitude()));        
            altitudeField.setText(String.valueOf(currentGliderPos.getElevation() * UnitConversionRate.convertDistanceUnitIndexToFactor(gliderPosAltitudeUnitsID)));
        }        
    }        
	
    /*public void deleteCommand(){
            int choice = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete " + currentGliderPos.getName() + "?",
                "Delete Glider Position", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (choice == 0){
                DatabaseUtilities.DatabaseEntryDelete.DeleteEntry(currentGliderPos);
                objectSet.cleafGliderPosition();
                JOptionPane.showMessageDialog(rootPane, currentGliderPos.toString() + " successfully deleted.");
                parent.update("3");
                this.dispose();
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
            String gliderPosName = nameField.getText();
            float altitude = Float.parseFloat(altitudeField.getText()) 
                    / UnitConversionRate.convertDistanceUnitIndexToFactor(gliderPosAltitudeUnitsID);
            float longitude = Float.parseFloat(longitudeField.getText());
            float latitude = Float.parseFloat(latitudeField.getText());
            
            int runwayParentId = 0;
            
            try{
                runwayParentId = objectSet.getCurrentRunway().getId();
            }catch (Exception e){
                System.out.println("cur runway 404 " + e.getMessage());
            }
            
            GliderPosition newGliderPos = new GliderPosition(gliderPosName, altitude,
                    latitude, longitude, "");
            newGliderPos.setId(currentGliderPos.getId());
            newGliderPos.setRunwayParentId(runwayParentId);
            try{
                objectSet.setCurrentGliderPosition(newGliderPos);
                Object[] options = {"One-time Launch", "Save to Database"};
                int choice = JOptionPane.showOptionDialog(rootPane, 
                        "Do you want to use this Glider Position for a one-time launch or save it to the database?",
                    "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (choice == 0){
                    parent.update("3");
                    this.dispose();
                }
                else
                {
                    if (isEditEntry){
                        DatabaseEntryEdit.UpdateEntry(newGliderPos);
                    }
                    else{
                        Random randomId = new Random();
                        newGliderPos.setId(randomId.nextInt(100000000));
                        while (DatabaseEntryIdCheck.IdCheck(newGliderPos)){
                            newGliderPos.setId(randomId.nextInt(100000000));
                        }
                        DatabaseUtilities.DatabaseEntryInsert.addGliderPositionToDB(newGliderPos);
                    }
                    parent.update("3");
                    dispose();
                }
            }catch(SQLException e1) {
                if(e1.getErrorCode() == 30000){
                    System.out.println(e1.getMessage());
                    JOptionPane.showMessageDialog(rootPane, "Sorry, but the Glider Position " + newGliderPos.toString() + " already exists in the database", "Error", JOptionPane.INFORMATION_MESSAGE);
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
        Float.parseFloat(altitude);
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
*/
}
