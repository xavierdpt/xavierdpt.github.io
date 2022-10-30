package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

@Scaffolded
public class BasicFileAttributeViewExample extends BaseExample<BasicFileAttributeView> {
    @Override
    public void scaffold(BasicFileAttributeView instance) throws Throwable {
        String name = instance.name();
        BasicFileAttributes basicFileAttributes = instance.readAttributes();
        FileTime lastModified = null;
        FileTime lastAccess = null;
        FileTime create = null;
        instance.setTimes(lastModified, lastAccess, create);
    }
}
