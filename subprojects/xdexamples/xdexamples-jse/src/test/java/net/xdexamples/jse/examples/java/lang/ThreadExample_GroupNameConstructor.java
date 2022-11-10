package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadExample_GroupNameConstructor {

    @Test
    public void example() throws InterruptedException {

        String[] value = new String[1];

        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");

        Thread thread = new Thread(threadGroup, "myThread") {
            @Override
            public void run() {

                Thread currentThread = Thread.currentThread();
                ThreadGroup currentGroup = currentThread.getThreadGroup();

                String threadName = currentThread.getName();
                String groupName = currentGroup.getName();

                value[0] = "Hello from " + groupName + "/" + threadName;
            }
        };

        thread.start();

        thread.join();

        assertEquals("Hello from myThreadGroup/myThread", value[0]);

    }


}
