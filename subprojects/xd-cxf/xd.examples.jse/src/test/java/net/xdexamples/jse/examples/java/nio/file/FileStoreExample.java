package net.xdexamples.jse.examples.java.nio.file;

import net.xdexamples.ExampleUtils;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;

public class FileStoreExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            FileStore instance = ExampleUtils.makeInstance(FileStore.class);
            String name = instance.name();
            String type = instance.type();
            boolean readOnly = instance.isReadOnly();
            long totalSpace = instance.getTotalSpace();
            long usableSpace = instance.getUsableSpace();
            long unallocatedSpace = instance.getUnallocatedSpace();
            long blockSize = instance.getBlockSize();
            boolean b = instance.supportsFileAttributeView(name);

            Class<? extends FileAttributeView> v = null;
            boolean b1 = instance.supportsFileAttributeView(v);

            Class<DummyFileStoreAttributeView> viewTypee = null;
            DummyFileStoreAttributeView fileStoreAttributeView = instance.getFileStoreAttributeView(viewTypee);

            Object attribute = instance.getAttribute(name);

        }
    }

    public interface DummyFileStoreAttributeView extends FileStoreAttributeView {
    }
}
