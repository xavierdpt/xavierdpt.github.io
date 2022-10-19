package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.AttachmentDeserializer;
import org.apache.cxf.attachment.LazyAttachmentCollection;
import org.apache.cxf.message.Attachment;
import org.junit.Test;

import javax.activation.DataHandler;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LazyAttachmentCollectionTest
{
    @Test
    public void test() throws IOException {
        AttachmentDeserializer deserializer = null;
        int maxAttachmentCount = 0;
        LazyAttachmentCollection instance = new LazyAttachmentCollection(deserializer, maxAttachmentCount);
        List<Attachment> loadedAttachments = instance.getLoadedAttachments();
        boolean shouldLoadNew = false;
        boolean b = instance.hasNext(shouldLoadNew);
        boolean b1 = instance.hasNext();
        Iterator<Attachment> iterator = instance.iterator();
        int size = instance.size();
        Attachment arg0 = null;
        boolean add = instance.add(arg0);
        Collection<? extends Attachment> aa = null;
        boolean b2 = instance.addAll(aa);
        instance.clear();
        Object ab = null;
        boolean contains = instance.contains(ab);
        Collection<?> ac = null;
        boolean b3 = instance.containsAll(ac);
        boolean empty = instance.isEmpty();
        Object ad = null;
        boolean remove = instance.remove(ad);
        Collection<?> ae = null;
        boolean b4 = instance.removeAll(ae);
        Collection<?> af = null;
        boolean b5 = instance.retainAll(af);
        Object[] objects = instance.toArray();
        Dummy[] dummies = instance.toArray(new Dummy[]{});
        Map<String, DataHandler> dataHandlerMap = instance.createDataHandlerMap();


    }

    public static class Dummy {

    }
}
