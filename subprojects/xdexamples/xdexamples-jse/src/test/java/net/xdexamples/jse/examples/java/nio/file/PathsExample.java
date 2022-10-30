package net.xdexamples.jse.examples.java.nio.file;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

@Scaffolded
public class PathsExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            Paths instance = ExampleUtils.makeInstance(Paths.class);

            URI uri = null;
            String first = null;
            String[] more = new String[0];

            Path path = Paths.get(uri);
            Path path1 = Paths.get(first, more);
        }
    }

}
