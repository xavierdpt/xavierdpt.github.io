package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.io.IOException;

@Scaffolded
public class CloneableExample {

    public void scaffold() throws ClassNotFoundException, IOException {
        if (ExampleUtils.skip()) {
            Cloneable instance = ExampleUtils.makeInstance(Cloneable.class);
            // marker interface
        }
    }

}
