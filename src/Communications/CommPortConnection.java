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
import java.util.Enumeration;
import java.util.TooManyListenersException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Connection to the embedded system over a CommPort in which the class listens 
 * for messages on the CommPort and then sends them off to the filter
 *
 * @author Alex
 */
public class CommPortConnection implements Connection{
    //Items listening to this object
    private ArrayList<FilterListener> filters = new ArrayList<FilterListener>();
    private InputStream inputStream;
    private OutputStream outputStream;
    private SerialPort serialPort;
    private byte[] readBuffer = new byte[64];
    
    public CommPortConnection() {
        initConnection();
        MessageThrower thrower = new MessageThrower();
        Thread t = new Thread(thrower);
        t.start();        
    } 
    
    /**
     * Sets up connection to CommPort using RXTX library
     */
    private void initConnection() {
        Enumeration ports = CommPortIdentifier.getPortIdentifiers();
        ArrayList portList = new ArrayList();
        String portArray[] = null;
        while (ports.hasMoreElements()) {
            CommPortIdentifier port = (CommPortIdentifier) ports.nextElement();
            if (port.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                portList.add(port.getName());
            }
        }
        portArray = (String[]) portList.toArray(new String[0]);
        
        String comPortID = (String) JOptionPane.showInputDialog(null, "Select A Com Port: ", "Com Port Select", JOptionPane.INFORMATION_MESSAGE, null, portArray, "COM1");
        
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
    
    /**
     * Reads a message off the CommPort using an InputStream
     */
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

    @Override
    public void start() {
        //Not used for this class
    }

    @Override
    public void stop() {

    }
    
    /**
     * Listens for incoming serial messages on the CommPort
     */
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
    /**
     * Threaded class set up to throw messages out onto the ComPort to be routed
     * right back and simulate incoming messages
     */
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
