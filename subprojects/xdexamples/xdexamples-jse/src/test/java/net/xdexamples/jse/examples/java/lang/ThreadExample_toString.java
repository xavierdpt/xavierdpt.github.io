package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadExample_toString {

    @Test
    public void example() {

        String threadName = "myThread";
        String groupName = "myThreadGroup";
        int priority = 3;

        // Create thread gruop
        ThreadGroup threadGroup = new ThreadGroup(groupName);

        // Create thread and set priority
        Thread thread = new Thread(threadGroup, () -> {
        }, threadName);
        thread.setPriority(priority);

        // String value contains thread name, thread group name and priority
        String result = thread.toString();
        assertEquals("Thread[myThread,3,myThreadGroup]", result);
    }

}
