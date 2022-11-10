package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterExample_toCodePoint {

    @Test
    public void example() {
        {
            int codePoint = Character.codePointOf("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            char high = Character.highSurrogate(codePoint);
            char low = Character.lowSurrogate(codePoint);

            // Makes a code point out of two surrogates
            int result = Character.toCodePoint(high, low);
            assertEquals(codePoint, result);
        }
        {
            // The results makes no sense when the input is not a surrogate pair
            int result = Character.toCodePoint('h', 'e');

            // That value may be implementation specific but means nothing
            assertEquals(0xFC_A1_C4_65, result);
        }
    }

}
