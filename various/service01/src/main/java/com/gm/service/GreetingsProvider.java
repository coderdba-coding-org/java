package com.gm.service;

import java.util.NoSuchElementException;
import java.util.ServiceLoader;
import com.gm.service.GreetingsServiceInterface;

public class GreetingsProvider {
	
    private static GreetingsProvider provider;
    private ServiceLoader<GreetingsServiceInterface> loader;

    private GreetingsProvider() {
        loader = ServiceLoader.load(GreetingsServiceInterface.class);
    }

  // instead of doing "new GreetingsProvider()" in the main class
  // call this method to get an instance of this class itself
  public static GreetingsProvider getInstance() {
      if(provider == null) {
          provider = new GreetingsProvider();
      }

      return provider;
    }

  	/*
  	 * Note: To load GreetingService, we are using ServiceLoader. 
  	 * If GreetingsService has multiple implementations, the ServiceLoader will load all of them. 
  	 * This depends on us and how we can handle implementations. In the above code, 
  	 * I am assuming there is only one implementation and finding out using next().
  	 */
    public GreetingsServiceInterface serviceImpl() {
    	
        GreetingsServiceInterface service = loader.iterator().next();

        if(service != null) {
            return service;
        } else {
            throw new NoSuchElementException(
            "No implementation for GreetingsProvider");
        }
    }
}