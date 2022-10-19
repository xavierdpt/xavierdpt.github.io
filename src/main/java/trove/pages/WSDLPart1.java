package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class WSDLPart1 extends Page {
    public WSDLPart1() {
        super("WSDLPart1", "WSDL Part 1");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.w3.org/TR/wsdl20/", "Web Services Description Language (WSDL) Version 2.0 Part 1: Core Language"));
        section("1. Introduction");
        section("1.1. Service Description");
        p("operation, message exchange pattern, interface, binding, endpoint, service");
        section("1.2. The Meaning of a Service Description");
        section("1.3. Document Conformance");
        p("element information item");
        p("namespace `\"http://www.w3.org/ns/wsdl\"`");
        p("XML element `description` in that namespace");
        p(externalLink("http://www.w3.org/2007/06/wsdl/wsdl20.xsd","WSDL XML Schema"));
        p("The root element of a WSDL 2.0 document is a `description` tag");
        p("component model");

        section("1.4. Notational Conventions");
        section("1.4.1. RFC 2119 Keywords");
        section("1.4.2. RFC 3986 Namespaces");
        section("1.4.3. XML Schema anyURI");

        p("`xs:anyURI` defines IRIs that are escaped according to XLink  with is almost identical to IRI escape rules defined in RFC 3987");
        p("Some of the characters allowed in `xs:anyURI` are not allowed by IRIs");

        section("1.4.4. Prefixes and Namespaces Used in this Specification");

        p("Namespace prefixes");
        p("`wsdl` : `\"http://www.w3.org/ns/wsdl\"`");
        p("`wsdli` : `\"http://www.w3.org/ns/wsdl-instance\"`");
        p("`wsdlx` : `\"http://www.w3.org/ns/wsdl-extensions\"`");
        p("`wrpc` : `\"http://www.w3.org/ns/wsdl/rpc\"`");
        p("`wsoap` : `\"http://www.w3.org/ns/wsdl/soap\"`");
        p("`whttp` : `\"http://www.w3.org/ns/wsdl/http\"`");
        p("`xs` : `\"http://www.w3.org/2001/XMLSchema\"`");
        p("`xsi` : `\"http://www.w3.org/2001/XMLSchema-instance\"`");

        section("1.4.5. Terms Used in This Specification");

        p("Actual value, inlined schema");

        section("1.4.6 XML Information Set Properties");

        p("Properties from the XML Information Set specification are referred to by square brackets.");

        section("1.4.7 WSDL 2.0 Component Model Properties");

        p("WSDL properties are referred to by curly brackets.");

        section("1.4.8 Z Notation");

        p("Fuzz 2000 type checker");

        p("Z notation is available in a non-normative version of the specification.");

        section("1.4.9 BNF Pseudo-Schemas");

        section("1.4.10 Assertions");

        section("2 Component Model");
        section("2.1 Description");
        section("2.1.1 The Description Component");
        p("WSDL Components and type system components");
        p("WSDL Components = interfaces, bindings and services");
        p("type system components = element declarations and type definitions");
        p("interface operations, endpoints");
        p(" type definitions are required, interfaces, bindings, services and element declarations are optional");
        p("Components can be defined in the WSDL document itself, in included documents or in imported namespaces");
        p("To use components from another namespace, `wsdl:import` must be used.");
        p("All QName references must resolve to components");

        section("2.1.2 XML Representation of Description Component");

        p("`wsdl:description` element");
        p("`targetNamespace` attribute");
        p("children: `documentation`, `import`, `include`, `types`, `interface`, `binding`, `service`");

        p("Two components of different kinds can have the same QName");

        p("WSDL documents can include elements and attributes from other namespaces at some designated points");

        section("2.1.2.1 `targetNamespace` attribute information item");

        p("`targetNamespace` is in the empty namespace");

        p("type `xs:anyURI` which must be an IRI");

        section("2.1.3 Mapping Description's XML Representation to Component Properties");

        p("interfaces: document's + imported + included");
        p("bindings: document's + imported + included");
        p("services: document's + imported + included");
        p("element declarations");
        p("type definitions: 19 primitive types + 25 derived types + any types defined in the document, imported or included");

        section("2.2 Interface");

        section("2.2.1 The Interface Component");

        p("operation = sequence of input and output messages");
        p("interface = set of operations");

        p("an interface can extend other interfaces");

        p("interface fault components");

        p("interfaces are referred to by QName");

        p("properties: name, extended interfaces interface faults, interface operations");

        section("2.2.2 XML Representation of Interface Component");

        p("`wsdl:interface`");
        p("attributes: name, extends, styleDefault");
        p("child elements: documentation, fault, operation");

        section("2.2.2.1 `name` attribute information item with interface [owner element]");

        p("QName of the interface = targetNamespace of the description + name of the interface");

        p("The `name` attribute is in no namespace");

        p("Note: attribute do not take the default namespace when a default namespace is declared.");

        section("2.2.2.2 `extends` attribute information item");

        p("Whitespace-separated list of `xs:QName`, no namespace.");
        p("List of the interfaces that this interface derives from.");
        p("Must not contain duplicates");

        section("2.2.2.3 `styleDefault` attribute information item");

        p("no namespace");
        p("Type `xs:anyURI`");
        p("If present, must contain absolute IRIs");
        p("Indicate the default style used to construct element declaration of interface message references");

        section("2.2.3 Mapping Interface's XML Representation to Component Properties");

        p("Name, extended interfaces, interface faults, interface operations");

        section("2.3 Interface Fault");

        section("2.3.1 The Interface Fault Component");

        p("Describes some possible application-specific faults, but not all faults.");
        p("Does not describe system faults.");

        p("Name, message content model (#any #none, #other, #element), element declaration, parent.");

        p("Faults in the same interface cannot have the same name, but faults in different interfaces can have the same name.");
        p("Since the interfaces can be in the same namespaces, faults cannot be identified by name or qualified name.");

        p("If two faults with the same name are defined on different interfaces within a derivatin chain, they must have the same properties.");

        p("Not WSDL documents are usually serialized in XML, but can be serialized in other type systems.");

        section("2.3.2: XML Representation of Interface Fault Component");

        p("XML element `fault` within an `interface` element");
        p("Namespace: `wsdl`");
        p("`name` attribute");
        p("`element` attribute");
        p("Other attributes within other namespaces");
        p("`documentation` element child");
        p("Other elements within other namespaces");

        section("2.3.2.1 `name` attribute information item with `fault` owner element");

        p("Attribute name `name`, type `xs:NCName`, no namespace");

        section("2.3.2.2 `element` attribute information item with `fault` owner element");

        p("Attribute name `element`, no namespace, type `xs:QName` or `xs:token` with values `#any`, `#none`, `#other`.");

        section("2.3.3 Mapping Interface Fault's XML Representation to Component Properties");

        p("Name, message content model, element declaration, parent");

        p("Message content element is #element when the `element` attribute is the QName of an element");

        section("2.4 Interface Operation");

        section("2.4.1 The Interface Operation Component");

        p("WSDL Part 2 defines message exchange patterns.");

        p("Name, message exchange pattern, interface message references, interface fault references, style, parent");

        p("Interface operation names are not globally unique, and duplicates must be equivalent.");

        section("2.4.1.1. Message Exchange Pattern");

        p("Placeholder message");

        p("Fault propagation ruleset: fault-replaces-message, message-triggers-fault, no-faults.");

        p("Message exchange patterns are idenfied by IRIs");

        section("2.4.1.2 Operation Style");

        p("IRIs that identify operation styles.");

        p("See WSDL2 Part 2");

        section("2.4.2 XML Representation of Interface Operation Component");

        p("Element name `operation`, namespace `wsdl`, parent `interface`");

        p("Required `name` attribute");
        p("Optional `pattern` attribute");
        p("Optional `style` attribute");
        p("Optional `documentation` child elements");
        p("Optional `input` child elements");
        p("Optional `output` child elements");
        p("Optional `infault` child elements");
        p("Optional `outfault` child elements");
        p("Other elements from other namespaces");

        section("2.4.2.1 `name` attribute information item with `operation` owner element");

        p("Attribute name `name`, no namespace, type `xs:NCName`");

        section("2.4.2.2 `pattern` attribute information item with `operation` owner element");

        p("Attribute name `pattern`, no namespace, type `xs:anyURI`, must be an absolute IRI.");

        section("2.4.2.3 `style` attribute informatin item with `operation` owner element");

        p("Attribute name `style`, no namespace, type `xs:anyURI`, must be an absolute IRI.");

        section("2.4.3 Mapping Interface Operation's XML Representation to Component Properties");

        p("name, message exchange pattern, interface message references, interface fault references, style, parent");

        p("Default value for message exchange pattern: `http://www.w3.org/ns/wsd/in-out`");

        section("2.5 Interface Message Reference");

        section("2.5.1 The Interface Message Reference Component");

        p("message label, direction, message content model, element declaration, parent");

        p("The message label identifies the role that the message plays in the message exchange pattern.");
        p("The direction must be `in` or `out` and must match the direction defined in the message exchange pattern.");
        p("The message content model is `#any`, `#none`, `#other` or `#element`.");

        section("2.5.2 XML Representation of Interface Message Reference Component");

        p("Location: `description/interface/operation`");
        p("Element name: `input` or `output`");
        p("Namespace: `wsdl`");
        p("Attributes: `messageLabel`, `element`, others");
        p("Child elements: `documentation`, others");

        section("2.5.2.1 `messageLabel` attribute information item with `input` or `output` owner element");

        p("Attribute name `messageLabel`, type `xs:NCName`, no namespace");

        section("2.5.2.2 `element` attribute information item with `input` or `output` owner element");

        p("Attribute name `element`, no namespace, type `xs:QName` or `xs:token` with values `#any`, `#none`, `#other`");

        section("2.5.3 Mapping Interface Message Reference's XML Representation to Component Properties");

        p("Message exchange pattern: that of the interface.");
        p("Direction: `in` for `input` and `out` for `output`.");
        p("The message label is not required, if absent, it is inferred from the message pattern.");

        p("message label, direction, message content model, element declaration, parent");

        section("2.6 Interface Fault Reference");

        section("2.6.1 The Interface Fault Reference Component");

        p("fault-replaces-message: the fault replaces the message");

        p("messages-triggers-fault: the fault will travel in the opposite direction of the message");

        p("interface fault, message label, direction, parent");

        section("2.6.2 XML Representation of Interface Fault Reference");

        p("Parent element: `description/interface/operation`");
        p("Element names: `infault`, `outfault`");
        p("Namespace: `wsdl`");
        p("Attributes: `ref`, `messageLabel`, others");
        p("Child elements: `documentation`, others");

        section("2.6.2.1 `ref` attribute item with `infault`, or `outfault` owner element");

        p("Attribute name: `ref`, no namespace, type `xs:QName`");

        section("2.6.2.2 `messageLabel` attribute information item with `infault`, or `outfault` owner element");

        p("Attribute name: `messageLabel`, no namespace, type: `xs:NCName`");

        p("If the message exchange pattern has more than one fault in the specified direction, the `messageLabel` attribute must be present.");

        section("2.6.3 Mapping Interface Fault Reference's XML Representation to Component Properties");

        p("interface fault, message label, direction, parent");

        section("2.7 Binding");

        p("A binding component describes a concrete message format and transmission protocol");

        p("A given binding can be used for multiple interfaces");

        p("Bindings can be specified on a per-operation basis.");

        p("When the binding specifies operation-specific or fault-specific details, it must specify the interface containing the corresponding operations and faults.");

        p("Otherwise, bindings do not need to specify interfaces");

        p("WSDL 2 Part 2 defines bindings for SOAP 1.2 and HTTP.");

        p("name, interface, type, binding faults, binding operations");

        section("2.7.2 XML Representation of Binding Component");

        p("Element `binding`");
        p("Namespace `wsdl`");
        p("Attributes `name`, `interface`, `type`, others");
        p("Child elements: `documentation`, `fault`, `operation`, others");

        section("2.7.2.1 `name` attribute information item with `binding` owner element");

        p("Attribute name `name`, no namespace, type `xs:NCName`");

        section("2.7.2.2 `interface` attribute information item with `binding` owner element");

        p("Attribute name `interface`, no namespace, type `xs:QName`");

        section("2.7.2.3 `type` attribute information item with `binding` owner element");

        p("Attribute name `type`, no namespace, type `xs:anyURI`");

        section("2.7.2.4 Binding extension elements");

        p("...");

        section("2.7.3 Mapping Binding's XML Representation to Component Properties");

        p("name, interface, type, binding faults, binding operations");

        section("2.8 Binding Faults");

        section("2.8.1 The Binding Fault Component");

        p("interface fault, parent");

        section("2.8.2 XML Representation of Binding Fault Component");

        p("Parent element: `description/binding`");
        p("Element name `fault`");
        p("Namespace `wsdl`");
        p("Attributes: `ref`, others");
        p("Child elements: `documentation`, others");

        section("2.8.2.1 `ref` attribute information item with `fault` owner element");

        p("Attribute name `ref`, no namespace, type `xs:QName`");

        section("2.8.2.2 Binding Fault extension elements");

        section("...");

        section("2.8.3 Mapping Binding Fault's XML Representation to Component Properties");

        p("interface fault, parent");

        section("2.9 Binding Operation");

        section("2.9.1 The Binding Operation Component");

        p("interface operation, binding message reference, binding fault references, parent");

        section("2.9.2 XML Representation of Binding Operation Component");

        p("Parent element `description/binding`");
        p("Element name: `operation`");
        p("Namespace: `wsdl`");
        p("Attributes: `ref`, others");
        p("Child elements: `documentation`, `input`, `output`, `infault`, `outfault`, others");

        section("2.9.2.1 `ref` attribute information item with `operation` owner element");

        p("...");

        section("2.9.2.2 Binding Operation extension elements");

        p("...");

        section("2.9.3 Mapping Binding Operation's XML Representation to Component Properties");

        p("interface operation, binding message references, binding fault references, parent");

        section("2.10 Binding Message Reference");

        section("2.10.1 The Binding Message Reference Component");

        p("interface message reference, parent");

        section("2.10.2 XML Representation of Binding Message Reference Component");

        p("Parent element: `description/binding/operation`");
        p("Element names: `input`, `output`");
        p("Namespace: `wsdl`");
        p("Attributes: `messageLabel`, others");
        p("Child elements: `documentation`, others");

        section("2.10.2.1 `messageLabel` attribute information item with `input` or `output` owner element");

        p("...");

        section("2.10.2.2 Binding Message Reference extension elements");

        p("...");

        section("2.10.3 Mapping Binding Reference's XML Representation to Component Properties");

        p("interface message reference, parent");

        section("2.11 Binding Fault Reference");

        section("2.11.1 The Binding Fault Reference Component");

        section("2.11.2 XML Representation of Binding Fault Reference Component");

        section("2.11.2.1 `ref` attribute information item `infault` or `outfault` owner element");

        section("2.11.2.2 `messageLabel` attribute information item `infault` or `outfault` owner element");

        section("2.11.2.3 Binding Fault Reference extension elements");

        section("2.11.3 Mapping Binding Fault Reference's XML Representation to Component Properties");

        section("2.12 Service");

        section("2.12.1 The Service Component");

        p("name, interface, endpoints");

        section("2.12.2 XML Representation of Service Component");

        p("Element name: `service`");
        p("Namespace: `wsdl`");
        p("Attributes: `name`, `interface`, others");
        p("Child elements: `documentation`, `endpoint`, others");

        section("2.12.2.1 `name` attribute information item with `service` owner element");

        section("2.12.2.2 `interface` attribute information item with `service` owner element");

        section("2.12.3 Mapping Service's XML Representation to Component Properties");

        section("2.13 Endpoint");

        section("2.13.1 The Endpoint Component ");

        p("name, binding, address, parent");

        section("2.13.2 XML Representation of Endpoint Component");

        p("Parent element: `description/service`");
        p("Element name: `endpoint`");
        p("Namespace: `wsdl`");
        p("Attributes: name, binding, address");
        p("Child elements: documentation");


        section("2.13.2.1 `name` attribute information item with `endpoint` owner element");

        section("2.13.2.2 `binding` attribute information item with `endpoint` owner element");

        section("2.13.2.3 `address` attribute information item with `endpoint` owner element");

        section("2.13.2.3 Endpoint extension elements");

        section("2.13.3 Mapping Endpoint's XML Representation to Component Properties");


        section("2.14 XML Schema 1.0 Simple Types Used in the Component Model");

        section("2.15 Equivalence of Components");

        section("2.16 Symbol Spaces");

        section("2.17 QName resolution");

        section("2.18 Comparing URIs and IRIs");

        section("3. Types");

        section("3.1");
        section("3.1.1");
        section("3.1.1.1");
        section("3.1.1.2");
        section("3.1.2");
        section("3.1.3");
        section("3.2");
        section("3.3");
        section("3.3.1");
        section("3.3.2");
        section("3.3.3");
        section("3.3.4");
        section("4");
        section("4.1");
        section("4.1.1");
        section("4.2");
        section("4.2.1");
        section("4.2.2");
        section("4.3");
        section("5");
        section("6");
        section("6.1");
        section("6.1.1");
        section("6.1.2");
        section("6.2");
        section("6.3");
        section("7");
        section("7.1");
        section("8");
        section("8.1");
        section("9");
        section("10");
        section("10.1");
        section("10.2");




    }
}
