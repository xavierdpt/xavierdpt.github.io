package xdtest.javax.net.ssl;

import net.xdexamples.BaseExample;

import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SNIServerName;
import java.util.List;

public class ExtendedSSLSessionTest extends BaseExample<ExtendedSSLSession> {

    @Override
    protected void scaffold(ExtendedSSLSession instance) {
        String[] localSupportedSignatureAlgorithms = instance.getLocalSupportedSignatureAlgorithms();
        String[] peerSupportedSignatureAlgorithms = instance.getPeerSupportedSignatureAlgorithms();
        List<SNIServerName> requestedServerNames = instance.getRequestedServerNames();
        List<byte[]> statusResponses = instance.getStatusResponses();
    }
}
