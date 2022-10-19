package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SNIServerName;
import java.util.List;

public class ExtendedSSLSessionTest {
    @Test public void test() {
        if (TestUtils.scaffold()) {
            ExtendedSSLSession instance = TestUtils.makeInstance(ExtendedSSLSession.class);
            String[] localSupportedSignatureAlgorithms = instance.getLocalSupportedSignatureAlgorithms();
            String[] peerSupportedSignatureAlgorithms = instance.getPeerSupportedSignatureAlgorithms();
            List<SNIServerName> requestedServerNames = instance.getRequestedServerNames();
            List<byte[]> statusResponses = instance.getStatusResponses();
        }
    }
}
