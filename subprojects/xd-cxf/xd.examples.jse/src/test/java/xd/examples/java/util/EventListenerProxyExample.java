package xd.examples.java.util;

import xd.BaseExample;
import xd.helpers.dummies.DummyEventListener;
import xdtest.Scaffolded;

import java.util.EventListenerProxy;

@Scaffolded
public class EventListenerProxyExample extends BaseExample<EventListenerProxy<DummyEventListener>> {
    @Override
    public void scaffold(EventListenerProxy<DummyEventListener> instance) throws Throwable {
        DummyEventListener listener = instance.getListener();
    }
}
