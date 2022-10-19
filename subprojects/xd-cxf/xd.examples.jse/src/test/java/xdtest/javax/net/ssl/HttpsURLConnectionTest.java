package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Optional;

public class HttpsURLConnectionTest {
    @Test
    public void test() throws SSLPeerUnverifiedException {
        if (TestUtils.scaffold()) {
            HttpsURLConnection instance = TestUtils.makeInstance(HttpsURLConnection.class);
            String cipherSuite = instance.getCipherSuite();
            Certificate[] localCertificates = instance.getLocalCertificates();
            Certificate[] serverCertificates = instance.getServerCertificates();
            Principal peerPrincipal = instance.getPeerPrincipal();
            Principal localPrincipal = instance.getLocalPrincipal();
            HostnameVerifier verifier = null;
            HttpsURLConnection.setDefaultHostnameVerifier(verifier);
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            instance.setHostnameVerifier(verifier);
            HostnameVerifier hostnameVerifier = instance.getHostnameVerifier();
            SSLSocketFactory sslSocketFactory = null;
            HttpsURLConnection.setDefaultSSLSocketFactory(sslSocketFactory);
            SSLSocketFactory defaultSSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
            instance.setSSLSocketFactory(sslSocketFactory);
            SSLSocketFactory sslSocketFactory1 = instance.getSSLSocketFactory();
            Optional<SSLSession> sslSession = instance.getSSLSession();
        }
    }
}
