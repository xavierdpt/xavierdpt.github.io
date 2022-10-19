package xd.examples.java.nio.channels;

import xd.ExampleUtils;
import xdtest.Interface;
import xdtest.Scaffolded;

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
