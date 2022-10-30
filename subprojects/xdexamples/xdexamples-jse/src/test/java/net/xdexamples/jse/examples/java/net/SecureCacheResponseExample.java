package net.xdexamples.jse.examples.java.net;

import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.SecureCacheResponse;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Optional;

@ToBeContinued
public class SecureCacheResponseExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            SecureCacheResponse instance = ExampleUtils.makeInstance(SecureCacheResponse.class);
            String cipherSuite = instance.getCipherSuite();
            List<Certificate> localCertificateChain = instance.getLocalCertificateChain();
            List<Certificate> serverCertificateChain = instance.getServerCertificateChain();
            Principal peerPrincipal = instance.getPeerPrincipal();
            Principal localPrincipal = instance.getLocalPrincipal();
            Optional<SSLSession> sslSession = instance.getSSLSession();
        }
    }
}
