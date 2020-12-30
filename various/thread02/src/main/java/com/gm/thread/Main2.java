package com.gm.thread;

public class Main2 {
	
	public static void main(String[] args) throws Exception {
		
	    /**
	    * A Thread which is responsive to Interruption.
	    */
	    class ResponsiveToInterruption extends Thread {
	    	@Override
	    	public void run() {
	    	    while(true) { // Long running loop
	    	        try {
	    	        	System.out.println("[Interruption Responsive Thread] Alive");
	    	            Thread.sleep(Long.MAX_VALUE);
	    	        } catch (InterruptedException exit) {
	    	        	System.out.println("[Interruption Responsive Thread] bye**");
	    	            break; //End the loop on interruption
	    	        }
	    	    }
	    	}
	    }

	    /**
	    * Thread that is oblivious to Interruption. It does not even check it's
	    * interruption status and doesn't even know it was interrupted.
	    */
	    class ObliviousToInterruption extends Thread {
	        @Override public void run() {
	            while (true) {
	                System.out.println("[Interruption Oblivious Thread] Alive");
	            }
	            // The statement below will never be reached.
	            //System.out.println("[Interruption Oblivious Thread] bye");
	        }
	    }

	    Thread theGood = new ResponsiveToInterruption();
	    //Thread theUgly = new ObliviousToInterruption();

	    theGood.start();
	    //theUgly.start();

	    theGood.interrupt(); // The thread will stop itself
	    //theUgly.interrupt(); // Will do nothing
	}

}
