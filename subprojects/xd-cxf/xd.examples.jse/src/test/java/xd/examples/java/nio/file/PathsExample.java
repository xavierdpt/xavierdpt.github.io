package xd.examples.java.nio.file;

import xd.ExampleUtils;
import xdtest.Scaffolded;

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
