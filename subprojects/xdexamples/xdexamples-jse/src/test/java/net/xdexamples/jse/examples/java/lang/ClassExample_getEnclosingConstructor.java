package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ClassExample_getEnclosingConstructor {

    @Test
    public void example() throws NoSuchMethodException {
        Object[] holder = new Object[1];
        new B(holder);
        {
            // B has no enclosing constructor
            Class<?> clazz = B.class;
            Constructor<?> enclosingConstructor = clazz.getEnclosingConstructor();
            assertNull(enclosingConstructor);
        }

        {
            // A has an enclosing constructor
            Class<?> clazz = holder[0].getClass();
            Constructor<?> enclosingConstructor = clazz.getEnclosingConstructor();
            Constructor<?> expectedConstructor = B.class.getConstructor(Object[].class);
            assertEquals(expectedConstructor, enclosingConstructor);
        }
    }

    public static class B {

        public B(Object[] holder) {
            class A {

            }
            holder[0] = new A();
        }
    }

}
