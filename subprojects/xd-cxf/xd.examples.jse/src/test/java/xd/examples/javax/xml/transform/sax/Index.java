package xd.examples.javax.xml.transform.sax;

import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TemplatesHandler;
import javax.xml.transform.sax.TransformerHandler;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    SAXResult.class,
                    SAXSource.class,
                    SAXTransformerFactory.class,
                    TemplatesHandler.class,
                    TransformerHandler.class
            ));
        }
    }


}
