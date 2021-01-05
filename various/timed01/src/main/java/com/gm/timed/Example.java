package com.gm.timed;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.ResponseMetered;
import com.codahale.metrics.annotation.Timed;


public class Example extends Thread {

  public static void main(final String... args) {

    final MetricRegistry metricRegistry = new MetricRegistry();

    final ConsoleReporter reporter =
        ConsoleReporter.forRegistry(metricRegistry).convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS).build();

    try {
    	doSomeWork();
    	reporter.report();
    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
      reporter.report();
    }
  }
  
  @Timed
  @Metered
  @ExceptionMetered
  @ResponseMetered
  private static void doSomeWork() throws Exception {
	  
	  System.out.println("Doing some work");
	  Thread.sleep(5000);
	  
  }
}