package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.QuotedPrintableDecoderStream;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class QuotedPrintableDecoderStreamTest {
    @Test
    public void test() throws IOException {
        InputStream is = null;
        QuotedPrintableDecoderStream instance = new QuotedPrintableDecoderStream(is);
        int read = instance.read();

    }
}
