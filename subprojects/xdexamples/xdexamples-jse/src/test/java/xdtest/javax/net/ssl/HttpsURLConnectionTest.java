package xdtest.javax.net.ssl;

import net.xdexamples.support.internal.BaseExample;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Optional;

public class HttpsURLConnectionTest extends BaseExample<HttpsURLConnection> {

    @Override
    protected void scaffold(HttpsURLConnection instance) throws Throwable {
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
