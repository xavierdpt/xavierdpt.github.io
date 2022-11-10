package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassExample_getSimpleName {

    @Test
    public void example() {
        Class<?> clazz = this.getClass();
        String simpleName = clazz.getSimpleName();
        assertEquals("ClassExample_getSimpleName", simpleName);
    }

}
