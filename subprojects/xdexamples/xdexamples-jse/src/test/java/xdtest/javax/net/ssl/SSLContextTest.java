package xdtest.javax.net.ssl;

import net.xdexamples.BaseExample;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.security.Provider;
import java.security.SecureRandom;

public class SSLContextTest extends BaseExample<SSLContext> {

    @Override
    protected void scaffold(SSLContext instance) throws Throwable {
        SSLContext.setDefault(instance);
        String protocol = null;
        String providerName = null;
        SSLContext.getInstance(protocol, providerName);
        Provider provider = null;
        SSLContext.getInstance(protocol, provider);
        SSLContext.getInstance(protocol);

        String protocol1 = instance.getProtocol();
        Provider provider1 = instance.getProvider();
        KeyManager[] km = new KeyManager[0];
        TrustManager[] tm = new TrustManager[0];
        SecureRandom random = null;
        instance.init(km, tm, random);
        SSLSocketFactory socketFactory = instance.getSocketFactory();
        SSLServerSocketFactory serverSocketFactory = instance.getServerSocketFactory();
        SSLEngine sslEngine = instance.createSSLEngine();
        String peerHost = null;
        int peerPort = 0;
        instance.createSSLEngine(peerHost, peerPort);

        SSLSessionContext serverSessionContext = instance.getServerSessionContext();

        SSLSessionContext clientSessionContext = instance.getClientSessionContext();

        SSLParameters defaultSSLParameters = instance.getDefaultSSLParameters();

        SSLParameters supportedSSLParameters = instance.getSupportedSSLParameters();

    }
}
