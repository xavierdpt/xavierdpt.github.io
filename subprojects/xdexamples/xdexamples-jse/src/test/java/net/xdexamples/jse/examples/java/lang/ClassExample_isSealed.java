package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isSealed {

    @Test
    public void example() {
        {
            Class<?> clazz = A.class;
            boolean result = clazz.isSealed();
            assertTrue(result);
        }
        {
            Class<?> clazz = B.class;
            boolean result = clazz.isSealed();
            assertFalse(result);
        }
    }

    public sealed interface A permits B {

    }

    public static final class B implements A {

    }

}
