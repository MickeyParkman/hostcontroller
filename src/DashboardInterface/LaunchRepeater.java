package DashboardInterface;

import Communications.*;
import DatabaseUtilities.*;
import java.util.ArrayList;

public class LaunchRepeater {
	
	private DashboardListener dashboardListener;
	private ArrayList<InternalMessage> messageList;
	
	public LaunchRepeater(DashboardListener dl, PreviousLaunch pl){
		dashboardListener = dl; 
		messageList = (ArrayList) DatabaseLaunchMessageUtilities.getMessagesForLaunch(pl);
		
		for(InternalMessage im: messageList)
		{
			//dashboardListener.msgAvailable(im);
		}
	}	
	
}
