package net.xdexamples.jse.examples.java.net;

import org.junit.Test;
import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketOption;
import java.nio.channels.DatagramChannel;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

@ToBeContinued
public class DatagramSocketExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            DatagramSocket instance = ExampleUtils.makeInstance(DatagramSocket.class);

            DatagramSocket datagramSocket = new DatagramSocket();

            SocketAddress socketAddress = null;
            DatagramSocket datagramSocket1 = new DatagramSocket(socketAddress);
            int port = 0;
            DatagramSocket datagramSocket2 = new DatagramSocket(port);
            InetAddress inetAddress = null;
            DatagramSocket datagramSocket3 = new DatagramSocket(port, inetAddress);

            instance.bind(socketAddress);
            instance.connect(inetAddress, port);
            instance.connect(socketAddress);
            instance.disconnect();

            boolean bound = instance.isBound();
            boolean connected = instance.isConnected();

            InetAddress inetAddress1 = instance.getInetAddress();

            int port1 = instance.getPort();

            SocketAddress remoteSocketAddress = instance.getRemoteSocketAddress();
            SocketAddress localSocketAddress = instance.getLocalSocketAddress();

            DatagramPacket packet = null;
            instance.send(packet);

            instance.receive(packet);

            InetAddress localAddress = instance.getLocalAddress();
            int localPort = instance.getLocalPort();

            int timeout = 0;
            instance.setSoTimeout(timeout);
            int soTimeout = instance.getSoTimeout();
            int size = 0;
            instance.setSendBufferSize(size);
            int sendBufferSize = instance.getSendBufferSize();
            instance.setReceiveBufferSize(size);
            int receiveBufferSize = instance.getReceiveBufferSize();
            boolean on = false;
            instance.setReuseAddress(on);
            boolean reuseAddress = instance.getReuseAddress();
            instance.setBroadcast(on);
            boolean broadcast = instance.getBroadcast();
            int tc = 0;
            instance.setTrafficClass(tc);
            int trafficClass = instance.getTrafficClass();
            instance.close();
            boolean closed = instance.isClosed();
            DatagramChannel channel = instance.getChannel();
            SocketOption<Dummy> name = null;
            Dummy value = null;
            instance.setOption(name, value);
            Dummy option = instance.getOption(name);
            Set<SocketOption<?>> socketOptions = instance.supportedOptions();
            NetworkInterface networkInterface = null;
            instance.joinGroup(socketAddress, networkInterface);
            instance.leaveGroup(socketAddress, networkInterface);
        }
    }

    @Test
    public void options() throws SocketException {
        /*-
            boolean
            SO_BROADCAST, SO_REUSEADDR, IP_MULTICAST_LOOP

            int
            SO_SNDBUF, IP_TOS, SO_RCVBUF,  IP_MULTICAST_TTL

            java.net.NetworkInterface:
            IP_MULTICAST_IF
         */
        try (DatagramSocket socket = new DatagramSocket()) {
            for (SocketOption<?> option : socket.supportedOptions()) {
                System.out.println(option.name());
                System.out.println(option.type().getName());
            }
            System.out.println("Bound: " + socket.isBound());
            System.out.println("Connected: " + socket.isConnected());
            System.out.println("Closed: " + socket.isClosed());
            System.out.println("Broadcast: " + socket.getBroadcast());
            System.out.println("ReuseAddress: " + socket.getReuseAddress());
            System.out.println("Timeout: " + socket.getSoTimeout());
            System.out.println("ReceiveBufferSize: " + socket.getReceiveBufferSize());
            System.out.println("SendBufferSize: " + socket.getSendBufferSize());
            System.out.println("Port: " + socket.getPort());
            System.out.println("LocalPort: " + socket.getLocalPort());
        }
    }

    @Test
    public void twoSockets() {
        CountDownLatch cdl = new CountDownLatch(2);

        Thread thread1 = new Thread(() -> {
            try {
                try (DatagramSocket socket = new DatagramSocket(40001, Inet4Address.getLoopbackAddress())) {
                    socket.connect(Inet4Address.getLoopbackAddress(), 40002);
                    socket.send(new DatagramPacket(new byte[]{5}, 1));
                    DatagramPacket packet = new DatagramPacket(new byte[1], 1);
                    socket.receive(packet);
                    System.out.println("Seems fine 1");
                    System.out.println(packet.getData()[0]);
                }
            } catch (IOException e) {
                System.out.println(e.getClass().getName() + ": " + e.getMessage());
            } finally {
                cdl.countDown();
            }

        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                try (DatagramSocket socket = new DatagramSocket(40002, Inet4Address.getLoopbackAddress())) {
                    socket.connect(Inet4Address.getLoopbackAddress(), 40001);
                    DatagramPacket packet = new DatagramPacket(new byte[1], 1);
                    socket.receive(packet);
                    socket.send(new DatagramPacket(new byte[]{6}, 1));
                    System.out.println("Seems fine 2");
                    System.out.println(packet.getData()[0]);
                }
            } catch (IOException e) {
                System.out.println(e.getClass().getName() + ": " + e.getMessage());
            } finally {
                cdl.countDown();
            }

        });
        thread2.start();

        try {
            cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static class Dummy {
    }
}
