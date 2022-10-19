package xd.examples.java.net;

import org.junit.Assert;
import org.junit.Test;
import xd.ExampleUtils;
import xdtest.TestUtils;
import xdtest.ToBeContinued;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@ToBeContinued
public class Inet6AddressExample {

    public void scaffold() throws UnknownHostException {
        if (ExampleUtils.skip()) {
            Inet6Address instance = ExampleUtils.makeInstance(Inet6Address.class);
            byte[] addr = new byte[0];
            String host = null;
            NetworkInterface networkInterface = null;
            Inet6Address byAddress = Inet6Address.getByAddress(host, addr, networkInterface);
            int scopeId = 0;
            Inet6Address byAddress1 = Inet6Address.getByAddress(host, addr, scopeId);

            boolean multicastAddress = instance.isMulticastAddress();
            boolean anyLocalAddress = instance.isAnyLocalAddress();
            boolean loopbackAddress = instance.isLoopbackAddress();
            boolean linkLocalAddress = instance.isLinkLocalAddress();
            boolean siteLocalAddress = instance.isSiteLocalAddress();
            boolean mcGlobal = instance.isMCGlobal();
            boolean mcNodeLocal = instance.isMCNodeLocal();
            boolean mcLinkLocal = instance.isMCLinkLocal();
            boolean mcSiteLocal = instance.isMCSiteLocal();
            boolean mcOrgLocal = instance.isMCOrgLocal();
            byte[] address = instance.getAddress();
            int scopeId1 = instance.getScopeId();
            NetworkInterface scopedInterface = instance.getScopedInterface();
            String hostAddress = instance.getHostAddress();
            boolean iPv4CompatibleAddress = instance.isIPv4CompatibleAddress();
        }
    }

    @Test
    public void example() {
        // Warning: some static methods still returns Inet4Address
        InetAddress loopback = Inet6Address.getLoopbackAddress();
        assertTrue(loopback instanceof Inet4Address);
        assertFalse(loopback instanceof Inet6Address);
    }
}
