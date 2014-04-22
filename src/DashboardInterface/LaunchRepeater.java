
package DashboardInterface

import Communications.*
import DatabaseUtilities.*

public class LaunchRepeater {
	
	private DashboardListener dashboardListener;
	private ArrayList<InternalMessage> messageList;
	
	public LaunchRepeater(DashboardListener dl, PreviousLaunch pl){
		dashboardListener = dl; 
		messageList = DatabaseLaunchMessageUtilities.getMessagesForLaunch(pl)
		
		for(InternalMessage im: messageList)
		{
			dashboardListener.msgAvailable(im);
		}
	}	
	
}
