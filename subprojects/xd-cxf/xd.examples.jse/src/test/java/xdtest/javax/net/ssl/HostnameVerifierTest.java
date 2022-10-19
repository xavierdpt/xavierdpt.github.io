package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class HostnameVerifierTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            HostnameVerifier instance = TestUtils.makeInstance(HostnameVerifier.class);
            String hostname = null;
            SSLSession session = null;
            boolean verify = instance.verify(hostname, session);
        }
    }
}
