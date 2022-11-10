package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isEnum {

    @Test
    public void example() {
        {
            // Object is not an enum
            Class<?> clazz = Object.class;
            boolean result = clazz.isEnum();
            assertFalse(result);
        }
        {
            // DummyEnum is not an enum
            Class<?> clazz = DummyEnum.class;
            boolean result = clazz.isEnum();
            assertTrue(result);
        }
    }

    enum DummyEnum {}
}
