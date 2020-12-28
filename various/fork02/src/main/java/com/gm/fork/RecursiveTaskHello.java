package com.gm.fork;

import java.util.concurrent.RecursiveTask;

//Reference: https://www.tutorialspoint.com/java_concurrency/concurrency_fork_join.htm

public class RecursiveTaskHello extends RecursiveTask<String> {
	
	
	// If this serialVersionUID is not set, a warning appeared
	// Therefore, had Eclips insert the following default line
	private static final long serialVersionUID = 1L;

	
	// Though string is returned the function should be named 'compute'
	protected String compute() {
		
		return "In recursive task's compute()";
		
		
		
	}

}