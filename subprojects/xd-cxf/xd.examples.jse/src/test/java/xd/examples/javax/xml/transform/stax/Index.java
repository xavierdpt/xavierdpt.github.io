package xd.examples.javax.xml.transform.stax;

import javax.xml.transform.stax.StAXResult;
import javax.xml.transform.stax.StAXSource;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    StAXResult.class,
                    StAXSource.class
            ));
        }
    }

}
