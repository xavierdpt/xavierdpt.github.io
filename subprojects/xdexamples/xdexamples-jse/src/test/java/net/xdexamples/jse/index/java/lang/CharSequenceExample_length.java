package net.xdexamples.jse.index.java.lang;

import org.junit.Test;

import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertEquals;

public class CharSequenceExample_length {

    @Test
    public void example() {
        {
            // Usual case
            CharSequence charSequence = "hello";
            int length = charSequence.length();
            assertEquals(5, length);
        }
        {
            // Less usual case with characters outside the basic multilingual plane
            // length count the number of UTF-16 characters, not the number of code points
            CharSequence charSequence = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            int length = charSequence.length();
            assertEquals(2,length);
        }
    }

}
