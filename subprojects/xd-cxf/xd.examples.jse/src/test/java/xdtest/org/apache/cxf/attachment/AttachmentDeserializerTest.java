package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.AttachmentDeserializer;
import org.apache.cxf.attachment.AttachmentImpl;
import org.apache.cxf.attachment.DelegatingInputStream;
import org.apache.cxf.message.Message;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class AttachmentDeserializerTest {
    @Test
    public void test() throws IOException {
        String attachmentPartHeaders = AttachmentDeserializer.ATTACHMENT_PART_HEADERS;
        String attachmentDirectory = AttachmentDeserializer.ATTACHMENT_DIRECTORY;
        String attachmentMemoryThreshold = AttachmentDeserializer.ATTACHMENT_MEMORY_THRESHOLD;
        String attachmentMaxSize = AttachmentDeserializer.ATTACHMENT_MAX_SIZE;
        String attachmentMaxCount = AttachmentDeserializer.ATTACHMENT_MAX_COUNT;
        String attachmentMaxHeaderSize = AttachmentDeserializer.ATTACHMENT_MAX_HEADER_SIZE;
        int defaultMaxHeaderSize = AttachmentDeserializer.DEFAULT_MAX_HEADER_SIZE;
        int threshold = AttachmentDeserializer.THRESHOLD;
        Message message = null;
        AttachmentDeserializer instance = new AttachmentDeserializer(message);
        List<String> supportedTypes = null;
        AttachmentDeserializer attachmentDeserializer1 = new AttachmentDeserializer(message, supportedTypes);
        instance.initializeAttachments();
        AttachmentImpl attachment = instance.readNext();
        boolean lazyLoading = instance.isLazyLoading();
        instance.setLazyLoading(lazyLoading);
        DelegatingInputStream delegatingInputStream = null;
        instance.markClosed(delegatingInputStream);
        instance.hasNext();


    }
}
