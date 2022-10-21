package net.xdexamples.jse.examples.java.net;

import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.net.FileNameMap;

@ToBeContinued
public class FileNameMapExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            // it's an interface, implemented by sun.net.www.MimeTable
            // and something in URLConnection
            FileNameMap instance = ExampleUtils.makeInstance(FileNameMap.class);
            String fileName = null;
            instance.getContentTypeFor(fileName);

        }
    }
}
