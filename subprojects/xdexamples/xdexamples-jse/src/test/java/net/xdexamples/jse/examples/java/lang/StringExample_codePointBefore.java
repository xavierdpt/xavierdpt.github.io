package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static java.lang.Character.codePointOf;
import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringExample_codePointBefore {

    @Test
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void example() {
        {
            // With before, counting starts at 1
            String string = "hello";
            assertThrows(StringIndexOutOfBoundsException.class, () -> {
                string.codePointBefore(0);
            });
        }
        {
            String string = "hello";
            int codePoint = string.codePointBefore(1);

            // For codePoints in the BMP, the codepoint (int) coincides with the UTF-16 char value
            assertEquals('h', codePoint);

            // but this would be the more general way, besides knowing the actual numeric value
            int latin_small_letter_h = codePointOf("LATIN SMALL LETTER H");
            assertEquals(latin_small_letter_h, codePoint);
        }
        {
            // UTF-16 surrogate pair
            String string = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");

            // When it sees a high surrogate, it does not try to find the following low surrogate
            int high = string.codePointBefore(1);
            assertEquals(codePointOf("HIGH SURROGATES D808"), high);

            // But when it sees a low surrogate, it tries to go backward to find the low surrogate
            int both = string.codePointBefore(2);
            assertEquals(codePointOf("CUNEIFORM SIGN ASH OVER ASH OVER ASH"), both);

            // To actually get the low surrogate, we need to remove the first character
            String substring = string.substring(1, 2);
            int low = substring.codePointBefore(1);
            assertEquals(codePointOf("LOW SURROGATES DC3C"), low);
        }
    }


}
