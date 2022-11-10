package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class ThreadGroupExample_getParent {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        {
            // Current thread's thread "main" has a parent
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            assertEquals("main", threadGroup.getName());
            ThreadGroup parent = threadGroup.getParent();
            assertNotNull(parent);

            // That parent's name is "system"
            assertEquals("system", parent.getName());

            // The "system" thread group has no parent
            assertNull(parent.getParent());
        }
        {
            // If we create a custom thread group and don't specify a parent,
            // its parent is the current thread's thread group
            ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");
            ThreadGroup parent = threadGroup.getParent();
            assertSame(Thread.currentThread().getThreadGroup(), parent);
        }
        {
            // Here we create a custom thread group with a custom parent
            ThreadGroup first = new ThreadGroup("first");
            ThreadGroup second = new ThreadGroup(first, "second");
            ThreadGroup parent = second.getParent();
            assertSame(first, parent);
        }
        {
            // We cannot create a thread group with a null parent
            Assert.assertThrows(NullPointerException.class, () -> {
                new ThreadGroup(null, "second");
            });

        }
    }

}
