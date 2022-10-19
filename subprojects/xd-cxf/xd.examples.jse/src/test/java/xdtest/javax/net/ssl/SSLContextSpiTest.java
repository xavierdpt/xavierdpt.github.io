package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.SSLContextSpi;

public class SSLContextSpiTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            SSLContextSpi instance = TestUtils.makeInstance(SSLContextSpi.class);
        }
    }
}
