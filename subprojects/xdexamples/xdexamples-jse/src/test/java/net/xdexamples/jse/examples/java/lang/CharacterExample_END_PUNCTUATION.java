package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_END_PUNCTUATION {

    @Test
    public void example() {

        // Unicode contains exactly those 73 end punctuation codepoints

        Set<String> expected = new BufferedReader(new StringReader("""
                000029 RIGHT PARENTHESIS
                00005d RIGHT SQUARE BRACKET
                00007d RIGHT CURLY BRACKET
                000f3b TIBETAN MARK GUG RTAGS GYAS
                000f3d TIBETAN MARK ANG KHANG GYAS
                00169c OGHAM REVERSED FEATHER MARK
                002046 RIGHT SQUARE BRACKET WITH QUILL
                00207e SUPERSCRIPT RIGHT PARENTHESIS
                00208e SUBSCRIPT RIGHT PARENTHESIS
                002309 RIGHT CEILING
                00230b RIGHT FLOOR
                00232a RIGHT-POINTING ANGLE BRACKET
                002769 MEDIUM RIGHT PARENTHESIS ORNAMENT
                00276b MEDIUM FLATTENED RIGHT PARENTHESIS ORNAMENT
                00276d MEDIUM RIGHT-POINTING ANGLE BRACKET ORNAMENT
                00276f HEAVY RIGHT-POINTING ANGLE QUOTATION MARK ORNAMENT
                002771 HEAVY RIGHT-POINTING ANGLE BRACKET ORNAMENT
                002773 LIGHT RIGHT TORTOISE SHELL BRACKET ORNAMENT
                002775 MEDIUM RIGHT CURLY BRACKET ORNAMENT
                0027c6 RIGHT S-SHAPED BAG DELIMITER
                0027e7 MATHEMATICAL RIGHT WHITE SQUARE BRACKET
                0027e9 MATHEMATICAL RIGHT ANGLE BRACKET
                0027eb MATHEMATICAL RIGHT DOUBLE ANGLE BRACKET
                0027ed MATHEMATICAL RIGHT WHITE TORTOISE SHELL BRACKET
                0027ef MATHEMATICAL RIGHT FLATTENED PARENTHESIS
                002984 RIGHT WHITE CURLY BRACKET
                002986 RIGHT WHITE PARENTHESIS
                002988 Z NOTATION RIGHT IMAGE BRACKET
                00298a Z NOTATION RIGHT BINDING BRACKET
                00298c RIGHT SQUARE BRACKET WITH UNDERBAR
                00298e RIGHT SQUARE BRACKET WITH TICK IN BOTTOM CORNER
                002990 RIGHT SQUARE BRACKET WITH TICK IN TOP CORNER
                002992 RIGHT ANGLE BRACKET WITH DOT
                002994 RIGHT ARC GREATER-THAN BRACKET
                002996 DOUBLE RIGHT ARC LESS-THAN BRACKET
                002998 RIGHT BLACK TORTOISE SHELL BRACKET
                0029d9 RIGHT WIGGLY FENCE
                0029db RIGHT DOUBLE WIGGLY FENCE
                0029fd RIGHT-POINTING CURVED ANGLE BRACKET
                002e23 TOP RIGHT HALF BRACKET
                002e25 BOTTOM RIGHT HALF BRACKET
                002e27 RIGHT SIDEWAYS U BRACKET
                002e29 RIGHT DOUBLE PARENTHESIS
                003009 RIGHT ANGLE BRACKET
                00300b RIGHT DOUBLE ANGLE BRACKET
                00300d RIGHT CORNER BRACKET
                00300f RIGHT WHITE CORNER BRACKET
                003011 RIGHT BLACK LENTICULAR BRACKET
                003015 RIGHT TORTOISE SHELL BRACKET
                003017 RIGHT WHITE LENTICULAR BRACKET
                003019 RIGHT WHITE TORTOISE SHELL BRACKET
                00301b RIGHT WHITE SQUARE BRACKET
                00301e DOUBLE PRIME QUOTATION MARK
                00301f LOW DOUBLE PRIME QUOTATION MARK
                00fd3e ORNATE LEFT PARENTHESIS
                00fe18 PRESENTATION FORM FOR VERTICAL RIGHT WHITE LENTICULAR BRAKCET
                00fe36 PRESENTATION FORM FOR VERTICAL RIGHT PARENTHESIS
                00fe38 PRESENTATION FORM FOR VERTICAL RIGHT CURLY BRACKET
                00fe3a PRESENTATION FORM FOR VERTICAL RIGHT TORTOISE SHELL BRACKET
                00fe3c PRESENTATION FORM FOR VERTICAL RIGHT BLACK LENTICULAR BRACKET
                00fe3e PRESENTATION FORM FOR VERTICAL RIGHT DOUBLE ANGLE BRACKET
                00fe40 PRESENTATION FORM FOR VERTICAL RIGHT ANGLE BRACKET
                00fe42 PRESENTATION FORM FOR VERTICAL RIGHT CORNER BRACKET
                00fe44 PRESENTATION FORM FOR VERTICAL RIGHT WHITE CORNER BRACKET
                00fe48 PRESENTATION FORM FOR VERTICAL RIGHT SQUARE BRACKET
                00fe5a SMALL RIGHT PARENTHESIS
                00fe5c SMALL RIGHT CURLY BRACKET
                00fe5e SMALL RIGHT TORTOISE SHELL BRACKET
                00ff09 FULLWIDTH RIGHT PARENTHESIS
                00ff3d FULLWIDTH RIGHT SQUARE BRACKET
                00ff5d FULLWIDTH RIGHT CURLY BRACKET
                00ff60 FULLWIDTH RIGHT WHITE PARENTHESIS
                00ff63 HALFWIDTH RIGHT CORNER BRACKET""")).lines()
                .collect(Collectors.toSet());

        // Check size before
        assertEquals(73, expected.size());

        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                if (Character.getType(codePoint) == Character.END_PUNCTUATION) {
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
