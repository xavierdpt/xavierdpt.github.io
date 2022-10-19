package xd.examples.javax.net;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    ServerSocketFactory.class,
                    SocketFactory.class
            ));
        }
    }
}
