package xd.examples.java.nio.channels;

import xd.ExampleUtils;
import xdtest.Interface;
import xdtest.Scaffolded;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ScatteringByteChannel;

@Scaffolded
@Interface
public class ScatteringByteChannelExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            ScatteringByteChannel instance = ExampleUtils.makeInstance(ScatteringByteChannel.class);
            ByteBuffer[] byteBuffers = new ByteBuffer[0];
            long read = instance.read(byteBuffers);
            int offset = 0;
            int length = 0;
            long read1 = instance.read(byteBuffers, offset, length);
        }
    }
}
