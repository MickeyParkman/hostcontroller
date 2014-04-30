/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communications;

/**
 *
 * @author Alex
 */
public interface Connection {
    void attachFilter(FilterListener newFilter);
    
    void notify(byte[] msg);
    
    void start();
    
    void stop();
}
