package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.ExampleUtils;
import xdtest.Interface;
import net.xdexamples.Scaffolded;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

@Scaffolded
@Interface
public class ReadableByteChannelExample {

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            ReadableByteChannel instance = ExampleUtils.makeInstance(ReadableByteChannel.class);
            ByteBuffer dst = null;
            int read = instance.read(dst);
        }
    }

}
