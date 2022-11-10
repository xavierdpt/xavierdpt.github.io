package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_CURRENCY_SYMBOL {

    @Test
    public void example() {

        // Unicode contains exactly those 62 currency symbol codepoints

        Set<String> expected = new BufferedReader(new StringReader("""
                000024 DOLLAR SIGN
                0000a2 CENT SIGN
                0000a3 POUND SIGN
                0000a4 CURRENCY SIGN
                0000a5 YEN SIGN
                00058f ARMENIAN DRAM SIGN
                00060b AFGHANI SIGN
                0007fe NKO DOROME SIGN
                0007ff NKO TAMAN SIGN
                0009f2 BENGALI RUPEE MARK
                0009f3 BENGALI RUPEE SIGN
                0009fb BENGALI GANDA MARK
                000af1 GUJARATI RUPEE SIGN
                000bf9 TAMIL RUPEE SIGN
                000e3f THAI CURRENCY SYMBOL BAHT
                0017db KHMER CURRENCY SYMBOL RIEL
                0020a0 EURO-CURRENCY SIGN
                0020a1 COLON SIGN
                0020a2 CRUZEIRO SIGN
                0020a3 FRENCH FRANC SIGN
                0020a4 LIRA SIGN
                0020a5 MILL SIGN
                0020a6 NAIRA SIGN
                0020a7 PESETA SIGN
                0020a8 RUPEE SIGN
                0020a9 WON SIGN
                0020aa NEW SHEQEL SIGN
                0020ab DONG SIGN
                0020ac EURO SIGN
                0020ad KIP SIGN
                0020ae TUGRIK SIGN
                0020af DRACHMA SIGN
                0020b0 GERMAN PENNY SIGN
                0020b1 PESO SIGN
                0020b2 GUARANI SIGN
                0020b3 AUSTRAL SIGN
                0020b4 HRYVNIA SIGN
                0020b5 CEDI SIGN
                0020b6 LIVRE TOURNOIS SIGN
                0020b7 SPESMILO SIGN
                0020b8 TENGE SIGN
                0020b9 INDIAN RUPEE SIGN
                0020ba TURKISH LIRA SIGN
                0020bb NORDIC MARK SIGN
                0020bc MANAT SIGN
                0020bd RUBLE SIGN
                0020be LARI SIGN
                0020bf BITCOIN SIGN
                00a838 NORTH INDIC RUPEE MARK
                00fdfc RIAL SIGN
                00fe69 SMALL DOLLAR SIGN
                00ff04 FULLWIDTH DOLLAR SIGN
                00ffe0 FULLWIDTH CENT SIGN
                00ffe1 FULLWIDTH POUND SIGN
                00ffe5 FULLWIDTH YEN SIGN
                00ffe6 FULLWIDTH WON SIGN
                011fdd TAMIL SIGN KAACU
                011fde TAMIL SIGN PANAM
                011fdf TAMIL SIGN PON
                011fe0 TAMIL SIGN VARAAKAN
                01e2ff WANCHO NGUN SIGN
                01ecb0 INDIC SIYAQ RUPEE MARK""")).lines()
                .collect(Collectors.toSet());

        // Check size before
        assertEquals(62, expected.size());

        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                if (Character.getType(codePoint) == Character.CURRENCY_SYMBOL) {
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
