Thread interruption

Reference: https://codeahoy.com/java/How-To-Stop-Threads-Safely/

Other: https://stackoverflow.com/questions/16504140/thread-stop-deprecated

Topic: Blocking Methods that do not Support Interruption

Programs in this project:
Main1.java - run() and interrupt() - with interrupt() handling interruption 
- Uses a socket - that does not support interruption

Main2.java
- Uses Thread.sleep - that supports interruption

From Reference site:
Let’s get this straight: in Java, there’s no straightforward or guaranteed way of stopping threads. 
You can only request a thread to stop itself and depending on its design, it can ignore your request and carry on. 
In this article, we’ll explore a few ways to stop threads and how you can design your tasks which run in threads to follow best practices.

In the early versions of Java, its designers made a mistake and decided they’d support thread termination. 
They added Thread.stop(), Thread.suspend() methods. 
A while later, they realized their mistake. 
These methods are inherently unsafe and could lead to dangerous side-effects. 
Imagine killing a thread that’s in the middle of writing a file to disk. 
You might end up corrupting the file. 
So they made the right call and deprecated these methods.

In Java, stopping threads requires cooperation from the task that’s being run by the thread. 
This co-operative mechanism is based on interruption. 
It’s a simple concept: to stop a thread, we deliver it an interrupt signal, requesting that the thread stops itself at the next available opportunity. 
To send the interrupt signal, we can use Thread.interrupt() method. 
It is up to the thread/task to check the signal, clean up if necessary and stop itself. 
It is totally possible (although a bad design) that the task may not bother to check the interrupt signal at all or ignore it. 
There’s very little an external caller can do in this situation. (I cover non-standard cancellation at the end of this post.)
