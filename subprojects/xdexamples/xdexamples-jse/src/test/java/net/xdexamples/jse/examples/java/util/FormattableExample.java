package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.util.Formattable;
import java.util.Formatter;

@Scaffolded
public class FormattableExample extends BaseExample<Formattable> {
    @Override
    public void scaffold(Formattable instance) {
        Formatter formatter = null;
        int flags = 0;
        int width = 0;
        int precision = 0;
        instance.formatTo(formatter, flags, width, precision);
    }
}
