package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class AppendableExample_char {

    @Test
    @SuppressWarnings("UnnecessaryLocalVariable")
    public void example() throws IOException {

        // We initialize a StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        {
            // stringBuilder is an Appendable
            Appendable appendable = stringBuilder;

            // Here's a character
            char aChar = 'h';

            // Append that charater
            Appendable result = appendable.append(aChar);

            // The operation returns the same appender
            assertSame(result, appendable);

            // This means it can be chained
            appendable.append('e')
                    .append('l')
                    .append('l')
                    .append('o');
        }

        // The characters has been appended
        assertEquals("hello", stringBuilder.toString());
    }

}
