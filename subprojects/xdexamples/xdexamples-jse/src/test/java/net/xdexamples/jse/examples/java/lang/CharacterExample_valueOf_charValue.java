package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterExample_valueOf_charValue {

    @Test
    @SuppressWarnings({"ConstantConditions", "UnnecessaryBoxing", "UnnecessaryUnboxing"})
    public void example() {

        char ch = '\0';

        // valueOf maps char to Character
        Character boxed = Character.valueOf(ch);

        // charValue maps Character to char
        char unboxed = boxed.charValue();

        assertEquals(ch, unboxed);
    }

}
