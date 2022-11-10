package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isAnonymousClass {

    @Test
    @SuppressWarnings("CloneableClassWithoutClone")
    public void example() {

        {
            Cloneable object = new Cloneable() {
            };

            Class<?> clazz = object.getClass();

            boolean result = clazz.isAnonymousClass();

            assertTrue(result);

            // Names of anonymous classes are generated with "$" and a number
            assertEquals(this.getClass().getName() + "$1", clazz.getName());
        }

        {
            Class<?> clazz = Object.class;

            boolean result = clazz.isAnonymousClass();

            assertFalse(result);
        }
    }


}
