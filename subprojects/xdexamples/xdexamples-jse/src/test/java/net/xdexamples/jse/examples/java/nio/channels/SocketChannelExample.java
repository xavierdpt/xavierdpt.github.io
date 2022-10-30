package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;
import xd.helpers.dummies.Dummy;

import java.net.ProtocolFamily;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

@Scaffolded
public class SocketChannelExample extends BaseExample<SocketChannel> {


    @Override
    protected void scaffold(SocketChannel instance) throws Throwable {
        ProtocolFamily protocolFamily = null;
        SocketAddress remoteSocketAddress = null;
        SocketChannel open = SocketChannel.open();
        SocketChannel open1 = SocketChannel.open(protocolFamily);
        SocketChannel open2 = SocketChannel.open(remoteSocketAddress);

        int ops = instance.validOps();

        SocketAddress localSocketAddress = null;
        SocketChannel bind = instance.bind(localSocketAddress);

        SocketOption<Dummy> name = null;
        Dummy value = null;
        SocketChannel socketChannel = instance.setOption(name, value);

        SocketChannel socketChannel1 = instance.shutdownInput();
        SocketChannel socketChannel2 = instance.shutdownOutput();

        Socket socket = instance.socket();
        boolean connected = instance.isConnected();
        boolean connectionPending = instance.isConnectionPending();
        boolean connect = instance.connect(remoteSocketAddress);
        boolean b = instance.finishConnect();
        SocketAddress remoteAddress = instance.getRemoteAddress();

        ByteBuffer byteBuffer = null;
        int read = instance.read(byteBuffer);
        ByteBuffer[] byteBuffers = new ByteBuffer[0];
        int offset = 0;
        int length = 0;
        long read1 = instance.read(byteBuffers, offset, length);
        long read2 = instance.read(byteBuffers);

        int write = instance.write(byteBuffer);
        long write1 = instance.write(byteBuffers);
        long write2 = instance.write(byteBuffers, offset, length);

        SocketAddress localAddress = instance.getLocalAddress();
    }

}
