package net.xdexamples.jse.examples.java.util;

import net.xdexamples.Scaffolded;
import net.xdexamples.BaseExample;
import xd.helpers.dummies.DummyEventListener;

import java.util.EventListenerProxy;

@Scaffolded
public class EventListenerProxyExample extends BaseExample<EventListenerProxy<DummyEventListener>> {
    @Override
    public void scaffold(EventListenerProxy<DummyEventListener> instance) throws Throwable {
        DummyEventListener listener = instance.getListener();
    }
}
