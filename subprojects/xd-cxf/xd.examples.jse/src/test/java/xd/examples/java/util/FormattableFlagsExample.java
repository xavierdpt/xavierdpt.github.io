package xd.examples.java.util;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.util.FormattableFlags;

@Scaffolded
public class FormattableFlagsExample extends BaseExample<FormattableFlags> {
    @Override
    public void scaffold(FormattableFlags instance) throws Throwable {
        int leftJustify = FormattableFlags.LEFT_JUSTIFY;
        int uppercase = FormattableFlags.UPPERCASE;
        int alternate = FormattableFlags.ALTERNATE;
    }
}
