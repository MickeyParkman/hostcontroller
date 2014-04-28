/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communications;

import DashboardInterface.DashboardInterface;
import DataObjects.Airfield;
import DataObjects.Pilot;
import DataObjects.Position;
import DataObjects.Runway;
import DataObjects.Sailplane;
import DatabaseUtilities.BlackBoxLogger;
import ParameterSelection.ParamSelectionFrame;

/**
 *
 * @author Alex
 */
public class MessagePipeline {
    
    int sequenceNumber = 0;
    
    //Comm Port Connection for the pipeline
    Connection connection;
    
    //Message Filter for the pipeline for filtering incoming messages
    FilterListener filter;
    
    //Parameter Selection window for the pipeline for elsecting components
    //of a launch
    ParamSelectionFrame paramSelection;
    
    //Dashboard for the pipeline
    DashboardInterface dashboard;
    
    //Logger for the pipeline for logging all messages
    BlackBoxLogger logger;
    
    CANMessageGenerator msgGenerator;
    
    
    public MessagePipeline(Connection comm) {
        filter = new FilterListener(this);
        connection = comm;
        comm.attachFilter(filter);
        
        //TODO Attach a logger
        logger = new BlackBoxLogger(); 
        
        msgGenerator = new CANMessageGenerator(this);
    }
    
    public void startParameterSelection() throws MessagePipelineException {
        if(filter != null) {
            paramSelection = new ParamSelectionFrame();
            paramSelection.setVisible(true);    
        }
        else{
            MessagePipelineException exception = new MessagePipelineException();
            exception.setErrorMessage("No MessageFilter Atached");
            throw exception;
        }
    }
    
    public void startDashboard() throws MessagePipelineException {
        if(filter != null) {
            
        }
        else {
            MessagePipelineException exception = new MessagePipelineException();
            exception.setErrorMessage("No MessageFilter Atached");
            throw exception;
        }
    }
    
    public void sendAsciiMessage(String asciiMessage) {
        
    }
    
    public void logMessage(String message) {
        logger.loggMessage(message);
    }
    
    public void logMessage(int timestamp, String message) {
        if(logger != null)
            logger.loggMessage(timestamp, message);
    }
    
    public void launchParametersRequested() {
        Pilot pilot = null;
        Sailplane sailplane = null;
        Airfield airfield = null;
        Runway runway = null;
        Position position = null;
        paramSelection.getSelectedLaunchElements(pilot, sailplane, airfield, runway, position);
        msgGenerator.generateAndSendLaunchParameters(pilot, sailplane, airfield, runway, position);
    }
    
    public void signalNewLaunchStarting() {
        
    }
    
    public void signalNewLaunchdataAvaialbe() {
        
    }
    
    public void logAndSendMessage(String message) {
        CanCnvt tempConvert = new CanCnvt();
        sequenceNumber += 1;
        
        String asciiMessage = tempConvert.msg_prep();
        logMessage(asciiMessage);
        sendAsciiMessage(asciiMessage);
        //TODO send out messgae to com port/socket
    }
}
