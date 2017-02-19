//Successful
package AddEditPanels;

import Communications.Observer;
import Configuration.UnitConversionRate;
import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Airfield;
import DatabaseUtilities.DatabaseEntryDelete;
import DatabaseUtilities.DatabaseEntryEdit;
import DatabaseUtilities.DatabaseEntryIdCheck;
import java.sql.SQLException;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class AddEditAirfieldFrame extends AddEditPanel{    
    @FXML private TextField airfieldAltitudeField;
    @FXML private TextField designatorField;
    @FXML private TextField airfieldNameField;
    @FXML private TextField magneticVariationField;
    @FXML private TextField airfieldLongitudeField;
    @FXML private TextField airfieldLatitudeField;
    @FXML private TextArea optionalInformationArea;
    
    private Airfield currentAirfield;
    private CurrentDataObjectSet objectSet;
    private boolean isEditEntry;
    private Observer parent;
    @FXML private Label airfieldAltitudeUnitsLabel;
    private int airfieldAltitudeUnitsID;        
        
    public void setupUnits()
    {
        airfieldAltitudeUnitsID = objectSet.getCurrentProfile().getUnitSetting("airfieldAltitude");
        String airfieldAltitudeUnitsString = UnitLabelUtilities.lenghtUnitIndexToString(airfieldAltitudeUnitsID);
        airfieldAltitudeUnitsLabel.setText(airfieldAltitudeUnitsString);
    }
    
    public void attach(Observer o)
    {
        parent = o;
    }

    public AddEditAirfieldFrame(SubScene airfieldPanel)
    {
        super(airfieldPanel);
    }
    
    public void edit(Airfield editAirfield) {
        objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
        setupUnits();
                
        isEditEntry = editAirfield != null;
        currentAirfield = editAirfield;        
        
        if (isEditEntry){
            airfieldNameField.setText(currentAirfield.getName());
            designatorField.setText(currentAirfield.getDesignator());
            airfieldAltitudeField.setText(String.valueOf(currentAirfield.getElevation() * UnitConversionRate.convertDistanceUnitIndexToFactor(airfieldAltitudeUnitsID)));        
            magneticVariationField.setText(String.valueOf(currentAirfield.getMagneticVariation()));        
            airfieldLongitudeField.setText(String.valueOf(currentAirfield.getLongitude()));        
            airfieldLatitudeField.setText(String.valueOf(currentAirfield.getLatitude()));
        }        
    }        
    
    public void deleteCommand(){

            /*int choice = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete " + currentAirfield.getName() + "?"
                    + "\n This will also delete all runways on this airfield and glider and winch positions associated with those runways.",
                    "Delete Airfield", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (choice == 0){*/
                DatabaseEntryDelete.DeleteEntry(currentAirfield);
                CurrentDataObjectSet objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
                objectSet.clearAirfield();
                //JOptionPane.showMessageDialog(rootPane, currentAirfield.toString() + " successfully deleted.");
                parent.update("1");
                //this.dispose();
            //}
    }
    
    public boolean submitData(){
        if (isComplete()){
            String airfieldName = airfieldNameField.getText();
            String designator = designatorField.getText();
            float airfieldAltitude = Float.parseFloat(airfieldAltitudeField.getText()) / UnitConversionRate.convertDistanceUnitIndexToFactor(airfieldAltitudeUnitsID);
            float magneticVariation = Float.parseFloat(magneticVariationField.getText());
            float airfieldLatitude = Float.parseFloat(airfieldLatitudeField.getText());
            float airfieldLongitude = Float.parseFloat(airfieldLongitudeField.getText());
            
            Airfield newAirfield = new Airfield(airfieldName, designator, airfieldAltitude,
                    magneticVariation, airfieldLatitude, airfieldLongitude, "");            
            
            try{
                CurrentDataObjectSet ObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
                ObjectSet.setCurrentAirfield(newAirfield);
                /*Object[] options = {"One-time Launch", "Save to Database"};
                int choice = JOptionPane.showOptionDialog(rootPane, "Do you want to use this Airfield for a one-time launch or save it to the database?",
                    "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                System.out.println(choice);
                if (choice == 0){
                    parent.update("1");
                    this.dispose();
                }
                else
                {
                */    if (isEditEntry){
                        newAirfield.setId(currentAirfield.getId());
                        DatabaseEntryEdit.UpdateEntry(newAirfield);
                    }
                    else{
                        Random randomId = new Random();
                        newAirfield.setId(randomId.nextInt(100000000));
                        while (DatabaseEntryIdCheck.IdCheck(newAirfield)){
                            newAirfield.setId(randomId.nextInt(100000000));
                        }
                        DatabaseUtilities.DatabaseEntryInsert.addAirfieldToDB(newAirfield);
                    }
                parent.update("1"); 
                return true;
               /*     this.dispose();
                } 
                */
            }catch(SQLException e1) {
                if(e1.getErrorCode() == 30000)
                    System.out.println(e1.getMessage());
                    //JOptionPane.showMessageDialog(rootPane, "Sorry, but the airfield " + newAirfield.toString() + " already exists in the database", "Error", JOptionPane.INFORMATION_MESSAGE);
            }catch (ClassNotFoundException e2) {
                //JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception e3){
                System.out.println(e3.getMessage());
            }            
        }  
        return false;
    }
    
    public boolean isComplete(){
        try
        {
            boolean emptyFields = false;
            String airfieldName = airfieldNameField.getText();
            String designator = designatorField.getText();
            String airfieldAltitude = airfieldAltitudeField.getText();
            String magneticVariation = magneticVariationField.getText();
            String airfieldLatitude = airfieldLatitudeField.getText();
            String airfieldLongitude = airfieldLongitudeField.getText();
            
            airfieldNameField.setStyle(whiteBackground);
            designatorField.setStyle(whiteBackground);
            airfieldAltitudeField.setStyle(whiteBackground);
            magneticVariationField.setStyle(whiteBackground);
            airfieldLatitudeField.setStyle(whiteBackground);
            airfieldLongitudeField.setStyle(whiteBackground);
            
            if(airfieldName.isEmpty())
            {
                airfieldNameField.setStyle(redBackground);
                emptyFields = true;
            }
            if(designator.isEmpty())
            {
                designatorField.setStyle(redBackground);
                emptyFields = true;
            }
            if(airfieldAltitude.isEmpty())
            {
                airfieldAltitudeField.setStyle(redBackground);
                emptyFields = true;
            }
            if(magneticVariation.isEmpty())
            {
                magneticVariationField.setStyle(redBackground);
                emptyFields = true;
            }
            if(airfieldLatitude.isEmpty())
            {
                airfieldLatitudeField.setStyle(redBackground);
                emptyFields = true;
            }
            if(airfieldLongitude.isEmpty())
            {
                airfieldLongitudeField.setStyle(redBackground);
                emptyFields = true;
            }
            if (emptyFields){
                throw new Exception("");
            }
            
            Float.parseFloat(airfieldAltitude);
            Float.parseFloat(magneticVariation);
            Float.parseFloat(airfieldLatitude);
            Float.parseFloat(airfieldLongitude);
            
        }catch(NumberFormatException e){
            //JOptionPane.showMessageDialog(rootPane, "Please input correct numerical values", "Error", JOptionPane.INFORMATION_MESSAGE);
            //ew = new ErrWindow("Please input correct numerical values");
            return false;
        }catch(Exception e){
            //JOptionPane.showMessageDialog(rootPane, "Please complete all required fields\n" + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            //ew = new ErrWindow("Please complete all required fields\n" + e.getMessage());
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
        
        airfieldNameField.setStyle(whiteBackground);
        designatorField.setStyle(whiteBackground);
        airfieldAltitudeField.setStyle(whiteBackground);
        magneticVariationField.setStyle(whiteBackground);
        airfieldLatitudeField.setStyle(whiteBackground);
        airfieldLongitudeField.setStyle(whiteBackground);
        
    } 

}
