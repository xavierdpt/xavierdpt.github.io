package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_MODIFIER_SYMBOL {

    @Test
    public void example() {

        // Unicode contains exactly those 123 modifier codepoints

        Set<String> expected = new BufferedReader(new StringReader("""
                00005e CIRCUMFLEX ACCENT
                000060 GRAVE ACCENT
                0000a8 DIAERESIS
                0000af MACRON
                0000b4 ACUTE ACCENT
                0000b8 CEDILLA
                0002c2 MODIFIER LETTER LEFT ARROWHEAD
                0002c3 MODIFIER LETTER RIGHT ARROWHEAD
                0002c4 MODIFIER LETTER UP ARROWHEAD
                0002c5 MODIFIER LETTER DOWN ARROWHEAD
                0002d2 MODIFIER LETTER CENTRED RIGHT HALF RING
                0002d3 MODIFIER LETTER CENTRED LEFT HALF RING
                0002d4 MODIFIER LETTER UP TACK
                0002d5 MODIFIER LETTER DOWN TACK
                0002d6 MODIFIER LETTER PLUS SIGN
                0002d7 MODIFIER LETTER MINUS SIGN
                0002d8 BREVE
                0002d9 DOT ABOVE
                0002da RING ABOVE
                0002db OGONEK
                0002dc SMALL TILDE
                0002dd DOUBLE ACUTE ACCENT
                0002de MODIFIER LETTER RHOTIC HOOK
                0002df MODIFIER LETTER CROSS ACCENT
                0002e5 MODIFIER LETTER EXTRA-HIGH TONE BAR
                0002e6 MODIFIER LETTER HIGH TONE BAR
                0002e7 MODIFIER LETTER MID TONE BAR
                0002e8 MODIFIER LETTER LOW TONE BAR
                0002e9 MODIFIER LETTER EXTRA-LOW TONE BAR
                0002ea MODIFIER LETTER YIN DEPARTING TONE MARK
                0002eb MODIFIER LETTER YANG DEPARTING TONE MARK
                0002ed MODIFIER LETTER UNASPIRATED
                0002ef MODIFIER LETTER LOW DOWN ARROWHEAD
                0002f0 MODIFIER LETTER LOW UP ARROWHEAD
                0002f1 MODIFIER LETTER LOW LEFT ARROWHEAD
                0002f2 MODIFIER LETTER LOW RIGHT ARROWHEAD
                0002f3 MODIFIER LETTER LOW RING
                0002f4 MODIFIER LETTER MIDDLE GRAVE ACCENT
                0002f5 MODIFIER LETTER MIDDLE DOUBLE GRAVE ACCENT
                0002f6 MODIFIER LETTER MIDDLE DOUBLE ACUTE ACCENT
                0002f7 MODIFIER LETTER LOW TILDE
                0002f8 MODIFIER LETTER RAISED COLON
                0002f9 MODIFIER LETTER BEGIN HIGH TONE
                0002fa MODIFIER LETTER END HIGH TONE
                0002fb MODIFIER LETTER BEGIN LOW TONE
                0002fc MODIFIER LETTER END LOW TONE
                0002fd MODIFIER LETTER SHELF
                0002fe MODIFIER LETTER OPEN SHELF
                0002ff MODIFIER LETTER LOW LEFT ARROW
                000375 GREEK LOWER NUMERAL SIGN
                000384 GREEK TONOS
                000385 GREEK DIALYTIKA TONOS
                001fbd GREEK KORONIS
                001fbf GREEK PSILI
                001fc0 GREEK PERISPOMENI
                001fc1 GREEK DIALYTIKA AND PERISPOMENI
                001fcd GREEK PSILI AND VARIA
                001fce GREEK PSILI AND OXIA
                001fcf GREEK PSILI AND PERISPOMENI
                001fdd GREEK DASIA AND VARIA
                001fde GREEK DASIA AND OXIA
                001fdf GREEK DASIA AND PERISPOMENI
                001fed GREEK DIALYTIKA AND VARIA
                001fee GREEK DIALYTIKA AND OXIA
                001fef GREEK VARIA
                001ffd GREEK OXIA
                001ffe GREEK DASIA
                00309b KATAKANA-HIRAGANA VOICED SOUND MARK
                00309c KATAKANA-HIRAGANA SEMI-VOICED SOUND MARK
                00a700 MODIFIER LETTER CHINESE TONE YIN PING
                00a701 MODIFIER LETTER CHINESE TONE YANG PING
                00a702 MODIFIER LETTER CHINESE TONE YIN SHANG
                00a703 MODIFIER LETTER CHINESE TONE YANG SHANG
                00a704 MODIFIER LETTER CHINESE TONE YIN QU
                00a705 MODIFIER LETTER CHINESE TONE YANG QU
                00a706 MODIFIER LETTER CHINESE TONE YIN RU
                00a707 MODIFIER LETTER CHINESE TONE YANG RU
                00a708 MODIFIER LETTER EXTRA-HIGH DOTTED TONE BAR
                00a709 MODIFIER LETTER HIGH DOTTED TONE BAR
                00a70a MODIFIER LETTER MID DOTTED TONE BAR
                00a70b MODIFIER LETTER LOW DOTTED TONE BAR
                00a70c MODIFIER LETTER EXTRA-LOW DOTTED TONE BAR
                00a70d MODIFIER LETTER EXTRA-HIGH DOTTED LEFT-STEM TONE BAR
                00a70e MODIFIER LETTER HIGH DOTTED LEFT-STEM TONE BAR
                00a70f MODIFIER LETTER MID DOTTED LEFT-STEM TONE BAR
                00a710 MODIFIER LETTER LOW DOTTED LEFT-STEM TONE BAR
                00a711 MODIFIER LETTER EXTRA-LOW DOTTED LEFT-STEM TONE BAR
                00a712 MODIFIER LETTER EXTRA-HIGH LEFT-STEM TONE BAR
                00a713 MODIFIER LETTER HIGH LEFT-STEM TONE BAR
                00a714 MODIFIER LETTER MID LEFT-STEM TONE BAR
                00a715 MODIFIER LETTER LOW LEFT-STEM TONE BAR
                00a716 MODIFIER LETTER EXTRA-LOW LEFT-STEM TONE BAR
                00a720 MODIFIER LETTER STRESS AND HIGH TONE
                00a721 MODIFIER LETTER STRESS AND LOW TONE
                00a789 MODIFIER LETTER COLON
                00a78a MODIFIER LETTER SHORT EQUALS SIGN
                00ab5b MODIFIER BREVE WITH INVERTED BREVE
                00ab6a MODIFIER LETTER LEFT TACK
                00ab6b MODIFIER LETTER RIGHT TACK
                00fbb2 ARABIC SYMBOL DOT ABOVE
                00fbb3 ARABIC SYMBOL DOT BELOW
                00fbb4 ARABIC SYMBOL TWO DOTS ABOVE
                00fbb5 ARABIC SYMBOL TWO DOTS BELOW
                00fbb6 ARABIC SYMBOL THREE DOTS ABOVE
                00fbb7 ARABIC SYMBOL THREE DOTS BELOW
                00fbb8 ARABIC SYMBOL THREE DOTS POINTING DOWNWARDS ABOVE
                00fbb9 ARABIC SYMBOL THREE DOTS POINTING DOWNWARDS BELOW
                00fbba ARABIC SYMBOL FOUR DOTS ABOVE
                00fbbb ARABIC SYMBOL FOUR DOTS BELOW
                00fbbc ARABIC SYMBOL DOUBLE VERTICAL BAR BELOW
                00fbbd ARABIC SYMBOL TWO DOTS VERTICALLY ABOVE
                00fbbe ARABIC SYMBOL TWO DOTS VERTICALLY BELOW
                00fbbf ARABIC SYMBOL RING
                00fbc0 ARABIC SYMBOL SMALL TAH ABOVE
                00fbc1 ARABIC SYMBOL SMALL TAH BELOW
                00ff3e FULLWIDTH CIRCUMFLEX ACCENT
                00ff40 FULLWIDTH GRAVE ACCENT
                00ffe3 FULLWIDTH MACRON
                01f3fb EMOJI MODIFIER FITZPATRICK TYPE-1-2
                01f3fc EMOJI MODIFIER FITZPATRICK TYPE-3
                01f3fd EMOJI MODIFIER FITZPATRICK TYPE-4
                01f3fe EMOJI MODIFIER FITZPATRICK TYPE-5
                01f3ff EMOJI MODIFIER FITZPATRICK TYPE-6""")).lines()
                .collect(Collectors.toSet());

        // Check size before
        assertEquals(123, expected.size());

        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                if (Character.getType(codePoint) == Character.MODIFIER_SYMBOL) {
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
