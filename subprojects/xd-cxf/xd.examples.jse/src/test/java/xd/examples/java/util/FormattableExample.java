package xd.examples.java.util;

import xd.BaseExample;
import xdtest.Scaffolded;

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
