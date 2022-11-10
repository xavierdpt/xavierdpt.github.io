package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class ClassExample_getEnumConstants {

    @Test
    public void example() {
        {
            Class<?> clazz = DummyEnum.class;
            Object[] result = clazz.getEnumConstants();
            assertArrayEquals(new DummyEnum[]{DummyEnum.DUMMY_CONSTANT}, result);
        }
        {
            Class<?> clazz = Object.class;
            Object[] result = clazz.getEnumConstants();
            assertNull(result);
        }
    }

    enum DummyEnum {
        DUMMY_CONSTANT
    }

}
