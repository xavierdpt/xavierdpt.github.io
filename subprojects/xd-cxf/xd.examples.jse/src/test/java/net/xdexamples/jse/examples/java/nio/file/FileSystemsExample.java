package net.xdexamples.jse.examples.java.nio.file;

import org.junit.Test;
import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Map;

@ToBeContinued
public class FileSystemsExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            FileSystems instance = ExampleUtils.makeInstance(FileSystems.class);

            FileSystem aDefault = FileSystems.getDefault();

            URI uri = null;
            FileSystem fileSystem = FileSystems.getFileSystem(uri);

            Map<String, ?> env = null;
            ClassLoader classLoader = null;
            Path path = null;

            FileSystem fileSystem1 = FileSystems.newFileSystem(uri, env);
            FileSystem fileSystem2 = FileSystems.newFileSystem(uri, env, classLoader);
            FileSystem fileSystem3 = FileSystems.newFileSystem(path, classLoader);
            FileSystem fileSystem4 = FileSystems.newFileSystem(path, env);
            FileSystem fileSystem5 = FileSystems.newFileSystem(path);
            FileSystem fileSystem6 = FileSystems.newFileSystem(path, env, classLoader);
        }
    }

    @Test
    public void example() {
        FileSystem fileSystem = FileSystems.getDefault();
        System.out.println("--- Root directories");
        for (Path rootDirectory : fileSystem.getRootDirectories()) {
            System.out.println(rootDirectory.toString());
        }
        System.out.println("--- File stores");
        for (FileStore fileStore : fileSystem.getFileStores()) {
            System.out.println(fileStore.name());
        }
    }
}
