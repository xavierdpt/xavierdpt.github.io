package net.xdexamples.jse.index.java.lang;

import org.junit.Test;

import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertEquals;

public class CharSequenceExample_subSequence {

    @Test
    public void example() {
        {
            // Usual case
            CharSequence charSequence = "hello";
            CharSequence subSequence = charSequence.subSequence(0, 1);
            assertEquals("h", subSequence.toString());
        }
        {
            // Less usual case with characters outside the basic multilingual plane
            // 1 code point = 1 surrogate pair of 2 characters
            CharSequence charSequence = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            // The subsequence only contains the high surrogate
            CharSequence subSequence = charSequence.subSequence(0, 1);
            assertEquals(fromCodePointNames("HIGH SURROGATES D808"), subSequence.toString());
        }
    }

}
