package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.EndpointProperties;
import org.apache.cxf.annotations.EndpointProperty;

public class EndpointPropertiesTest {

    @EndpointProperties(value = {@EndpointProperty(key = "hello")})
    public static class Dummy {

    }


}
