package xdtest.javax.net.ssl;

import net.xdexamples.BaseExample;
import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;

public class SSLServerSocketFactoryTest extends BaseExample<SSLServerSocketFactory> {

    @Override
    protected void scaffold(SSLServerSocketFactory instance) throws Throwable {
        ServerSocketFactory aDefault = instance.getDefault();
        String[] defaultCipherSuites = instance.getDefaultCipherSuites();
        String[] supportedCipherSuites = instance.getSupportedCipherSuites();
    }
}
