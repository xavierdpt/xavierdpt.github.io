package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.SSLException;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class X509TrustManagerTest {
    @Test
    public void test() throws SSLException, CertificateException {
        if (TestUtils.scaffold()) {
            X509TrustManager instance = TestUtils.makeInstance(X509TrustManager.class);
            X509Certificate[] chain = new X509Certificate[0];
            String authType = null;
            instance.checkServerTrusted(chain,authType);
            instance.checkClientTrusted(chain,authType);
            X509Certificate[] acceptedIssuers = instance.getAcceptedIssuers();
        }
    }
}
