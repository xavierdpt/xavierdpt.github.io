package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

public class HandshakeCompletedListenerTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            HandshakeCompletedListener instance = TestUtils.makeInstance(HandshakeCompletedListener.class);
            HandshakeCompletedEvent event = null;
            instance.handshakeCompleted(event);
        }
    }
}
