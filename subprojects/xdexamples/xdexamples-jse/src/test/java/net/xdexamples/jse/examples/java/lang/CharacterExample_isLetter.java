package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterExample_isLetter {

    @Test
    public void example() {
        {
            // Here's a letter that's not a digit and is neither uppercase, lowercase or title case
            int codePoint = Character.codePointOf("LATIN LETTER DENTAL CLICK");
            boolean isLetter = Character.isLetter(codePoint);

            assertTrue(isLetter);
            assertFalse(Character.isDigit(codePoint));
            assertFalse(Character.isLowerCase(codePoint));
            assertFalse(Character.isUpperCase(codePoint));
            assertFalse(Character.isTitleCase(codePoint));
        }
        {
            // Here's an uppercase codepoint that is not a letter and not a digit
            int codePoint = Character.codePointOf("ROMAN NUMERAL ONE");
            boolean isLetter = Character.isLetter(codePoint);

            assertFalse(isLetter);
            assertTrue(Character.isUpperCase(codePoint));
            assertFalse(Character.isDigit(codePoint));
            assertFalse(Character.isLowerCase(codePoint));
            assertFalse(Character.isTitleCase(codePoint));
        }
        {
            // Here's another one
            int codePoint = Character.codePointOf("CIRCLED LATIN CAPITAL LETTER A");
            boolean isLetter = Character.isLetter(codePoint);

            assertFalse(isLetter);
            assertTrue(Character.isUpperCase(codePoint));
            assertFalse(Character.isDigit(codePoint));
            assertFalse(Character.isLowerCase(codePoint));
            assertFalse(Character.isTitleCase(codePoint));
        }
    }
}
