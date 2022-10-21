package net.xdexamples.jse.examples.java.net;

import org.junit.Test;
import net.xdexamples.ExampleUtils;
import net.xdexamples.Done;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@Done
public class ProxyExample {

    public void scaffold() throws SocketException {
        if (ExampleUtils.skip()) {
            // holds info for a proxy, but does not have magical proxy powers
            Proxy instance = ExampleUtils.makeInstance(Proxy.class);
            Proxy.Type type = null;
            SocketAddress socketAddress = null;
            new Proxy(type, socketAddress);
            Proxy.Type type2 = instance.type();
            SocketAddress address = instance.address();
            String s = instance.toString();
            Proxy noProxy = Proxy.NO_PROXY;

        }
    }

    @Test
    public void noProxy() {
        Proxy proxy = Proxy.NO_PROXY;
        assertEquals(Proxy.Type.DIRECT, proxy.type());
        assertNull(proxy.address());
        assertEquals("DIRECT", proxy.toString());
    }

    @Test
    public void socks() {
        InetSocketAddress proxyAddress = InetSocketAddress.createUnresolved("example", 2222);
        Proxy proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);
        assertEquals(Proxy.Type.SOCKS, proxy.type());
        assertEquals(proxyAddress, proxy.address());
        assertEquals("SOCKS @ " + proxyAddress, proxy.toString());
    }

    @Test
    public void http() {
        InetSocketAddress proxyAddress = InetSocketAddress.createUnresolved("example", 2222);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddress);
        assertEquals(Proxy.Type.HTTP, proxy.type());
        assertEquals(proxyAddress, proxy.address());
        assertEquals("HTTP @ " + proxyAddress, proxy.toString());
    }

}
