package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_CONNECTOR_PUNCTUATION {

    @Test
    public void example() {

        // Unicode contains exactly those 10 connector punctuation codepoints

        Set<String> expected = new BufferedReader(new StringReader("""
                00005f LOW LINE
                00203f UNDERTIE
                002040 CHARACTER TIE
                002054 INVERTED UNDERTIE
                00fe33 PRESENTATION FORM FOR VERTICAL LOW LINE
                00fe34 PRESENTATION FORM FOR VERTICAL WAVY LOW LINE
                00fe4d DASHED LOW LINE
                00fe4e CENTRELINE LOW LINE
                00fe4f WAVY LOW LINE
                00ff3f FULLWIDTH LOW LINE""")).lines()
                .collect(Collectors.toSet());

        // Check size before
        assertEquals(10, expected.size());

        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                if (Character.getType(codePoint) == Character.CONNECTOR_PUNCTUATION) {
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
