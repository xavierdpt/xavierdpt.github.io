package net.xdexamples.jse.examples.java.io;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.io.CharArrayReader;
import java.io.IOException;
import java.nio.CharBuffer;

@Scaffolded
public class CharArrayReaderExample extends BaseExample<CharArrayReader> {

    @Override
    @SuppressWarnings({"ResultOfMethodCallIgnored", "unused"})
    protected void scaffold(CharArrayReader instance) throws IOException {
        {
            char[] chars = new char[0];
            CharArrayReader charArrayReader = new CharArrayReader(chars);
        }
        {
            char[] chars = new char[0];
            int offset = 0;
            int length = 0;
            CharArrayReader charArrayReader = new CharArrayReader(chars, offset, length);
        }
        {
            instance.close();
        }
        {
            int limit = 0;
            instance.mark(limit);
        }
        {
            boolean b = instance.markSupported();
        }
        {
            int read = instance.read();
        }
        {
            char[] chars = new char[0];
            int offset = 0;
            int length = 0;
            int read = instance.read(chars, offset, length);
        }
        {
            CharBuffer charBuffer = any();
            int read = instance.read(charBuffer);
        }
        {
            boolean ready = instance.ready();
        }
        {
            instance.reset();
        }
        {
            long n = 0;
            instance.skip(n);
        }
    }
}
