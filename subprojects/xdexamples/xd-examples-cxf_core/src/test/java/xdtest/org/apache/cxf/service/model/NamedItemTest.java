package xdtest.org.apache.cxf.service.model;

import org.apache.cxf.service.model.NamedItem;
import org.junit.Test;
import xdtest.TestUtils;

import javax.xml.namespace.QName;


public class NamedItemTest {

    @Test
    public void test() {
        NamedItem instance = new Dummy();

        // A named item has a name
        QName name = instance.getName();

        TestUtils.ignore(name);
    }

    public static class Dummy implements NamedItem {
        @Override
        public QName getName() {
            return null;
        }
    }
}
