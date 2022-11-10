package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreadExample_holdsLock {

    @Test
    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    public void example() throws InterruptedException {

        // We will lock on this object
        Object object = new Object();

        // Inside a synchronized, answer should be true
        boolean result1;
        synchronized (object) {
            result1 = Thread.holdsLock(object);
        }

        // Outside a synchronized, answer should be false
        boolean result2 = Thread.holdsLock(object);

        assertTrue(result1);
        assertFalse(result2);
    }

}
