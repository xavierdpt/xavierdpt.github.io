package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassExample_getName {

    @Test
    public void example() {
        Class<?> clazz = this.getClass();
        String name = clazz.getName();
        assertEquals("net.xdexamples.jse.examples.java.lang.ClassExample_getName", name);
    }

}
