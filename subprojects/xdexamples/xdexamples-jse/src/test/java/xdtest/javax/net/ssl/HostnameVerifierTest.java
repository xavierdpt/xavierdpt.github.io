package xdtest.javax.net.ssl;

import net.xdexamples.support.internal.BaseExample;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class HostnameVerifierTest extends BaseExample<HostnameVerifier> {

    @Override
    protected void scaffold(HostnameVerifier instance) throws Throwable {
        String hostname = null;
        SSLSession session = null;
        boolean verify = instance.verify(hostname, session);
    }
}
