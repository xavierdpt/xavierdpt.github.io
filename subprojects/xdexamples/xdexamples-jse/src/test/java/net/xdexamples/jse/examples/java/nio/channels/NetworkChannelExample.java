package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;
import xd.helpers.dummies.Dummy;

import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.channels.NetworkChannel;
import java.util.Set;

@Scaffolded
public class NetworkChannelExample extends BaseExample<NetworkChannel> {

    @Override
    protected void scaffold(NetworkChannel instance) throws Throwable {
        SocketAddress socketAddress = null;
        NetworkChannel bind = instance.bind(socketAddress);

        SocketAddress localAddress = instance.getLocalAddress();

        SocketOption<Dummy> name = null;
        Dummy option = instance.getOption(name);
        NetworkChannel networkChannel = instance.setOption(name, option);

        Set<SocketOption<?>> socketOptions = instance.supportedOptions();
    }


}
