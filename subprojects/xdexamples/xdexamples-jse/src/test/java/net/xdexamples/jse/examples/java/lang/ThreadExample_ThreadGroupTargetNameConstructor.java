package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadExample_ThreadGroupTargetNameConstructor {

    @Test
    public void example() throws InterruptedException {

        // Prepare a slot to receive a String
        String[] value = new String[1];

        // This runnable outputs a message with the current thread group's name and current thread's name
        Runnable target = () -> {
            Thread currentThread = Thread.currentThread();
            ThreadGroup currentGroup = currentThread.getThreadGroup();

            String threadName = currentThread.getName();
            String groupName = currentGroup.getName();

            value[0] = "Hello from " + groupName + "/" + threadName;
        };

        // Create custom thread group (with parent that thread's thread group)
        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");

        // Create new named thread in that group
        Thread thread = new Thread(threadGroup, target, "myThread");

        // Start the thread
        thread.start();

        // Wait for the thread to finish
        thread.join();

        // Check the message
        assertEquals("Hello from myThreadGroup/myThread", value[0]);
    }

}
