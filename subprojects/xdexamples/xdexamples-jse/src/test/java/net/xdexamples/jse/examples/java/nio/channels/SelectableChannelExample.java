package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;

@Scaffolded
public class SelectableChannelExample extends BaseExample<SelectableChannel> {

    @Override
    protected void scaffold(SelectableChannel instance) throws Throwable {
        SelectorProvider provider = instance.provider();
        int ops = instance.validOps();
        boolean registered = instance.isRegistered();
        Selector selector = null;
        SelectionKey selectionKey = instance.keyFor(selector);
        SelectionKey register = instance.register(selector, ops);
        Object attribute = null;
        SelectionKey register1 = instance.register(selector, ops, attribute);
        boolean block = false;
        SelectableChannel selectableChannel = instance.configureBlocking(block);
        boolean blocking = instance.isBlocking();
        Object o = instance.blockingLock();
    }
}
