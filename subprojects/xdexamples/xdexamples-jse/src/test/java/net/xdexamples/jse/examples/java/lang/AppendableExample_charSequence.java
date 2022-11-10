package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AppendableExample_charSequence {

    @Test
    @SuppressWarnings("UnnecessaryLocalVariable")
    public void example() throws IOException {

        // We initialize a StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        {
            // stringBuilder is an Appendable
            Appendable appendable = stringBuilder;

            // Strings implements CharSequence
            CharSequence charSequence = "hello";

            // Append it to the appendable
            appendable.append(charSequence);
        }

        // The character sequence has been appended
        assertEquals("hello", stringBuilder.toString());
    }


}
