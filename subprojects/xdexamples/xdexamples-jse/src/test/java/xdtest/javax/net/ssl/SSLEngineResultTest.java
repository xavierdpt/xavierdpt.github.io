package xdtest.javax.net.ssl;

import net.xdexamples.BaseExample;

import javax.net.ssl.SSLEngineResult;

public class SSLEngineResultTest extends BaseExample<SSLEngineResult> {

    @Override
    protected void scaffold(SSLEngineResult instance) throws Throwable {
        SSLEngineResult.Status status = null;
        SSLEngineResult.HandshakeStatus handshakeStatus = null;
        int bytesConsumed = 0;
        int bytesProduced = 0;
        SSLEngineResult instance2 = new SSLEngineResult(status, handshakeStatus, bytesConsumed, bytesProduced);
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
