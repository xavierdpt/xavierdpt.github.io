package xdtest.javax.net.ssl;

import net.xdexamples.BaseExample;

import javax.net.ssl.SNIServerName;

public class SNIServerNameTest extends BaseExample<SNIServerName> {

    @Override
    protected void scaffold(SNIServerName instance) throws Throwable {
        int type = 0;
        byte[] encoded = new byte[0];
        SNIServerName instance2 = new SNIServerName(type, encoded) {
        };
        int type1 = instance.getType();
        byte[] encoded1 = instance.getEncoded();
        String s = instance.toString();
    }
}
