package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class BooleanExample_valueOfBoolean {

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void example() {

        // valueOf convert a primitive boolean to the boxed value

        {
            boolean value = true;
            Boolean b = Boolean.valueOf(value);
            assertSame(Boolean.TRUE, b);
        }
        {
            boolean value = false;
            Boolean b = Boolean.valueOf(value);
            assertSame(Boolean.FALSE, b);
        }
    }
}
