package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.support.ExampleSupport;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringExample_charAt {

    @Test
    public void example() {
        {
            String string = "hello";
            char ch = string.charAt(0);
            assertEquals('h', ch);
        }
        {
            // One code point outside the BMP, two UTF-16 chars
            String string = ExampleSupport.fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            char first = string.charAt(0);
            char second = string.charAt(1);
            assertEquals('\ud808', first);
            assertEquals('\udc3c', second);
        }
    }
}
