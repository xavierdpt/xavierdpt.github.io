package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertEquals;

public class StringExample_length {

    @Test
    public void example() {
        {
            // It may seem obvious
            String string = "hello";
            int length = string.length();
            assertEquals(5, length);
        }
        {
            // But watch out, it's actual the number of UTF-16 characters, not the number of code points
            String string = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            int length = string.length();
            assertEquals(2, length);
        }
    }
}
