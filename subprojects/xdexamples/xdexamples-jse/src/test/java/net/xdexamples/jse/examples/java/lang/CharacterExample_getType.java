package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CharacterExample_getType {

    @Test
    public void example() {
        // Here we collect the first code point of each type as well as their count
        Map<Integer, String> types = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                int type = Character.getType(codePoint);
                if (!types.containsKey(type)) {
                    types.put(type, Character.getName(codePoint));
                }
                counts.putIfAbsent(type, 0);
                counts.put(type, counts.get(type) + 1);
            }
        }

        {
            int type = Character.UPPERCASE_LETTER;
            assertEquals(types.get(type), "LATIN CAPITAL LETTER A");
            assertEquals(1791, counts.get(type).intValue());
        }
        {
            int type = Character.LOWERCASE_LETTER;
            assertEquals(types.get(type), "LATIN SMALL LETTER A");
            assertEquals(2155, counts.get(type).intValue());
        }
        {
            int type = Character.TITLECASE_LETTER;
            assertEquals(types.get(type), "LATIN CAPITAL LETTER D WITH SMALL LETTER Z WITH CARON");
            assertEquals(31, counts.get(type).intValue());
        }
        {
            int type = Character.MODIFIER_LETTER;
            assertEquals(types.get(type), "MODIFIER LETTER SMALL H");
            assertEquals(260, counts.get(type).intValue());
        }
        {
            int type = Character.OTHER_LETTER;
            assertEquals(types.get(type), "FEMININE ORDINAL INDICATOR");
            assertEquals(127004, counts.get(type).intValue());
        }
        {
            int type = Character.NON_SPACING_MARK;
            assertEquals(types.get(type), "COMBINING GRAVE ACCENT");
            assertEquals(1839, counts.get(type).intValue());
        }
        {
            int type = Character.ENCLOSING_MARK;
            assertEquals(types.get(type), "COMBINING CYRILLIC HUNDRED THOUSANDS SIGN");
            assertEquals(13, counts.get(type).intValue());
        }
        {
            int type = Character.COMBINING_SPACING_MARK;
            assertEquals(types.get(type), "DEVANAGARI SIGN VISARGA");
            assertEquals(443, counts.get(type).intValue());
        }
        {
            int type = Character.DECIMAL_DIGIT_NUMBER;
            assertEquals(types.get(type), "DIGIT ZERO");
            assertEquals(650, counts.get(type).intValue());
        }
        {
            int type = Character.LETTER_NUMBER;
            assertEquals(types.get(type), "RUNIC ARLAUG SYMBOL");
            assertEquals(236, counts.get(type).intValue());
        }
        {
            int type = Character.OTHER_NUMBER;
            assertEquals(types.get(type), "SUPERSCRIPT TWO");
            assertEquals(895, counts.get(type).intValue());
        }
        {
            int type = Character.SPACE_SEPARATOR;
            assertEquals(types.get(type), "SPACE");
            assertEquals(17, counts.get(type).intValue());
        }
        {
            int type = Character.LINE_SEPARATOR;
            assertEquals(types.get(type), "LINE SEPARATOR");
            assertEquals(1, counts.get(type).intValue());
        }
        {
            int type = Character.PARAGRAPH_SEPARATOR;
            assertEquals(types.get(type), "PARAGRAPH SEPARATOR");
            assertEquals(1, counts.get(type).intValue());
        }
        {
            int type = Character.CONTROL;
            assertEquals(types.get(type), "NULL");
            assertEquals(65, counts.get(type).intValue());
        }
        {
            int type = Character.FORMAT;
            assertEquals(types.get(type), "SOFT HYPHEN");
            assertEquals(161, counts.get(type).intValue());
        }
        {
            int type = Character.PRIVATE_USE;
            assertEquals(types.get(type), "PRIVATE USE AREA E000");
            assertEquals(137468, counts.get(type).intValue());
        }
        {
            int type = Character.SURROGATE;
            assertEquals(types.get(type), "HIGH SURROGATES D800");
            assertEquals(2048, counts.get(type).intValue());
        }
        {
            int type = Character.DASH_PUNCTUATION;
            assertEquals(types.get(type), "HYPHEN-MINUS");
            assertEquals(25, counts.get(type).intValue());
        }
        {
            int type = Character.START_PUNCTUATION;
            assertEquals(types.get(type), "LEFT PARENTHESIS");
            assertEquals(75, counts.get(type).intValue());
        }
        {
            int type = Character.END_PUNCTUATION;
            assertEquals(types.get(type), "RIGHT PARENTHESIS");
            assertEquals(73, counts.get(type).intValue());
        }
        {
            int type = Character.CONNECTOR_PUNCTUATION;
            assertEquals(types.get(type), "LOW LINE");
            assertEquals(10, counts.get(type).intValue());
        }
        {
            int type = Character.OTHER_PUNCTUATION;
            assertEquals(types.get(type), "EXCLAMATION MARK");
            assertEquals(593, counts.get(type).intValue());
        }
        {
            int type = Character.MATH_SYMBOL;
            assertEquals(types.get(type), "PLUS SIGN");
            assertEquals(948, counts.get(type).intValue());
        }
        {
            int type = Character.CURRENCY_SYMBOL;
            assertEquals(types.get(type), "DOLLAR SIGN");
            assertEquals(62, counts.get(type).intValue());
        }
        {
            int type = Character.MODIFIER_SYMBOL;
            assertEquals(types.get(type), "CIRCUMFLEX ACCENT");
            assertEquals(123, counts.get(type).intValue());
        }
        {
            int type = Character.OTHER_SYMBOL;
            assertEquals(types.get(type), "BROKEN BAR");
            assertEquals(6431, counts.get(type).intValue());
        }
        {
            int type = Character.INITIAL_QUOTE_PUNCTUATION;
            assertEquals(types.get(type), "LEFT-POINTING DOUBLE ANGLE QUOTATION MARK");
            assertEquals(12, counts.get(type).intValue());
        }
        {
            int type = Character.FINAL_QUOTE_PUNCTUATION;
            assertEquals(types.get(type), "RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK");
            assertEquals(10, counts.get(type).intValue());
        }
    }

}
