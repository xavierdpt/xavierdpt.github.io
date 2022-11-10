package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ClassExample_getMethod {

    @Test
    public void example() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        {
            // get the toString method from the Object class
            Class<?> clazz = this.getClass();
            Method method = clazz.getMethod("toString");
            assertSame(Object.class, method.getDeclaringClass());
        }
        {
            // get the toString method that has been overriden
            Class<?> clazz = A.class;
            Method method = clazz.getMethod("toString");
            assertSame(A.class, method.getDeclaringClass());
            assertEquals("Hello from A", method.invoke(new A()));
        }
        {
            // get a static toString method with one argument
            Class<?> clazz = A.class;
            Method method = clazz.getMethod("toString", String.class);
            assertSame(A.class, method.getDeclaringClass());
            assertEquals("Hello from A, I am happy", method.invoke(null, "happy"));
        }
    }

    public static class A {
        @Override
        public String toString() {
            return "Hello from A";
        }

        public static String toString(String mood) {
            return "Hello from A, I am " + mood;
        }


    }

}
