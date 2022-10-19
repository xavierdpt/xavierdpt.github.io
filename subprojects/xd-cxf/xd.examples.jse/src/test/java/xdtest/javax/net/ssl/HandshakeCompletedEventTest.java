package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.security.Principal;
import java.security.cert.Certificate;

public class HandshakeCompletedEventTest {
    @Test
    public void test() throws SSLPeerUnverifiedException {
        if (TestUtils.scaffold()) {
            SSLSocket socket = null;
            SSLSession session = null;
            HandshakeCompletedEvent instance = new HandshakeCompletedEvent(socket, session);
            SSLSession session1 = instance.getSession();
            String cipherSuite = instance.getCipherSuite();
            Certificate[] localCertificates = instance.getLocalCertificates();
            Certificate[] peerCertificates = instance.getPeerCertificates();
            Principal peerPrincipal = instance.getPeerPrincipal();
            Principal localPrincipal = instance.getLocalPrincipal();
            SSLSocket socket1 = instance.getSocket();

        }
    }
}
