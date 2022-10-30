package net.xdexamples.jse.index.java.nio.channels;


import net.xdexamples.support.internal.ExampleIndex;
import net.xdexamples.jse.examples.java.nio.channels.AsynchronousByteChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.AsynchronousChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.AsynchronousChannelGroupExample;
import net.xdexamples.jse.examples.java.nio.channels.AsynchronousFileChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.AsynchronousServerSocketChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.AsynchronousSocketChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.ByteChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.ChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.ChannelsExample;
import net.xdexamples.jse.examples.java.nio.channels.CompletionHandlerExample;
import net.xdexamples.jse.examples.java.nio.channels.DatagramChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.FileChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.FileLockExample;
import net.xdexamples.jse.examples.java.nio.channels.GatheringByteChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.InterruptibleChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.MembershipKeyExample;
import net.xdexamples.jse.examples.java.nio.channels.MulticastChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.NetworkChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.PipeExample;
import net.xdexamples.jse.examples.java.nio.channels.ReadableByteChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.ScatteringByteChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.SeekableByteChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.SelectableChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.SelectionKeyExample;
import net.xdexamples.jse.examples.java.nio.channels.SelectorExample;
import net.xdexamples.jse.examples.java.nio.channels.ServerSocketChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.SocketChannelExample;
import net.xdexamples.jse.examples.java.nio.channels.WritableByteChannelExample;

import java.nio.channels.AcceptPendingException;
import java.nio.channels.AlreadyBoundException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.ByteChannel;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.CompletionHandler;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.FileLockInterruptionException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.IllegalChannelGroupException;
import java.nio.channels.IllegalSelectorException;
import java.nio.channels.InterruptedByTimeoutException;
import java.nio.channels.InterruptibleChannel;
import java.nio.channels.MembershipKey;
import java.nio.channels.MulticastChannel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.NoConnectionPendingException;
import java.nio.channels.NonReadableChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.NotYetBoundException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.OverlappingFileLockException;
import java.nio.channels.Pipe;
import java.nio.channels.ReadPendingException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.ShutdownChannelGroupException;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnresolvedAddressException;
import java.nio.channels.WritableByteChannel;
import java.nio.channels.WritePendingException;

@ExampleIndex({

        AcceptPendingException.class,

        AlreadyBoundException.class,

        AlreadyConnectedException.class,

        AsynchronousByteChannel.class,
        AsynchronousByteChannelExample.class,

        AsynchronousChannel.class,
        AsynchronousChannelExample.class,

        AsynchronousChannelGroup.class,
        AsynchronousChannelGroupExample.class,

        AsynchronousCloseException.class,

        AsynchronousFileChannel.class,
        AsynchronousFileChannelExample.class,

        AsynchronousServerSocketChannel.class,
        AsynchronousServerSocketChannelExample.class,

        AsynchronousSocketChannel.class,
        AsynchronousSocketChannelExample.class,

        ByteChannel.class,
        ByteChannelExample.class,

        CancelledKeyException.class,

        Channel.class,
        ChannelExample.class,

        Channels.class,
        ChannelsExample.class,

        ClosedByInterruptException.class,

        ClosedChannelException.class,

        ClosedSelectorException.class,

        CompletionHandler.class,
        CompletionHandlerExample.class,

        ConnectionPendingException.class,

        DatagramChannel.class,
        DatagramChannelExample.class,

        FileChannel.class,
        FileChannelExample.class,

        FileLock.class,
        FileLockExample.class,

        FileLockInterruptionException.class,

        GatheringByteChannel.class,
        GatheringByteChannelExample.class,

        IllegalBlockingModeException.class,

        IllegalChannelGroupException.class,

        IllegalSelectorException.class,

        InterruptedByTimeoutException.class,

        InterruptibleChannel.class,
        InterruptibleChannelExample.class,

        MembershipKey.class,
        MembershipKeyExample.class,

        MulticastChannel.class,
        MulticastChannelExample.class,

        NetworkChannel.class,
        NetworkChannelExample.class,

        NoConnectionPendingException.class,

        NonReadableChannelException.class,

        NonWritableChannelException.class,

        NotYetBoundException.class,

        NotYetConnectedException.class,

        OverlappingFileLockException.class,

        Pipe.class,
        PipeExample.class,

        ReadableByteChannel.class,
        ReadableByteChannelExample.class,

        ReadPendingException.class,

        ScatteringByteChannel.class,
        ScatteringByteChannelExample.class,

        SeekableByteChannel.class,
        SeekableByteChannelExample.class,

        SelectableChannel.class,
        SelectableChannelExample.class,

        SelectionKey.class,
        SelectionKeyExample.class,

        Selector.class,
        SelectorExample.class,

        ServerSocketChannel.class,
        ServerSocketChannelExample.class,

        ShutdownChannelGroupException.class,

        SocketChannel.class,
        SocketChannelExample.class,

        UnresolvedAddressException.class,

        WritableByteChannel.class,
        WritableByteChannelExample.class,

        WritePendingException.class
})
public class Index {
}
