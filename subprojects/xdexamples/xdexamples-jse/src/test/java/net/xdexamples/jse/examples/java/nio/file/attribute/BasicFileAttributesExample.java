package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

@Scaffolded
public class BasicFileAttributesExample extends BaseExample<BasicFileAttributes> {

    @Override
    public void scaffold(BasicFileAttributes instance) throws Throwable {
        FileTime fileTime = instance.lastModifiedTime();
        FileTime fileTime1 = instance.lastAccessTime();
        FileTime fileTime2 = instance.creationTime();
        boolean regularFile = instance.isRegularFile();
        boolean directory = instance.isDirectory();
        boolean symbolicLink = instance.isSymbolicLink();
        boolean other = instance.isOther();
        long size = instance.size();
        Object o = instance.fileKey();
    }
}
