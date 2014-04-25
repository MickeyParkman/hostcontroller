package Communications;

import Communications.MessageDataClasses.TensionMsgData;
import java.util.ArrayList;

/**
 *
 * @author Matt
 */
public class FilterListener extends MessageListener
{

    int active_drum; //  This needs to be persistent, where to put?

    ArrayList<MessageListener> listeners = new ArrayList();
    MessagePipeline pipeline;
    TensionMsgData td = new TensionMsgData();

    public FilterListener(MessagePipeline pipeline)
    {
        this.pipeline = pipeline;
    }

    public void msgAvailable(byte[] msg)
    {
        String message = new String(msg);
        CanCnvt msgin = new CanCnvt();

        int result = msgin.convert_msgtobin(message);
        System.out.println(msgin.id & 0xffe00000);

        switch (msgin.id & 0xffe00000)
        {
            case 0x20000000:
                //  Time message
                System.out.println("Time Message");
                
               pipeline.loggMessage(msgin.get_int(0), message);
                
                
                
                
                InternalMessage lnchdata = new InternalMessage(data);
                pipeline.sendinternalmsg(lnchdata);
                
                
                
                
                break;

            case 0x21000000:
                //  Brake Command
                System.out.println("Brake Command");
                pipeline.loggMesssage(message);
                
                
                break;

            case 0x22000000:
                //  Guillotine command
                System.out.println("Guillotine Command");
                break;

            case 0x23000000: //  Contactor command

                System.out.println("Contactor Command");
                break;

            case 0x26000000:
                //  State message
                System.out.println("State Messge");
                
                
                
                
                break;

            case 0x27000000:
                //  Launch Parameter Request message
                System.out.println("Launch Parameter Request");
                
                pipeline.launchParameterRequest();
                
                break;

            case 0x50200000:
                //  control lever statu/data message

                System.out.println("control lever statu/data message");
                break;

            case 0x51400000:
                //  zero odometer from embedded controller command
                System.out.println("zero odometer from embedded controller command");
                break;

            case 0x51800000:
                //  zero tensiometer from embedded controller command
                System.out.println("zero tensiometer from embedded controller command");
                break;

            case 0xa0200000:
                //  evironmental status/data message 
                System.out.println("evironmental status/data message");
                break;

            case 0xa0400000:
                //  wind message
                System.out.println("wind message");
                break;

            default:
                switch (msgin.id & 0xff800000)
                {
                    case 0x24800000:
                        //  Motor/Controller Status
                        System.out.println("Motor/Controller Status");
                        break;
                    case 0x25800000:
                        //  Torque/Speed Command
                        System.out.println("Torque/Speed Command");
                        break;

                    default:
                        switch (msgin.id & 0xff00000)
                        {
                            case 0x36000000:
                                //  active drum status/data during launch message
                                if (((msgin.id & 0x00e00000) >> 17) != active_drum)
                                {
                                    //  Mismatched drum indication
                                    System.out.println("Mismatched Drum Indication");

                                }
                                break;

                            case 0x3a000000:
                                //  active cable angle status/data during launch message
                                if (((msgin.id & 0x00e00000) >> 17) != active_drum)
                                {
                                    //  Mismatched cable angle sensor indication
                                    System.out.println("Mismatched cable angle sensor indication");
                                }
                                break;

                            default:
                                //  unrecognized id
                                System.out.println("Unrecognized ID");
                                System.out.println(msgin.id & 0xffe00000);

                        }

                }

        }

    }
}

    // notify all attached listeners after message is filtered
        /*for(MessageListener ml: listeners){
     ml.msgAvailable(msg);
     }*/
    


