package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreadGroupExample_parentOf {

    @Test
    public void example() {

        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");

        ThreadGroup main = Thread.currentThread().getThreadGroup();
        assertEquals("main", main.getName());

        ThreadGroup system = main.getParent();
        assertEquals("system", system.getName());

        // parentOf is reflexive
        assertTrue(threadGroup.parentOf(threadGroup));
        assertTrue(main.parentOf(main));
        assertTrue(system.parentOf(system));

        // parentOf is transitive
        assertTrue(main.parentOf(threadGroup));
        assertTrue(system.parentOf(main));
        assertTrue(system.parentOf(threadGroup));

        // and it is antisymmetric
        assertFalse(threadGroup.parentOf(main));
        assertFalse(threadGroup.parentOf(system));
        assertFalse(main.parentOf(system));

    }

}
