package xdtest.org.apache.cxf.bus.extension;

import org.apache.cxf.bus.extension.Extension;
import org.apache.cxf.bus.extension.TextExtensionFragmentParser;
import org.junit.Test;
import xd.ExampleUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class TextExtensionFragmentParserTest {
    @Test
    public void test() throws IOException {
        if (ExampleUtils.skip()) {
            ClassLoader loader = null;
            TextExtensionFragmentParser instance = new TextExtensionFragmentParser(loader);
            URL url = null;
            List<Extension> extensions = instance.getExtensions(url);
            InputStream is = null;
            List<Extension> extensions1 = instance.getExtensions(is);
        }
    }
}
