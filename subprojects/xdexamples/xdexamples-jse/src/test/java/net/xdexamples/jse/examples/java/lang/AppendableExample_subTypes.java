package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.OutputStreamWriter;
import java.io.PipedWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.CharBuffer;

import static java.util.Arrays.asList;

public class AppendableExample_subTypes {

    @Test
    public void example() {

        // Here we mention other types that implement the Appendable interface

        for (Class<? extends Appendable> clazz : asList(
                StringBuilder.class,
                StringBuffer.class,
                PrintStream.class,
                CharBuffer.class,
                Writer.class,
                OutputStreamWriter.class,
                FileWriter.class,
                PrintWriter.class,
                BufferedWriter.class,
                StringWriter.class,
                FilterWriter.class,
                CharArrayWriter.class,
                PipedWriter.class
        )) {
            Appendable.class.isAssignableFrom(clazz);
        }

    }

}
