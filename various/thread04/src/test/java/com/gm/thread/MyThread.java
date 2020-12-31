package com.gm.thread;

class MyThread extends Thread {
	
	   boolean waiting = true;
	   boolean ready = false;
	   
	   // Constructor - empty a we are not setting any variables, attributes etc
	   MyThread() {
	   }
	   
	   // run() method
	   public void run() {
		   
	      String thrdName = Thread.currentThread().getName();
	      System.out.println("In thread: " + thrdName + " starting.");
	      
	      //while(waiting) System.out.println("waiting:" + waiting); 
	      
	      System.out.println("waiting running startWait() method ...");
	     
	      startWait(); 
	      
	      try {
	    	 
	    	 System.out.println("sleeping with Thread.sleep() ...");
	         Thread.sleep(10000);
	         
	      // can use 'Exception' or 'InterruptedException' 
	      } catch(Exception exc) {
	         System.out.println("In thread: Thread.sleep() interrupted.");
	      }
	      
	      System.out.println("In thread: Thread.sleep() terminating.");
	      
	   }
	   
	   // method
	   synchronized void startWait() {
	      try {
	         while(!ready) wait();
	         
	      // can use 'Exception' or 'InterruptedException' (original code used InterruptedException)
	      } catch(Exception exc) {
	    	  
	    	 // if sent interrupt instead of notice()
	         System.out.println("In thread: wait() interrupted");
	      }
	      
	      // if sent notice() instead of interrupt, thread task on hand comes out gracefully
	      System.out.println("In thread: wait() completed");
	   }
	   
	   // method
	   synchronized void notice() {
	      ready = true;
	      notify();
	   }
	}
