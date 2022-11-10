package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertEquals;

public class StringExample_codePointCount {

    @Test
    public void example() {
        {
            // No surprise here
            String string = "hello";
            int count = string.codePointCount(0, string.length());
            assertEquals(5, count);
        }
        {
            // UTF-16 surrogate pair
            // Two chars, but one codepoint
            String string = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            int count = string.codePointCount(0, string.length());
            assertEquals(1, count);
        }
        {
            // UTF-16 surrogate pair but swapped
            String string = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            String swapped = new String(new char[]{string.charAt(1), string.charAt(0)});
            int count = swapped.codePointCount(0, swapped.length());

            // Now it's seeing two codepoints
            assertEquals(2, count);
        }
    }

}
