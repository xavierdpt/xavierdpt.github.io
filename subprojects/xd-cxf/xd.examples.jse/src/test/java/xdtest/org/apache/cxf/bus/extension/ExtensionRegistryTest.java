package xdtest.org.apache.cxf.bus.extension;

import org.apache.cxf.bus.extension.Extension;
import org.apache.cxf.bus.extension.ExtensionRegistry;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ExtensionRegistryTest {
    @Test
    public void test(){
        Map<String, Extension> registeredExtensions = ExtensionRegistry.getRegisteredExtensions();
        List<? extends Extension> list = null;
        ExtensionRegistry.removeExtensions(list);
        ExtensionRegistry.addExtensions(list);
    }
}
