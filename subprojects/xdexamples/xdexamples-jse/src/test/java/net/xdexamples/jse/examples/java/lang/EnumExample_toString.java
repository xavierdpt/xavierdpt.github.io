package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnumExample_toString {

    @Test
    public void example() {
        ExampleEnum value = ExampleEnum.BEFORE;
        String result = value.toString();
        // it's simply the name of the enum constant
        assertEquals("BEFORE", result);
    }

    public enum ExampleEnum {
        BEFORE, AFTER
    }

}
