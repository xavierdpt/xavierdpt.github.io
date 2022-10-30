package net.xdexamples.jse.examples.java.net;

import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.ExampleUtils;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import static org.junit.Assert.assertEquals;

public class InterfaceAddressExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            InterfaceAddress instance = ExampleUtils.makeInstance(InterfaceAddress.class);
            InetAddress address = instance.getAddress();
            InetAddress broadcast = instance.getBroadcast();
            short networkPrefixLength = instance.getNetworkPrefixLength();
            String s = instance.toString();
        }
    }

    @Test
    public void lookForLocalhost() throws SocketException {
        InterfaceAddress example = null;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        top:
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                if ("127.0.0.1".equals(interfaceAddress.getAddress().getHostAddress())) {
                    example = interfaceAddress;
                    break top;
                }
            }
        }
        Assert.assertNotNull(example);
        assertEquals("127.0.0.1", example.getAddress().getHostAddress());
        assertEquals("127.255.255.255", example.getBroadcast().getHostAddress());
        assertEquals(8, example.getNetworkPrefixLength());
    }


    @Deprecated // to move somewhere else
    public static void describe(InterfaceAddress interfaceAddress) {
        InetAddress address = interfaceAddress.getAddress();
        short networkPrefixLength = interfaceAddress.getNetworkPrefixLength();
        System.out.println("Network prefix length: " + networkPrefixLength);
        System.out.println("- Address");
        InetAddress broadcast = interfaceAddress.getBroadcast();
        System.out.println("- Broadcast");


    }
}
