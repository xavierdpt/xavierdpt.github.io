package xdtest.javax.net.ssl;

import net.xdexamples.support.internal.BaseExample;

import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;

public class SNIHostNameTest extends BaseExample<SNIHostName> {

    @Override
    protected void scaffold(SNIHostName instance) throws Throwable {
        String hostname = null;
        SNIHostName instance2 = new SNIHostName(hostname);
        byte[] encoded = new byte[0];
        SNIHostName sniHostName = new SNIHostName(encoded);
        String asciiName = instance.getAsciiName();
        String s = instance.toString();
        String regex = null;
        SNIMatcher sniMatcher = SNIHostName.createSNIMatcher(regex);
    }
}
