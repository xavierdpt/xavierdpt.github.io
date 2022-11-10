package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isLocalClass {

    @Test
    public void example() {

        // A local class
        class A {

        }

        {
            // A is local
            Class<?> clazz = A.class;
            boolean result = clazz.isLocalClass();
            assertTrue(result);

            // Class name is made with $,  number and class' simple name
            String thisClassName = this.getClass().getName();
            String aSimpleName = A.class.getSimpleName();
            assertEquals(thisClassName + "$1" + aSimpleName, A.class.getName());
        }
        {
            // B is not local
            Class<?> clazz = B.class;
            boolean result = clazz.isLocalClass();
            assertFalse(result);
        }
    }

    public static class B {

    }

}
