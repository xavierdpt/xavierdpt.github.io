package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.DelegatingInputStream;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DelegatingInputStreamTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException, IOException {
        DelegatingInputStream instance = DelegatingInputStream.class.newInstance();
        instance.close();
        File destinationFile = null;
        instance.transferTo(destinationFile);
        boolean closed = instance.isClosed();
        instance.setClosed(closed);
        int read = instance.read();
        int available = instance.available();
        int arg0 = 0;
        instance.mark(arg0);
        boolean b = instance.markSupported();
        byte[] bytes = new byte[0];
        int arg1 = 0;
        int arg2 = 0;
        int read1 = instance.read(bytes, arg1, arg2);
        int read2 = instance.read(bytes);
        instance.reset();
        long n = 0;
        instance.skip(n);
        InputStream inputStream = null;
        instance.setInputStream(inputStream);
        InputStream inputStream1 = instance.getInputStream();

    }
}
