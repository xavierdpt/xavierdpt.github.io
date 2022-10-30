package net.xdexamples.jse.examples.java.io;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.io.IOException;
import java.io.Writer;

@Scaffolded
public class WriterExample extends BaseExample<Writer> {

    @Override
    public void scaffold(Writer instance) throws IOException {

        int c = 0;
        char[] chars = new char[0];
        int offset = 0;
        int length = 0;
        String string = null;
        char ch = 0;
        CharSequence charSequence = null;

        Writer writer = Writer.nullWriter();
        instance.write(c);
        instance.write(chars);
        instance.write(chars, offset, length);
        instance.write(string);
        instance.write(string, offset, length);
        Writer append2 = instance.append(ch);
        Writer append1 = instance.append(charSequence);
        Writer append = instance.append(charSequence, offset, length);
        instance.flush();
        instance.close();
    }

}
