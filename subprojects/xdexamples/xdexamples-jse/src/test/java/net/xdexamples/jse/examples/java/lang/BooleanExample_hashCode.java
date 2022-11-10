package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class BooleanExample_hashCode {

    @Test
    public void example() {

        // The hashcode of TRUE is different from the hashcode of FALSE

        Boolean bTrue = Boolean.TRUE;
        Boolean bFalse = Boolean.FALSE;

        int hashCodeTrue = bTrue.hashCode();
        int hashCodeFlase = bFalse.hashCode();

        assertNotEquals(hashCodeTrue, hashCodeFlase);
    }

}
