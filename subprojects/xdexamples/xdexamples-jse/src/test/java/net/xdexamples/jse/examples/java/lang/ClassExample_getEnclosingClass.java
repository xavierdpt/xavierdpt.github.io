package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class ClassExample_getEnclosingClass {

    @Test
    public void example() {
        {
            // A's enclosing class is this class
            Class<?> clazz = A.class;
            Class<?> enclosingClass = clazz.getEnclosingClass();
            assertSame(this.getClass(), enclosingClass);
        }
        {
            // this class has no enclosing class
            Class<? > clazz = this.getClass();
            Class<?> enclosingClass = clazz.getEnclosingClass();
            assertNull(enclosingClass);
        }
    }

    class  A {

    }

}
