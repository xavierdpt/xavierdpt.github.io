package xdtest.org.apache.cxf.binding;

import org.apache.cxf.Bus;
import org.apache.cxf.binding.AbstractBindingFactory;
import org.apache.cxf.binding.Binding;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.transport.Destination;
import org.junit.Test;

import java.util.Collection;

public class AbstractBindingFactoryTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        AbstractBindingFactory instance = new Dummy();
        ServiceInfo serviceInfo = null;
        String namespace = null;
        Object config = null;
        BindingInfo bindingInfo = instance.createBindingInfo(serviceInfo, namespace, config);
        Service service = null;
        BindingInfo bindingInfo1 = instance.createBindingInfo(service, namespace, config);
        Destination d = null;
        Endpoint e = null;
        instance.addListener(d, e);
        Bus bus = instance.getBus();
        instance.setBus(bus);
        Collection<String> activationNamespaces = instance.getActivationNamespaces();
        instance.setActivationNamespaces(activationNamespaces);
    }

    public static class Dummy extends AbstractBindingFactory {

        public Dummy() {
            super();
        }

        public Dummy(Collection<String> ns) {
            super(ns);
        }

        public Dummy(Bus b) {
            super(b);
        }

        public Dummy(Bus b, Collection<String> ns) {
            super(b, ns);
        }

        @Override
        public Binding createBinding(BindingInfo binding) {
            return null;
        }
    }

}
