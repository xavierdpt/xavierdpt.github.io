package xd.examples.java.io;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

@Scaffolded
public class BufferedWriterExample extends BaseExample<BufferedWriter> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(BufferedWriter instance) throws IOException {
        {
            Writer writer = any();
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
        }
        {
            Writer writer = any();
            int size = 0;
            BufferedWriter bufferedWriter = new BufferedWriter(writer, size);
        }
        {
            instance.close();
        }
        {
            instance.flush();
        }
        {
            instance.newLine();
        }
        {
            int c = 0;
            instance.write(c);
        }
        {
            char[] chars = new char[0];
            int offset = 0;
            int length = 0;
            instance.write(chars, offset, length);
        }
        {
            String string = any();
            int offset = 0;
            int length = 0;
            instance.write(string, offset, length);
        }
    }

}
