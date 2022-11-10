package net.xdexamples.jse.index.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CharSequenceExample_compare {

    @Test
    public void example() {

        {
            String left = "hello";

            StringBuilder right = new StringBuilder();
            right.append("world");

            // the compare static function can compare any specialization of CharSequence
            int result = CharSequence.compare(left, right);
            assertTrue(result < 0);
        }

    }


}
