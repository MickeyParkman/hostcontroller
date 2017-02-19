//Should be successful if entries in DB are set in the CurrentDataObjectSet
package AddEditPanels;

import Communications.Observer;
import Configuration.UnitConversionRate;
import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;
import DataObjects.WinchPosition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.SubScene;
import javafx.scene.control.TextArea;

public class AddEditWinchPosFrame extends AddEditPanel {    
    @FXML private TextField latitudeField;
    @FXML private TextField longitudeField;
    @FXML private TextField altitudeField;
    @FXML private TextField nameField;
    @FXML private TextArea optionalInformationArea;
    private CurrentDataObjectSet objectSet;
    private WinchPosition currentWinchPos;
    private boolean isEditEntry;
    private Observer parent;
    @FXML private Label winchPosAltitudeUnitsLabel; 
    private int winchPosAltitudeUnitsID;
      
    public void setupUnits()
    {
        winchPosAltitudeUnitsID = objectSet.getCurrentProfile().getUnitSetting("winchPosAltitude");
        String winchPosAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(winchPosAltitudeUnitsID);
        winchPosAltitudeUnitsLabel.setText(winchPosAltitudeUnitsString);
    }
    
    public void attach(Observer o)
    {
        parent = o;
    }
    
    public AddEditWinchPosFrame(SubScene winchPosPanel) { super(winchPosPanel); }
    
    public void edit(WinchPosition editWinchPos, boolean isEditEntry) {
        objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
        setupUnits();

        if (!isEditEntry || editWinchPos == null){
            editWinchPos = new WinchPosition("", 0, 0, 0, "");
        }
        this.isEditEntry = isEditEntry;
        currentWinchPos = editWinchPos;
       
        if (isEditEntry){
            latitudeField.setText(String.valueOf(currentWinchPos.getLatitude()));
            longitudeField.setText(String.valueOf(currentWinchPos.getLongitude()));
            altitudeField.setText(String.valueOf((currentWinchPos.getElevation()
                    * UnitConversionRate.convertDistanceUnitIndexToFactor(winchPosAltitudeUnitsID))));
        }
    }
	    
    /*public void deleteCommand(){
        int choice = JOptionPane.showConfirmDialog(rootPane, 
            "Are you sure you want to delete " + currentWinchPos.getName() + "?",
            "Delete Winch Position", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (choice == 0){
            DatabaseUtilities.DatabaseEntryDelete.DeleteEntry(currentWinchPos);
            objectSet.cleafGliderPosition();
            JOptionPane.showMessageDialog(rootPane, currentWinchPos.toString() + " successfully deleted.");
            parent.update("4");
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
            String winchPosId = nameField.getText();
            float altitude = Float.parseFloat(altitudeField.getText()) 
                    / UnitConversionRate.convertDistanceUnitIndexToFactor(winchPosAltitudeUnitsID);
            float longitude = Float.parseFloat(longitudeField.getText());
            float latitude = Float.parseFloat(latitudeField.getText());
            
            int runwayParentId = 0;
            
            try{
                runwayParentId = objectSet.getCurrentRunway().getId();
            }catch (Exception e){
                
            }
            
            WinchPosition newWinchPos = new WinchPosition(winchPosId, altitude,
                    latitude, longitude, "");
            newWinchPos.setId(currentWinchPos.getId());
            newWinchPos.setRunwayParentId(runwayParentId);
            try{
                objectSet.setCurrentWinchPosition(newWinchPos);
                Object[] options = {"One-time Launch", "Save to Database"};
                int choice = JOptionPane.showOptionDialog(rootPane, 
                        "Do you want to use this Winch Position for a one-time launch or save it to the database?",
                    "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);     
                if (choice == 0){
                    parent.update("4");
                    this.dispose();
                }
                else
                {
                    if (isEditEntry){
                        DatabaseUtilities.DatabaseEntryEdit.UpdateEntry(newWinchPos);
                    }
                    else{
                        Random randomId = new Random();
                        newWinchPos.setId(randomId.nextInt(100000000));
                        while (DatabaseEntryIdCheck.IdCheck(newWinchPos)){
                            newWinchPos.setId(randomId.nextInt(100000000));
                        }
                        DatabaseUtilities.DatabaseEntryInsert.addWinchPositionToDB(newWinchPos);
                    }
                    parent.update("4");
                    this.dispose();
                }
            }catch(SQLException e1) {
                if(e1.getErrorCode() == 30000){

                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, "Sorry, but the Winch Position " 
                            + newWinchPos.toString() + " already exists in the database");
                }
            }catch (ClassNotFoundException e2) {
                JOptionPane.showMessageDialog(rootPane, 
                        "Error: No access to database currently. Please try again later.", 
                        "Error", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(rootPane, "Please input correct numerical values", 
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            //ew = new ErrWindow("Please input correct numerical values");
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Please complete all required fields\n" 
                    + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            //ew = new ErrWindow("Please complete all required fields\n" + e.getMessage());
            return false;
        }
        return true;
    }
*/
}
