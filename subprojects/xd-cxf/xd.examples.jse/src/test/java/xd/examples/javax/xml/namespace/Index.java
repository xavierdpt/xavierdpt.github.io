package xd.examples.javax.xml.namespace;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    NamespaceContext.class,
                    QName.class
            ));
        }
    }

}
