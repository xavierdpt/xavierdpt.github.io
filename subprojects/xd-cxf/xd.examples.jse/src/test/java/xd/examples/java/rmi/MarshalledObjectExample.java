package xd.examples.java.rmi;

import xd.ExampleUtils;
import xdtest.Scaffolded;

import java.io.IOException;
import java.rmi.MarshalledObject;

@Scaffolded
public class MarshalledObjectExample {

    public void scaffold() throws IOException, ClassNotFoundException {
        if (ExampleUtils.skip()) {
            MarshalledObject<Dummy> instance = ExampleUtils.makeInstance(MarshalledObject.class);
            Dummy object = null;
            ExampleUtils.ignore(
                    new MarshalledObject<Dummy>(object)
            );
            Dummy dummy = instance.get();
            int i = instance.hashCode();
            MarshalledObject<Dummy> other = null;
            boolean equals = instance.equals(other);
        }
    }

    public static class Dummy {
    }

}
