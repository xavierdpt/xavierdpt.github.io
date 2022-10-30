package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.Policies;
import org.apache.cxf.annotations.Policy;

public class PoliciesTest {

    @Policies(value = {@Policy(uri = "hello")})
    public static class Dummy {
        @Policies(value = {@Policy(uri = "world")})
        public static void foo() {

        }
    }
}
