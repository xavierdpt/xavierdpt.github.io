package xd.examples.javax.security.auth.x500;

import javax.security.auth.x500.X500Principal;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    X500Principal.class
            ));
        }
    }

}
