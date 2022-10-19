package xdtest.org.apache.cxf.binding;

import org.apache.cxf.binding.Binding;
import org.apache.cxf.binding.BindingFactory;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.transport.Destination;
import org.junit.Test;

public class BindingFactoryTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        BindingFactory instance = BindingFactory.class.newInstance();
        BindingInfo binding = null;
        Binding binding1 = instance.createBinding(binding);
        Service service = null;
        String namespace = null;
        Object configObject = null;
        BindingInfo bindingInfo = instance.createBindingInfo(service, namespace, configObject);
        Destination d = null;
        Endpoint e = null;
        instance.addListener(d, e);
    }
}
