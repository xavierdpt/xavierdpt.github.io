package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.nio.file.attribute.FileAttribute;

@Scaffolded
public class FileAttributeExample extends BaseExample<FileAttribute<FileAttributeExample.Dummy>> {

    @Override
    public void scaffold(FileAttribute<Dummy> instance) {
        String name = instance.name();
        Dummy value1 = instance.value();
    }

    public static class Dummy {
    }
}
