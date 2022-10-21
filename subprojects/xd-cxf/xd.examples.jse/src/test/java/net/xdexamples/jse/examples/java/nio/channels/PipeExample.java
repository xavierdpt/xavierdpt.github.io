package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.ExampleUtils;
import xdtest.Abstract;
import net.xdexamples.Scaffolded;

import java.io.IOException;
import java.nio.channels.Pipe;

@Scaffolded
@Abstract
public class PipeExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            Pipe instance = ExampleUtils.makeInstance(Pipe.class);
            Pipe.SourceChannel source = instance.source();
            Pipe.SinkChannel sink = instance.sink();
            Pipe open = Pipe.open();
        }
    }
}
