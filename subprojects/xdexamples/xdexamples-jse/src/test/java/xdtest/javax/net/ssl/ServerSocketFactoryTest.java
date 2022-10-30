package xdtest.javax.net.ssl;

import net.xdexamples.support.internal.BaseExample;

import javax.net.ServerSocketFactory;
import java.net.InetAddress;
import java.net.ServerSocket;

public class ServerSocketFactoryTest extends BaseExample<ServerSocketFactory> {

    @Override
    protected void scaffold(ServerSocketFactory instance) throws Throwable {
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
