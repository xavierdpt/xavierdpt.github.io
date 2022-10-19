package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.Rfc5987Util;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class Rfc5987UtilTest {
    @Test
    public void test() throws UnsupportedEncodingException {
        String s = null;
        String encode = Rfc5987Util.encode(s);
        String encoding = null;
        String encode1 = Rfc5987Util.encode(s, encoding);
        String decode = Rfc5987Util.decode(s, encoding);
    }
}
