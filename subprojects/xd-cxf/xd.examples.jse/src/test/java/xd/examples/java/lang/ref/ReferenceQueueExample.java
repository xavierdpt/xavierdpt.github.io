package xd.examples.java.lang.ref;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

@Scaffolded
public class ReferenceQueueExample extends BaseExample<ReferenceQueue<ReferenceQueueExample.Dummy>> {

    @Override
    public void scaffold(ReferenceQueue<Dummy> instance) throws Throwable {
        ignore(
                new ReferenceQueue<Dummy>()
        );
        Reference<? extends Dummy> poll = instance.poll();
        Reference<? extends Dummy> remove = instance.remove();
        long timeout = 0;
        Reference<? extends Dummy> remove1 = instance.remove(timeout);
    }

    public static class Dummy {
    }
}
