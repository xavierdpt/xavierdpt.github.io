package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.ExampleUtils;
import net.xdexamples.support.internal.Scaffolded;

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
