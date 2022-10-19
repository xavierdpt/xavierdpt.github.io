package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.AttachmentDataSource;
import org.apache.cxf.message.Message;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AttachmentDataSourceTest {

    @Test
    public void test() throws IOException {
        String ctParam = null;
        InputStream inParam = null;
        AttachmentDataSource instance = new AttachmentDataSource(ctParam, inParam);
        boolean cached = instance.isCached();
        Message message = null;
        instance.cache(message);
        instance.hold(message);
        instance.release();
        String contentType = instance.getContentType();
        InputStream inputStream = instance.getInputStream();
        String name = instance.getName();
        instance.setName(name);
        OutputStream outputStream = instance.getOutputStream();

    }
}
