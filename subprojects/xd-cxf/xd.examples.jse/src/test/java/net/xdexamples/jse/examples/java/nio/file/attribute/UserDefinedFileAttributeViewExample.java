package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.BaseExample;
import xdtest.Interface;
import net.xdexamples.Scaffolded;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

@Scaffolded
@Interface
public class UserDefinedFileAttributeViewExample extends BaseExample<UserDefinedFileAttributeView> {
    @Override
    public void scaffold(UserDefinedFileAttributeView instance) throws IOException {
        String name = instance.name();
        List<String> list = instance.list();
        int size = instance.size(name);
        ByteBuffer byteBuffer = null;
        int read = instance.read(name, byteBuffer);
        int write = instance.write(name, byteBuffer);
        instance.delete(name);
    }
}
