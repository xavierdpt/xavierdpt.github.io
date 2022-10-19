package xd.examples.javax.xml.parsers;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    DocumentBuilder.class,
                    DocumentBuilderFactory.class,
                    FactoryConfigurationError.class,
                    ParserConfigurationException.class,
                    SAXParser.class,
                    SAXParserFactory.class
            ));
        }
    }

}
