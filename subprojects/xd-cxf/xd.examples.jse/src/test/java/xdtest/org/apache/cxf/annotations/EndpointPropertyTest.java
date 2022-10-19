package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.EndpointProperty;

public class EndpointPropertyTest {

    @EndpointProperty(value = {"hello", "world"}, key = "bar", ref = "baz", beanClass = Dummy.class)
    public static class Dummy {

    }
}
