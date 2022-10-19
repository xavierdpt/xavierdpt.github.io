package xd.examples.java.nio.channels;

import xd.ExampleUtils;
import xdtest.Interface;
import xdtest.Scaffolded;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

@Scaffolded
@Interface
public class SeekableByteChannelExample {

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            SeekableByteChannel instance = ExampleUtils.makeInstance(SeekableByteChannel.class);
            ByteBuffer byteBuffer = null;
            int read = instance.read(byteBuffer);
            int write = instance.write(byteBuffer);
            long position = instance.position();
            SeekableByteChannel position1 = instance.position(position);
            long size = instance.size();
            SeekableByteChannel truncate = instance.truncate(size);
        }
    }
}
