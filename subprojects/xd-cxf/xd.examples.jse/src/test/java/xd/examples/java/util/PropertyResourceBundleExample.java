package xd.examples.java.util;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.io.InputStream;
import java.io.Reader;
import java.util.Enumeration;
import java.util.PropertyResourceBundle;

@Scaffolded
public class PropertyResourceBundleExample extends BaseExample<PropertyResourceBundle> {
    @Override
    public void scaffold(PropertyResourceBundle instance) throws Throwable {

        Reader reader = null;
        InputStream inputStream = null;
        ignore(
                new PropertyResourceBundle(reader),
                new PropertyResourceBundle(inputStream)
        );

        String key = null;
        Object o = instance.handleGetObject(key);
        Enumeration<String> keys = instance.getKeys();
    }
}
