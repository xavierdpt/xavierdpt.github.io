package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class EnumExample_valueOf {

    @Test
    @SuppressWarnings("CodeBlock2Expr")
    public void example() {
        {
            // valueOf maps a String to the corresponding enum constant
            ExampleEnum value = ExampleEnum.valueOf("BEFORE");
            assertEquals(ExampleEnum.BEFORE, value);
        }
        {
            // and throws an exception when the input does not match any enum constants
            assertThrows(IllegalArgumentException.class, () -> {
                ExampleEnum.valueOf("INVALID");
            });
        }
    }


    public enum ExampleEnum {
        BEFORE, AFTER
    }

}
