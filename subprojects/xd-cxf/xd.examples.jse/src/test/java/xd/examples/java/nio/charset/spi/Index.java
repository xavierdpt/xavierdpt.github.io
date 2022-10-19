package xd.examples.java.nio.charset.spi;

import java.nio.charset.spi.CharsetProvider;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    CharsetProvider.class
            ));
        }
    }

}
