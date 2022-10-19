package xd.examples.java.net;

import xd.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.net.DatagramSocketImpl;
import java.net.DatagramSocketImplFactory;
@ToBeContinued
public class DatagramSocketImplFactoryExample  {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            // it's an interface, but nothing implements it
            DatagramSocketImplFactory instance = ExampleUtils.makeInstance(DatagramSocketImplFactory.class);
            DatagramSocketImpl datagramSocketImpl = instance.createDatagramSocketImpl();
        }
    }
}
