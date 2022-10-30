package net.xdexamples.jse.examples.java.io;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.io.Closeable;
import java.io.IOException;

@Scaffolded
public class CloseableExample extends BaseExample<Closeable> {
    @Override
    protected void scaffold(Closeable instance) throws IOException {
        {
            instance.close();
        }
    }
}
