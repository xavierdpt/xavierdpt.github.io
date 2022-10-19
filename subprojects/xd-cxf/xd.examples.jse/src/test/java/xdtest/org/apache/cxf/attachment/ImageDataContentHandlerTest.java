package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.ImageDataContentHandler;
import org.junit.Test;

import javax.activation.DataSource;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.OutputStream;

public class ImageDataContentHandlerTest {
    @Test
    public void test() throws IOException, UnsupportedFlavorException {
        ImageDataContentHandler instance = new ImageDataContentHandler();
        DataSource ds = null;
        Object content = instance.getContent(ds);
        DataFlavor df = null;
        Object transferData = instance.getTransferData(df, ds);
        DataFlavor[] transferDataFlavors = instance.getTransferDataFlavors();
        Object obj = null;
        String mimeType = null;
        OutputStream os = null;
        instance.writeTo(obj,mimeType,os);
    }
}
