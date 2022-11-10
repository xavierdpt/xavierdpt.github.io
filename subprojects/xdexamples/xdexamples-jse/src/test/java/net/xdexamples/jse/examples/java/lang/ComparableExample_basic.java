package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ComparableExample_basic {

    @Test
    @SuppressWarnings({"UnnecessaryBoxing", "UnnecessaryLocalVariable"})
    public void example() {

        Integer a = Integer.valueOf(5);
        Integer b = Integer.valueOf(9);

        // Integer implements Comparable
        Comparable<Integer> aComparable = a;
        Comparable<Integer> bComparable = b;

        {
            // a < b => a.compareTo(b) < 0
            int result = aComparable.compareTo(b);
            assertTrue(result < 0);
        }

        {
            // b > a => b.compareTo(a) > 0
            int baResult = bComparable.compareTo(a);
            assertTrue(baResult > 0);
        }

        // TODO: There is probably more to say about Comparable
    }

}
