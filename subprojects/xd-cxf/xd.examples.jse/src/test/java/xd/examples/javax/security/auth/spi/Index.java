package xd.examples.javax.security.auth.spi;

import javax.security.auth.spi.LoginModule;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    LoginModule.class
            ));
        }
    }
}
