package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

@Scaffolded
public class WritableByteChannelExample extends BaseExample<WritableByteChannel> {

    @Override
    protected void scaffold(WritableByteChannel instance) throws Throwable {
        ByteBuffer byteBuffer = null;
        int write = instance.write(byteBuffer);
    }
}
