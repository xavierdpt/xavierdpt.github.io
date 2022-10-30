package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.nio.channels.Channel;

@Scaffolded
public class ChannelExample extends BaseExample<Channel> {

    @Override
    protected void scaffold(Channel instance) throws Throwable {
        boolean open = instance.isOpen();
        instance.close();
    }
}
