package Communications;

import Communications.MessageDataClasses.TensionMsgData;
import java.util.ArrayList;

/**
 *
 * @author Matt
 */
public class FilterListener extends MessageListener
{

    private final float timeTick = 1.0f / 64.0f;
    private final int numbDrums = 1;
    private final int numbMotors = 1;
    private final int referenceMotor = 0;

    //  variables for CIC3 filters, 
    private final int decimationFactor = 8;
    private final float gainCIC = decimationFactor ^ 3;
    private final float groupDelay = ((decimationFactor - 1) / 2.0f)
            * 3.0f * timeTick;

    private int downCounter;

    private final int numbCICs = 4;
    //   0 -  tension, 1 - cable angle, 2 - cable out, 3 - motor speed
    private int[] i1 = new int[numbCICs];
    private int[] i2 = new int[numbCICs];
    private int[] i3 = new int[numbCICs];
    private int[] c1 = new int[numbCICs];
    private int[] c2 = new int[numbCICs];
    private int[] c3 = new int[numbCICs];

    //  variables, scales, and offsets for last values recieved in messages
    private int[] lastTension = new int[numbDrums];
    private final float tensionScale = 1.0f / 4.0f;
    private final int tensionOffset = 1024;

    private int[] lastCableAngle = new int[numbDrums];
    private final float cableAngleScale = 1.0f / 2.0f;  //  degrees per lsb    
    private final int cableAngleOffset = 40;

    private int[] lastCableOut = new int[numbDrums];
    private final float cableOutScale = 1.0f / 16.0f;
    private final int cableOutOffset = 4096;

    private int[] lastMotorSpeed = new int[numbMotors];
    private final float motorSpeedScale = 1.0f / 128.0f;

    private double startTime;

    private int lastIntTime;
    private int lastFracTime;
    private double lastTime;
    private double currentTime;

    private int lastControlLever;
    private final float controlLeverScale = 1.0f / (2.0f * 100);  // 1/2 percent per bit
    private final int controlLeverOffset = 28;

    private int lastState;
    private int activeDrum;
    private boolean launchActive;

    

    InternalMessage intData = new InternalMessage();

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

        int motor = msgin.id & 0x00600000;
        int drum  = msgin.id & 0x00e00000;

        switch (msgin.id & 0xffe00000)
        {
            case 0x20000000:
                //  Time message
                System.out.println("Time Message");

                if (msgin.dlc == 1)
                {
                    //  fractional second tick
                    lastFracTime = msgin.get_byte(0);
                    currentTime = (lastIntTime) + lastFracTime
                            * (1.0f / 64);
                    //  ??  should there be gg in logg
                    pipeline.logMessage(message);

                } else if (msgin.dlc == 4)
                {
                    //  intergral second
                                                        
                    pipeline.logMessage(lastIntTime = msgin.get_int(0), message);
                    lastFracTime = 0;
                    currentTime = lastIntTime; 
                    
                } else
                {
                    System.out.println("Invalid Time Message Payload Length");
                }

                //   Update CIC filter integrators
                //   0 -  tension, 1 - cable angle, 2 - cable out, 3 - motor speed
                i1[0] += lastTension[activeDrum];
                i2[0] += i1[0];
                i3[0] += i2[0];

                i1[1] += lastCableAngle[activeDrum];
                i2[1] += i1[1];
                i3[1] += i2[1];

                i1[2] += lastCableOut[activeDrum];
                i2[2] += i1[2];
                i3[2] += i2[2];

                i1[3] += lastMotorSpeed[referenceMotor];
                i2[3] += i1[3];
                i3[3] += i2[3];

                downCounter -= 1;

                if (downCounter <= 0)
                {
                    downCounter = decimationFactor - 1; //  reset down counter
                    //  update the comb functions and set the output values
                    int ctmpe, ctmpo;

                    ctmpo = i3[0] - c1[0];
                    c1[0] = i3[0];
                    ctmpe = ctmpo - c2[0];
                    c2[0] = ctmpo;
                    ctmpo = ctmpe - c3[0];
                    c3[0] = ctmpe;
                    intData.setTension((float) (((double) ctmpo / gainCIC - tensionOffset)
                            * tensionScale));

                    ctmpo = i3[1] - c1[1];
                    c1[1] = i3[1];
                    ctmpe = ctmpo - c2[1];
                    c2[1] = ctmpo;
                    ctmpo = ctmpe - c3[1];
                    c3[1] = ctmpe;
                    intData.setCableAngle((ctmpo / gainCIC - cableAngleOffset)
                            * cableAngleScale);

                    ctmpo = i3[2] - c1[2];
                    c1[2] = i3[2];
                    ctmpe = ctmpo - c2[2];
                    c2[2] = ctmpo;
                    ctmpo = ctmpe - c3[2];
                    c3[2] = ctmpe;
                    intData.setCableOut((float) (((double) ctmpo / gainCIC - cableOutOffset)
                            * cableOutScale));

                    ctmpo = i3[3] - c1[3];
                    c1[3] = i3[3];
                    ctmpe = ctmpo - c2[3];
                    c2[3] = ctmpo;
                    ctmpo = ctmpe - c3[3];
                    c3[3] = ctmpe;
                    intData.setCableSpeed(ctmpo * (motorSpeedScale / gainCIC));

                    //  elasped time includes correction for CIC group delay and
                    //  data being from one tick before
                    intData.setElaspedTime((float)(currentTime - startTime)
                            - (groupDelay + timeTick));

                    //  case??
                    if (launchActive)
                    {
                        pipeline.signalNewLaunchdataAvaialbe();
                    }

                }

                lastTime = currentTime;

                break;

            case 0x26000000:
                //  State message
                System.out.println("State Messge");
                int tmp = msgin.get_ubyte(0);
                int tmpState = tmp & 0xf;
                int tmpActiveDrum = tmp & 0xf0;

                /*
                 State Assignments
                 0      SAFE
                 1      PREP
                 2      ARMED
                 3      PROFILE
                 4      RAMP
                 5      CONSTANT
                 6      RECOVERY
                 7      RETRIEVE
                 14 (E) STOP
                 15 (F) ABORT                    
                 */
                if (lastState != tmpState)
                //  state change
                {
                    intData.setState(tmpState);

                    if (activeDrum != tmpActiveDrum)
                    {
                        intData.setActiveDrum(activeDrum = tmpActiveDrum);
                    }

                    switch (intData.state)
                    {
                        case 3:
                            if (!launchActive)
                            {
                                //     new launch begining
                                launchActive = true;
                                intData.setStartTime(lastTime);
                                intData.setElaspedTime(-(groupDelay + timeTick));
                                pipeline.signalNewLaunchStarting();   //  ??case
                                pipeline.signalNewLaunchdataAvaialbe(); //  ??case
                            } else
                            {
                                System.out.println("Entry into Profile State with Launch Active");
                            }
                            break;

                        case 1:
                            //  this should be end of launch for demo only
                            intData.setLauchActive(launchActive = false);
                            break;
                    }
                }
                break;

            case 0xa0200000:
                //  evironmental status/data message 
                System.out.println("evironmental status/data message");
                break;

            case 0xa0400000:
                //  wind message
                System.out.println("wind message");
                break;

            case 0x27000000:
                //  Launch Parameter Request message
                System.out.println("Launch Parameter Request");

                pipeline.launchParametersRequested();
                break;

            case 0x50200000:
                //  control lever statu/data message
                System.out.println("control lever statu/data message");

                intData.setControlLever(lastControlLever = msgin.get_ubyte(1));
                break;

            case 0x21000000:
                //  Brake Command
                System.out.println("Brake Command");
                break;

            case 0x22000000:
                //  Guillotine command
                System.out.println("Guillotine Command");
                break;

            case 0x23000000:
                //  Contactor command
                System.out.println("Contactor Command");
                break;

            case 0x51400000:
                //  zero odometer from embedded controller command
                System.out.println("zero odometer from embedded controller command");
                break;

            case 0x51800000:
                //  zero tensiometer from embedded controller command
                System.out.println("zero tensiometer from embedded controller command");
                break;

            default:
                switch (msgin.id & 0xff800000)
                {
                    case 0x24800000:
                        //  Motor/Controller Status
                        System.out.println("Motor/Controller Status");

                        lastMotorSpeed[motor] = msgin.get_short(1);
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
                                lastCableOut[drum] = msgin.get_short(1);

                                if (drum != activeDrum)
                                {
                                    //  Mismatched drum indication
                                    System.out.println("Mismatched Drum Indication");
                                }
                                break;

                            case 0x3800000:
                                //  active tensiometer status/data during launch
                                lastTension[drum] = msgin.get_short(1);

                                if (drum != activeDrum)
                                {
                                    //  Mismatched tensiometer indication
                                    System.out.println("Mismatched Drum Indication");
                                }
                                break;
                            
                            
                            case 0x3a000000:
                                //  active cable angle status/data during launch message

                                lastCableAngle[drum] = msgin.get_ubyte(1);
                                if (drum != activeDrum)
                                {
                                    //  Mismatched cable angle sensor indication
                                    System.out.println("Mismatched cable angle sensor indication");
                                }
                                break;

                            default:
                                //  unrecognized id
                                System.out.println("Unrecognized ID");
                                System.out.println(msgin.id & 0xffe00000);
                                break;

                                //  still need decodes for low high/low priority messages
                        }
                }
        }
    }
}

    // notify all attached listeners after message is filtered
        /*for(MessageListener ml: listeners){
 ml.msgAvailable(msg);
 }*/
