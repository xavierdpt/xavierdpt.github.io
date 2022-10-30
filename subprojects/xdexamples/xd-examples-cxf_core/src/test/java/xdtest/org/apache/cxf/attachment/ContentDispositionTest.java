package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.ContentDisposition;
import org.junit.Test;

import java.util.Map;

public class ContentDispositionTest {
    @Test
    public void test() {
        String value = null;
        ContentDisposition instance = new ContentDisposition(value);
        String type = instance.getType();
        String filename = instance.getFilename();
        String name = null;
        String parameter = instance.getParameter(name);
        Map<String, String> parameters = instance.getParameters();
        String s = instance.toString();
    }
}
