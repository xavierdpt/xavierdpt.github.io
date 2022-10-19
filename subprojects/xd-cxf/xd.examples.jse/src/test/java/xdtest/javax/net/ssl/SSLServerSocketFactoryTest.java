package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;

public class SSLServerSocketFactoryTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            SSLServerSocketFactory instance = TestUtils.makeInstance(SSLServerSocketFactory.class);
            ServerSocketFactory aDefault = instance.getDefault();
            String[] defaultCipherSuites = instance.getDefaultCipherSuites();
            String[] supportedCipherSuites = instance.getSupportedCipherSuites();

        }
    }
}
