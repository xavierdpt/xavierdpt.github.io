package xd.examples.java.rmi;

import xd.ExampleUtils;
import xdtest.Scaffolded;

import java.rmi.Remote;

@Scaffolded
public class RemoteExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            Remote instance = ExampleUtils.makeInstance(Remote.class);
        }
    }

}
