package net.xdexamples.jse.index.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharSequenceExample_isEmpty {

    @Test
    public void example() {
        {
            CharSequence charSequence = "hello";
            boolean result = charSequence.isEmpty();
            assertFalse(result);
        }
        {
            CharSequence charSequence = "";
            boolean result = charSequence.isEmpty();
            assertTrue(result);
        }
    }

}
