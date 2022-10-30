package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.BaseExample;
import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

@Scaffolded
public class SeekableByteChannelExample extends BaseExample<SeekableByteChannel> {

    @Override
    protected void scaffold(SeekableByteChannel instance) throws Throwable {
        ByteBuffer byteBuffer = null;
        int read = instance.read(byteBuffer);
        int write = instance.write(byteBuffer);
        long position = instance.position();
        SeekableByteChannel position1 = instance.position(position);
        long size = instance.size();
        SeekableByteChannel truncate = instance.truncate(size);
    }
}
