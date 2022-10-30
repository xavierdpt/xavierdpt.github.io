package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

@Scaffolded
public class ReadableByteChannelExample extends BaseExample<ReadableByteChannel> {

    @Override
    protected void scaffold(ReadableByteChannel instance) throws Throwable {
        ByteBuffer dst = null;
        int read = instance.read(dst);
    }
}
