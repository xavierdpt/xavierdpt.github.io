package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ClassExample_getAnnotation {

    @Test
    public void example() {
        Class<?> clazz = A.class;
        Deprecated annotation = clazz.getAnnotation(Deprecated.class);
        assertNotNull(annotation);
    }

    @Deprecated(forRemoval = false)
    @SuppressWarnings("DefaultAnnotationParam")
    public static class A {

    }

}
