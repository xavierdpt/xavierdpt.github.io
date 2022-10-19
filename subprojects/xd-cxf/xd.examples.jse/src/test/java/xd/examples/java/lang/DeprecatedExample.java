package xd.examples.java.lang;

import xd.ExampleUtils;
import xdtest.Scaffolded;

import java.io.IOException;

@Scaffolded
public class DeprecatedExample {

    public void scaffold() throws ClassNotFoundException, IOException {
        if (ExampleUtils.skip()) {
            Deprecated instance = ExampleUtils.makeInstance(Deprecated.class);
            String since = instance.since();
            boolean b = instance.forRemoval();
        }
    }

}
