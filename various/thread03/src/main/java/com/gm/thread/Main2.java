package com.gm.thread;

import java.net.*;
import java.io.*;

/**
 * Demonstrates non-standard thread cancellation.
 *
 */
public class Main2 {

    /**
     * Thread.sleep() support and respond to interruption. 
     */
    static class SleepThread extends Thread {


    	// interrupt() is optional - in this case, Thread.sleep() in run() responds to interrupt by itself     
        @Override
        public void interrupt() {
        	
        	System.out.println("In interrupt() of the thread");
        	super.interrupt();

        }
        
        

        @Override
        public void run() {
        	System.out.println("In run() of the thread");
            while (true) {
                try {
                	System.out.println("In run() of the thread: Starting sleep in loops");
                    Thread.sleep(1000);
                } catch (Exception se) {
                	System.out.println("In run() of the thread: Caught exception and breaking");
                    break;
                }
            }
        }
    }

    /**
     * Main entry point.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	
        SleepThread cst = new SleepThread();
        
        // starting a socket
        System.out.println("Starting the thread - which creates a socket that listens endlessly");
        cst.start();
        
        System.out.println("Starting a sleep - in the main program, while thread is running in background");
        Thread.sleep(3000);
        
        System.out.println("Interrupting the thread");
        cst.interrupt();
        
        System.out.println("Completed interrupting the thread");
    }
}