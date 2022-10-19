package xd.examples.java.nio.file;

import xd.ExampleUtils;
import xdtest.Interface;
import xdtest.Scaffolded;

import java.nio.file.DirectoryStream;
import java.util.Iterator;

@Scaffolded
@Interface
public class DirectoryStreamExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            DirectoryStream<Dummy> instance = ExampleUtils.makeInstance(DirectoryStream.class);
            Iterator<Dummy> iterator = instance.iterator();
        }
    }

    public static class Dummy {
    }
}
