package net.xdexamples.jse.examples.java.rmi.server;

import net.xdexamples.ExampleUtils;
import net.xdexamples.support.internal.Scaffolded;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.rmi.server.UID;

@Scaffolded
public class UIDExample {

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {

            UID instance = ExampleUtils.makeInstance(UID.class);

            short num = 0;
            ExampleUtils.ignore(
                    new UID(),
                    new UID(num)
            );

            int i = instance.hashCode();
            UID other = null;
            boolean equals = instance.equals(other);
            String s = instance.toString();
            DataOutput output = null;
            instance.write(output);
            DataInput input = null;
            UID read = UID.read(input);
        }
    }

}
