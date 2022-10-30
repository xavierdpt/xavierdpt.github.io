package net.xdexamples.jse.examples.java.net;

import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.net.Inet4Address;
import java.net.InetAddress;

@ToBeContinued
public class Inet4AddressExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            Inet4Address instance = ExampleUtils.makeInstance(Inet4Address.class);
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
            String hostAddress = instance.getHostAddress();
        }
    }

    @Test
    public void example() {
        InetAddress a = InetAddress.getLoopbackAddress();
        Assert.assertTrue(a instanceof Inet4Address);
        // See InetAddressExample::loopback
    }


}
