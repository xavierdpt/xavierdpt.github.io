package net.xdexamples.jse.examples.java.rmi.server;

import net.xdexamples.ExampleUtils;
import net.xdexamples.support.internal.Scaffolded;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.rmi.server.ObjID;

@Scaffolded
public class ObjIDExample {

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            ObjID instance = ExampleUtils.makeInstance(ObjID.class);

            int num = 0;
            ExampleUtils.ignore(
                    new ObjID(),
                    new ObjID(num)
            );

            ObjectOutput output = null;
            instance.write(output);

            ObjectInput input = null;
            ObjID read = ObjID.read(input);

            int i = instance.hashCode();
            ObjID other = null;
            boolean equals = instance.equals(other);

            String s = instance.toString();

            int registryId = ObjID.REGISTRY_ID;
            int activatorId = ObjID.ACTIVATOR_ID;
            int dgcId = ObjID.DGC_ID;

        }
    }
}
