package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.nio.ByteBuffer;
import java.nio.channels.ScatteringByteChannel;

@Scaffolded
public class ScatteringByteChannelExample extends BaseExample<ScatteringByteChannel> {


    @Override
    protected void scaffold(ScatteringByteChannel instance) throws Throwable {
        ByteBuffer[] byteBuffers = new ByteBuffer[0];
        long read = instance.read(byteBuffers);
        int offset = 0;
        int length = 0;
        long read1 = instance.read(byteBuffers, offset, length);
    }
}
