package net.xdexamples.jse.examples.java.net;

import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.net.IDN;

@ToBeContinued
public class IDNExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            String input = "";
            int flag = 0;
            String s = IDN.toASCII(input, flag);
            String s1 = IDN.toASCII(input);
            String s2 = IDN.toUnicode(input, flag);
            String s3 = IDN.toUnicode(input);
            int allowUnassigned = IDN.ALLOW_UNASSIGNED;
            int useStd3AsciiRules = IDN.USE_STD3_ASCII_RULES;
        }
    }

    @Test
    public void example() {
        Assert.assertEquals("5$", IDN.toASCII("5$"));
        Assert.assertEquals("xn--5-xpn", IDN.toASCII("5€"));

    }
}
