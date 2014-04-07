/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        // 1. George will convert the timestamp on the message
        // 2. The message will be logged in the "Log Everything" DB
        // 3. If we're in a launch, then the message will be converted to a Vector
        
        for(MessageListener ml: listeners){
            ml.msgAvailable(msg);
        }
        
    }
    
    public void addMessageListener(MessageListener ml) {
        listeners.add(ml);
    }
    
    
}
