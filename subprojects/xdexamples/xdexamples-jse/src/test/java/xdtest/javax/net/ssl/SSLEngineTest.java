package xdtest.javax.net.ssl;

import net.xdexamples.BaseExample;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.BiFunction;

public class SSLEngineTest extends BaseExample<SSLEngine> {

    @Override
    protected void scaffold(SSLEngine instance) throws Throwable {
        String peerHost = instance.getPeerHost();
        int peerPort = instance.getPeerPort();
        ByteBuffer src = null;
        ByteBuffer dst = null;
        SSLEngineResult wrap = instance.wrap(src, dst);
        ByteBuffer[] srcs = new ByteBuffer[0];
        SSLEngineResult wrap1 = instance.wrap(srcs, dst);
        int offset = 0;
        int length = 0;
        SSLEngineResult wrap2 = instance.wrap(srcs, offset, length, dst);

        SSLEngineResult unwrap = instance.unwrap(src, dst);
        ByteBuffer[] dsts = new ByteBuffer[0];
        SSLEngineResult unwrap1 = instance.unwrap(src, dsts);
        SSLEngineResult unwrap2 = instance.unwrap(src, dsts, offset, length);

        Runnable delegatedTask = instance.getDelegatedTask();

        instance.closeInbound();
        boolean inboundDone = instance.isInboundDone();

        instance.closeOutbound();
        boolean outboundDone = instance.isOutboundDone();

        String[] supportedCipherSuites = instance.getSupportedCipherSuites();
        String[] enabledCipherSuites = instance.getEnabledCipherSuites();
        String[] suites = new String[0];
        instance.setEnabledCipherSuites(suites);

        String[] supportedProtocols = instance.getSupportedProtocols();
        String[] enabledProtocols = instance.getEnabledProtocols();
        String[] protocols = new String[0];
        instance.setEnabledProtocols(protocols);
        SSLSession session = instance.getSession();
        SSLSession handshakeSession = instance.getHandshakeSession();
        instance.beginHandshake();
        SSLEngineResult.HandshakeStatus handshakeStatus = instance.getHandshakeStatus();
        boolean mode = false;
        instance.setUseClientMode(mode);
        boolean useClientMode = instance.getUseClientMode();
        boolean need = false;
        instance.setNeedClientAuth(need);
        boolean needClientAuth = instance.getNeedClientAuth();
        boolean want = false;
        instance.setWantClientAuth(want);
        boolean wantClientAuth = instance.getWantClientAuth();
        boolean flag = false;
        instance.setEnableSessionCreation(flag);
        boolean enableSessionCreation = instance.getEnableSessionCreation();
        SSLParameters sslParameters = instance.getSSLParameters();
        instance.setSSLParameters(sslParameters);
        String applicationProtocol = instance.getApplicationProtocol();
        String handshakeApplicationProtocol = instance.getHandshakeApplicationProtocol();
        BiFunction<SSLEngine, List<String>, String> selector = null;
        instance.setHandshakeApplicationProtocolSelector(selector);
        BiFunction<SSLEngine, List<String>, String> handshakeApplicationProtocolSelector = instance.getHandshakeApplicationProtocolSelector();

    }
}
