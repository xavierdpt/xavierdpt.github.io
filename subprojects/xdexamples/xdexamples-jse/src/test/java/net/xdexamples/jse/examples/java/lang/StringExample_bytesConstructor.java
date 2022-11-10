package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertEquals;

public class StringExample_bytesConstructor {

    @Test
    public void example() {

        {
            // ALL C0 Control code points + SPACE
            byte[] bytes = new byte[33];
            for (byte b = 0; b < bytes.length; b++) {
                bytes[b] = b;
            }

            String string = new String(bytes);

            String expected = fromCodePointNames(
                    "NULL",
                    "START OF HEADING",
                    "START OF TEXT",
                    "END OF TEXT",
                    "END OF TRANSMISSION",
                    "ENQUIRY",
                    "ACKNOWLEDGE",
                    "BEL",
                    "BACKSPACE",
                    "CHARACTER TABULATION",
                    "LINE FEED (LF)",
                    "LINE TABULATION",
                    "FORM FEED (FF)",
                    "CARRIAGE RETURN (CR)",
                    "SHIFT OUT",
                    "SHIFT IN",
                    "DATA LINK ESCAPE",
                    "DEVICE CONTROL ONE",
                    "DEVICE CONTROL TWO",
                    "DEVICE CONTROL THREE",
                    "DEVICE CONTROL FOUR",
                    "NEGATIVE ACKNOWLEDGE",
                    "SYNCHRONOUS IDLE",
                    "END OF TRANSMISSION BLOCK",
                    "CANCEL",
                    "END OF MEDIUM",
                    "SUBSTITUTE",
                    "ESCAPE",
                    "INFORMATION SEPARATOR FOUR",
                    "INFORMATION SEPARATOR THREE",
                    "INFORMATION SEPARATOR TWO",
                    "INFORMATION SEPARATOR ONE",
                    "SPACE"
            );

            assertEquals(expected, string);
        }
        {
            // Cuneiform is outside the BMP and requries many UTF8 bytes
            byte[] bytes = new byte[]{
                    (byte) 0xF0,
                    (byte) 0x92,
                    (byte) 0x80,
                    (byte) 0xBC
            };

            String string = new String(bytes);

            // 1 code point => four bytes
            String expected = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");

            assertEquals(expected, string);
        }
    }

}
