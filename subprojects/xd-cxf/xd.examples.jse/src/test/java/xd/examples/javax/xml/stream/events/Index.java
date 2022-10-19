package xd.examples.javax.xml.stream.events;

import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.Comment;
import javax.xml.stream.events.DTD;
import javax.xml.stream.events.EndDocument;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.EntityDeclaration;
import javax.xml.stream.events.EntityReference;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.NotationDeclaration;
import javax.xml.stream.events.ProcessingInstruction;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    Attribute.class,
                    Characters.class,
                    Comment.class,
                    DTD.class,
                    EndDocument.class,
                    EndElement.class,
                    EntityDeclaration.class,
                    EntityReference.class,
                    Namespace.class,
                    NotationDeclaration.class,
                    ProcessingInstruction.class,
                    StartDocument.class,
                    StartElement.class,
                    XMLEvent.class
            ));
        }
    }

}
