package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ClassExample_getAnnotations {

    @Test
    public void example() {

        // An annotated class
        Class<?> clazz = A.class;

        // Get the anntotations
        Annotation[] annotations = clazz.getAnnotations();

        // Get and check the annotation class names
        String annotationNames = Arrays.stream(annotations)
                .map(Annotation::annotationType)
                .map(Class::getSimpleName)
                .collect(Collectors.joining(","));

        assertEquals("Deprecated", annotationNames);
    }

    @Deprecated(forRemoval = false)
    public static class A {

    }


}
