package xd.examples.java.io;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Scaffolded
public class ByteArrayInputStreamExample extends BaseExample<ByteArrayInputStream> {

    @Override
    @SuppressWarnings({"unused", "ResultOfMethodCallIgnored"})
    protected void scaffold(ByteArrayInputStream instance) throws IOException {
        {
            byte[] bytes = new byte[0];
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        }
        {
            byte[] bytes = new byte[0];
            int offset = 0;
            int length = 0;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes, offset, length);
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
            byte[] bytes = instance.readAllBytes();
        }
        {
            byte[] bytes = new byte[0];
            int offset = 0;
            int length = 0;
            int i = instance.readNBytes(bytes, offset, length);
        }
        {
            instance.reset();
        }
        {
            long n = 0;
            instance.skip(n);
        }
        {
            OutputStream outputStream = null;
            long l = instance.transferTo(outputStream);
        }
    }
}
