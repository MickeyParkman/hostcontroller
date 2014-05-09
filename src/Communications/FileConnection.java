/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communications;

import java.util.ArrayList;

/**
 * For reading CanBus messages from a file for testing. NOT IMPLEMENTED YET!
 * 
 * @author Alex
 */
public class FileConnection implements Connection{
    private ArrayList<FilterListener> filters = new ArrayList<FilterListener>();
    
    public FileConnection() {
            
    }
    
    public void attachFilter(FilterListener newFilter) {
        filters.add(newFilter);
    }
    
    public void notify(byte[] msg) {
        for(FilterListener filter : filters) {
            filter.msgAvailable(msg);
        }
    }
    
    private void readFromFile() {
        //TODO add read in form file and call notify
    }

    @Override
    public void start() {
        //Not used for this class
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
