package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.MimeBodyPartInputStream;
import org.junit.Test;

import java.io.IOException;
import java.io.PushbackInputStream;

public class MimeBodyPartInputStreamTest {
    @Test
    public void test() throws IOException {
        PushbackInputStream inStreamParam = null;
        byte[] boundaryParam = new byte[0];
        int pbsize = 0;
        MimeBodyPartInputStream instance = new MimeBodyPartInputStream(inStreamParam, boundaryParam, pbsize);
        byte[] buf = new byte[0];
        int origOff = 0;
        int origLen = 0;
        int read = instance.read(buf, origOff, origLen);
        int read1 = instance.read();
        instance.close();
    }
}
