package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassExample_getPackageName {

    @Test
    public void example() {
        {
            // Every class should be in a package
            Class<?> clazz = Object.class;
            String packageName = clazz.getPackageName();
            assertEquals("java.lang", packageName);
        }
        {
            // Even primitive types are in a package
            Class<?> clazz = void.class;
            String packageName = clazz.getPackageName();
            assertEquals("java.lang", packageName);
        }
    }

}
