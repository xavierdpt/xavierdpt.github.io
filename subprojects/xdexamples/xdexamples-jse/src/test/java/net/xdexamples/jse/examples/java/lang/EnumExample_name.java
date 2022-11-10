package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnumExample_name {

    @Test
    public void example() {
        // The name is simply the name of the enum constant
        {
            ExampleEnum value = ExampleEnum.BEFORE;
            String name = value.name();
            assertEquals("BEFORE", name);

        }
        {
            ExampleEnum value = ExampleEnum.AFTER;
            String name = value.name();
            assertEquals("AFTER", name);

        }
    }

    public enum ExampleEnum {
        BEFORE, AFTER
    }

}
