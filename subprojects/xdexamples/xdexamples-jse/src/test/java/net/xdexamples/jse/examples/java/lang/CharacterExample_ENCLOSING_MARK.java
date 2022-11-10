package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_ENCLOSING_MARK {

    @Test
    public void example() {

        // Unicode contains exactly those 13 enclosing mark codepoints

        Set<String> expected = new BufferedReader(new StringReader("""
                000488 COMBINING CYRILLIC HUNDRED THOUSANDS SIGN
                000489 COMBINING CYRILLIC MILLIONS SIGN
                001abe COMBINING PARENTHESES OVERLAY
                0020dd COMBINING ENCLOSING CIRCLE
                0020de COMBINING ENCLOSING SQUARE
                0020df COMBINING ENCLOSING DIAMOND
                0020e0 COMBINING ENCLOSING CIRCLE BACKSLASH
                0020e2 COMBINING ENCLOSING SCREEN
                0020e3 COMBINING ENCLOSING KEYCAP
                0020e4 COMBINING ENCLOSING UPWARD POINTING TRIANGLE
                00a670 COMBINING CYRILLIC TEN MILLIONS SIGN
                00a671 COMBINING CYRILLIC HUNDRED MILLIONS SIGN
                00a672 COMBINING CYRILLIC THOUSAND MILLIONS SIGN""")).lines().collect(Collectors.toSet());

        // Check size before
        assertEquals(13, expected.size());

        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                if (Character.getType(codePoint) == Character.ENCLOSING_MARK) {
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
