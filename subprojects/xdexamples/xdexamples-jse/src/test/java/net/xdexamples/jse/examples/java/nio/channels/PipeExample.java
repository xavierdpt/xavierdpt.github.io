package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.nio.channels.Pipe;

@Scaffolded
public class PipeExample extends BaseExample<Pipe> {

    @Override
    protected void scaffold(Pipe instance) throws Throwable {
        Pipe.SourceChannel source = instance.source();
        Pipe.SinkChannel sink = instance.sink();
        Pipe open = Pipe.open();
    }
}
