package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.ExampleUtils;
import xdtest.Interface;
import net.xdexamples.Scaffolded;

import java.io.IOException;
import java.nio.channels.Channel;

@Scaffolded
@Interface
public class ChannelExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            Channel instance = ExampleUtils.makeInstance(Channel.class);
            boolean open = instance.isOpen();
            instance.close();
        }
    }
}
