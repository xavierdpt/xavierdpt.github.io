package net.xdexamples.jse.examples.java.io;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

@Scaffolded
public class PrintStreamExample extends BaseExample<PrintStream> {

    @Override
    public void scaffold(PrintStream instance) throws IOException {
        OutputStream outputStream = null;
        boolean autoFlush = false;
        String encoding = null;
        Charset charset = null;
        String fileName = null;
        String charsetName = null;
        File file = null;
        ignore(
                new PrintStream(outputStream),
                new PrintStream(outputStream, autoFlush),
                new PrintStream(outputStream, autoFlush, encoding),
                new PrintStream(outputStream, autoFlush, charset),
                new PrintStream(fileName),
                new PrintStream(fileName, charsetName),
                new PrintStream(fileName, charset),
                new PrintStream(file),
                new PrintStream(file, charsetName),
                new PrintStream(file, charset)
        );

        char ch = 0;
        CharSequence charSequence = null;
        int start = 0;
        int end = 0;
        String formatString = null;
        Object[] args = new Object[0];
        Locale locale = null;
        boolean aBoolean = false;
        int anInt = 0;
        long aLong = 0;
        float aFloat = 0;
        double aDouble = 0;
        char aChar = 0;
        String string = null;
        Object object = null;
        char[] chars = new char[0];
        byte[] bytes = new byte[0];
        int offset = 0;
        int length = 0;

        PrintStream append = instance.append(ch);
        PrintStream append1 = instance.append(charSequence);
        PrintStream append2 = instance.append(charSequence, start, end);
        Charset charset1 = instance.charset();
        boolean b = instance.checkError();
        instance.close();
        instance.flush();
        PrintStream format = instance.format(formatString, args);
        PrintStream format1 = instance.format(locale, formatString, args);

        instance.print(aBoolean);
        instance.print(anInt);
        instance.print(aLong);
        instance.print(aFloat);
        instance.print(aDouble);
        instance.print(aChar);
        instance.print(string);
        instance.print(object);
        instance.print(chars);

        PrintStream printf = instance.printf(formatString, args);
        PrintStream printf1 = instance.printf(locale, formatString, args);

        instance.println();
        instance.println(aBoolean);
        instance.println(anInt);
        instance.println(aLong);
        instance.println(aFloat);
        instance.println(aDouble);
        instance.println(aChar);
        instance.println(chars);
        instance.println(string);
        instance.println(object);
        instance.write(anInt);
        instance.write(bytes);
        instance.write(bytes, offset, length);
        instance.writeBytes(bytes);
    }

}
