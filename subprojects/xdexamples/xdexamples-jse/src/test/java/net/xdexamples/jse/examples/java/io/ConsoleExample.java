package net.xdexamples.jse.examples.java.io;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.io.Console;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.Charset;

@Scaffolded
public class ConsoleExample extends BaseExample<Console> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(Console instance) throws Throwable {
        {
            // TODO charset
            Charset charset = instance.charset();
        }
        {
            // TODO flush
            instance.flush();
        }
        {
            // TODO format
            String format = any();
            Object[] args = new Object[0];
            Console console = instance.format(format, args);
        }
        {
            // TODO printf
            String format = any();
            Object[] args = new Object[0];
            Console console = instance.printf(format, args);
        }
        {
            // TODO reader
            Reader reader = instance.reader();
        }
        {
            // TODO readLine
            String line = instance.readLine();
        }
        {
            // TODO readLine
            String format = any();
            Object[] args = new Object[0];
            String line = instance.readLine(format, args);
        }
        {
            // TODO readPassword
            char[] password = instance.readPassword();
        }
        {
            // TODO readPassword
            String format = any();
            Object[] args = new Object[0];
            instance.readPassword(format, args);
        }
        {
            // TODO writer
            PrintWriter writer = instance.writer();
        }
    }
}
