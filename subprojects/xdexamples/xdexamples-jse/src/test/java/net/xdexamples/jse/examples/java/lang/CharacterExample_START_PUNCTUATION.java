package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_START_PUNCTUATION {

    @Test
    public void example() {

        // Unicode contains exactly those 75 start punctuation codepoints

        Set<String> expected = new BufferedReader(new StringReader("""
                000028 LEFT PARENTHESIS
                00005b LEFT SQUARE BRACKET
                00007b LEFT CURLY BRACKET
                000f3a TIBETAN MARK GUG RTAGS GYON
                000f3c TIBETAN MARK ANG KHANG GYON
                00169b OGHAM FEATHER MARK
                00201a SINGLE LOW-9 QUOTATION MARK
                00201e DOUBLE LOW-9 QUOTATION MARK
                002045 LEFT SQUARE BRACKET WITH QUILL
                00207d SUPERSCRIPT LEFT PARENTHESIS
                00208d SUBSCRIPT LEFT PARENTHESIS
                002308 LEFT CEILING
                00230a LEFT FLOOR
                002329 LEFT-POINTING ANGLE BRACKET
                002768 MEDIUM LEFT PARENTHESIS ORNAMENT
                00276a MEDIUM FLATTENED LEFT PARENTHESIS ORNAMENT
                00276c MEDIUM LEFT-POINTING ANGLE BRACKET ORNAMENT
                00276e HEAVY LEFT-POINTING ANGLE QUOTATION MARK ORNAMENT
                002770 HEAVY LEFT-POINTING ANGLE BRACKET ORNAMENT
                002772 LIGHT LEFT TORTOISE SHELL BRACKET ORNAMENT
                002774 MEDIUM LEFT CURLY BRACKET ORNAMENT
                0027c5 LEFT S-SHAPED BAG DELIMITER
                0027e6 MATHEMATICAL LEFT WHITE SQUARE BRACKET
                0027e8 MATHEMATICAL LEFT ANGLE BRACKET
                0027ea MATHEMATICAL LEFT DOUBLE ANGLE BRACKET
                0027ec MATHEMATICAL LEFT WHITE TORTOISE SHELL BRACKET
                0027ee MATHEMATICAL LEFT FLATTENED PARENTHESIS
                002983 LEFT WHITE CURLY BRACKET
                002985 LEFT WHITE PARENTHESIS
                002987 Z NOTATION LEFT IMAGE BRACKET
                002989 Z NOTATION LEFT BINDING BRACKET
                00298b LEFT SQUARE BRACKET WITH UNDERBAR
                00298d LEFT SQUARE BRACKET WITH TICK IN TOP CORNER
                00298f LEFT SQUARE BRACKET WITH TICK IN BOTTOM CORNER
                002991 LEFT ANGLE BRACKET WITH DOT
                002993 LEFT ARC LESS-THAN BRACKET
                002995 DOUBLE LEFT ARC GREATER-THAN BRACKET
                002997 LEFT BLACK TORTOISE SHELL BRACKET
                0029d8 LEFT WIGGLY FENCE
                0029da LEFT DOUBLE WIGGLY FENCE
                0029fc LEFT-POINTING CURVED ANGLE BRACKET
                002e22 TOP LEFT HALF BRACKET
                002e24 BOTTOM LEFT HALF BRACKET
                002e26 LEFT SIDEWAYS U BRACKET
                002e28 LEFT DOUBLE PARENTHESIS
                002e42 DOUBLE LOW-REVERSED-9 QUOTATION MARK
                003008 LEFT ANGLE BRACKET
                00300a LEFT DOUBLE ANGLE BRACKET
                00300c LEFT CORNER BRACKET
                00300e LEFT WHITE CORNER BRACKET
                003010 LEFT BLACK LENTICULAR BRACKET
                003014 LEFT TORTOISE SHELL BRACKET
                003016 LEFT WHITE LENTICULAR BRACKET
                003018 LEFT WHITE TORTOISE SHELL BRACKET
                00301a LEFT WHITE SQUARE BRACKET
                00301d REVERSED DOUBLE PRIME QUOTATION MARK
                00fd3f ORNATE RIGHT PARENTHESIS
                00fe17 PRESENTATION FORM FOR VERTICAL LEFT WHITE LENTICULAR BRACKET
                00fe35 PRESENTATION FORM FOR VERTICAL LEFT PARENTHESIS
                00fe37 PRESENTATION FORM FOR VERTICAL LEFT CURLY BRACKET
                00fe39 PRESENTATION FORM FOR VERTICAL LEFT TORTOISE SHELL BRACKET
                00fe3b PRESENTATION FORM FOR VERTICAL LEFT BLACK LENTICULAR BRACKET
                00fe3d PRESENTATION FORM FOR VERTICAL LEFT DOUBLE ANGLE BRACKET
                00fe3f PRESENTATION FORM FOR VERTICAL LEFT ANGLE BRACKET
                00fe41 PRESENTATION FORM FOR VERTICAL LEFT CORNER BRACKET
                00fe43 PRESENTATION FORM FOR VERTICAL LEFT WHITE CORNER BRACKET
                00fe47 PRESENTATION FORM FOR VERTICAL LEFT SQUARE BRACKET
                00fe59 SMALL LEFT PARENTHESIS
                00fe5b SMALL LEFT CURLY BRACKET
                00fe5d SMALL LEFT TORTOISE SHELL BRACKET
                00ff08 FULLWIDTH LEFT PARENTHESIS
                00ff3b FULLWIDTH LEFT SQUARE BRACKET
                00ff5b FULLWIDTH LEFT CURLY BRACKET
                00ff5f FULLWIDTH LEFT WHITE PARENTHESIS
                00ff62 HALFWIDTH LEFT CORNER BRACKET""")).lines()
                .collect(Collectors.toSet());

        // Check size before
        assertEquals(75, expected.size());

        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                if (Character.getType(codePoint) == Character.START_PUNCTUATION) {
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
