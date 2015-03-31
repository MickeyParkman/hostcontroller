package Communications;

public class MessageListener implements Observer
{
    static final int ID_OFFSET = 1 << 21;
    static final int TIME_MESSAGE_ID = 256 * ID_OFFSET; // 0x200
    static final int MOTOR_MESSAGE_ID = 296 * ID_OFFSET; // 0x250
    static final int TORQUE_MESSAGE_ID = 300 * ID_OFFSET; // 0x258
    static final int STATE_MESSAGE_ID = 304 * ID_OFFSET; // 0x260
    static final int LAUNCH_PARAM_MESSAGE_ID = 327 * ID_OFFSET; // 0x28e
    static final int TENSION_MESSAGE_ID = 448 * ID_OFFSET; // 0x380
    static final int CABLE_ANGLE_MESSAGE_ID = 464 * ID_OFFSET; // 0x3a0
    static final int PARAM_REQUEST_MESSAGE_ID = 312 * ID_OFFSET; // 0x270
    static final int CP_CONTROL_LEVER_RMT = 328 * ID_OFFSET; // 0x290
    static final int CP_CONTROL_LEVER_LCL = 329 * ID_OFFSET; // 0x292
    static final int CP_CONTROL_LEVER_INPUTS_RMT = 330 * ID_OFFSET; // 0x294
    static final int CP_CONTROL_LEVER_INPUTS_LCL = 331 * ID_OFFSET; // 0x296
    static final int CONTROL_LEVER_MESSAGE_ID = 641 * ID_OFFSET; // 0x502   
    //for now, leave these defined here. I am working on a constant loader that will let you define
    // these in a file then have them globally accessible
    
    public int currentTimestamp; //i believe we decided this was an int?
                    //this would be accessible to classes needing current time
    private DataRelay relay = null;
    
    public MessageListener()
    {
        currentTimestamp = 0;
    }

    //my code will call this function
    public void attachRelay(DataRelay rIn)
    {
        relay = rIn;
    }

    public void update(String msg)
    {
        //decode the CANBUS message here
        CanCnvt canIn = new CanCnvt();//I believe this is the correct call
        canIn.convert_msgtobin(msg);

        switch (canIn.id)
        {
            /////////////////////////////
            //
            //  GEORGE - YOUR CODE HERE
            //
            /////////////////////////////
            case TIME_MESSAGE_ID:
                //do what we need to do with time messages...
                if(relay != null) relay.sendTimeMessage(/*...whatever we need here…*/);
                // any time you call a function from relay, add that IF statement
                break;
            //continue for other messages
            /*case STATE_MESSAGE_ID:
                doMyStateMessageFunction(canIn);
                if(relay != null) relay.sendStateMessage(...some params...);
                break;
            */
        }
    }

    /////////////////////////////////
    //
    //  GEORGE - YOUR FUNCTIONS HERE
    //
    /////////////////////////////////

    public void update(){} //this guy is not used, but needed because we are implementing Observer
}
