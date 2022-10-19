package xd.examples.java.io;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

@Scaffolded
public class ByteArrayOutputStreamExample extends BaseExample<ByteArrayOutputStream> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(ByteArrayOutputStream instance) throws IOException {
        {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        }
        {
            int size = 0;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
        }
        {
            instance.close();
        }
        {
            instance.reset();
        }
        {
            int size = instance.size();
        }
        {
            byte[] bytes = instance.toByteArray();
        }
        {
            String s = instance.toString();
        }
        {
            String charsetName = any();
            String s = instance.toString(charsetName);
        }
        {
            Charset charset = any();
            String s = instance.toString(charset);
        }

        // 2/3
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
        {
            byte[] bytes = new byte[0];
            instance.writeBytes(bytes);
        }
        {
            OutputStream outputStream = any();
            instance.writeTo(outputStream);
        }
    }

}
