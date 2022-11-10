package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.support.ExampleSupport;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StringExample_equalsIgnoreCase {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        {
            String string = "hello";
            String other = "Hello";
            boolean result = string.equalsIgnoreCase(other);
            assertTrue(result);
        }
        {
            // More than two codepoints can be equals when ignoring case
            List<String> omegas = Arrays.asList(
                    "GREEK CAPITAL LETTER OMEGA",
                    "GREEK SMALL LETTER OMEGA",
                    "OHM SIGN"
            );
            for (String omega1 : omegas) {
                for (String omega2 : omegas) {
                    String string = ExampleSupport.fromCodePointNames(omega1);
                    String other = ExampleSupport.fromCodePointNames(omega2);
                    assertTrue(string.equalsIgnoreCase(other));
                }
            }
        }
    }

}
