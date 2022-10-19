package xd.examples.java.io;

import xd.BaseExample;
import xdtest.Scaffolded;

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
