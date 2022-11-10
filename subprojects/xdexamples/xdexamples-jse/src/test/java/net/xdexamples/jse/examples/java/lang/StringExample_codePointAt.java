package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.support.ExampleSupport;
import org.junit.Test;

import static java.lang.Character.codePointOf;
import static org.junit.Assert.assertEquals;

public class StringExample_codePointAt {

    @Test
    public void example() {
        {
            String string = "hello";
            int codePoint = string.codePointAt(0);

            // For codePoints in the BMP, the codepoint (int) coincides with the UTF-16 char value
            assertEquals('h', codePoint);

            // but this would be the more general way, besides knowing the actual numeric value
            int latin_small_letter_h = codePointOf("LATIN SMALL LETTER H");
            assertEquals(latin_small_letter_h, codePoint);
        }
        {
            String string = ExampleSupport.fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");

            // When it sees a high surrogate, it automatically tries to check the following low surrogate
            int both = string.codePointAt(0);
            assertEquals(codePointOf("CUNEIFORM SIGN ASH OVER ASH OVER ASH"), both);

            // But when it sees a low surrogate, it doesn't try to go backward to find the high surrogate
            int low = string.codePointAt(1);
            assertEquals(codePointOf("LOW SURROGATES DC3C"), low);

            // To actually get the high surrogate, we need to remove the second character
            String substring = string.substring(0, 1);
            int high = substring.codePointAt(0);
            assertEquals(codePointOf("HIGH SURROGATES D808"), high);
        }
    }

}
