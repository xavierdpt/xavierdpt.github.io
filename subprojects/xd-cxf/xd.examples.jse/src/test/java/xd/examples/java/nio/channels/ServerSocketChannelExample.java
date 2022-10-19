package xd.examples.java.nio.channels;

import xd.ExampleUtils;
import xdtest.Abstract;
import xdtest.Scaffolded;

import java.io.IOException;
import java.net.ProtocolFamily;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

@Scaffolded
@Abstract
public class ServerSocketChannelExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            ServerSocketChannel instance = ExampleUtils.makeInstance(ServerSocketChannel.class);

            ProtocolFamily protocolFamily = null;
            ServerSocketChannel open = ServerSocketChannel.open();
            ServerSocketChannel open1 = ServerSocketChannel.open(protocolFamily);

            int ops = instance.validOps();

            SocketAddress socketAddress = null;
            int backlog = 0;
            ServerSocketChannel bind = instance.bind(socketAddress);
            ServerSocketChannel bind1 = instance.bind(socketAddress, backlog);

            SocketOption<Dummy> name = null;
            Dummy value = null;
            ServerSocketChannel serverSocketChannel = instance.setOption(name, value);

            ServerSocket socket = instance.socket();

            SocketChannel accept = instance.accept();

            SocketAddress localAddress = instance.getLocalAddress();
        }
    }

    public static class Dummy {
    }
}
