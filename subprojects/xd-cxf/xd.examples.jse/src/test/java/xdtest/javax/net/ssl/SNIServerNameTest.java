package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.SNIServerName;

public class SNIServerNameTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            int type = 0;
            byte[] encoded = new byte[0];
            SNIServerName instance = new SNIServerName(type, encoded) {
            };
            int type1 = instance.getType();
            byte[] encoded1 = instance.getEncoded();
            String s = instance.toString();
        }
    }
}
