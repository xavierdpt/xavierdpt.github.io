package xdtest.org.apache.cxf.service.model;

import org.apache.cxf.service.model.DescriptionInfo;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.namespace.QName;

import static org.junit.Assert.assertNull;

public class DescriptionInfoTest {

    @Test
    public void test() {

        DescriptionInfo instance = new DescriptionInfo();
        assertNull(instance.getName());
        assertNull(instance.getBaseURI());

        QName qName = new QName("localPart");
        instance.setName(qName);
        Assert.assertEquals(qName, instance.getName());

        instance.setBaseURI("baseURI");
        Assert.assertEquals("baseURI", instance.getBaseURI());

        Assert.assertEquals(0, instance.getDescribed().size());

    }

}
