package xd.examples.javax.xml.transform.dom;

import javax.xml.transform.dom.DOMLocator;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    DOMLocator.class,
                    DOMResult.class,
                    DOMSource.class
            ));
        }
    }


}
