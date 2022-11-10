package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class BooleanExample_hashCodeStatic {

    @Test
    public void example() {

        // The hashcode of true is different from the hashcode of false

        boolean bTrue = true;
        boolean bFalse = false;

        int hashCodeTrue = Boolean.hashCode(bTrue);
        int hashCodeFalse = Boolean.hashCode(bFalse);

        assertNotEquals(hashCodeTrue, hashCodeFalse);

    }

}
