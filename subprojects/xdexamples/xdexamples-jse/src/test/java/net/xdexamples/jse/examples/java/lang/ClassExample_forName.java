package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ClassExample_forName {

    @Test
    public void example() throws ClassNotFoundException {
        // Allows to load classes without having a dependency to it at compile time
        Class<?> clazz = Class.forName(this.getClass().getName());
        assertSame(this.getClass(), clazz);
    }

}
