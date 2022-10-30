package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.AttachmentImpl;
import org.junit.Test;

import javax.activation.DataHandler;
import java.util.Iterator;

public class AttachmentImplTest {
    @Test
    public void test() {
        String idParam = null;
        AttachmentImpl instance = new AttachmentImpl(idParam);
        DataHandler handlerParam = null;
        AttachmentImpl attachment = new AttachmentImpl(idParam, handlerParam);
        String id = instance.getId();
        DataHandler dataHandler = instance.getDataHandler();
        instance.setDataHandler(dataHandler);
        String name = null;
        String value = null;
        instance.setHeader(name, value);
        String header = instance.getHeader(name);
        Iterator<String> headerNames = instance.getHeaderNames();
        boolean xop = instance.isXOP();
        instance.setXOP(xop);
    }
}
