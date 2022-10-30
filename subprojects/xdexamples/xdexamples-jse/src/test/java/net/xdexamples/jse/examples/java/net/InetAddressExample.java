package net.xdexamples.jse.examples.java.net;

import org.junit.Test;
import net.xdexamples.ExampleUtils;
import xdtest.TestUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@ToBeContinued
public class InetAddressExample {

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            InetAddress instance = TestUtils.makeInstance(InetAddress.class);

            // Todo
            byte[] addr = new byte[0];
            InetAddress byAddress = InetAddress.getByAddress(addr);

            // Todo
            String host = null;
            InetAddress byAddress1 = InetAddress.getByAddress(host, addr);

            // Todo
            InetAddress byName = InetAddress.getByName(host);

            // Todo
            InetAddress[] allByName = InetAddress.getAllByName(host);

            // Done
            InetAddress localHost = InetAddress.getLocalHost();

            // Done
            InetAddress loopbackAddress1 = InetAddress.getLoopbackAddress();

            // Partially done
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

            // Todo
            int timeout = 0;
            boolean reachable = instance.isReachable(timeout);

            // Todo
            NetworkInterface networkInterface = null;
            int ttl = 0;
            boolean reachable1 = instance.isReachable(networkInterface, ttl, timeout);

            // Partially done
            // These two use the hidden builting resolver which will use the network and induce timeouts
            // It is statically initialized here java.net.InetAddress.createBuiltinInetAddressResolver
            // to HostsFileResolver when jdk.net.hosts.file is set or to PlatformResolver
            // Most of it is hidden and cannot be changed afterwards without reflection, which is a shame.
            String hostName = instance.getHostName();
            String canonicalHostName = instance.getCanonicalHostName();

            // Partially done
            byte[] address = instance.getAddress();
            String hostAddress = instance.getHostAddress();
            String s = instance.toString();
        }
    }

    @Test
    public void loopback() {
        InetAddress a = InetAddress.getLoopbackAddress();

        assertEquals("localhost", a.getHostName());
        assertEquals("127.0.0.1", a.getCanonicalHostName());
        assertEquals("7F 00 00 01", ExampleUtils.bytesToHex(a.getAddress()));
        assertEquals("127.0.0.1", a.getHostAddress());
        assertEquals("localhost/127.0.0.1", a.toString());

        assertTrue(a.isLoopbackAddress());

        assertFalse(a.isMulticastAddress());
        assertFalse(a.isAnyLocalAddress());
        assertFalse(a.isLinkLocalAddress());
        assertFalse(a.isSiteLocalAddress());
        assertFalse(a.isMCGlobal());
        assertFalse(a.isMCNodeLocal());
        assertFalse(a.isMCLinkLocal());
        assertFalse(a.isMCSiteLocal());
        assertFalse(a.isMCOrgLocal());
    }

    @Test
    public void localhost() throws UnknownHostException {
        InetAddress a = InetAddress.getLocalHost();

        String hostName = a.getHostName();
        String hostAddress = a.getHostAddress();

        // hostname and host address are derived form the system and are probably not localhost/127.0.0.1
        assertNotEquals("localhost", hostName);
        assertNotEquals("127.0.0.1", hostAddress);

        // .lan suffix
        assertEquals(hostName + ".lan", a.getCanonicalHostName());

        assertNotEquals("7F 00 00 01", ExampleUtils.bytesToHex(a.getAddress()));
        assertEquals(hostName + "/" + hostAddress, a.toString());

        // RFC 1918
        assertTrue(a.isSiteLocalAddress());

        assertFalse(a.isLoopbackAddress());
        assertFalse(a.isMulticastAddress());
        assertFalse(a.isAnyLocalAddress());
        assertFalse(a.isLinkLocalAddress());
        assertFalse(a.isMCGlobal());
        assertFalse(a.isMCNodeLocal());
        assertFalse(a.isMCLinkLocal());
        assertFalse(a.isMCSiteLocal());
        assertFalse(a.isMCOrgLocal());
    }

}
