package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Formatter;
import java.util.Locale;

@Scaffolded
public class FormatterExample extends BaseExample<Formatter> {
    @Override
    public void scaffold(Formatter instance) throws Throwable {

        Appendable appendable = null;
        Locale locale = null;
        String fileName = null;
        String csn = null;
        Charset charset = null;
        File file = null;
        PrintStream printStream = null;
        OutputStream outputStream = null;
        ignore(
                new Formatter(),
                new Formatter(appendable),
                new Formatter(locale),
                new Formatter(appendable, locale),
                new Formatter(fileName),
                new Formatter(fileName, csn),
                new Formatter(fileName, csn, locale),
                new Formatter(fileName, charset, locale),
                new Formatter(file),
                new Formatter(file, csn),
                new Formatter(file, csn, locale),
                new Formatter(file, charset, locale),
                new Formatter(printStream),
                new Formatter(outputStream),
                new Formatter(outputStream, csn),
                new Formatter(outputStream, csn, locale),
                new Formatter(outputStream, charset, locale)
        );

        instance.close();
        instance.flush();
        String str = null;
        Object[] args = new Object[0];
        Formatter format = instance.format(str, args);
        Formatter format1 = instance.format(locale, str, args);

        Locale locale1 = instance.locale();
        Appendable out = instance.out();
        String s = instance.toString();
    }
}
