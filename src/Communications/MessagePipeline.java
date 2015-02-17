package Communications;

import Communications.Observer;
import java.util.ArrayList;

public class MessagePipeline {
    
    private ArrayList<Observer> observers;
    
    public MessagePipeline()
    {
        observers = new ArrayList<Observer>();
    }
    
    public void attach(Observer ob)
    {
        observers.add(ob);
    }
    
    private void notifyObservers()
    {
        for(Observer ob : observers)
        {
            ob.update();
        }
    }
    
    
}
