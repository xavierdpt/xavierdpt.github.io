package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_FINAL_QUOTE_PUNCTUATION {

    @Test
    public void example() {

        // Unicode contains exactly those 10 final quote punctuation codepoints

        Set<String> expected = new BufferedReader(new StringReader("""
                0000bb RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
                002019 RIGHT SINGLE QUOTATION MARK
                00201d RIGHT DOUBLE QUOTATION MARK
                00203a SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
                002e03 RIGHT SUBSTITUTION BRACKET
                002e05 RIGHT DOTTED SUBSTITUTION BRACKET
                002e0a RIGHT TRANSPOSITION BRACKET
                002e0d RIGHT RAISED OMISSION BRACKET
                002e1d RIGHT LOW PARAPHRASE BRACKET
                002e21 RIGHT VERTICAL BAR WITH QUILL""")).lines()
                .collect(Collectors.toSet());

        // Check size before
        assertEquals(10, expected.size());

        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                if (Character.getType(codePoint) == Character.FINAL_QUOTE_PUNCTUATION) {
                    String hex = pad(Integer.toHexString(codePoint));
                    String name = Character.getName(codePoint);
                    String line = hex + " " + name;
                    // Check that line was found
                    assertTrue(expected.remove(line));
                }
            }
        }

        // Check that all been seen
        assertEquals(0, expected.size());
    }

    private static String pad(String s) {
        return "0".repeat(6 - s.length()) + s;
    }
}
