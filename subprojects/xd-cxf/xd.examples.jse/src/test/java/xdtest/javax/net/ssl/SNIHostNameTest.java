package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;

public class SNIHostNameTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            String hostname = null;
            SNIHostName instance = new SNIHostName(hostname);
            byte[] encoded = new byte[0];
            SNIHostName sniHostName = new SNIHostName(encoded);
            String asciiName = instance.getAsciiName();
            String s = instance.toString();
            String regex = null;
            SNIMatcher sniMatcher = SNIHostName.createSNIMatcher(regex);

        }
    }
}
