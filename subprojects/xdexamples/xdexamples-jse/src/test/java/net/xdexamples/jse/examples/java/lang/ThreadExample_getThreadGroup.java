package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ThreadExample_getThreadGroup {

    @Test
    @SuppressWarnings("InstantiatingAThreadWithDefaultRunMethod")
    public void example() {
        {
            // By default, a thread is created in the current thread's thread group
            Thread thread = new Thread();

            ThreadGroup threadGroup = thread.getThreadGroup();
            assertSame(Thread.currentThread().getThreadGroup(), threadGroup);
        }
        {
            ThreadGroup myThreadGroup = new ThreadGroup("myThreadGroup");

            // It's possible to create a thread in another thread group
            Thread thread = new Thread(myThreadGroup, () -> {
            });

            ThreadGroup threadGroup = thread.getThreadGroup();
            assertSame(threadGroup, threadGroup);
        }
    }

}
