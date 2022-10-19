package xd.examples.java.util;

import xd.BaseExample;
import xd.helpers.dummies.Dummy;
import xdtest.Scaffolded;

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
