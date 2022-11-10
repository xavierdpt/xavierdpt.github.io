package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_CONTROL {

    @Test
    public void example() {

        // Unicode contains exactly those 65 control codepoints

        Set<String> expected = new BufferedReader(new StringReader("""
                000000 NULL
                000001 START OF HEADING
                000002 START OF TEXT
                000003 END OF TEXT
                000004 END OF TRANSMISSION
                000005 ENQUIRY
                000006 ACKNOWLEDGE
                000007 BEL
                000008 BACKSPACE
                000009 CHARACTER TABULATION
                00000a LINE FEED (LF)
                00000b LINE TABULATION
                00000c FORM FEED (FF)
                00000d CARRIAGE RETURN (CR)
                00000e SHIFT OUT
                00000f SHIFT IN
                000010 DATA LINK ESCAPE
                000011 DEVICE CONTROL ONE
                000012 DEVICE CONTROL TWO
                000013 DEVICE CONTROL THREE
                000014 DEVICE CONTROL FOUR
                000015 NEGATIVE ACKNOWLEDGE
                000016 SYNCHRONOUS IDLE
                000017 END OF TRANSMISSION BLOCK
                000018 CANCEL
                000019 END OF MEDIUM
                00001a SUBSTITUTE
                00001b ESCAPE
                00001c INFORMATION SEPARATOR FOUR
                00001d INFORMATION SEPARATOR THREE
                00001e INFORMATION SEPARATOR TWO
                00001f INFORMATION SEPARATOR ONE
                00007f DELETE
                000080 PADDING CHARACTER
                000081 HIGH OCTET PRESET
                000082 BREAK PERMITTED HERE
                000083 NO BREAK HERE
                000084 LATIN 1 SUPPLEMENT 84
                000085 NEXT LINE (NEL)
                000086 START OF SELECTED AREA
                000087 END OF SELECTED AREA
                000088 CHARACTER TABULATION SET
                000089 CHARACTER TABULATION WITH JUSTIFICATION
                00008a LINE TABULATION SET
                00008b PARTIAL LINE FORWARD
                00008c PARTIAL LINE BACKWARD
                00008d REVERSE LINE FEED
                00008e SINGLE SHIFT TWO
                00008f SINGLE SHIFT THREE
                000090 DEVICE CONTROL STRING
                000091 PRIVATE USE ONE
                000092 PRIVATE USE TWO
                000093 SET TRANSMIT STATE
                000094 CANCEL CHARACTER
                000095 MESSAGE WAITING
                000096 START OF GUARDED AREA
                000097 END OF GUARDED AREA
                000098 START OF STRING
                000099 SINGLE GRAPHIC CHARACTER INTRODUCER
                00009a SINGLE CHARACTER INTRODUCER
                00009b CONTROL SEQUENCE INTRODUCER
                00009c STRING TERMINATOR
                00009d OPERATING SYSTEM COMMAND
                00009e PRIVACY MESSAGE
                00009f APPLICATION PROGRAM COMMAND""")).lines()
                .collect(Collectors.toSet());

        // Check size before
        assertEquals(65, expected.size());

        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                if (Character.getType(codePoint) == Character.CONTROL) {
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
