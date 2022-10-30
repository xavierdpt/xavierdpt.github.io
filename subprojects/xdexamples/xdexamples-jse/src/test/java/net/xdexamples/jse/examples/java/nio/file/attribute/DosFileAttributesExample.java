package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.Scaffolded;
import net.xdexamples.BaseExample;

import java.nio.file.attribute.DosFileAttributes;

@Scaffolded
public class DosFileAttributesExample extends BaseExample<DosFileAttributes> {
    @Override
    public void scaffold(DosFileAttributes instance) throws Throwable {
        boolean readOnly = instance.isReadOnly();
        boolean hidden = instance.isHidden();
        boolean archive = instance.isArchive();
        boolean system = instance.isSystem();
    }
}
