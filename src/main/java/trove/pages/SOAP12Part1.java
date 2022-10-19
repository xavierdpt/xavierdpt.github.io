package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class SOAP12Part1 extends Page {

    public SOAP12Part1() {
        super("SOAP/SOAP12-part1", "SOAP 1.2 - Part 1", List.of(Languages.XML));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.w3.org/TR/soap12-part1/", "SOAP Version 1.2 Part 1: Messaging Framework (Second Edition)"));
        section("1");
        p("XMLP Requirements");
        p("MEP: Message Exchange Pattern");
        p("SOAP 1.2 defines things for two MEPs.");
        p("The SOAP 1.2 specification has three parts.");
        p("SOAP processing model");
        p("SOAP extensibility model: features and modules");
        p("SOAP protocol binding framework");
        p("SOAP Message Construct");
        p("TODO link: SOAP 1.2 Primer");
        section("1.1");
        p("Namespace prefix `env` for `\"http://www.w3.org/2003/05/soap-envelope\"`");
        p("Namespace prefix `xs` for `\"http://www.w3.org/2001/XMLSchema\"`");
        p("Schema for `env` at " + externalLink("https://www.w3.org/2003/05/soap-envelope/"));
        section("1.2");
        p("Omitted");
        section("1.3");
        p("XML, XML Schema, XML Namespaces, XML Base");
        p("XML Schema describes some attributes types which can have multiple lexical forms; for example, \"1\" and \"true\" means the same thing for booleans.");
        p("Media type: `application/soap+xml`");
        section("1.3.1");
        p("Omitted");
        section("1.4");
        p("Example SOAP message");
        code(Languages.XML, """
                <env:Envelope xmlns:env="http://www.w3.org/2003/05/soap-envelope">
                 <env:Header>
                  <n:alertcontrol xmlns:n="http://example.org/alertcontrol">
                   <n:priority>1</n:priority>
                   <n:expires>2001-06-22T14:00:00-05:00</n:expires>
                  </n:alertcontrol>
                 </env:Header>
                 <env:Body>
                  <m:alert xmlns:m="http://example.org/alert">
                   <m:msg>Pick up Mary at school at 2pm</m:msg>
                  </m:alert>
                 </env:Body>
                </env:Envelope>""");
        section("1.5");
        section("1.5.1");
        ul(List.of(
                "SOAP",
                "SOAP node",
                "SOAP role",
                "SOAP binding",
                "SOAP feature",
                "SOAP module",
                "SOAP Message Exchange Pattern (MEP)",
                "SOAP application"
        ));
        section("1.5.2");
        ul(List.of(
                "SOAP message",
                "SOAP envelope",
                "SOAP header",
                "SOAP header block",
                "SOAP body",
                "SOAP fault"
        ));
        section("1.5.3");
        ul(List.of(
                "SOAP sender",
                "SOAP receiver",
                "SOAP message path",
                "Initial SOAP sender",
                "SOAP intermediary",
                "Ultimate SOAP receiver"
        ));
        section("2");
        section("2.1");
        p("SOAP nodes are identified by URIs");
        section("2.2");
        p("A SOAP node can act in one or more roles, each roles is identified by an URI.");
        p("Role names with special signifiance: next, none, ultimateReceiver.");
        p("Full role names are prefixed with `http://www.w3.org/2003/05/soap-envelope/role/`");

        section("2.3");

        p("`role` attribute for header blocks.");

        section("2.4");

        p("`mustUnderstand` attribute on header blocks.");

        p("A node that doesn't understand a `mustUnderstand` header block must generate a fault when the header block is targetted at that node.");

        section("2.5");

        p("...");

        section("2.6");

        p("...");

        section("2.7");

        section("2.7.1");

        p("`relay` attribute");
        p("When a header block is understood, it may be forwarded according to semantics of that header block.");
        p("When a header block is not understood, it will be forwarded when the node is not targeted, or the node is targeted but does not understand it and `relay` is true.");


        section("2.7.2");
        section("2.7.2.1");

        p("Rules and provisions for REC-xml-c14n-20010315");

        section("2.7.3");

        p("Active intermediaries can transform the SOAP messages in arbitrary ways before forwarding them.");

        section("2.8");

        p("`Envelope` element in namespace `http://www.w3.org/2003/05/soap-envelope`");
        p("Faults `env:VersionMismatch` or `env:Sender`.");

        section("3");
        section("3.1");

        p("SOAP header blocks");
        p("Features are named with URIs");

        section("3.1.1");
        section("3.2");

        p("MEPs are named with URIs");
        p("MEPs are features");
        p("MEPs apply to features which involve multiple messages (request/response/causality)");

        p("Protocol binding specification can declare support for some MEPs");

        section("3.3");

        p("SOAP modules includes one or more features or MEPs");
        p("SOAP modules are identified by URIs");
        p("SOAP modules declare which features they use");


        // ------------------ STOPPED HERE

        section("4");

        p("HTTP binding in SOAP part 2");

        section("4.1");

        p("...");

        section("4.2");

        p("A binding must enable one or more MEPs");

        p("When bindings support multiple features, they must describe how these futures will be combined together");

        section("5");

        p("No DTD, no notations, no unparsed entities.");
        p("SOAP `Envelope` element");
        p("No processing information items, receivers should reply with a fault with code `env:Sender`");
        p("Only whitespace is allowed as character information item surrounding the element.");
        p("Comments are allowed, but not before or after the element information item.");

        section("5.1");

        p("`env:Envelope`");
        p("`env` = `\"http://www.w3.org/2003/05/soap-envelope\"`.");
        p("Namespace-qualified attributes are allowed.");
        p("Optional `Header` element information item.");
        p("Mandatory `Body` element information item.");

        /*
            <env:Envelope>
              ...
            </env:Envelope>
         */

        section("5.1.1");

        p("`env:encodingStyle` of type `xs:anyURI`");
        p("Allowed on header block and descendants, children of `Body` that are not SOAP Faults an descendants, children of SOAP Detail.");

        p("Default value when unspecified:");
        p("`\"http://www.w3.org/2003/05/soap-envelope/encoding/none\"`");

        section("5.2");

        p("`env:Header");
        p("Namespace-qualified attributes and child elements allowed");
        p("Children of env:Header are SOAP header blocks");

        section("5.2.1");

        p("SOAP header blocks must be namespace-qualified.");
        p("May contain character information item, in which whitespace is considered significant");
        p("Children elements do not need to be namespace-qualified.");
        p("Allowed SOAP-related attributes: `encodingStyle`, `role`, `mustUnderstand`, `relay`.");


        section("5.2.2");

        p("`env:role` attribute, of type `xs:anyURI`.");
        p("Default value when unspecified: `\"http://www.w3.org/2003/05/soap-envelope/role/ultimateReceiver\"`");

        section("5.2.3");

        p("`env:mustUnderstand` attribute of type `xs:boolean`");
        p("Default value when unspecified: `\"false\"`");
        p("SOAP intermediaries can convert \"0\" to \"false\", \"1\" to \"true\" and omit the attribute when its value is \"false\" or \"0\".");

        section("5.2.4");

        p("`env:relay` attribute of type `xs:boolean`");
        p("Default value when unspecified: \"false\".");

        section("5.3");

        p("`env:Body` element");
        p("Namespace-qualified attributes and elements allowed.");
        p("Body may characters, and if so these characters must be whitespace and are considered significant.");

        section("5.3.1");

        p("Child elements of `Body` should be namespace-qualified.");
        p("Child elements of `Body` may have characters, in which whitespace characters is considered significant");
        p("Child elements of `Body` may be qualified");
        p("Child elements of `Body` may have a `env:encodingStyle` attribute.");

        section("5.4");

        p("`env:Fault` element");
        p("Mandatory `Code` and `Reason` elements");
        p("Optional `Node`, `Role` and `Detail` elements.");

        p("A SOAP error message must have a single `Fault` element.");

        section("5.4.1");

        p("`env:Code` element");
        p("Mandatory `Value` element.");
        p("Optional `Subcode` element.");

        section("5.4.1.1");

        p("`env:Value` element child of `Code` of type `env:faultCodeEnum`");

        section("5.4.1.2");

        p("`env:Subcode` element");
        p("Mandatory `Value` element.");
        p("Optional `Subcode` element.");

        section("5.4.1.3");

        p("`env:Value` element child of `Subcode` of type `xs:QName`");

        section("5.4.2");

        p("`env:Reason`");
        p("Several `Text` elements with different `xml:lang` attributes.");
        p("Type of `Reason` is `env:faultReason`");

        section("5.4.2.1");

        p("`env:Text` element with mandatory `xml:lang` attribute and character content with significant whitespace.");

        p("Type of `Text` is `env:reasonText`");

        p("Similar to HTTP 1.1 `Reason-Phrase`");

        section("5.4.3");

        p("`env:Node` element of type `xs:anyURI`");
        p("Identifies the node that generated the fault.");
        p("Intermediaries must include this information when generating the fault, ultimate receivers need not include this information.");

        section("5.4.4");

        p("`env:Role` element of type `xs:anyURI`");

        section("5.4.5");

        p("`env:Detail` element.");
        p("May have whitespace characters, which are considered significant.");

        section("5.4.5.1");

        p("Children of `Detail` are cause Detail Entries and may be namespace-qualified");
        p("Detail entries can have characters or elements, and attributes.");
        p("`encodingStyle` is allowed.");

        section("5.4.6");

        p("SOAP Fault Codes are XML expanded names.");
        p("Values of `Value` for the `Code` element are restricted.");
        p("The interpretation of a `Detail` element is conditioned by the Code and the Subcodes.");
        ul(List.of(
                markdown("`VersionMismatch`"),
                markdown("`MustUnderstand`"),
                markdown("`DataEncodingUnknown`"),
                markdown("`Sender`"),
                markdown("`Receiver`")
        ));

        p("`Sender` fault code indicates that the message needs to be modified to succeed, `Receiver` fault code indicates that the message may succeed if sent again later");

        section("5.4.7");

        p("Messages with a `VersionMismatch` fault code should include a `Upgrade` SOAP header block which indicates the SOAP envelopes that the SOAP node supports.");

        section("5.4.7.1");

        p("`env:Upgrade` header block with `SupportedEnvelope` child elements.");
        p("`encodingStyle` not allowed on `Upgrade` header blocks.");

        section("5.4.7.2");

        p("`env:SupportedEnvelope` element with a `qname` attribute.");

        section("5.4.7.3");

        p("`qname` attribute with no namespace and of type `xs:QName`");
        p("Contains the XML qualified name of a SOAP Envelope element that the faulting node can understand.");
        p("The namespace is specified with a name introduced with `xmlns:` on the attribute, and the local name is `Envelope`");

        section("5.4.7.4");

        p("Example");

        section("5.4.8");

        p("Faults with code value `mustUnderstand` should include a `NotUnderstood` header block.");

        section("5.4.8.1");

        p("`env:NotUnderstood` header block element with `qname` attribute and `encodingStyle` attribute disallowed.");

        section("5.4.8.2");

        p("`qname` attribute of type `xs:QName` which contains the XML qualified name of a SOAP header block that was not understood.");

        section("5.4.8.3");

        p("Example.");
        p("The fault message may include multiple `NotUnderstood` header blocks.");

        section("6");

        p("IP addresses in URIs are discouraged but if IPv4 addresses are supported, IPv6 addresses should be supported too.");

        section("7");

        p("Security.");

        section("7.1");
        section("7.2");
        section("7.3");
        section("7.3.1");
        section("8");

        p("References");

        section("8.1");
        section("8.2");
        section("A");

        p("Transition from SOAP/1.1 to SOAP Version 1.2");
        p("SOAP/1.1 nodes receiving SOAP Version 1.2 messages will generate a version mismatch fault based on a SOAP/1.1 message construct.");
        p("A SOAP Version 1.2 node receiving a SOAP/1.1 message may generate a fault if choosing not to support SOAP/1.1");
        p("If so, they should generate a SOAP/1.1 fault so that the SOAP/1.1 sender can correctly interpret it.");

        section("B");

        p("Acknowledgments");

        p(externalLink("https://www.w3.org/TR/soap12-part2/", "SOAP Version 1.2 Part 2: Adjuncts (Second Edition)"));
        p(externalLink("https://www.w3.org/TR/soap12-part3/", "SOAP 1.2 Part 3: One-Way MEP"));
    }
}
