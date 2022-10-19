package xd.examples.javax.xml.stream.util;

import javax.xml.stream.util.EventReaderDelegate;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.stream.util.XMLEventAllocator;
import javax.xml.stream.util.XMLEventConsumer;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    EventReaderDelegate.class,
                    StreamReaderDelegate.class,
                    XMLEventAllocator.class,
                    XMLEventConsumer.class
            ));
        }
    }

}
