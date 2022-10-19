package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;

public class SSLEngineResultTest {
    @Test
    public void test() throws SSLException {
        if (TestUtils.scaffold()) {
            SSLEngineResult.Status status = null;
            SSLEngineResult.HandshakeStatus handshakeStatus = null;
            int bytesConsumed = 0;
            int bytesProduced = 0;
            SSLEngineResult instance = new SSLEngineResult(status, handshakeStatus, bytesConsumed, bytesProduced);
            long sequenceNumber = 0;
            SSLEngineResult sslEngineResult = new SSLEngineResult(status, handshakeStatus, bytesConsumed, bytesProduced, sequenceNumber);

            SSLEngineResult.Status status1 = instance.getStatus();
            SSLEngineResult.HandshakeStatus handshakeStatus1 = instance.getHandshakeStatus();
            int i = instance.bytesConsumed();
            int i1 = instance.bytesProduced();
            long l = instance.sequenceNumber();
            String s = instance.toString();

        }
    }

}
