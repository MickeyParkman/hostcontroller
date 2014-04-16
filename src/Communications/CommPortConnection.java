/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communications;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.TooManyListenersException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class CommPortConnection implements Connection{
    private ArrayList<FilterListener> filters = new ArrayList<FilterListener>();
    InputStream inputStream;
    OutputStream outputStream;
    SerialPort serialPort;
    private byte[] readBuffer = new byte[64];
    
    public CommPortConnection() {
        initConnection();
        MessageThrower thrower = new MessageThrower();
        Thread t = new Thread(thrower);
        t.start();        
    } 
    
    private void initConnection() {
        String comPortID = "COM3";
        try {
            CommPortIdentifier port = CommPortIdentifier.getPortIdentifier(comPortID);
            serialPort = (SerialPort) port.open(comPortID, 5000);
            serialPort.setSerialPortParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            inputStream = serialPort.getInputStream();
            outputStream = serialPort.getOutputStream();
            this.setSerialEventHandler();
        } catch (NoSuchPortException ex) {
            //TODO handle exception
        } catch (PortInUseException ex) {
            //TODO handle exception
        } catch (UnsupportedCommOperationException ex) {
            //TODO handle exception
        } catch (IOException ex) {
            //TODO handle exception
        }
        
    }
    
    public void attachFilter(FilterListener newFilter) {
        filters.add(newFilter);
    }
    
    public void notify(byte[] msg) {
        for(FilterListener filter : filters) {
            filter.msgAvailable(msg);
        }
    }
    
    private void setSerialEventHandler() {
        try {
           // Add the serial port event listener
           serialPort.addEventListener(new SerialEventHandler());
           serialPort.notifyOnDataAvailable(true);
        } catch (TooManyListenersException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private void readSerial() {
        try {
            int availableBytes = inputStream.available();
                if (availableBytes > 0) {
                // Read the serial port
                inputStream.read(readBuffer, 0, availableBytes);
                    notify(readBuffer);
                }
            } catch (IOException e) {
        }
    }
    
    private class SerialEventHandler implements SerialPortEventListener {
        public void serialEvent(SerialPortEvent event) {
            switch (event.getEventType()) {
            case SerialPortEvent.DATA_AVAILABLE:
                readSerial();
                break;
            }
        }
    }
    
    private void testPort() {
        String serialMessage = "AT\r\n";
        String serialMessage2 = "IT\r\n";
        //System.out.println(serialMessage.getBytes().length);
        try {
                outputStream.write(serialMessage.getBytes());
                outputStream.write(serialMessage2.getBytes());
        } catch (IOException ex) {
            //Testing, don't need to do anything for now
        }
        
    }
    
    private class MessageThrower implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
                testPort();
            } catch (InterruptedException ex) {
                Logger.getLogger(CommPortConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
