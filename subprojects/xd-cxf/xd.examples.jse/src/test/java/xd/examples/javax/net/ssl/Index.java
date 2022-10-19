package xd.examples.javax.net.ssl;

import javax.net.ssl.CertPathTrustManagerParameters;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.KeyStoreBuilderParameters;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLPermission;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.StandardConstants;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.TrustManagerFactorySpi;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

import java.net.HttpURLConnection;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    CertPathTrustManagerParameters.class,
                    ExtendedSSLSession.class,
                    HandshakeCompletedEvent.class,
                    HandshakeCompletedListener.class,
                    HostnameVerifier.class,
                    HttpURLConnection.class,
                    KeyManager.class,
                    KeyManagerFactory.class,
                    KeyManagerFactorySpi.class,
                    KeyStoreBuilderParameters.class,
                    ManagerFactoryParameters.class,
                    SNIHostName.class,
                    SNIMatcher.class,
                    SNIServerName.class,
                    SSLContext.class,
                    SSLContextSpi.class,
                    SSLEngine.class,
                    SSLEngineResult.class,
                    SSLException.class,
                    SSLHandshakeException.class,
                    SSLKeyException.class,
                    SSLParameters.class,
                    SSLPeerUnverifiedException.class,
                    SSLPermission.class,
                    SSLProtocolException.class,
                    SSLServerSocket.class,
                    SSLServerSocketFactory.class,
                    SSLSession.class,
                    SSLSessionBindingEvent.class,
                    SSLSessionBindingListener.class,
                    SSLSessionContext.class,
                    SSLSocket.class,
                    SSLSocketFactory.class,
                    StandardConstants.class,
                    TrustManager.class,
                    TrustManagerFactory.class,
                    TrustManagerFactorySpi.class,
                    X509ExtendedKeyManager.class,
                    X509ExtendedTrustManager.class,
                    X509KeyManager.class,
                    X509TrustManager.class
            ));
        }
    }
}
