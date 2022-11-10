package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_getModule {

    @Test
    public void example() {
        {
            // Object is part of a named module
            Class<?> clazz = Object.class;
            Module module = clazz.getModule();
            assertTrue(module.isNamed());
        }
        {
            // This class is part of an unamed module
            Class<?> clazz = this.getClass();
            Module module = clazz.getModule();
            assertFalse(module.isNamed());
        }
    }
}
