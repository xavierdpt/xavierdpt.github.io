package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CharacterExample_isDigitCodePoint {

    @Test
    public void example() {

        // Unicode defines digits ONE to NINE for a variety of scripts with predictable names

        String[] scripts = new String[]{
                "",
                "ADLAM",
                "AHOM",
                "ARABIC-INDIC",
                "BALINESE",
                "BENGALI",
                "BHAIKSUKI",
                "BRAHMI",
                "CHAKMA",
                "CHAM",
                "DEVANAGARI",
                "DIVES AKURU",
                "EXTENDED ARABIC-INDIC",
                "FULLWIDTH",
                "GUJARATI",
                "GUNJALA GONDI",
                "GURMUKHI",
                "HANIFI ROHINGYA",
                "JAVANESE",
                "KANNADA",
                "KAYAH LI",
                "KHMER",
                "KHUDAWADI",
                "LAO",
                "LEPCHA",
                "LIMBU",
                "MALAYALAM",
                "MASARAM GONDI",
                "MATHEMATICAL BOLD",
                "MATHEMATICAL DOUBLE-STRUCK",
                "MATHEMATICAL MONOSPACE",
                "MATHEMATICAL SANS-SERIF",
                "MATHEMATICAL SANS-SERIF BOLD",
                "MEETEI MAYEK",
                "MODI",
                "MONGOLIAN",
                "MRO",
                "MYANMAR",
                "MYANMAR SHAN",
                "MYANMAR TAI LAING",
                "NEW TAI LUE",
                "NEWA",
                "NKO",
                "NYIAKENG PUACHUE HMONG",
                "OL CHIKI",
                "ORIYA",
                "OSMANYA",
                "PAHAWH HMONG",
                "SAURASHTRA",
                "SEGMENTED",
                "SHARADA",
                "SINHALA LITH",
                "SORA SOMPENG",
                "SUNDANESE",
                "TAI THAM HORA",
                "TAI THAM THAM",
                "TAKRI",
                "TAMIL",
                "TELUGU",
                "THAI",
                "TIBETAN",
                "TIRHUTA",
                "VAI",
                "WANCHO",
                "WARANG CITI"
        };

        String[] digits = "ZERO,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE".split(",");

        for (String script : scripts) {
            for (String digit : digits) {
                String digitName = script + " DIGIT " + digit;
                int codePoint = Character.codePointOf(digitName.strip());
                boolean result = Character.isDigit(codePoint);
                assertTrue(result);
            }
        }
    }

}
