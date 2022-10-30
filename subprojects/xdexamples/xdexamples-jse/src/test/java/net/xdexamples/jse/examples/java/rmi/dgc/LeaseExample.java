package net.xdexamples.jse.examples.java.rmi.dgc;

import net.xdexamples.Scaffolded;
import net.xdexamples.ExampleUtils;

import java.rmi.dgc.Lease;
import java.rmi.dgc.VMID;

@Scaffolded
public class LeaseExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            Lease instance = ExampleUtils.makeInstance(Lease.class);

            VMID vmid = null;
            long duration = 0;

            ExampleUtils.ignore(
                    new Lease(vmid, duration)
            );

            VMID vmid1 = instance.getVMID();
            long value = instance.getValue();
        }
    }

}
