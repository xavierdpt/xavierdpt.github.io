package xd.examples.java.io;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

@Scaffolded
public class BufferedInputStreamExample extends BaseExample<BufferedInputStream> {

    @Override
    @SuppressWarnings({"unused", "ConstantConditions"})
    protected void scaffold(BufferedInputStream instance) throws IOException {

        {
            InputStream inputStream = any();
            new BufferedInputStream(inputStream);
        }
        {
            InputStream inputStream = any();
            int size = 0;
            new BufferedInputStream(inputStream, size);
        }
        {
            int available = instance.available();
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
            byte[] bytes = new byte[0];
            int offset = 0;
            int length = 0;
            int read = instance.read(bytes, offset, length);
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
