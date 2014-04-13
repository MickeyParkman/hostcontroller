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
        
        for(MessageListener ml: listeners){
            ml.msgAvailable(msg);
        }
        
    }
    
    public void addMessageListener(MessageListener ml) {
        listeners.add(ml);
    }
    
    
}
