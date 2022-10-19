package xd.examples.java.net;

import xd.ExampleUtils;
import xdtest.Enum;
import xdtest.Interface;
import xdtest.ToBeContinued;

import java.net.SocketException;
import java.net.StandardProtocolFamily;


@Enum
@ToBeContinued
public class StandardProtocolFamilyExample {

    public void scaffold() throws SocketException {
        if (ExampleUtils.skip()) {
            StandardProtocolFamily inet = StandardProtocolFamily.INET;
            StandardProtocolFamily inet6 = StandardProtocolFamily.INET6;
            StandardProtocolFamily unix = StandardProtocolFamily.UNIX;
        }
    }

}
