package xdtest.org.apache.cxf.databinding.source.mime;

import org.apache.cxf.databinding.source.mime.CustomExtensionRegistry;
import org.junit.Test;
import xdtest.Done;
import xdtest.TestUtils;

@Done
public class CustomExtensionRegistryTest {
    @Test
    public void test() {
        // USe MimeSerializer to serialize MimeAttribute
        CustomExtensionRegistry instance = new CustomExtensionRegistry();
        TestUtils.ignore(instance);
    }
}
