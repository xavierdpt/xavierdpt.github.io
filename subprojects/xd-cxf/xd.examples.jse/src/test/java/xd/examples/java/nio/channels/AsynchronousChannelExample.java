package xd.examples.java.nio.channels;

import xd.ExampleUtils;
import xdtest.Interface;
import xdtest.Scaffolded;

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
