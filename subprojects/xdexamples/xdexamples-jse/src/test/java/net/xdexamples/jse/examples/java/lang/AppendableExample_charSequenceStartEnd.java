package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AppendableExample_charSequenceStartEnd {

    @Test
    @SuppressWarnings("UnnecessaryLocalVariable")
    public void example() throws IOException {

        // Initialize a StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        {
            // stringBuilder is an Appendable
            Appendable appendable = stringBuilder;

            // String implements CharSequence
            CharSequence charSequence = "hello";

            // Define two boundaries
            int start = 1;
            int end = 4;

            // Append to the appendable
            appendable.append(charSequence, start, end);
        }

        // The character sequence has been appended
        assertEquals("ell", stringBuilder.toString());
    }

}
