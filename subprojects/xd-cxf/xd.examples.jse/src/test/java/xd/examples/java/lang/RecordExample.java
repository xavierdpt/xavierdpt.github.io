package xd.examples.java.lang;

import xd.ExampleUtils;
import xdtest.Scaffolded;

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
