package xdtest.org.apache.cxf.binding;

import org.apache.cxf.binding.Binding;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.model.BindingInfo;
import org.junit.Test;

public class BindingTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        Binding instance = Binding.class.newInstance();
        Message message = instance.createMessage();
        Message m = null;
        Message message1 = instance.createMessage(m);
        BindingInfo bindingInfo = instance.getBindingInfo();
    }
}
