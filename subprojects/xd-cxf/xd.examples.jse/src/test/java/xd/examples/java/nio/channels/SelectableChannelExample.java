package xd.examples.java.nio.channels;

import xd.ExampleUtils;
import xdtest.Abstract;
import xdtest.Interface;
import xdtest.Scaffolded;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;

@Scaffolded
@Abstract
public class SelectableChannelExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            SelectableChannel instance = ExampleUtils.makeInstance(SelectableChannel.class);
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
}
