package xd.examples.java.net;

import xd.ExampleUtils;
import xdtest.Interface;
import xdtest.ToBeContinued;

import java.net.SocketImpl;
import java.net.SocketImplFactory;

@ToBeContinued
@Interface
public class SocketImplFactoryExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            SocketImplFactory instance = ExampleUtils.makeInstance(SocketImplFactory.class);
            SocketImpl socketImpl = instance.createSocketImpl();
        }
    }

}
