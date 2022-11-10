package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringExample_contentEqualsCharSequence {

    @Test
    @SuppressWarnings("UnnecessaryLocalVariable")
    public void example() {
        // more general method that compares any CharSequence
        {
            String string = "hello";

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hello");

            // StringBuilder is an example of CharSequnce
            CharSequence other = stringBuilder;

            boolean result = string.contentEquals(other);
            assertTrue(result);
        }
        {
            String string = "hello";

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("world");

            // StringBuilder is an example of CharSequnce
            CharSequence other = stringBuilder;

            boolean result = string.contentEquals(other);
            assertFalse(result);
        }
    }

}
