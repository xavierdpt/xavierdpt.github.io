package net.xdexamples.jse.examples.java.net;

import org.junit.Test;
import net.xdexamples.ExampleUtils;
import xdtest.SeeAlso;
import xdtest.ToBeContinued;
import xdtools.java.net.NetworkInterfaceDumper;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Stream;

@SeeAlso({NetworkInterfaceDumper.class})
@ToBeContinued
public class NetworkInterfaceExample {

    public void scaffold() throws SocketException {
        if (ExampleUtils.skip()) {
            NetworkInterface instance = ExampleUtils.makeInstance(NetworkInterface.class);
            String name = instance.getName();
            Enumeration<InetAddress> inetAddresses = instance.getInetAddresses();
            Stream<InetAddress> inetAddressStream = instance.inetAddresses();
            List<InterfaceAddress> interfaceAddresses = instance.getInterfaceAddresses();
            Enumeration<NetworkInterface> subInterfaces = instance.getSubInterfaces();
            Stream<NetworkInterface> networkInterfaceStream = instance.subInterfaces();
            NetworkInterface parent = instance.getParent();
            int index = instance.getIndex();
            String displayName = instance.getDisplayName();
            NetworkInterface byName = NetworkInterface.getByName(name);
            NetworkInterface byIndex = NetworkInterface.getByIndex(index);
            InetAddress inetAddress = null;
            NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(inetAddress);
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            Stream<NetworkInterface> networkInterfaceStream1 = NetworkInterface.networkInterfaces();
            boolean up = instance.isUp();
            boolean loopback = instance.isLoopback();
            boolean pointToPoint = instance.isPointToPoint();
            boolean b = instance.supportsMulticast();
            byte[] hardwareAddress = instance.getHardwareAddress();
            int mtu = instance.getMTU();
            boolean virtual = instance.isVirtual();
            String s = instance.toString();
        }
    }

    @Test
    public void example() throws IOException, ParserConfigurationException, TransformerException {
        // Dump only interfaces which are up
        NetworkInterfaceDumper.main(new String[]{"-up"});
    }

}
