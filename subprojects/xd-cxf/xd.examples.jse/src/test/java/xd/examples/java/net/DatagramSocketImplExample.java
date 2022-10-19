package xd.examples.java.net;

import xd.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.net.DatagramSocketImpl;

@ToBeContinued
public class DatagramSocketImplExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            DatagramSocketImpl instance = ExampleUtils.makeInstance(DatagramSocketImpl.class);
            // it's an abstract class, but nothing extends it
        }
    }
}
