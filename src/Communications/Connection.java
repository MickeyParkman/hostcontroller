/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communications;

/**
 * Interface for connections to the pipeline where messages will be received 
 * from the embedded system
 *
 * @author Alex
 */
public interface Connection {
    void attachFilter(FilterListener newFilter);
    
    void notify(byte[] msg);
    
    void start();
    
    void stop();
}
