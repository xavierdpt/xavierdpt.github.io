package xd.examples.java.nio.channels;

import xd.ExampleUtils;
import xdtest.Interface;
import xdtest.Scaffolded;

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
