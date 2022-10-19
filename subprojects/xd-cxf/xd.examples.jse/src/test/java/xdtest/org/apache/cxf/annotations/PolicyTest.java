package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.Policy;
import org.junit.Test;

public class PolicyTest {

    @Test
    public void test() {
        Policy annotation = Dummy.class.getAnnotation(Policy.class);
        switch (annotation.placement()) {
            case DEFAULT:
                break;
            case PORT_TYPE:
                break;
            case PORT_TYPE_OPERATION:
                break;
            case PORT_TYPE_OPERATION_INPUT:
                break;
            case PORT_TYPE_OPERATION_OUTPUT:
                break;
            case PORT_TYPE_OPERATION_FAULT:
                break;
            case BINDING:
                break;
            case BINDING_OPERATION:
                break;
            case BINDING_OPERATION_INPUT:
                break;
            case BINDING_OPERATION_OUTPUT:
                break;
            case BINDING_OPERATION_FAULT:
                break;
            case SERVICE:
                break;
            case SERVICE_PORT:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + annotation.placement());
        }
    }

    @Policy(uri = "hello", includeInWSDL = false, placement = Policy.Placement.DEFAULT, faultClass = Policy.DEFAULT.class)
    public static class Dummy {
        @Policy(uri = "world", faultClass = MyFaultClass.class)
        public static void foo() {

        }
    }

    public static class MyFaultClass {

    }
}
