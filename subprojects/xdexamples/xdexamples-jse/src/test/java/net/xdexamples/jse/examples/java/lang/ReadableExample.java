package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ReadableExample {

    @Test
    public void example() throws IOException {

        // InputStreamReader implements readable
        Readable readable = new InputStreamReader(new ByteArrayInputStream("hello".getBytes()));

        // Allocate a char buffer with 2 chars
        CharBuffer charBuffer = CharBuffer.allocate(2);

        // Read from the readable into the char buffer
        int read = readable.read(charBuffer);

        // Check number of chars read
        assertEquals(2, read);

        // Check chars read
        assertArrayEquals(new char[]{'h', 'e'}, charBuffer.array());

    }

}
