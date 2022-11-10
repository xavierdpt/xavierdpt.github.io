package net.xdexamples.jse.index.java.lang;

import org.junit.Test;

import java.util.stream.IntStream;

import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertArrayEquals;

public class CharSequenceExample_codePoints {

    @Test
    public void example() {
        {
            // Usual case
            CharSequence charSequence = "hello";
            IntStream codePoints = charSequence.codePoints();
            // one integer per character with implicit cast from char to int
            assertArrayEquals(new int[]{'h', 'e', 'l', 'l', 'o'}, codePoints.toArray());
        }
        {
            // Less usual case with characters outside the basic multilingual plane
            // 1 code point = 1 surrogate pair of 2 characters
            CharSequence charSequence = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            IntStream codePoints = charSequence.codePoints();
            // one integer per code point
            assertArrayEquals(new int[]{0x1203c}, codePoints.toArray());
        }
    }
}
