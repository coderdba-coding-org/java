About asynch/parallel/background execution:
- https://medium.com/@varun93342/difference-between-thread-service-and-asynctask-in-android-d6e37960e56c
- Thread --> start a thread that runs in background and can be infinite looping
- AsyncTask --> finite end, but async
- Fork --> finite end, split into multiple parallel tasks
- Service --> utility services like functions in shell programs, not instantiated 

## INDEX

thread01 - simple thread that reads a file - in continuous or one-time mode
thread02 - thread with interruption - simple, non-blocking threads, interrupt using different wasy
thread03 - blocking threads - how to interrupt them
