package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.support.internal.BaseExample;

import java.io.IOException;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;

public class FileOwnerAttributeViewExample extends BaseExample<FileOwnerAttributeView> {

    @Override
    public void scaffold(FileOwnerAttributeView instance) throws IOException {
        String name = instance.name();
        UserPrincipal owner = instance.getOwner();
        instance.setOwner(owner);
    }
}
