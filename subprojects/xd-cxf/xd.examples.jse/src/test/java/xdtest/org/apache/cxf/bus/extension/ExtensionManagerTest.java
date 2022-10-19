package xdtest.org.apache.cxf.bus.extension;

import org.apache.cxf.bus.extension.ExtensionManager;
import org.junit.Test;

public class ExtensionManagerTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        ExtensionManager instance = ExtensionManager.class.newInstance();
        instance.activateAll();
        Class<?> type = null;
        instance.activateAllByType(type);
        String ns = null;
        Object extension = instance.getExtension(ns, type);
    }
}
