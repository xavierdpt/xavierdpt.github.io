package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isMemberClass {

    @Test
    public void example() {
        {
            Class<?> clazz = B.class;
            boolean result = clazz.isMemberClass();
            assertTrue(result);
        }
        {
            Class<?> clazz = this.getClass();
            boolean result = clazz.isMemberClass();
            assertFalse(result);
        }

    }

    public static class B {

    }

}
