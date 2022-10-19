package xdtest.org.apache.cxf;

import org.apache.cxf.Bus;
import org.apache.cxf.feature.Feature;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;

public class BusTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        Bus instance = Bus.class.newInstance();
        String defaultBusId = instance.DEFAULT_BUS_ID;
        Dummy extension = instance.getExtension(Dummy.class);
        instance.setExtension(new Dummy(), Dummy.class);
        String name = null;
        boolean b = instance.hasExtensionByName(name);
        String id = instance.getId();
        instance.setId(id);
        boolean wait = false;
        instance.shutdown(wait);
        String s = null;
        Object o = null;
        instance.setProperty(s, o);
        Object property = instance.getProperty(s);
        Map<String, Object> properties = null;
        instance.setProperties(properties);
        Map<String, Object> properties1 = instance.getProperties();
        Collection<Feature> features = instance.getFeatures();
        instance.setFeatures(features);
        Bus.BusState state = instance.getState();
    }

    public static class Dummy {
    }

}
