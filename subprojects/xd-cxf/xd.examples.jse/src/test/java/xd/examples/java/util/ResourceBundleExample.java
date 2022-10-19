package xd.examples.java.util;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

@Scaffolded
public class ResourceBundleExample extends BaseExample<ResourceBundle> {
    @Override
    public void scaffold(ResourceBundle instance) {
        String key = null;
        String baseName = null;
        ClassLoader classLoader = null;
        ResourceBundle.Control control = null;
        Locale locale = null;
        Module module = null;

        ResourceBundle.clearCache();
        ResourceBundle.clearCache(classLoader);

        boolean b = instance.containsKey(key);

        String baseBundleName = instance.getBaseBundleName();

        ResourceBundle bundle = ResourceBundle.getBundle(baseName);
        ResourceBundle bundle1 = ResourceBundle.getBundle(baseName, control);
        ResourceBundle bundle2 = ResourceBundle.getBundle(baseName, locale);
        ResourceBundle bundle3 = ResourceBundle.getBundle(baseName, module);
        ResourceBundle bundle4 = ResourceBundle.getBundle(baseName, locale, module);
        ResourceBundle bundle5 = ResourceBundle.getBundle(baseName, locale, control);
        ResourceBundle bundle6 = ResourceBundle.getBundle(baseName, locale, classLoader);
        ResourceBundle bundle7 = ResourceBundle.getBundle(baseName, locale, classLoader, control);

        Enumeration<String> keys = instance.getKeys();

        Locale locale1 = instance.getLocale();

        Object object = instance.getObject(key);

        String string = instance.getString(key);

        String[] stringArray = instance.getStringArray(key);

        Set<String> strings = instance.keySet();

    }
}
