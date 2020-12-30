package com.gm.thread;

import java.net.*;
import java.io.*;

/**
 * Demonstrates non-standard thread cancellation.
 *
 */
public class Main1 {

    /**
     * ServerSocket.accept() doesn't detect or respond to interruption. 
     * The class below overrides the interrupt() method to support 
     * non-standard cancellation by canceling the underlying 
     * ServerSocket forcing the accept() method to throw Exception, 
     * on which we act by breaking the while loop.
     */
    static class CancelleableSocketThread extends Thread {

        private final ServerSocket server;

        public CancelleableSocketThread(int port) throws IOException {
            server = new ServerSocket(port);
        }

        @Override
        public void interrupt() {
        	
        	System.out.println("In interrupt() of the thread");
            try {
            	System.out.println("In interrupt() of the thread: Caught interrupt, closing the socket");
                server.close();
            } catch (IOException ignored) {
            } finally {
            	System.out.println("In interrupt() of the thread, in 'finally' part: interrupting the thread");
                super.interrupt();
            }
        }

        @Override
        public void run() {
        	System.out.println("In run() of the thread");
            while (true) {
                try {
                	System.out.println("In run() of the thread: Opening the socket to accept requests");
                    Socket client = server.accept();
                } catch (Exception se) {
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
    	
        CancelleableSocketThread cst = new CancelleableSocketThread(8080);
        
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