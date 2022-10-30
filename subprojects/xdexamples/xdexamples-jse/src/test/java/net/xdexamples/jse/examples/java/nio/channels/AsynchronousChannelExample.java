package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.nio.channels.AsynchronousChannel;

@Scaffolded
public class AsynchronousChannelExample extends BaseExample<AsynchronousChannel> {

    @Override
    protected void scaffold(AsynchronousChannel instance) throws Throwable {
        instance.close();
    }
}
