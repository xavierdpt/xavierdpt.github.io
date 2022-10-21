package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.ExampleUtils;
import xdtest.Interface;
import net.xdexamples.Scaffolded;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

@Scaffolded
@Interface
public class AsynchronousByteChannelExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            AsynchronousByteChannel instance = ExampleUtils.makeInstance(AsynchronousByteChannel.class);
            ByteBuffer dst = null;

            Dummy attachment = null;
            CompletionHandler<Integer, ? super Dummy> completionHandler = null;

            Future<Integer> read = instance.read(dst);
            instance.read(dst, attachment, completionHandler);

            ByteBuffer src = null;
            Future<Integer> write = instance.write(src);
            instance.write(src, attachment, completionHandler);
        }
    }

    public static class Dummy {
    }
}
