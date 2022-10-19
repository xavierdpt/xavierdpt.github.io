package xd.examples.java.util;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.util.Enumeration;
import java.util.ListResourceBundle;

@Scaffolded
public class ListResourceBundleExample extends BaseExample<ListResourceBundle> {

    @Override
    public void scaffold(ListResourceBundle instance) throws Throwable {
        String key = null;
        Object o = instance.handleGetObject(key);
        Enumeration<String> keys = instance.getKeys();
    }

}
