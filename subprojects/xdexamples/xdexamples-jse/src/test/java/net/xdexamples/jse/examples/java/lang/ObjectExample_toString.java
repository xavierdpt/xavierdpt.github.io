package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObjectExample_toString {

    @Test
    public void example() {

        // We create an object
        Object object = new Object();

        // Get its string value
        String result = object.toString();

        // We expect to see the class name, followed by the hascode in lowercase hexadecimal
        String hashCodeHex = Integer.toHexString(object.hashCode()).toLowerCase();
        String expectedResult = "java.lang.Object@" + hashCodeHex;

        // And it's indeed the case
        assertEquals(expectedResult, result);
    }

}
