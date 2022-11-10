package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterExample_toString {

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void example() {
        {
            char ch = '\0';

            // Static version of toString that works on the primitive value
            String string = Character.toString(ch);
            assertEquals("\0", string);
        }
        {
            Character ch = Character.valueOf('\0');

            // Member version toString that works on the boxed value
            String string = ch.toString();
            assertEquals("\0", string);
        }
        {
            int codePoint = Character.codePointOf("CUNEIFORM SIGN ASH OVER ASH OVER ASH");

            // Static version that converts any codepoint to strings, especially those outside the BMP which require
            // two UTF-16 chars
            String string = Character.toString(codePoint);
            assertEquals("\ud808\udc3c", string);
        }

    }

}
