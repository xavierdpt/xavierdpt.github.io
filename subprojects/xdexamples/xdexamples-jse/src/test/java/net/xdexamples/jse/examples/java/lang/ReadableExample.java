package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.io.IOException;
import java.nio.CharBuffer;

@Scaffolded
public class ReadableExample {

    public void scaffold() throws ClassNotFoundException, IOException, InterruptedException {
        if (ExampleUtils.skip()) {
            Readable instance = ExampleUtils.makeInstance(Readable.class);
            CharBuffer charBuffer = null;
            int read = instance.read(charBuffer);
        }
    }


}
