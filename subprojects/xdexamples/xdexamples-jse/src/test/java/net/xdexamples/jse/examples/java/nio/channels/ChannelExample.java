package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.nio.channels.Channel;

@Scaffolded
public class ChannelExample extends BaseExample<Channel> {

    @Override
    protected void scaffold(Channel instance) throws Throwable {
        boolean open = instance.isOpen();
        instance.close();
    }
}
