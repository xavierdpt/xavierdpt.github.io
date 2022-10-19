package xd.examples.java.lang;

import xd.ExampleUtils;
import xdtest.Scaffolded;

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
