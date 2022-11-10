package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassExample_arrayType {

    @Test
    public void example() {
        {
            Class<?> clazz = double.class;
            Class<?> arrayType = clazz.arrayType();
            assertEquals(double[].class, arrayType);
        }
        {
            Class<?> clazz = double[].class;
            Class<?> arrayType = clazz.arrayType();
            assertEquals(double[][].class, arrayType);
        }
    }

}
