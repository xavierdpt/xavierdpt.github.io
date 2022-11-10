package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ClassExample_asSubclass {

    @Test
    public void example() {
        {
            // B can be converted into something that extends A
            Class<?> clazz = B.class;
            Class<? extends A> subclass = clazz.asSubclass(A.class);
            assertEquals(B.class, subclass);
        }
        {
            // A cannot be converted into B
            Class<?> clazz = A.class;
            assertThrows(ClassCastException.class, () -> {
                clazz.asSubclass(B.class);
            });
        }
    }

    static class A {

    }

    static class B extends A {

    }
}
