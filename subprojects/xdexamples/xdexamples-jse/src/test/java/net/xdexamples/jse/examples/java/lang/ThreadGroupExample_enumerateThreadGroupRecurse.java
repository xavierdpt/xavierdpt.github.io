package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreadGroupExample_enumerateThreadGroupRecurse {

    @Test
    @SuppressWarnings({"SynchronizationOnLocalVariableOrMethodParameter", "unused"})
    public void test() {

        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");

        ThreadGroup main = Thread.currentThread().getThreadGroup();
        assertEquals("main", main.getName());

        ThreadGroup system = main.getParent();
        assertEquals("system", system.getName());

        {
            // recurse => my thread group found
            boolean hasMyThreadGroup;
            synchronized (system) {
                ThreadGroup[] list = new ThreadGroup[system.activeGroupCount() * 2];
                int found = system.enumerate(list, true);
                assertTrue(found < list.length);
                hasMyThreadGroup = Arrays.stream(list).filter(Objects::nonNull).map(ThreadGroup::getName).anyMatch("myThreadGroup"::equals);

            }
            assertTrue(hasMyThreadGroup);
        }

        {
            // not recurse => my thread group not found
            boolean hasMyThreadGroup;
            synchronized (system) {
                ThreadGroup[] list = new ThreadGroup[system.activeGroupCount() * 2];
                int found = system.enumerate(list, false);
                assertTrue(found < list.length);
                hasMyThreadGroup = Arrays.stream(list).filter(Objects::nonNull).map(ThreadGroup::getName).anyMatch("myThreadGroup"::equals);

            }
            assertFalse(hasMyThreadGroup);
        }
    }

}
