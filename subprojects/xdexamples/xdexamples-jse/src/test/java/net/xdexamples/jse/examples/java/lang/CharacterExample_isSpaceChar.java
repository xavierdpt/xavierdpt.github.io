package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_isSpaceChar {

    @Test
    public void example() {
        {
            // There are 19 space code points
            int count = 0;
            for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
                if (Character.isSpaceChar(codePoint)) {
                    ++count;
                }
            }
            assertEquals(19, count);
        }
        {
            // Here are all of them
            String spaceChars = """
                    SPACE
                    NO-BREAK SPACE
                    OGHAM SPACE MARK
                    EN QUAD
                    EM QUAD
                    EN SPACE
                    EM SPACE
                    THREE-PER-EM SPACE
                    FOUR-PER-EM SPACE
                    SIX-PER-EM SPACE
                    FIGURE SPACE
                    PUNCTUATION SPACE
                    THIN SPACE
                    HAIR SPACE
                    LINE SEPARATOR
                    PARAGRAPH SEPARATOR
                    NARROW NO-BREAK SPACE
                    MEDIUM MATHEMATICAL SPACE
                    IDEOGRAPHIC SPACE""";
            new BufferedReader(new StringReader(spaceChars)).lines().forEach(name -> {
                int codePoint = Character.codePointOf(name);
                boolean isSpaceChar = Character.isSpaceChar(codePoint);
                assertTrue(isSpaceChar);
            });
        }
    }
}
