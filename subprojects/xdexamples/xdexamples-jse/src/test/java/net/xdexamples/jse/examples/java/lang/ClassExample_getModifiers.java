package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

public class ClassExample_getModifiers {

    @Test
    public void example() {
        Class<?> clazz = this.getClass();
        int modifiers = clazz.getModifiers();
        boolean result = Modifier.isPublic(modifiers);
        assertTrue(result);
    }

}
