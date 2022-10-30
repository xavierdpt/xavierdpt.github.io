package net.xdexamples.jse.examples.java.io;

import net.xdexamples.support.internal.Scaffolded;
import net.xdexamples.support.internal.BaseExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

@Scaffolded
public class BufferedReaderExample extends BaseExample<BufferedReader> {

    @Override
    @SuppressWarnings({"unused", "ConstantConditions"})
    protected void scaffold(BufferedReader instance) throws IOException {
        {
            Reader reader = any();
            new BufferedReader(reader);
        }
        {
            Reader reader = any();
            int size = 0;
            new BufferedReader(reader, size);
        }
        {
            instance.close();
        }
        {
            instance.lines();
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
            String s = instance.readLine();
        }
        {
            boolean ready = instance.ready();
        }
        {
            instance.reset();
        }
        {
            long n = 0;
            long skip = instance.skip(n);
        }
    }
}
