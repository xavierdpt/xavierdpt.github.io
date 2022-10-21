package net.xdexamples.jse.examples.java.nio.file;

import net.xdexamples.ExampleUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.util.Iterator;

public class PathExample {

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            Path instance = ExampleUtils.makeInstance(Path.class);

            URI uri = null;
            String first = null;
            String[] more = new String[0];
            Path of = Path.of(uri);
            Path of1 = Path.of(first, more);
            FileSystem fileSystem = instance.getFileSystem();
            boolean absolute = instance.isAbsolute();
            Path root = instance.getRoot();
            Path fileName = instance.getFileName();
            Path parent = instance.getParent();
            int nameCount = instance.getNameCount();
            int index = 0;
            Path name = instance.getName(index);

            int beginIndex = 0;
            int endIndex = 0;
            Path subpath = instance.subpath(beginIndex, endIndex);
            Path other = null;
            boolean b1 = instance.startsWith(other);
            String str = null;
            boolean b = instance.startsWith(str);
            boolean b2 = instance.endsWith(other);
            boolean b3 = instance.endsWith(str);
            Path normalize = instance.normalize();
            Path resolve = instance.resolve(other);
            Path resolve1 = instance.resolve(str);
            Path path = instance.resolveSibling(other);
            Path path1 = instance.resolveSibling(str);
            Path relativize = instance.relativize(other);
            URI uri1 = instance.toUri();
            Path path2 = instance.toAbsolutePath();
            LinkOption linkOption = null;
            Path path3 = instance.toRealPath(linkOption);
            File file = instance.toFile();
            WatchService watcher = null;
            WatchEvent.Kind<?> events = null;
            WatchEvent.Kind<?> modifiers = null;
            instance.register(watcher, events, modifiers);
            instance.register(watcher, events);
            Iterator<Path> iterator = instance.iterator();
            int i = instance.compareTo(other);
            boolean equals = instance.equals(other);
            int i1 = instance.hashCode();
            String s = instance.toString();

        }
    }

}
