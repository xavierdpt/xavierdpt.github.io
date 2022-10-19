package xd.examples.java.rmi.dgc;

import xd.ExampleUtils;
import xdtest.Scaffolded;

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
