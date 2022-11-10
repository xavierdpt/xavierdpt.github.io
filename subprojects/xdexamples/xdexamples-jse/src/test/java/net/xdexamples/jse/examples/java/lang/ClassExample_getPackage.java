package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassExample_getPackage {

    @Test
    public void example() {
        Class<?> clazz = Object.class;
        Package aPackage = clazz.getPackage();
        assertEquals("java.lang", aPackage.getName());
    }

}
