package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertArrayEquals;

public class SuppressWarningsExample {

    @Test
    @SuppressWarnings("unused")
    public void example() throws NoSuchMethodException {

        // Declare an unused variable to justify the presence of the annotation
        int x = 0;

        // For good measure, also check that annotation's value with code
        Class<?> thisClass = this.getClass();
        Method thisMethod = thisClass.getMethod("example");
        SuppressWarnings annotation = thisMethod.getAnnotation(SuppressWarnings.class);
        String[] value = annotation.value();
        assertArrayEquals(new String[]{"unused"}, value);
    }

}
