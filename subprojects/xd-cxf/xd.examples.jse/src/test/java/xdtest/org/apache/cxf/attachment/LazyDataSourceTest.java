package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.LazyDataSource;
import org.apache.cxf.message.Attachment;
import org.junit.Test;

import javax.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

public class LazyDataSourceTest {
    @Test
    public void test() throws IOException {
        String id = null;
        Collection<Attachment> attachments = null;
        LazyDataSource instance = new LazyDataSource(id, attachments);
        String contentType = instance.getContentType();
        InputStream inputStream = instance.getInputStream();
        String name = instance.getName();
        OutputStream outputStream = instance.getOutputStream();
        DataSource dataSource = instance.getDataSource();
        instance.setDataSource(dataSource);
    }
}
