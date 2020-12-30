-----------------------
STILL NOT WORKING
-----------------------

ServiceLoader function:

Example taken from: https://dzone.com/articles/play-with-java-serviceloader-forget-about-dependen
              https://docs.oracle.com/javase/tutorial/ext/basics/spi.html
              
Other:
            https://www.tutorialspoint.com/java/util/serviceloader_load_service.htm
            https://www.baeldung.com/java-spi
            https://riptutorial.com/java/example/19523/simple-serviceloader-example
            https://www.codingame.com/playgrounds/3549/java-9-service-implementation
            
-----------------------
STILL NOT WORKING
-----------------------
This example from Dzone is still not working
Try a different one - maybe https://www.tutorialspoint.com/java/util/serviceloader_load_service.htm

This example:
Placed file in src/META-INF/services and ran Main.java:

Errors:
Exception in thread "main" java.util.NoSuchElementException
	at java.util.ServiceLoader$LazyIterator.nextService(ServiceLoader.java:365)
	at java.util.ServiceLoader$LazyIterator.next(ServiceLoader.java:404)
	at java.util.ServiceLoader$1.next(ServiceLoader.java:480)
	at com.gm.service.GreetingsProvider.serviceImpl(GreetingsProvider.java:32)
	at com.gm.service.Main.main(Main.java:10)
