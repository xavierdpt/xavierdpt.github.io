package xd.examples.javax.xml.transform.stream;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    StreamResult.class,
                    StreamSource.class
            ));
        }
    }

}
