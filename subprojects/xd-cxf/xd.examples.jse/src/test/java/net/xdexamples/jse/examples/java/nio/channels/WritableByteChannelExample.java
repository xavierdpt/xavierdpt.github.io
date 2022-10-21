package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.ExampleUtils;
import xdtest.Interface;
import net.xdexamples.Scaffolded;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

@Scaffolded
@Interface
public class WritableByteChannelExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            WritableByteChannel instance = ExampleUtils.makeInstance(WritableByteChannel.class);
            ByteBuffer byteBuffer = null;
            int write = instance.write(byteBuffer);

        }
    }
}
