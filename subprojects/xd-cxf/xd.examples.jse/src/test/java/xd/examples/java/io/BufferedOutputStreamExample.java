package xd.examples.java.io;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Scaffolded
public class BufferedOutputStreamExample extends BaseExample<BufferedOutputStream> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(BufferedOutputStream instance) throws IOException {
        {
            OutputStream outputStream = any();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        }
        {
            OutputStream outputStream = any();
            int size = 0;
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, size);
        }
        {
            instance.flush();
        }
        {
            int b = 0;
            instance.write(b);
        }
        {
            byte[] bytes = new byte[0];
            int offset = 0;
            int length = 0;
            instance.write(bytes, offset, length);
        }
    }

}
