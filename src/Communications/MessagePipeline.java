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
 * The MessagePipeline is the entity that connects up a connection (Socket, CommPort,
 * File, etc) a Filter, the loggers and the display so that they can all know 
 * about each other and interact with each other. 
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
    DashboardInterface dashboard = null;
    
    //Logger for the pipeline for logging all messages
    BlackBoxLogger logger;
    
    //CANMessageGenerator msgGenerator;
    
    
    public MessagePipeline(Connection comm) {
        filter = new FilterListener(this);
        connection = comm;
        comm.attachFilter(filter);
        
        //TODO Attach a logger
        logger = new BlackBoxLogger(); 
        
        //msgGenerator = new CANMessageGenerator(this);
    }
    
    /**
     * Starts up the parameter selection page for this pipeline
     * 
     * @throws MessagePipelineException 
     */
    public void startParameterSelection() throws MessagePipelineException {
        if(filter != null) {
            paramSelection = new ParamSelectionFrame(this);
            paramSelection.setVisible(true);    
        }
        else{
            MessagePipelineException exception = new MessagePipelineException();
            exception.setErrorMessage("No MessageFilter Atached");
            throw exception;
        }
    }
    
    /**
     * Starts up the dashboard display page for this pipeline
     * 
     * @throws MessagePipelineException 
     */
    public void startDashboard() throws MessagePipelineException {
        if(filter != null) {
            dashboard = new DashboardInterface();
            dashboard.setVisible(true);
            connection.stop();
            filter.restartFile();
            dashboard.resetState();
            connection.start();
        }
        else {
            MessagePipelineException exception = new MessagePipelineException();
            exception.setErrorMessage("No MessageFilter Atached");
            throw exception;
        }
    }
    
    /**
     * Sends out an Ascii message to the embedded system from a CanCnvrt message
     * @param asciiMessage 
     */
    public void sendAsciiMessage(String asciiMessage) {
        
    }
    
    /**
     * Uses the CanBus message logger attached to the pipeline to log the raw 
     * CanBus message
     * 
     * @param message the message to log
     */
    public void logMessage(String message) {
        if(logger != null);
            //logger.loggMessage(message);
    }
    
    /**
     * Uses the CanBus message logger attached to the pipeline to log the raw 
     * CanBus message with an associated timestamp
     * 
     * @param message the message to log
     */
    public void logMessage(int timestamp, String message) {
        if(logger != null);
            //logger.loggMessage(timestamp, message);
    }
    
    /**
     * Method to be called when a request for launch parameters comes in form 
     * the embedded system
     */
    public void launchParametersRequested() {
        Pilot pilot = null;
        Sailplane sailplane = null;
        Airfield airfield = null;
        Runway runway = null;
        Position position = null;
        paramSelection.getSelectedLaunchElements(pilot, sailplane, airfield, runway, position);
        //msgGenerator.generateAndSendLaunchParameters(pilot, sailplane, airfield, runway, position);
    }
    
    /**
     * Method to be called when a new launch is starting (signaled by specific
     * state change)
     */
    public void signalNewLaunchStarting() {
        
    }
    
    /**
     * Method to be called when new InternalMessage with launch data is available from the Filter
     * 
     * @param internalMsg the new launch data
     */
    public void signalNewLaunchdataAvaialbe(InternalMessage internalMsg) {
        if(dashboard != null) {
            dashboard.updateDisplay(internalMsg);
        }
    }
    
    /**
     * Method to log and pass on an outgoing message to the embedded system
     * 
     * @param byteMessage the message to be logged and passed on to the embedded system
     */
    public void logAndSendMessage(CanCnvt byteMessage) 
    {        
        byteMessage.seq = sequenceNumber;
        sequenceNumber += 1;
            
        String asciiMessage = byteMessage.msg_prep();
        logMessage(asciiMessage);
        sendAsciiMessage(asciiMessage);
        //TODO send out messgae to com port/socket
    }

    /**
     * Method to be called at the end of a launch
     */
    void signalLaunchEnded() {
        dashboard.markEndLaunch();
    }
    
    public void closeLaunch() {
        
    }
}
