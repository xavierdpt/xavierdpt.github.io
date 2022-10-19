package xdtest.org.apache.cxf.service.factory;

import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.apache.cxf.BusFactory;
import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;
import org.apache.cxf.binding.AbstractBindingFactory;
import org.apache.cxf.binding.Binding;
import org.apache.cxf.binding.BindingFactory;
import org.apache.cxf.bus.extension.ExtensionManager;
import org.apache.cxf.bus.extension.ExtensionManagerImpl;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.EndpointException;
import org.apache.cxf.endpoint.EndpointImpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.endpoint.ServerImpl;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.ServiceImpl;
import org.apache.cxf.service.factory.AbstractServiceFactoryBean;
import org.apache.cxf.service.factory.AnnotationsFactoryBeanListener;
import org.apache.cxf.service.factory.FactoryBeanListener;
import org.apache.cxf.service.factory.FactoryBeanListenerManager;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.transport.Destination;
import org.apache.cxf.transport.DestinationFactory;
import org.junit.Before;
import org.junit.Test;
import xdtest.TestUtils;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class AnnotationsFactoryBeanListenerTest {

    public static final String NS = "ns";
    private final AbstractServiceFactoryBean serviceFactoryBean = new DummyServiceFactoryBean();
    private final Bus bus = BusFactory.getDefaultBus();
    private AnnotationsFactoryBeanListener instance;

    @Before
    public void before() {
        ExtensionManager extensionManager = bus.getExtension(ExtensionManager.class);
        ExtensionManagerImpl extensionManagerImpl = (ExtensionManagerImpl) extensionManager;
        Collection<? extends FactoryBeanListenerManager> beans = extensionManagerImpl.getBeansOfType(FactoryBeanListenerManager.class);
        FactoryBeanListenerManager factoryBeanListenerManager = beans.iterator().next();
        List<FactoryBeanListener> listeners = factoryBeanListenerManager.getListeners();
        instance = TestUtils.getObjectOfType(listeners, AnnotationsFactoryBeanListener.class);
    }

    @Test
    public void testInterfaceCreated() {
        ServiceInfo serviceInfo = new ServiceInfo();
        QName qName = new QName(NS, "interfaceInfo");
        InterfaceInfo interfaceInfo = new InterfaceInfo(serviceInfo, qName);
        instance.handleEvent(FactoryBeanListener.Event.INTERFACE_CREATED, serviceFactoryBean, interfaceInfo, Dummy.class);
        String xxx = interfaceInfo.getDocumentation();
        String yyy = interfaceInfo.getService().getDocumentation();
        String zzz = interfaceInfo.getService().getTopLevelDoc();
        DataBinding uuu = serviceFactoryBean.getDataBinding();
    }

    public void testEndpointSelected() throws EndpointException {
        QName qName = new QName(NS, "interfaceInfo");
        Service service = new ServiceImpl();
        Endpoint endpoint = new EndpointImpl(bus, service, qName);
        instance.handleEvent(FactoryBeanListener.Event.ENDPOINT_SELECTED, serviceFactoryBean, null, endpoint, Dummy.class, Dummy.class);
    }

    public void testServerCreated() throws EndpointException, IOException, BusException {
        QName qName = new QName(NS, "interfaceInfo");

        Service service = new ServiceImpl();
        Endpoint endpoint = new EndpointImpl(bus, service, qName);

        DestinationFactory destinationFactory = new DummyDestinationFactory();
        BindingFactory bindingFactory = new DummyBindingFactory();
        Server server = new ServerImpl(bus, endpoint, destinationFactory, bindingFactory);
        instance.handleEvent(FactoryBeanListener.Event.SERVER_CREATED, serviceFactoryBean, server, null, Dummy.class);

    }

    public void testInterfaceOperationBound() throws NoSuchMethodException {
        OperationInfo operationInfo = new OperationInfo();
        instance.handleEvent(FactoryBeanListener.Event.INTERFACE_OPERATION_BOUND, serviceFactoryBean, operationInfo, Dummy.class.getMethod("foo"));
    }

    public static class DummyServiceFactoryBean extends AbstractServiceFactoryBean {
        @Override
        public Service create() {
            return new ServiceImpl();
        }
    }

    @WSDLDocumentationCollection({
            @WSDLDocumentation(value = "a", placement = WSDLDocumentation.Placement.PORT_TYPE),
            @WSDLDocumentation(value = "b", placement = WSDLDocumentation.Placement.SERVICE),
            @WSDLDocumentation(value = "c", placement = WSDLDocumentation.Placement.TOP),
            @WSDLDocumentation(value = "d", placement = WSDLDocumentation.Placement.DEFAULT),
            @WSDLDocumentation(value = "e", placement = WSDLDocumentation.Placement.INPUT_MESSAGE)
    })
    public static class Dummy {
        public void foo() {

        }
    }

    public static class DummyDestinationFactory implements DestinationFactory {

        @Override
        public Destination getDestination(EndpointInfo ei, Bus bus) {
            return null;
        }

        @Override
        public Set<String> getUriPrefixes() {
            return null;
        }

        @Override
        public List<String> getTransportIds() {
            return null;
        }
    }

    public static class DummyBindingFactory extends AbstractBindingFactory {

        @Override
        public Binding createBinding(BindingInfo binding) {
            return null;
        }
    }

}
