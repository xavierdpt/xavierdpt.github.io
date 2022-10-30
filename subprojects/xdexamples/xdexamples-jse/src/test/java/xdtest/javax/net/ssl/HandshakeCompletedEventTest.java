package xdtest.javax.net.ssl;

import net.xdexamples.BaseExample;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.security.Principal;
import java.security.cert.Certificate;

public class HandshakeCompletedEventTest extends BaseExample<HandshakeCompletedEvent> {

    @Override
    protected void scaffold(HandshakeCompletedEvent instance) throws Throwable {
        SSLSocket sock = any();
        SSLSession session = any();
        new HandshakeCompletedEvent(sock, session);
        SSLSession session1 = instance.getSession();
        String cipherSuite = instance.getCipherSuite();
        Certificate[] localCertificates = instance.getLocalCertificates();
        Certificate[] peerCertificates = instance.getPeerCertificates();
        Principal peerPrincipal = instance.getPeerPrincipal();
        Principal localPrincipal = instance.getLocalPrincipal();
        SSLSocket socket1 = instance.getSocket();
    }
}
