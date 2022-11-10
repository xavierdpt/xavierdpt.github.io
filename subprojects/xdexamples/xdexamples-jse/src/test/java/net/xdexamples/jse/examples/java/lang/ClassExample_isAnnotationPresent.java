package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isAnnotationPresent {

    @Test
    public void example() {
        {
            Class<?> clazz = A.class;
            Class<Deprecated> annotationClass = Deprecated.class;
            boolean result = clazz.isAnnotationPresent(annotationClass);
            assertFalse(result);
        }
        {
            Class<?> clazz = B.class;
            Class<Deprecated> annotationClass = Deprecated.class;
            boolean result = clazz.isAnnotationPresent(annotationClass);
            assertTrue(result);
        }
    }

    public static class A {

    }

    @Deprecated(forRemoval = false)
    @SuppressWarnings("DefaultAnnotationParam")
    public static class B {

    }

}
