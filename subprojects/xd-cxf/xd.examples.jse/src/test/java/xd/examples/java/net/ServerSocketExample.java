package xd.examples.java.net;

import org.junit.Assert;
import org.junit.Test;
import xd.ExampleUtils;
import xdtest.TestUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.channels.ServerSocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ServerSocketExample {

    public static final String SO_RCVBUF = "SO_RCVBUF";
    public static final String IP_TOS = "IP_TOS";
    public static final String SO_REUSEADDR = "SO_REUSEADDR";

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            ServerSocket instance = ExampleUtils.makeInstance(ServerSocket.class);

            TestUtils.ignore(
                    new ServerSocket(),
                    new ServerSocket(0),
                    new ServerSocket(0, 0),
                    new ServerSocket(0, 0, null)
            );

            InetAddress inetAddress1 = instance.getInetAddress();
            SocketAddress localSocketAddress = instance.getLocalSocketAddress();

            instance.bind(null);
            instance.bind(null, 0);
            Socket accept = instance.accept();
            instance.close();

            ServerSocketChannel channel = instance.getChannel();

            instance.setSoTimeout(0);
            instance.setReuseAddress(false);
            instance.setReceiveBufferSize(0);
            instance.setPerformancePreferences(0, 0, 0);
            instance.setOption(null, (Dummy) null);
            Dummy option = instance.getOption(null);
            Set<SocketOption<?>> socketOptions = instance.supportedOptions();

            boolean bound = instance.isBound();
            boolean closed = instance.isClosed();
            int receiveBufferSize = instance.getReceiveBufferSize();
            boolean reuseAddress = instance.getReuseAddress();
            int soTimeout = instance.getSoTimeout();
            String s = instance.toString();
            int localPort = instance.getLocalPort();
        }
    }

    @Test
    public void emptyConstructor() throws IOException {
        try (ServerSocket ssocket = new ServerSocket()) {
            assertFalse(ssocket.isBound());
            assertFalse(ssocket.isClosed());
            assertFalse(ssocket.getReuseAddress());
            assertEquals(-1, ssocket.getLocalPort());
            assertNull(ssocket.getInetAddress());
            assertNull(ssocket.getLocalSocketAddress());
            assertEquals(65536, ssocket.getReceiveBufferSize());
            assertEquals(0, ssocket.getSoTimeout());
            assertEquals("ServerSocket[unbound]", ssocket.toString());
        }
    }

    @Test
    public void port() throws IOException {
        try (ServerSocket ssocket = new ServerSocket(2222)) {
            assertTrue(ssocket.isBound());
            assertFalse(ssocket.isClosed());
            assertFalse(ssocket.getReuseAddress());
            assertEquals(2222, ssocket.getLocalPort());
            assertEquals("0.0.0.0/0.0.0.0", ssocket.getInetAddress().toString());
            assertEquals("0.0.0.0/0.0.0.0:2222", ssocket.getLocalSocketAddress().toString());
            assertEquals(65536, ssocket.getReceiveBufferSize());
            assertEquals(0, ssocket.getSoTimeout());
            assertEquals("ServerSocket[addr=0.0.0.0/0.0.0.0,localport=2222]", ssocket.toString());

            int[] transmittedData = new int[1];

            CountDownLatch cdl = new CountDownLatch(2);

            new Thread(() -> {
                try {
                    try (Socket socket = ssocket.accept()) {
                        int b = socket.getInputStream().read();
                        transmittedData[0] = b;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                cdl.countDown();
            }).start();

            new Thread(() -> {
                try {
                    try (Socket socket = new Socket("localhost", 2222)) {
                        socket.getOutputStream().write(5);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                cdl.countDown();
            }).start();

            try {
                cdl.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            Assert.assertEquals(5, transmittedData[0]);

        }
    }

    @Test
    public void options() throws IOException {
        String I = Integer.class.getName();
        String B = Boolean.class.getName();
        try (ServerSocket ssocket = new ServerSocket()) {
            Map<String, Class<?>> options = new HashMap<>();
            for (SocketOption<?> option : ssocket.supportedOptions()) {
                options.put(option.name(), option.type());
            }
            assertEquals(I, options.get(SO_RCVBUF).getName());
            assertEquals(I, options.get(IP_TOS).getName());
            assertEquals(B, options.get(SO_REUSEADDR).getName());
        }
    }

    public static class Dummy {

    }

}
