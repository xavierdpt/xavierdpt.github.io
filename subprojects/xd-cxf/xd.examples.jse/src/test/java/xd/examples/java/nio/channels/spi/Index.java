package xd.examples.java.nio.channels.spi;

import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelectionKey;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.nio.channels.spi.SelectorProvider;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    AbstractInterruptibleChannel.class,
                    AbstractSelectableChannel.class,
                    AbstractSelectionKey.class,
                    AbstractSelector.class,
                    AsynchronousChannelProvider.class,
                    SelectorProvider.class
            ));
        }
    }

}
