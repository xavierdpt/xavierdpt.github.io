package net.xdexamples.jse.examples.java.net;

import net.xdexamples.ExampleUtils;
import xdtest.Abstract;
import xdtest.ToBeContinued;

import java.net.SocketImpl;


@Abstract
@ToBeContinued
public class SocketImplExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            SocketImpl instance = ExampleUtils.makeInstance(SocketImpl.class);
            String s = instance.toString();
        }
    }

}
