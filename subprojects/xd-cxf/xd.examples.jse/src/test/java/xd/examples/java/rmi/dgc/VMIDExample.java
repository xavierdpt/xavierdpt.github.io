package xd.examples.java.rmi.dgc;

import xd.ExampleUtils;
import xdtest.Scaffolded;

import java.rmi.dgc.VMID;

@Scaffolded
public class VMIDExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            VMID instance = ExampleUtils.makeInstance(VMID.class);
            ExampleUtils.ignore(
                    new VMID()
            );
            int i = instance.hashCode();
            VMID other = null;
            boolean equals = instance.equals(other);
            String s = instance.toString();
        }
    }

}
