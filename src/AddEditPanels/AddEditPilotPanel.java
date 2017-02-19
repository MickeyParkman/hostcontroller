package AddEditPanels;

import Communications.Observer;
import Configuration.UnitConversionRate;
import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Pilot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddEditPilotPanel extends AddEditPanel {
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField middleNameField;
    @FXML private TextField flightWeightField;
    //private ButtonGroup pilotCapability;
    //private ButtonGroup pilotLaunchPref;
    @FXML private TextField emergencyContactNameField;
    @FXML private TextField emergencyContactPhoneField;
    @FXML private TextField medInfoNameField;
    @FXML private TextField medInfoPhoneField;
    @FXML private TextArea optionalInfoField;
    private Pilot currentPilot;
    private boolean isEditEntry;
    private Observer parent;
    private CurrentDataObjectSet currentData;
    private int flightWeightUnitsID;
    @FXML private Label flightWeightUnitsLabel;        
    
    public void setupUnits()
    {
        flightWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("flightWeight");
        String flightWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(flightWeightUnitsID);
        flightWeightUnitsLabel.setText(flightWeightUnitsString);
    }
    
    public void attach(Observer o)
    {
        parent = o;
    }
    
    public AddEditPilotPanel(SubScene pilotPanel) { super(pilotPanel); }
    
    public void edit(Pilot editPilot, boolean isEditEntry) {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        setupUnits();
        
        if (!isEditEntry || editPilot == null){
            editPilot = new Pilot(0, "", "", "", 0, "", 0, "", "", "");
        }
        this.isEditEntry = isEditEntry;
        currentPilot = editPilot;
               
        if (isEditEntry){

            flightWeightField.setText(String.valueOf((currentPilot.getWeight() * UnitConversionRate.convertWeightUnitIndexToFactor(flightWeightUnitsID))));
        }        
        
        String emergencyContact = editPilot.getEmergencyName();
        String emergencyContactName;
        String emergencyContactPhone;
        int p = emergencyContact.indexOf('%');
        if (p >= 0) 
        {
            emergencyContactName = emergencyContact.substring(0, p);
            emergencyContactPhone = emergencyContact.substring(p + 1);
        }
        else
        {
            emergencyContactName = "";
            emergencyContactPhone = "";
        }        
    }            
    
    /*protected void submitData(){
        if (isComplete()){
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String middleName = middleNameField.getText();
            String emergencyContact = emergencyContactNameField.getText() +
                    "%" + emergencyContactPhoneField.getText();
            //String medicalInformation = medInfoNameField.getText() +
            //        "%" + medInfoPhoneField.getText();
            String optionalInformation = optionalInfoField.getText();
            float weight = 0;
            try {
                weight = Float.parseFloat(flightWeightField.getText()) / UnitConversionRate.convertWeightUnitIndexToFactor(flightWeightUnitsID);
            }catch (NumberFormatException e) {
                weight = -1;
            }
            String capability = pilotCapability.getSelection().getActionCommand();
            float preference = Preference
                    .convertPreferenceStringToNum(pilotLaunchPref.getSelection().getActionCommand());
            try{
            int newPilotId = currentPilot.getPilotId();
            Pilot newPilot = new Pilot(newPilotId, firstName, lastName, middleName, 
                        weight, capability, preference, emergencyContact,
                        "", optionalInformation);
            
                CurrentDataObjectSet ObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
                ObjectSet.setCurrentPilot(newPilot);
                Object[] options = {"One-time Launch", "Save to Database"};
                int choice = JOptionPane.showOptionDialog(rootPane, "Do you want to use this Glider Position for a one-time launch or save it to the database?",
                    "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                
                if (choice == 0){
                    parent.update();
                    dispose();
                }
                else
                {
                    if (isEditEntry){
                        DatabaseEntryEdit.updateEntry(newPilot);
                    }
                    else{
                        Random randomId = new Random();
                        newPilot.setPilotId(randomId.nextInt(100000000));
                        while (DatabaseEntryIdCheck.IdCheck(newPilot)){
                            newPilotId = randomId.nextInt(100000000);
                        }
                        DatabaseUtilities.DatabaseEntryInsert.addPilotToDB(newPilot);
                    }

                    parent.update();
                    dispose();
                }
            }catch(SQLException e1) {
                e1.printStackTrace();
            }catch (ClassNotFoundException e2) {
                JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
    
    public void deleteCommand(){
            DatabaseEntryDelete.DeleteEntry(currentPilot);
            CurrentDataObjectSet objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
            objectSet.clearPilot();
            JOptionPane.showMessageDialog(rootPane, currentPilot.toString() + " successfully deleted.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            parent.update();
            this.dispose(); 
    }
    
    public void cancelCommand(){
        this.dispose();
    }
    
    public boolean isComplete()
    {
        try
        {
            boolean emptyFields = false;
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String weightStr = flightWeightField.getText();
            firstNameField.setBackground(Color.WHITE);
            lastNameField.setBackground(Color.WHITE);
            flightWeightField.setBackground(Color.WHITE);
            
            if(firstName.isEmpty())
            {
                firstNameField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(lastName.isEmpty())
            {
                lastNameField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(weightStr.isEmpty())
            {
                flightWeightField.setBackground(Color.PINK);
                emptyFields = true;
            }
            
            if(pilotCapability.getSelection() == null){
                if (pilotLaunchPref.getSelection() == null){
                    throw new Exception("Select Capability and Launch Pref");
                }
                throw new Exception("Select Capability");
            }
            
            if(pilotLaunchPref.getSelection() == null){
                throw new Exception("Select Launch Preference");
            }
            
            if (emptyFields){
                throw new Exception("");
            }
            
            if (!weightStr.isEmpty()){
                Float.parseFloat(weightStr);
            }
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Please input a numerical weight value", "Error", JOptionPane.INFORMATION_MESSAGE);
            //ew = new ErrWindow("Please input a numerical weight value");
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Please complete all required fields\n" + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            //ew = new ErrWindow("Please complete all required fields\n" + e.getMessage());
            return false;
        }
        return true;
    }
    
    public void clearData(){
        firstNameField.setText("");
	lastNameField.setText("");
	middleNameField.setText("");
	flightWeightField.setText("");
        pilotCapability.clearSelection();
        pilotLaunchPref.clearSelection();
        emergencyContactNameField.setText("");
        emergencyContactPhoneField.setText("");
	medInfoNameField.setText("");
	medInfoPhoneField.setText("");
	optionalInfoField.setText("");
        
        firstNameField.setBackground(Color.WHITE);
	lastNameField.setBackground(Color.WHITE);
	flightWeightField.setBackground(Color.WHITE);
    }
*/
}
