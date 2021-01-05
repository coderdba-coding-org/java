Reference: https://www.tutorialspoint.com/javaexamples/thread_monitor.htm

Topic: Monitoring thread status

If sent notice() the current task (startWait()) being done by thread is coded to come out gracefully (OR, DOES IT ACTUALLY NOT DO ANYTHING?)
 - else it catches interrupt and shows that message too
 
After that current task, another task of Thread.sleep() is placed - and that will be picked up

Thread.sleep() is a blocking task