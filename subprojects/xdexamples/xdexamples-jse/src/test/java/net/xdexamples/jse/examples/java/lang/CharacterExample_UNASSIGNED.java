package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CharacterExample_UNASSIGNED {

    @Test
    public void example() {

        // Character type is UNASSIGNED iff character is not defined
        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                assertNotEquals(Character.UNASSIGNED, Character.getType(codePoint));
            } else {
                assertEquals(Character.UNASSIGNED, Character.getType(codePoint));
            }
        }

    }

}
