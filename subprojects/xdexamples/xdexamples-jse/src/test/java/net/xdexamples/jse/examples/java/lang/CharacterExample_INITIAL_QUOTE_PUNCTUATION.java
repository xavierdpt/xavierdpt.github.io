package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_INITIAL_QUOTE_PUNCTUATION {

    @Test
    public void example() {

        // Unicode contains exactly those 12 initial quote punctuation codepoints

        Set<String> expected = new BufferedReader(new StringReader("""
                0000ab LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
                002018 LEFT SINGLE QUOTATION MARK
                00201b SINGLE HIGH-REVERSED-9 QUOTATION MARK
                00201c LEFT DOUBLE QUOTATION MARK
                00201f DOUBLE HIGH-REVERSED-9 QUOTATION MARK
                002039 SINGLE LEFT-POINTING ANGLE QUOTATION MARK
                002e02 LEFT SUBSTITUTION BRACKET
                002e04 LEFT DOTTED SUBSTITUTION BRACKET
                002e09 LEFT TRANSPOSITION BRACKET
                002e0c LEFT RAISED OMISSION BRACKET
                002e1c LEFT LOW PARAPHRASE BRACKET
                002e20 LEFT VERTICAL BAR WITH QUILL""")).lines()
                .collect(Collectors.toSet());

        // Check size before
        assertEquals(12, expected.size());

        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                if (Character.getType(codePoint) == Character.INITIAL_QUOTE_PUNCTUATION) {
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
