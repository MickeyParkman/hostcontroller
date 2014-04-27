/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communications;

import DashboardInterface.DashboardInterface;
import DatabaseUtilities.BlackBoxLogger;
import ParameterSelection.ParamSelectionFrame;

/**
 *
 * @author Alex
 */
public class MessagePipeline {
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
    
    
    public MessagePipeline(Connection comm) {
        filter = new FilterListener(this);
        connection = comm;
        comm.attachFilter(filter);
        
        //TODO Attach a logger
        logger = new BlackBoxLogger();               
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
    
    public void loggMesssage(String message) {
        logger.loggMessage(message);
    }
    
    public void loggMessage(int timestamp, String message) {
        if(logger != null)
            logger.loggMessage(timestamp, message);
    }
    
}
