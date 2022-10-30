package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.ExampleUtils;
import net.xdexamples.support.internal.Scaffolded;

import java.io.IOException;

@Scaffolded
public class RecordExample {

    public void scaffold() throws ClassNotFoundException, IOException, InterruptedException {
        if (ExampleUtils.skip()) {
            Record instance = ExampleUtils.makeInstance(Record.class);
            Record other = null;
            boolean equals = instance.equals(other);
            int i = instance.hashCode();
            String s = instance.toString();
        }
    }

}
