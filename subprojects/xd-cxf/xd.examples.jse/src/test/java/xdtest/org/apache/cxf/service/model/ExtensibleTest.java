package xdtest.org.apache.cxf.service.model;

import org.apache.cxf.service.model.Extensible;
import org.junit.Test;
import net.xdexamples.Done;

import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static xdtest.TestUtils.ignore;

@Done
public class ExtensibleTest {

    @Test
    public void test() {
        Extensible instance = new DummyExtensible();

        // An extensible can have multiple extensors of the same type
        List<DummyExtensor> extensors = instance.getExtensors(DummyExtensor.class);

        // Or it can have only one ?
        DummyExtensor extensor = instance.getExtensor(DummyExtensor.class);

        // It's possible to add extensors
        instance.addExtensor(new DummyExtensor());


        // It's possible to add extension attributes
        QName name = new QName("localPart");
        Object attribute = new Object();
        instance.addExtensionAttribute(name, attribute);

        // Or to set all extension attributes at once
        Map<QName, Object> attributes = new HashMap<>();
        instance.setExtensionAttributes(attributes);

        // It's possible to get an extension attribute
        instance.getExtensionAttribute(name);

        // Or to get all attributes
        attributes = instance.getExtensionAttributes();


        ignore(extensors, extensor, attributes);
    }
    public static class DummyExtensor {
    }

    public static class DummyExtensible implements Extensible {

        @Override
        public <T> T getExtensor(Class<T> cls) {
            return null;
        }

        @Override
        public <T> List<T> getExtensors(Class<T> cls) {
            return null;
        }

        @Override
        public void addExtensor(Object el) {

        }

        @Override
        public Object getExtensionAttribute(QName name) {
            return null;
        }

        @Override
        public Map<QName, Object> getExtensionAttributes() {
            return null;
        }

        @Override
        public void addExtensionAttribute(QName name, Object attr) {

        }

        @Override
        public void setExtensionAttributes(Map<QName, Object> attrs) {

        }
    }
}
