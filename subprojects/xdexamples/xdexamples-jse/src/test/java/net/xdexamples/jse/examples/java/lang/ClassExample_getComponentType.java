package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class ClassExample_getComponentType {

    @Test
    public void example() {
        {
            Class<?> clazz = double[].class;
            Class<?> componentType = clazz.getComponentType();
            assertSame(double.class, componentType);
        }
        {
            Class<?> clazz = double.class;
            Class<?> componentType = clazz.getComponentType();
            assertNull(componentType);
        }
    }

}
