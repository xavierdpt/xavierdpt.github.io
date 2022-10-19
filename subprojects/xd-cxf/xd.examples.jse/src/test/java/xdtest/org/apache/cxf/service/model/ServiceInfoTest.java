package xdtest.org.apache.cxf.service.model;

import org.apache.cxf.common.xmlschema.SchemaCollection;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.DescriptionInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.SchemaInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.service.model.ServiceSchemaInfo;
import org.junit.Test;

import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ServiceInfoTest {

    public void scaffold() {
        ServiceInfo instance = new ServiceInfo();
        DescriptionInfo description = instance.getDescription();
        instance.setDescription(description);
        String topLevelDoc = instance.getTopLevelDoc();
        instance.setTopLevelDoc(topLevelDoc);
        String targetNamespace = instance.getTargetNamespace();
        instance.setTargetNamespace(targetNamespace);
        QName name = instance.getName();
        instance.setName(name);
        InterfaceInfo anInterface = instance.createInterface(name);
        instance.setInterface(anInterface);
        InterfaceInfo anInterface1 = instance.getInterface();
        BindingInfo binding = instance.getBinding(name);
        instance.addBinding(binding);
        EndpointInfo endpoint = instance.getEndpoint(name);
        instance.addEndpoint(endpoint);
        Collection<EndpointInfo> endpoints = instance.getEndpoints();
        Collection<BindingInfo> bindings = instance.getBindings();
        Map<QName, MessageInfo> messages = instance.getMessages();
        MessageInfo message = instance.getMessage(name);
        instance.setMessages(messages);
        instance.refresh();
        SchemaInfo schemaInfo = null;
        instance.addSchema(schemaInfo);
        String namespaceURI = null;
        instance.addNewSchema(namespaceURI);
        instance.getSchema(namespaceURI);
        List<SchemaInfo> schemas = instance.getSchemas();
        SchemaCollection xmlSchemaCollection = instance.getXmlSchemaCollection();
        ServiceSchemaInfo serviceSchemaInfo = null;
        instance.setServiceSchemaInfo(serviceSchemaInfo);
        instance.setSchemas(xmlSchemaCollection,schemas);



    }
}
