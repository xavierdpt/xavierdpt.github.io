package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;

import java.util.EventObject;

public class EventObjectExample extends BaseExample<EventObject> {

    @Override
    public void scaffold(EventObject instance) throws Throwable {
        Object source = null;
        ignore(
                new EventObject(source)
        );
        Object source1 = instance.getSource();
        String s = instance.toString();
    }
}
