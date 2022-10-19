package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.Base64DecoderStream;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Base64DecoderStreamTest {
    @Test
    public void test() throws IOException {
        InputStream in = null;
        Base64DecoderStream instance = new Base64DecoderStream(in);
        int read = instance.read();
        byte[] buffer = new byte[0];
        int offset = 0;
        int length = 0;
        int read1 = instance.read(buffer, offset, length);
        boolean b = instance.markSupported();
        int available = instance.available();
    }
}
