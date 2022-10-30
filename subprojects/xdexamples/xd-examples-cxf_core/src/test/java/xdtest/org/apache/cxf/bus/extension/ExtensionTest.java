package xdtest.org.apache.cxf.bus.extension;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.extension.Extension;
import org.junit.Test;

import java.util.Collection;

public class ExtensionTest {
    @Test
    public void test() {
        Extension instance = new Extension();
        Class<?> cls = null;
        Class<?> inf = null;
        Extension extension = new Extension(cls, inf);
        Extension extension1 = new Extension(cls);
        ClassLoader loader = null;
        Extension extension2 = new Extension(loader);
        Extension ext = null;
        Extension extension3 = new Extension(ext);
        boolean b = false;
        instance.setOptional(b);
        String name = instance.getName();
        Object loadedObject = instance.getLoadedObject();
        Extension extension4 = instance.cloneNoObject();
        String s = instance.toString();
        String classname = instance.getClassname();
        String interfaceName = instance.getInterfaceName();
        String i = null;
        instance.setInterfaceName(i);
        boolean deferred = instance.isDeferred();
        instance.setDeferred(deferred);
        Collection<String> namespaces = instance.getNamespaces();
        Object[] a = new Object[0];
        instance.setArgs(a);
        ClassLoader cl = null;
        Class<?> classObject = instance.getClassObject(cl);
        Bus bus = null;
        Object load = instance.load(cl, bus);
        Class<?> aClass = instance.loadInterface(cl);
    }
}
