package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_FORMAT {

    @Test
    public void example() {

        // Unicode contains exactly those 161 format codepoints

        Set<String> expected = new BufferedReader(new StringReader("""
                0000ad SOFT HYPHEN
                000600 ARABIC NUMBER SIGN
                000601 ARABIC SIGN SANAH
                000602 ARABIC FOOTNOTE MARKER
                000603 ARABIC SIGN SAFHA
                000604 ARABIC SIGN SAMVAT
                000605 ARABIC NUMBER MARK ABOVE
                00061c ARABIC LETTER MARK
                0006dd ARABIC END OF AYAH
                00070f SYRIAC ABBREVIATION MARK
                0008e2 ARABIC DISPUTED END OF AYAH
                00180e MONGOLIAN VOWEL SEPARATOR
                00200b ZERO WIDTH SPACE
                00200c ZERO WIDTH NON-JOINER
                00200d ZERO WIDTH JOINER
                00200e LEFT-TO-RIGHT MARK
                00200f RIGHT-TO-LEFT MARK
                00202a LEFT-TO-RIGHT EMBEDDING
                00202b RIGHT-TO-LEFT EMBEDDING
                00202c POP DIRECTIONAL FORMATTING
                00202d LEFT-TO-RIGHT OVERRIDE
                00202e RIGHT-TO-LEFT OVERRIDE
                002060 WORD JOINER
                002061 FUNCTION APPLICATION
                002062 INVISIBLE TIMES
                002063 INVISIBLE SEPARATOR
                002064 INVISIBLE PLUS
                002066 LEFT-TO-RIGHT ISOLATE
                002067 RIGHT-TO-LEFT ISOLATE
                002068 FIRST STRONG ISOLATE
                002069 POP DIRECTIONAL ISOLATE
                00206a INHIBIT SYMMETRIC SWAPPING
                00206b ACTIVATE SYMMETRIC SWAPPING
                00206c INHIBIT ARABIC FORM SHAPING
                00206d ACTIVATE ARABIC FORM SHAPING
                00206e NATIONAL DIGIT SHAPES
                00206f NOMINAL DIGIT SHAPES
                00feff ZERO WIDTH NO-BREAK SPACE
                00fff9 INTERLINEAR ANNOTATION ANCHOR
                00fffa INTERLINEAR ANNOTATION SEPARATOR
                00fffb INTERLINEAR ANNOTATION TERMINATOR
                0110bd KAITHI NUMBER SIGN
                0110cd KAITHI NUMBER SIGN ABOVE
                013430 EGYPTIAN HIEROGLYPH VERTICAL JOINER
                013431 EGYPTIAN HIEROGLYPH HORIZONTAL JOINER
                013432 EGYPTIAN HIEROGLYPH INSERT AT TOP START
                013433 EGYPTIAN HIEROGLYPH INSERT AT BOTTOM START
                013434 EGYPTIAN HIEROGLYPH INSERT AT TOP END
                013435 EGYPTIAN HIEROGLYPH INSERT AT BOTTOM END
                013436 EGYPTIAN HIEROGLYPH OVERLAY MIDDLE
                013437 EGYPTIAN HIEROGLYPH BEGIN SEGMENT
                013438 EGYPTIAN HIEROGLYPH END SEGMENT
                01bca0 SHORTHAND FORMAT LETTER OVERLAP
                01bca1 SHORTHAND FORMAT CONTINUING OVERLAP
                01bca2 SHORTHAND FORMAT DOWN STEP
                01bca3 SHORTHAND FORMAT UP STEP
                01d173 MUSICAL SYMBOL BEGIN BEAM
                01d174 MUSICAL SYMBOL END BEAM
                01d175 MUSICAL SYMBOL BEGIN TIE
                01d176 MUSICAL SYMBOL END TIE
                01d177 MUSICAL SYMBOL BEGIN SLUR
                01d178 MUSICAL SYMBOL END SLUR
                01d179 MUSICAL SYMBOL BEGIN PHRASE
                01d17a MUSICAL SYMBOL END PHRASE
                0e0001 LANGUAGE TAG
                0e0020 TAG SPACE
                0e0021 TAG EXCLAMATION MARK
                0e0022 TAG QUOTATION MARK
                0e0023 TAG NUMBER SIGN
                0e0024 TAG DOLLAR SIGN
                0e0025 TAG PERCENT SIGN
                0e0026 TAG AMPERSAND
                0e0027 TAG APOSTROPHE
                0e0028 TAG LEFT PARENTHESIS
                0e0029 TAG RIGHT PARENTHESIS
                0e002a TAG ASTERISK
                0e002b TAG PLUS SIGN
                0e002c TAG COMMA
                0e002d TAG HYPHEN-MINUS
                0e002e TAG FULL STOP
                0e002f TAG SOLIDUS
                0e0030 TAG DIGIT ZERO
                0e0031 TAG DIGIT ONE
                0e0032 TAG DIGIT TWO
                0e0033 TAG DIGIT THREE
                0e0034 TAG DIGIT FOUR
                0e0035 TAG DIGIT FIVE
                0e0036 TAG DIGIT SIX
                0e0037 TAG DIGIT SEVEN
                0e0038 TAG DIGIT EIGHT
                0e0039 TAG DIGIT NINE
                0e003a TAG COLON
                0e003b TAG SEMICOLON
                0e003c TAG LESS-THAN SIGN
                0e003d TAG EQUALS SIGN
                0e003e TAG GREATER-THAN SIGN
                0e003f TAG QUESTION MARK
                0e0040 TAG COMMERCIAL AT
                0e0041 TAG LATIN CAPITAL LETTER A
                0e0042 TAG LATIN CAPITAL LETTER B
                0e0043 TAG LATIN CAPITAL LETTER C
                0e0044 TAG LATIN CAPITAL LETTER D
                0e0045 TAG LATIN CAPITAL LETTER E
                0e0046 TAG LATIN CAPITAL LETTER F
                0e0047 TAG LATIN CAPITAL LETTER G
                0e0048 TAG LATIN CAPITAL LETTER H
                0e0049 TAG LATIN CAPITAL LETTER I
                0e004a TAG LATIN CAPITAL LETTER J
                0e004b TAG LATIN CAPITAL LETTER K
                0e004c TAG LATIN CAPITAL LETTER L
                0e004d TAG LATIN CAPITAL LETTER M
                0e004e TAG LATIN CAPITAL LETTER N
                0e004f TAG LATIN CAPITAL LETTER O
                0e0050 TAG LATIN CAPITAL LETTER P
                0e0051 TAG LATIN CAPITAL LETTER Q
                0e0052 TAG LATIN CAPITAL LETTER R
                0e0053 TAG LATIN CAPITAL LETTER S
                0e0054 TAG LATIN CAPITAL LETTER T
                0e0055 TAG LATIN CAPITAL LETTER U
                0e0056 TAG LATIN CAPITAL LETTER V
                0e0057 TAG LATIN CAPITAL LETTER W
                0e0058 TAG LATIN CAPITAL LETTER X
                0e0059 TAG LATIN CAPITAL LETTER Y
                0e005a TAG LATIN CAPITAL LETTER Z
                0e005b TAG LEFT SQUARE BRACKET
                0e005c TAG REVERSE SOLIDUS
                0e005d TAG RIGHT SQUARE BRACKET
                0e005e TAG CIRCUMFLEX ACCENT
                0e005f TAG LOW LINE
                0e0060 TAG GRAVE ACCENT
                0e0061 TAG LATIN SMALL LETTER A
                0e0062 TAG LATIN SMALL LETTER B
                0e0063 TAG LATIN SMALL LETTER C
                0e0064 TAG LATIN SMALL LETTER D
                0e0065 TAG LATIN SMALL LETTER E
                0e0066 TAG LATIN SMALL LETTER F
                0e0067 TAG LATIN SMALL LETTER G
                0e0068 TAG LATIN SMALL LETTER H
                0e0069 TAG LATIN SMALL LETTER I
                0e006a TAG LATIN SMALL LETTER J
                0e006b TAG LATIN SMALL LETTER K
                0e006c TAG LATIN SMALL LETTER L
                0e006d TAG LATIN SMALL LETTER M
                0e006e TAG LATIN SMALL LETTER N
                0e006f TAG LATIN SMALL LETTER O
                0e0070 TAG LATIN SMALL LETTER P
                0e0071 TAG LATIN SMALL LETTER Q
                0e0072 TAG LATIN SMALL LETTER R
                0e0073 TAG LATIN SMALL LETTER S
                0e0074 TAG LATIN SMALL LETTER T
                0e0075 TAG LATIN SMALL LETTER U
                0e0076 TAG LATIN SMALL LETTER V
                0e0077 TAG LATIN SMALL LETTER W
                0e0078 TAG LATIN SMALL LETTER X
                0e0079 TAG LATIN SMALL LETTER Y
                0e007a TAG LATIN SMALL LETTER Z
                0e007b TAG LEFT CURLY BRACKET
                0e007c TAG VERTICAL LINE
                0e007d TAG RIGHT CURLY BRACKET
                0e007e TAG TILDE
                0e007f CANCEL TAG""")).lines()
                .collect(Collectors.toSet());

        // Check size before
        assertEquals(161, expected.size());

        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                if (Character.getType(codePoint) == Character.FORMAT) {
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
