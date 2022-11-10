package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnumExample_ordinal {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        // The ordinal is assigned by Java
        {
            ExampleEnum value = ExampleEnum.BEFORE;
            int ordinal = value.ordinal();
            assertEquals(0, ordinal);
        }
        {
            ExampleEnum value = ExampleEnum.AFTER;
            int ordinal = value.ordinal();
            assertEquals(1, ordinal);
        }
    }

    public enum ExampleEnum {
        BEFORE, AFTER
    }

}
