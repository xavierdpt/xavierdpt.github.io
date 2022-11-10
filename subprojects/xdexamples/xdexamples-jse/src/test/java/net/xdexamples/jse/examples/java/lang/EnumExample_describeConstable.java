package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class EnumExample_describeConstable {


    @Test
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public void example() {

        ExampleEnum value = ExampleEnum.BEFORE;

        Optional<Enum.EnumDesc<ExampleEnum>> result = value.describeConstable();

        assertEquals("EnumDesc[EnumExample_describeConstable$ExampleEnum.BEFORE]",
                result.get().toString());

        // TODO: Find something more interesting to say about this

    }

    public enum ExampleEnum {
        BEFORE, AFTER
    }
}
