package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.AttachmentSerializer;
import org.apache.cxf.message.Message;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AttachmentSerializerTest {
    @Test
    public void test() throws IOException {
        Message messageParam = null;
        AttachmentSerializer instance = new AttachmentSerializer(messageParam);
        String multipartType = null;
        boolean writeOptionalTypeParameters = false;
        Map<String, List<String>> headers = null;
        AttachmentSerializer attachmentSerializer = new AttachmentSerializer(messageParam, multipartType, writeOptionalTypeParameters, headers);
        instance.writeProlog();
        String cte = null;
        instance.setContentTransferEncoding(cte);
        instance.writeAttachments();
        boolean xop = instance.isXop();
        instance.setXop(xop);

    }
}
