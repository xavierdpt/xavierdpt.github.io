package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class EnumExample_compareTo {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        {
            ExampleEnum before = ExampleEnum.BEFORE;
            ExampleEnum after = ExampleEnum.AFTER;
            int result = before.compareTo(after);
            assertTrue(result < 0);
        }
        {
            // enums are sorted by ordinal
            List<ExampleEnum> list = new ArrayList<>(Arrays.asList(
                    ExampleEnum.AFTER,
                    ExampleEnum.BEFORE
            ));
            Collections.sort(list);
            assertArrayEquals(new ExampleEnum[]{
                    ExampleEnum.BEFORE,
                    ExampleEnum.AFTER
            }, list.toArray());
        }
    }

    public enum ExampleEnum {
        BEFORE, AFTER
    }

}
