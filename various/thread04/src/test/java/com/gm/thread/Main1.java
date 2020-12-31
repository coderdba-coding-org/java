package com.gm.thread;

public class Main1 {
	
	   public static void main(String args[]) throws Exception {
		   
		  System.out.println("MAIN PROGRAM BEGIN");
		  
	      MyThread thrd = new MyThread();
	      thrd.setName("MyThread #1");
	      
	      System.out.println("Thread status before start()");
	      showThreadStatus(thrd);
	      
	      
	      System.out.println("Thread calling start()");
	      thrd.start();
	      
	      Thread.sleep(50);
	      System.out.println("Thread status after first Thread.sleep(50)");
	      showThreadStatus(thrd);
	      thrd.waiting = false;
	      
	      Thread.sleep(50); 
	      System.out.println("Thread status after second Thread.sleep(50)");
	      showThreadStatus(thrd);
	      
	      // send notice to thread so that it finshes work and terminates
	      System.out.println("Sending notice() to thread");
	      thrd.notice();
	      //thrd.interrupt();
	      
	      //System.out.println("Sending another notice() to thread");
	      //thrd.notice();
	      
	      //System.out.println("Sending an interrupt after first notice() to thread");
	      //Thread.sleep(500);
	      //thrd.interrupt();
	      
	      Thread.sleep(50);
	      System.out.println("Thread status after third Thread.sleep(50)");
	      showThreadStatus(thrd);
	      
	      //while(thrd.isAlive()) 
	      //System.out.println("alive");
	       
	       
	      System.out.println("Thread status after some more time Thread.sleep(50)");
	      showThreadStatus(thrd);
	      
	      System.out.println("MAIN PROGRAM END ---- Note, you may receive 'terminating' from thread after this line");
	   }
	   
	   // method
	   static void showThreadStatus(Thread thrd) {
	      System.out.println(thrd.getName()+"  Alive:="+thrd.isAlive()+" State:=" + thrd.getState() );
	   }
	}