package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterExample_hashCode {

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void example() {

        char ch = '\0';
        Character boxed = Character.valueOf(ch);

        // Member hashCode function of Character
        int boxedHashCode = boxed.hashCode();

        // Static version of hashCode that works direclty on the primitive value
        int primitiveHashCode = Character.hashCode(ch);

        assertEquals(boxedHashCode, primitiveHashCode);

    }

}
