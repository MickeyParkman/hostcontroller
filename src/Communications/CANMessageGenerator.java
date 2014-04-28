/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communications;

import DataObjects.Airfield;
import DataObjects.Pilot;
import DataObjects.Position;
import DataObjects.Runway;
import DataObjects.Sailplane;

/**
 *
 * @author Alex
 */
public class CANMessageGenerator
{

    MessagePipeline pipeline;

    public CANMessageGenerator(MessagePipeline pipeline)
    {
        this.pipeline = pipeline;
    }

    public void generateAndSendLaunchParameters(Pilot pilot, Sailplane sailplane, Airfield airfield, Runway runway, Position position)
    {
        CanCnvt tempMsg = new CanCnvt();

        if (pilot != null && sailplane != null && Airfield != null)
        {
            //  this is where computation of launch parameters would go
            
            //  first launch parameter messages would go here
            
            //  this would be the last parameter message 
            //  the 111 id ending signifying final message 
            tempMsg.id = 0x28E00000;
            tempMsg.dlc = 1;
            tempMsg.set_byte(0, 0);  //  dummy launch parameter payload
            pipeline.logAndSendMessage(tempMsg);

        } else  //  send parameters not available message
        {
            tempMsg.id = 0x28E00000;
            tempMsg.dlc = 0;    //  dlc == 0 signifies parameters not available
            pipeline.logAndSendMessage(tempMsg);
        }

        
        //To log and send the message. I am under the impression it's going
        //to be in a hex string fromat like the incoming messages, but this
        //can be modified if needed.
        
        //  No, this method sends a CanCnvt object to be logged and sent; the
        //  .logAndSendMessage method produces a ASCII hex string to be logged 
        //  sent

    }

}
