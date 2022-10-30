package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.AttachmentUtil;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Attachment;
import org.apache.cxf.message.Message;
import org.junit.Test;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AttachmentUtilTest {
    @Test
    public void test() throws IOException {
        String bodyAttachmentId = AttachmentUtil.BODY_ATTACHMENT_ID;
        CommandMap commandMap = AttachmentUtil.getCommandMap();
        Message message = null;
        boolean mtomEnabled = AttachmentUtil.isMtomEnabled(message);
        CachedOutputStream bos = null;
        AttachmentUtil.setStreamedAttachmentProperties(message,bos);
        String ns = null;
        String contentID = AttachmentUtil.createContentID(ns);
        String uniqueBoundaryValue = AttachmentUtil.getUniqueBoundaryValue();
        Collection<Attachment> attachments = null;
        Map<String, DataHandler> dhMap = AttachmentUtil.getDHMap(attachments);
        String id = null;
        AttachmentUtil.cleanContentId(id);
        InputStream stream = null;
        Map<String, List<String>> headers = null;
        Attachment attachment = AttachmentUtil.createAttachment(stream, headers);
        InputStream in = null;
        String encoding = null;
        InputStream decode = AttachmentUtil.decode(in, encoding);
        String contentType = null;
        List<String> types = null;
        boolean typeSupported = AttachmentUtil.isTypeSupported(contentType, types);
        boolean isXop = false;
        String mimeType = null;
        String elementNS = null;
        byte[] data = new byte[0];
        int offset = 0;
        int length = 0;
        int threshold = 0;
        Attachment mtomAttachment = AttachmentUtil.createMtomAttachment(isXop, mimeType, elementNS, data, offset, length, threshold);
        DataHandler handler = null;
        Attachment mtomAttachmentFromDH = AttachmentUtil.createMtomAttachmentFromDH(isXop, handler, elementNS, threshold);
        String contentId = null;
        Collection<Attachment> atts = null;
        DataSource attachmentDataSource = AttachmentUtil.getAttachmentDataSource(contentId, atts);

    }
}
