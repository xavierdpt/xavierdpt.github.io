package xd.examples.javax.xml.stream;

import javax.xml.stream.EventFilter;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.Location;
import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    EventFilter.class,
                    FactoryConfigurationError.class,
                    Location.class,
                    StreamFilter.class,
                    XMLEventFactory.class,
                    XMLEventReader.class,
                    XMLEventWriter.class,
                    XMLInputFactory.class,
                    XMLOutputFactory.class,
                    XMLReporter.class,
                    XMLResolver.class,
                    XMLStreamConstants.class,
                    XMLStreamException.class,
                    XMLStreamReader.class,
                    XMLStreamWriter.class
            ));
        }
    }

}
