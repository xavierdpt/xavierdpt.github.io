package xd.examples.javax.xml.datatype;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    DatatypeConfigurationException.class,
                    DatatypeConstants.class,
                    DatatypeFactory.class,
                    Duration.class,
                    XMLGregorianCalendar.class
            ));
        }
    }

}
