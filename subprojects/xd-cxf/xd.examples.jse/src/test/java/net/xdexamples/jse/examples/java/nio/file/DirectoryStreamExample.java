package net.xdexamples.jse.examples.java.nio.file;

import net.xdexamples.Scaffolded;
import net.xdexamples.ExampleUtils;
import xdtest.Interface;

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
