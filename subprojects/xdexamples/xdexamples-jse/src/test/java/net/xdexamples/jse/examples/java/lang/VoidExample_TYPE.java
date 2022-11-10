package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VoidExample_TYPE {

    @Test
    public void example() {
        {
            // The VOID class simply holds the "void" primitive type
            assertEquals(void.class, Void.TYPE);
        }
    }

}
