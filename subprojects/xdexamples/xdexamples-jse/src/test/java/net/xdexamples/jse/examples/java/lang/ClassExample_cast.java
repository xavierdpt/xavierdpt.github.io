package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

public class ClassExample_cast {

    @Test
    @SuppressWarnings("RedundantClassCall")
    public void example() {
        {
            A object = new B();

            // equivalent to the (B)object
            B result = B.class.cast(object);

            assertSame(object, result);
        }
        {
            A object = new A();
            assertThrows(ClassCastException.class, () -> B.class.cast(object));
        }
    }

    public static class A {

    }

    public static class B extends A {

    }

}
