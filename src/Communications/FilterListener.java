package Communications;

import java.util.ArrayList;

/**
 *
 * @author Matt
 */
public class FilterListener extends MessageListener{
   int active_drum; //  This needs to be persistent, where to put?
    
    
    ArrayList<MessageListener> listeners  = new ArrayList();
    
    public FilterListener(){
   
        CanCnvt msgin = new CanCnvt();

        msgin.convert_msgtobin(msg)
        if ((msgin.id & 0xffe00000 ) == 0x20000000 )
        {
            //  Time message
            
        } else if ((msgin.id & 0xffe00000) == 0x21000000)
        {
            //  Brake Command
            
        } else if ((msgin.id & 0xffe00000) == 0x22000000)
        {
            //  Guillotine command
            
        } else if ((msgin.id & 0xffe00000) == 0x23000000)
        {
            //  Contactor command
            
        } else if ((msgin.id & 0xffe00000) == 0x00000)
        {
            //  Motor/Controller status/data
                        
        } else if ((msgin.id & 0xffe00000) == 0x00000)
        {
            //  Torque/Speed Command
                                   
        } else if ((msgin.id & 0xffe00000) == 0x26000000)
        {
            //  State message
            
        } else if ((msgin.id & 0xffe00000) == 0x27000000)
        {
            //  Launch Parameter Request message
            
        } else if ((msgin.id & 0xff00000) == 0x36000000)
        {
            //  active drum status/data during launch message
            if (((msgin.id & 0x00e00000) >> 17) != active_drum)
            {
                //  Mismatched drum indication
            }
        } 
        else if ((msgin.id & 0xff00000) == 0x3a000000) 
        {
            //  active cable angle status/data during launch message
            if (((msgin.id & 0x00e00000) >> 17) != active_drum)
            {
                //  Mismatched cable angle sensor indication
            }
        } else if ((msgin.id & 0xffe00000) == 0x50200000)
                {
                    //  control lever statu/data message
                    
                } else if ((msgin.id & 0xffe00000) == 0x51400000)
                {
                    //  zero odometer from embedded controller command
                }
        else if ((msgin.id & 0xffe00000) == 0x51800000)
                {
                    //  zero odometer from embedded controller command
                    
                } else if ((msgin.id & 0xffe00000) == 0xa0200000)
                {
                    //  evironmental status/data message 
                    
                } else if ((msgin.id & 0xffe00000) == 0xa0400000)
                {
                    //  wind message
                }

    }

      
        /*
         * space for George's code
         */
        System.out.println(new String(msg));
        
        // notify all attached listeners after message is filtered
        for(MessageListener ml: listeners){
            ml.msgAvailable(msg);
        }
        
    }
    
    public void addMessageListener(MessageListener ml) {
        listeners.add(ml);
    }
    
    
}
