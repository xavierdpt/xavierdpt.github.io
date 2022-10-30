package xdtest.javax.net.ssl;

import net.xdexamples.BaseExample;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

public class HandshakeCompletedListenerTest extends BaseExample<HandshakeCompletedListener> {

    @Override
    protected void scaffold(HandshakeCompletedListener instance) throws Throwable {
        HandshakeCompletedEvent event = null;
        instance.handshakeCompleted(event);
    }
}
