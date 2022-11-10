package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isRecord {

    @Test
    public void example() {
        {
            Class<?> clazz = this.getClass();
            boolean result = clazz.isRecord();
            assertFalse(result);
        }
        {
            Class<?> clazz = A.class;
            boolean result = clazz.isRecord();
            assertTrue(result);
        }
    }

    public record A() {

    }
}
