package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ClassExample_componentType {

    @Test
    public void example() {
        {
            Class<?> clazz = double[].class;
            Class<?> componentType = clazz.getComponentType();
            assertEquals(double.class, componentType);
        }
        {
            Class<?> clazz = double.class;
            Class<?> componentType = clazz.getComponentType();
            assertNull(componentType);
        }
    }

}
