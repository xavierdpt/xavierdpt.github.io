package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringExample_equals {

    @Test
    @SuppressWarnings({
            "ConstantConditions",
            "EqualsBetweenInconvertibleTypes",
            "EqualsOnSuspiciousObject",
            "StringEqualsCharSequence"
    })
    public void example() {
        {
            String string = "hello";
            String other = "hello";
            boolean result = string.equals(other);
            assertTrue(result);
        }
        {
            String string = "hello";
            String other = "world";
            boolean result = string.equals(other);
            assertFalse(result);
        }
        {
            // to compare with other "String-equivalent" types, see contentEquals

            String string = "hello";

            StringBuilder other = new StringBuilder();
            other.append("hello");

            boolean result = string.equals(other);
            assertFalse(result);

            // equality as seen by CharSequence::compare
            int compare = CharSequence.compare(string, other);
            Assert.assertEquals(0, compare);
        }
    }

}
