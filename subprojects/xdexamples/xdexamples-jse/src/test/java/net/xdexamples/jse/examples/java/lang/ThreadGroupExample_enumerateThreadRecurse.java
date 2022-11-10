package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreadGroupExample_enumerateThreadRecurse {

    @Test
    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    public void test() {

        ThreadGroup main = Thread.currentThread().getThreadGroup();
        assertEquals("main", main.getName());

        ThreadGroup system = main.getParent();
        assertEquals("system", system.getName());

        {
            // recurse false => main not found
            boolean hasMain;
            synchronized (system) {
                Thread[] list = new Thread[system.activeCount() * 2];
                int found = system.enumerate(list, false);
                assertTrue(found < list.length);
                hasMain = Arrays.stream(list)
                        .filter(Objects::nonNull)
                        .map(Thread::getName)
                        .anyMatch("main"::equals);
            }
            assertFalse(hasMain);
        }

        {
            // recurse true => main found
            boolean hasMain;
            synchronized (system) {
                Thread[] list = new Thread[system.activeCount() * 2];
                int found = system.enumerate(list, true);
                assertTrue(found < list.length);
                hasMain = Arrays.stream(list)
                        .filter(Objects::nonNull)
                        .map(Thread::getName)
                        .anyMatch("main"::equals);
            }
            assertTrue(hasMain);
        }

    }

}
