package xd.examples.java.net;

import org.junit.Test;
import xd.ExampleUtils;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class InetSocketAddressExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            int port = 0;
            InetSocketAddress instance = new InetSocketAddress(port);
            InetAddress addr = null;
            InetSocketAddress inetSocketAddress = new InetSocketAddress(addr, port);
            String hostname = null;
            InetSocketAddress inetSocketAddress1 = new InetSocketAddress(hostname, port);

            String host = null;
            InetSocketAddress unresolved = InetSocketAddress.createUnresolved(host, port);

            int port1 = instance.getPort();
            InetAddress address = instance.getAddress();
            String hostName = instance.getHostName();
            String hostString = instance.getHostString();
            boolean unresolved1 = instance.isUnresolved();
            String s = instance.toString();
        }
    }

    @Test
    public void unresolved() {
        InetSocketAddress a = InetSocketAddress.createUnresolved("example", 2222);
        assertTrue(a.isUnresolved());
        assertNull(a.getAddress());
        assertEquals(2222, a.getPort());
        assertEquals("example", a.getHostName());
        assertEquals("example", a.getHostString());
        assertEquals("example/<unresolved>:2222", a.toString());
    }

    @Test
    public void portOnly() {
        InetSocketAddress a = new InetSocketAddress(2222);
        assertFalse(a.isUnresolved());
        assertNotNull(a.getAddress());
        assertEquals(2222, a.getPort());
        assertEquals("0.0.0.0", a.getHostName());
        assertEquals("0.0.0.0", a.getHostString());
        assertEquals("0.0.0.0/0.0.0.0:2222", a.toString());
    }

    @Test
    public void hostAndPort() {
        InetSocketAddress a = new InetSocketAddress("localhost", 2222);
        assertFalse(a.isUnresolved());
        assertNotNull(a.getAddress());
        assertEquals(2222, a.getPort());
        assertEquals("localhost", a.getHostName());
        assertEquals("localhost", a.getHostString());
        assertEquals("localhost/127.0.0.1:2222", a.toString());
    }

}
