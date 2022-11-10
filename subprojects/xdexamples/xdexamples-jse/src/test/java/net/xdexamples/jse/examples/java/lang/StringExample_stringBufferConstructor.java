package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringExample_stringBufferConstructor {

    @Test
    @SuppressWarnings("StringBufferMayBeStringBuilder")
    public void example() {

        // You should usually use StringBuilder instead of StringBuffer
        // and use the ::toString method to get the final string

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello");

        String string = new String(stringBuffer);
        assertEquals("hello", string);
    }

}
