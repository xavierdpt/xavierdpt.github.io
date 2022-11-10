package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class StringExample_getChars {

    @Test
    public void example() {

        // This copy some of the characters at some offset in a preallocated char array
        // to actually get a char array, use toCharArray()

        String string = "hello";

        int srcBegin = 1;
        int srcEnd = string.length() - 1;
        int dstBegin = 2;
        char[] dst = new char[srcEnd - srcBegin + dstBegin];

        string.getChars(srcBegin, srcEnd, dst, dstBegin);

        assertArrayEquals(new char[]{'\0', '\0', 'e','l','l'}, dst);



    }

}
