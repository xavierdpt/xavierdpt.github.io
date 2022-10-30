package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.support.internal.Scaffolded;

import java.util.Queue;

@Scaffolded
public class QueueExample extends BaseExample<Queue<Dummy>> {

    @Override
    public void scaffold(Queue<Dummy> instance) throws Throwable {

        Dummy value = null;

        boolean add = instance.add(value);
        Dummy element = instance.element();
        boolean offer = instance.offer(value);
        Dummy peek = instance.peek();
        Dummy poll = instance.poll();
        Dummy remove = instance.remove();
    }

}
