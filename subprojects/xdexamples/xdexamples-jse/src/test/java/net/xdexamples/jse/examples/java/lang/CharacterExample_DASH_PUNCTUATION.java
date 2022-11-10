package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_DASH_PUNCTUATION {

    @Test
    public void example() {

        // Unicode contains exactly those 25 dash punctuation codepoints

        Set<String> expected = new BufferedReader(new StringReader("""
                00002d HYPHEN-MINUS
                00058a ARMENIAN HYPHEN
                0005be HEBREW PUNCTUATION MAQAF
                001400 CANADIAN SYLLABICS HYPHEN
                001806 MONGOLIAN TODO SOFT HYPHEN
                002010 HYPHEN
                002011 NON-BREAKING HYPHEN
                002012 FIGURE DASH
                002013 EN DASH
                002014 EM DASH
                002015 HORIZONTAL BAR
                002e17 DOUBLE OBLIQUE HYPHEN
                002e1a HYPHEN WITH DIAERESIS
                002e3a TWO-EM DASH
                002e3b THREE-EM DASH
                002e40 DOUBLE HYPHEN
                00301c WAVE DASH
                003030 WAVY DASH
                0030a0 KATAKANA-HIRAGANA DOUBLE HYPHEN
                00fe31 PRESENTATION FORM FOR VERTICAL EM DASH
                00fe32 PRESENTATION FORM FOR VERTICAL EN DASH
                00fe58 SMALL EM DASH
                00fe63 SMALL HYPHEN-MINUS
                00ff0d FULLWIDTH HYPHEN-MINUS
                010ead YEZIDI HYPHENATION MARK""")).lines()
                .collect(Collectors.toSet());

        // Check size before
        assertEquals(25, expected.size());

        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                if (Character.getType(codePoint) == Character.DASH_PUNCTUATION) {
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
