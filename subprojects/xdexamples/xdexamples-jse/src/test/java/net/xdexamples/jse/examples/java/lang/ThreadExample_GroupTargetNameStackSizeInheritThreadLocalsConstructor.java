package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ThreadExample_GroupTargetNameStackSizeInheritThreadLocalsConstructor {

    @Test
    public void example() throws InterruptedException {

        // Initialize an inheritable thread local
        //   if it is a ThreadLocal but not an InheritableThradLocal, inheritance doesn't work
        //   if using a supplier for initializing values of the thread local, inheritance doesn't work
        //     because the supplier is always used
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        // Initialize the thread local's value ot the current thread's name
        threadLocal.set(Thread.currentThread().getName());

        // Check that the current thread's name is indeed "main"
        assertEquals("main", threadLocal.get());

        // Threads will write into that atomatic reference
        AtomicReference<String> ref = new AtomicReference<>();

        {
            // No inheritance
            boolean inheritThreadLocals = false;
            Thread thread = new Thread(
                    Thread.currentThread().getThreadGroup(),
                    () -> ref.set(threadLocal.get()),
                    "myThread",
                    0L,
                    inheritThreadLocals
            );
            thread.start();
            thread.join();
            // The thread local read "null"
            assertNull(ref.get());
        }
        {
            // Inheritance
            boolean inheritThreadLocals = true;
            Thread thread = new Thread(
                    Thread.currentThread().getThreadGroup(),
                    () -> ref.set(threadLocal.get()),
                    "myThread",
                    0L,
                    inheritThreadLocals
            );
            thread.start();
            thread.join();
            // The thread local read "main"
            assertEquals("main", ref.get());
        }

    }

}
