package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.support.internal.Scaffolded;

import java.util.Enumeration;
import java.util.Iterator;

@Scaffolded
public class EnumerationExample extends BaseExample<Enumeration<Dummy>> {

    @Override
    public void scaffold(Enumeration<Dummy> instance) throws Throwable {

        boolean b = instance.hasMoreElements();

        Dummy dummy = instance.nextElement();

        Iterator<Dummy> dummyIterator = instance.asIterator();
    }

}
