package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanExample_booleanValue {

    @Test
    @SuppressWarnings({"ConstantConditions", "UnnecessaryUnboxing"})
    public void example() {

        // booleanValue is the counterpart to the ...Value() methods in
        // the Number class

        {
            Boolean b = Boolean.TRUE;
            boolean value = b.booleanValue();
            assertTrue(value);
        }

        {
            Boolean b = Boolean.FALSE;
            boolean value = b.booleanValue();
            assertFalse(value);
        }
    }
}
