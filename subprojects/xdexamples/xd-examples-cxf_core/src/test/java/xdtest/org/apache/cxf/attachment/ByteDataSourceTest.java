package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.ByteDataSource;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteDataSourceTest {
    @Test
    public void test() throws IOException {
        byte[] dataParam = new byte[0];
        ByteDataSource instance = new ByteDataSource(dataParam);
        String ct = null;
        ByteDataSource byteDataSource = new ByteDataSource(dataParam, ct);
        int offsetParam = 0;
        int lengthParam = 0;
        ByteDataSource byteDataSource1 = new ByteDataSource(dataParam, offsetParam, lengthParam);
        byte[] data = instance.getData();
        instance.setData(dataParam);
        String contentTypeParam = null;
        instance.setContentType(contentTypeParam);
        String nameParam = null;
        instance.setName(nameParam);
        String contentType = instance.getContentType();
        InputStream inputStream = instance.getInputStream();
        String name = instance.getName();
        OutputStream outputStream = instance.getOutputStream();
    }
}
