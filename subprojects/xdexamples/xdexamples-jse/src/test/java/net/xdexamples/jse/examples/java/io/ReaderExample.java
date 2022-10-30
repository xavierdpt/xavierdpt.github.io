package net.xdexamples.jse.examples.java.io;

import net.xdexamples.support.internal.Scaffolded;
import net.xdexamples.support.internal.BaseExample;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;

@Scaffolded
public class ReaderExample extends BaseExample<Reader> {
    @Override
    public void scaffold(Reader instance) throws IOException {

        int readAheadLimit = 0;
        char[] chars = new char[0];
        int offset = 0;
        int length = 0;
        CharBuffer charBuffer = null;
        long n = 0;
        Writer writer = null;

        instance.close();
        instance.mark(readAheadLimit);
        boolean b = instance.markSupported();
        Reader reader = Reader.nullReader();
        int read = instance.read();
        int read1 = instance.read(chars);
        int read2 = instance.read(chars, offset, length);
        int read3 = instance.read(charBuffer);
        boolean ready = instance.ready();
        instance.reset();
        long skip = instance.skip(n);
        instance.transferTo(writer);
    }
}
