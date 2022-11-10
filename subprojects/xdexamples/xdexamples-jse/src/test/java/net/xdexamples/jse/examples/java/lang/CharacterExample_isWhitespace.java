package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterExample_isWhitespace {

    @Test
    public void example() {
        {
            // There are 25 whitespace code points
            int count = 0;
            for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
                if (Character.isWhitespace(codePoint)) {
                    ++count;
                }
            }
            assertEquals(25, count);
        }
        {
            // Here are all of them
            String whitespaces = """
                    CHARACTER TABULATION
                    LINE FEED (LF)
                    LINE TABULATION
                    FORM FEED (FF)
                    CARRIAGE RETURN (CR)
                    INFORMATION SEPARATOR FOUR
                    INFORMATION SEPARATOR THREE
                    INFORMATION SEPARATOR TWO
                    INFORMATION SEPARATOR ONE
                    SPACE
                    OGHAM SPACE MARK
                    EN QUAD
                    EM QUAD
                    EN SPACE
                    EM SPACE
                    THREE-PER-EM SPACE
                    FOUR-PER-EM SPACE
                    SIX-PER-EM SPACE
                    PUNCTUATION SPACE
                    THIN SPACE
                    HAIR SPACE
                    LINE SEPARATOR
                    PARAGRAPH SEPARATOR
                    MEDIUM MATHEMATICAL SPACE
                    IDEOGRAPHIC SPACE""";
            new BufferedReader(new StringReader(whitespaces)).lines().forEach(name -> {
                int codePoint = Character.codePointOf(name);
                boolean isWhiteSpace = Character.isWhitespace(codePoint);
                assertTrue(isWhiteSpace);
            });
        }
        {
            // Those are whitespace but not space
            String notSpace = """
                    CHARACTER TABULATION
                    LINE FEED (LF)
                    LINE TABULATION
                    FORM FEED (FF)
                    CARRIAGE RETURN (CR)
                    INFORMATION SEPARATOR FOUR
                    INFORMATION SEPARATOR THREE
                    INFORMATION SEPARATOR TWO
                    INFORMATION SEPARATOR ONE""";
            new BufferedReader(new StringReader(notSpace)).lines().forEach(name -> {
                int codePoint = Character.codePointOf(name);
                boolean isWhiteSpace = Character.isWhitespace(codePoint);
                boolean isSpace = Character.isSpaceChar(codePoint);
                assertTrue(isWhiteSpace);
                assertFalse(isSpace);
            });
        }
        {
            // Those are space but not whitespace
            String notWhitespace = """
                    NO-BREAK SPACE
                    FIGURE SPACE
                    NARROW NO-BREAK SPACE""";
            new BufferedReader(new StringReader(notWhitespace)).lines().forEach(name -> {
                int codePoint = Character.codePointOf(name);
                boolean isWhiteSpace = Character.isWhitespace(codePoint);
                boolean isSpace = Character.isSpaceChar(codePoint);
                assertFalse(isWhiteSpace);
                assertTrue(isSpace);
            });
        }
        // Now go back to list of at the top and identify which is which in the list of 25
    }


}
