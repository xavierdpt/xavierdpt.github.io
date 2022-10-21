package net.xdexamples.jse.examples.java.net;

import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ToBeContinued
public class ProxySelectorExample {

    public void scaffold() throws SocketException {
        if (ExampleUtils.skip()) {
            ProxySelector instance = ExampleUtils.makeInstance(ProxySelector.class);
            ProxySelector.getDefault();
            ProxySelector proxySelector = null;
            ProxySelector.setDefault(proxySelector);
            URI uri = null;
            List<Proxy> proxies = instance.select(uri);
            SocketAddress socketAddress = null;
            IOException exception = null;
            instance.connectFailed(uri, socketAddress, exception);
            InetSocketAddress proxyAddress = null;
            ProxySelector selector = ProxySelector.of(proxyAddress);
        }
    }

    @Test
    public void defaultSelectorNoProxy() throws URISyntaxException {
        ProxySelector defaultProxySelector = ProxySelector.getDefault();
        Assert.assertNotNull(defaultProxySelector);
        URI uri = new URI("http://localhost");
        List<Proxy> proxies = defaultProxySelector.select(uri);
        assertEquals(1, proxies.size());
        assertEquals(Proxy.NO_PROXY, proxies.get(0));


    }

}
