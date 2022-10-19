package xdtest.org.apache.cxf.service.model;

import org.apache.cxf.service.model.AbstractDescriptionElement;
import org.apache.cxf.service.model.DescriptionInfo;
import org.junit.Assert;

public class AbstractDescriptionElementTest {
    public void scaffold() {
        AbstractDescriptionElement x = new AbstractDescriptionElement() {
            @Override
            public DescriptionInfo getDescription() {
                return null;
            }
        };
        Assert.assertNull(x.getDescription());
    }
}
