package xd.examples.java.nio.channels;

import xd.ExampleUtils;
import xdtest.Abstract;
import xdtest.Scaffolded;

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
