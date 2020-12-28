package com.gm.fork;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//Reference: https://www.tutorialspoint.com/java_concurrency/concurrency_fork_join.htm

public class Main  {

	public static void main(String[] args) throws InterruptedException, 
	ExecutionException {
		
		System.out.println("Hello!");
		
		// print number of threads available
	    int nThreads = Runtime.getRuntime().availableProcessors();
	    System.out.println("Available CPUs: "+ nThreads);
	      
		//New ForkJoinPool with a parallelism level of x CPUs (like 2 cpus)
		ForkJoinPool forkJoinPool = new ForkJoinPool(2);
		
	    String result = forkJoinPool.invoke(new RecursiveTaskHello());
	    System.out.println(result);

	}

}
