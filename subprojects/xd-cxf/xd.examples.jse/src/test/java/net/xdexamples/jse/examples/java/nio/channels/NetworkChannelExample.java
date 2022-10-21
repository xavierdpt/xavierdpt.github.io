package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.ExampleUtils;
import xdtest.Interface;
import net.xdexamples.Scaffolded;

import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.channels.NetworkChannel;
import java.util.Set;

@Scaffolded
@Interface
public class NetworkChannelExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            NetworkChannel instance = ExampleUtils.makeInstance(NetworkChannel.class);

            SocketAddress socketAddress = null;
            NetworkChannel bind = instance.bind(socketAddress);

            SocketAddress localAddress = instance.getLocalAddress();

            SocketOption<Dummy> name = null;
            Dummy option = instance.getOption(name);
            NetworkChannel networkChannel = instance.setOption(name, option);

            Set<SocketOption<?>> socketOptions = instance.supportedOptions();
        }
    }

    public static class Dummy {
    }
}
