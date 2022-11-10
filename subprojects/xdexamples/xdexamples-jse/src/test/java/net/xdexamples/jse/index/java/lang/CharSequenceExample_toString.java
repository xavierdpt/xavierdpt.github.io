package net.xdexamples.jse.index.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharSequenceExample_toString {

    @Test
    @SuppressWarnings("UnnecessaryLocalVariable")
    public void example() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello").append(" ").append("world");
        {
            CharSequence charSequence = stringBuilder;
            String result = charSequence.toString();
            assertEquals("hello world", result);
        }
    }
}
