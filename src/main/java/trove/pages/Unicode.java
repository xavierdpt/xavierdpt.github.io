package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class Unicode extends Page {

    public Unicode() {
        super(makeLocation(CharacterEncodings.LOCATION, "Unicode"), "Unicode");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        String wikipedia = externalLink("https://en.wikipedia.org/wiki/Unicode");
        String website = externalLink("https://home.unicode.org/");
        String standardWebsite = externalLink("http://www.unicode.org/standard/standard.html");
        p("Wikipedia link: " + wikipedia);
        p("Website: " + website);
        p("Website of the standard: " + standardWebsite);
        p("The Unicode Standard Core Specification is 1048 pages long, but it is worthwhile to read at least the first few chapters.");

        /*-

        https://www.unicode.org/charts/
        https://www.unicode.org/charts/PDF/


        https://www.unicode.org/charts/PDF/U0000.pdf

        This code charts contains C0 and Basic Latin character codes, which are aligned to ASCII.

        The first code point is U+0000, is known as the NULL control character.
        In UTF-32, it is encoded as a zero on 32 bits: 00000000000000000000000000000000.
        In UTF-16, it is encoded as a zero on 16 bits: 0000000000000000.
        In UTF-8, it is encoded as a zero on 8 bits: 00000000.

        Next characters are C0 control codes, up to Unit Separator US, 0x1F.
        This character is encoded as itself in UTF-32, UTF-16 and UTF-8.
        UTF-32: 00000000000000000000000000011111.
        UTF-16: 0000000000011111.
        UTF-8: 00011111.

        The first printable character is SPACE at 0x20
        UTF-32: 00000000000000000000000000100000
        UTF-16: 0000000000100000
        UTF-8: 00100000

        Then we have printable characters up to the 0x7E TILDE
        UTF-32: 00000000000000000000000001111110
        UTF-16: 0000000001111110
        UTF-8: 01111110

        And finally we have the DEL chararacter at 007F
        UTF-32: 00000000000000000000000001111111
        UTF-16: 0000000001111111
        UTF-8: 01111111

        https://www.unicode.org/charts/PDF/U0080.pdf
        C1 Controls and Latin-1 Supplement

        ASCII defined characters for the first seven bits of a byte, which left the eighth byte free for other standards
        to jump in and feel the hole.

        The C1 control character is 0080, and does not have a name.
        UTF-32: 00000000000000000000000010000000
        UTF-16: 0000000010000000
        UTF-8:  11000010 10000000

        Because we are leaving the 7-bit ASCII code space, we will now need more than one byte to encode into UTF-8.
        To encode to UTF-8, write the code point in 32-bit binary form.
        If only the lowest bits 7 bits are used, then discard the 24 other bits and you're done.
        Otherwise, keep the lowest 6 bits, and prefix those with 10.
        Try to stuff the other bits in a second byte to the left that starts with 110.
        If the remaining bits do not fit, keep 6 bits, prefix them with 10.
        Try to stuff the other bits in a third byte to the left that starts with 1110.
        If the remaining bits do not fit, keep 6 bits, prefix them with 10.
        Stuff the other bits in a fourth byte to the left that starts with 11110.

        Let's do this for 0080.
        In binary, it is 10000000.
        We take the six lowest bits, and prefix with 10.
        We get 10000000.
        We are left with to bits (10) and we can stuff those in a second byte starting with 110.
        So that second byte is 11000010, and the UTF-8 encoding for 0080 is 11000010 10000000.

        The first printable character is 00A1 INVERTED EXCLAMATION MARK
        UTF-32: 00000000000000000000000010100001
        UTF-16: 0000000010100001
        UTF-8: 11000010 10100001

        The last printable character is 00FF LATIN SMALL LETTER Y WITH DIAERESIS
        UTF-32: 00000000000000000000000011111111
        UTF-16: 0000000011111111
        UTF-8: 11000011 10111111

        https://www.unicode.org/charts/PDF/U0100.pdf
        Latin Extended-A

        We are now leaving the space of characters code defined on one byte, but we will not feel this change yet.
        The encodings for UTF-32 and UTF-16 remain straightforward, and the UTF-8 encoding will be using two bytes for a while.
        But all forthcoming characters have no counterpart in any 8-bit byte-oriented character encoding standard.

        This block contains only printable characters.

        0100 LATIN CAPITAL LETTER A WITH MACRON
        UTF-32: 00000000000000000000000100000000
        UTF-16: 0000000100000000
        UTF-8: 11000100 10000000

        017F LATIN SMALL LETTER LONG S
        UTF-32: 00000000000000000000000101111111
        UTF-16: 0000000101111111
        UTF-8: 11000101 10111111

        https://www.unicode.org/charts/PDF/U0100.pdf
        Latin Extended-B

        0180 LATIN SMALL LETTER B WITH STROKE
        UTF-32: 00000000000000000000000110000000
        UTF-16: 0000000110000000
        UTF-8: 11000110 10000000

        024F LATIN SMALL LETTER Y WITH STROKE
        UTF-32: 00000000000000000000001001001111
        UTF-16: 0000001001001111
        UTF-8: 11001001 10001111

        https://www.unicode.org/charts/PDF/U0250.pdf
        IPA Extensions
        O250
        02AF

        https://www.unicode.org/charts/PDF/U02B0.pdf
        Spacing Modifier Letters
        02B0
        02FF

        https://www.unicode.org/charts/PDF/U0300.pdf
        Combining Diacritical Marks
        0300
        036F

        https://www.unicode.org/charts/PDF/U0370.pdf
        Greek and Coptic
        0370
        03FF

        https://www.unicode.org/charts/PDF/U0400.pdf
        Cyrillic
        0400
        04FF

        https://www.unicode.org/charts/PDF/U0500.pdf
        Cyrillic Supplement
        0500
        052F

        https://www.unicode.org/charts/PDF/U0530.pdf
        Armenian
        0530
        058F

        https://www.unicode.org/charts/PDF/U0590.pdf
        Hebrew
        0590
        05FF

        https://www.unicode.org/charts/PDF/U0600.pdf
        Arabic
        0600
        06FF

        https://www.unicode.org/charts/PDF/U0700.pdf
        Syriac
        0700
        074F

        https://www.unicode.org/charts/PDF/U0750.pdf
        Arabic Supplement
        0750
        077F

        https://www.unicode.org/charts/PDF/U0780.pdf
        Thaana
        0780
        07BF

        https://www.unicode.org/charts/PDF/U07C0.pdf
        NKo
        07C0
        07FF

        https://www.unicode.org/charts/PDF/U0800.pdf
        https://www.unicode.org/charts/PDF/U0840.pdf
        https://www.unicode.org/charts/PDF/U0860.pdf
        https://www.unicode.org/charts/PDF/U0870.pdf
        https://www.unicode.org/charts/PDF/U08A0.pdf
        Arabic Extended-A
        08A0
        08FF
        https://www.unicode.org/charts/PDF/U0900.pdf
        https://www.unicode.org/charts/PDF/U0980.pdf
        https://www.unicode.org/charts/PDF/U0A00.pdf
        https://www.unicode.org/charts/PDF/U0A80.pdf
        https://www.unicode.org/charts/PDF/U0B00.pdf
        https://www.unicode.org/charts/PDF/U0B80.pdf
        https://www.unicode.org/charts/PDF/U0C00.pdf
        https://www.unicode.org/charts/PDF/U0C80.pdf
        https://www.unicode.org/charts/PDF/U0D00.pdf
        https://www.unicode.org/charts/PDF/U0D80.pdf
        https://www.unicode.org/charts/PDF/U0E00.pdf
        https://www.unicode.org/charts/PDF/U0E80.pdf
        https://www.unicode.org/charts/PDF/U0F00.pdf
        https://www.unicode.org/charts/PDF/U1000.pdf
        https://www.unicode.org/charts/PDF/U10A0.pdf
        https://www.unicode.org/charts/PDF/U1100.pdf
        https://www.unicode.org/charts/PDF/U1200.pdf
        https://www.unicode.org/charts/PDF/U1380.pdf
        https://www.unicode.org/charts/PDF/U13A0.pdf
        https://www.unicode.org/charts/PDF/U1400.pdf
        https://www.unicode.org/charts/PDF/U1680.pdf
        https://www.unicode.org/charts/PDF/U16A0.pdf
        https://www.unicode.org/charts/PDF/U1700.pdf
        https://www.unicode.org/charts/PDF/U1720.pdf
        https://www.unicode.org/charts/PDF/U1740.pdf
        https://www.unicode.org/charts/PDF/U1760.pdf
        https://www.unicode.org/charts/PDF/U1780.pdf
        https://www.unicode.org/charts/PDF/U1800.pdf
        https://www.unicode.org/charts/PDF/U18B0.pdf
        https://www.unicode.org/charts/PDF/U1900.pdf
        https://www.unicode.org/charts/PDF/U1950.pdf
        https://www.unicode.org/charts/PDF/U1980.pdf
        https://www.unicode.org/charts/PDF/U19E0.pdf
        https://www.unicode.org/charts/PDF/U1A00.pdf
        https://www.unicode.org/charts/PDF/U1A20.pdf
        https://www.unicode.org/charts/PDF/U1AB0.pdf
        https://www.unicode.org/charts/PDF/U1B00.pdf
        https://www.unicode.org/charts/PDF/U1B80.pdf
        https://www.unicode.org/charts/PDF/U1BC0.pdf
        https://www.unicode.org/charts/PDF/U1C00.pdf
        https://www.unicode.org/charts/PDF/U1C50.pdf
        https://www.unicode.org/charts/PDF/U1C80.pdf
        https://www.unicode.org/charts/PDF/U1C90.pdf
        https://www.unicode.org/charts/PDF/U1CC0.pdf
        https://www.unicode.org/charts/PDF/U1CD0.pdf
        https://www.unicode.org/charts/PDF/U1D00.pdf
        https://www.unicode.org/charts/PDF/U1D80.pdf
        https://www.unicode.org/charts/PDF/U1DC0.pdf
        https://www.unicode.org/charts/PDF/U1E00.pdf
        https://www.unicode.org/charts/PDF/U1F00.pdf
        https://www.unicode.org/charts/PDF/U2000.pdf
        https://www.unicode.org/charts/PDF/U2070.pdf
        https://www.unicode.org/charts/PDF/U20A0.pdf
        https://www.unicode.org/charts/PDF/U20D0.pdf
        https://www.unicode.org/charts/PDF/U2100.pdf
        https://www.unicode.org/charts/PDF/U2150.pdf
        https://www.unicode.org/charts/PDF/U2190.pdf
        https://www.unicode.org/charts/PDF/U2200.pdf
        https://www.unicode.org/charts/PDF/U2300.pdf
        https://www.unicode.org/charts/PDF/U2400.pdf
        https://www.unicode.org/charts/PDF/U2440.pdf
        https://www.unicode.org/charts/PDF/U2460.pdf
        https://www.unicode.org/charts/PDF/U2500.pdf
        https://www.unicode.org/charts/PDF/U2580.pdf
        https://www.unicode.org/charts/PDF/U25A0.pdf
        https://www.unicode.org/charts/PDF/U2600.pdf
        https://www.unicode.org/charts/PDF/U2700.pdf
        https://www.unicode.org/charts/PDF/U27C0.pdf
        https://www.unicode.org/charts/PDF/U27F0.pdf
        https://www.unicode.org/charts/PDF/U2800.pdf
        https://www.unicode.org/charts/PDF/U2900.pdf
        https://www.unicode.org/charts/PDF/U2980.pdf
        https://www.unicode.org/charts/PDF/U2A00.pdf
        https://www.unicode.org/charts/PDF/U2B00.pdf
        https://www.unicode.org/charts/PDF/U2C00.pdf
        https://www.unicode.org/charts/PDF/U2C60.pdf
        https://www.unicode.org/charts/PDF/U2C80.pdf
        https://www.unicode.org/charts/PDF/U2D00.pdf
        https://www.unicode.org/charts/PDF/U2D30.pdf
        https://www.unicode.org/charts/PDF/U2D80.pdf
        https://www.unicode.org/charts/PDF/U2DE0.pdf
        https://www.unicode.org/charts/PDF/U2E00.pdf
        https://www.unicode.org/charts/PDF/U2E80.pdf
        https://www.unicode.org/charts/PDF/U2F00.pdf
        https://www.unicode.org/charts/PDF/U2FF0.pdf





        Numeric value = code point + name
        UTF-32, UTF-16, UTF-8
        ISO/IEC 10646 UCS Universal Coded Character Set
        BMP: Basic Multilingual Plane : code points <= 65536
        144,697 characters defined
        6400 code points in the BMP available for private use
        131068 code points outside the BMP available for private use
        U+000000 -- U+10FFFF
        Control codes:
        - C0: U+000000 -- U+00001F
        - C1: U+00007F -- U+00009F
        Noncharacters:
        - U+00FDD0 -- U+00FDEF
        - U+..FFFE, U+..FFFF
        Private Use
        Surrogates: 2048 code points
        UTF-8
        UTF-16
        UTF-32
        UTF-32 code point range:
        - U+000000 -- U+00D7FF
        - U+00E000 -- U+10FFFF
        UTF-16:
        - U+000000 -- U+00FFFF => One 16-bit code unit
        - U+010000 -- U+10FFFF => Two 16-bit code unit = surrogate pairs
        UTF-8: 8-bit code units
        - U+000000 -- U+00007F : 1 byte (ASCII)
        - U+000800 -- U+00FFFF : 3 bytes (ASCII)
        - > U+00FFFF : 4 bytes (ASCII)

        The order of code units for UTF-16 and UTF-8 is well defined.
        But the order of bytes in UTF-32 and UTF-16 code units is dependent on endianess.

        BOM: Byte Order Mark

        replacement character U+FFFD

        Planes are sets of 64K continugous code points.
        Plane 0 : BMP : Basic Multilingual Plane
        Plane 1 : SMP : Supplementary Multilingual Plane
        Plane 2 : SIP : Supplementary Ideographic Plane
        Plane 3 : TIP : Tertiary Ideographic Plane
        Plane 14 : SSP : Supplementary Special-Purpose Plane
        Plane 15 and Plane 16 : Private use planes

        Unicode encoding forms are described in section 3.9 of the specification.




Codespace
Code point

         */
    }

}
