package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnumExample_equals {

    @Test
    @SuppressWarnings({"ConstantConditions", "EqualsWithItself", "SimplifiableAssertion"})
    public void example() {

        // No surprise

        ExampleEnum before = ExampleEnum.BEFORE;
        ExampleEnum after = ExampleEnum.AFTER;

        assertTrue(before.equals(before));
        assertFalse(before.equals(after));
        assertFalse(after.equals(before));
        assertTrue(after.equals(after));
    }

    public enum ExampleEnum {
        BEFORE, AFTER
    }

}
