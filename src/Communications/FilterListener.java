package Communications;

import java.util.ArrayList;

/**
 *
 * @author Matt
 */
public class FilterListener extends MessageListener{
    
    ArrayList<MessageListener> listeners  = new ArrayList();
    
    public FilterListener(){
        
    }

    @Override
    public void msgAvailable(byte[] msg) {
        
        /*
         * space for George's code
         */
        
        // notify all attached listeners after message is filtered
        for(MessageListener ml: listeners){
            ml.msgAvailable(msg);
        }
        
    }
    
    public void addMessageListener(MessageListener ml) {
        listeners.add(ml);
    }
    
    
}
