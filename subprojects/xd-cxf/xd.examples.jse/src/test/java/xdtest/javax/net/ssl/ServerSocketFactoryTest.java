package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class ServerSocketFactoryTest {
    @Test
    public void test() throws IOException {
        if (TestUtils.scaffold()) {
            ServerSocketFactory instance = TestUtils.makeInstance(ServerSocketFactory.class);
            ServerSocketFactory aDefault = ServerSocketFactory.getDefault();
            ServerSocket serverSocket = instance.createServerSocket();
            int port = 0;

            ServerSocket serverSocket1 = instance.createServerSocket(port);
            int backlog = 0;
            ServerSocket serverSocket2 = instance.createServerSocket(port, backlog);
            InetAddress ifAddress = null;
            ServerSocket serverSocket3 = instance.createServerSocket(port, backlog, ifAddress);
        }
    }
}
