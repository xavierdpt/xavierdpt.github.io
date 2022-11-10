package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class EnumExample_hashCode {

    @Test
    public void example() {
        int hashCode1 = ExampleEnum.BEFORE.hashCode();
        int hashCode2 = ExampleEnum.AFTER.hashCode();

        // it is statistically not equal, but I'm not sure it's guaranteed to be not equal
        assertNotEquals(hashCode1, hashCode2);
    }

    public enum ExampleEnum {
        BEFORE, AFTER
    }


}

