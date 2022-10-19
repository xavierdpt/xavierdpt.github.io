package xd.examples.java.nio.file;

import xd.ExampleUtils;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.WatchService;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Set;

public class FileSystemExample {

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            FileSystem instance = ExampleUtils.makeInstance(FileSystem.class);
            FileSystemProvider provider = instance.provider();
            instance.close();
            boolean open = instance.isOpen();
            boolean readOnly = instance.isReadOnly();
            String separator = instance.getSeparator();
            Iterable<Path> rootDirectories = instance.getRootDirectories();
            Iterable<FileStore> fileStores = instance.getFileStores();
            Set<String> strings = instance.supportedFileAttributeViews();
            String first = null;
            String[] more = new String[0];
            Path path = instance.getPath(first, more);
            String syntax = null;
            PathMatcher pathMatcher = instance.getPathMatcher(syntax);
            UserPrincipalLookupService userPrincipalLookupService = instance.getUserPrincipalLookupService();
            WatchService watchService = instance.newWatchService();
        }
    }

}
