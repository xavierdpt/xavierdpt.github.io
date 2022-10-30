package net.xdexamples.jse.examples.java.rmi.dgc;

import net.xdexamples.ExampleUtils;
import net.xdexamples.support.internal.Scaffolded;

import java.rmi.RemoteException;
import java.rmi.dgc.DGC;
import java.rmi.dgc.Lease;
import java.rmi.dgc.VMID;
import java.rmi.server.ObjID;

@Scaffolded
public class DGCExample {

    public void scaffold() throws RemoteException {
        if (ExampleUtils.skip()) {
            DGC instance = ExampleUtils.makeInstance(DGC.class);

            ObjID[] ids = new ObjID[0];
            long sequenceNum = 0;
            Lease lease = null;
            Lease dirty = instance.dirty(ids, sequenceNum, lease);
            VMID vmid = null;
            boolean strong = false;
            instance.clean(ids, sequenceNum, vmid, strong);
        }
    }

}
