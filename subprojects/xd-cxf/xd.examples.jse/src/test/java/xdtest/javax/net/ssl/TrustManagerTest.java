package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;

public class TrustManagerTest {
    @Test
    public void test() throws SSLException {
        if (TestUtils.scaffold()) {
            TrustManager instance = new TrustManager() {
            };

        }
    }
}
