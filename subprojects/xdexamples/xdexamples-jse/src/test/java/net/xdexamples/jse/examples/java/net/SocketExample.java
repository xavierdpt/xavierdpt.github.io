package net.xdexamples.jse.examples.java.net;

import org.junit.Test;
import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

@ToBeContinued
public class SocketExample {

    public static final String SO_RCVBUF = "SO_RCVBUF";
    public static final String SO_SNDBUF = "SO_SNDBUF";
    public static final String SO_LINGER = "SO_LINGER";
    public static final String IP_TOS = "IP_TOS";
    public static final String TCP_NODELAY = "TCP_NODELAY";
    public static final String SO_KEEPALIVE = "SO_KEEPALIVE";
    public static final String SO_REUSEADDR = "SO_REUSEADDR";

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            Socket instance = ExampleUtils.makeInstance(Socket.class);

            Proxy proxy = null;

            int port = 0;
            InetAddress inetAddress = null;
            int localPort = 0;
            InetAddress localAddress = null;
            boolean stream = false;
            String host = null;
            ExampleUtils.ignore(
                    new Socket(),
                    new Socket(proxy),
                    new Socket(host, port),
                    new Socket(inetAddress, port),
                    new Socket(host, port, inetAddress, localPort),
                    new Socket(inetAddress, port, localAddress, localPort),
                    new Socket(host, port, stream),
                    new Socket(inetAddress, port, stream)
            );

            SocketAddress socketAddress = null;
            int timeout = 0;
            instance.connect(socketAddress);
            instance.connect(socketAddress, timeout);

            instance.bind(socketAddress);

            InetAddress inetAddress1 = instance.getInetAddress();
            InetAddress localAddress1 = instance.getLocalAddress();
            int port1 = instance.getPort();
            int localPort1 = instance.getLocalPort();
            SocketAddress remoteSocketAddress = instance.getRemoteSocketAddress();
            SocketAddress localSocketAddress = instance.getLocalSocketAddress();
            SocketChannel channel = instance.getChannel();
            InputStream inputStream = instance.getInputStream();
            OutputStream outputStream = instance.getOutputStream();
            boolean tcpNoDelay = instance.getTcpNoDelay();
            instance.setTcpNoDelay(tcpNoDelay);
            int soLinger = instance.getSoLinger();
            boolean on = false;
            instance.setSoLinger(on, soLinger);
            int data = 0;
            instance.sendUrgentData(data);
            boolean oobInline = instance.getOOBInline();
            instance.setOOBInline(oobInline);
            int soTimeout = instance.getSoTimeout();
            instance.setSoTimeout(soTimeout);
            int sendBufferSize = instance.getSendBufferSize();
            instance.setSendBufferSize(sendBufferSize);
            int receiveBufferSize = instance.getReceiveBufferSize();
            instance.setReceiveBufferSize(receiveBufferSize);
            boolean keepAlive = instance.getKeepAlive();
            instance.setKeepAlive(keepAlive);
            int trafficClass = instance.getTrafficClass();
            instance.setTrafficClass(trafficClass);
            boolean reuseAddress = instance.getReuseAddress();
            instance.setReuseAddress(reuseAddress);
            instance.close();
            instance.shutdownInput();
            instance.shutdownOutput();
            String s = instance.toString();
            boolean connected = instance.isConnected();
            boolean bound = instance.isBound();
            boolean closed = instance.isClosed();
            boolean inputShutdown = instance.isInputShutdown();
            boolean outputShutdown = instance.isOutputShutdown();
            int connectionTime = 0;
            int latency = 0;
            int bandwidth = 0;
            instance.setPerformancePreferences(connectionTime, latency, bandwidth);
            SocketOption<Dummy> name = null;
            Dummy option = instance.getOption(name);
            instance.setOption(name, option);
            Set<SocketOption<?>> socketOptions = instance.supportedOptions();
        }
    }

    @Test
    public void example() throws IOException {
        try (Socket socket = new Socket()) {

            assertFalse(socket.getTcpNoDelay());
            assertFalse(socket.getOOBInline());
            assertFalse(socket.getKeepAlive());
            assertFalse(socket.getReuseAddress());
            assertFalse(socket.isConnected());
            assertFalse(socket.isBound());
            assertFalse(socket.isClosed());
            assertFalse(socket.isInputShutdown());
            assertFalse(socket.isOutputShutdown());

            assertEquals(0, socket.getPort());
            assertEquals(-1, socket.getLocalPort());
            assertEquals(-1, socket.getSoLinger());
            assertEquals(0, socket.getSoTimeout());
            assertEquals(65536, socket.getSendBufferSize());
            assertEquals(65536, socket.getReceiveBufferSize());
            assertEquals(0, socket.getTrafficClass());

            assertNull(socket.getInetAddress());
            assertEquals("0.0.0.0/0.0.0.0", socket.getLocalAddress().toString());
            assertNull(socket.getRemoteSocketAddress());
            assertNull(socket.getLocalSocketAddress());

            assertEquals("Socket[unconnected]", socket.toString());
        }
    }

    @Test
    public void options() throws IOException {
        try (Socket socket = new Socket()) {
            Map<String, Class<?>> options = new HashMap<>();
            for (SocketOption<?> option : socket.supportedOptions()) {
                String name = option.name();
                Class<?> type = option.type();
                options.put(name, type);
            }
            assertEquals(Integer.class, options.get(SO_RCVBUF));
            assertEquals(Integer.class, options.get(SO_SNDBUF));
            assertEquals(Integer.class, options.get(SO_LINGER));
            assertEquals(Integer.class, options.get(IP_TOS));
            assertEquals(Boolean.class, options.get(TCP_NODELAY));
            assertEquals(Boolean.class, options.get(SO_KEEPALIVE));
            assertEquals(Boolean.class, options.get(SO_REUSEADDR));
        }
    }

    public static class Dummy {
    }


}
