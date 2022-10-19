package xdtest.java.security;

import org.junit.Test;
import xdtest.TestUtils;

import java.security.AlgorithmConstraints;
import java.security.AlgorithmParameters;
import java.security.CryptoPrimitive;
import java.security.Key;
import java.util.Set;

public class AlgorithmConstraintsTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            AlgorithmConstraints instance = TestUtils.makeInstance(AlgorithmConstraints.class);
            Set<CryptoPrimitive> primitives = null;
            String algorithm = null;
            Key key = null;
            AlgorithmParameters parameters = null;
            boolean permits = instance.permits(primitives, algorithm, key, parameters);
            boolean permits1 = instance.permits(primitives, algorithm, parameters);
            boolean permits2 = instance.permits(primitives, key);

        }
    }
}
