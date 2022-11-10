package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThreadGroupExample_enumerateThreadGroup {

    @Test
    @SuppressWarnings({"SynchronizationOnLocalVariableOrMethodParameter", "unused"})
    public void test() {

        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");

        ThreadGroup main = Thread.currentThread().getThreadGroup();
        assertEquals("main", main.getName());

        ThreadGroup system = main.getParent();
        assertEquals("system", system.getName());

        {
            // enumerate is recursive by default
            boolean hasMyThreadGroup;
            synchronized (system) {
                ThreadGroup[] list = new ThreadGroup[system.activeGroupCount() * 2];
                int found = system.enumerate(list);
                assertTrue(found < list.length);
                hasMyThreadGroup = Arrays.stream(list).filter(Objects::nonNull).map(ThreadGroup::getName).anyMatch("myThreadGroup"::equals);

            }
            assertTrue(hasMyThreadGroup);
        }

    }


}
