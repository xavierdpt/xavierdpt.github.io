package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;

@ToBeContinued
public class VoidExample {

    public void scaffold() throws ClassNotFoundException, IOException {
        if (ExampleUtils.skip()) {
            Void instance = ExampleUtils.makeInstance(Void.class);
            Class<Void> type = Void.TYPE;
        }
    }

}
