package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;
import xd.helpers.dummies.Dummy;

import java.net.ProtocolFamily;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

@Scaffolded
public class ServerSocketChannelExample extends BaseExample<ServerSocketChannel> {

    @Override
    protected void scaffold(ServerSocketChannel instance) throws Throwable {
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
