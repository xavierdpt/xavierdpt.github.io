package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;
import xd.helpers.dummies.Dummy;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

@Scaffolded
public class AsynchronousByteChannelExample extends BaseExample<AsynchronousByteChannel> {

    @Override
    protected void scaffold(AsynchronousByteChannel instance) throws Throwable {
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
