package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.CertPathTrustManagerParameters;
import java.security.cert.CertPathParameters;

public class CertPathTrustManagerParametersTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            CertPathParameters parameters = null;
            CertPathTrustManagerParameters instance = new CertPathTrustManagerParameters(parameters);
            CertPathParameters parameters1 = instance.getParameters();
        }

    }
}
