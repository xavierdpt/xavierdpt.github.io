package xd.examples.java.nio.file.attribute;

import xd.BaseExample;
import xdtest.Interface;
import xdtest.Scaffolded;

import java.io.IOException;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

@Scaffolded
@Interface
public class DosFileAttributeViewExample extends BaseExample<DosFileAttributeView> {
    @Override
    public void scaffold(DosFileAttributeView instance) throws IOException {
        String name = instance.name();
        DosFileAttributes dosFileAttributes = instance.readAttributes();
        boolean value = false;
        instance.setReadOnly(value);
        instance.setHidden(value);
        instance.setSystem(value);
        instance.setArchive(value);
    }
}
