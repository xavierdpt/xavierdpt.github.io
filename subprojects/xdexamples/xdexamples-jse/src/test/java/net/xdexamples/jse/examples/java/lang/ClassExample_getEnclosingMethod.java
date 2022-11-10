package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ClassExample_getEnclosingMethod {

    @Test
    public void example() throws NoSuchMethodException {

        class A {
        }

        {
            // B has no enclosing method
            Class<?> clazz = B.class;
            Method enclosingMethod = clazz.getEnclosingMethod();
            assertNull(enclosingMethod);
        }

        {
            // A's enclosing method is example()
            Class<?> clazz = A.class;
            Method enclosingMethod = clazz.getEnclosingMethod();
            Method expectedMethod = this.getClass().getMethod("example");
            assertEquals(expectedMethod, enclosingMethod);
        }
    }

    public static class B {

    }

}
