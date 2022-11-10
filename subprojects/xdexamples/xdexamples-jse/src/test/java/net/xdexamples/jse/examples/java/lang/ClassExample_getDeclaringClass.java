package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ClassExample_getDeclaringClass {

    @Test
    public void example() {
        {
            Class<?> clazz = A.class;
            Class<?> declaringClass = clazz.getDeclaringClass();
            assertEquals(this.getClass(), declaringClass);
        }
        {
            Class<?> clazz = this.getClass();
            Class<?> declaringClass = clazz.getDeclaringClass();
            assertNull(declaringClass);
        }
    }

    static class A {

    }

}
