package xd.examples.java.net.spi;

import xd.ExampleUtils;
import xdtest.ToBeContinued;

import java.net.spi.URLStreamHandlerProvider;

@ToBeContinued
public class URLStreamHandlerProviderExample {
    public void scaffold() {
        if (ExampleUtils.skip()) {
            URLStreamHandlerProvider instance = ExampleUtils.makeInstance(URLStreamHandlerProvider.class);
            // only checks the "setFactory" permission
        }
    }

}
