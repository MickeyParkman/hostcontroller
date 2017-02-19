package AddEditPanels;

import Communications.Observer;
import Configuration.UnitConversionRate;
import Configuration.UnitLabelUtilities;
import DataObjects.CurrentDataObjectSet;
import DataObjects.Sailplane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class AddEditGlider extends AddEditPanel {
    
    @FXML private TextField nNumberField;
    @FXML private TextField ownerField;
    @FXML private TextField emptyWeightField;
    @FXML private TextField grossWeightField;
    @FXML private TextField stallSpeedField;
    @FXML private TextField weakLinkField;
    @FXML private TextField tensionField;
    @FXML private TextField releaseAngleField;
    @FXML private TextField winchingSpeedField;
    @FXML private TextArea optionalInformationArea;
    private CheckBox ballastCheckBox;
    private CheckBox multipleSeatsCheckBox;
    private Sailplane currentGlider;
    private boolean isEditEntry;
    private Observer parent;
    private CurrentDataObjectSet currentData;
    @FXML private Label emptyWeightUnitsLabel;
    @FXML private Label maxGrossWeightUnitsLabel;
    @FXML private Label stallSpeedUnitsLabel;
    @FXML private Label tensionUnitsLabel;
    @FXML private Label weakLinkStrengthUnitsLabel;
    @FXML private Label winchingSpeedUnitsLabel;
    private int emptyWeightUnitsID;
    private int maxGrossWeightUnitsID;
    private int stallSpeedUnitsID;
    private int tensionUnitsID;
    private int weakLinkStrengthUnitsID;
    private int winchingSpeedUnitsID;        
    
    public void setupUnits()
    {
        emptyWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("emptyWeight");
        String emptyWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(emptyWeightUnitsID);
        emptyWeightUnitsLabel.setText(emptyWeightUnitsString);
        
        maxGrossWeightUnitsID = currentData.getCurrentProfile().getUnitSetting("maxGrossWeight");
        String maxGrossWeightUnitsString = UnitLabelUtilities.weightUnitIndexToString(maxGrossWeightUnitsID);
        maxGrossWeightUnitsLabel.setText(maxGrossWeightUnitsString);
        
        stallSpeedUnitsID = currentData.getCurrentProfile().getUnitSetting("stallSpeed");
        String stallSpeedUnitsString = UnitLabelUtilities.velocityUnitIndexToString(stallSpeedUnitsID);
        stallSpeedUnitsLabel.setText(stallSpeedUnitsString);
                
        tensionUnitsID = currentData.getCurrentProfile().getUnitSetting("maxTension");
        String tensionUnitsString = UnitLabelUtilities.tensionUnitIndexToString(tensionUnitsID);
        tensionUnitsLabel.setText(tensionUnitsString);
        
        weakLinkStrengthUnitsID = currentData.getCurrentProfile().getUnitSetting("weakLinkStrength");
        String weakLinkStrengthUnitsString = UnitLabelUtilities.tensionUnitIndexToString(weakLinkStrengthUnitsID);
        weakLinkStrengthUnitsLabel.setText(weakLinkStrengthUnitsString);
        
        winchingSpeedUnitsID = currentData.getCurrentProfile().getUnitSetting("winchingSpeed");
        String winchingSpeedUnitsString = UnitLabelUtilities.velocityUnitIndexToString(winchingSpeedUnitsID);
        winchingSpeedUnitsLabel.setText(winchingSpeedUnitsString);
    }
    
    public void attach(Observer o)
    {
        parent = o;
    }
    
    public AddEditGlider(SubScene gliderPane)
    {
        super(gliderPane);
    }
    
    public void edit(Sailplane sailplaneEdited, boolean isEditEntry) {
        currentData = CurrentDataObjectSet.getCurrentDataObjectSet();
        setupUnits();
        
        this.isEditEntry = isEditEntry;

        if (!isEditEntry || sailplaneEdited == null){
            sailplaneEdited = new Sailplane("", "", "", "", 0, 0, 0, 0, 0, 0, 0, false, false, "");
        }
        currentGlider = sailplaneEdited;
               
        if (isEditEntry){
            stallSpeedField.setText(String.valueOf(currentGlider.getIndicatedStallSpeed() * UnitConversionRate.convertSpeedUnitIndexToFactor(stallSpeedUnitsID)));        
            grossWeightField.setText(String.valueOf(currentGlider.getMaximumGrossWeight() * UnitConversionRate.convertWeightUnitIndexToFactor(maxGrossWeightUnitsID)));        
            emptyWeightField.setText(String.valueOf(currentGlider.getEmptyWeight() * UnitConversionRate.convertWeightUnitIndexToFactor(emptyWeightUnitsID)));        
            weakLinkField.setText(String.valueOf(currentGlider.getMaxWeakLinkStrength() * UnitConversionRate.convertTensionUnitIndexToFactor(weakLinkStrengthUnitsID)));        
            tensionField.setText(String.valueOf(currentGlider.getMaxTension() * UnitConversionRate.convertTensionUnitIndexToFactor(tensionUnitsID)));        
            releaseAngleField.setText(String.valueOf(currentGlider.getCableReleaseAngle()));        
            winchingSpeedField.setText(String.valueOf(currentGlider.getMaxWinchingSpeed() * UnitConversionRate.convertSpeedUnitIndexToFactor(winchingSpeedUnitsID)));
        }             
    }
    
    /*
    public void deleteCommand(){
            int choice = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete " + currentGlider.getId() + "?",
                "Delete Glider", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (choice == 0){
                DatabaseEntryDelete.DeleteEntry(currentGlider);
                CurrentDataObjectSet objectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
                objectSet.clearGlider();
                JOptionPane.showMessageDialog(rootPane, currentGlider.toString() + " successfully deleted.");
                parent.update();
                this.dispose();
            }
    }
    
    public void submitData(){
        if (isComplete()){
            String nNumber = nNumberField.getText();
            String name = "Planet Express";
            String owner = "Hubert Farnsworth";
            float emptyWeight = (Float.parseFloat(emptyWeightField.getText()) / UnitConversionRate.convertWeightUnitIndexToFactor(emptyWeightUnitsID));
            float grossWeight = Float.parseFloat(grossWeightField.getText()) / UnitConversionRate.convertWeightUnitIndexToFactor(maxGrossWeightUnitsID);
            float stallSpeed = Float.parseFloat(stallSpeedField.getText()) / UnitConversionRate.convertSpeedUnitIndexToFactor(stallSpeedUnitsID);
            float weakLink = Float.parseFloat(weakLinkField.getText()) / UnitConversionRate.convertTensionUnitIndexToFactor(weakLinkStrengthUnitsID);
            float tension = Float.parseFloat(tensionField.getText()) / UnitConversionRate.convertTensionUnitIndexToFactor(tensionUnitsID);
            float releaseAngle = Float.parseFloat(releaseAngleField.getText());
            float winchingSpeed = Float.parseFloat(winchingSpeedField.getText()) / UnitConversionRate.convertSpeedUnitIndexToFactor(winchingSpeedUnitsID);
            boolean carryBallast = ballastCheckBox.isSelected();
            boolean multipleSeats = multipleSeatsCheckBox.isSelected();
            Sailplane newGlider = new Sailplane(nNumber ,name, owner,"", grossWeight,
                    emptyWeight, stallSpeed, winchingSpeed, weakLink, tension,
                    releaseAngle, carryBallast, multipleSeats, "");   
            newGlider.setId(currentGlider.getId());

            try{
                CurrentDataObjectSet ObjectSet = CurrentDataObjectSet.getCurrentDataObjectSet();
                ObjectSet.setCurrentGlider(newGlider);
                Object[] options = {"One-time Launch", "Save to Database"};
                int choice = JOptionPane.showOptionDialog(rootPane, "Do you want to use this Glider for a one-time launch or save it to the database?",
                    "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (choice == 0){
                    parent.update();
                    this.dispose();
                }
                else
                {
                    if (isEditEntry){
                        DatabaseEntryEdit.UpdateEntry(newGlider);
                    }
                    else{
                        Random randomId = new Random();
                        newGlider.setId(randomId.nextInt(100000000));
                        while (DatabaseEntryIdCheck.IdCheck(newGlider)){
                            newGlider.setId(randomId.nextInt(100000000));
                        }
                        DatabaseUtilities.DatabaseEntryInsert.addSailplaneToDB(newGlider);
                    }

                    parent.update();
                    this.dispose();
                } 
            }catch(SQLException e1) {
                e1.printStackTrace();
                logError(e1);
                if(e1.getErrorCode() == 30000)
                    JOptionPane.showMessageDialog(rootPane, "Sorry, but the glider " + newGlider.toString() + " already exists in the database", "Error", JOptionPane.INFORMATION_MESSAGE);
            }catch (ClassNotFoundException e2) {
                JOptionPane.showMessageDialog(rootPane, "Error: No access to database currently. Please try again later.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }
    
    public boolean isComplete(){
        try
        {
            boolean emptyFields = false;
            String nNumber = nNumberField.getText();
            String emptyWeight = emptyWeightField.getText();
            String grossWeight = grossWeightField.getText();
            String stallSpeed = stallSpeedField.getText();
            String weakLink = weakLinkField.getText();
            String tension = tensionField.getText();
            String releaseAngle = releaseAngleField.getText();
            String winchingSpeed = winchingSpeedField.getText();
            
            nNumberField.setBackground(Color.WHITE);
            emptyWeightField.setBackground(Color.WHITE);
            grossWeightField.setBackground(Color.WHITE);
            stallSpeedField.setBackground(Color.WHITE);
            weakLinkField.setBackground(Color.WHITE);
            tensionField.setBackground(Color.WHITE);
            releaseAngleField.setBackground(Color.WHITE);
            winchingSpeedField.setBackground(Color.WHITE);
            
            if(nNumber.isEmpty())
            {
                nNumberField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(emptyWeight.isEmpty())
            {
                emptyWeightField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(grossWeight.isEmpty())
            {
                grossWeightField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(stallSpeed.isEmpty())
            {
                stallSpeedField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(weakLink.isEmpty())
            {
                weakLinkField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(tension.isEmpty())
            {
                tensionField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(releaseAngle.isEmpty())
            {
                releaseAngleField.setBackground(Color.PINK);
                emptyFields = true;
            }
            if(winchingSpeed.isEmpty())
            {
                winchingSpeedField.setBackground(Color.PINK);
                emptyFields = true;
            }    
            if (emptyFields){
                throw new Exception("");
            }
            
            Float.parseFloat(emptyWeight);
            Float.parseFloat(grossWeight);
            Float.parseFloat(stallSpeed);
            Float.parseFloat(weakLink);
            Float.parseFloat(tension);
            Float.parseFloat(releaseAngle);
            Float.parseFloat(winchingSpeed);
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Please input a numerical values", "Error", JOptionPane.INFORMATION_MESSAGE);
            //ew = new ErrWindow("Please input a numerical values");
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Please complete all required fields\n" + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    public void clearData(){
        nNumberField.setText("");
        emptyWeightField.setText("");
        grossWeightField.setText("");
        stallSpeedField.setText("");
        winchingSpeedField.setText("");
        weakLinkField.setText("");
        tensionField.setText("");
        releaseAngleField.setText("");
        ballastCheckBox.setSelected(false);
        multipleSeatsCheckBox.setSelected(false);
        
        nNumberField.setBackground(Color.WHITE);
        emptyWeightField.setBackground(Color.WHITE);
        grossWeightField.setBackground(Color.WHITE);
        stallSpeedField.setBackground(Color.WHITE);
        winchingSpeedField.setBackground(Color.WHITE);
        weakLinkField.setBackground(Color.WHITE);
        tensionField.setBackground(Color.WHITE);
        releaseAngleField.setBackground(Color.WHITE);
        
    }    
*/
}
