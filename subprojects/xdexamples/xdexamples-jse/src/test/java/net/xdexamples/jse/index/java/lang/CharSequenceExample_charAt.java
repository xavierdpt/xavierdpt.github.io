package net.xdexamples.jse.index.java.lang;

import org.junit.Test;

import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertEquals;

public class CharSequenceExample_charAt {
    @Test
    public void example() {
        {
            // Usual case
            CharSequence charSequence = "hello";
            char ch = charSequence.charAt(0);
            assertEquals('h', ch);
        }
        {
            // Less usual case with characters outside the basic multilingual plane
            // 1 code point = 1 surrogate pair of 2 characters
            CharSequence charSequence = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            char ch1 = charSequence.charAt(0);
            char ch2 = charSequence.charAt(1);
            assertEquals('\ud808', ch1);
            assertEquals('\udc3c', ch2);

        }


    }
}
