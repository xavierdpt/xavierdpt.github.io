package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class CharacterExample_getDirectionality {

    @Test
    public void example() {
        Map<Byte, String> directionalities = new TreeMap<>();
        Map<Byte, Integer> counts = new TreeMap<>();
        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                byte directionality = Character.getDirectionality(codePoint);
                if (!directionalities.containsKey(directionality)) {
                    directionalities.put(directionality, Character.getName(codePoint));
                }
                counts.putIfAbsent(directionality, 0);
                counts.put(directionality, counts.get(directionality) + 1);
            }
        }
        {
            byte directionality = Character.DIRECTIONALITY_LEFT_TO_RIGHT;
            assertEquals("LATIN CAPITAL LETTER A", directionalities.get(directionality));
            assertEquals(272209, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_RIGHT_TO_LEFT;
            assertEquals("HEBREW PUNCTUATION MAQAF", directionalities.get(directionality));
            assertEquals(1469, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
            assertEquals("ARABIC RAY", directionalities.get(directionality));
            assertEquals(1435, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_EUROPEAN_NUMBER;
            assertEquals("DIGIT ZERO", directionalities.get(directionality));
            assertEquals(168, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR;
            assertEquals("PLUS SIGN", directionalities.get(directionality));
            assertEquals(12, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR;
            assertEquals("NUMBER SIGN", directionalities.get(directionality));
            assertEquals(76, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_ARABIC_NUMBER;
            assertEquals("ARABIC NUMBER SIGN", directionalities.get(directionality));
            assertEquals(61, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_COMMON_NUMBER_SEPARATOR;
            assertEquals("COMMA", directionalities.get(directionality));
            assertEquals(15, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_NONSPACING_MARK;
            assertEquals("COMBINING GRAVE ACCENT", directionalities.get(directionality));
            assertEquals(1847, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_BOUNDARY_NEUTRAL;
            assertEquals("NULL", directionalities.get(directionality));
            assertEquals(181, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR;
            assertEquals("LINE FEED (LF)", directionalities.get(directionality));
            assertEquals(7, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_SEGMENT_SEPARATOR;
            assertEquals("CHARACTER TABULATION", directionalities.get(directionality));
            assertEquals(3, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_WHITESPACE;
            assertEquals("FORM FEED (FF)", directionalities.get(directionality));
            assertEquals(17, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_OTHER_NEUTRALS;
            assertEquals("EXCLAMATION MARK", directionalities.get(directionality));
            assertEquals(5931, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING;
            assertEquals("LEFT-TO-RIGHT EMBEDDING", directionalities.get(directionality));
            assertEquals(1, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE;
            assertEquals("LEFT-TO-RIGHT OVERRIDE", directionalities.get(directionality));
            assertEquals(1, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING;
            assertEquals("RIGHT-TO-LEFT EMBEDDING", directionalities.get(directionality));
            assertEquals(1, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE;
            assertEquals("RIGHT-TO-LEFT OVERRIDE", directionalities.get(directionality));
            assertEquals(1, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_POP_DIRECTIONAL_FORMAT;
            assertEquals("POP DIRECTIONAL FORMATTING", directionalities.get(directionality));
            assertEquals(1, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_LEFT_TO_RIGHT_ISOLATE;
            assertEquals("LEFT-TO-RIGHT ISOLATE", directionalities.get(directionality));
            assertEquals(1, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_RIGHT_TO_LEFT_ISOLATE;
            assertEquals("RIGHT-TO-LEFT ISOLATE", directionalities.get(directionality));
            assertEquals(1, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_FIRST_STRONG_ISOLATE;
            assertEquals("FIRST STRONG ISOLATE", directionalities.get(directionality));
            assertEquals(1, counts.get(directionality).intValue());
        }
        {
            byte directionality = Character.DIRECTIONALITY_POP_DIRECTIONAL_ISOLATE;
            assertEquals("POP DIRECTIONAL ISOLATE", directionalities.get(directionality));
            assertEquals(1, counts.get(directionality).intValue());
        }
    }

}
