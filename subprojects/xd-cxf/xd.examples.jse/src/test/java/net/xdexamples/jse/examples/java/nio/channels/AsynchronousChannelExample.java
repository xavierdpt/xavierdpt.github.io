package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.ExampleUtils;
import xdtest.Interface;
import net.xdexamples.Scaffolded;

import java.io.IOException;
import java.nio.channels.AsynchronousChannel;

@Scaffolded
@Interface
public class AsynchronousChannelExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            AsynchronousChannel instance = ExampleUtils.makeInstance(AsynchronousChannel.class);
            instance.close();

        }
    }
}
