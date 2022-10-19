package xd.examples.java.lang;

import xd.ExampleUtils;
import xdtest.Scaffolded;

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
