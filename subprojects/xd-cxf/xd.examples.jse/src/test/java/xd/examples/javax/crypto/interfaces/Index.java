package xd.examples.javax.crypto.interfaces;

import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.interfaces.PBEKey;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    DHKey.class,
                    DHPrivateKey.class,
                    DHPublicKey.class,
                    PBEKey.class
            ));
        }
    }
}
