package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.WritableByteChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Set;

@Scaffolded
public class FileChannelExample extends BaseExample<FileChannel> {

    @Override
    protected void scaffold(FileChannel instance) throws Throwable {
        Path path = null;
        OpenOption openOption = null;
        Set<? extends OpenOption> openOptions = null;
        FileAttribute<?> fileAttributes = null;
        FileChannel open = FileChannel.open(path, openOption);
        FileChannel open1 = instance.open(path, openOptions, fileAttributes);

        ByteBuffer byteBuffer = null;
        long position = 0;
        ByteBuffer[] byteBuffers = new ByteBuffer[0];
        int offset = 0;
        int length = 0;
        int read = instance.read(byteBuffer);
        int read1 = instance.read(byteBuffer, position);
        long read2 = instance.read(byteBuffers);
        long read3 = instance.read(byteBuffers, offset, length);

        int write = instance.write(byteBuffer);
        int write1 = instance.write(byteBuffer, position);
        long write2 = instance.write(byteBuffers);
        long write3 = instance.write(byteBuffers, offset, length);

        long position1 = instance.position();
        FileChannel position2 = instance.position(position1);

        long size = instance.size();
        FileChannel truncate = instance.truncate(size);

        boolean metaData = false;
        instance.force(metaData);

        long count = 0;
        WritableByteChannel writableByteChannel = null;
        long l = instance.transferTo(position, count, writableByteChannel);

        WritableByteChannel readableByteChannel = null;
        long l1 = instance.transferTo(position, count, readableByteChannel);

        FileChannel.MapMode mode = null;
        MappedByteBuffer map = instance.map(mode, position, size);

        FileLock lock = instance.lock();
        boolean shared = false;
        FileLock lock1 = instance.lock(position, size, shared);

        FileLock fileLock = instance.tryLock();
        instance.tryLock(position, size, shared);
    }
}
