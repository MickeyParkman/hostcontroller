
<ckage Communications;

import java.util.ArrayList;

/**
 *
 * @author Gisela Arreola-Gutierrez
 */
public class DashboardListener extends MessageListener{
    
    ArrayList<MessageListener> listeners  = new ArrayList();
    
    public DashboardListener(){
        
    }

    @Override
    //update for speed graph 
    public void updateSpeedDial(byte[] msg) {
        
  
        
        for(MessageListener ml: listeners){
            ml.msgAvailable(msg);
        }
        
    }
    @Override
    //update for tension graph	
    public void updateTensionGraph(byte[] msg) {
        
  
        
        for(MessageListener ml: listeners){
            ml.msgAvailable(msg);
        }
        
    }

    @Override
    //update for tension dial
    public void updateTensionDial(byte[] msg) {
        
  
        
        for(MessageListener ml: listeners){
            ml.msgAvailable(msg);
        }
        
    }

    @Override
    //update for systemStatus	
    public void updateSystemStatus(byte[] msg) {
        
  
        
        for(MessageListener ml: listeners){
            ml.msgAvailable(msg);
        }
        
    }

    @Override
    //update for sateMachine panel
    public void updateSateMachinePanel(byte[] msg) {
        
  
        
        for(MessageListener ml: listeners){
            ml.msgAvailable(msg);
        }
        
    }
    @Override
    //update for speed graph
    public void updateSpeedGraph(byte[] msg) {
        
  
        
        for(MessageListener ml: listeners){
            ml.msgAvailable(msg);
        }
        
    }
    @Override
    //update for Environmental	
    public void updateEnvironmental(byte[] msg) {
        
  
        
        for(MessageListener ml: listeners){
            ml.msgAvailable(msg);
        }
        
    }
        public void addMessageListener(MessageListener ml) {
        listeners.add(ml);
    }
    
    
}
