package xd.examples.java.nio.file.attribute;

import xd.BaseExample;
import xdtest.Interface;
import xdtest.Scaffolded;

import java.nio.file.attribute.FileAttribute;

@Scaffolded
@Interface
public class FileAttributeExample extends BaseExample<FileAttribute<FileAttributeExample.Dummy>> {

    @Override
    public void scaffold(FileAttribute<Dummy> instance) {
        String name = instance.name();
        Dummy value1 = instance.value();
    }

    public static class Dummy {
    }
}
