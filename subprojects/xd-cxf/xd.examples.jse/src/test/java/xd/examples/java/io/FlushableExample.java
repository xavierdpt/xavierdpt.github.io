package xd.examples.java.io;

import xd.BaseExample;

import java.io.Flushable;
import java.io.IOException;

public class FlushableExample extends BaseExample<Flushable> {
    @Override
    protected void scaffold(Flushable instance) throws IOException {
        instance.flush();
    }
}
