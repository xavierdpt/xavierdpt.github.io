package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnumExample_getDeclaringClass {

    @Test
    public void example() {

        ExampleEnum value = ExampleEnum.BEFORE;

        Class<ExampleEnum> declaringClass = value.getDeclaringClass();

        // it's simply the name of the Enum class that contains that enum constant
        assertEquals(ExampleEnum.class, declaringClass);
    }

    public enum ExampleEnum {
        BEFORE, AFTER
    }

}
