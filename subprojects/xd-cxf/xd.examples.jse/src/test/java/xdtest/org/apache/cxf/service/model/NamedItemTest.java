package xdtest.org.apache.cxf.service.model;

import net.xdexamples.Bundle;
import org.apache.cxf.service.model.NamedItem;
import org.junit.Test;
import net.xdexamples.Done;

import javax.xml.namespace.QName;

import static xdtest.TestUtils.ignore;

@Done
public class NamedItemTest {

    @Test
    public void test() {
        NamedItem instance = new Dummy();

        // A named item has a name
        QName name = instance.getName();

        ignore(name);
    }

    public static class Dummy implements NamedItem {
        @Override
        public QName getName() {
            return null;
        }
    }
}
