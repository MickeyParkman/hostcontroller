/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communications.MessageDataClasses;

/**
 *
 * @author gsmoore
 */


public class TensionMsgData
{
    int [] tension = new int [8];
    float [] TensionScale = new float [8];
    int [] TensionOffset = new int [8];

public TensionMsgData ()
{
    TensionScale[0] = 0.3f;
    TensionOffset[0] = -1024;
    
}



}

