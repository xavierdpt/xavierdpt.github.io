package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

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
