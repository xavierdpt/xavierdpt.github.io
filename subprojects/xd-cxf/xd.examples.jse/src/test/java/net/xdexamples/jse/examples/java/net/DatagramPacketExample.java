package net.xdexamples.jse.examples.java.net;

import org.junit.Test;
import net.xdexamples.ExampleUtils;
import net.xdexamples.Done;

import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Done
public class DatagramPacketExample {
    public void scaffold() {
        if (ExampleUtils.skip()) {
            DatagramPacket instance = ExampleUtils.makeInstance(DatagramPacket.class);

            byte[] buffer = new byte[0];
            int offset = 0;
            int length = 0;
            int port = 0;
            InetAddress inetAddress = null;
            SocketAddress socketAddress = null;

            DatagramPacket datagramPacket = new DatagramPacket(buffer, offset, length);
            DatagramPacket datagramPacket1 = new DatagramPacket(buffer, length);
            DatagramPacket datagramPacket2 = new DatagramPacket(buffer, offset, length, inetAddress, port);
            DatagramPacket datagramPacket3 = new DatagramPacket(buffer, offset, length, socketAddress);
            DatagramPacket datagramPacket4 = new DatagramPacket(buffer, length, inetAddress, port);
            DatagramPacket datagramPacket5 = new DatagramPacket(buffer, length, socketAddress);

            InetAddress address = instance.getAddress();
            int port1 = instance.getPort();
            byte[] data = instance.getData();
            int offset1 = instance.getOffset();
            int length1 = instance.getLength();
            instance.setData(buffer);
            instance.setData(buffer, offset, length);
            instance.setAddress(inetAddress);
            instance.setPort(port);
            instance.setSocketAddress(socketAddress);
            SocketAddress socketAddress1 = instance.getSocketAddress();
            instance.setLength(length);
        }
    }

    @Test
    public void example() {
        byte[] buffer = new byte[]{1, 2};
        int length = buffer.length;
        InetAddress address = Inet4Address.getLoopbackAddress();
        int port = 2000;
        DatagramPacket datagramPacket = new DatagramPacket(buffer, length, address, port);
        InetAddress dInetAddress = datagramPacket.getAddress();
        int dPort = datagramPacket.getPort();
        SocketAddress dSocketAddress = datagramPacket.getSocketAddress();
        byte[] dData = datagramPacket.getData();
        int dLength = datagramPacket.getLength();
        int dOffset = datagramPacket.getOffset();

        assertEquals(port, dPort);
        assertEquals(length, dLength);
        assertEquals(0, dOffset);
        assertEquals((byte) 1, dData[0]);
        assertEquals((byte) 2, dData[1]);
        assertEquals(address, dInetAddress);

        assertTrue(dSocketAddress instanceof InetSocketAddress);
        InetSocketAddress dInetSocketAddress = (InetSocketAddress) dSocketAddress;
        assertEquals(address, dInetSocketAddress.getAddress());
        assertEquals(port, dInetSocketAddress.getPort());
        assertEquals(address.getHostAddress(), dInetSocketAddress.getHostName());

    }
}
