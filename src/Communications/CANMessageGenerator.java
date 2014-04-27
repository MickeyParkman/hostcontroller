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
public class CANMessageGenerator {
    MessagePipeline pipeline;
    
    public CANMessageGenerator(MessagePipeline pipeline) {
        this.pipeline = pipeline;
    }
    
    public void generateAndSendLaunchParameters(Pilot pilot, Sailplane sailplane, Airfield airfield, Runway runway, Position position) {
        String message = "Test";
        //Here is where you can do the work to generater a launch parameter
        //message and then call:
        pipeline.logAndSendLaunchParameterMessage(message);
        //To log and send the message. I am under the impression it's going
        //to be in a hex string fromat like the incoming messages, but this
        //can be modified if needed.
        
    }
    
}
